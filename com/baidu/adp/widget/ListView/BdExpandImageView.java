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
    private float Oo;
    protected float Op;
    protected float Oq;
    private final float Or;
    private int Os;
    private boolean Ot;
    private float Ou;
    private final DisplayMetrics Ov;
    private final Paint paint;
    private final Rect si;
    private final Rect sj;

    public BdExpandImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Oo = 0.0f;
        this.si = new Rect();
        this.sj = new Rect();
        setScaleType(ImageView.ScaleType.MATRIX);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandListView);
        this.Oo = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_expandDistance, 0) / 2.0f;
        this.Op = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExpandListView_beforeExpandHeight, 0);
        obtainStyledAttributes.recycle();
        this.Oq = getResources().getDisplayMetrics().widthPixels;
        this.Or = this.Op + (this.Oo * 2.0f);
        this.paint = new Paint();
        this.Ov = getResources().getDisplayMetrics();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        this.Ot = true;
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.Ot) {
            oD();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.Ot) {
            oD();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        oD();
    }

    private void oD() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            int measuredHeight = getMeasuredHeight();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.Ou = intrinsicHeight / 10.0f;
            this.Os = (int) (intrinsicHeight - (((((this.Or - measuredHeight) / 2.0f) * this.Ou) / this.Oo) * 2.0f));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
            int scaledWidth = bitmap.getScaledWidth(this.Ov);
            int scaledHeight = (bitmap.getScaledHeight(this.Ov) - this.Os) / 2;
            this.si.set(0, scaledHeight, scaledWidth, this.Os + scaledHeight);
            int width = getWidth();
            float max = Math.max(width / scaledWidth, getHeight() / this.Os);
            int i = (int) (scaledWidth * max);
            int i2 = (i - width) / 2;
            this.sj.set(-i2, 0, i - (i2 * 2), (int) (max * this.Os));
            canvas.drawBitmap(bitmap, this.si, this.sj, this.paint);
        }
    }

    public boolean getEditable() {
        return false;
    }
}
