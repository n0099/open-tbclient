package com.baidu.ar.recommend;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.widget.ImageView;
import com.baidu.ar.util.FileUtils;
import com.baidu.ar.util.HttpUtils;
import com.baidu.ar.util.IoUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public final class d {
    private static final String a = d.class.getSimpleName();
    private static String g;
    private static d h;
    private final SparseArray<WeakReference<Bitmap>> b = new SparseArray<>();
    private final SparseArray<a> c = new SparseArray<>();
    private final Map<String, List<WeakReference<ImageView>>> d = new HashMap();
    private File e = new File(Environment.getExternalStorageDirectory(), "cache");
    private Bitmap f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public final class a extends AsyncTask<Void, Void, Boolean> {
        private final String b;

        a(String str) {
            this.b = str;
        }

        private void a() {
            synchronized (d.this.c) {
                d.this.c.remove(this.b.hashCode());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Void... voidArr) {
            return Boolean.valueOf(d.this.h(this.b));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(Boolean bool) {
            List<WeakReference> list;
            ImageView imageView;
            if (bool.booleanValue() && (list = (List) d.this.d.remove(this.b)) != null) {
                for (WeakReference weakReference : list) {
                    if (weakReference != null && (imageView = (ImageView) weakReference.get()) != null && this.b.equals(imageView.getTag())) {
                        d.this.a(imageView, d.this.g(this.b));
                    }
                }
            }
            a();
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            super.onCancelled();
            a();
            d.this.d.remove(this.b);
        }
    }

    private d() {
    }

    private Bitmap a(String str, int i, SparseArray<WeakReference<Bitmap>> sparseArray) {
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        if (decodeFile != null) {
            decodeFile.setDensity(Resources.getSystem().getDisplayMetrics().densityDpi);
            sparseArray.put(i, new WeakReference<>(decodeFile));
        }
        return decodeFile;
    }

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (h == null) {
                h = new d();
            }
            dVar = h;
        }
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, Bitmap bitmap) {
        if (imageView == null || bitmap == null) {
            return;
        }
        imageView.setImageDrawable(new c(bitmap, 0, 0.0f));
    }

    public static void a(String str) {
        g = str;
    }

    private static boolean a(Bitmap bitmap, String str) {
        FileOutputStream fileOutputStream;
        File file = new File(str);
        if (file.exists()) {
            return true;
        }
        try {
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file);
            try {
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
                    fileOutputStream.flush();
                    IoUtils.closeQuietly(fileOutputStream);
                    return true;
                } catch (IOException e) {
                    e = e;
                    e.printStackTrace();
                    FileUtils.deleteFileIfExist(file);
                    IoUtils.closeQuietly(fileOutputStream);
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                IoUtils.closeQuietly(fileOutputStream);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            IoUtils.closeQuietly(fileOutputStream);
            throw th;
        }
    }

    private static Bitmap b(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width == height) {
            return bitmap;
        }
        return width > height ? Bitmap.createBitmap(bitmap, (width / 2) - (height / 2), 0, height, height) : Bitmap.createBitmap(bitmap, 0, (height / 2) - (width / 2), width, width);
    }

    private void b() {
        if (this.f != null) {
            this.f.recycle();
            this.f = null;
        }
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str) || !str.equals(g) || h == null) {
            return;
        }
        h.b();
        h = null;
    }

    private void e(String str) {
        synchronized (this.c) {
            int hashCode = str.hashCode();
            if (this.c.get(hashCode) == null) {
                a aVar = new a(str);
                this.c.put(hashCode, aVar);
                aVar.execute(new Void[0]);
            }
        }
    }

    private Bitmap f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int hashCode = str.hashCode();
        SparseArray<WeakReference<Bitmap>> sparseArray = this.b;
        WeakReference<Bitmap> weakReference = sparseArray.get(hashCode);
        Bitmap bitmap = weakReference != null ? weakReference.get() : null;
        return bitmap == null ? a(str, hashCode, sparseArray) : bitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap g(String str) {
        File c = c(str);
        if (c != null) {
            return f(c.getPath());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h(String str) {
        File c;
        if (!TextUtils.isEmpty(str) && (c = c(str)) != null) {
            FileUtils.ensureParent(c);
            File file = new File(c.getAbsoluteFile() + "itmp" + System.currentTimeMillis());
            Log.d(a, String.format("Downloading image from %s to %s.", str, file.toString()));
            boolean downloadFile = HttpUtils.downloadFile(str, file);
            Log.d(a, String.format("Downloaded image from %s to %s, RESULT = %s.", str, file.toString(), String.valueOf(downloadFile)));
            if (downloadFile) {
                Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath());
                if (decodeFile == null) {
                    Log.e(a, "Decode image error, file:" + file);
                    return downloadFile;
                }
                decodeFile.setDensity(Resources.getSystem().getDisplayMetrics().densityDpi);
                Bitmap b = b(decodeFile);
                if (b == decodeFile) {
                    return file.renameTo(c);
                }
                boolean a2 = a(b, c.getAbsolutePath());
                FileUtils.deleteFileIfExist(file);
                return a2;
            }
            return downloadFile;
        }
        return false;
    }

    public void a(Bitmap bitmap) {
        this.f = bitmap;
    }

    public void a(File file) {
        this.e = file;
    }

    public void a(String str, ImageView imageView) {
        if (imageView == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            a(imageView, this.f);
            return;
        }
        Bitmap g2 = g(str);
        if (g2 != null) {
            a(imageView, g2);
            return;
        }
        a(imageView, this.f);
        imageView.setTag(str);
        List<WeakReference<ImageView>> list = this.d.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.d.put(str, list);
        }
        list.add(new WeakReference<>(imageView));
        d(str);
    }

    public File c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new File(this.e, String.format("%08x.cache", Integer.valueOf(str.hashCode())));
    }

    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        e(str);
    }
}
