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
    public static final Object Gu = new Object();
    private volatile boolean Gm;
    private boolean Gn;
    private byte[] Go;
    private int Gp;
    private int Gq;
    private AtomicBoolean Gr;
    private com.baidu.adp.gif.c Gs;
    private boolean Gt;
    public Rect Gv;
    public c Gw;
    private Bitmap tY;
    public long timeStamp;
    private String url;

    public a(Bitmap bitmap, boolean z) {
        this.tY = null;
        this.Gm = false;
        this.Gn = true;
        this.Go = null;
        this.Gp = -1;
        this.Gq = -1;
        this.Gr = new AtomicBoolean(false);
        this.Gt = false;
        this.timeStamp = -1L;
        this.Gw = new c();
        this.tY = bitmap;
        this.Gm = z;
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.tY = null;
        this.Gm = false;
        this.Gn = true;
        this.Go = null;
        this.Gp = -1;
        this.Gq = -1;
        this.Gr = new AtomicBoolean(false);
        this.Gt = false;
        this.timeStamp = -1L;
        this.Gw = new c();
        this.tY = bitmap;
        this.Gm = z;
        this.url = str;
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.tY = null;
        this.Gm = false;
        this.Gn = true;
        this.Go = null;
        this.Gp = -1;
        this.Gq = -1;
        this.Gr = new AtomicBoolean(false);
        this.Gt = false;
        this.timeStamp = -1L;
        this.Gw = new c();
        this.tY = bitmap;
        this.Gm = z;
        this.url = str;
        this.Gv = rect;
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.tY = null;
        this.Gm = false;
        this.Gn = true;
        this.Go = null;
        this.Gp = -1;
        this.Gq = -1;
        this.Gr = new AtomicBoolean(false);
        this.Gt = false;
        this.timeStamp = -1L;
        this.Gw = new c();
        this.tY = bitmap;
        this.Gm = z;
        this.url = str;
        this.Go = bArr;
    }

    public a(com.baidu.adp.gif.c cVar) {
        this.tY = null;
        this.Gm = false;
        this.Gn = true;
        this.Go = null;
        this.Gp = -1;
        this.Gq = -1;
        this.Gr = new AtomicBoolean(false);
        this.Gt = false;
        this.timeStamp = -1L;
        this.Gw = new c();
        this.Gs = cVar;
        this.Gt = true;
    }

    public boolean mx() {
        return this.Gt;
    }

    public com.baidu.adp.gif.c getGif() {
        return this.Gs;
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
            this.Gr.set(true);
            canvas.drawBitmap(this.tY, matrix, paint);
            this.Gr.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.tY != null) {
            this.Gr.set(true);
            canvas.drawBitmap(this.tY, f, f2, paint);
            this.Gr.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.tY != null) {
            this.Gr.set(true);
            canvas.drawBitmap(this.tY, rect, rectF, paint);
            this.Gr.set(false);
        }
    }

    public void a(ImageView imageView) {
        if (imageView != null && this.tY != null) {
            this.Gn = false;
            imageView.setImageBitmap(this.tY);
        }
    }

    public boolean fI() {
        return this.Gm;
    }

    public int size() {
        if (this.tY == null) {
            return 0;
        }
        return this.tY.getHeight() * this.tY.getRowBytes();
    }

    public boolean my() {
        if (this.Gn && !this.Gr.get()) {
            if (this.tY != null) {
                Bitmap bitmap = this.tY;
                this.tY = null;
                bitmap.recycle();
            }
            if (this.Gs != null) {
                com.baidu.adp.gif.c cVar = this.Gs;
                this.Gs = null;
                cVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap mz() {
        this.Gn = false;
        return this.tY;
    }

    public boolean mA() {
        return this.tY != null;
    }

    public BitmapDrawable mB() {
        if (this.tY == null) {
            return null;
        }
        this.Gn = false;
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
        synchronized (Gu) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.tY.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect mD() {
        return this.Gv;
    }

    public byte[] mE() {
        return this.Go;
    }

    public BitmapShader mF() {
        if (this.tY == null) {
            return null;
        }
        this.Gn = false;
        return new BitmapShader(this.tY, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void N(boolean z) {
        this.Gr.set(z);
    }
}
