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
import com.baidu.adp.gif.b;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    public static final Object lockForSyncImageDecoder = new Object();
    private Bitmap atR;
    private boolean atS;
    private byte[] atT;
    private int atU;
    private int atV;
    private AtomicBoolean atW;
    private b atX;
    private boolean atY;
    public Rect atZ;
    private boolean aua;
    private NinePatch aub;
    public C0027a auc;
    private volatile boolean isGif;
    public long timeStamp;
    private String url;

    /* renamed from: com.baidu.adp.widget.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0027a {
        public String aue;
        public long auf;
        public boolean aug;
    }

    public a(Bitmap bitmap, boolean z) {
        this.atR = null;
        this.isGif = false;
        this.atS = true;
        this.atT = null;
        this.atU = -1;
        this.atV = -1;
        this.atW = new AtomicBoolean(false);
        this.atY = false;
        this.timeStamp = -1L;
        this.aua = false;
        this.auc = new C0027a();
        this.atR = bitmap;
        this.isGif = z;
        se();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.atR = null;
        this.isGif = false;
        this.atS = true;
        this.atT = null;
        this.atU = -1;
        this.atV = -1;
        this.atW = new AtomicBoolean(false);
        this.atY = false;
        this.timeStamp = -1L;
        this.aua = false;
        this.auc = new C0027a();
        this.atR = bitmap;
        this.isGif = z;
        this.url = str;
        se();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.atR = null;
        this.isGif = false;
        this.atS = true;
        this.atT = null;
        this.atU = -1;
        this.atV = -1;
        this.atW = new AtomicBoolean(false);
        this.atY = false;
        this.timeStamp = -1L;
        this.aua = false;
        this.auc = new C0027a();
        this.atR = bitmap;
        this.isGif = z;
        this.url = str;
        this.atZ = rect;
        se();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.atR = null;
        this.isGif = false;
        this.atS = true;
        this.atT = null;
        this.atU = -1;
        this.atV = -1;
        this.atW = new AtomicBoolean(false);
        this.atY = false;
        this.timeStamp = -1L;
        this.aua = false;
        this.auc = new C0027a();
        this.atR = bitmap;
        this.isGif = z;
        this.url = str;
        this.atT = bArr;
        se();
    }

    public a(b bVar, Bitmap bitmap, boolean z) {
        this.atR = null;
        this.isGif = false;
        this.atS = true;
        this.atT = null;
        this.atU = -1;
        this.atV = -1;
        this.atW = new AtomicBoolean(false);
        this.atY = false;
        this.timeStamp = -1L;
        this.aua = false;
        this.auc = new C0027a();
        this.atX = bVar;
        this.atR = bitmap;
        this.isGif = z;
    }

    public a(b bVar) {
        this.atR = null;
        this.isGif = false;
        this.atS = true;
        this.atT = null;
        this.atU = -1;
        this.atV = -1;
        this.atW = new AtomicBoolean(false);
        this.atY = false;
        this.timeStamp = -1L;
        this.aua = false;
        this.auc = new C0027a();
        this.atX = bVar;
        this.atY = true;
    }

    private void se() {
        byte[] ninePatchChunk;
        if (this.atR != null && (ninePatchChunk = this.atR.getNinePatchChunk()) != null && ninePatchChunk.length > 0 && NinePatch.isNinePatchChunk(ninePatchChunk)) {
            this.aua = true;
            this.aub = new NinePatch(this.atR, ninePatchChunk, "image");
        }
    }

    public boolean sf() {
        return this.atY;
    }

    public b getGif() {
        return this.atX;
    }

    public int getWidth() {
        if (this.atR == null) {
            return 0;
        }
        return this.atR.getWidth();
    }

    public int getHeight() {
        if (this.atR == null) {
            return 0;
        }
        return this.atR.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.atR != null) {
            this.atW.set(true);
            canvas.drawBitmap(this.atR, matrix, paint);
            this.atW.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.atR != null) {
            this.atW.set(true);
            canvas.drawBitmap(this.atR, f, f2, paint);
            this.atW.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.atR != null) {
            this.atW.set(true);
            canvas.drawBitmap(this.atR, rect, rectF, paint);
            this.atW.set(false);
        }
    }

    public void a(ImageView imageView) {
        if (imageView != null && this.atR != null) {
            this.atS = false;
            imageView.setImageBitmap(this.atR);
        }
    }

    public void a(Canvas canvas, RectF rectF) {
        if (this.aua && this.aub != null) {
            this.aub.draw(canvas, rectF);
        }
    }

    public boolean isGif() {
        return this.isGif;
    }

    public int size() {
        if (this.atR == null) {
            return 0;
        }
        return this.atR.getHeight() * this.atR.getRowBytes();
    }

    public boolean sg() {
        if (this.atS && !this.atW.get()) {
            if (this.atR != null) {
                Bitmap bitmap = this.atR;
                this.atR = null;
                bitmap.recycle();
            }
            if (this.atX != null) {
                b bVar = this.atX;
                this.atX = null;
                bVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap sh() {
        this.atS = false;
        return this.atR;
    }

    public boolean si() {
        return this.atR != null;
    }

    public BitmapDrawable sj() {
        if (this.atR == null) {
            return null;
        }
        this.atS = false;
        return new BitmapDrawable(this.atR) { // from class: com.baidu.adp.widget.a.a.1
            @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                Bitmap bitmap;
                if (a.this.atR != null && (bitmap = getBitmap()) != null && !bitmap.isRecycled()) {
                    canvas.drawBitmap(a.this.atR, (Rect) null, getBounds(), getPaint());
                }
            }
        };
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] sk() {
        byte[] byteArray;
        if (this.atR == null) {
            return null;
        }
        synchronized (lockForSyncImageDecoder) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.atR.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect sl() {
        return this.atZ;
    }

    public byte[] sm() {
        return this.atT;
    }

    public BitmapShader sn() {
        if (this.atR == null) {
            return null;
        }
        this.atS = false;
        return new BitmapShader(this.atR, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void aC(boolean z) {
        this.atW.set(z);
    }

    public boolean so() {
        return this.aua;
    }
}
