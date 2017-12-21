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
import com.baidu.adp.gif.b;
import com.baidu.tbadk.TbConfig;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    public static final Object lockForSyncImageDecoder = new Object();
    private Bitmap Ga;
    private boolean Gb;
    private byte[] Gc;
    private int Gd;
    private int Ge;
    private AtomicBoolean Gf;
    private b Gg;
    private boolean Gh;
    public Rect Gi;
    private boolean Gj;
    private NinePatch Gk;
    public C0014a Gl;
    private volatile boolean isGif;
    public long timeStamp;
    private String url;

    /* renamed from: com.baidu.adp.widget.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0014a {
        public String Gn;
        public long Go;
        public boolean Gp;
    }

    public a(Bitmap bitmap, boolean z) {
        this.Ga = null;
        this.isGif = false;
        this.Gb = true;
        this.Gc = null;
        this.Gd = -1;
        this.Ge = -1;
        this.Gf = new AtomicBoolean(false);
        this.Gh = false;
        this.timeStamp = -1L;
        this.Gj = false;
        this.Gl = new C0014a();
        this.Ga = bitmap;
        this.isGif = z;
        kH();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.Ga = null;
        this.isGif = false;
        this.Gb = true;
        this.Gc = null;
        this.Gd = -1;
        this.Ge = -1;
        this.Gf = new AtomicBoolean(false);
        this.Gh = false;
        this.timeStamp = -1L;
        this.Gj = false;
        this.Gl = new C0014a();
        this.Ga = bitmap;
        this.isGif = z;
        this.url = str;
        kH();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.Ga = null;
        this.isGif = false;
        this.Gb = true;
        this.Gc = null;
        this.Gd = -1;
        this.Ge = -1;
        this.Gf = new AtomicBoolean(false);
        this.Gh = false;
        this.timeStamp = -1L;
        this.Gj = false;
        this.Gl = new C0014a();
        this.Ga = bitmap;
        this.isGif = z;
        this.url = str;
        this.Gi = rect;
        kH();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.Ga = null;
        this.isGif = false;
        this.Gb = true;
        this.Gc = null;
        this.Gd = -1;
        this.Ge = -1;
        this.Gf = new AtomicBoolean(false);
        this.Gh = false;
        this.timeStamp = -1L;
        this.Gj = false;
        this.Gl = new C0014a();
        this.Ga = bitmap;
        this.isGif = z;
        this.url = str;
        this.Gc = bArr;
        kH();
    }

    public a(b bVar, Bitmap bitmap, boolean z) {
        this.Ga = null;
        this.isGif = false;
        this.Gb = true;
        this.Gc = null;
        this.Gd = -1;
        this.Ge = -1;
        this.Gf = new AtomicBoolean(false);
        this.Gh = false;
        this.timeStamp = -1L;
        this.Gj = false;
        this.Gl = new C0014a();
        this.Gg = bVar;
        this.Ga = bitmap;
        this.isGif = z;
    }

    public a(b bVar) {
        this.Ga = null;
        this.isGif = false;
        this.Gb = true;
        this.Gc = null;
        this.Gd = -1;
        this.Ge = -1;
        this.Gf = new AtomicBoolean(false);
        this.Gh = false;
        this.timeStamp = -1L;
        this.Gj = false;
        this.Gl = new C0014a();
        this.Gg = bVar;
        this.Gh = true;
    }

    private void kH() {
        byte[] ninePatchChunk;
        if (this.Ga != null && (ninePatchChunk = this.Ga.getNinePatchChunk()) != null && ninePatchChunk.length > 0 && NinePatch.isNinePatchChunk(ninePatchChunk)) {
            this.Gj = true;
            this.Gk = new NinePatch(this.Ga, ninePatchChunk, TbConfig.TMP_PIC_DIR_NAME);
        }
    }

    public boolean kI() {
        return this.Gh;
    }

    public b getGif() {
        return this.Gg;
    }

    public int getWidth() {
        if (this.Ga == null) {
            return 0;
        }
        return this.Ga.getWidth();
    }

    public int getHeight() {
        if (this.Ga == null) {
            return 0;
        }
        return this.Ga.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.Ga != null) {
            this.Gf.set(true);
            canvas.drawBitmap(this.Ga, matrix, paint);
            this.Gf.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.Ga != null) {
            this.Gf.set(true);
            canvas.drawBitmap(this.Ga, f, f2, paint);
            this.Gf.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.Ga != null) {
            this.Gf.set(true);
            canvas.drawBitmap(this.Ga, rect, rectF, paint);
            this.Gf.set(false);
        }
    }

    public void a(ImageView imageView) {
        if (imageView != null && this.Ga != null) {
            this.Gb = false;
            imageView.setImageBitmap(this.Ga);
        }
    }

    public void a(Canvas canvas, RectF rectF) {
        if (this.Gj && this.Gk != null) {
            this.Gk.draw(canvas, rectF);
        }
    }

    public boolean isGif() {
        return this.isGif;
    }

    public int size() {
        if (this.Ga == null) {
            return 0;
        }
        return this.Ga.getHeight() * this.Ga.getRowBytes();
    }

    public boolean kJ() {
        if (this.Gb && !this.Gf.get()) {
            if (this.Ga != null) {
                Bitmap bitmap = this.Ga;
                this.Ga = null;
                bitmap.recycle();
            }
            if (this.Gg != null) {
                b bVar = this.Gg;
                this.Gg = null;
                bVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap kK() {
        this.Gb = false;
        return this.Ga;
    }

    public boolean kL() {
        return this.Ga != null;
    }

    public BitmapDrawable kM() {
        if (this.Ga == null) {
            return null;
        }
        this.Gb = false;
        return new BitmapDrawable(this.Ga) { // from class: com.baidu.adp.widget.a.a.1
            @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                Bitmap bitmap;
                if (a.this.Ga != null && (bitmap = getBitmap()) != null && !bitmap.isRecycled()) {
                    canvas.drawBitmap(a.this.Ga, (Rect) null, getBounds(), getPaint());
                }
            }
        };
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] kN() {
        byte[] byteArray;
        if (this.Ga == null) {
            return null;
        }
        synchronized (lockForSyncImageDecoder) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.Ga.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect kO() {
        return this.Gi;
    }

    public byte[] kP() {
        return this.Gc;
    }

    public BitmapShader kQ() {
        if (this.Ga == null) {
            return null;
        }
        this.Gb = false;
        return new BitmapShader(this.Ga, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void S(boolean z) {
        this.Gf.set(z);
    }

    public boolean kR() {
        return this.Gj;
    }
}
