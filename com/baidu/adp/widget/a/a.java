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
    public static final Object GT = new Object();
    private Bitmap GJ;
    private volatile boolean GK;
    private boolean GL;
    private byte[] GM;
    private int GN;
    private int GP;
    private AtomicBoolean GQ;
    private com.baidu.adp.gif.b GR;
    private boolean GS;
    public Rect GU;
    private boolean GV;
    private NinePatch GW;
    public C0015a GX;
    public long timeStamp;
    private String url;

    /* renamed from: com.baidu.adp.widget.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0015a {
        public String GZ;
        public long Ha;
        public boolean Hb;
    }

    public a(Bitmap bitmap, boolean z) {
        this.GJ = null;
        this.GK = false;
        this.GL = true;
        this.GM = null;
        this.GN = -1;
        this.GP = -1;
        this.GQ = new AtomicBoolean(false);
        this.GS = false;
        this.timeStamp = -1L;
        this.GV = false;
        this.GX = new C0015a();
        this.GJ = bitmap;
        this.GK = z;
        mB();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.GJ = null;
        this.GK = false;
        this.GL = true;
        this.GM = null;
        this.GN = -1;
        this.GP = -1;
        this.GQ = new AtomicBoolean(false);
        this.GS = false;
        this.timeStamp = -1L;
        this.GV = false;
        this.GX = new C0015a();
        this.GJ = bitmap;
        this.GK = z;
        this.url = str;
        mB();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.GJ = null;
        this.GK = false;
        this.GL = true;
        this.GM = null;
        this.GN = -1;
        this.GP = -1;
        this.GQ = new AtomicBoolean(false);
        this.GS = false;
        this.timeStamp = -1L;
        this.GV = false;
        this.GX = new C0015a();
        this.GJ = bitmap;
        this.GK = z;
        this.url = str;
        this.GU = rect;
        mB();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.GJ = null;
        this.GK = false;
        this.GL = true;
        this.GM = null;
        this.GN = -1;
        this.GP = -1;
        this.GQ = new AtomicBoolean(false);
        this.GS = false;
        this.timeStamp = -1L;
        this.GV = false;
        this.GX = new C0015a();
        this.GJ = bitmap;
        this.GK = z;
        this.url = str;
        this.GM = bArr;
        mB();
    }

    public a(com.baidu.adp.gif.b bVar) {
        this.GJ = null;
        this.GK = false;
        this.GL = true;
        this.GM = null;
        this.GN = -1;
        this.GP = -1;
        this.GQ = new AtomicBoolean(false);
        this.GS = false;
        this.timeStamp = -1L;
        this.GV = false;
        this.GX = new C0015a();
        this.GR = bVar;
        this.GS = true;
    }

    private void mB() {
        byte[] ninePatchChunk;
        if (this.GJ != null && (ninePatchChunk = this.GJ.getNinePatchChunk()) != null && ninePatchChunk.length > 0 && NinePatch.isNinePatchChunk(ninePatchChunk)) {
            this.GV = true;
            this.GW = new NinePatch(this.GJ, ninePatchChunk, TbConfig.TMP_PIC_DIR_NAME);
        }
    }

    public boolean mC() {
        return this.GS;
    }

    public com.baidu.adp.gif.b getGif() {
        return this.GR;
    }

    public int getWidth() {
        if (this.GJ == null) {
            return 0;
        }
        return this.GJ.getWidth();
    }

    public int getHeight() {
        if (this.GJ == null) {
            return 0;
        }
        return this.GJ.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.GJ != null) {
            this.GQ.set(true);
            canvas.drawBitmap(this.GJ, matrix, paint);
            this.GQ.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.GJ != null) {
            this.GQ.set(true);
            canvas.drawBitmap(this.GJ, f, f2, paint);
            this.GQ.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.GJ != null) {
            this.GQ.set(true);
            canvas.drawBitmap(this.GJ, rect, rectF, paint);
            this.GQ.set(false);
        }
    }

    public void a(ImageView imageView) {
        if (imageView != null && this.GJ != null) {
            this.GL = false;
            imageView.setImageBitmap(this.GJ);
        }
    }

    public void a(Canvas canvas, RectF rectF) {
        if (this.GV && this.GW != null) {
            this.GW.draw(canvas, rectF);
        }
    }

    public boolean fF() {
        return this.GK;
    }

    public int size() {
        if (this.GJ == null) {
            return 0;
        }
        return this.GJ.getHeight() * this.GJ.getRowBytes();
    }

    public boolean mD() {
        if (this.GL && !this.GQ.get()) {
            if (this.GJ != null) {
                Bitmap bitmap = this.GJ;
                this.GJ = null;
                bitmap.recycle();
            }
            if (this.GR != null) {
                com.baidu.adp.gif.b bVar = this.GR;
                this.GR = null;
                bVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap mE() {
        this.GL = false;
        return this.GJ;
    }

    public boolean mF() {
        return this.GJ != null;
    }

    public BitmapDrawable mG() {
        if (this.GJ == null) {
            return null;
        }
        this.GL = false;
        return new b(this, this.GJ);
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] mH() {
        byte[] byteArray;
        if (this.GJ == null) {
            return null;
        }
        synchronized (GT) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.GJ.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect mI() {
        return this.GU;
    }

    public byte[] mJ() {
        return this.GM;
    }

    public BitmapShader mK() {
        if (this.GJ == null) {
            return null;
        }
        this.GL = false;
        return new BitmapShader(this.GJ, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void N(boolean z) {
        this.GQ.set(z);
    }

    public boolean mL() {
        return this.GV;
    }
}
