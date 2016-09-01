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
    private Bitmap Ak;
    private volatile boolean Al;
    private boolean Am;
    private byte[] An;
    private int Ao;
    private int Ap;
    private AtomicBoolean Aq;
    private com.baidu.adp.gif.b Ar;
    private boolean As;
    public long At;
    public Rect Au;
    private boolean Av;
    private NinePatch Aw;
    public C0015a Ax;
    private String url;

    /* renamed from: com.baidu.adp.widget.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0015a {
        public long AA;
        public boolean AB;
        public String Az;
    }

    public a(Bitmap bitmap, boolean z) {
        this.Ak = null;
        this.Al = false;
        this.Am = true;
        this.An = null;
        this.Ao = -1;
        this.Ap = -1;
        this.Aq = new AtomicBoolean(false);
        this.As = false;
        this.At = -1L;
        this.Av = false;
        this.Ax = new C0015a();
        this.Ak = bitmap;
        this.Al = z;
        jS();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.Ak = null;
        this.Al = false;
        this.Am = true;
        this.An = null;
        this.Ao = -1;
        this.Ap = -1;
        this.Aq = new AtomicBoolean(false);
        this.As = false;
        this.At = -1L;
        this.Av = false;
        this.Ax = new C0015a();
        this.Ak = bitmap;
        this.Al = z;
        this.url = str;
        jS();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.Ak = null;
        this.Al = false;
        this.Am = true;
        this.An = null;
        this.Ao = -1;
        this.Ap = -1;
        this.Aq = new AtomicBoolean(false);
        this.As = false;
        this.At = -1L;
        this.Av = false;
        this.Ax = new C0015a();
        this.Ak = bitmap;
        this.Al = z;
        this.url = str;
        this.Au = rect;
        jS();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.Ak = null;
        this.Al = false;
        this.Am = true;
        this.An = null;
        this.Ao = -1;
        this.Ap = -1;
        this.Aq = new AtomicBoolean(false);
        this.As = false;
        this.At = -1L;
        this.Av = false;
        this.Ax = new C0015a();
        this.Ak = bitmap;
        this.Al = z;
        this.url = str;
        this.An = bArr;
        jS();
    }

    public a(com.baidu.adp.gif.b bVar) {
        this.Ak = null;
        this.Al = false;
        this.Am = true;
        this.An = null;
        this.Ao = -1;
        this.Ap = -1;
        this.Aq = new AtomicBoolean(false);
        this.As = false;
        this.At = -1L;
        this.Av = false;
        this.Ax = new C0015a();
        this.Ar = bVar;
        this.As = true;
    }

    private void jS() {
        byte[] ninePatchChunk;
        if (this.Ak != null && (ninePatchChunk = this.Ak.getNinePatchChunk()) != null && ninePatchChunk.length > 0 && NinePatch.isNinePatchChunk(ninePatchChunk)) {
            this.Av = true;
            this.Aw = new NinePatch(this.Ak, ninePatchChunk, TbConfig.TMP_PIC_DIR_NAME);
        }
    }

    public boolean jT() {
        return this.As;
    }

    public com.baidu.adp.gif.b getGif() {
        return this.Ar;
    }

    public int getWidth() {
        if (this.Ak == null) {
            return 0;
        }
        return this.Ak.getWidth();
    }

    public int getHeight() {
        if (this.Ak == null) {
            return 0;
        }
        return this.Ak.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.Ak != null) {
            this.Aq.set(true);
            canvas.drawBitmap(this.Ak, matrix, paint);
            this.Aq.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.Ak != null) {
            this.Aq.set(true);
            canvas.drawBitmap(this.Ak, f, f2, paint);
            this.Aq.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.Ak != null) {
            this.Aq.set(true);
            canvas.drawBitmap(this.Ak, rect, rectF, paint);
            this.Aq.set(false);
        }
    }

    public void e(ImageView imageView) {
        if (imageView != null && this.Ak != null) {
            this.Am = false;
            imageView.setImageBitmap(this.Ak);
        }
    }

    public void a(Canvas canvas, RectF rectF) {
        if (this.Av && this.Aw != null) {
            this.Aw.draw(canvas, rectF);
        }
    }

    public boolean cY() {
        return this.Al;
    }

    public int size() {
        if (this.Ak == null) {
            return 0;
        }
        return this.Ak.getHeight() * this.Ak.getRowBytes();
    }

    public boolean jU() {
        if (this.Am && !this.Aq.get()) {
            if (this.Ak != null) {
                Bitmap bitmap = this.Ak;
                this.Ak = null;
                bitmap.recycle();
            }
            if (this.Ar != null) {
                com.baidu.adp.gif.b bVar = this.Ar;
                this.Ar = null;
                bVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap jV() {
        this.Am = false;
        return this.Ak;
    }

    public boolean jW() {
        return this.Ak != null;
    }

    public BitmapDrawable jX() {
        if (this.Ak == null) {
            return null;
        }
        this.Am = false;
        return new b(this, this.Ak);
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] jY() {
        byte[] byteArray;
        if (this.Ak == null) {
            return null;
        }
        synchronized (lockForSyncImageDecoder) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.Ak.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect jZ() {
        return this.Au;
    }

    public byte[] ka() {
        return this.An;
    }

    public BitmapShader kb() {
        if (this.Ak == null) {
            return null;
        }
        this.Am = false;
        return new BitmapShader(this.Ak, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void Q(boolean z) {
        this.Aq.set(z);
    }

    public boolean kc() {
        return this.Av;
    }
}
