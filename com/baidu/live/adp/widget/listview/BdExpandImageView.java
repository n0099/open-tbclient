package com.baidu.live.adp.widget.listview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.baidu.live.adp.R;
/* loaded from: classes4.dex */
public class BdExpandImageView extends ImageView {
    private static final boolean mEnabled = false;
    private final DisplayMetrics dm;
    private float drawableDis;
    private int drawableHeight;
    private final Rect dst;
    private final float finalHeight;
    private boolean hasSetFrame;
    protected float mCoverHeight;
    protected float mCoverWidth;
    private float mVerticalInvisibleHeight;
    private final Paint paint;
    private final Rect src;

    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mVerticalInvisibleHeight = 0.0f;
        this.src = new Rect();
        this.dst = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.sdk_ExpandListView);
        this.mVerticalInvisibleHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.sdk_ExpandListView_expandDistance, 0) / 2.0f;
        this.mCoverHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.sdk_ExpandListView_beforeExpandHeight, 0);
        obtainStyledAttributes.recycle();
        this.mCoverWidth = getResources().getDisplayMetrics().widthPixels;
        this.finalHeight = this.mCoverHeight + (this.mVerticalInvisibleHeight * 2.0f);
        this.paint = new Paint();
        this.dm = getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        this.hasSetFrame = true;
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.hasSetFrame) {
            recompute();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.hasSetFrame) {
            recompute();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        recompute();
    }

    private void recompute() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            int measuredHeight = getMeasuredHeight();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.drawableDis = intrinsicHeight / 10.0f;
            this.drawableHeight = (int) (intrinsicHeight - (((((this.finalHeight - measuredHeight) / 2.0f) * this.drawableDis) / this.mVerticalInvisibleHeight) * 2.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.dm);
            int scaledHeight = (bitmap.getScaledHeight(this.dm) - this.drawableHeight) / 2;
            this.src.set(0, scaledHeight, scaledWidth, this.drawableHeight + scaledHeight);
            int width = getWidth();
            float max = Math.max(width / scaledWidth, getHeight() / this.drawableHeight);
            int i = (int) (scaledWidth * max);
            int i2 = (i - width) / 2;
            this.dst.set(-i2, 0, i - (i2 * 2), (int) (max * this.drawableHeight));
            canvas.drawBitmap(bitmap, this.src, this.dst, this.paint);
        }
    }

    public boolean getEditable() {
        return false;
    }
}
