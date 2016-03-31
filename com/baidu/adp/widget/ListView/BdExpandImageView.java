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
    private float HO;
    protected float HP;
    protected float HQ;
    private final float HR;
    private final Rect HT;
    private final Rect HU;
    private int HV;
    private boolean HW;
    private float HX;
    private final DisplayMetrics HY;
    private final Paint paint;

    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.HO = 0.0f;
        this.HT = new Rect();
        this.HU = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.HO = obtainStyledAttributes.getDimensionPixelSize(1, 0) / 2.0f;
        this.HP = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        this.HQ = getResources().getDisplayMetrics().widthPixels;
        this.HR = this.HP + (this.HO * 2.0f);
        this.paint = new Paint();
        this.HY = getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        this.HW = true;
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.HW) {
            mU();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.HW) {
            mU();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        mU();
    }

    private void mU() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            int measuredHeight = getMeasuredHeight();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.HX = intrinsicHeight / 10.0f;
            this.HV = (int) (intrinsicHeight - (((((this.HR - measuredHeight) / 2.0f) * this.HX) / this.HO) * 2.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.HY);
            int scaledHeight = (bitmap.getScaledHeight(this.HY) - this.HV) / 2;
            this.HT.set(0, scaledHeight, scaledWidth, this.HV + scaledHeight);
            int width = getWidth();
            float max = Math.max(width / scaledWidth, getHeight() / this.HV);
            int i = (int) (scaledWidth * max);
            int i2 = (i - width) / 2;
            this.HU.set(-i2, 0, i - (i2 * 2), (int) (max * this.HV));
            canvas.drawBitmap(bitmap, this.HT, this.HU, this.paint);
        }
    }

    public boolean getEditable() {
        return false;
    }
}
