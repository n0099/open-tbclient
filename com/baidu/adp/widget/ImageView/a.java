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
import java.io.ByteArrayOutputStream;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class a {
    public static final Object lockForSyncImageDecoder = new Object();
    private AtomicBoolean drawingNow;
    private Bitmap image;
    private volatile boolean isGif;
    private boolean isNinePatchBitmap;
    private byte[] mByteData;
    private int mDrawHeight;
    private int mDrawWidth;
    private boolean mIsEmotionGif;
    public Rect mPadding;
    private boolean mRecyclable;
    private int mRequestHeight;
    private int mRequestWidth;
    private boolean needCache;
    private NinePatch ninePatch;
    public long timeStamp;
    private String url;
    private com.baidu.adp.gif.b zW;
    public C0027a zX;

    /* renamed from: com.baidu.adp.widget.ImageView.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0027a {
        public long costTime;
        public boolean isScuess;
        public String resourceFromType;
    }

    public a(Bitmap bitmap, boolean z) {
        this.image = null;
        this.isGif = false;
        this.mRecyclable = true;
        this.mByteData = null;
        this.mDrawWidth = -1;
        this.mDrawHeight = -1;
        this.needCache = true;
        this.drawingNow = new AtomicBoolean(false);
        this.mIsEmotionGif = false;
        this.timeStamp = -1L;
        this.isNinePatchBitmap = false;
        this.zX = new C0027a();
        this.image = bitmap;
        this.isGif = z;
        checkIsNinePatchBitmap();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        this.image = null;
        this.isGif = false;
        this.mRecyclable = true;
        this.mByteData = null;
        this.mDrawWidth = -1;
        this.mDrawHeight = -1;
        this.needCache = true;
        this.drawingNow = new AtomicBoolean(false);
        this.mIsEmotionGif = false;
        this.timeStamp = -1L;
        this.isNinePatchBitmap = false;
        this.zX = new C0027a();
        this.image = bitmap;
        this.isGif = z;
        this.url = str;
        checkIsNinePatchBitmap();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.image = null;
        this.isGif = false;
        this.mRecyclable = true;
        this.mByteData = null;
        this.mDrawWidth = -1;
        this.mDrawHeight = -1;
        this.needCache = true;
        this.drawingNow = new AtomicBoolean(false);
        this.mIsEmotionGif = false;
        this.timeStamp = -1L;
        this.isNinePatchBitmap = false;
        this.zX = new C0027a();
        this.image = bitmap;
        this.isGif = z;
        this.url = str;
        this.mPadding = rect;
        checkIsNinePatchBitmap();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.image = null;
        this.isGif = false;
        this.mRecyclable = true;
        this.mByteData = null;
        this.mDrawWidth = -1;
        this.mDrawHeight = -1;
        this.needCache = true;
        this.drawingNow = new AtomicBoolean(false);
        this.mIsEmotionGif = false;
        this.timeStamp = -1L;
        this.isNinePatchBitmap = false;
        this.zX = new C0027a();
        this.image = bitmap;
        this.isGif = z;
        this.url = str;
        this.mByteData = bArr;
        checkIsNinePatchBitmap();
    }

    public a(com.baidu.adp.gif.b bVar, Bitmap bitmap, boolean z) {
        this.image = null;
        this.isGif = false;
        this.mRecyclable = true;
        this.mByteData = null;
        this.mDrawWidth = -1;
        this.mDrawHeight = -1;
        this.needCache = true;
        this.drawingNow = new AtomicBoolean(false);
        this.mIsEmotionGif = false;
        this.timeStamp = -1L;
        this.isNinePatchBitmap = false;
        this.zX = new C0027a();
        this.zW = bVar;
        this.image = bitmap;
        this.isGif = z;
    }

    public a(com.baidu.adp.gif.b bVar) {
        this.image = null;
        this.isGif = false;
        this.mRecyclable = true;
        this.mByteData = null;
        this.mDrawWidth = -1;
        this.mDrawHeight = -1;
        this.needCache = true;
        this.drawingNow = new AtomicBoolean(false);
        this.mIsEmotionGif = false;
        this.timeStamp = -1L;
        this.isNinePatchBitmap = false;
        this.zX = new C0027a();
        this.zW = bVar;
        this.mIsEmotionGif = true;
    }

    private void checkIsNinePatchBitmap() {
        byte[] ninePatchChunk;
        if (this.image != null && (ninePatchChunk = this.image.getNinePatchChunk()) != null && ninePatchChunk.length > 0 && NinePatch.isNinePatchChunk(ninePatchChunk)) {
            this.isNinePatchBitmap = true;
            this.ninePatch = new NinePatch(this.image, ninePatchChunk, "image");
        }
    }

    public boolean isEmotionGif() {
        return this.mIsEmotionGif;
    }

    public com.baidu.adp.gif.b getGif() {
        return this.zW;
    }

    public int getWidth() {
        if (this.image == null) {
            return 0;
        }
        return this.image.getWidth();
    }

    public int getHeight() {
        if (this.image == null) {
            return 0;
        }
        return this.image.getHeight();
    }

    public void drawImageTo(Canvas canvas, Matrix matrix, Paint paint) {
        if (this.image != null) {
            this.drawingNow.set(true);
            canvas.drawBitmap(this.image, matrix, paint);
            this.drawingNow.set(false);
        }
    }

    public void drawImageTo(Canvas canvas, float f, float f2, Paint paint) {
        if (this.image != null) {
            this.drawingNow.set(true);
            canvas.drawBitmap(this.image, f, f2, paint);
            this.drawingNow.set(false);
        }
    }

    public void drawImageTo(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.image != null) {
            this.drawingNow.set(true);
            canvas.drawBitmap(this.image, rect, rectF, paint);
            this.drawingNow.set(false);
        }
    }

    public void drawImageTo(ImageView imageView) {
        if (imageView != null && this.image != null) {
            this.mRecyclable = false;
            imageView.setImageBitmap(this.image);
        }
    }

    public void drawNinePatchImage(Canvas canvas, RectF rectF) {
        if (this.isNinePatchBitmap && this.ninePatch != null) {
            this.ninePatch.draw(canvas, rectF);
        }
    }

    public boolean isGif() {
        return this.isGif;
    }

    public int size() {
        if (this.image == null) {
            return 0;
        }
        return this.image.getHeight() * this.image.getRowBytes();
    }

    public boolean recycle() {
        if (this.mRecyclable && !this.drawingNow.get()) {
            if (this.image != null) {
                Bitmap bitmap = this.image;
                this.image = null;
                bitmap.recycle();
            }
            if (this.zW != null) {
                com.baidu.adp.gif.b bVar = this.zW;
                this.zW = null;
                bVar.close();
            }
            return true;
        }
        return false;
    }

    public Bitmap getRawBitmap() {
        this.mRecyclable = false;
        return this.image;
    }

    public boolean isValidNow() {
        return this.image != null;
    }

    public BitmapDrawable getAsBitmapDrawable() {
        if (this.image == null) {
            return null;
        }
        this.mRecyclable = false;
        return new BitmapDrawable(this.image) { // from class: com.baidu.adp.widget.ImageView.a.1
            @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                Bitmap bitmap;
                if (a.this.image != null && (bitmap = getBitmap()) != null && !bitmap.isRecycled()) {
                    canvas.drawBitmap(a.this.image, (Rect) null, getBounds(), getPaint());
                }
            }
        };
    }

    public String getUrl() {
        return this.url;
    }

    public byte[] getImageByte() {
        byte[] byteArray;
        if (this.image == null) {
            return null;
        }
        synchronized (lockForSyncImageDecoder) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.image.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return byteArray;
    }

    public Rect getPadding() {
        return this.mPadding;
    }

    public byte[] getByteData() {
        return this.mByteData;
    }

    public BitmapShader createBitmapShader() {
        if (this.image == null || this.image.isRecycled()) {
            return null;
        }
        this.mRecyclable = false;
        return new BitmapShader(this.image, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    public void changeDrawing(boolean z) {
        this.drawingNow.set(z);
    }

    public boolean isNinePatchBitmap() {
        return this.isNinePatchBitmap;
    }

    public void ai(int i) {
        this.mRequestWidth = i;
    }

    public void aj(int i) {
        this.mRequestHeight = i;
    }

    public void setNeedCache(boolean z) {
        this.needCache = z;
    }

    public boolean isNeedCache() {
        return this.needCache;
    }
}
