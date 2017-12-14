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
    private Bitmap FZ;
    private boolean Ga;
    private byte[] Gb;
    private int Gc;
    private int Gd;
    private AtomicBoolean Ge;
    private b Gf;
    private boolean Gg;
    public Rect Gh;
    private boolean Gi;
    private NinePatch Gj;
    public C0014a Gk;
    private volatile boolean isGif;
    public long timeStamp;
    private String url;

    /* renamed from: com.baidu.adp.widget.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0014a {
        public String Gm;
        public long Gn;
        public boolean Go;
    }

    public a(Bitmap bitmap, boolean z) {
        this.FZ = null;
        this.isGif = false;
        this.Ga = true;
        this.Gb = null;
        this.Gc = -1;
        this.Gd = -1;
        this.Ge = new AtomicBoolean(false);
        this.Gg = false;
        this.timeStamp = -1L;
        this.Gi = false;
        this.Gk = new C0014a();
        this.FZ = bitmap;
        this.isGif = z;
        kH();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.FZ = null;
        this.isGif = false;
        this.Ga = true;
        this.Gb = null;
        this.Gc = -1;
        this.Gd = -1;
        this.Ge = new AtomicBoolean(false);
        this.Gg = false;
        this.timeStamp = -1L;
        this.Gi = false;
        this.Gk = new C0014a();
        this.FZ = bitmap;
        this.isGif = z;
        this.url = str;
        kH();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.FZ = null;
        this.isGif = false;
        this.Ga = true;
        this.Gb = null;
        this.Gc = -1;
        this.Gd = -1;
        this.Ge = new AtomicBoolean(false);
        this.Gg = false;
        this.timeStamp = -1L;
        this.Gi = false;
        this.Gk = new C0014a();
        this.FZ = bitmap;
        this.isGif = z;
        this.url = str;
        this.Gh = rect;
        kH();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.FZ = null;
        this.isGif = false;
        this.Ga = true;
        this.Gb = null;
        this.Gc = -1;
        this.Gd = -1;
        this.Ge = new AtomicBoolean(false);
        this.Gg = false;
        this.timeStamp = -1L;
        this.Gi = false;
        this.Gk = new C0014a();
        this.FZ = bitmap;
        this.isGif = z;
        this.url = str;
        this.Gb = bArr;
        kH();
    }

    public a(b bVar, Bitmap bitmap, boolean z) {
        this.FZ = null;
        this.isGif = false;
        this.Ga = true;
        this.Gb = null;
        this.Gc = -1;
        this.Gd = -1;
        this.Ge = new AtomicBoolean(false);
        this.Gg = false;
        this.timeStamp = -1L;
        this.Gi = false;
        this.Gk = new C0014a();
        this.Gf = bVar;
        this.FZ = bitmap;
        this.isGif = z;
    }

    public a(b bVar) {
        this.FZ = null;
        this.isGif = false;
        this.Ga = true;
        this.Gb = null;
        this.Gc = -1;
        this.Gd = -1;
        this.Ge = new AtomicBoolean(false);
        this.Gg = false;
        this.timeStamp = -1L;
        this.Gi = false;
        this.Gk = new C0014a();
        this.Gf = bVar;
        this.Gg = true;
    }

    private void kH() {
        byte[] ninePatchChunk;
        if (this.FZ != null && (ninePatchChunk = this.FZ.getNinePatchChunk()) != null && ninePatchChunk.length > 0 && NinePatch.isNinePatchChunk(ninePatchChunk)) {
            this.Gi = true;
            this.Gj = new NinePatch(this.FZ, ninePatchChunk, TbConfig.TMP_PIC_DIR_NAME);
        }
    }

    public boolean kI() {
        return this.Gg;
    }

    public b getGif() {
        return this.Gf;
    }

    public int getWidth() {
        if (this.FZ == null) {
            return 0;
        }
        return this.FZ.getWidth();
    }

    public int getHeight() {
        if (this.FZ == null) {
            return 0;
        }
        return this.FZ.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.FZ != null) {
            this.Ge.set(true);
            canvas.drawBitmap(this.FZ, matrix, paint);
            this.Ge.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.FZ != null) {
            this.Ge.set(true);
            canvas.drawBitmap(this.FZ, f, f2, paint);
            this.Ge.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.FZ != null) {
            this.Ge.set(true);
            canvas.drawBitmap(this.FZ, rect, rectF, paint);
            this.Ge.set(false);
        }
    }

    public void a(ImageView imageView) {
        if (imageView != null && this.FZ != null) {
            this.Ga = false;
            imageView.setImageBitmap(this.FZ);
        }
    }

    public void a(Canvas canvas, RectF rectF) {
        if (this.Gi && this.Gj != null) {
            this.Gj.draw(canvas, rectF);
        }
    }

    public boolean isGif() {
        return this.isGif;
    }

    public int size() {
        if (this.FZ == null) {
            return 0;
        }
        return this.FZ.getHeight() * this.FZ.getRowBytes();
    }

    public boolean kJ() {
        if (this.Ga && !this.Ge.get()) {
            if (this.FZ != null) {
                Bitmap bitmap = this.FZ;
                this.FZ = null;
                bitmap.recycle();
            }
            if (this.Gf != null) {
                b bVar = this.Gf;
                this.Gf = null;
                bVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap kK() {
        this.Ga = false;
        return this.FZ;
    }

    public boolean kL() {
        return this.FZ != null;
    }

    public BitmapDrawable kM() {
        if (this.FZ == null) {
            return null;
        }
        this.Ga = false;
        return new BitmapDrawable(this.FZ) { // from class: com.baidu.adp.widget.a.a.1
            @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                Bitmap bitmap;
                if (a.this.FZ != null && (bitmap = getBitmap()) != null && !bitmap.isRecycled()) {
                    canvas.drawBitmap(a.this.FZ, (Rect) null, getBounds(), getPaint());
                }
            }
        };
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] kN() {
        byte[] byteArray;
        if (this.FZ == null) {
            return null;
        }
        synchronized (lockForSyncImageDecoder) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.FZ.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect kO() {
        return this.Gh;
    }

    public byte[] kP() {
        return this.Gb;
    }

    public BitmapShader kQ() {
        if (this.FZ == null) {
            return null;
        }
        this.Ga = false;
        return new BitmapShader(this.FZ, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void S(boolean z) {
        this.Ge.set(z);
    }

    public boolean kR() {
        return this.Gi;
    }
}
