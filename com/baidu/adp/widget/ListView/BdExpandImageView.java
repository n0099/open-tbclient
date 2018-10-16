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
    private float Oc;
    protected float Od;
    protected float Oe;
    private final float Of;
    private int Og;
    private boolean Oh;
    private float Oi;
    private final DisplayMetrics Oj;
    private final Paint paint;
    private final Rect sg;
    private final Rect sh;

    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Oc = 0.0f;
        this.sg = new Rect();
        this.sh = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.Oc = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0) / 2.0f;
        this.Od = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_beforeExpandHeight, 0);
        obtainStyledAttributes.recycle();
        this.Oe = getResources().getDisplayMetrics().widthPixels;
        this.Of = this.Od + (this.Oc * 2.0f);
        this.paint = new Paint();
        this.Oj = getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        this.Oh = true;
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.Oh) {
            oC();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.Oh) {
            oC();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        oC();
    }

    private void oC() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            int measuredHeight = getMeasuredHeight();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.Oi = intrinsicHeight / 10.0f;
            this.Og = (int) (intrinsicHeight - (((((this.Of - measuredHeight) / 2.0f) * this.Oi) / this.Oc) * 2.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.Oj);
            int scaledHeight = (bitmap.getScaledHeight(this.Oj) - this.Og) / 2;
            this.sg.set(0, scaledHeight, scaledWidth, this.Og + scaledHeight);
            int width = getWidth();
            float max = Math.max(width / scaledWidth, getHeight() / this.Og);
            int i = (int) (scaledWidth * max);
            int i2 = (i - width) / 2;
            this.sh.set(-i2, 0, i - (i2 * 2), (int) (max * this.Og));
            canvas.drawBitmap(bitmap, this.sg, this.sh, this.paint);
        }
    }

    public boolean getEditable() {
        return false;
    }
}
