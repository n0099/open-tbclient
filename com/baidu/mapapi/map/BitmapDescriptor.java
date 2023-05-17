package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes3.dex */
public final class BitmapDescriptor {
    public Bitmap a;
    public Bundle b;

    public BitmapDescriptor(Bitmap bitmap) {
        if (bitmap != null) {
            this.a = a(bitmap, bitmap.getWidth(), bitmap.getHeight());
        }
    }

    private Bitmap a(Bitmap bitmap, int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    public byte[] a() {
        ByteBuffer allocate = ByteBuffer.allocate(this.a.getWidth() * this.a.getHeight() * 4);
        this.a.copyPixelsToBuffer(allocate);
        return allocate.array();
    }

    public void clearCache() {
        Bundle bundle = this.b;
        if (bundle != null) {
            bundle.clear();
            this.b = null;
        }
    }

    public Bitmap getBitmap() {
        return this.a;
    }

    public void recycle() {
        Bitmap bitmap = this.a;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.a.recycle();
            this.a = null;
        }
    }

    public Bundle b() {
        if (this.a != null) {
            if (this.b == null) {
                Bundle bundle = new Bundle();
                bundle.putInt("image_width", this.a.getWidth());
                bundle.putInt("image_height", this.a.getHeight());
                byte[] a = a();
                bundle.putByteArray("image_data", a);
                MessageDigest messageDigest = null;
                try {
                    messageDigest = MessageDigest.getInstance("MD5");
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
                if (messageDigest != null) {
                    messageDigest.update(a, 0, a.length);
                    byte[] digest = messageDigest.digest();
                    StringBuilder sb = new StringBuilder("");
                    for (byte b : digest) {
                        sb.append(Integer.toString((b & 255) + 256, 16).substring(1));
                    }
                    bundle.putString("image_hashcode", sb.toString());
                }
                this.b = bundle;
            }
            return this.b;
        }
        throw new IllegalStateException("BDMapSDKException: the bitmap has been recycled! you can not use it again");
    }
}
