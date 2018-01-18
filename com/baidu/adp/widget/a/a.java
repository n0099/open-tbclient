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
import com.baidu.tbadk.TbConfig;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    public static final Object lockForSyncImageDecoder = new Object();
    private Bitmap aub;
    private boolean auc;
    private byte[] aud;
    private int aue;
    private int auf;
    private AtomicBoolean aug;
    private b auh;
    private boolean aui;
    public Rect auj;
    private boolean auk;
    private NinePatch aul;
    public C0027a aum;
    private volatile boolean isGif;
    public long timeStamp;
    private String url;

    /* renamed from: com.baidu.adp.widget.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0027a {
        public String auo;
        public long aup;
        public boolean auq;
    }

    public a(Bitmap bitmap, boolean z) {
        this.aub = null;
        this.isGif = false;
        this.auc = true;
        this.aud = null;
        this.aue = -1;
        this.auf = -1;
        this.aug = new AtomicBoolean(false);
        this.aui = false;
        this.timeStamp = -1L;
        this.auk = false;
        this.aum = new C0027a();
        this.aub = bitmap;
        this.isGif = z;
        sf();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.aub = null;
        this.isGif = false;
        this.auc = true;
        this.aud = null;
        this.aue = -1;
        this.auf = -1;
        this.aug = new AtomicBoolean(false);
        this.aui = false;
        this.timeStamp = -1L;
        this.auk = false;
        this.aum = new C0027a();
        this.aub = bitmap;
        this.isGif = z;
        this.url = str;
        sf();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.aub = null;
        this.isGif = false;
        this.auc = true;
        this.aud = null;
        this.aue = -1;
        this.auf = -1;
        this.aug = new AtomicBoolean(false);
        this.aui = false;
        this.timeStamp = -1L;
        this.auk = false;
        this.aum = new C0027a();
        this.aub = bitmap;
        this.isGif = z;
        this.url = str;
        this.auj = rect;
        sf();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.aub = null;
        this.isGif = false;
        this.auc = true;
        this.aud = null;
        this.aue = -1;
        this.auf = -1;
        this.aug = new AtomicBoolean(false);
        this.aui = false;
        this.timeStamp = -1L;
        this.auk = false;
        this.aum = new C0027a();
        this.aub = bitmap;
        this.isGif = z;
        this.url = str;
        this.aud = bArr;
        sf();
    }

    public a(b bVar, Bitmap bitmap, boolean z) {
        this.aub = null;
        this.isGif = false;
        this.auc = true;
        this.aud = null;
        this.aue = -1;
        this.auf = -1;
        this.aug = new AtomicBoolean(false);
        this.aui = false;
        this.timeStamp = -1L;
        this.auk = false;
        this.aum = new C0027a();
        this.auh = bVar;
        this.aub = bitmap;
        this.isGif = z;
    }

    public a(b bVar) {
        this.aub = null;
        this.isGif = false;
        this.auc = true;
        this.aud = null;
        this.aue = -1;
        this.auf = -1;
        this.aug = new AtomicBoolean(false);
        this.aui = false;
        this.timeStamp = -1L;
        this.auk = false;
        this.aum = new C0027a();
        this.auh = bVar;
        this.aui = true;
    }

    private void sf() {
        byte[] ninePatchChunk;
        if (this.aub != null && (ninePatchChunk = this.aub.getNinePatchChunk()) != null && ninePatchChunk.length > 0 && NinePatch.isNinePatchChunk(ninePatchChunk)) {
            this.auk = true;
            this.aul = new NinePatch(this.aub, ninePatchChunk, TbConfig.TMP_PIC_DIR_NAME);
        }
    }

    public boolean sg() {
        return this.aui;
    }

    public b getGif() {
        return this.auh;
    }

    public int getWidth() {
        if (this.aub == null) {
            return 0;
        }
        return this.aub.getWidth();
    }

    public int getHeight() {
        if (this.aub == null) {
            return 0;
        }
        return this.aub.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.aub != null) {
            this.aug.set(true);
            canvas.drawBitmap(this.aub, matrix, paint);
            this.aug.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.aub != null) {
            this.aug.set(true);
            canvas.drawBitmap(this.aub, f, f2, paint);
            this.aug.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.aub != null) {
            this.aug.set(true);
            canvas.drawBitmap(this.aub, rect, rectF, paint);
            this.aug.set(false);
        }
    }

    public void a(ImageView imageView) {
        if (imageView != null && this.aub != null) {
            this.auc = false;
            imageView.setImageBitmap(this.aub);
        }
    }

    public void a(Canvas canvas, RectF rectF) {
        if (this.auk && this.aul != null) {
            this.aul.draw(canvas, rectF);
        }
    }

    public boolean isGif() {
        return this.isGif;
    }

    public int size() {
        if (this.aub == null) {
            return 0;
        }
        return this.aub.getHeight() * this.aub.getRowBytes();
    }

    public boolean sh() {
        if (this.auc && !this.aug.get()) {
            if (this.aub != null) {
                Bitmap bitmap = this.aub;
                this.aub = null;
                bitmap.recycle();
            }
            if (this.auh != null) {
                b bVar = this.auh;
                this.auh = null;
                bVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap si() {
        this.auc = false;
        return this.aub;
    }

    public boolean sj() {
        return this.aub != null;
    }

    public BitmapDrawable sk() {
        if (this.aub == null) {
            return null;
        }
        this.auc = false;
        return new BitmapDrawable(this.aub) { // from class: com.baidu.adp.widget.a.a.1
            @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                Bitmap bitmap;
                if (a.this.aub != null && (bitmap = getBitmap()) != null && !bitmap.isRecycled()) {
                    canvas.drawBitmap(a.this.aub, (Rect) null, getBounds(), getPaint());
                }
            }
        };
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] sl() {
        byte[] byteArray;
        if (this.aub == null) {
            return null;
        }
        synchronized (lockForSyncImageDecoder) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.aub.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect sm() {
        return this.auj;
    }

    public byte[] sn() {
        return this.aud;
    }

    public BitmapShader so() {
        if (this.aub == null) {
            return null;
        }
        this.auc = false;
        return new BitmapShader(this.aub, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void ay(boolean z) {
        this.aug.set(z);
    }

    public boolean sp() {
        return this.auk;
    }
}
