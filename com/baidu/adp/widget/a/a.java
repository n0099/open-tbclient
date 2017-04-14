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
    private Bitmap GO;
    private volatile boolean GP;
    private boolean GQ;
    private byte[] GR;
    private int GS;
    private int GT;
    private AtomicBoolean GU;
    private com.baidu.adp.gif.b GV;
    private boolean GW;
    public long GX;
    public Rect GY;
    private boolean GZ;
    private NinePatch Ha;
    public C0013a Hb;
    private String url;

    /* renamed from: com.baidu.adp.widget.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0013a {
        public String Hd;
        public long He;
        public boolean Hf;
    }

    public a(Bitmap bitmap, boolean z) {
        this.GO = null;
        this.GP = false;
        this.GQ = true;
        this.GR = null;
        this.GS = -1;
        this.GT = -1;
        this.GU = new AtomicBoolean(false);
        this.GW = false;
        this.GX = -1L;
        this.GZ = false;
        this.Hb = new C0013a();
        this.GO = bitmap;
        this.GP = z;
        kO();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.GO = null;
        this.GP = false;
        this.GQ = true;
        this.GR = null;
        this.GS = -1;
        this.GT = -1;
        this.GU = new AtomicBoolean(false);
        this.GW = false;
        this.GX = -1L;
        this.GZ = false;
        this.Hb = new C0013a();
        this.GO = bitmap;
        this.GP = z;
        this.url = str;
        kO();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.GO = null;
        this.GP = false;
        this.GQ = true;
        this.GR = null;
        this.GS = -1;
        this.GT = -1;
        this.GU = new AtomicBoolean(false);
        this.GW = false;
        this.GX = -1L;
        this.GZ = false;
        this.Hb = new C0013a();
        this.GO = bitmap;
        this.GP = z;
        this.url = str;
        this.GY = rect;
        kO();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.GO = null;
        this.GP = false;
        this.GQ = true;
        this.GR = null;
        this.GS = -1;
        this.GT = -1;
        this.GU = new AtomicBoolean(false);
        this.GW = false;
        this.GX = -1L;
        this.GZ = false;
        this.Hb = new C0013a();
        this.GO = bitmap;
        this.GP = z;
        this.url = str;
        this.GR = bArr;
        kO();
    }

    public a(com.baidu.adp.gif.b bVar) {
        this.GO = null;
        this.GP = false;
        this.GQ = true;
        this.GR = null;
        this.GS = -1;
        this.GT = -1;
        this.GU = new AtomicBoolean(false);
        this.GW = false;
        this.GX = -1L;
        this.GZ = false;
        this.Hb = new C0013a();
        this.GV = bVar;
        this.GW = true;
    }

    private void kO() {
        byte[] ninePatchChunk;
        if (this.GO != null && (ninePatchChunk = this.GO.getNinePatchChunk()) != null && ninePatchChunk.length > 0 && NinePatch.isNinePatchChunk(ninePatchChunk)) {
            this.GZ = true;
            this.Ha = new NinePatch(this.GO, ninePatchChunk, TbConfig.TMP_PIC_DIR_NAME);
        }
    }

    public boolean kP() {
        return this.GW;
    }

    public com.baidu.adp.gif.b getGif() {
        return this.GV;
    }

    public int getWidth() {
        if (this.GO == null) {
            return 0;
        }
        return this.GO.getWidth();
    }

    public int getHeight() {
        if (this.GO == null) {
            return 0;
        }
        return this.GO.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.GO != null) {
            this.GU.set(true);
            canvas.drawBitmap(this.GO, matrix, paint);
            this.GU.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.GO != null) {
            this.GU.set(true);
            canvas.drawBitmap(this.GO, f, f2, paint);
            this.GU.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.GO != null) {
            this.GU.set(true);
            canvas.drawBitmap(this.GO, rect, rectF, paint);
            this.GU.set(false);
        }
    }

    public void e(ImageView imageView) {
        if (imageView != null && this.GO != null) {
            this.GQ = false;
            imageView.setImageBitmap(this.GO);
        }
    }

    public void a(Canvas canvas, RectF rectF) {
        if (this.GZ && this.Ha != null) {
            this.Ha.draw(canvas, rectF);
        }
    }

    public boolean ee() {
        return this.GP;
    }

    public int size() {
        if (this.GO == null) {
            return 0;
        }
        return this.GO.getHeight() * this.GO.getRowBytes();
    }

    public boolean kQ() {
        if (this.GQ && !this.GU.get()) {
            if (this.GO != null) {
                Bitmap bitmap = this.GO;
                this.GO = null;
                bitmap.recycle();
            }
            if (this.GV != null) {
                com.baidu.adp.gif.b bVar = this.GV;
                this.GV = null;
                bVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap kR() {
        this.GQ = false;
        return this.GO;
    }

    public boolean kS() {
        return this.GO != null;
    }

    public BitmapDrawable kT() {
        if (this.GO == null) {
            return null;
        }
        this.GQ = false;
        return new b(this, this.GO);
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] kU() {
        byte[] byteArray;
        if (this.GO == null) {
            return null;
        }
        synchronized (lockForSyncImageDecoder) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.GO.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect kV() {
        return this.GY;
    }

    public byte[] kW() {
        return this.GR;
    }

    public BitmapShader kX() {
        if (this.GO == null) {
            return null;
        }
        this.GQ = false;
        return new BitmapShader(this.GO, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void R(boolean z) {
        this.GU.set(z);
    }

    public boolean kY() {
        return this.GZ;
    }
}
