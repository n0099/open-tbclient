package com.baidu.live.adp.widget.imageview;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.widget.ImageView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.widget.RoundCornerDecor;
import com.baidu.live.adp.widget.RoundCornerDecor23;
import com.baidu.live.adp.widget.RoundCornerDecor40;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class BdImage {
    private static final int BORDER_WIDTH = 1;
    public static final Object lockForSyncImageDecoder = new Object();
    private AtomicBoolean drawingNow;
    private Bitmap image;
    private volatile boolean isGif;
    private boolean isNinePatchBitmap;
    public PerfResourceLogData logData;
    private Paint mBorderPaint;
    private RectF mBorderRect;
    private int mBorderWidth;
    private byte[] mByteData;
    private int mCornerRadius;
    private int mDrawHeight;
    private int mDrawWidth;
    private boolean mIsEmotionGif;
    public Rect mPadding;
    private boolean mRecyclable;
    private RoundCornerDecor mRoundCornerDecor;
    private NinePatch ninePatch;
    public long timeStamp;
    private String url;

    /* loaded from: classes6.dex */
    public static class PerfResourceLogData {
        public long costTime;
        public boolean isScuess;
        public String resourceFromType;
    }

    public BdImage(Bitmap bitmap, boolean z) {
        this.image = null;
        this.isGif = false;
        this.mRecyclable = true;
        this.mByteData = null;
        this.mDrawWidth = -1;
        this.mDrawHeight = -1;
        this.drawingNow = new AtomicBoolean(false);
        this.mIsEmotionGif = false;
        this.timeStamp = -1L;
        this.isNinePatchBitmap = false;
        this.logData = new PerfResourceLogData();
        this.image = bitmap;
        this.isGif = z;
        checkIsNinePatchBitmap();
    }

    public BdImage(Bitmap bitmap, boolean z, String str) {
        this.image = null;
        this.isGif = false;
        this.mRecyclable = true;
        this.mByteData = null;
        this.mDrawWidth = -1;
        this.mDrawHeight = -1;
        this.drawingNow = new AtomicBoolean(false);
        this.mIsEmotionGif = false;
        this.timeStamp = -1L;
        this.isNinePatchBitmap = false;
        this.logData = new PerfResourceLogData();
        this.image = bitmap;
        this.isGif = z;
        this.url = str;
        checkIsNinePatchBitmap();
    }

    public BdImage(Bitmap bitmap, boolean z, String str, Rect rect) {
        this.image = null;
        this.isGif = false;
        this.mRecyclable = true;
        this.mByteData = null;
        this.mDrawWidth = -1;
        this.mDrawHeight = -1;
        this.drawingNow = new AtomicBoolean(false);
        this.mIsEmotionGif = false;
        this.timeStamp = -1L;
        this.isNinePatchBitmap = false;
        this.logData = new PerfResourceLogData();
        this.image = bitmap;
        this.isGif = z;
        this.url = str;
        this.mPadding = rect;
        checkIsNinePatchBitmap();
    }

    public BdImage(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        this.image = null;
        this.isGif = false;
        this.mRecyclable = true;
        this.mByteData = null;
        this.mDrawWidth = -1;
        this.mDrawHeight = -1;
        this.drawingNow = new AtomicBoolean(false);
        this.mIsEmotionGif = false;
        this.timeStamp = -1L;
        this.isNinePatchBitmap = false;
        this.logData = new PerfResourceLogData();
        this.image = bitmap;
        this.isGif = z;
        this.url = str;
        this.mByteData = bArr;
        checkIsNinePatchBitmap();
    }

    public void setBitmapAndUrl(Bitmap bitmap, String str) {
        this.image = bitmap;
        this.url = str;
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

    public void setIsEmotionGif(boolean z) {
        this.mIsEmotionGif = z;
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

    public void drawImageAsBackgroundResource(ImageView imageView) {
        if (this.image != null) {
            this.mRecyclable = false;
            imageView.setBackgroundDrawable(new BitmapDrawable(this.image));
        }
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

    public void drawScaledImageTo(Canvas canvas, int i, int i2, Paint paint) {
        if (this.image != null) {
            this.drawingNow.set(true);
            float max = Math.max(i / this.image.getWidth(), i2 / this.image.getHeight());
            canvas.save();
            canvas.scale(max, max, i >> 1, i2 >> 1);
            canvas.drawBitmap(this.image, (i - this.image.getWidth()) >> 1, (i2 - this.image.getHeight()) >> 1, paint);
            canvas.restore();
            this.drawingNow.set(false);
        }
    }

    public void drawImageTo(Canvas canvas, Rect rect, Rect rect2, Paint paint) {
        if (this.image != null) {
            this.drawingNow.set(true);
            canvas.drawBitmap(this.image, rect, rect2, paint);
            this.drawingNow.set(false);
        }
    }

    public void drawImageTo(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        if (this.image != null && !this.image.isRecycled()) {
            this.drawingNow.set(true);
            canvas.drawBitmap(this.image, rect, rectF, paint);
            this.drawingNow.set(false);
        }
    }

    public void drawImageWidthRoundDecor(Canvas canvas, Matrix matrix, Resources resources, ImageView imageView, int i, ColorFilter colorFilter) {
        if (this.image != null) {
            if (this.mDrawWidth != imageView.getMeasuredWidth() || this.mDrawHeight != imageView.getMeasuredHeight()) {
                this.mRoundCornerDecor = null;
                this.mDrawWidth = imageView.getMeasuredWidth();
                this.mDrawHeight = imageView.getMeasuredHeight();
            }
            this.drawingNow.set(true);
            if (this.mRoundCornerDecor == null || this.mCornerRadius != i) {
                this.mCornerRadius = i;
                if (Build.VERSION.SDK_INT < 11 && imageView.getMeasuredWidth() > BdUtilHelper.dip2px(imageView.getContext(), 100.0f)) {
                    this.mRoundCornerDecor = new RoundCornerDecor23(resources, matrix, imageView, this.image, this.mCornerRadius, colorFilter);
                } else {
                    this.mRoundCornerDecor = new RoundCornerDecor40(resources, matrix, imageView, this.image, this.mCornerRadius, colorFilter);
                }
                this.mRoundCornerDecor.setBounds(0, 0, imageView.getMeasuredWidth(), imageView.getMeasuredHeight());
                this.mBorderRect = new RectF();
                this.mBorderWidth = (int) ((resources.getDisplayMetrics().density * 1.0f) + 0.5d);
                int i2 = this.mBorderWidth >> 1;
                this.mBorderRect.set(i2, i2, imageView.getMeasuredWidth() - i2, imageView.getMeasuredHeight() - i2);
                this.mBorderPaint = new Paint();
                this.mBorderPaint.setStyle(Paint.Style.STROKE);
                this.mBorderPaint.setAntiAlias(true);
                this.mBorderPaint.setColor(637534208);
                this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
                if (colorFilter != null) {
                    this.mBorderPaint.setColorFilter(colorFilter);
                }
            } else {
                this.mRoundCornerDecor.setColorFilterForSkin(colorFilter);
                this.mBorderPaint.setColorFilter(colorFilter);
            }
            this.mRoundCornerDecor.draw(canvas);
            canvas.drawRoundRect(this.mBorderRect, this.mCornerRadius, this.mCornerRadius, this.mBorderPaint);
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

    public boolean isTheSame(Bitmap bitmap) {
        return this.image == bitmap;
    }

    public BitmapDrawable getAsBitmapDrawable() {
        if (this.image == null) {
            return null;
        }
        this.mRecyclable = false;
        return new BitmapDrawable(this.image) { // from class: com.baidu.live.adp.widget.imageview.BdImage.1
            @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                Bitmap bitmap;
                if (BdImage.this.image != null && (bitmap = getBitmap()) != null && !bitmap.isRecycled()) {
                    canvas.drawBitmap(BdImage.this.image, (Rect) null, getBounds(), getPaint());
                }
            }
        };
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
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

    public void setPadding(Rect rect) {
        this.mPadding = rect;
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

    public void reset() {
        this.image = null;
        this.mByteData = null;
    }
}
