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
/* loaded from: classes9.dex */
public class PartingLineView extends ViewGroup {
    private Paint aqT;
    private int caA;
    private Paint caB;
    private int caC;
    private int caD;
    private Path caE;
    private Path caF;
    private int caG;
    private RectF caH;
    private RectF caI;
    private View cau;
    private int caz;
    private int mBgColor;
    private int mBorderColor;
    private Paint mBorderPaint;
    private int mBorderWidth;
    private View mBottomView;
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
        this.caz = obtainStyledAttributes.getColor(b.i.PartingLineView_bgNormalColor, SupportMenu.CATEGORY_MASK);
        this.caA = obtainStyledAttributes.getColor(b.i.PartingLineView_bgPressedColor, SupportMenu.CATEGORY_MASK);
        this.mBorderColor = obtainStyledAttributes.getColor(b.i.PartingLineView_bgBorderColor, ViewCompat.MEASURED_STATE_MASK);
        this.mBorderWidth = obtainStyledAttributes.getDimensionPixelOffset(b.i.PartingLineView_bgBorderWidth, 1);
        this.caC = obtainStyledAttributes.getColor(b.i.PartingLineView_dividerLineColor, ViewCompat.MEASURED_STATE_MASK);
        this.caD = obtainStyledAttributes.getDimensionPixelOffset(b.i.PartingLineView_dividerLineHeight, 1);
        this.caG = obtainStyledAttributes.getDimensionPixelOffset(b.i.PartingLineView_dividerArcRadius, 30);
        obtainStyledAttributes.recycle();
        dk(context);
    }

    private void dk(Context context) {
        setWillNotDraw(false);
        this.mBgColor = this.caz;
        this.aqT = new Paint();
        this.aqT.setStyle(Paint.Style.FILL);
        this.aqT.setAntiAlias(true);
        this.aqT.setColor(this.mBgColor);
        this.mBorderPaint = new Paint();
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setAntiAlias(true);
        this.mBorderPaint.setColor(this.mBorderColor);
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        this.caB = new Paint();
        this.caB.setStyle(Paint.Style.STROKE);
        this.caB.setAntiAlias(true);
        this.caB.setColor(this.caC);
        this.caB.setPathEffect(new DashPathEffect(new float[]{9.0f, 9.0f}, 0.0f));
        this.caB.setStrokeWidth(this.caD);
        this.caE = new Path();
        this.caF = new Path();
        this.mRoundPath = new Path();
        this.caH = new RectF();
        this.caI = new RectF();
    }

    public void setContentView(View view, View view2) {
        if (view != null && view2 != null) {
            this.cau = view;
            this.mBottomView = view2;
            as(this.cau);
            as(this.mBottomView);
            invalidate();
        }
    }

    public void setBgNormalColor(int i) {
        if (this.mContext != null && this.aqT != null) {
            this.caz = this.mContext.getResources().getColor(i);
            this.mBgColor = this.caz;
            this.aqT.setColor(this.mBgColor);
        }
    }

    public void setBgPressedColor(int i) {
        if (this.mContext != null) {
            this.caA = this.mContext.getResources().getColor(i);
        }
    }

    public void setBorderColor(int i) {
        if (this.mContext != null && this.mBorderPaint != null) {
            this.mBorderColor = this.mContext.getResources().getColor(i);
            this.mBorderPaint.setColor(this.mBorderColor);
        }
    }

    public void setDividerLineColor(int i) {
        if (this.mContext != null && this.caB != null) {
            this.caC = this.mContext.getResources().getColor(i);
            this.caB.setColor(this.caC);
        }
    }

    private void as(View view) {
        if (view != null) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            addView(view);
        }
    }

    public void ei(boolean z) {
        if (this.aqT != null) {
            this.mBgColor = z ? this.caA : this.caz;
            this.aqT.setColor(this.mBgColor);
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
            setMeasuredDimension(size, (this.cau != null ? this.cau.getMeasuredHeight() : 0) + 0 + getPaddingTop() + this.caD + (this.mBottomView != null ? this.mBottomView.getMeasuredHeight() : 0) + getPaddingBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        if (this.cau != null) {
            int i6 = paddingTop + 0;
            this.cau.layout(0 + paddingLeft, i6, 0 + paddingRight + this.cau.getMeasuredWidth(), this.cau.getMeasuredHeight() + i6);
            i5 = i6 + this.cau.getMeasuredHeight();
        } else {
            i5 = 0;
        }
        if (this.mBottomView != null) {
            this.mBottomView.layout(paddingLeft + 0, this.caD + i5, 0 + paddingRight + this.mBottomView.getMeasuredWidth(), i5 + this.mBottomView.getMeasuredHeight());
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.cau != null && this.mBottomView != null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int width = (getWidth() - paddingLeft) - paddingRight;
            int height = (getHeight() - paddingTop) - paddingBottom;
            this.caF.reset();
            this.caF.moveTo(paddingLeft, paddingTop);
            this.caF.lineTo(paddingLeft + width, paddingTop);
            this.caF.lineTo(paddingLeft + width, (this.cau.getHeight() + paddingTop) - this.caG);
            this.caH.set((paddingLeft + width) - this.caG, (this.cau.getHeight() + paddingTop) - this.caG, paddingLeft + width + this.caG, this.cau.getHeight() + paddingTop + this.caG);
            this.caF.arcTo(this.caH, 270.0f, -180.0f);
            this.caF.lineTo(paddingLeft + width, paddingTop + height);
            this.caF.lineTo(paddingLeft, paddingTop + height);
            this.caF.lineTo(paddingLeft, this.cau.getHeight() + paddingTop + this.caG);
            this.caH.set(paddingLeft - this.caG, (this.cau.getHeight() + paddingTop) - this.caG, this.caG + paddingLeft, this.cau.getHeight() + paddingTop + this.caG);
            this.caF.arcTo(this.caH, 90.0f, -180.0f);
            this.caF.lineTo(paddingLeft, paddingTop);
            this.caF.close();
            int i = this.mBorderWidth / 2;
            this.caI.set(paddingLeft + i, paddingTop + i, (width + paddingLeft) - i, (height + paddingTop) - i);
            this.mRoundPath.reset();
            this.mRoundPath.addRoundRect(this.caI, 10.0f, 10.0f, Path.Direction.CCW);
            this.caF.op(this.mRoundPath, Path.Op.INTERSECT);
            if (this.aqT != null) {
                canvas.drawPath(this.caF, this.aqT);
            }
            if (this.mBorderPaint != null) {
                canvas.drawPath(this.caF, this.mBorderPaint);
            }
            if (this.caB != null && this.cau != null && this.mBottomView != null) {
                float height2 = paddingTop + this.cau.getHeight();
                this.caE.reset();
                this.caE.moveTo(paddingLeft + this.caG + 9, height2);
                this.caE.lineTo(((getWidth() - paddingRight) - this.caG) - 9, height2);
                canvas.drawPath(this.caE, this.caB);
            }
        }
    }
}
