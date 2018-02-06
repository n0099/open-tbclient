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
    private Bitmap atZ;
    private boolean aua;
    private byte[] aub;
    private int auc;
    private int aud;
    private AtomicBoolean aue;
    private b auf;
    private boolean aug;
    public Rect auh;
    private boolean aui;
    private NinePatch auj;
    public C0027a auk;
    private volatile boolean isGif;
    public long timeStamp;
    private String url;

    /* renamed from: com.baidu.adp.widget.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0027a {
        public String aum;
        public long aun;
        public boolean auo;
    }

    public a(Bitmap bitmap, boolean z) {
        this.atZ = null;
        this.isGif = false;
        this.aua = true;
        this.aub = null;
        this.auc = -1;
        this.aud = -1;
        this.aue = new AtomicBoolean(false);
        this.aug = false;
        this.timeStamp = -1L;
        this.aui = false;
        this.auk = new C0027a();
        this.atZ = bitmap;
        this.isGif = z;
        se();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.atZ = null;
        this.isGif = false;
        this.aua = true;
        this.aub = null;
        this.auc = -1;
        this.aud = -1;
        this.aue = new AtomicBoolean(false);
        this.aug = false;
        this.timeStamp = -1L;
        this.aui = false;
        this.auk = new C0027a();
        this.atZ = bitmap;
        this.isGif = z;
        this.url = str;
        se();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.atZ = null;
        this.isGif = false;
        this.aua = true;
        this.aub = null;
        this.auc = -1;
        this.aud = -1;
        this.aue = new AtomicBoolean(false);
        this.aug = false;
        this.timeStamp = -1L;
        this.aui = false;
        this.auk = new C0027a();
        this.atZ = bitmap;
        this.isGif = z;
        this.url = str;
        this.auh = rect;
        se();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.atZ = null;
        this.isGif = false;
        this.aua = true;
        this.aub = null;
        this.auc = -1;
        this.aud = -1;
        this.aue = new AtomicBoolean(false);
        this.aug = false;
        this.timeStamp = -1L;
        this.aui = false;
        this.auk = new C0027a();
        this.atZ = bitmap;
        this.isGif = z;
        this.url = str;
        this.aub = bArr;
        se();
    }

    public a(b bVar, Bitmap bitmap, boolean z) {
        this.atZ = null;
        this.isGif = false;
        this.aua = true;
        this.aub = null;
        this.auc = -1;
        this.aud = -1;
        this.aue = new AtomicBoolean(false);
        this.aug = false;
        this.timeStamp = -1L;
        this.aui = false;
        this.auk = new C0027a();
        this.auf = bVar;
        this.atZ = bitmap;
        this.isGif = z;
    }

    public a(b bVar) {
        this.atZ = null;
        this.isGif = false;
        this.aua = true;
        this.aub = null;
        this.auc = -1;
        this.aud = -1;
        this.aue = new AtomicBoolean(false);
        this.aug = false;
        this.timeStamp = -1L;
        this.aui = false;
        this.auk = new C0027a();
        this.auf = bVar;
        this.aug = true;
    }

    private void se() {
        byte[] ninePatchChunk;
        if (this.atZ != null && (ninePatchChunk = this.atZ.getNinePatchChunk()) != null && ninePatchChunk.length > 0 && NinePatch.isNinePatchChunk(ninePatchChunk)) {
            this.aui = true;
            this.auj = new NinePatch(this.atZ, ninePatchChunk, "image");
        }
    }

    public boolean sf() {
        return this.aug;
    }

    public b getGif() {
        return this.auf;
    }

    public int getWidth() {
        if (this.atZ == null) {
            return 0;
        }
        return this.atZ.getWidth();
    }

    public int getHeight() {
        if (this.atZ == null) {
            return 0;
        }
        return this.atZ.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.atZ != null) {
            this.aue.set(true);
            canvas.drawBitmap(this.atZ, matrix, paint);
            this.aue.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.atZ != null) {
            this.aue.set(true);
            canvas.drawBitmap(this.atZ, f, f2, paint);
            this.aue.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.atZ != null) {
            this.aue.set(true);
            canvas.drawBitmap(this.atZ, rect, rectF, paint);
            this.aue.set(false);
        }
    }

    public void a(ImageView imageView) {
        if (imageView != null && this.atZ != null) {
            this.aua = false;
            imageView.setImageBitmap(this.atZ);
        }
    }

    public void a(Canvas canvas, RectF rectF) {
        if (this.aui && this.auj != null) {
            this.auj.draw(canvas, rectF);
        }
    }

    public boolean isGif() {
        return this.isGif;
    }

    public int size() {
        if (this.atZ == null) {
            return 0;
        }
        return this.atZ.getHeight() * this.atZ.getRowBytes();
    }

    public boolean sg() {
        if (this.aua && !this.aue.get()) {
            if (this.atZ != null) {
                Bitmap bitmap = this.atZ;
                this.atZ = null;
                bitmap.recycle();
            }
            if (this.auf != null) {
                b bVar = this.auf;
                this.auf = null;
                bVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap sh() {
        this.aua = false;
        return this.atZ;
    }

    public boolean si() {
        return this.atZ != null;
    }

    public BitmapDrawable sj() {
        if (this.atZ == null) {
            return null;
        }
        this.aua = false;
        return new BitmapDrawable(this.atZ) { // from class: com.baidu.adp.widget.a.a.1
            @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                Bitmap bitmap;
                if (a.this.atZ != null && (bitmap = getBitmap()) != null && !bitmap.isRecycled()) {
                    canvas.drawBitmap(a.this.atZ, (Rect) null, getBounds(), getPaint());
                }
            }
        };
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] sk() {
        byte[] byteArray;
        if (this.atZ == null) {
            return null;
        }
        synchronized (lockForSyncImageDecoder) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.atZ.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect sl() {
        return this.auh;
    }

    public byte[] sm() {
        return this.aub;
    }

    public BitmapShader sn() {
        if (this.atZ == null) {
            return null;
        }
        this.aua = false;
        return new BitmapShader(this.atZ, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void aC(boolean z) {
        this.aue.set(z);
    }

    public boolean so() {
        return this.aui;
    }
}
