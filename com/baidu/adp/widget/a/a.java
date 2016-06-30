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
    private int xA;
    private int xB;
    private AtomicBoolean xC;
    private com.baidu.adp.gif.b xD;
    private boolean xE;
    public long xF;
    public Rect xG;
    private boolean xH;
    private NinePatch xI;
    public C0015a xJ;
    private Bitmap xw;
    private volatile boolean xx;
    private boolean xy;
    private byte[] xz;

    /* renamed from: com.baidu.adp.widget.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0015a {
        public String xL;
        public long xM;
        public boolean xN;
    }

    public a(Bitmap bitmap, boolean z) {
        this.xw = null;
        this.xx = false;
        this.xy = true;
        this.xz = null;
        this.xA = -1;
        this.xB = -1;
        this.xC = new AtomicBoolean(false);
        this.xE = false;
        this.xF = -1L;
        this.xH = false;
        this.xJ = new C0015a();
        this.xw = bitmap;
        this.xx = z;
        iY();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.xw = null;
        this.xx = false;
        this.xy = true;
        this.xz = null;
        this.xA = -1;
        this.xB = -1;
        this.xC = new AtomicBoolean(false);
        this.xE = false;
        this.xF = -1L;
        this.xH = false;
        this.xJ = new C0015a();
        this.xw = bitmap;
        this.xx = z;
        this.url = str;
        iY();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.xw = null;
        this.xx = false;
        this.xy = true;
        this.xz = null;
        this.xA = -1;
        this.xB = -1;
        this.xC = new AtomicBoolean(false);
        this.xE = false;
        this.xF = -1L;
        this.xH = false;
        this.xJ = new C0015a();
        this.xw = bitmap;
        this.xx = z;
        this.url = str;
        this.xG = rect;
        iY();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.xw = null;
        this.xx = false;
        this.xy = true;
        this.xz = null;
        this.xA = -1;
        this.xB = -1;
        this.xC = new AtomicBoolean(false);
        this.xE = false;
        this.xF = -1L;
        this.xH = false;
        this.xJ = new C0015a();
        this.xw = bitmap;
        this.xx = z;
        this.url = str;
        this.xz = bArr;
        iY();
    }

    public a(com.baidu.adp.gif.b bVar) {
        this.xw = null;
        this.xx = false;
        this.xy = true;
        this.xz = null;
        this.xA = -1;
        this.xB = -1;
        this.xC = new AtomicBoolean(false);
        this.xE = false;
        this.xF = -1L;
        this.xH = false;
        this.xJ = new C0015a();
        this.xD = bVar;
        this.xE = true;
    }

    private void iY() {
        byte[] ninePatchChunk;
        if (this.xw != null && (ninePatchChunk = this.xw.getNinePatchChunk()) != null && ninePatchChunk.length > 0 && NinePatch.isNinePatchChunk(ninePatchChunk)) {
            this.xH = true;
            this.xI = new NinePatch(this.xw, ninePatchChunk, TbConfig.TMP_PIC_DIR_NAME);
        }
    }

    public boolean iZ() {
        return this.xE;
    }

    public com.baidu.adp.gif.b getGif() {
        return this.xD;
    }

    public int getWidth() {
        if (this.xw == null) {
            return 0;
        }
        return this.xw.getWidth();
    }

    public int getHeight() {
        if (this.xw == null) {
            return 0;
        }
        return this.xw.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.xw != null) {
            this.xC.set(true);
            canvas.drawBitmap(this.xw, matrix, paint);
            this.xC.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.xw != null) {
            this.xC.set(true);
            canvas.drawBitmap(this.xw, f, f2, paint);
            this.xC.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.xw != null) {
            this.xC.set(true);
            canvas.drawBitmap(this.xw, rect, rectF, paint);
            this.xC.set(false);
        }
    }

    public void a(ImageView imageView) {
        if (imageView != null && this.xw != null) {
            this.xy = false;
            imageView.setImageBitmap(this.xw);
        }
    }

    public void a(Canvas canvas, RectF rectF) {
        if (this.xH && this.xI != null) {
            this.xI.draw(canvas, rectF);
        }
    }

    public boolean ce() {
        return this.xx;
    }

    public int size() {
        if (this.xw == null) {
            return 0;
        }
        return this.xw.getHeight() * this.xw.getRowBytes();
    }

    public boolean ja() {
        if (this.xy && !this.xC.get()) {
            if (this.xw != null) {
                Bitmap bitmap = this.xw;
                this.xw = null;
                bitmap.recycle();
            }
            if (this.xD != null) {
                com.baidu.adp.gif.b bVar = this.xD;
                this.xD = null;
                bVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap jb() {
        this.xy = false;
        return this.xw;
    }

    public boolean jc() {
        return this.xw != null;
    }

    public BitmapDrawable jd() {
        if (this.xw == null) {
            return null;
        }
        this.xy = false;
        return new b(this, this.xw);
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] je() {
        byte[] byteArray;
        if (this.xw == null) {
            return null;
        }
        synchronized (lockForSyncImageDecoder) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.xw.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect jf() {
        return this.xG;
    }

    public byte[] jg() {
        return this.xz;
    }

    public BitmapShader jh() {
        if (this.xw == null) {
            return null;
        }
        this.xy = false;
        return new BitmapShader(this.xw, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void M(boolean z) {
        this.xC.set(z);
    }

    public boolean ji() {
        return this.xH;
    }
}
