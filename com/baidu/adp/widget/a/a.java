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
    public static final Object lockForSyncImageDecoder = new Object();
    private Bitmap Hc;
    private volatile boolean Hd;
    private boolean He;
    private byte[] Hf;
    private int Hg;
    private int Hh;
    private AtomicBoolean Hi;
    private com.baidu.adp.gif.b Hj;
    private boolean Hk;
    public long Hl;
    public Rect Hm;
    private boolean Hn;
    private NinePatch Ho;
    public C0015a Hp;
    private String url;

    /* renamed from: com.baidu.adp.widget.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0015a {
        public String Hr;
        public long Hs;
        public boolean Ht;
    }

    public a(Bitmap bitmap, boolean z) {
        this.Hc = null;
        this.Hd = false;
        this.He = true;
        this.Hf = null;
        this.Hg = -1;
        this.Hh = -1;
        this.Hi = new AtomicBoolean(false);
        this.Hk = false;
        this.Hl = -1L;
        this.Hn = false;
        this.Hp = new C0015a();
        this.Hc = bitmap;
        this.Hd = z;
        mH();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.Hc = null;
        this.Hd = false;
        this.He = true;
        this.Hf = null;
        this.Hg = -1;
        this.Hh = -1;
        this.Hi = new AtomicBoolean(false);
        this.Hk = false;
        this.Hl = -1L;
        this.Hn = false;
        this.Hp = new C0015a();
        this.Hc = bitmap;
        this.Hd = z;
        this.url = str;
        mH();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.Hc = null;
        this.Hd = false;
        this.He = true;
        this.Hf = null;
        this.Hg = -1;
        this.Hh = -1;
        this.Hi = new AtomicBoolean(false);
        this.Hk = false;
        this.Hl = -1L;
        this.Hn = false;
        this.Hp = new C0015a();
        this.Hc = bitmap;
        this.Hd = z;
        this.url = str;
        this.Hm = rect;
        mH();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.Hc = null;
        this.Hd = false;
        this.He = true;
        this.Hf = null;
        this.Hg = -1;
        this.Hh = -1;
        this.Hi = new AtomicBoolean(false);
        this.Hk = false;
        this.Hl = -1L;
        this.Hn = false;
        this.Hp = new C0015a();
        this.Hc = bitmap;
        this.Hd = z;
        this.url = str;
        this.Hf = bArr;
        mH();
    }

    public a(com.baidu.adp.gif.b bVar) {
        this.Hc = null;
        this.Hd = false;
        this.He = true;
        this.Hf = null;
        this.Hg = -1;
        this.Hh = -1;
        this.Hi = new AtomicBoolean(false);
        this.Hk = false;
        this.Hl = -1L;
        this.Hn = false;
        this.Hp = new C0015a();
        this.Hj = bVar;
        this.Hk = true;
    }

    private void mH() {
        byte[] ninePatchChunk;
        if (this.Hc != null && (ninePatchChunk = this.Hc.getNinePatchChunk()) != null && ninePatchChunk.length > 0 && NinePatch.isNinePatchChunk(ninePatchChunk)) {
            this.Hn = true;
            this.Ho = new NinePatch(this.Hc, ninePatchChunk, TbConfig.TMP_PIC_DIR_NAME);
        }
    }

    public boolean mI() {
        return this.Hk;
    }

    public com.baidu.adp.gif.b getGif() {
        return this.Hj;
    }

    public int getWidth() {
        if (this.Hc == null) {
            return 0;
        }
        return this.Hc.getWidth();
    }

    public int getHeight() {
        if (this.Hc == null) {
            return 0;
        }
        return this.Hc.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.Hc != null) {
            this.Hi.set(true);
            canvas.drawBitmap(this.Hc, matrix, paint);
            this.Hi.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.Hc != null) {
            this.Hi.set(true);
            canvas.drawBitmap(this.Hc, f, f2, paint);
            this.Hi.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.Hc != null) {
            this.Hi.set(true);
            canvas.drawBitmap(this.Hc, rect, rectF, paint);
            this.Hi.set(false);
        }
    }

    public void a(ImageView imageView) {
        if (imageView != null && this.Hc != null) {
            this.He = false;
            imageView.setImageBitmap(this.Hc);
        }
    }

    public void a(Canvas canvas, RectF rectF) {
        if (this.Hn && this.Ho != null) {
            this.Ho.draw(canvas, rectF);
        }
    }

    public boolean fO() {
        return this.Hd;
    }

    public int size() {
        if (this.Hc == null) {
            return 0;
        }
        return this.Hc.getHeight() * this.Hc.getRowBytes();
    }

    public boolean mJ() {
        if (this.He && !this.Hi.get()) {
            if (this.Hc != null) {
                Bitmap bitmap = this.Hc;
                this.Hc = null;
                bitmap.recycle();
            }
            if (this.Hj != null) {
                com.baidu.adp.gif.b bVar = this.Hj;
                this.Hj = null;
                bVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap mK() {
        this.He = false;
        return this.Hc;
    }

    public boolean mL() {
        return this.Hc != null;
    }

    public BitmapDrawable mM() {
        if (this.Hc == null) {
            return null;
        }
        this.He = false;
        return new b(this, this.Hc);
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] mN() {
        byte[] byteArray;
        if (this.Hc == null) {
            return null;
        }
        synchronized (lockForSyncImageDecoder) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.Hc.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect mO() {
        return this.Hm;
    }

    public byte[] mP() {
        return this.Hf;
    }

    public BitmapShader mQ() {
        if (this.Hc == null) {
            return null;
        }
        this.He = false;
        return new BitmapShader(this.Hc, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void M(boolean z) {
        this.Hi.set(z);
    }

    public boolean mR() {
        return this.Hn;
    }
}
