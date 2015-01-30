package com.baidu.adp.widget.ListView;

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
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class BdExpandImageView extends ImageView {
    private final boolean mEnabled;
    private final Paint paint;
    private float vY;
    protected float vZ;
    protected float wa;
    private final float wb;
    private final Rect wc;
    private final Rect wd;
    private int we;
    private boolean wf;
    private float wg;
    private final DisplayMetrics wh;

    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.vY = 0.0f;
        this.mEnabled = false;
        this.wc = new Rect();
        this.wd = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.vY = obtainStyledAttributes.getDimensionPixelSize(1, 0) / 2;
        this.vZ = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        this.wa = getResources().getDisplayMetrics().widthPixels;
        this.wb = this.vZ + (2.0f * this.vY);
        this.paint = new Paint();
        this.wh = getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        this.wf = true;
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.wf) {
            jt();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.wf) {
            jt();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        jt();
    }

    private void jt() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            int measuredHeight = getMeasuredHeight();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.wg = intrinsicHeight / 10;
            this.we = (int) (intrinsicHeight - (((((this.wb - measuredHeight) / 2.0f) * this.wg) / this.vY) * 2.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.wh);
            int scaledHeight = (bitmap.getScaledHeight(this.wh) - this.we) / 2;
            this.wc.set(0, scaledHeight, scaledWidth, this.we + scaledHeight);
            int width = getWidth();
            float max = Math.max(width / scaledWidth, getHeight() / this.we);
            int i = (int) (scaledWidth * max);
            int i2 = (i - width) / 2;
            this.wd.set(-i2, 0, i - (i2 * 2), (int) (max * this.we));
            canvas.drawBitmap(bitmap, this.wc, this.wd, this.paint);
        }
    }

    public boolean getEditable() {
        return false;
    }
}
