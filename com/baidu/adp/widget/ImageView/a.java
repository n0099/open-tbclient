package com.baidu.adp.widget.ImageView;

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
    private Bitmap MW;
    private boolean MX;
    private byte[] MY;
    private int MZ;
    private int Na;
    private int Nb;
    private int Nc;
    private AtomicBoolean Nd;
    private com.baidu.adp.gif.b Ne;
    private boolean Nf;
    public Rect Ng;
    private boolean Nh;
    private NinePatch Ni;
    public C0023a Nj;
    private volatile boolean isGif;
    public long timeStamp;
    private String url;

    /* renamed from: com.baidu.adp.widget.ImageView.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0023a {
        public String Nl;
        public long Nm;
        public boolean Nn;
    }

    public a(Bitmap bitmap, boolean z) {
        this.MW = null;
        this.isGif = false;
        this.MX = true;
        this.MY = null;
        this.MZ = -1;
        this.Na = -1;
        this.Nd = new AtomicBoolean(false);
        this.Nf = false;
        this.timeStamp = -1L;
        this.Nh = false;
        this.Nj = new C0023a();
        this.MW = bitmap;
        this.isGif = z;
        oe();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.MW = null;
        this.isGif = false;
        this.MX = true;
        this.MY = null;
        this.MZ = -1;
        this.Na = -1;
        this.Nd = new AtomicBoolean(false);
        this.Nf = false;
        this.timeStamp = -1L;
        this.Nh = false;
        this.Nj = new C0023a();
        this.MW = bitmap;
        this.isGif = z;
        this.url = str;
        oe();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.MW = null;
        this.isGif = false;
        this.MX = true;
        this.MY = null;
        this.MZ = -1;
        this.Na = -1;
        this.Nd = new AtomicBoolean(false);
        this.Nf = false;
        this.timeStamp = -1L;
        this.Nh = false;
        this.Nj = new C0023a();
        this.MW = bitmap;
        this.isGif = z;
        this.url = str;
        this.Ng = rect;
        oe();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.MW = null;
        this.isGif = false;
        this.MX = true;
        this.MY = null;
        this.MZ = -1;
        this.Na = -1;
        this.Nd = new AtomicBoolean(false);
        this.Nf = false;
        this.timeStamp = -1L;
        this.Nh = false;
        this.Nj = new C0023a();
        this.MW = bitmap;
        this.isGif = z;
        this.url = str;
        this.MY = bArr;
        oe();
    }

    public a(com.baidu.adp.gif.b bVar, Bitmap bitmap, boolean z) {
        this.MW = null;
        this.isGif = false;
        this.MX = true;
        this.MY = null;
        this.MZ = -1;
        this.Na = -1;
        this.Nd = new AtomicBoolean(false);
        this.Nf = false;
        this.timeStamp = -1L;
        this.Nh = false;
        this.Nj = new C0023a();
        this.Ne = bVar;
        this.MW = bitmap;
        this.isGif = z;
    }

    public a(com.baidu.adp.gif.b bVar) {
        this.MW = null;
        this.isGif = false;
        this.MX = true;
        this.MY = null;
        this.MZ = -1;
        this.Na = -1;
        this.Nd = new AtomicBoolean(false);
        this.Nf = false;
        this.timeStamp = -1L;
        this.Nh = false;
        this.Nj = new C0023a();
        this.Ne = bVar;
        this.Nf = true;
    }

    private void oe() {
        byte[] ninePatchChunk;
        if (this.MW != null && (ninePatchChunk = this.MW.getNinePatchChunk()) != null && ninePatchChunk.length > 0 && NinePatch.isNinePatchChunk(ninePatchChunk)) {
            this.Nh = true;
            this.Ni = new NinePatch(this.MW, ninePatchChunk, TbConfig.TMP_PIC_DIR_NAME);
        }
    }

    public boolean of() {
        return this.Nf;
    }

    public com.baidu.adp.gif.b getGif() {
        return this.Ne;
    }

    public int getWidth() {
        if (this.MW == null) {
            return 0;
        }
        return this.MW.getWidth();
    }

    public int getHeight() {
        if (this.MW == null) {
            return 0;
        }
        return this.MW.getHeight();
    }

    public void a(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.MW != null) {
            this.Nd.set(true);
            canvas.drawBitmap(this.MW, matrix, paint);
            this.Nd.set(false);
        }
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        if (this.MW != null) {
            this.Nd.set(true);
            canvas.drawBitmap(this.MW, f, f2, paint);
            this.Nd.set(false);
        }
    }

    public void a(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.MW != null) {
            this.Nd.set(true);
            canvas.drawBitmap(this.MW, rect, rectF, paint);
            this.Nd.set(false);
        }
    }

    public void a(ImageView imageView) {
        if (imageView != null && this.MW != null) {
            this.MX = false;
            imageView.setImageBitmap(this.MW);
        }
    }

    public void a(Canvas canvas, RectF rectF) {
        if (this.Nh && this.Ni != null) {
            this.Ni.draw(canvas, rectF);
        }
    }

    public boolean isGif() {
        return this.isGif;
    }

    public int size() {
        if (this.MW == null) {
            return 0;
        }
        return this.MW.getHeight() * this.MW.getRowBytes();
    }

    public boolean og() {
        if (this.MX && !this.Nd.get()) {
            if (this.MW != null) {
                Bitmap bitmap = this.MW;
                this.MW = null;
                bitmap.recycle();
            }
            if (this.Ne != null) {
                com.baidu.adp.gif.b bVar = this.Ne;
                this.Ne = null;
                bVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap oh() {
        this.MX = false;
        return this.MW;
    }

    public boolean oi() {
        return this.MW != null;
    }

    public BitmapDrawable oj() {
        if (this.MW == null) {
            return null;
        }
        this.MX = false;
        return new BitmapDrawable(this.MW) { // from class: com.baidu.adp.widget.ImageView.a.1
            @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                Bitmap bitmap;
                if (a.this.MW != null && (bitmap = getBitmap()) != null && !bitmap.isRecycled()) {
                    canvas.drawBitmap(a.this.MW, (Rect) null, getBounds(), getPaint());
                }
            }
        };
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] ok() {
        byte[] byteArray;
        if (this.MW == null) {
            return null;
        }
        synchronized (lockForSyncImageDecoder) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.MW.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect ol() {
        return this.Ng;
    }

    public byte[] om() {
        return this.MY;
    }

    public BitmapShader on() {
        if (this.MW == null || this.MW.isRecycled()) {
            return null;
        }
        this.MX = false;
        return new BitmapShader(this.MW, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void ag(boolean z) {
        this.Nd.set(z);
    }

    public boolean oo() {
        return this.Nh;
    }

    public void aN(int i) {
        this.Nb = i;
    }

    public void aO(int i) {
        this.Nc = i;
    }
}
