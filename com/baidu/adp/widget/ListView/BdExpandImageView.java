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
    private float HI;
    protected float HJ;
    protected float HK;
    private final float HL;
    private final Rect HM;
    private final Rect HN;
    private int HO;
    private boolean HP;
    private float HQ;
    private final DisplayMetrics HR;
    private final Paint paint;

    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.HI = 0.0f;
        this.HM = new Rect();
        this.HN = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.HI = obtainStyledAttributes.getDimensionPixelSize(1, 0) / 2.0f;
        this.HJ = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        this.HK = getResources().getDisplayMetrics().widthPixels;
        this.HL = this.HJ + (this.HI * 2.0f);
        this.paint = new Paint();
        this.HR = getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        this.HP = true;
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.HP) {
            nc();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.HP) {
            nc();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        nc();
    }

    private void nc() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            int measuredHeight = getMeasuredHeight();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.HQ = intrinsicHeight / 10.0f;
            this.HO = (int) (intrinsicHeight - (((((this.HL - measuredHeight) / 2.0f) * this.HQ) / this.HI) * 2.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.HR);
            int scaledHeight = (bitmap.getScaledHeight(this.HR) - this.HO) / 2;
            this.HM.set(0, scaledHeight, scaledWidth, this.HO + scaledHeight);
            int width = getWidth();
            float max = Math.max(width / scaledWidth, getHeight() / this.HO);
            int i = (int) (scaledWidth * max);
            int i2 = (i - width) / 2;
            this.HN.set(-i2, 0, i - (i2 * 2), (int) (max * this.HO));
            canvas.drawBitmap(bitmap, this.HM, this.HN, this.paint);
        }
    }

    public boolean getEditable() {
        return false;
    }
}
