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
    public static final Object Gm = new Object();
    private Bitmap Gd;
    private volatile boolean Ge;
    private boolean Gf;
    private byte[] Gg;
    private int Gh;
    private int Gi;
    private AtomicBoolean Gj;
    private com.baidu.adp.gif.b Gk;
    private boolean Gl;
    public Rect Gn;
    public C0014a Go;
    public long timeStamp;
    private String url;

    /* renamed from: com.baidu.adp.widget.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0014a {
        public String Gq;
        public long Gr;
        public boolean Gs;
    }

    public a(Bitmap bitmap, boolean z) {
        this.Gd = null;
        this.Ge = false;
        this.Gf = true;
        this.Gg = null;
        this.Gh = -1;
        this.Gi = -1;
        this.Gj = new AtomicBoolean(false);
        this.Gl = false;
        this.timeStamp = -1L;
        this.Go = new C0014a();
        this.Gd = bitmap;
        this.Ge = z;
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.Gd = null;
        this.Ge = false;
        this.Gf = true;
        this.Gg = null;
        this.Gh = -1;
        this.Gi = -1;
        this.Gj = new AtomicBoolean(false);
        this.Gl = false;
        this.timeStamp = -1L;
        this.Go = new C0014a();
        this.Gd = bitmap;
        this.Ge = z;
        this.url = str;
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.Gd = null;
        this.Ge = false;
        this.Gf = true;
        this.Gg = null;
        this.Gh = -1;
        this.Gi = -1;
        this.Gj = new AtomicBoolean(false);
        this.Gl = false;
        this.timeStamp = -1L;
        this.Go = new C0014a();
        this.Gd = bitmap;
        this.Ge = z;
        this.url = str;
        this.Gn = rect;
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.Gd = null;
        this.Ge = false;
        this.Gf = true;
        this.Gg = null;
        this.Gh = -1;
        this.Gi = -1;
        this.Gj = new AtomicBoolean(false);
        this.Gl = false;
        this.timeStamp = -1L;
        this.Go = new C0014a();
        this.Gd = bitmap;
        this.Ge = z;
        this.url = str;
        this.Gg = bArr;
    }

    public a(com.baidu.adp.gif.b bVar) {
        this.Gd = null;
        this.Ge = false;
        this.Gf = true;
        this.Gg = null;
        this.Gh = -1;
        this.Gi = -1;
        this.Gj = new AtomicBoolean(false);
        this.Gl = false;
        this.timeStamp = -1L;
        this.Go = new C0014a();
        this.Gk = bVar;
        this.Gl = true;
    }

    public boolean mY() {
        return this.Gl;
    }

    public com.baidu.adp.gif.b getGif() {
        return this.Gk;
    }

    public int getWidth() {
        if (this.Gd == null) {
            return 0;
        }
        return this.Gd.getWidth();
    }

    public int getHeight() {
        if (this.Gd == null) {
            return 0;
        }
        return this.Gd.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.Gd != null) {
            this.Gj.set(true);
            canvas.drawBitmap(this.Gd, matrix, paint);
            this.Gj.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.Gd != null) {
            this.Gj.set(true);
            canvas.drawBitmap(this.Gd, f, f2, paint);
            this.Gj.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.Gd != null) {
            this.Gj.set(true);
            canvas.drawBitmap(this.Gd, rect, rectF, paint);
            this.Gj.set(false);
        }
    }

    public void a(ImageView imageView) {
        if (imageView != null && this.Gd != null) {
            this.Gf = false;
            imageView.setImageBitmap(this.Gd);
        }
    }

    public boolean fF() {
        return this.Ge;
    }

    public int size() {
        if (this.Gd == null) {
            return 0;
        }
        return this.Gd.getHeight() * this.Gd.getRowBytes();
    }

    public boolean mZ() {
        if (this.Gf && !this.Gj.get()) {
            if (this.Gd != null) {
                Bitmap bitmap = this.Gd;
                this.Gd = null;
                bitmap.recycle();
            }
            if (this.Gk != null) {
                com.baidu.adp.gif.b bVar = this.Gk;
                this.Gk = null;
                bVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap na() {
        this.Gf = false;
        return this.Gd;
    }

    public boolean nb() {
        return this.Gd != null;
    }

    public BitmapDrawable nc() {
        if (this.Gd == null) {
            return null;
        }
        this.Gf = false;
        return new b(this, this.Gd);
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] nd() {
        byte[] byteArray;
        if (this.Gd == null) {
            return null;
        }
        synchronized (Gm) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.Gd.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect ne() {
        return this.Gn;
    }

    public byte[] nf() {
        return this.Gg;
    }

    public BitmapShader ng() {
        if (this.Gd == null) {
            return null;
        }
        this.Gf = false;
        return new BitmapShader(this.Gd, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void Q(boolean z) {
        this.Gj.set(z);
    }
}
