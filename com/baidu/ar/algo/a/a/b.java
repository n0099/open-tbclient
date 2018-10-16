package com.baidu.ar.algo.a.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.renderscript.Type;
import android.util.Log;
import com.baidu.ar.algo.a.a.a;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class b {
    a a;
    float[] b = new float[76800];
    private boolean c = false;
    private int d = 0;
    private String e;
    private String f;
    private Context g;
    private RenderScript h;
    private ScriptIntrinsicYuvToRGB i;

    public b(Context context, String str, String str2, a aVar) {
        this.e = null;
        this.f = null;
        this.g = (Context) new WeakReference(context).get();
        this.e = str;
        this.f = str2;
        this.a = aVar;
        this.h = RenderScript.create(this.g);
        this.i = ScriptIntrinsicYuvToRGB.create(this.h, Element.RGBA_8888(this.h));
    }

    public static Bitmap a(Bitmap bitmap, double d, double d2) {
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(((float) d) / width, ((float) d2) / height);
        matrix.postRotate(90.0f);
        return Bitmap.createBitmap(bitmap, 0, 0, (int) width, (int) height, matrix, true);
    }

    private Bitmap a(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        matrix.setRotate(i, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
        try {
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            return null;
        }
    }

    public Bitmap a(int i, int i2, byte[] bArr) {
        Allocation createTyped = Allocation.createTyped(this.h, new Type.Builder(this.h, Element.U8(this.h)).setX(i).setY(i2).setYuvFormat(17).create(), 1);
        Allocation createTyped2 = Allocation.createTyped(this.h, new Type.Builder(this.h, Element.RGBA_8888(this.h)).setX(i).setY(i2).create(), 1);
        createTyped.copyFrom(bArr);
        this.i.setInput(createTyped);
        this.i.forEach(createTyped2);
        createTyped2.copyTo(new byte[i * i2 * 4]);
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        createTyped2.copyTo(createBitmap);
        return createBitmap;
    }

    public Bundle a(byte[] bArr, int i, int i2) {
        if (this.c && this.g != null) {
            try {
                Bitmap a = a(i, i2, bArr);
                Bitmap a2 = a(a, 160.0d, 160.0d);
                if (this.d == 1) {
                    a2 = a(a2, 180);
                }
                int allocationByteCount = (a2.getAllocationByteCount() * 3) / 4;
                if (this.b == null || this.b.length != allocationByteCount) {
                    this.b = new float[allocationByteCount];
                }
                a(this.b, a2);
                a.C0036a predictForFloatMatrix = this.a.predictForFloatMatrix(this.b, 160, 160, 3);
                float[] fArr = predictForFloatMatrix != null ? predictForFloatMatrix.a : null;
                Bundle bundle = new Bundle();
                bundle.putFloatArray("result", fArr);
                if (a != null && !a.isRecycled()) {
                    a.recycle();
                }
                if (a2 != null && !a2.isRecycled()) {
                    a2.recycle();
                }
                return bundle;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public void a(int i) {
        this.d = i;
    }

    public boolean a() {
        int init = this.a.init(this.e, this.f);
        Log.e("bdar", "Paddle init result:" + init);
        if (init == 0) {
            this.c = true;
            return true;
        }
        return false;
    }

    public float[] a(float[] fArr, Bitmap bitmap) {
        ByteBuffer allocate = ByteBuffer.allocate(bitmap.getByteCount());
        bitmap.copyPixelsToBuffer(allocate);
        byte[] array = allocate.array();
        int length = array.length / 4;
        for (int i = 0; i < array.length / 4; i++) {
            fArr[i] = (array[(i * 4) + 2] & 255) - 104.0f;
            fArr[i + length] = (array[(i * 4) + 1] & 255) - 117.0f;
            fArr[(length * 2) + i] = (array[i * 4] & 255) - 124.0f;
        }
        return fArr;
    }

    public boolean b() {
        if (this.a != null) {
            try {
                this.a.close();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                Log.e("bdar", "Paddle close Exception:" + e.getMessage());
                return false;
            }
        }
        return false;
    }

    public void c() {
        if (this.i != null) {
            this.i.destroy();
            this.i = null;
        }
        if (this.h != null) {
            this.h.finish();
            this.h.destroy();
            this.h = null;
        }
        if (this.g != null) {
            this.g = null;
        }
    }
}
