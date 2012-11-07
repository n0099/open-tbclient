package cn.jingling.lib.file;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.StatFs;
import android.provider.MediaStore;
import cn.jingling.lib.utils.LogUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes.dex */
public class ImageFile {
    public static final int FILE_NOT_EXSIT = -2;
    public static final int FILE_PATH_NOT_EXIST = -4;
    private static final int INDEX_ORIENTATION = 3;
    private static final int JPEG_QUALITY = 80;
    private static final int MAX_CONCURRENT_THREAD_NUM = 1;
    public static final long MIN_SD_CARD_SPACE = 5242880;
    public static final int ORIGINAL_SIZE = 9999;
    public static final int OTHER_ERROR = -1;
    public static final int OUT_OF_MEMORY = -5;
    public static final int SDCARD_FULL = -7;
    public static final int STILL_RUNNING = -6;
    public static final int SUCCESSED = 0;
    private static final String TAG = "ImageFile";
    public static final int TYPE_JPG = 0;
    public static final int TYPE_PNG = 1;
    public static final int URI_NOT_EXSIT = -3;
    private static final String WHERE_CLAUSE = "(mime_type in (?, ?, ?))";
    private LoadTask mLoadTask;
    private OnFileLoadedListener mOnFileLoadedListener;
    private OnFileSavedListener mOnFileSavedListener;
    private OnSampleFileListener mOnSampleFileListener;
    private SampleFileTask mSampleFileTask;
    private SaveTask mSaveTask;
    private ThreadNote mThreadNote;
    private static final String[] ACCEPTABLE_IMAGE_TYPES = {"image/jpeg", "image/png", "image/gif"};
    private static final String[] IMAGE_PROJECTION = {"_id", "datetaken", "date_added", "orientation", "_data"};
    private static Set<ThreadNote> sImageTaskQueue = new HashSet();

    /* loaded from: classes.dex */
    public interface OnFileLoadedListener {
        void onFileLoaded(int i, Bitmap bitmap, Object obj);
    }

    /* loaded from: classes.dex */
    public interface OnFileSavedListener {
        void onFileSaved(int i, Uri uri);
    }

    /* loaded from: classes.dex */
    public interface OnSampleFileListener {
        void onGetSampleFile(int i, File file);
    }

    public int loadImageAsync(Context context, Uri uri, int width, int height, OnFileLoadedListener l) {
        return loadImageAsync(context, uri, width, height, null, l);
    }

    public int loadImageAsync(Context context, Uri uri, int width, int height, Object tag, OnFileLoadedListener l) {
        this.mOnFileLoadedListener = l;
        if (this.mLoadTask == null || this.mLoadTask.getStatus() == AsyncTask.Status.FINISHED) {
            this.mLoadTask = new LoadTask(this, null);
        }
        if (this.mLoadTask.getStatus() == AsyncTask.Status.RUNNING) {
            return -6;
        }
        synchronized (sImageTaskQueue) {
            this.mThreadNote = new ThreadNote(this.mLoadTask, context, uri, Integer.valueOf(width), Integer.valueOf(height), tag);
            sImageTaskQueue.add(this.mThreadNote);
            if (sImageTaskQueue.size() <= 1) {
                ((LoadTask) this.mThreadNote.task).execute(this.mThreadNote.params);
            }
        }
        return 0;
    }

    public int saveImageAsync(Context context, Bitmap bitmap, String path, int type, OnFileSavedListener l) {
        this.mOnFileSavedListener = l;
        if (this.mSaveTask == null || this.mSaveTask.getStatus() == AsyncTask.Status.FINISHED) {
            this.mSaveTask = new SaveTask(this, null);
        }
        if (this.mSaveTask.getStatus() == AsyncTask.Status.RUNNING) {
            return -6;
        }
        this.mSaveTask.execute(context, bitmap, path, Integer.valueOf(type));
        return 0;
    }

    public int getSampleFileAsync(Context cx, Uri uri, int w, int h, String path, int type, OnSampleFileListener l) {
        this.mOnSampleFileListener = l;
        if (this.mSampleFileTask == null || this.mSampleFileTask.getStatus() == AsyncTask.Status.FINISHED) {
            this.mSampleFileTask = new SampleFileTask(this, null);
        }
        if (this.mSampleFileTask.getStatus() == AsyncTask.Status.RUNNING) {
            return -6;
        }
        this.mSampleFileTask.execute(cx, uri, Integer.valueOf(w), Integer.valueOf(h), path, Integer.valueOf(type));
        return 0;
    }

