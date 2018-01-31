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
    private Bitmap aue;
    private boolean auf;
    private byte[] aug;
    private int auh;
    private int aui;
    private AtomicBoolean auj;
    private b auk;
    private boolean aul;
    public Rect aum;
    private boolean aun;
    private NinePatch auo;
    public C0027a aup;
    private volatile boolean isGif;
    public long timeStamp;
    private String url;

    /* renamed from: com.baidu.adp.widget.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0027a {
        public String aur;
        public long aus;
        public boolean aut;
    }

    public a(Bitmap bitmap, boolean z) {
        this.aue = null;
        this.isGif = false;
        this.auf = true;
        this.aug = null;
        this.auh = -1;
        this.aui = -1;
        this.auj = new AtomicBoolean(false);
        this.aul = false;
        this.timeStamp = -1L;
        this.aun = false;
        this.aup = new C0027a();
        this.aue = bitmap;
        this.isGif = z;
        sg();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.aue = null;
        this.isGif = false;
        this.auf = true;
        this.aug = null;
        this.auh = -1;
        this.aui = -1;
        this.auj = new AtomicBoolean(false);
        this.aul = false;
        this.timeStamp = -1L;
        this.aun = false;
        this.aup = new C0027a();
        this.aue = bitmap;
        this.isGif = z;
        this.url = str;
        sg();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.aue = null;
        this.isGif = false;
        this.auf = true;
        this.aug = null;
        this.auh = -1;
        this.aui = -1;
        this.auj = new AtomicBoolean(false);
        this.aul = false;
        this.timeStamp = -1L;
        this.aun = false;
        this.aup = new C0027a();
        this.aue = bitmap;
        this.isGif = z;
        this.url = str;
        this.aum = rect;
        sg();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.aue = null;
        this.isGif = false;
        this.auf = true;
        this.aug = null;
        this.auh = -1;
        this.aui = -1;
        this.auj = new AtomicBoolean(false);
        this.aul = false;
        this.timeStamp = -1L;
        this.aun = false;
        this.aup = new C0027a();
        this.aue = bitmap;
        this.isGif = z;
        this.url = str;
        this.aug = bArr;
        sg();
    }

    public a(b bVar, Bitmap bitmap, boolean z) {
        this.aue = null;
        this.isGif = false;
        this.auf = true;
        this.aug = null;
        this.auh = -1;
        this.aui = -1;
        this.auj = new AtomicBoolean(false);
        this.aul = false;
        this.timeStamp = -1L;
        this.aun = false;
        this.aup = new C0027a();
        this.auk = bVar;
        this.aue = bitmap;
        this.isGif = z;
    }

    public a(b bVar) {
        this.aue = null;
        this.isGif = false;
        this.auf = true;
        this.aug = null;
        this.auh = -1;
        this.aui = -1;
        this.auj = new AtomicBoolean(false);
        this.aul = false;
        this.timeStamp = -1L;
        this.aun = false;
        this.aup = new C0027a();
        this.auk = bVar;
        this.aul = true;
    }

    private void sg() {
        byte[] ninePatchChunk;
        if (this.aue != null && (ninePatchChunk = this.aue.getNinePatchChunk()) != null && ninePatchChunk.length > 0 && NinePatch.isNinePatchChunk(ninePatchChunk)) {
            this.aun = true;
            this.auo = new NinePatch(this.aue, ninePatchChunk, TbConfig.TMP_PIC_DIR_NAME);
        }
    }

    public boolean sh() {
        return this.aul;
    }

    public b getGif() {
        return this.auk;
    }

    public int getWidth() {
        if (this.aue == null) {
            return 0;
        }
        return this.aue.getWidth();
    }

    public int getHeight() {
        if (this.aue == null) {
            return 0;
        }
        return this.aue.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.aue != null) {
            this.auj.set(true);
            canvas.drawBitmap(this.aue, matrix, paint);
            this.auj.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.aue != null) {
            this.auj.set(true);
            canvas.drawBitmap(this.aue, f, f2, paint);
            this.auj.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.aue != null) {
            this.auj.set(true);
            canvas.drawBitmap(this.aue, rect, rectF, paint);
            this.auj.set(false);
        }
    }

    public void a(ImageView imageView) {
        if (imageView != null && this.aue != null) {
            this.auf = false;
            imageView.setImageBitmap(this.aue);
        }
    }

    public void a(Canvas canvas, RectF rectF) {
        if (this.aun && this.auo != null) {
            this.auo.draw(canvas, rectF);
        }
    }

    public boolean isGif() {
        return this.isGif;
    }

    public int size() {
        if (this.aue == null) {
            return 0;
        }
        return this.aue.getHeight() * this.aue.getRowBytes();
    }

    public boolean si() {
        if (this.auf && !this.auj.get()) {
            if (this.aue != null) {
                Bitmap bitmap = this.aue;
                this.aue = null;
                bitmap.recycle();
            }
            if (this.auk != null) {
                b bVar = this.auk;
                this.auk = null;
                bVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap sj() {
        this.auf = false;
        return this.aue;
    }

    public boolean sk() {
        return this.aue != null;
    }

    public BitmapDrawable sl() {
        if (this.aue == null) {
            return null;
        }
        this.auf = false;
        return new BitmapDrawable(this.aue) { // from class: com.baidu.adp.widget.a.a.1
            @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                Bitmap bitmap;
                if (a.this.aue != null && (bitmap = getBitmap()) != null && !bitmap.isRecycled()) {
                    canvas.drawBitmap(a.this.aue, (Rect) null, getBounds(), getPaint());
                }
            }
        };
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] sm() {
        byte[] byteArray;
        if (this.aue == null) {
            return null;
        }
        synchronized (lockForSyncImageDecoder) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.aue.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect sn() {
        return this.aum;
    }

    public byte[] so() {
        return this.aug;
    }

    public BitmapShader sp() {
        if (this.aue == null) {
            return null;
        }
        this.auf = false;
        return new BitmapShader(this.aue, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void az(boolean z) {
        this.auj.set(z);
    }

    public boolean sq() {
        return this.aun;
    }
}
