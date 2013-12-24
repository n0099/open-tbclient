package com.baidu.cloudsdk.common.imgloader;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.baidu.zeus.NotificationProxy;
import com.google.protobuf.CodedOutputStream;
import java.io.ByteArrayOutputStream;
/* loaded from: classes.dex */
public class CompressBitmapTask extends AsyncTask {
    private int a;
    private int b;
    private ICompressBitmapListener c;

    /* loaded from: classes.dex */
    public interface ICompressBitmapListener {
        void onComplete(ByteArrayOutputStream byteArrayOutputStream);
    }

    public CompressBitmapTask(int i, int i2, ICompressBitmapListener iCompressBitmapListener) {
        this.a = i;
        this.b = i2;
        this.c = iCompressBitmapListener;
    }

    public CompressBitmapTask(ICompressBitmapListener iCompressBitmapListener) {
        this.a = CodedOutputStream.DEFAULT_BUFFER_SIZE;
        this.b = NotificationProxy.MAX_URL_LENGTH;
        this.c = iCompressBitmapListener;
    }

    private Bitmap a(Bitmap bitmap) {
        int i;
        int i2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width > height) {
            i2 = this.b;
            i = (height * i2) / width;
        } else {
            i = this.b;
            i2 = (width * i) / height;
        }
        return Bitmap.createScaledBitmap(bitmap, i2, i, true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public ByteArrayOutputStream doInBackground(Bitmap... bitmapArr) {
        Bitmap bitmap = bitmapArr[0];
        if (((bitmap.getHeight() * bitmap.getWidth()) * 4) / NotificationProxy.MAX_URL_LENGTH > this.a) {
            bitmap = a(bitmap);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)) {
            return byteArrayOutputStream;
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(ByteArrayOutputStream byteArrayOutputStream) {
        if (this.c != null) {
            this.c.onComplete(byteArrayOutputStream);
        }
    }
}
