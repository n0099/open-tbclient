package com.baidu.apollon.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.apollon.imagemanager.ImageProcessor;
import java.io.ByteArrayOutputStream;
import java.io.File;
/* loaded from: classes.dex */
public class ImageBase64Utils {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3953a = "ImageBase64Utils";

    /* renamed from: b  reason: collision with root package name */
    public static int f3954b = 70;

    /* renamed from: c  reason: collision with root package name */
    public static ImageBase64Utils f3955c;

    /* loaded from: classes.dex */
    public interface ImageBase64Listener {
        void onBase64Result(String str);
    }

    /* loaded from: classes.dex */
    public class a extends AsyncTask<String, Integer, String> {

        /* renamed from: b  reason: collision with root package name */
        public ImageBase64Listener f3957b;

        /* renamed from: c  reason: collision with root package name */
        public String f3958c;

        /* renamed from: d  reason: collision with root package name */
        public int f3959d;

        public a(ImageBase64Listener imageBase64Listener, String str, int i) {
            this.f3957b = imageBase64Listener;
            this.f3958c = str;
            this.f3959d = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public String doInBackground(String... strArr) {
            return ImageBase64Utils.b(this.f3958c, this.f3959d);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            ImageBase64Listener imageBase64Listener = this.f3957b;
            if (imageBase64Listener != null) {
                imageBase64Listener.onBase64Result(str);
            }
        }
    }

    public static String b(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str, options);
                LogUtil.d("ImageBase64Utils", "original size\t " + (file.length() / 1000) + "\twidth" + options.outWidth + "\theight" + options.outHeight);
                int a2 = ImageProcessor.a(options, i, -1);
                options.inSampleSize = a2;
                options.inJustDecodeBounds = false;
                Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                decodeFile.compress(Bitmap.CompressFormat.JPEG, f3954b, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                LogUtil.d("ImageBase64Utils", "compress size:\t" + byteArray.length + "\tsampleSize" + a2 + "\twidth" + decodeFile.getWidth());
                decodeFile.recycle();
                byteArrayOutputStream.close();
                byte[] encode = Base64.encode(byteArray, 0, byteArray.length, 2);
                StringBuilder sb = new StringBuilder();
                sb.append("base64 size:\t");
                sb.append(byteArray.length / 1024);
                LogUtil.d("ImageBase64Utils", sb.toString());
                return new String(encode);
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static ImageBase64Utils getInstance() {
        if (f3955c == null) {
            f3955c = new ImageBase64Utils();
        }
        return f3955c;
    }

    public void getImgageBase64(String str, int i, ImageBase64Listener imageBase64Listener) {
        new a(imageBase64Listener, str, i).execute("");
    }
}
