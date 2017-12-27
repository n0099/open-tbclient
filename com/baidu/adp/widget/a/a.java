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
    private Bitmap auc;
    private boolean aud;
    private byte[] aue;
    private int auf;
    private int aug;
    private AtomicBoolean auh;
    private b aui;
    private boolean auj;
    public Rect auk;
    private boolean aul;
    private NinePatch aum;
    public C0027a aun;
    private volatile boolean isGif;
    public long timeStamp;
    private String url;

    /* renamed from: com.baidu.adp.widget.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0027a {
        public String aup;
        public long auq;
        public boolean aur;
    }

    public a(Bitmap bitmap, boolean z) {
        this.auc = null;
        this.isGif = false;
        this.aud = true;
        this.aue = null;
        this.auf = -1;
        this.aug = -1;
        this.auh = new AtomicBoolean(false);
        this.auj = false;
        this.timeStamp = -1L;
        this.aul = false;
        this.aun = new C0027a();
        this.auc = bitmap;
        this.isGif = z;
        sf();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.auc = null;
        this.isGif = false;
        this.aud = true;
        this.aue = null;
        this.auf = -1;
        this.aug = -1;
        this.auh = new AtomicBoolean(false);
        this.auj = false;
        this.timeStamp = -1L;
        this.aul = false;
        this.aun = new C0027a();
        this.auc = bitmap;
        this.isGif = z;
        this.url = str;
        sf();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.auc = null;
        this.isGif = false;
        this.aud = true;
        this.aue = null;
        this.auf = -1;
        this.aug = -1;
        this.auh = new AtomicBoolean(false);
        this.auj = false;
        this.timeStamp = -1L;
        this.aul = false;
        this.aun = new C0027a();
        this.auc = bitmap;
        this.isGif = z;
        this.url = str;
        this.auk = rect;
        sf();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.auc = null;
        this.isGif = false;
        this.aud = true;
        this.aue = null;
        this.auf = -1;
        this.aug = -1;
        this.auh = new AtomicBoolean(false);
        this.auj = false;
        this.timeStamp = -1L;
        this.aul = false;
        this.aun = new C0027a();
        this.auc = bitmap;
        this.isGif = z;
        this.url = str;
        this.aue = bArr;
        sf();
    }

    public a(b bVar, Bitmap bitmap, boolean z) {
        this.auc = null;
        this.isGif = false;
        this.aud = true;
        this.aue = null;
        this.auf = -1;
        this.aug = -1;
        this.auh = new AtomicBoolean(false);
        this.auj = false;
        this.timeStamp = -1L;
        this.aul = false;
        this.aun = new C0027a();
        this.aui = bVar;
        this.auc = bitmap;
        this.isGif = z;
    }

    public a(b bVar) {
        this.auc = null;
        this.isGif = false;
        this.aud = true;
        this.aue = null;
        this.auf = -1;
        this.aug = -1;
        this.auh = new AtomicBoolean(false);
        this.auj = false;
        this.timeStamp = -1L;
        this.aul = false;
        this.aun = new C0027a();
        this.aui = bVar;
        this.auj = true;
    }

    private void sf() {
        byte[] ninePatchChunk;
        if (this.auc != null && (ninePatchChunk = this.auc.getNinePatchChunk()) != null && ninePatchChunk.length > 0 && NinePatch.isNinePatchChunk(ninePatchChunk)) {
            this.aul = true;
            this.aum = new NinePatch(this.auc, ninePatchChunk, TbConfig.TMP_PIC_DIR_NAME);
        }
    }

    public boolean sg() {
        return this.auj;
    }

    public b getGif() {
        return this.aui;
    }

    public int getWidth() {
        if (this.auc == null) {
            return 0;
        }
        return this.auc.getWidth();
    }

    public int getHeight() {
        if (this.auc == null) {
            return 0;
        }
        return this.auc.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.auc != null) {
            this.auh.set(true);
            canvas.drawBitmap(this.auc, matrix, paint);
            this.auh.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.auc != null) {
            this.auh.set(true);
            canvas.drawBitmap(this.auc, f, f2, paint);
            this.auh.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.auc != null) {
            this.auh.set(true);
            canvas.drawBitmap(this.auc, rect, rectF, paint);
            this.auh.set(false);
        }
    }

    public void a(ImageView imageView) {
        if (imageView != null && this.auc != null) {
            this.aud = false;
            imageView.setImageBitmap(this.auc);
        }
    }

    public void a(Canvas canvas, RectF rectF) {
        if (this.aul && this.aum != null) {
            this.aum.draw(canvas, rectF);
        }
    }

    public boolean isGif() {
        return this.isGif;
    }

    public int size() {
        if (this.auc == null) {
            return 0;
        }
        return this.auc.getHeight() * this.auc.getRowBytes();
    }

    public boolean sh() {
        if (this.aud && !this.auh.get()) {
            if (this.auc != null) {
                Bitmap bitmap = this.auc;
                this.auc = null;
                bitmap.recycle();
            }
            if (this.aui != null) {
                b bVar = this.aui;
                this.aui = null;
                bVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap si() {
        this.aud = false;
        return this.auc;
    }

    public boolean sj() {
        return this.auc != null;
    }

    public BitmapDrawable sk() {
        if (this.auc == null) {
            return null;
        }
        this.aud = false;
        return new BitmapDrawable(this.auc) { // from class: com.baidu.adp.widget.a.a.1
            @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                Bitmap bitmap;
                if (a.this.auc != null && (bitmap = getBitmap()) != null && !bitmap.isRecycled()) {
                    canvas.drawBitmap(a.this.auc, (Rect) null, getBounds(), getPaint());
                }
            }
        };
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] sl() {
        byte[] byteArray;
        if (this.auc == null) {
            return null;
        }
        synchronized (lockForSyncImageDecoder) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.auc.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect sm() {
        return this.auk;
    }

    public byte[] sn() {
        return this.aue;
    }

    public BitmapShader so() {
        if (this.auc == null) {
            return null;
        }
        this.aud = false;
        return new BitmapShader(this.auc, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void ay(boolean z) {
        this.auh.set(z);
    }

    public boolean sp() {
        return this.aul;
    }
}
