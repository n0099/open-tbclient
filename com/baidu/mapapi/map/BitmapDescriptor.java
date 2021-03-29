package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes2.dex */
public final class BitmapDescriptor {

    /* renamed from: a  reason: collision with root package name */
    public Bitmap f6823a;

    /* renamed from: b  reason: collision with root package name */
    public Bundle f6824b;

    public BitmapDescriptor(Bitmap bitmap) {
        if (bitmap != null) {
            this.f6823a = a(bitmap, bitmap.getWidth(), bitmap.getHeight());
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
        ByteBuffer allocate = ByteBuffer.allocate(this.f6823a.getWidth() * this.f6823a.getHeight() * 4);
        this.f6823a.copyPixelsToBuffer(allocate);
        return allocate.array();
    }

    public Bundle b() {
        if (this.f6823a != null) {
            if (this.f6824b == null) {
                Bundle bundle = new Bundle();
                bundle.putInt("image_width", this.f6823a.getWidth());
                bundle.putInt("image_height", this.f6823a.getHeight());
                byte[] a2 = a();
                bundle.putByteArray("image_data", a2);
                MessageDigest messageDigest = null;
                try {
                    messageDigest = MessageDigest.getInstance("MD5");
                } catch (NoSuchAlgorithmException e2) {
                    e2.printStackTrace();
                }
                messageDigest.update(a2, 0, a2.length);
                byte[] digest = messageDigest.digest();
                StringBuilder sb = new StringBuilder("");
                for (byte b2 : digest) {
                    sb.append(Integer.toString((b2 & 255) + 256, 16).substring(1));
                }
                bundle.putString("image_hashcode", sb.toString());
                this.f6824b = bundle;
            }
            return this.f6824b;
        }
        throw new IllegalStateException("the bitmap has been recycled! you can not use it again");
    }

    public Bitmap getBitmap() {
        return this.f6823a;
    }

    public void recycle() {
        Bitmap bitmap = this.f6823a;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.f6823a.recycle();
        this.f6823a = null;
    }
}
