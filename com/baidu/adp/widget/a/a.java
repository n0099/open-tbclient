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
    private Bitmap atQ;
    private boolean atR;
    private byte[] atS;
    private int atT;
    private int atU;
    private AtomicBoolean atV;
    private b atW;
    private boolean atX;
    public Rect atY;
    private boolean atZ;
    private NinePatch aua;
    public C0027a aub;
    private volatile boolean isGif;
    public long timeStamp;
    private String url;

    /* renamed from: com.baidu.adp.widget.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0027a {
        public String aud;
        public long aue;
        public boolean auf;
    }

    public a(Bitmap bitmap, boolean z) {
        this.atQ = null;
        this.isGif = false;
        this.atR = true;
        this.atS = null;
        this.atT = -1;
        this.atU = -1;
        this.atV = new AtomicBoolean(false);
        this.atX = false;
        this.timeStamp = -1L;
        this.atZ = false;
        this.aub = new C0027a();
        this.atQ = bitmap;
        this.isGif = z;
        se();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.atQ = null;
        this.isGif = false;
        this.atR = true;
        this.atS = null;
        this.atT = -1;
        this.atU = -1;
        this.atV = new AtomicBoolean(false);
        this.atX = false;
        this.timeStamp = -1L;
        this.atZ = false;
        this.aub = new C0027a();
        this.atQ = bitmap;
        this.isGif = z;
        this.url = str;
        se();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.atQ = null;
        this.isGif = false;
        this.atR = true;
        this.atS = null;
        this.atT = -1;
        this.atU = -1;
        this.atV = new AtomicBoolean(false);
        this.atX = false;
        this.timeStamp = -1L;
        this.atZ = false;
        this.aub = new C0027a();
        this.atQ = bitmap;
        this.isGif = z;
        this.url = str;
        this.atY = rect;
        se();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.atQ = null;
        this.isGif = false;
        this.atR = true;
        this.atS = null;
        this.atT = -1;
        this.atU = -1;
        this.atV = new AtomicBoolean(false);
        this.atX = false;
        this.timeStamp = -1L;
        this.atZ = false;
        this.aub = new C0027a();
        this.atQ = bitmap;
        this.isGif = z;
        this.url = str;
        this.atS = bArr;
        se();
    }

    public a(b bVar, Bitmap bitmap, boolean z) {
        this.atQ = null;
        this.isGif = false;
        this.atR = true;
        this.atS = null;
        this.atT = -1;
        this.atU = -1;
        this.atV = new AtomicBoolean(false);
        this.atX = false;
        this.timeStamp = -1L;
        this.atZ = false;
        this.aub = new C0027a();
        this.atW = bVar;
        this.atQ = bitmap;
        this.isGif = z;
    }

    public a(b bVar) {
        this.atQ = null;
        this.isGif = false;
        this.atR = true;
        this.atS = null;
        this.atT = -1;
        this.atU = -1;
        this.atV = new AtomicBoolean(false);
        this.atX = false;
        this.timeStamp = -1L;
        this.atZ = false;
        this.aub = new C0027a();
        this.atW = bVar;
        this.atX = true;
    }

    private void se() {
        byte[] ninePatchChunk;
        if (this.atQ != null && (ninePatchChunk = this.atQ.getNinePatchChunk()) != null && ninePatchChunk.length > 0 && NinePatch.isNinePatchChunk(ninePatchChunk)) {
            this.atZ = true;
            this.aua = new NinePatch(this.atQ, ninePatchChunk, "image");
        }
    }

    public boolean sf() {
        return this.atX;
    }

    public b getGif() {
        return this.atW;
    }

    public int getWidth() {
        if (this.atQ == null) {
            return 0;
        }
        return this.atQ.getWidth();
    }

    public int getHeight() {
        if (this.atQ == null) {
            return 0;
        }
        return this.atQ.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.atQ != null) {
            this.atV.set(true);
            canvas.drawBitmap(this.atQ, matrix, paint);
            this.atV.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.atQ != null) {
            this.atV.set(true);
            canvas.drawBitmap(this.atQ, f, f2, paint);
            this.atV.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.atQ != null) {
            this.atV.set(true);
            canvas.drawBitmap(this.atQ, rect, rectF, paint);
            this.atV.set(false);
        }
    }

    public void a(ImageView imageView) {
        if (imageView != null && this.atQ != null) {
            this.atR = false;
            imageView.setImageBitmap(this.atQ);
        }
    }

    public void a(Canvas canvas, RectF rectF) {
        if (this.atZ && this.aua != null) {
            this.aua.draw(canvas, rectF);
        }
    }

    public boolean isGif() {
        return this.isGif;
    }

    public int size() {
        if (this.atQ == null) {
            return 0;
        }
        return this.atQ.getHeight() * this.atQ.getRowBytes();
    }

    public boolean sg() {
        if (this.atR && !this.atV.get()) {
            if (this.atQ != null) {
                Bitmap bitmap = this.atQ;
                this.atQ = null;
                bitmap.recycle();
            }
            if (this.atW != null) {
                b bVar = this.atW;
                this.atW = null;
                bVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap sh() {
        this.atR = false;
        return this.atQ;
    }

    public boolean si() {
        return this.atQ != null;
    }

    public BitmapDrawable sj() {
        if (this.atQ == null) {
            return null;
        }
        this.atR = false;
        return new BitmapDrawable(this.atQ) { // from class: com.baidu.adp.widget.a.a.1
            @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                Bitmap bitmap;
                if (a.this.atQ != null && (bitmap = getBitmap()) != null && !bitmap.isRecycled()) {
                    canvas.drawBitmap(a.this.atQ, (Rect) null, getBounds(), getPaint());
                }
            }
        };
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] sk() {
        byte[] byteArray;
        if (this.atQ == null) {
            return null;
        }
        synchronized (lockForSyncImageDecoder) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.atQ.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect sl() {
        return this.atY;
    }

    public byte[] sm() {
        return this.atS;
    }

    public BitmapShader sn() {
        if (this.atQ == null) {
            return null;
        }
        this.atR = false;
        return new BitmapShader(this.atQ, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void aC(boolean z) {
        this.atV.set(z);
    }

    public boolean so() {
        return this.atZ;
    }
}
