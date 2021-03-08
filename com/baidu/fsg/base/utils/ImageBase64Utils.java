package com.baidu.fsg.base.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
/* loaded from: classes5.dex */
public class ImageBase64Utils {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1553a = "ImageBase64Utils";
    private static int b = 70;
    private static ImageBase64Utils c;

    /* loaded from: classes5.dex */
    public interface ImageBase64Listener {
        void onBase64Result(String str);
    }

    private ImageBase64Utils() {
    }

    public static ImageBase64Utils getInstance() {
        if (c == null) {
            c = new ImageBase64Utils();
        }
        return c;
    }

    public static Bitmap getBase64Bitmap(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] decode = Base64Utils.decode(str);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getImageBase64(Bitmap bitmap, int i) {
        if (bitmap == null) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                LogUtil.d(f1553a, "compress size:\t" + byteArray.length + "\timagesize" + byteArray.length + "\twidth" + bitmap.getWidth());
                byte[] encode = Base64.encode(byteArray, 0, byteArray.length, 2);
                LogUtil.d(f1553a, "base64 size:\t" + (byteArray.length / 1024));
                String str = new String(encode);
                try {
                    byteArrayOutputStream.close();
                    return str;
                } catch (IOException e) {
                    e.printStackTrace();
                    return str;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                try {
                    byteArrayOutputStream.close();
                    return "";
                } catch (IOException e3) {
                    e3.printStackTrace();
                    return "";
                }
            }
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            try {
                File file = new File(str);
                if (file.exists() && file.isFile()) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(str, options);
                    LogUtil.d(f1553a, "original size\t " + (file.length() / 1000) + "\twidth" + options.outWidth + "\theight" + options.outHeight);
                    int computeSampleSize = ImageCompressor.computeSampleSize(options, i, -1);
                    options.inSampleSize = computeSampleSize;
                    options.inJustDecodeBounds = false;
                    Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    decodeFile.compress(Bitmap.CompressFormat.JPEG, b, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    LogUtil.d(f1553a, "compress size:\t" + byteArray.length + "\tsampleSize" + computeSampleSize + "\twidth" + decodeFile.getWidth());
                    decodeFile.recycle();
                    byteArrayOutputStream.close();
                    byte[] encode = Base64.encode(byteArray, 0, byteArray.length, 2);
                    LogUtil.d(f1553a, "base64 size:\t" + (byteArray.length / 1024));
                    return new String(encode);
                }
            } catch (Throwable th) {
            }
        }
        return "";
    }

    public void getImgageBase64(String str, int i, ImageBase64Listener imageBase64Listener) {
        new ImageBase64AsyncTask(imageBase64Listener, str, i).execute("");
    }

    /* loaded from: classes5.dex */
    class ImageBase64AsyncTask extends AsyncTask<String, Integer, String> {
        private ImageBase64Listener b;
        private String c;
        private int d;

        public ImageBase64AsyncTask(ImageBase64Listener imageBase64Listener, String str, int i) {
            this.b = imageBase64Listener;
            this.c = str;
            this.d = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public String doInBackground(String... strArr) {
            return ImageBase64Utils.b(this.c, this.d);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            if (this.b != null) {
                this.b.onBase64Result(str);
            }
        }
    }
}
