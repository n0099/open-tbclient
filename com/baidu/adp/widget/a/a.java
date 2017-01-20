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
    private volatile boolean Aa;
    private boolean Ab;
    private byte[] Ac;
    private int Ae;
    private int Af;
    private AtomicBoolean Ag;
    private com.baidu.adp.gif.b Ah;
    private boolean Ai;
    public long Aj;
    public Rect Ak;
    private boolean Al;
    private NinePatch Am;
    public C0014a An;
    private String url;
    private Bitmap zZ;

    /* renamed from: com.baidu.adp.widget.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0014a {
        public String Ap;
        public long Aq;
        public boolean Ar;
    }

    public a(Bitmap bitmap, boolean z) {
        this.zZ = null;
        this.Aa = false;
        this.Ab = true;
        this.Ac = null;
        this.Ae = -1;
        this.Af = -1;
        this.Ag = new AtomicBoolean(false);
        this.Ai = false;
        this.Aj = -1L;
        this.Al = false;
        this.An = new C0014a();
        this.zZ = bitmap;
        this.Aa = z;
        jQ();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.zZ = null;
        this.Aa = false;
        this.Ab = true;
        this.Ac = null;
        this.Ae = -1;
        this.Af = -1;
        this.Ag = new AtomicBoolean(false);
        this.Ai = false;
        this.Aj = -1L;
        this.Al = false;
        this.An = new C0014a();
        this.zZ = bitmap;
        this.Aa = z;
        this.url = str;
        jQ();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.zZ = null;
        this.Aa = false;
        this.Ab = true;
        this.Ac = null;
        this.Ae = -1;
        this.Af = -1;
        this.Ag = new AtomicBoolean(false);
        this.Ai = false;
        this.Aj = -1L;
        this.Al = false;
        this.An = new C0014a();
        this.zZ = bitmap;
        this.Aa = z;
        this.url = str;
        this.Ak = rect;
        jQ();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.zZ = null;
        this.Aa = false;
        this.Ab = true;
        this.Ac = null;
        this.Ae = -1;
        this.Af = -1;
        this.Ag = new AtomicBoolean(false);
        this.Ai = false;
        this.Aj = -1L;
        this.Al = false;
        this.An = new C0014a();
        this.zZ = bitmap;
        this.Aa = z;
        this.url = str;
        this.Ac = bArr;
        jQ();
    }

    public a(com.baidu.adp.gif.b bVar) {
        this.zZ = null;
        this.Aa = false;
        this.Ab = true;
        this.Ac = null;
        this.Ae = -1;
        this.Af = -1;
        this.Ag = new AtomicBoolean(false);
        this.Ai = false;
        this.Aj = -1L;
        this.Al = false;
        this.An = new C0014a();
        this.Ah = bVar;
        this.Ai = true;
    }

    private void jQ() {
        byte[] ninePatchChunk;
        if (this.zZ != null && (ninePatchChunk = this.zZ.getNinePatchChunk()) != null && ninePatchChunk.length > 0 && NinePatch.isNinePatchChunk(ninePatchChunk)) {
            this.Al = true;
            this.Am = new NinePatch(this.zZ, ninePatchChunk, TbConfig.TMP_PIC_DIR_NAME);
        }
    }

    public boolean jR() {
        return this.Ai;
    }

    public com.baidu.adp.gif.b getGif() {
        return this.Ah;
    }

    public int getWidth() {
        if (this.zZ == null) {
            return 0;
        }
        return this.zZ.getWidth();
    }

    public int getHeight() {
        if (this.zZ == null) {
            return 0;
        }
        return this.zZ.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.zZ != null) {
            this.Ag.set(true);
            canvas.drawBitmap(this.zZ, matrix, paint);
            this.Ag.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.zZ != null) {
            this.Ag.set(true);
            canvas.drawBitmap(this.zZ, f, f2, paint);
            this.Ag.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.zZ != null) {
            this.Ag.set(true);
            canvas.drawBitmap(this.zZ, rect, rectF, paint);
            this.Ag.set(false);
        }
    }

    public void e(ImageView imageView) {
        if (imageView != null && this.zZ != null) {
            this.Ab = false;
            imageView.setImageBitmap(this.zZ);
        }
    }

    public void a(Canvas canvas, RectF rectF) {
        if (this.Al && this.Am != null) {
            this.Am.draw(canvas, rectF);
        }
    }

    public boolean cW() {
        return this.Aa;
    }

    public int size() {
        if (this.zZ == null) {
            return 0;
        }
        return this.zZ.getHeight() * this.zZ.getRowBytes();
    }

    public boolean jS() {
        if (this.Ab && !this.Ag.get()) {
            if (this.zZ != null) {
                Bitmap bitmap = this.zZ;
                this.zZ = null;
                bitmap.recycle();
            }
            if (this.Ah != null) {
                com.baidu.adp.gif.b bVar = this.Ah;
                this.Ah = null;
                bVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap jT() {
        this.Ab = false;
        return this.zZ;
    }

    public boolean jU() {
        return this.zZ != null;
    }

    public BitmapDrawable jV() {
        if (this.zZ == null) {
            return null;
        }
        this.Ab = false;
        return new b(this, this.zZ);
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] jW() {
        byte[] byteArray;
        if (this.zZ == null) {
            return null;
        }
        synchronized (lockForSyncImageDecoder) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.zZ.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect jX() {
        return this.Ak;
    }

    public byte[] jY() {
        return this.Ac;
    }

    public BitmapShader jZ() {
        if (this.zZ == null) {
            return null;
        }
        this.Ab = false;
        return new BitmapShader(this.zZ, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void Q(boolean z) {
        this.Ag.set(z);
    }

    public boolean ka() {
        return this.Al;
    }
}
