package com.baidu.adp.widget.a;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.baidu.tbadk.TbConfig;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    public static final Object GC = new Object();
    private com.baidu.adp.gif.b GA;
    private boolean GB;
    public Rect GD;
    private boolean GE;
    private NinePatch GF;
    public C0014a GG;
    private Bitmap Gt;
    private volatile boolean Gu;
    private boolean Gv;
    private byte[] Gw;
    private int Gx;
    private int Gy;
    private AtomicBoolean Gz;
    public long timeStamp;
    private String url;

    /* renamed from: com.baidu.adp.widget.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0014a {
        public String GI;
        public long GJ;
        public boolean GK;
    }

    public a(Bitmap bitmap, boolean z) {
        this.Gt = null;
        this.Gu = false;
        this.Gv = true;
        this.Gw = null;
        this.Gx = -1;
        this.Gy = -1;
        this.Gz = new AtomicBoolean(false);
        this.GB = false;
        this.timeStamp = -1L;
        this.GE = false;
        this.GG = new C0014a();
        this.Gt = bitmap;
        this.Gu = z;
        nd();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.Gt = null;
        this.Gu = false;
        this.Gv = true;
        this.Gw = null;
        this.Gx = -1;
        this.Gy = -1;
        this.Gz = new AtomicBoolean(false);
        this.GB = false;
        this.timeStamp = -1L;
        this.GE = false;
        this.GG = new C0014a();
        this.Gt = bitmap;
        this.Gu = z;
        this.url = str;
        nd();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.Gt = null;
        this.Gu = false;
        this.Gv = true;
        this.Gw = null;
        this.Gx = -1;
        this.Gy = -1;
        this.Gz = new AtomicBoolean(false);
        this.GB = false;
        this.timeStamp = -1L;
        this.GE = false;
        this.GG = new C0014a();
        this.Gt = bitmap;
        this.Gu = z;
        this.url = str;
        this.GD = rect;
        nd();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.Gt = null;
        this.Gu = false;
        this.Gv = true;
        this.Gw = null;
        this.Gx = -1;
        this.Gy = -1;
        this.Gz = new AtomicBoolean(false);
        this.GB = false;
        this.timeStamp = -1L;
        this.GE = false;
        this.GG = new C0014a();
        this.Gt = bitmap;
        this.Gu = z;
        this.url = str;
        this.Gw = bArr;
        nd();
    }

    public a(com.baidu.adp.gif.b bVar) {
        this.Gt = null;
        this.Gu = false;
        this.Gv = true;
        this.Gw = null;
        this.Gx = -1;
        this.Gy = -1;
        this.Gz = new AtomicBoolean(false);
        this.GB = false;
        this.timeStamp = -1L;
        this.GE = false;
        this.GG = new C0014a();
        this.GA = bVar;
        this.GB = true;
    }

    private void nd() {
        byte[] ninePatchChunk;
        if (this.Gt != null && (ninePatchChunk = this.Gt.getNinePatchChunk()) != null && ninePatchChunk.length > 0 && NinePatch.isNinePatchChunk(ninePatchChunk)) {
            this.GE = true;
            this.GF = new NinePatch(this.Gt, ninePatchChunk, TbConfig.TMP_PIC_DIR_NAME);
        }
    }

    public boolean ne() {
        return this.GB;
    }

    public com.baidu.adp.gif.b getGif() {
        return this.GA;
    }

    public int getWidth() {
        if (this.Gt == null) {
            return 0;
        }
        return this.Gt.getWidth();
    }

    public int getHeight() {
        if (this.Gt == null) {
            return 0;
        }
        return this.Gt.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.Gt != null) {
            this.Gz.set(true);
            canvas.drawBitmap(this.Gt, matrix, paint);
            this.Gz.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.Gt != null) {
            this.Gz.set(true);
            canvas.drawBitmap(this.Gt, f, f2, paint);
            this.Gz.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.Gt != null) {
            this.Gz.set(true);
            canvas.drawBitmap(this.Gt, rect, rectF, paint);
            this.Gz.set(false);
        }
    }

    public void a(ImageView imageView) {
        if (imageView != null && this.Gt != null) {
            this.Gv = false;
            imageView.setImageBitmap(this.Gt);
        }
    }

    public void a(Canvas canvas, RectF rectF) {
        if (this.GE && this.GF != null) {
            this.GF.draw(canvas, rectF);
        }
    }

    public boolean fF() {
        return this.Gu;
    }

    public int size() {
        if (this.Gt == null) {
            return 0;
        }
        return this.Gt.getHeight() * this.Gt.getRowBytes();
    }

    public boolean nf() {
        if (this.Gv && !this.Gz.get()) {
            if (this.Gt != null) {
                Bitmap bitmap = this.Gt;
                this.Gt = null;
                bitmap.recycle();
            }
            if (this.GA != null) {
                com.baidu.adp.gif.b bVar = this.GA;
                this.GA = null;
                bVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap ng() {
        this.Gv = false;
        return this.Gt;
    }

    public boolean nh() {
        return this.Gt != null;
    }

    public BitmapDrawable ni() {
        if (this.Gt == null) {
            return null;
        }
        this.Gv = false;
        return new b(this, this.Gt);
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] nj() {
        byte[] byteArray;
        if (this.Gt == null) {
            return null;
        }
        synchronized (GC) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.Gt.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect nk() {
        return this.GD;
    }

    public byte[] nl() {
        return this.Gw;
    }

    public BitmapShader nm() {
        if (this.Gt == null) {
            return null;
        }
        this.Gv = false;
        return new BitmapShader(this.Gt, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void Q(boolean z) {
        this.Gz.set(z);
    }

    public boolean nn() {
        return this.GE;
    }
}
