package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import com.baidu.minivideo.plugin.capture.utils.EncryptUtils;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes15.dex */
public final class BitmapDescriptor {

    /* renamed from: a  reason: collision with root package name */
    Bitmap f2797a;

    /* renamed from: b  reason: collision with root package name */
    private Bundle f2798b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BitmapDescriptor(Bitmap bitmap) {
        if (bitmap != null) {
            this.f2797a = a(bitmap, bitmap.getWidth(), bitmap.getHeight());
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
        ByteBuffer allocate = ByteBuffer.allocate(this.f2797a.getWidth() * this.f2797a.getHeight() * 4);
        this.f2797a.copyPixelsToBuffer(allocate);
        return allocate.array();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle b() {
        MessageDigest messageDigest;
        if (this.f2797a == null) {
            throw new IllegalStateException("BDMapSDKException: the bitmap has been recycled! you can not use it again");
        }
        if (this.f2798b == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("image_width", this.f2797a.getWidth());
            bundle.putInt("image_height", this.f2797a.getHeight());
            byte[] a2 = a();
            bundle.putByteArray("image_data", a2);
            try {
                messageDigest = MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                messageDigest = null;
            }
            if (messageDigest != null) {
                messageDigest.update(a2, 0, a2.length);
                byte[] digest = messageDigest.digest();
                StringBuilder sb = new StringBuilder("");
                for (byte b2 : digest) {
                    sb.append(Integer.toString((b2 & 255) + 256, 16).substring(1));
                }
                bundle.putString("image_hashcode", sb.toString());
            }
            this.f2798b = bundle;
        }
        return this.f2798b;
    }

    public void clearCache() {
        if (this.f2798b != null) {
            this.f2798b.clear();
            this.f2798b = null;
        }
    }

    public Bitmap getBitmap() {
        return this.f2797a;
    }

    public void recycle() {
        if (this.f2797a == null || this.f2797a.isRecycled()) {
            return;
        }
        this.f2797a.recycle();
        this.f2797a = null;
    }
}
