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
    private String url;
    private Bitmap xX;
    private volatile boolean xY;
    private boolean xZ;
    private byte[] ya;
    private int yb;
    private int yc;
    private AtomicBoolean yd;
    private com.baidu.adp.gif.b ye;
    private boolean yf;
    public long yg;
    public Rect yh;
    private boolean yi;
    private NinePatch yj;
    public C0015a yk;

    /* renamed from: com.baidu.adp.widget.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0015a {
        public String ym;
        public long yn;
        public boolean yo;
    }

    public a(Bitmap bitmap, boolean z) {
        this.xX = null;
        this.xY = false;
        this.xZ = true;
        this.ya = null;
        this.yb = -1;
        this.yc = -1;
        this.yd = new AtomicBoolean(false);
        this.yf = false;
        this.yg = -1L;
        this.yi = false;
        this.yk = new C0015a();
        this.xX = bitmap;
        this.xY = z;
        iX();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.xX = null;
        this.xY = false;
        this.xZ = true;
        this.ya = null;
        this.yb = -1;
        this.yc = -1;
        this.yd = new AtomicBoolean(false);
        this.yf = false;
        this.yg = -1L;
        this.yi = false;
        this.yk = new C0015a();
        this.xX = bitmap;
        this.xY = z;
        this.url = str;
        iX();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.xX = null;
        this.xY = false;
        this.xZ = true;
        this.ya = null;
        this.yb = -1;
        this.yc = -1;
        this.yd = new AtomicBoolean(false);
        this.yf = false;
        this.yg = -1L;
        this.yi = false;
        this.yk = new C0015a();
        this.xX = bitmap;
        this.xY = z;
        this.url = str;
        this.yh = rect;
        iX();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.xX = null;
        this.xY = false;
        this.xZ = true;
        this.ya = null;
        this.yb = -1;
        this.yc = -1;
        this.yd = new AtomicBoolean(false);
        this.yf = false;
        this.yg = -1L;
        this.yi = false;
        this.yk = new C0015a();
        this.xX = bitmap;
        this.xY = z;
        this.url = str;
        this.ya = bArr;
        iX();
    }

    public a(com.baidu.adp.gif.b bVar) {
        this.xX = null;
        this.xY = false;
        this.xZ = true;
        this.ya = null;
        this.yb = -1;
        this.yc = -1;
        this.yd = new AtomicBoolean(false);
        this.yf = false;
        this.yg = -1L;
        this.yi = false;
        this.yk = new C0015a();
        this.ye = bVar;
        this.yf = true;
    }

    private void iX() {
        byte[] ninePatchChunk;
        if (this.xX != null && (ninePatchChunk = this.xX.getNinePatchChunk()) != null && ninePatchChunk.length > 0 && NinePatch.isNinePatchChunk(ninePatchChunk)) {
            this.yi = true;
            this.yj = new NinePatch(this.xX, ninePatchChunk, TbConfig.TMP_PIC_DIR_NAME);
        }
    }

    public boolean iY() {
        return this.yf;
    }

    public com.baidu.adp.gif.b getGif() {
        return this.ye;
    }

    public int getWidth() {
        if (this.xX == null) {
            return 0;
        }
        return this.xX.getWidth();
    }

    public int getHeight() {
        if (this.xX == null) {
            return 0;
        }
        return this.xX.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.xX != null) {
            this.yd.set(true);
            canvas.drawBitmap(this.xX, matrix, paint);
            this.yd.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.xX != null) {
            this.yd.set(true);
            canvas.drawBitmap(this.xX, f, f2, paint);
            this.yd.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.xX != null) {
            this.yd.set(true);
            canvas.drawBitmap(this.xX, rect, rectF, paint);
            this.yd.set(false);
        }
    }

    public void e(ImageView imageView) {
        if (imageView != null && this.xX != null) {
            this.xZ = false;
            imageView.setImageBitmap(this.xX);
        }
    }

    public void a(Canvas canvas, RectF rectF) {
        if (this.yi && this.yj != null) {
            this.yj.draw(canvas, rectF);
        }
    }

    public boolean cd() {
        return this.xY;
    }

    public int size() {
        if (this.xX == null) {
            return 0;
        }
        return this.xX.getHeight() * this.xX.getRowBytes();
    }

    public boolean iZ() {
        if (this.xZ && !this.yd.get()) {
            if (this.xX != null) {
                Bitmap bitmap = this.xX;
                this.xX = null;
                bitmap.recycle();
            }
            if (this.ye != null) {
                com.baidu.adp.gif.b bVar = this.ye;
                this.ye = null;
                bVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap ja() {
        this.xZ = false;
        return this.xX;
    }

    public boolean jb() {
        return this.xX != null;
    }

    public BitmapDrawable jc() {
        if (this.xX == null) {
            return null;
        }
        this.xZ = false;
        return new b(this, this.xX);
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] jd() {
        byte[] byteArray;
        if (this.xX == null) {
            return null;
        }
        synchronized (lockForSyncImageDecoder) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.xX.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect je() {
        return this.yh;
    }

    public byte[] jf() {
        return this.ya;
    }

    public BitmapShader jg() {
        if (this.xX == null) {
            return null;
        }
        this.xZ = false;
        return new BitmapShader(this.xX, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void O(boolean z) {
        this.yd.set(z);
    }

    public boolean jh() {
        return this.yi;
    }
}
