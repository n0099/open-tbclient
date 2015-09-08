package com.baidu.adp.widget.a;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    public static final Object Gl = new Object();
    private Bitmap Gc;
    private volatile boolean Gd;
    private boolean Ge;
    private byte[] Gf;
    private int Gg;
    private int Gh;
    private AtomicBoolean Gi;
    private com.baidu.adp.gif.b Gj;
    private boolean Gk;
    public Rect Gm;
    public C0014a Gn;
    public long timeStamp;
    private String url;

    /* renamed from: com.baidu.adp.widget.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0014a {
        public String Gp;
        public long Gq;
        public boolean Gr;
    }

    public a(Bitmap bitmap, boolean z) {
        this.Gc = null;
        this.Gd = false;
        this.Ge = true;
        this.Gf = null;
        this.Gg = -1;
        this.Gh = -1;
        this.Gi = new AtomicBoolean(false);
        this.Gk = false;
        this.timeStamp = -1L;
        this.Gn = new C0014a();
        this.Gc = bitmap;
        this.Gd = z;
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.Gc = null;
        this.Gd = false;
        this.Ge = true;
        this.Gf = null;
        this.Gg = -1;
        this.Gh = -1;
        this.Gi = new AtomicBoolean(false);
        this.Gk = false;
        this.timeStamp = -1L;
        this.Gn = new C0014a();
        this.Gc = bitmap;
        this.Gd = z;
        this.url = str;
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.Gc = null;
        this.Gd = false;
        this.Ge = true;
        this.Gf = null;
        this.Gg = -1;
        this.Gh = -1;
        this.Gi = new AtomicBoolean(false);
        this.Gk = false;
        this.timeStamp = -1L;
        this.Gn = new C0014a();
        this.Gc = bitmap;
        this.Gd = z;
        this.url = str;
        this.Gm = rect;
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.Gc = null;
        this.Gd = false;
        this.Ge = true;
        this.Gf = null;
        this.Gg = -1;
        this.Gh = -1;
        this.Gi = new AtomicBoolean(false);
        this.Gk = false;
        this.timeStamp = -1L;
        this.Gn = new C0014a();
        this.Gc = bitmap;
        this.Gd = z;
        this.url = str;
        this.Gf = bArr;
    }

    public a(com.baidu.adp.gif.b bVar) {
        this.Gc = null;
        this.Gd = false;
        this.Ge = true;
        this.Gf = null;
        this.Gg = -1;
        this.Gh = -1;
        this.Gi = new AtomicBoolean(false);
        this.Gk = false;
        this.timeStamp = -1L;
        this.Gn = new C0014a();
        this.Gj = bVar;
        this.Gk = true;
    }

    public boolean mX() {
        return this.Gk;
    }

    public com.baidu.adp.gif.b getGif() {
        return this.Gj;
    }

    public int getWidth() {
        if (this.Gc == null) {
            return 0;
        }
        return this.Gc.getWidth();
    }

    public int getHeight() {
        if (this.Gc == null) {
            return 0;
        }
        return this.Gc.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.Gc != null) {
            this.Gi.set(true);
            canvas.drawBitmap(this.Gc, matrix, paint);
            this.Gi.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.Gc != null) {
            this.Gi.set(true);
            canvas.drawBitmap(this.Gc, f, f2, paint);
            this.Gi.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.Gc != null) {
            this.Gi.set(true);
            canvas.drawBitmap(this.Gc, rect, rectF, paint);
            this.Gi.set(false);
        }
    }

    public void a(ImageView imageView) {
        if (imageView != null && this.Gc != null) {
            this.Ge = false;
            imageView.setImageBitmap(this.Gc);
        }
    }

    public boolean fF() {
        return this.Gd;
    }

    public int size() {
        if (this.Gc == null) {
            return 0;
        }
        return this.Gc.getHeight() * this.Gc.getRowBytes();
    }

    public boolean mY() {
        if (this.Ge && !this.Gi.get()) {
            if (this.Gc != null) {
                Bitmap bitmap = this.Gc;
                this.Gc = null;
                bitmap.recycle();
            }
            if (this.Gj != null) {
                com.baidu.adp.gif.b bVar = this.Gj;
                this.Gj = null;
                bVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap mZ() {
        this.Ge = false;
        return this.Gc;
    }

    public boolean na() {
        return this.Gc != null;
    }

    public BitmapDrawable nb() {
        if (this.Gc == null) {
            return null;
        }
        this.Ge = false;
        return new b(this, this.Gc);
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] nc() {
        byte[] byteArray;
        if (this.Gc == null) {
            return null;
        }
        synchronized (Gl) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.Gc.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect nd() {
        return this.Gm;
    }

    public byte[] ne() {
        return this.Gf;
    }

    public BitmapShader nf() {
        if (this.Gc == null) {
            return null;
        }
        this.Ge = false;
        return new BitmapShader(this.Gc, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void Q(boolean z) {
        this.Gi.set(z);
    }
}
