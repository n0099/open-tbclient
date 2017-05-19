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
    private volatile boolean GS;
    private boolean GT;
    private byte[] GU;
    private int GV;
    private int GW;
    private AtomicBoolean GX;
    private com.baidu.adp.gif.b GY;
    private boolean GZ;
    public Rect Ha;
    private boolean Hb;
    private NinePatch Hc;
    public C0013a Hd;
    public long timeStamp;
    private String url;

    /* renamed from: com.baidu.adp.widget.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0013a {
        public String Hf;
        public long Hg;
        public boolean Hh;
    }

    public a(Bitmap bitmap, boolean z) {
        this.GR = null;
        this.GS = false;
        this.GT = true;
        this.GU = null;
        this.GV = -1;
        this.GW = -1;
        this.GX = new AtomicBoolean(false);
        this.GZ = false;
        this.timeStamp = -1L;
        this.Hb = false;
        this.Hd = new C0013a();
        this.GR = bitmap;
        this.GS = z;
        kO();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.GR = null;
        this.GS = false;
        this.GT = true;
        this.GU = null;
        this.GV = -1;
        this.GW = -1;
        this.GX = new AtomicBoolean(false);
        this.GZ = false;
        this.timeStamp = -1L;
        this.Hb = false;
        this.Hd = new C0013a();
        this.GR = bitmap;
        this.GS = z;
        this.url = str;
        kO();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.GR = null;
        this.GS = false;
        this.GT = true;
        this.GU = null;
        this.GV = -1;
        this.GW = -1;
        this.GX = new AtomicBoolean(false);
        this.GZ = false;
        this.timeStamp = -1L;
        this.Hb = false;
        this.Hd = new C0013a();
        this.GR = bitmap;
        this.GS = z;
        this.url = str;
        this.Ha = rect;
        kO();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.GR = null;
        this.GS = false;
        this.GT = true;
        this.GU = null;
        this.GV = -1;
        this.GW = -1;
        this.GX = new AtomicBoolean(false);
        this.GZ = false;
        this.timeStamp = -1L;
        this.Hb = false;
        this.Hd = new C0013a();
        this.GR = bitmap;
        this.GS = z;
        this.url = str;
        this.GU = bArr;
        kO();
    }

    public a(com.baidu.adp.gif.b bVar) {
        this.GR = null;
        this.GS = false;
        this.GT = true;
        this.GU = null;
        this.GV = -1;
        this.GW = -1;
        this.GX = new AtomicBoolean(false);
        this.GZ = false;
        this.timeStamp = -1L;
        this.Hb = false;
        this.Hd = new C0013a();
        this.GY = bVar;
        this.GZ = true;
    }

    private void kO() {
        byte[] ninePatchChunk;
        if (this.GR != null && (ninePatchChunk = this.GR.getNinePatchChunk()) != null && ninePatchChunk.length > 0 && NinePatch.isNinePatchChunk(ninePatchChunk)) {
            this.Hb = true;
            this.Hc = new NinePatch(this.GR, ninePatchChunk, TbConfig.TMP_PIC_DIR_NAME);
        }
    }

    public boolean kP() {
        return this.GZ;
    }

    public com.baidu.adp.gif.b getGif() {
        return this.GY;
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
            this.GX.set(true);
            canvas.drawBitmap(this.GR, matrix, paint);
            this.GX.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.GR != null) {
            this.GX.set(true);
            canvas.drawBitmap(this.GR, f, f2, paint);
            this.GX.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.GR != null) {
            this.GX.set(true);
            canvas.drawBitmap(this.GR, rect, rectF, paint);
            this.GX.set(false);
        }
    }

    public void e(ImageView imageView) {
        if (imageView != null && this.GR != null) {
            this.GT = false;
            imageView.setImageBitmap(this.GR);
        }
    }

    public void a(Canvas canvas, RectF rectF) {
        if (this.Hb && this.Hc != null) {
            this.Hc.draw(canvas, rectF);
        }
    }

    public boolean ef() {
        return this.GS;
    }

    public int size() {
        if (this.GR == null) {
            return 0;
        }
        return this.GR.getHeight() * this.GR.getRowBytes();
    }

    public boolean kQ() {
        if (this.GT && !this.GX.get()) {
            if (this.GR != null) {
                Bitmap bitmap = this.GR;
                this.GR = null;
                bitmap.recycle();
            }
            if (this.GY != null) {
                com.baidu.adp.gif.b bVar = this.GY;
                this.GY = null;
                bVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap kR() {
        this.GT = false;
        return this.GR;
    }

    public boolean kS() {
        return this.GR != null;
    }

    public BitmapDrawable kT() {
        if (this.GR == null) {
            return null;
        }
        this.GT = false;
        return new b(this, this.GR);
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] kU() {
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

    public Rect kV() {
        return this.Ha;
    }

    public byte[] kW() {
        return this.GU;
    }

    public BitmapShader kX() {
        if (this.GR == null) {
            return null;
        }
        this.GT = false;
        return new BitmapShader(this.GR, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void R(boolean z) {
        this.GX.set(z);
    }

    public boolean kY() {
        return this.Hb;
    }
}