    public static Bitmap getBitmapSample(Context context, Uri uri, int width, int height) throws FileNotFoundException, OutOfMemoryError {
        int nLong;
        int nShort;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPurgeable = true;
        InputStream is = context.getContentResolver().openInputStream(uri);
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(is, null, options);
        int nSample = 1;
        if (options.outHeight > options.outWidth) {
            nLong = options.outHeight;
            nShort = options.outWidth;
        } else {
            nLong = options.outWidth;
            nShort = options.outHeight;
        }
        while (true) {
            if (nShort > (nSample + 1) * height || nLong > (nSample + 1) * width) {
                nSample++;
            } else {
                try {
                    break;
                } catch (IOException e) {
                    LogUtils.w(TAG, "file close error");
                }
            }
        }
        is.close();
        InputStream is2 = context.getContentResolver().openInputStream(uri);
        options.inJustDecodeBounds = false;
        options.inSampleSize = nSample;
        options.inDither = true;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        Bitmap bitmap = BitmapFactory.decodeStream(is2, null, options);
        try {
            is2.close();
        } catch (IOException e2) {
            LogUtils.w(TAG, "file close error");
        }
        return bitmap;
    }

    public static Bitmap getBitmapSample(byte[] data, int width, int height) throws OutOfMemoryError {
        int nLong;
        int nShort;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPurgeable = true;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(data, 0, data.length, options);
        int nSample = 1;
        if (options.outHeight > options.outWidth) {
            nLong = options.outHeight;
            nShort = options.outWidth;
        } else {
            nLong = options.outWidth;
            nShort = options.outHeight;
        }
        while (true) {
            if (nShort > (nSample + 1) * height || nLong > (nSample + 1) * width) {
                nSample++;
            } else {
                options.inJustDecodeBounds = false;
                options.inSampleSize = nSample;
                options.inDither = true;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length, options);
                return bitmap;
            }
        }
    }

    public static String getFileNameFromPath(String path) {
        String file;
        if (path == null) {
            return null;
        }
        if (path.contains("/")) {
            int s = path.lastIndexOf("/") + 1;
            int e = path.length();
            LogUtils.w(TAG, String.format("name: %s. s: %d. n:%d", path, Integer.valueOf(s), Integer.valueOf(e)));
            file = path.substring(s, e);
        } else {
            file = path;
        }
        if (file.contains(".")) {
            return file.substring(0, file.indexOf("."));
        }
        return file;
    }

    public static boolean isSdcardFull() {
        String sdcard = Environment.getExternalStorageDirectory().getPath();
        File file = new File(sdcard);
        StatFs statFs = new StatFs(file.getPath());
        long availableSpare = statFs.getBlockSize() * (statFs.getAvailableBlocks() - 4);
        LogUtils.w("----------availableSpare-------------", String.valueOf(availableSpare));
        return availableSpare < MIN_SD_CARD_SPACE;
    }

    public static String getRealPathFromUri(Context context, Uri contentUri) {
        LogUtils.w(TAG, String.format("getRealPathFromUri: %s", contentUri.toString()));
        String[] proj = {"_data"};
        try {
            Cursor cursor = ((Activity) context).managedQuery(contentUri, proj, null, null, null);
            if (cursor == null) {
                return null;
            }
            int column_index = cursor.getColumnIndex("_data");
            cursor.moveToFirst();
            if (column_index != -1) {
                try {
                    return cursor.getString(column_index);
                } catch (Exception e) {
                    return null;
                }
            }
            return null;
        } catch (Exception e2) {
            return null;
        }
    }

    public static byte[] getImageByte(Bitmap bitmap, int type) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        if (type == 0) {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, os);
        }
        byte[] b = os.toByteArray();
        return b;
    }

    public static Uri saveImage(Context context, Bitmap bitmap, String path, int type, int quality) throws OtherException, SDCardFullException {
        int pos = path.lastIndexOf(47);
        if (pos <= 0) {
            return null;
        }
        String dir = path.substring(0, pos + 1);
        String name = path.substring(pos + 1, path.length());
        if (type == 1) {
            return saveImage(context, bitmap, dir, name, ".png", "image/png", Bitmap.CompressFormat.PNG, 100);
        }
        if (type == 0) {
            return saveImage(context, bitmap, dir, name, ".jpg", "image/jpeg", Bitmap.CompressFormat.JPEG, quality);
        }
        throw new OtherException("");
    }

    public static Bitmap loadImage(Context context, Uri uri, int width, int height) throws OtherException, OutOfMemoryError, FileNotFoundException {
        Bitmap bitmap;
        try {
            Bitmap bitmap2 = getBitmapSample(context, uri, width, height);
            if (bitmap2 == null) {
                throw new OtherException();
            }
            if (bitmap2.getWidth() > bitmap2.getHeight()) {
                bitmap = resizeBitmap(bitmap2, width, height);
            } else {
                bitmap = resizeBitmap(bitmap2, height, width);
            }
            int rotation = getRotationFromMedia(context, uri);
            if (rotation == 0) {
                rotation = getRotationFromExif(uri);
            }
            if (rotation != 0) {
                Matrix mtx = new Matrix();
                mtx.setRotate(rotation);
                return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), mtx, true);
            }
            return bitmap;
        } catch (Exception e) {
            e.printStackTrace();
            throw new OtherException();
        }
    }

    public static Bitmap scaleBitmap(Bitmap bitmap, float scale) {
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();
        int w1 = (int) (w / scale);
        int h1 = (int) (h / scale);
        Bitmap newBitmap = Bitmap.createBitmap(w1, h1, bitmap.getConfig());
        Canvas canvas = new Canvas(newBitmap);
        Paint paint = new Paint();
        paint.setDither(true);
        paint.setFilterBitmap(true);
        canvas.drawBitmap(bitmap, new Rect(0, 0, w, h), new Rect(0, 0, w1, h1), paint);
        bitmap.recycle();
        return newBitmap;
    }

    public static File getSampleFile(Context cx, Uri uri, int w, int h, String path, int type) throws OutOfMemoryError, FileNotFoundException, OtherException, SDCardFullException {
        Bitmap bm = loadImage(cx, uri, w, h);
        saveImage(cx, bm, path, 0, 80);
        return new File(path);
    }

    private static int getRotationFromMedia(Context context, Uri imageUri) {
        ContentResolver mContentResolver = context.getContentResolver();
        int rotation = 0;
        Cursor c = createCursor(mContentResolver, imageUri);
        if (c != null) {
            if (c.moveToFirst()) {
                rotation = c.getInt(3);
            }
            c.close();
        }
        return rotation;
    }

    private static int getRotationFromExif(Uri uri) {
        try {
            String targetScheme = uri.getScheme();
            if (!targetScheme.equals("file")) {
                return 0;
            }
            ExifInterface exif = new ExifInterface(uri.getPath());
            int rotation = (int) Shared.exifOrientationToDegrees(exif.getAttributeInt("Orientation", 1));
            return rotation;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private static String sortOrder() {
        return String.valueOf("case ifnull(datetaken,0) when 0 then date_modified*1000 else datetaken end") + " DESC, _id DESC";
    }

    private static Cursor createCursor(ContentResolver mContentResolver, Uri mBaseUri) {
        Cursor c;
        try {
            if (mBaseUri.getScheme().startsWith("file")) {
                String[] args = {""};
                args[0] = mBaseUri.getPath();
                c = MediaStore.Images.Media.query(mContentResolver, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, IMAGE_PROJECTION, "(_data=?)", args, sortOrder());
            } else {
                c = MediaStore.Images.Media.query(mContentResolver, mBaseUri, IMAGE_PROJECTION, WHERE_CLAUSE, ACCEPTABLE_IMAGE_TYPES, sortOrder());
            }
            return c;
        } catch (Exception e) {
            return null;
        }
    }

    private static Uri saveImage(Context context, Bitmap bitmap, String dir, String name, String suffix, String mimeType, Bitmap.CompressFormat format, int quality) throws OtherException, SDCardFullException {
        String newPath;
        if (isSdcardFull()) {
            throw new SDCardFullException();
        }
        String[] nameArr = name.split("\\.");
        if (nameArr.length > 2 && (nameArr[1].equals("jpg") || nameArr[1].equals("png"))) {
            newPath = String.valueOf(dir) + name + suffix;
        } else {
            newPath = String.valueOf(dir) + name;
        }
        ContentValues values = new ContentValues(8);
        values.put("title", name);
        values.put("_display_name", name);
        values.put("description", "edited_by_photowonder");
        values.put("datetaken", Long.valueOf(System.currentTimeMillis()));
        values.put("mime_type", mimeType);
        values.put("orientation", (Integer) 0);
        values.put("bucket_id", Integer.valueOf(dir.hashCode()));
        new File(dir).mkdirs();
        File f = new File(newPath);
        values.put("bucket_display_name", f.getName().toLowerCase());
        try {
            f.createNewFile();
            FileOutputStream fileOS = new FileOutputStream(f);
            bitmap.compress(format, quality, fileOS);
            fileOS.close();
            context.sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED", Uri.parse("file://" + Environment.getExternalStorageDirectory())));
            LogUtils.d(TAG, "save ok at:" + newPath);
            return Uri.fromFile(new File(newPath));
        } catch (Exception e) {
            e.printStackTrace();
            throw new OtherException("cannot save image");
        }
    }

    private static Bitmap resizeBitmap(Bitmap bitmap, int newWidth, int newHeight) throws OtherException {
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();
        float rw = w / newWidth;
        float rh = h / newHeight;
        float r = rw > rh ? rw : rh;
        if (r < 1.0f) {
            Bitmap newBitmap = bitmap.copy(bitmap.getConfig(), true);
            bitmap.recycle();
            return newBitmap;
        }
        Bitmap newBitmap2 = scaleBitmap(bitmap, r);
        return newBitmap2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class LoadTask extends AsyncTask<Object, Void, Integer> {
        private Bitmap miBitmap;
        private Object tag;

        private LoadTask() {
        }

        /* synthetic */ LoadTask(ImageFile imageFile, LoadTask loadTask) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.AsyncTask
        public Integer doInBackground(Object... params) {
            try {
                Context context = (Context) params[0];
                Uri uri = (Uri) params[1];
                Integer width = (Integer) params[2];
                Integer height = (Integer) params[3];
                if (params.length == 5) {
                    this.tag = params[4];
                }
                this.miBitmap = ImageFile.loadImage(context, uri, width.intValue(), height.intValue());
                return 0;
            } catch (OtherException e) {
                e.printStackTrace();
                return -1;
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
                return -2;
            } catch (OutOfMemoryError e3) {
                e3.printStackTrace();
                return -5;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Integer rst) {
            synchronized (ImageFile.sImageTaskQueue) {
                ImageFile.sImageTaskQueue.remove(ImageFile.this.mThreadNote);
                if (ImageFile.sImageTaskQueue.size() > 0) {
                    Iterator<ThreadNote> iter = ImageFile.sImageTaskQueue.iterator();
                    while (true) {
                        if (!iter.hasNext()) {
                            break;
                        }
                        ThreadNote note = iter.next();
                        if (note.task.getStatus() == AsyncTask.Status.PENDING) {
                            ((LoadTask) note.task).execute(note.params);
                            break;
                        }
                    }
                }
            }
            if (ImageFile.this.mOnFileLoadedListener != null) {
                ImageFile.this.mOnFileLoadedListener.onFileLoaded(rst.intValue(), this.miBitmap, this.tag);
                ImageFile.this.mOnFileLoadedListener = null;
            }
        }
    }

    /* loaded from: classes.dex */
    private class SaveTask extends AsyncTask<Object, Void, Integer> {
        private Uri miUri;

        private SaveTask() {
        }

        /* synthetic */ SaveTask(ImageFile imageFile, SaveTask saveTask) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.AsyncTask
        public Integer doInBackground(Object... params) {
            Context context = (Context) params[0];
            Bitmap bitmap = (Bitmap) params[1];
            String path = (String) params[2];
            Integer type = (Integer) params[3];
            try {
                this.miUri = ImageFile.saveImage(context, bitmap, path, type.intValue(), 80);
                return 0;
            } catch (OtherException e) {
                e.printStackTrace();
                return -1;
            } catch (SDCardFullException e2) {
                e2.printStackTrace();
                return -7;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Integer rst) {
            if (ImageFile.this.mOnFileSavedListener != null) {
                ImageFile.this.mOnFileSavedListener.onFileSaved(rst.intValue(), this.miUri);
                ImageFile.this.mOnFileSavedListener = null;
            }
        }
    }

    /* loaded from: classes.dex */
    private class SampleFileTask extends AsyncTask<Object, Void, Integer> {
        private File file;

        private SampleFileTask() {
        }

        /* synthetic */ SampleFileTask(ImageFile imageFile, SampleFileTask sampleFileTask) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.AsyncTask
        public Integer doInBackground(Object... params) {
            Context cx = (Context) params[0];
            Uri uri = (Uri) params[1];
            int w = ((Integer) params[2]).intValue();
            int h = ((Integer) params[3]).intValue();
            String path = (String) params[4];
            Integer type = (Integer) params[5];
            try {
                this.file = ImageFile.getSampleFile(cx, uri, w, h, path, type.intValue());
                return 0;
            } catch (OtherException e) {
                e.printStackTrace();
                return -1;
            } catch (SDCardFullException e2) {
                e2.printStackTrace();
                return -7;
            } catch (FileNotFoundException e3) {
                e3.printStackTrace();
                return -2;
            } catch (OutOfMemoryError e4) {
                e4.printStackTrace();
                return -5;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Integer rst) {
            if (ImageFile.this.mOnSampleFileListener != null) {
                ImageFile.this.mOnSampleFileListener.onGetSampleFile(rst.intValue(), this.file);
                ImageFile.this.mOnSampleFileListener = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ThreadNote {
        public Object[] params;
        public AsyncTask task;

        public ThreadNote(AsyncTask task, Object... params) {
            this.task = task;
            this.params = params;
        }
    }
}
