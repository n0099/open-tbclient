package com.baidu.swan.bdprivate.invoice.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.swan.bdprivate.b;
/* loaded from: classes11.dex */
public class PartingLineView extends ViewGroup {
    private Paint aOw;
    private View cDX;
    private int cEc;
    private int cEd;
    private Paint cEe;
    private int cEf;
    private int cEg;
    private Path cEh;
    private Path cEi;
    private int cEj;
    private RectF cEk;
    private RectF cEl;
    private View cat;
    private int mBgColor;
    private int mBorderColor;
    private Paint mBorderPaint;
    private int mBorderWidth;
    private Context mContext;
    private Path mRoundPath;

    public PartingLineView(Context context) {
        this(context, null);
    }

    public PartingLineView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PartingLineView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(context, attributeSet, i);
    }

    private void b(Context context, AttributeSet attributeSet, int i) {
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.i.PartingLineView);
        this.cEc = obtainStyledAttributes.getColor(b.i.PartingLineView_bgNormalColor, SupportMenu.CATEGORY_MASK);
        this.cEd = obtainStyledAttributes.getColor(b.i.PartingLineView_bgPressedColor, SupportMenu.CATEGORY_MASK);
        this.mBorderColor = obtainStyledAttributes.getColor(b.i.PartingLineView_bgBorderColor, ViewCompat.MEASURED_STATE_MASK);
        this.mBorderWidth = obtainStyledAttributes.getDimensionPixelOffset(b.i.PartingLineView_bgBorderWidth, 1);
        this.cEf = obtainStyledAttributes.getColor(b.i.PartingLineView_dividerLineColor, ViewCompat.MEASURED_STATE_MASK);
        this.cEg = obtainStyledAttributes.getDimensionPixelOffset(b.i.PartingLineView_dividerLineHeight, 1);
        this.cEj = obtainStyledAttributes.getDimensionPixelOffset(b.i.PartingLineView_dividerArcRadius, 30);
        obtainStyledAttributes.recycle();
        db(context);
    }

    private void db(Context context) {
        setWillNotDraw(false);
        this.mBgColor = this.cEc;
        this.aOw = new Paint();
        this.aOw.setStyle(Paint.Style.FILL);
        this.aOw.setAntiAlias(true);
        this.aOw.setColor(this.mBgColor);
        this.mBorderPaint = new Paint();
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setAntiAlias(true);
        this.mBorderPaint.setColor(this.mBorderColor);
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        this.cEe = new Paint();
        this.cEe.setStyle(Paint.Style.STROKE);
        this.cEe.setAntiAlias(true);
        this.cEe.setColor(this.cEf);
        this.cEe.setPathEffect(new DashPathEffect(new float[]{9.0f, 9.0f}, 0.0f));
        this.cEe.setStrokeWidth(this.cEg);
        this.cEh = new Path();
        this.cEi = new Path();
        this.mRoundPath = new Path();
        this.cEk = new RectF();
        this.cEl = new RectF();
    }

    public void setContentView(View view, View view2) {
        if (view != null && view2 != null) {
            this.cDX = view;
            this.cat = view2;
            ax(this.cDX);
            ax(this.cat);
            invalidate();
        }
    }

    public void setBgNormalColor(int i) {
        if (this.mContext != null && this.aOw != null) {
            this.cEc = this.mContext.getResources().getColor(i);
            this.mBgColor = this.cEc;
            this.aOw.setColor(this.mBgColor);
        }
    }

    public void setBgPressedColor(int i) {
        if (this.mContext != null) {
            this.cEd = this.mContext.getResources().getColor(i);
        }
    }

    public void setBorderColor(int i) {
        if (this.mContext != null && this.mBorderPaint != null) {
            this.mBorderColor = this.mContext.getResources().getColor(i);
            this.mBorderPaint.setColor(this.mBorderColor);
        }
    }

    public void setDividerLineColor(int i) {
        if (this.mContext != null && this.cEe != null) {
            this.cEf = this.mContext.getResources().getColor(i);
            this.cEe.setColor(this.cEf);
        }
    }

    private void ax(View view) {
        if (view != null) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            addView(view);
        }
    }

    public void fs(boolean z) {
        if (this.aOw != null) {
            this.mBgColor = z ? this.cEd : this.cEc;
            this.aOw.setColor(this.mBgColor);
            invalidate();
        }
    }

    @Override // android.view.View
    public void refreshDrawableState() {
        super.refreshDrawableState();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        measureChildren(i, i2);
        if (getChildCount() == 0) {
            setMeasuredDimension(0, 0);
        }
        if (mode != 1073741824) {
            setMeasuredDimension(size, (this.cDX != null ? this.cDX.getMeasuredHeight() : 0) + 0 + getPaddingTop() + this.cEg + (this.cat != null ? this.cat.getMeasuredHeight() : 0) + getPaddingBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        if (this.cDX != null) {
            int i6 = paddingTop + 0;
            this.cDX.layout(0 + paddingLeft, i6, 0 + paddingRight + this.cDX.getMeasuredWidth(), this.cDX.getMeasuredHeight() + i6);
            i5 = i6 + this.cDX.getMeasuredHeight();
        } else {
            i5 = 0;
        }
        if (this.cat != null) {
            this.cat.layout(paddingLeft + 0, this.cEg + i5, 0 + paddingRight + this.cat.getMeasuredWidth(), i5 + this.cat.getMeasuredHeight());
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.cDX != null && this.cat != null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int width = (getWidth() - paddingLeft) - paddingRight;
            int height = (getHeight() - paddingTop) - paddingBottom;
            this.cEi.reset();
            this.cEi.moveTo(paddingLeft, paddingTop);
            this.cEi.lineTo(paddingLeft + width, paddingTop);
            this.cEi.lineTo(paddingLeft + width, (this.cDX.getHeight() + paddingTop) - this.cEj);
            this.cEk.set((paddingLeft + width) - this.cEj, (this.cDX.getHeight() + paddingTop) - this.cEj, paddingLeft + width + this.cEj, this.cDX.getHeight() + paddingTop + this.cEj);
            this.cEi.arcTo(this.cEk, 270.0f, -180.0f);
            this.cEi.lineTo(paddingLeft + width, paddingTop + height);
            this.cEi.lineTo(paddingLeft, paddingTop + height);
            this.cEi.lineTo(paddingLeft, this.cDX.getHeight() + paddingTop + this.cEj);
            this.cEk.set(paddingLeft - this.cEj, (this.cDX.getHeight() + paddingTop) - this.cEj, this.cEj + paddingLeft, this.cDX.getHeight() + paddingTop + this.cEj);
            this.cEi.arcTo(this.cEk, 90.0f, -180.0f);
            this.cEi.lineTo(paddingLeft, paddingTop);
            this.cEi.close();
            int i = this.mBorderWidth / 2;
            this.cEl.set(paddingLeft + i, paddingTop + i, (width + paddingLeft) - i, (height + paddingTop) - i);
            this.mRoundPath.reset();
            this.mRoundPath.addRoundRect(this.cEl, 10.0f, 10.0f, Path.Direction.CCW);
            this.cEi.op(this.mRoundPath, Path.Op.INTERSECT);
            if (this.aOw != null) {
                canvas.drawPath(this.cEi, this.aOw);
            }
            if (this.mBorderPaint != null) {
                canvas.drawPath(this.cEi, this.mBorderPaint);
            }
            if (this.cEe != null && this.cDX != null && this.cat != null) {
                float height2 = paddingTop + this.cDX.getHeight();
                this.cEh.reset();
                this.cEh.moveTo(paddingLeft + this.cEj + 9, height2);
                this.cEh.lineTo(((getWidth() - paddingRight) - this.cEj) - 9, height2);
                canvas.drawPath(this.cEh, this.cEe);
            }
        }
    }
}
