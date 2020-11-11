package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes7.dex */
public final class BitmapDescriptor {

    /* renamed from: a  reason: collision with root package name */
    Bitmap f1999a;
    private Bundle b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BitmapDescriptor(Bitmap bitmap) {
        if (bitmap != null) {
            this.f1999a = a(bitmap, bitmap.getWidth(), bitmap.getHeight());
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

    byte[] a() {
        ByteBuffer allocate = ByteBuffer.allocate(this.f1999a.getWidth() * this.f1999a.getHeight() * 4);
        this.f1999a.copyPixelsToBuffer(allocate);
        return allocate.array();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle b() {
        MessageDigest messageDigest;
        if (this.f1999a == null) {
            throw new IllegalStateException("BDMapSDKException: the bitmap has been recycled! you can not use it again");
        }
        if (this.b == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("image_width", this.f1999a.getWidth());
            bundle.putInt("image_height", this.f1999a.getHeight());
            byte[] a2 = a();
            bundle.putByteArray("image_data", a2);
            try {
                messageDigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                messageDigest = null;
            }
            if (messageDigest != null) {
                messageDigest.update(a2, 0, a2.length);
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

    public void clearCache() {
        if (this.b != null) {
            this.b.clear();
            this.b = null;
        }
    }

    public Bitmap getBitmap() {
        return this.f1999a;
    }

    public void recycle() {
        if (this.f1999a == null || this.f1999a.isRecycled()) {
            return;
        }
        this.f1999a.recycle();
        this.f1999a = null;
    }
}
