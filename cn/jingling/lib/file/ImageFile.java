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
import com.tencent.mm.sdk.platformtools.Util;
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

    public int loadImageAsync(Context context, Uri uri, int i, int i2, OnFileLoadedListener onFileLoadedListener) {
        return loadImageAsync(context, uri, i, i2, null, onFileLoadedListener);
    }

    public int loadImageAsync(Context context, Uri uri, int i, int i2, Object obj, OnFileLoadedListener onFileLoadedListener) {
        this.mOnFileLoadedListener = onFileLoadedListener;
        if (this.mLoadTask == null || this.mLoadTask.getStatus() == AsyncTask.Status.FINISHED) {
            this.mLoadTask = new LoadTask(this, null);
        }
        if (this.mLoadTask.getStatus() == AsyncTask.Status.RUNNING) {
            return -6;
        }
        synchronized (sImageTaskQueue) {
            this.mThreadNote = new ThreadNote(this.mLoadTask, context, uri, Integer.valueOf(i), Integer.valueOf(i2), obj);
            sImageTaskQueue.add(this.mThreadNote);
            if (sImageTaskQueue.size() <= 1) {
                ((LoadTask) this.mThreadNote.task).execute(this.mThreadNote.params);
            }
        }
        return 0;
    }

    public int saveImageAsync(Context context, Bitmap bitmap, String str, int i, OnFileSavedListener onFileSavedListener) {
        this.mOnFileSavedListener = onFileSavedListener;
        if (this.mSaveTask == null || this.mSaveTask.getStatus() == AsyncTask.Status.FINISHED) {
            this.mSaveTask = new SaveTask(this, null);
        }
        if (this.mSaveTask.getStatus() == AsyncTask.Status.RUNNING) {
            return -6;
        }
        this.mSaveTask.execute(context, bitmap, str, Integer.valueOf(i));
        return 0;
    }

    public int getSampleFileAsync(Context context, Uri uri, int i, int i2, String str, int i3, OnSampleFileListener onSampleFileListener) {
        this.mOnSampleFileListener = onSampleFileListener;
        if (this.mSampleFileTask == null || this.mSampleFileTask.getStatus() == AsyncTask.Status.FINISHED) {
            this.mSampleFileTask = new SampleFileTask(this, null);
        }
        if (this.mSampleFileTask.getStatus() == AsyncTask.Status.RUNNING) {
            return -6;
        }
        this.mSampleFileTask.execute(context, uri, Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3));
        return 0;
    }

    public static Bitmap getBitmapSample(Context context, Uri uri, int i, int i2) {
        int i3;
        int i4;
        int i5;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPurgeable = true;
        InputStream openInputStream = context.getContentResolver().openInputStream(uri);
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(openInputStream, null, options);
        if (options.outHeight > options.outWidth) {
            i3 = options.outHeight;
            i4 = options.outWidth;
            i5 = 1;
        } else {
            i3 = options.outWidth;
            i4 = options.outHeight;
            i5 = 1;
        }
        while (true) {
            if (i4 > (i5 + 1) * i2 || i3 > (i5 + 1) * i) {
                i5++;
            } else {
                try {
                    break;
                } catch (IOException e) {
                    LogUtils.w(TAG, "file close error");
                }
            }
        }
        openInputStream.close();
        InputStream openInputStream2 = context.getContentResolver().openInputStream(uri);
        options.inJustDecodeBounds = false;
        options.inSampleSize = i5;
        options.inDither = true;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        Bitmap decodeStream = BitmapFactory.decodeStream(openInputStream2, null, options);
        try {
            openInputStream2.close();
        } catch (IOException e2) {
            LogUtils.w(TAG, "file close error");
        }
        return decodeStream;
    }

    public static Bitmap getBitmapSample(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPurgeable = true;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        if (options.outHeight > options.outWidth) {
            i3 = options.outHeight;
            i4 = options.outWidth;
            i5 = 1;
        } else {
            i3 = options.outWidth;
            i4 = options.outHeight;
            i5 = 1;
        }
        while (true) {
            if (i4 > (i5 + 1) * i2 || i3 > (i5 + 1) * i) {
                i5++;
            } else {
                options.inJustDecodeBounds = false;
                options.inSampleSize = i5;
                options.inDither = true;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            }
        }
    }

    public static String getFileNameFromPath(String str) {
        if (str == null) {
            return null;
        }
        if (str.contains("/")) {
            int lastIndexOf = str.lastIndexOf("/") + 1;
            int length = str.length();
            LogUtils.w(TAG, String.format("name: %s. s: %d. n:%d", str, Integer.valueOf(lastIndexOf), Integer.valueOf(length)));
            str = str.substring(lastIndexOf, length);
        }
        if (str.contains(".")) {
            return str.substring(0, str.indexOf("."));
        }
        return str;
    }

    public static boolean isSdcardFull() {
        StatFs statFs = new StatFs(new File(Environment.getExternalStorageDirectory().getPath()).getPath());
        long blockSize = statFs.getBlockSize() * (statFs.getAvailableBlocks() - 4);
        LogUtils.w("----------availableSpare-------------", String.valueOf(blockSize));
        return blockSize < MIN_SD_CARD_SPACE;
    }

    public static String getRealPathFromUri(Context context, Uri uri) {
        String str;
        LogUtils.w(TAG, String.format("getRealPathFromUri: %s", uri.toString()));
        try {
            Cursor managedQuery = ((Activity) context).managedQuery(uri, new String[]{"_data"}, null, null, null);
            if (managedQuery == null) {
                return null;
            }
            int columnIndex = managedQuery.getColumnIndex("_data");
            managedQuery.moveToFirst();
            if (columnIndex != -1) {
                try {
                    str = managedQuery.getString(columnIndex);
                } catch (Exception e) {
                    str = null;
                }
                return str;
            }
            return null;
        } catch (Exception e2) {
            return null;
        }
    }

    public static byte[] getImageByte(Bitmap bitmap, int i) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (i == 0) {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static Uri saveImage(Context context, Bitmap bitmap, String str, int i, int i2) {
        int lastIndexOf = str.lastIndexOf(47);
        if (lastIndexOf <= 0) {
            return null;
        }
        String substring = str.substring(0, lastIndexOf + 1);
        String substring2 = str.substring(lastIndexOf + 1, str.length());
        if (i == 1) {
            return saveImage(context, bitmap, substring, substring2, ".png", "image/png", Bitmap.CompressFormat.PNG, 100);
        }
        if (i == 0) {
            return saveImage(context, bitmap, substring, substring2, Util.PHOTO_DEFAULT_EXT, "image/jpeg", Bitmap.CompressFormat.JPEG, i2);
        }
        throw new OtherException("");
    }

    public static Bitmap loadImage(Context context, Uri uri, int i, int i2) {
        Bitmap resizeBitmap;
        try {
            Bitmap bitmapSample = getBitmapSample(context, uri, i, i2);
            if (bitmapSample == null) {
                throw new OtherException();
            }
            if (bitmapSample.getWidth() > bitmapSample.getHeight()) {
                resizeBitmap = resizeBitmap(bitmapSample, i, i2);
            } else {
                resizeBitmap = resizeBitmap(bitmapSample, i2, i);
            }
            int rotationFromMedia = getRotationFromMedia(context, uri);
            if (rotationFromMedia == 0) {
                rotationFromMedia = getRotationFromExif(uri);
            }
            if (rotationFromMedia != 0) {
                Matrix matrix = new Matrix();
                matrix.setRotate(rotationFromMedia);
                return Bitmap.createBitmap(resizeBitmap, 0, 0, resizeBitmap.getWidth(), resizeBitmap.getHeight(), matrix, true);
            }
            return resizeBitmap;
        } catch (Exception e) {
            e.printStackTrace();
            throw new OtherException();
        }
    }

    public static Bitmap scaleBitmap(Bitmap bitmap, float f) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = (int) (width / f);
        int i2 = (int) (height / f);
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setDither(true);
        paint.setFilterBitmap(true);
        canvas.drawBitmap(bitmap, new Rect(0, 0, width, height), new Rect(0, 0, i, i2), paint);
        bitmap.recycle();
        return createBitmap;
    }

    public static File getSampleFile(Context context, Uri uri, int i, int i2, String str, int i3) {
        saveImage(context, loadImage(context, uri, i, i2), str, 0, 80);
        return new File(str);
    }

    private static int getRotationFromMedia(Context context, Uri uri) {
        int i = 0;
        Cursor createCursor = createCursor(context.getContentResolver(), uri);
        if (createCursor != null) {
            if (createCursor.moveToFirst()) {
                i = createCursor.getInt(3);
            }
            createCursor.close();
        }
        return i;
    }

    private static int getRotationFromExif(Uri uri) {
        try {
            if (!uri.getScheme().equals("file")) {
                return 0;
            }
            return (int) Shared.exifOrientationToDegrees(new ExifInterface(uri.getPath()).getAttributeInt("Orientation", 1));
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private static String sortOrder() {
        return String.valueOf("case ifnull(datetaken,0) when 0 then date_modified*1000 else datetaken end") + " DESC, _id DESC";
    }

    private static Cursor createCursor(ContentResolver contentResolver, Uri uri) {
        Cursor query;
        try {
            if (uri.getScheme().startsWith("file")) {
                String[] strArr = {""};
                strArr[0] = uri.getPath();
                query = MediaStore.Images.Media.query(contentResolver, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, IMAGE_PROJECTION, "(_data=?)", strArr, sortOrder());
            } else {
                query = MediaStore.Images.Media.query(contentResolver, uri, IMAGE_PROJECTION, WHERE_CLAUSE, ACCEPTABLE_IMAGE_TYPES, sortOrder());
            }
            return query;
        } catch (Exception e) {
            return null;
        }
    }

    private static Uri saveImage(Context context, Bitmap bitmap, String str, String str2, String str3, String str4, Bitmap.CompressFormat compressFormat, int i) {
        String str5;
        if (isSdcardFull()) {
            throw new SDCardFullException();
        }
        String[] split = str2.split("\\.");
        if (split.length > 2 && (split[1].equals("jpg") || split[1].equals("png"))) {
            str5 = String.valueOf(str) + str2 + str3;
        } else {
            str5 = String.valueOf(str) + str2;
        }
        ContentValues contentValues = new ContentValues(8);
        contentValues.put("title", str2);
        contentValues.put("_display_name", str2);
        contentValues.put("description", "edited_by_photowonder");
        contentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("mime_type", str4);
        contentValues.put("orientation", (Integer) 0);
        contentValues.put("bucket_id", Integer.valueOf(str.hashCode()));
        new File(str).mkdirs();
        File file = new File(str5);
        contentValues.put("bucket_display_name", file.getName().toLowerCase());
        try {
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(compressFormat, i, fileOutputStream);
            fileOutputStream.close();
            context.sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED", Uri.parse("file://" + Environment.getExternalStorageDirectory())));
            LogUtils.d(TAG, "save ok at:" + str5);
            return Uri.fromFile(new File(str5));
        } catch (Exception e) {
            e.printStackTrace();
            throw new OtherException("cannot save image");
        }
    }

    private static Bitmap resizeBitmap(Bitmap bitmap, int i, int i2) {
        float width = bitmap.getWidth() / i;
        float height = bitmap.getHeight() / i2;
        if (width <= height) {
            width = height;
        }
        if (width < 1.0f) {
            Bitmap copy = bitmap.copy(bitmap.getConfig(), true);
            bitmap.recycle();
            return copy;
        }
        return scaleBitmap(bitmap, width);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
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
        public Integer doInBackground(Object... objArr) {
            try {
                Context context = (Context) objArr[0];
                Uri uri = (Uri) objArr[1];
                Integer num = (Integer) objArr[2];
                Integer num2 = (Integer) objArr[3];
                if (objArr.length == 5) {
                    this.tag = objArr[4];
                }
                this.miBitmap = ImageFile.loadImage(context, uri, num.intValue(), num2.intValue());
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
        public void onPostExecute(Integer num) {
            synchronized (ImageFile.sImageTaskQueue) {
                ImageFile.sImageTaskQueue.remove(ImageFile.this.mThreadNote);
                if (ImageFile.sImageTaskQueue.size() > 0) {
                    Iterator it = ImageFile.sImageTaskQueue.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ThreadNote threadNote = (ThreadNote) it.next();
                        if (threadNote.task.getStatus() == AsyncTask.Status.PENDING) {
                            ((LoadTask) threadNote.task).execute(threadNote.params);
                            break;
                        }
                    }
                }
            }
            if (ImageFile.this.mOnFileLoadedListener != null) {
                ImageFile.this.mOnFileLoadedListener.onFileLoaded(num.intValue(), this.miBitmap, this.tag);
                ImageFile.this.mOnFileLoadedListener = null;
            }
        }
    }

    /* loaded from: classes.dex */
    class SaveTask extends AsyncTask<Object, Void, Integer> {
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
        public Integer doInBackground(Object... objArr) {
            try {
                this.miUri = ImageFile.saveImage((Context) objArr[0], (Bitmap) objArr[1], (String) objArr[2], ((Integer) objArr[3]).intValue(), 80);
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
        public void onPostExecute(Integer num) {
            if (ImageFile.this.mOnFileSavedListener != null) {
                ImageFile.this.mOnFileSavedListener.onFileSaved(num.intValue(), this.miUri);
                ImageFile.this.mOnFileSavedListener = null;
            }
        }
    }

    /* loaded from: classes.dex */
    class SampleFileTask extends AsyncTask<Object, Void, Integer> {
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
        public Integer doInBackground(Object... objArr) {
            try {
                this.file = ImageFile.getSampleFile((Context) objArr[0], (Uri) objArr[1], ((Integer) objArr[2]).intValue(), ((Integer) objArr[3]).intValue(), (String) objArr[4], ((Integer) objArr[5]).intValue());
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
        public void onPostExecute(Integer num) {
            if (ImageFile.this.mOnSampleFileListener != null) {
                ImageFile.this.mOnSampleFileListener.onGetSampleFile(num.intValue(), this.file);
                ImageFile.this.mOnSampleFileListener = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ThreadNote {
        public Object[] params;
        public AsyncTask task;

        public ThreadNote(AsyncTask asyncTask, Object... objArr) {
            this.task = asyncTask;
            this.params = objArr;
        }
    }
}
