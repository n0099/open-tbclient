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
    private final Paint paint;
    private float yJ;
    protected float yK;
    protected float yL;
    private final float yM;
    private final Rect yN;
    private final Rect yO;
    private int yP;
    private boolean yQ;
    private float yR;
    private final DisplayMetrics yS;

    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.yJ = 0.0f;
        this.yN = new Rect();
        this.yO = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.yJ = obtainStyledAttributes.getDimensionPixelSize(1, 0) / 2.0f;
        this.yK = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        this.yL = getResources().getDisplayMetrics().widthPixels;
        this.yM = this.yK + (this.yJ * 2.0f);
        this.paint = new Paint();
        this.yS = getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        this.yQ = true;
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.yQ) {
            jk();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.yQ) {
            jk();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        jk();
    }

    private void jk() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            int measuredHeight = getMeasuredHeight();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.yR = intrinsicHeight / 10.0f;
            this.yP = (int) (intrinsicHeight - (((((this.yM - measuredHeight) / 2.0f) * this.yR) / this.yJ) * 2.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.yS);
            int scaledHeight = (bitmap.getScaledHeight(this.yS) - this.yP) / 2;
            this.yN.set(0, scaledHeight, scaledWidth, this.yP + scaledHeight);
            int width = getWidth();
            float max = Math.max(width / scaledWidth, getHeight() / this.yP);
            int i = (int) (scaledWidth * max);
            int i2 = (i - width) / 2;
            this.yO.set(-i2, 0, i - (i2 * 2), (int) (max * this.yP));
            canvas.drawBitmap(bitmap, this.yN, this.yO, this.paint);
        }
    }

    public boolean getEditable() {
        return false;
    }
}
