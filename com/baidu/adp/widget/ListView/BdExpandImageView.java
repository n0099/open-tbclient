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
    private float tJ;
    protected float tK;
    protected float tL;
    private final float tM;
    private final Rect tN;
    private final Rect tO;
    private int tP;
    private boolean tQ;
    private final Paint tR;
    private float tS;
    private final DisplayMetrics tT;

    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.tJ = 0.0f;
        this.mEnabled = false;
        this.tN = new Rect();
        this.tO = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.tJ = obtainStyledAttributes.getDimensionPixelSize(1, 0) / 2;
        this.tK = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        this.tL = getResources().getDisplayMetrics().widthPixels;
        this.tM = this.tK + (2.0f * this.tJ);
        this.tR = new Paint();
        this.tT = getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        this.tQ = true;
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.tQ) {
            hv();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.tQ) {
            hv();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        hv();
    }

    private void hv() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            int measuredHeight = getMeasuredHeight();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.tS = intrinsicHeight / 10;
            this.tP = (int) (intrinsicHeight - (((((this.tM - measuredHeight) / 2.0f) * this.tS) / this.tJ) * 2.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.tT);
            int scaledHeight = (bitmap.getScaledHeight(this.tT) - this.tP) / 2;
            this.tN.set(0, scaledHeight, scaledWidth, this.tP + scaledHeight);
            int width = getWidth();
            float max = Math.max(width / scaledWidth, getHeight() / this.tP);
            int i = (int) (scaledWidth * max);
            int i2 = (i - width) / 2;
            this.tO.set(-i2, 0, i - (i2 * 2), (int) (max * this.tP));
            canvas.drawBitmap(bitmap, this.tN, this.tO, this.tR);
        }
    }

    public boolean getEditable() {
        return false;
    }
}
