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
    private AtomicBoolean xA;
    private com.baidu.adp.gif.b xB;
    private boolean xC;
    public long xD;
    public Rect xE;
    private boolean xF;
    private NinePatch xG;
    public C0015a xH;
    private Bitmap xu;
    private volatile boolean xv;
    private boolean xw;
    private byte[] xx;
    private int xy;
    private int xz;

    /* renamed from: com.baidu.adp.widget.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0015a {
        public String xJ;
        public long xK;
        public boolean xL;
    }

    public a(Bitmap bitmap, boolean z) {
        this.xu = null;
        this.xv = false;
        this.xw = true;
        this.xx = null;
        this.xy = -1;
        this.xz = -1;
        this.xA = new AtomicBoolean(false);
        this.xC = false;
        this.xD = -1L;
        this.xF = false;
        this.xH = new C0015a();
        this.xu = bitmap;
        this.xv = z;
        iV();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.xu = null;
        this.xv = false;
        this.xw = true;
        this.xx = null;
        this.xy = -1;
        this.xz = -1;
        this.xA = new AtomicBoolean(false);
        this.xC = false;
        this.xD = -1L;
        this.xF = false;
        this.xH = new C0015a();
        this.xu = bitmap;
        this.xv = z;
        this.url = str;
        iV();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.xu = null;
        this.xv = false;
        this.xw = true;
        this.xx = null;
        this.xy = -1;
        this.xz = -1;
        this.xA = new AtomicBoolean(false);
        this.xC = false;
        this.xD = -1L;
        this.xF = false;
        this.xH = new C0015a();
        this.xu = bitmap;
        this.xv = z;
        this.url = str;
        this.xE = rect;
        iV();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.xu = null;
        this.xv = false;
        this.xw = true;
        this.xx = null;
        this.xy = -1;
        this.xz = -1;
        this.xA = new AtomicBoolean(false);
        this.xC = false;
        this.xD = -1L;
        this.xF = false;
        this.xH = new C0015a();
        this.xu = bitmap;
        this.xv = z;
        this.url = str;
        this.xx = bArr;
        iV();
    }

    public a(com.baidu.adp.gif.b bVar) {
        this.xu = null;
        this.xv = false;
        this.xw = true;
        this.xx = null;
        this.xy = -1;
        this.xz = -1;
        this.xA = new AtomicBoolean(false);
        this.xC = false;
        this.xD = -1L;
        this.xF = false;
        this.xH = new C0015a();
        this.xB = bVar;
        this.xC = true;
    }

    private void iV() {
        byte[] ninePatchChunk;
        if (this.xu != null && (ninePatchChunk = this.xu.getNinePatchChunk()) != null && ninePatchChunk.length > 0 && NinePatch.isNinePatchChunk(ninePatchChunk)) {
            this.xF = true;
            this.xG = new NinePatch(this.xu, ninePatchChunk, TbConfig.TMP_PIC_DIR_NAME);
        }
    }

    public boolean iW() {
        return this.xC;
    }

    public com.baidu.adp.gif.b getGif() {
        return this.xB;
    }

    public int getWidth() {
        if (this.xu == null) {
            return 0;
        }
        return this.xu.getWidth();
    }

    public int getHeight() {
        if (this.xu == null) {
            return 0;
        }
        return this.xu.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.xu != null) {
            this.xA.set(true);
            canvas.drawBitmap(this.xu, matrix, paint);
            this.xA.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.xu != null) {
            this.xA.set(true);
            canvas.drawBitmap(this.xu, f, f2, paint);
            this.xA.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.xu != null) {
            this.xA.set(true);
            canvas.drawBitmap(this.xu, rect, rectF, paint);
            this.xA.set(false);
        }
    }

    public void a(ImageView imageView) {
        if (imageView != null && this.xu != null) {
            this.xw = false;
            imageView.setImageBitmap(this.xu);
        }
    }

    public void a(Canvas canvas, RectF rectF) {
        if (this.xF && this.xG != null) {
            this.xG.draw(canvas, rectF);
        }
    }

    public boolean cd() {
        return this.xv;
    }

    public int size() {
        if (this.xu == null) {
            return 0;
        }
        return this.xu.getHeight() * this.xu.getRowBytes();
    }

    public boolean iX() {
        if (this.xw && !this.xA.get()) {
            if (this.xu != null) {
                Bitmap bitmap = this.xu;
                this.xu = null;
                bitmap.recycle();
            }
            if (this.xB != null) {
                com.baidu.adp.gif.b bVar = this.xB;
                this.xB = null;
                bVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap iY() {
        this.xw = false;
        return this.xu;
    }

    public boolean iZ() {
        return this.xu != null;
    }

    public BitmapDrawable ja() {
        if (this.xu == null) {
            return null;
        }
        this.xw = false;
        return new b(this, this.xu);
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] jb() {
        byte[] byteArray;
        if (this.xu == null) {
            return null;
        }
        synchronized (lockForSyncImageDecoder) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.xu.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect jc() {
        return this.xE;
    }

    public byte[] jd() {
        return this.xx;
    }

    public BitmapShader je() {
        if (this.xu == null) {
            return null;
        }
        this.xw = false;
        return new BitmapShader(this.xu, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void M(boolean z) {
        this.xA.set(z);
    }

    public boolean jf() {
        return this.xF;
    }
}
