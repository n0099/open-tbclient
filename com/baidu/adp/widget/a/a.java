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
    private Bitmap GR;
    private boolean GS;
    private byte[] GT;
    private int GU;
    private int GV;
    private AtomicBoolean GW;
    private com.baidu.adp.gif.b GX;
    private boolean GY;
    public Rect GZ;
    private boolean Ha;
    private NinePatch Hb;
    public C0013a Hc;
    private volatile boolean isGif;
    public long timeStamp;
    private String url;

    /* renamed from: com.baidu.adp.widget.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0013a {
        public String He;
        public long Hf;
        public boolean Hg;
    }

    public a(Bitmap bitmap, boolean z) {
        this.GR = null;
        this.isGif = false;
        this.GS = true;
        this.GT = null;
        this.GU = -1;
        this.GV = -1;
        this.GW = new AtomicBoolean(false);
        this.GY = false;
        this.timeStamp = -1L;
        this.Ha = false;
        this.Hc = new C0013a();
        this.GR = bitmap;
        this.isGif = z;
        kM();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.GR = null;
        this.isGif = false;
        this.GS = true;
        this.GT = null;
        this.GU = -1;
        this.GV = -1;
        this.GW = new AtomicBoolean(false);
        this.GY = false;
        this.timeStamp = -1L;
        this.Ha = false;
        this.Hc = new C0013a();
        this.GR = bitmap;
        this.isGif = z;
        this.url = str;
        kM();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.GR = null;
        this.isGif = false;
        this.GS = true;
        this.GT = null;
        this.GU = -1;
        this.GV = -1;
        this.GW = new AtomicBoolean(false);
        this.GY = false;
        this.timeStamp = -1L;
        this.Ha = false;
        this.Hc = new C0013a();
        this.GR = bitmap;
        this.isGif = z;
        this.url = str;
        this.GZ = rect;
        kM();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.GR = null;
        this.isGif = false;
        this.GS = true;
        this.GT = null;
        this.GU = -1;
        this.GV = -1;
        this.GW = new AtomicBoolean(false);
        this.GY = false;
        this.timeStamp = -1L;
        this.Ha = false;
        this.Hc = new C0013a();
        this.GR = bitmap;
        this.isGif = z;
        this.url = str;
        this.GT = bArr;
        kM();
    }

    public a(com.baidu.adp.gif.b bVar) {
        this.GR = null;
        this.isGif = false;
        this.GS = true;
        this.GT = null;
        this.GU = -1;
        this.GV = -1;
        this.GW = new AtomicBoolean(false);
        this.GY = false;
        this.timeStamp = -1L;
        this.Ha = false;
        this.Hc = new C0013a();
        this.GX = bVar;
        this.GY = true;
    }

    private void kM() {
        byte[] ninePatchChunk;
        if (this.GR != null && (ninePatchChunk = this.GR.getNinePatchChunk()) != null && ninePatchChunk.length > 0 && NinePatch.isNinePatchChunk(ninePatchChunk)) {
            this.Ha = true;
            this.Hb = new NinePatch(this.GR, ninePatchChunk, TbConfig.TMP_PIC_DIR_NAME);
        }
    }

    public boolean kN() {
        return this.GY;
    }

    public com.baidu.adp.gif.b getGif() {
        return this.GX;
    }

    public int getWidth() {
        if (this.GR == null) {
            return 0;
        }
        return this.GR.getWidth();
    }

    public int getHeight() {
        if (this.GR == null) {
            return 0;
        }
        return this.GR.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.GR != null) {
            this.GW.set(true);
            canvas.drawBitmap(this.GR, matrix, paint);
            this.GW.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.GR != null) {
            this.GW.set(true);
            canvas.drawBitmap(this.GR, f, f2, paint);
            this.GW.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.GR != null) {
            this.GW.set(true);
            canvas.drawBitmap(this.GR, rect, rectF, paint);
            this.GW.set(false);
        }
    }

    public void e(ImageView imageView) {
        if (imageView != null && this.GR != null) {
            this.GS = false;
            imageView.setImageBitmap(this.GR);
        }
    }

    public void a(Canvas canvas, RectF rectF) {
        if (this.Ha && this.Hb != null) {
            this.Hb.draw(canvas, rectF);
        }
    }

    public boolean isGif() {
        return this.isGif;
    }

    public int size() {
        if (this.GR == null) {
            return 0;
        }
        return this.GR.getHeight() * this.GR.getRowBytes();
    }

    public boolean kO() {
        if (this.GS && !this.GW.get()) {
            if (this.GR != null) {
                Bitmap bitmap = this.GR;
                this.GR = null;
                bitmap.recycle();
            }
            if (this.GX != null) {
                com.baidu.adp.gif.b bVar = this.GX;
                this.GX = null;
                bVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap kP() {
        this.GS = false;
        return this.GR;
    }

    public boolean kQ() {
        return this.GR != null;
    }

    public BitmapDrawable kR() {
        if (this.GR == null) {
            return null;
        }
        this.GS = false;
        return new b(this, this.GR);
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] kS() {
        byte[] byteArray;
        if (this.GR == null) {
            return null;
        }
        synchronized (lockForSyncImageDecoder) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.GR.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect kT() {
        return this.GZ;
    }

    public byte[] kU() {
        return this.GT;
    }

    public BitmapShader kV() {
        if (this.GR == null) {
            return null;
        }
        this.GS = false;
        return new BitmapShader(this.GR, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void R(boolean z) {
        this.GW.set(z);
    }

    public boolean kW() {
        return this.Ha;
    }
}
