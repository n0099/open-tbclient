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
    private Bitmap GX;
    private volatile boolean GY;
    private boolean GZ;
    private byte[] Ha;
    private int Hb;
    private int Hc;
    private AtomicBoolean Hd;
    private com.baidu.adp.gif.b He;
    private boolean Hf;
    public Rect Hg;
    private boolean Hh;
    private NinePatch Hi;
    public C0015a Hj;
    public long timeStamp;
    private String url;

    /* renamed from: com.baidu.adp.widget.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0015a {
        public String Hl;
        public long Hm;
        public boolean Hn;
    }

    public a(Bitmap bitmap, boolean z) {
        this.GX = null;
        this.GY = false;
        this.GZ = true;
        this.Ha = null;
        this.Hb = -1;
        this.Hc = -1;
        this.Hd = new AtomicBoolean(false);
        this.Hf = false;
        this.timeStamp = -1L;
        this.Hh = false;
        this.Hj = new C0015a();
        this.GX = bitmap;
        this.GY = z;
        mP();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.GX = null;
        this.GY = false;
        this.GZ = true;
        this.Ha = null;
        this.Hb = -1;
        this.Hc = -1;
        this.Hd = new AtomicBoolean(false);
        this.Hf = false;
        this.timeStamp = -1L;
        this.Hh = false;
        this.Hj = new C0015a();
        this.GX = bitmap;
        this.GY = z;
        this.url = str;
        mP();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.GX = null;
        this.GY = false;
        this.GZ = true;
        this.Ha = null;
        this.Hb = -1;
        this.Hc = -1;
        this.Hd = new AtomicBoolean(false);
        this.Hf = false;
        this.timeStamp = -1L;
        this.Hh = false;
        this.Hj = new C0015a();
        this.GX = bitmap;
        this.GY = z;
        this.url = str;
        this.Hg = rect;
        mP();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.GX = null;
        this.GY = false;
        this.GZ = true;
        this.Ha = null;
        this.Hb = -1;
        this.Hc = -1;
        this.Hd = new AtomicBoolean(false);
        this.Hf = false;
        this.timeStamp = -1L;
        this.Hh = false;
        this.Hj = new C0015a();
        this.GX = bitmap;
        this.GY = z;
        this.url = str;
        this.Ha = bArr;
        mP();
    }

    public a(com.baidu.adp.gif.b bVar) {
        this.GX = null;
        this.GY = false;
        this.GZ = true;
        this.Ha = null;
        this.Hb = -1;
        this.Hc = -1;
        this.Hd = new AtomicBoolean(false);
        this.Hf = false;
        this.timeStamp = -1L;
        this.Hh = false;
        this.Hj = new C0015a();
        this.He = bVar;
        this.Hf = true;
    }

    private void mP() {
        byte[] ninePatchChunk;
        if (this.GX != null && (ninePatchChunk = this.GX.getNinePatchChunk()) != null && ninePatchChunk.length > 0 && NinePatch.isNinePatchChunk(ninePatchChunk)) {
            this.Hh = true;
            this.Hi = new NinePatch(this.GX, ninePatchChunk, TbConfig.TMP_PIC_DIR_NAME);
        }
    }

    public boolean mQ() {
        return this.Hf;
    }

    public com.baidu.adp.gif.b getGif() {
        return this.He;
    }

    public int getWidth() {
        if (this.GX == null) {
            return 0;
        }
        return this.GX.getWidth();
    }

    public int getHeight() {
        if (this.GX == null) {
            return 0;
        }
        return this.GX.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.GX != null) {
            this.Hd.set(true);
            canvas.drawBitmap(this.GX, matrix, paint);
            this.Hd.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.GX != null) {
            this.Hd.set(true);
            canvas.drawBitmap(this.GX, f, f2, paint);
            this.Hd.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.GX != null) {
            this.Hd.set(true);
            canvas.drawBitmap(this.GX, rect, rectF, paint);
            this.Hd.set(false);
        }
    }

    public void a(ImageView imageView) {
        if (imageView != null && this.GX != null) {
            this.GZ = false;
            imageView.setImageBitmap(this.GX);
        }
    }

    public void a(Canvas canvas, RectF rectF) {
        if (this.Hh && this.Hi != null) {
            this.Hi.draw(canvas, rectF);
        }
    }

    public boolean fN() {
        return this.GY;
    }

    public int size() {
        if (this.GX == null) {
            return 0;
        }
        return this.GX.getHeight() * this.GX.getRowBytes();
    }

    public boolean mR() {
        if (this.GZ && !this.Hd.get()) {
            if (this.GX != null) {
                Bitmap bitmap = this.GX;
                this.GX = null;
                bitmap.recycle();
            }
            if (this.He != null) {
                com.baidu.adp.gif.b bVar = this.He;
                this.He = null;
                bVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap mS() {
        this.GZ = false;
        return this.GX;
    }

    public boolean mT() {
        return this.GX != null;
    }

    public BitmapDrawable mU() {
        if (this.GX == null) {
            return null;
        }
        this.GZ = false;
        return new b(this, this.GX);
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] mV() {
        byte[] byteArray;
        if (this.GX == null) {
            return null;
        }
        synchronized (lockForSyncImageDecoder) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.GX.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect mW() {
        return this.Hg;
    }

    public byte[] mX() {
        return this.Ha;
    }

    public BitmapShader mY() {
        if (this.GX == null) {
            return null;
        }
        this.GZ = false;
        return new BitmapShader(this.GX, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void N(boolean z) {
        this.Hd.set(z);
    }

    public boolean mZ() {
        return this.Hh;
    }
}
