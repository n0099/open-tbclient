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
    private Bitmap Gm;
    private boolean Gn;
    private byte[] Go;
    private int Gp;
    private int Gq;
    private AtomicBoolean Gr;
    private b Gs;
    private boolean Gt;
    public Rect Gu;
    private boolean Gv;
    private NinePatch Gw;
    public C0014a Gx;
    private volatile boolean isGif;
    public long timeStamp;
    private String url;

    /* renamed from: com.baidu.adp.widget.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0014a {
        public long GA;
        public boolean GB;
        public String Gz;
    }

    public a(Bitmap bitmap, boolean z) {
        this.Gm = null;
        this.isGif = false;
        this.Gn = true;
        this.Go = null;
        this.Gp = -1;
        this.Gq = -1;
        this.Gr = new AtomicBoolean(false);
        this.Gt = false;
        this.timeStamp = -1L;
        this.Gv = false;
        this.Gx = new C0014a();
        this.Gm = bitmap;
        this.isGif = z;
        kL();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.Gm = null;
        this.isGif = false;
        this.Gn = true;
        this.Go = null;
        this.Gp = -1;
        this.Gq = -1;
        this.Gr = new AtomicBoolean(false);
        this.Gt = false;
        this.timeStamp = -1L;
        this.Gv = false;
        this.Gx = new C0014a();
        this.Gm = bitmap;
        this.isGif = z;
        this.url = str;
        kL();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.Gm = null;
        this.isGif = false;
        this.Gn = true;
        this.Go = null;
        this.Gp = -1;
        this.Gq = -1;
        this.Gr = new AtomicBoolean(false);
        this.Gt = false;
        this.timeStamp = -1L;
        this.Gv = false;
        this.Gx = new C0014a();
        this.Gm = bitmap;
        this.isGif = z;
        this.url = str;
        this.Gu = rect;
        kL();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.Gm = null;
        this.isGif = false;
        this.Gn = true;
        this.Go = null;
        this.Gp = -1;
        this.Gq = -1;
        this.Gr = new AtomicBoolean(false);
        this.Gt = false;
        this.timeStamp = -1L;
        this.Gv = false;
        this.Gx = new C0014a();
        this.Gm = bitmap;
        this.isGif = z;
        this.url = str;
        this.Go = bArr;
        kL();
    }

    public a(b bVar) {
        this.Gm = null;
        this.isGif = false;
        this.Gn = true;
        this.Go = null;
        this.Gp = -1;
        this.Gq = -1;
        this.Gr = new AtomicBoolean(false);
        this.Gt = false;
        this.timeStamp = -1L;
        this.Gv = false;
        this.Gx = new C0014a();
        this.Gs = bVar;
        this.Gt = true;
    }

    private void kL() {
        byte[] ninePatchChunk;
        if (this.Gm != null && (ninePatchChunk = this.Gm.getNinePatchChunk()) != null && ninePatchChunk.length > 0 && NinePatch.isNinePatchChunk(ninePatchChunk)) {
            this.Gv = true;
            this.Gw = new NinePatch(this.Gm, ninePatchChunk, TbConfig.TMP_PIC_DIR_NAME);
        }
    }

    public boolean kM() {
        return this.Gt;
    }

    public b getGif() {
        return this.Gs;
    }

    public int getWidth() {
        if (this.Gm == null) {
            return 0;
        }
        return this.Gm.getWidth();
    }

    public int getHeight() {
        if (this.Gm == null) {
            return 0;
        }
        return this.Gm.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.Gm != null) {
            this.Gr.set(true);
            canvas.drawBitmap(this.Gm, matrix, paint);
            this.Gr.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.Gm != null) {
            this.Gr.set(true);
            canvas.drawBitmap(this.Gm, f, f2, paint);
            this.Gr.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.Gm != null) {
            this.Gr.set(true);
            canvas.drawBitmap(this.Gm, rect, rectF, paint);
            this.Gr.set(false);
        }
    }

    public void a(ImageView imageView) {
        if (imageView != null && this.Gm != null) {
            this.Gn = false;
            imageView.setImageBitmap(this.Gm);
        }
    }

    public void a(Canvas canvas, RectF rectF) {
        if (this.Gv && this.Gw != null) {
            this.Gw.draw(canvas, rectF);
        }
    }

    public boolean isGif() {
        return this.isGif;
    }

    public int size() {
        if (this.Gm == null) {
            return 0;
        }
        return this.Gm.getHeight() * this.Gm.getRowBytes();
    }

    public boolean kN() {
        if (this.Gn && !this.Gr.get()) {
            if (this.Gm != null) {
                Bitmap bitmap = this.Gm;
                this.Gm = null;
                bitmap.recycle();
            }
            if (this.Gs != null) {
                b bVar = this.Gs;
                this.Gs = null;
                bVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap kO() {
        this.Gn = false;
        return this.Gm;
    }

    public boolean kP() {
        return this.Gm != null;
    }

    public BitmapDrawable kQ() {
        if (this.Gm == null) {
            return null;
        }
        this.Gn = false;
        return new BitmapDrawable(this.Gm) { // from class: com.baidu.adp.widget.a.a.1
            @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                Bitmap bitmap;
                if (a.this.Gm != null && (bitmap = getBitmap()) != null && !bitmap.isRecycled()) {
                    canvas.drawBitmap(a.this.Gm, (Rect) null, getBounds(), getPaint());
                }
            }
        };
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] kR() {
        byte[] byteArray;
        if (this.Gm == null) {
            return null;
        }
        synchronized (lockForSyncImageDecoder) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.Gm.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect kS() {
        return this.Gu;
    }

    public byte[] kT() {
        return this.Go;
    }

    public BitmapShader kU() {
        if (this.Gm == null) {
            return null;
        }
        this.Gn = false;
        return new BitmapShader(this.Gm, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void S(boolean z) {
        this.Gr.set(z);
    }

    public boolean kV() {
        return this.Gv;
    }
}
