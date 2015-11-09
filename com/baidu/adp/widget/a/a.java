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
    public static final Object Gn = new Object();
    private Bitmap Ge;
    private volatile boolean Gf;
    private boolean Gg;
    private byte[] Gh;
    private int Gi;
    private int Gj;
    private AtomicBoolean Gk;
    private com.baidu.adp.gif.b Gl;
    private boolean Gm;
    public Rect Go;
    public C0014a Gp;
    public long timeStamp;
    private String url;

    /* renamed from: com.baidu.adp.widget.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0014a {
        public String Gr;
        public long Gs;
        public boolean Gt;
    }

    public a(Bitmap bitmap, boolean z) {
        this.Ge = null;
        this.Gf = false;
        this.Gg = true;
        this.Gh = null;
        this.Gi = -1;
        this.Gj = -1;
        this.Gk = new AtomicBoolean(false);
        this.Gm = false;
        this.timeStamp = -1L;
        this.Gp = new C0014a();
        this.Ge = bitmap;
        this.Gf = z;
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.Ge = null;
        this.Gf = false;
        this.Gg = true;
        this.Gh = null;
        this.Gi = -1;
        this.Gj = -1;
        this.Gk = new AtomicBoolean(false);
        this.Gm = false;
        this.timeStamp = -1L;
        this.Gp = new C0014a();
        this.Ge = bitmap;
        this.Gf = z;
        this.url = str;
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.Ge = null;
        this.Gf = false;
        this.Gg = true;
        this.Gh = null;
        this.Gi = -1;
        this.Gj = -1;
        this.Gk = new AtomicBoolean(false);
        this.Gm = false;
        this.timeStamp = -1L;
        this.Gp = new C0014a();
        this.Ge = bitmap;
        this.Gf = z;
        this.url = str;
        this.Go = rect;
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.Ge = null;
        this.Gf = false;
        this.Gg = true;
        this.Gh = null;
        this.Gi = -1;
        this.Gj = -1;
        this.Gk = new AtomicBoolean(false);
        this.Gm = false;
        this.timeStamp = -1L;
        this.Gp = new C0014a();
        this.Ge = bitmap;
        this.Gf = z;
        this.url = str;
        this.Gh = bArr;
    }

    public a(com.baidu.adp.gif.b bVar) {
        this.Ge = null;
        this.Gf = false;
        this.Gg = true;
        this.Gh = null;
        this.Gi = -1;
        this.Gj = -1;
        this.Gk = new AtomicBoolean(false);
        this.Gm = false;
        this.timeStamp = -1L;
        this.Gp = new C0014a();
        this.Gl = bVar;
        this.Gm = true;
    }

    public boolean mZ() {
        return this.Gm;
    }

    public com.baidu.adp.gif.b getGif() {
        return this.Gl;
    }

    public int getWidth() {
        if (this.Ge == null) {
            return 0;
        }
        return this.Ge.getWidth();
    }

    public int getHeight() {
        if (this.Ge == null) {
            return 0;
        }
        return this.Ge.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.Ge != null) {
            this.Gk.set(true);
            canvas.drawBitmap(this.Ge, matrix, paint);
            this.Gk.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.Ge != null) {
            this.Gk.set(true);
            canvas.drawBitmap(this.Ge, f, f2, paint);
            this.Gk.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.Ge != null) {
            this.Gk.set(true);
            canvas.drawBitmap(this.Ge, rect, rectF, paint);
            this.Gk.set(false);
        }
    }

    public void a(ImageView imageView) {
        if (imageView != null && this.Ge != null) {
            this.Gg = false;
            imageView.setImageBitmap(this.Ge);
        }
    }

    public boolean fF() {
        return this.Gf;
    }

    public int size() {
        if (this.Ge == null) {
            return 0;
        }
        return this.Ge.getHeight() * this.Ge.getRowBytes();
    }

    public boolean na() {
        if (this.Gg && !this.Gk.get()) {
            if (this.Ge != null) {
                Bitmap bitmap = this.Ge;
                this.Ge = null;
                bitmap.recycle();
            }
            if (this.Gl != null) {
                com.baidu.adp.gif.b bVar = this.Gl;
                this.Gl = null;
                bVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap nb() {
        this.Gg = false;
        return this.Ge;
    }

    public boolean nc() {
        return this.Ge != null;
    }

    public BitmapDrawable nd() {
        if (this.Ge == null) {
            return null;
        }
        this.Gg = false;
        return new b(this, this.Ge);
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] ne() {
        byte[] byteArray;
        if (this.Ge == null) {
            return null;
        }
        synchronized (Gn) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.Ge.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect nf() {
        return this.Go;
    }

    public byte[] ng() {
        return this.Gh;
    }

    public BitmapShader nh() {
        if (this.Ge == null) {
            return null;
        }
        this.Gg = false;
        return new BitmapShader(this.Ge, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void Q(boolean z) {
        this.Gk.set(z);
    }
}
