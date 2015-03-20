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
    public static final Object Gs = new Object();
    private volatile boolean Gk;
    private boolean Gl;
    private byte[] Gm;
    private int Gn;
    private int Go;
    private AtomicBoolean Gp;
    private com.baidu.adp.gif.c Gq;
    private boolean Gr;
    public Rect Gt;
    public c Gu;
    private Bitmap tY;
    public long timeStamp;
    private String url;

    public a(Bitmap bitmap, boolean z) {
        this.tY = null;
        this.Gk = false;
        this.Gl = true;
        this.Gm = null;
        this.Gn = -1;
        this.Go = -1;
        this.Gp = new AtomicBoolean(false);
        this.Gr = false;
        this.timeStamp = -1L;
        this.Gu = new c();
        this.tY = bitmap;
        this.Gk = z;
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.tY = null;
        this.Gk = false;
        this.Gl = true;
        this.Gm = null;
        this.Gn = -1;
        this.Go = -1;
        this.Gp = new AtomicBoolean(false);
        this.Gr = false;
        this.timeStamp = -1L;
        this.Gu = new c();
        this.tY = bitmap;
        this.Gk = z;
        this.url = str;
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.tY = null;
        this.Gk = false;
        this.Gl = true;
        this.Gm = null;
        this.Gn = -1;
        this.Go = -1;
        this.Gp = new AtomicBoolean(false);
        this.Gr = false;
        this.timeStamp = -1L;
        this.Gu = new c();
        this.tY = bitmap;
        this.Gk = z;
        this.url = str;
        this.Gt = rect;
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.tY = null;
        this.Gk = false;
        this.Gl = true;
        this.Gm = null;
        this.Gn = -1;
        this.Go = -1;
        this.Gp = new AtomicBoolean(false);
        this.Gr = false;
        this.timeStamp = -1L;
        this.Gu = new c();
        this.tY = bitmap;
        this.Gk = z;
        this.url = str;
        this.Gm = bArr;
    }

    public a(com.baidu.adp.gif.c cVar) {
        this.tY = null;
        this.Gk = false;
        this.Gl = true;
        this.Gm = null;
        this.Gn = -1;
        this.Go = -1;
        this.Gp = new AtomicBoolean(false);
        this.Gr = false;
        this.timeStamp = -1L;
        this.Gu = new c();
        this.Gq = cVar;
        this.Gr = true;
    }

    public boolean mx() {
        return this.Gr;
    }

    public com.baidu.adp.gif.c getGif() {
        return this.Gq;
    }

    public int getWidth() {
        if (this.tY == null) {
            return 0;
        }
        return this.tY.getWidth();
    }

    public int getHeight() {
        if (this.tY == null) {
            return 0;
        }
        return this.tY.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.tY != null) {
            this.Gp.set(true);
            canvas.drawBitmap(this.tY, matrix, paint);
            this.Gp.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.tY != null) {
            this.Gp.set(true);
            canvas.drawBitmap(this.tY, f, f2, paint);
            this.Gp.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.tY != null) {
            this.Gp.set(true);
            canvas.drawBitmap(this.tY, rect, rectF, paint);
            this.Gp.set(false);
        }
    }

    public void a(ImageView imageView) {
        if (imageView != null && this.tY != null) {
            this.Gl = false;
            imageView.setImageBitmap(this.tY);
        }
    }

    public boolean fI() {
        return this.Gk;
    }

    public int size() {
        if (this.tY == null) {
            return 0;
        }
        return this.tY.getHeight() * this.tY.getRowBytes();
    }

    public boolean my() {
        if (this.Gl && !this.Gp.get()) {
            if (this.tY != null) {
                Bitmap bitmap = this.tY;
                this.tY = null;
                bitmap.recycle();
            }
            if (this.Gq != null) {
                com.baidu.adp.gif.c cVar = this.Gq;
                this.Gq = null;
                cVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap mz() {
        this.Gl = false;
        return this.tY;
    }

    public boolean mA() {
        return this.tY != null;
    }

    public BitmapDrawable mB() {
        if (this.tY == null) {
            return null;
        }
        this.Gl = false;
        return new b(this, this.tY);
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] mC() {
        byte[] byteArray;
        if (this.tY == null) {
            return null;
        }
        synchronized (Gs) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.tY.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect mD() {
        return this.Gt;
    }

    public byte[] mE() {
        return this.Gm;
    }

    public BitmapShader mF() {
        if (this.tY == null) {
            return null;
        }
        this.Gl = false;
        return new BitmapShader(this.tY, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void N(boolean z) {
        this.Gp.set(z);
    }
}
