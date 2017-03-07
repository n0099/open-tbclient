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
    public C0013a HA;
    private Bitmap Hn;
    private volatile boolean Ho;
    private boolean Hp;
    private byte[] Hq;
    private int Hr;
    private int Hs;
    private AtomicBoolean Ht;
    private com.baidu.adp.gif.b Hu;
    private boolean Hv;
    public long Hw;
    public Rect Hx;
    private boolean Hy;
    private NinePatch Hz;
    private String url;

    /* renamed from: com.baidu.adp.widget.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0013a {
        public String HC;
        public long HD;
        public boolean HE;
    }

    public a(Bitmap bitmap, boolean z) {
        this.Hn = null;
        this.Ho = false;
        this.Hp = true;
        this.Hq = null;
        this.Hr = -1;
        this.Hs = -1;
        this.Ht = new AtomicBoolean(false);
        this.Hv = false;
        this.Hw = -1L;
        this.Hy = false;
        this.HA = new C0013a();
        this.Hn = bitmap;
        this.Ho = z;
        kK();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.Hn = null;
        this.Ho = false;
        this.Hp = true;
        this.Hq = null;
        this.Hr = -1;
        this.Hs = -1;
        this.Ht = new AtomicBoolean(false);
        this.Hv = false;
        this.Hw = -1L;
        this.Hy = false;
        this.HA = new C0013a();
        this.Hn = bitmap;
        this.Ho = z;
        this.url = str;
        kK();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.Hn = null;
        this.Ho = false;
        this.Hp = true;
        this.Hq = null;
        this.Hr = -1;
        this.Hs = -1;
        this.Ht = new AtomicBoolean(false);
        this.Hv = false;
        this.Hw = -1L;
        this.Hy = false;
        this.HA = new C0013a();
        this.Hn = bitmap;
        this.Ho = z;
        this.url = str;
        this.Hx = rect;
        kK();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.Hn = null;
        this.Ho = false;
        this.Hp = true;
        this.Hq = null;
        this.Hr = -1;
        this.Hs = -1;
        this.Ht = new AtomicBoolean(false);
        this.Hv = false;
        this.Hw = -1L;
        this.Hy = false;
        this.HA = new C0013a();
        this.Hn = bitmap;
        this.Ho = z;
        this.url = str;
        this.Hq = bArr;
        kK();
    }

    public a(com.baidu.adp.gif.b bVar) {
        this.Hn = null;
        this.Ho = false;
        this.Hp = true;
        this.Hq = null;
        this.Hr = -1;
        this.Hs = -1;
        this.Ht = new AtomicBoolean(false);
        this.Hv = false;
        this.Hw = -1L;
        this.Hy = false;
        this.HA = new C0013a();
        this.Hu = bVar;
        this.Hv = true;
    }

    private void kK() {
        byte[] ninePatchChunk;
        if (this.Hn != null && (ninePatchChunk = this.Hn.getNinePatchChunk()) != null && ninePatchChunk.length > 0 && NinePatch.isNinePatchChunk(ninePatchChunk)) {
            this.Hy = true;
            this.Hz = new NinePatch(this.Hn, ninePatchChunk, TbConfig.TMP_PIC_DIR_NAME);
        }
    }

    public boolean kL() {
        return this.Hv;
    }

    public com.baidu.adp.gif.b getGif() {
        return this.Hu;
    }

    public int getWidth() {
        if (this.Hn == null) {
            return 0;
        }
        return this.Hn.getWidth();
    }

    public int getHeight() {
        if (this.Hn == null) {
            return 0;
        }
        return this.Hn.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.Hn != null) {
            this.Ht.set(true);
            canvas.drawBitmap(this.Hn, matrix, paint);
            this.Ht.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.Hn != null) {
            this.Ht.set(true);
            canvas.drawBitmap(this.Hn, f, f2, paint);
            this.Ht.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.Hn != null) {
            this.Ht.set(true);
            canvas.drawBitmap(this.Hn, rect, rectF, paint);
            this.Ht.set(false);
        }
    }

    public void e(ImageView imageView) {
        if (imageView != null && this.Hn != null) {
            this.Hp = false;
            imageView.setImageBitmap(this.Hn);
        }
    }

    public void a(Canvas canvas, RectF rectF) {
        if (this.Hy && this.Hz != null) {
            this.Hz.draw(canvas, rectF);
        }
    }

    public boolean ef() {
        return this.Ho;
    }

    public int size() {
        if (this.Hn == null) {
            return 0;
        }
        return this.Hn.getHeight() * this.Hn.getRowBytes();
    }

    public boolean kM() {
        if (this.Hp && !this.Ht.get()) {
            if (this.Hn != null) {
                Bitmap bitmap = this.Hn;
                this.Hn = null;
                bitmap.recycle();
            }
            if (this.Hu != null) {
                com.baidu.adp.gif.b bVar = this.Hu;
                this.Hu = null;
                bVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap kN() {
        this.Hp = false;
        return this.Hn;
    }

    public boolean kO() {
        return this.Hn != null;
    }

    public BitmapDrawable kP() {
        if (this.Hn == null) {
            return null;
        }
        this.Hp = false;
        return new b(this, this.Hn);
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] kQ() {
        byte[] byteArray;
        if (this.Hn == null) {
            return null;
        }
        synchronized (lockForSyncImageDecoder) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.Hn.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect kR() {
        return this.Hx;
    }

    public byte[] kS() {
        return this.Hq;
    }

    public BitmapShader kT() {
        if (this.Hn == null) {
            return null;
        }
        this.Hp = false;
        return new BitmapShader(this.Hn, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void R(boolean z) {
        this.Ht.set(z);
    }

    public boolean kU() {
        return this.Hy;
    }
}
