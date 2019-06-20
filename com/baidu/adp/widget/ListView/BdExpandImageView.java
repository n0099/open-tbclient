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
    private float Mo;
    protected float Mp;
    protected float Mq;
    private final float Mr;
    private int Ms;
    private boolean Mt;
    private float Mu;
    private final DisplayMetrics Mv;
    private final Rect pK;
    private final Rect pL;
    private final Paint paint;

    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Mo = 0.0f;
        this.pK = new Rect();
        this.pL = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.Mo = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0) / 2.0f;
        this.Mp = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_beforeExpandHeight, 0);
        obtainStyledAttributes.recycle();
        this.Mq = getResources().getDisplayMetrics().widthPixels;
        this.Mr = this.Mp + (this.Mo * 2.0f);
        this.paint = new Paint();
        this.Mv = getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        this.Mt = true;
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.Mt) {
            nC();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.Mt) {
            nC();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        nC();
    }

    private void nC() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            int measuredHeight = getMeasuredHeight();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.Mu = intrinsicHeight / 10.0f;
            this.Ms = (int) (intrinsicHeight - (((((this.Mr - measuredHeight) / 2.0f) * this.Mu) / this.Mo) * 2.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.Mv);
            int scaledHeight = (bitmap.getScaledHeight(this.Mv) - this.Ms) / 2;
            this.pK.set(0, scaledHeight, scaledWidth, this.Ms + scaledHeight);
            int width = getWidth();
            float max = Math.max(width / scaledWidth, getHeight() / this.Ms);
            int i = (int) (scaledWidth * max);
            int i2 = (i - width) / 2;
            this.pL.set(-i2, 0, i - (i2 * 2), (int) (max * this.Ms));
            canvas.drawBitmap(bitmap, this.pK, this.pL, this.paint);
        }
    }

    public boolean getEditable() {
        return false;
    }
}
