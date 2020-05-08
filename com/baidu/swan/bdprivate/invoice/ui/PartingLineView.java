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
    private Paint aOC;
    private View cEd;
    private int cEi;
    private int cEj;
    private Paint cEk;
    private int cEl;
    private int cEm;
    private Path cEn;
    private Path cEo;
    private int cEp;
    private RectF cEq;
    private RectF cEr;
    private View caz;
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
        this.cEi = obtainStyledAttributes.getColor(b.i.PartingLineView_bgNormalColor, SupportMenu.CATEGORY_MASK);
        this.cEj = obtainStyledAttributes.getColor(b.i.PartingLineView_bgPressedColor, SupportMenu.CATEGORY_MASK);
        this.mBorderColor = obtainStyledAttributes.getColor(b.i.PartingLineView_bgBorderColor, ViewCompat.MEASURED_STATE_MASK);
        this.mBorderWidth = obtainStyledAttributes.getDimensionPixelOffset(b.i.PartingLineView_bgBorderWidth, 1);
        this.cEl = obtainStyledAttributes.getColor(b.i.PartingLineView_dividerLineColor, ViewCompat.MEASURED_STATE_MASK);
        this.cEm = obtainStyledAttributes.getDimensionPixelOffset(b.i.PartingLineView_dividerLineHeight, 1);
        this.cEp = obtainStyledAttributes.getDimensionPixelOffset(b.i.PartingLineView_dividerArcRadius, 30);
        obtainStyledAttributes.recycle();
        cP(context);
    }

    private void cP(Context context) {
        setWillNotDraw(false);
        this.mBgColor = this.cEi;
        this.aOC = new Paint();
        this.aOC.setStyle(Paint.Style.FILL);
        this.aOC.setAntiAlias(true);
        this.aOC.setColor(this.mBgColor);
        this.mBorderPaint = new Paint();
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setAntiAlias(true);
        this.mBorderPaint.setColor(this.mBorderColor);
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        this.cEk = new Paint();
        this.cEk.setStyle(Paint.Style.STROKE);
        this.cEk.setAntiAlias(true);
        this.cEk.setColor(this.cEl);
        this.cEk.setPathEffect(new DashPathEffect(new float[]{9.0f, 9.0f}, 0.0f));
        this.cEk.setStrokeWidth(this.cEm);
        this.cEn = new Path();
        this.cEo = new Path();
        this.mRoundPath = new Path();
        this.cEq = new RectF();
        this.cEr = new RectF();
    }

    public void setContentView(View view, View view2) {
        if (view != null && view2 != null) {
            this.cEd = view;
            this.caz = view2;
            ax(this.cEd);
            ax(this.caz);
            invalidate();
        }
    }

    public void setBgNormalColor(int i) {
        if (this.mContext != null && this.aOC != null) {
            this.cEi = this.mContext.getResources().getColor(i);
            this.mBgColor = this.cEi;
            this.aOC.setColor(this.mBgColor);
        }
    }

    public void setBgPressedColor(int i) {
        if (this.mContext != null) {
            this.cEj = this.mContext.getResources().getColor(i);
        }
    }

    public void setBorderColor(int i) {
        if (this.mContext != null && this.mBorderPaint != null) {
            this.mBorderColor = this.mContext.getResources().getColor(i);
            this.mBorderPaint.setColor(this.mBorderColor);
        }
    }

    public void setDividerLineColor(int i) {
        if (this.mContext != null && this.cEk != null) {
            this.cEl = this.mContext.getResources().getColor(i);
            this.cEk.setColor(this.cEl);
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
        if (this.aOC != null) {
            this.mBgColor = z ? this.cEj : this.cEi;
            this.aOC.setColor(this.mBgColor);
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
            setMeasuredDimension(size, (this.cEd != null ? this.cEd.getMeasuredHeight() : 0) + 0 + getPaddingTop() + this.cEm + (this.caz != null ? this.caz.getMeasuredHeight() : 0) + getPaddingBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        if (this.cEd != null) {
            int i6 = paddingTop + 0;
            this.cEd.layout(0 + paddingLeft, i6, 0 + paddingRight + this.cEd.getMeasuredWidth(), this.cEd.getMeasuredHeight() + i6);
            i5 = i6 + this.cEd.getMeasuredHeight();
        } else {
            i5 = 0;
        }
        if (this.caz != null) {
            this.caz.layout(paddingLeft + 0, this.cEm + i5, 0 + paddingRight + this.caz.getMeasuredWidth(), i5 + this.caz.getMeasuredHeight());
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.cEd != null && this.caz != null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int width = (getWidth() - paddingLeft) - paddingRight;
            int height = (getHeight() - paddingTop) - paddingBottom;
            this.cEo.reset();
            this.cEo.moveTo(paddingLeft, paddingTop);
            this.cEo.lineTo(paddingLeft + width, paddingTop);
            this.cEo.lineTo(paddingLeft + width, (this.cEd.getHeight() + paddingTop) - this.cEp);
            this.cEq.set((paddingLeft + width) - this.cEp, (this.cEd.getHeight() + paddingTop) - this.cEp, paddingLeft + width + this.cEp, this.cEd.getHeight() + paddingTop + this.cEp);
            this.cEo.arcTo(this.cEq, 270.0f, -180.0f);
            this.cEo.lineTo(paddingLeft + width, paddingTop + height);
            this.cEo.lineTo(paddingLeft, paddingTop + height);
            this.cEo.lineTo(paddingLeft, this.cEd.getHeight() + paddingTop + this.cEp);
            this.cEq.set(paddingLeft - this.cEp, (this.cEd.getHeight() + paddingTop) - this.cEp, this.cEp + paddingLeft, this.cEd.getHeight() + paddingTop + this.cEp);
            this.cEo.arcTo(this.cEq, 90.0f, -180.0f);
            this.cEo.lineTo(paddingLeft, paddingTop);
            this.cEo.close();
            int i = this.mBorderWidth / 2;
            this.cEr.set(paddingLeft + i, paddingTop + i, (width + paddingLeft) - i, (height + paddingTop) - i);
            this.mRoundPath.reset();
            this.mRoundPath.addRoundRect(this.cEr, 10.0f, 10.0f, Path.Direction.CCW);
            this.cEo.op(this.mRoundPath, Path.Op.INTERSECT);
            if (this.aOC != null) {
                canvas.drawPath(this.cEo, this.aOC);
            }
            if (this.mBorderPaint != null) {
                canvas.drawPath(this.cEo, this.mBorderPaint);
            }
            if (this.cEk != null && this.cEd != null && this.caz != null) {
                float height2 = paddingTop + this.cEd.getHeight();
                this.cEn.reset();
                this.cEn.moveTo(paddingLeft + this.cEp + 9, height2);
                this.cEn.lineTo(((getWidth() - paddingRight) - this.cEp) - 9, height2);
                canvas.drawPath(this.cEn, this.cEk);
            }
        }
    }
}
