package com.baidu.fsg.base.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
/* loaded from: classes2.dex */
public class ImageBase64Utils {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5537a = "ImageBase64Utils";

    /* renamed from: b  reason: collision with root package name */
    public static int f5538b = 70;

    /* renamed from: c  reason: collision with root package name */
    public static ImageBase64Utils f5539c;

    /* loaded from: classes2.dex */
    public class ImageBase64AsyncTask extends AsyncTask<String, Integer, String> {

        /* renamed from: b  reason: collision with root package name */
        public ImageBase64Listener f5541b;

        /* renamed from: c  reason: collision with root package name */
        public String f5542c;

        /* renamed from: d  reason: collision with root package name */
        public int f5543d;

        public ImageBase64AsyncTask(ImageBase64Listener imageBase64Listener, String str, int i2) {
            this.f5541b = imageBase64Listener;
            this.f5542c = str;
            this.f5543d = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public String doInBackground(String... strArr) {
            return ImageBase64Utils.b(this.f5542c, this.f5543d);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            ImageBase64Listener imageBase64Listener = this.f5541b;
            if (imageBase64Listener != null) {
                imageBase64Listener.onBase64Result(str);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface ImageBase64Listener {
        void onBase64Result(String str);
    }

    public static String b(String str, int i2) {
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
                int computeSampleSize = ImageCompressor.computeSampleSize(options, i2, -1);
                options.inSampleSize = computeSampleSize;
                options.inJustDecodeBounds = false;
                Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                decodeFile.compress(Bitmap.CompressFormat.JPEG, f5538b, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                LogUtil.d("ImageBase64Utils", "compress size:\t" + byteArray.length + "\tsampleSize" + computeSampleSize + "\twidth" + decodeFile.getWidth());
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

    public static Bitmap getBase64Bitmap(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] decode = Base64Utils.decode(str);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String getImageBase64(Bitmap bitmap, int i2) {
        if (bitmap == null) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                LogUtil.d("ImageBase64Utils", "compress size:\t" + byteArray.length + "\timagesize" + byteArray.length + "\twidth" + bitmap.getWidth());
                byte[] encode = Base64.encode(byteArray, 0, byteArray.length, 2);
                StringBuilder sb = new StringBuilder();
                sb.append("base64 size:\t");
                sb.append(byteArray.length / 1024);
                LogUtil.d("ImageBase64Utils", sb.toString());
                String str = new String(encode);
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return str;
            } catch (Exception e3) {
                e3.printStackTrace();
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                return "";
            }
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            throw th;
        }
    }

    public static ImageBase64Utils getInstance() {
        if (f5539c == null) {
            f5539c = new ImageBase64Utils();
        }
        return f5539c;
    }

    public void getImgageBase64(String str, int i2, ImageBase64Listener imageBase64Listener) {
        new ImageBase64AsyncTask(imageBase64Listener, str, i2).execute("");
    }
}
