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
    private Paint auJ;
    private View ceM;
    private int ceR;
    private int ceS;
    private Paint ceT;
    private int ceU;
    private int ceV;
    private Path ceW;
    private Path ceX;
    private int ceY;
    private RectF ceZ;
    private RectF cfa;
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
        this.ceR = obtainStyledAttributes.getColor(b.i.PartingLineView_bgNormalColor, SupportMenu.CATEGORY_MASK);
        this.ceS = obtainStyledAttributes.getColor(b.i.PartingLineView_bgPressedColor, SupportMenu.CATEGORY_MASK);
        this.mBorderColor = obtainStyledAttributes.getColor(b.i.PartingLineView_bgBorderColor, ViewCompat.MEASURED_STATE_MASK);
        this.mBorderWidth = obtainStyledAttributes.getDimensionPixelOffset(b.i.PartingLineView_bgBorderWidth, 1);
        this.ceU = obtainStyledAttributes.getColor(b.i.PartingLineView_dividerLineColor, ViewCompat.MEASURED_STATE_MASK);
        this.ceV = obtainStyledAttributes.getDimensionPixelOffset(b.i.PartingLineView_dividerLineHeight, 1);
        this.ceY = obtainStyledAttributes.getDimensionPixelOffset(b.i.PartingLineView_dividerArcRadius, 30);
        obtainStyledAttributes.recycle();
        m27do(context);
    }

    /* renamed from: do  reason: not valid java name */
    private void m27do(Context context) {
        setWillNotDraw(false);
        this.mBgColor = this.ceR;
        this.auJ = new Paint();
        this.auJ.setStyle(Paint.Style.FILL);
        this.auJ.setAntiAlias(true);
        this.auJ.setColor(this.mBgColor);
        this.mBorderPaint = new Paint();
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setAntiAlias(true);
        this.mBorderPaint.setColor(this.mBorderColor);
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        this.ceT = new Paint();
        this.ceT.setStyle(Paint.Style.STROKE);
        this.ceT.setAntiAlias(true);
        this.ceT.setColor(this.ceU);
        this.ceT.setPathEffect(new DashPathEffect(new float[]{9.0f, 9.0f}, 0.0f));
        this.ceT.setStrokeWidth(this.ceV);
        this.ceW = new Path();
        this.ceX = new Path();
        this.mRoundPath = new Path();
        this.ceZ = new RectF();
        this.cfa = new RectF();
    }

    public void setContentView(View view, View view2) {
        if (view != null && view2 != null) {
            this.ceM = view;
            this.mBottomView = view2;
            aw(this.ceM);
            aw(this.mBottomView);
            invalidate();
        }
    }

    public void setBgNormalColor(int i) {
        if (this.mContext != null && this.auJ != null) {
            this.ceR = this.mContext.getResources().getColor(i);
            this.mBgColor = this.ceR;
            this.auJ.setColor(this.mBgColor);
        }
    }

    public void setBgPressedColor(int i) {
        if (this.mContext != null) {
            this.ceS = this.mContext.getResources().getColor(i);
        }
    }

    public void setBorderColor(int i) {
        if (this.mContext != null && this.mBorderPaint != null) {
            this.mBorderColor = this.mContext.getResources().getColor(i);
            this.mBorderPaint.setColor(this.mBorderColor);
        }
    }

    public void setDividerLineColor(int i) {
        if (this.mContext != null && this.ceT != null) {
            this.ceU = this.mContext.getResources().getColor(i);
            this.ceT.setColor(this.ceU);
        }
    }

    private void aw(View view) {
        if (view != null) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            addView(view);
        }
    }

    public void eu(boolean z) {
        if (this.auJ != null) {
            this.mBgColor = z ? this.ceS : this.ceR;
            this.auJ.setColor(this.mBgColor);
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
            setMeasuredDimension(size, (this.ceM != null ? this.ceM.getMeasuredHeight() : 0) + 0 + getPaddingTop() + this.ceV + (this.mBottomView != null ? this.mBottomView.getMeasuredHeight() : 0) + getPaddingBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        if (this.ceM != null) {
            int i6 = paddingTop + 0;
            this.ceM.layout(0 + paddingLeft, i6, 0 + paddingRight + this.ceM.getMeasuredWidth(), this.ceM.getMeasuredHeight() + i6);
            i5 = i6 + this.ceM.getMeasuredHeight();
        } else {
            i5 = 0;
        }
        if (this.mBottomView != null) {
            this.mBottomView.layout(paddingLeft + 0, this.ceV + i5, 0 + paddingRight + this.mBottomView.getMeasuredWidth(), i5 + this.mBottomView.getMeasuredHeight());
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.ceM != null && this.mBottomView != null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int width = (getWidth() - paddingLeft) - paddingRight;
            int height = (getHeight() - paddingTop) - paddingBottom;
            this.ceX.reset();
            this.ceX.moveTo(paddingLeft, paddingTop);
            this.ceX.lineTo(paddingLeft + width, paddingTop);
            this.ceX.lineTo(paddingLeft + width, (this.ceM.getHeight() + paddingTop) - this.ceY);
            this.ceZ.set((paddingLeft + width) - this.ceY, (this.ceM.getHeight() + paddingTop) - this.ceY, paddingLeft + width + this.ceY, this.ceM.getHeight() + paddingTop + this.ceY);
            this.ceX.arcTo(this.ceZ, 270.0f, -180.0f);
            this.ceX.lineTo(paddingLeft + width, paddingTop + height);
            this.ceX.lineTo(paddingLeft, paddingTop + height);
            this.ceX.lineTo(paddingLeft, this.ceM.getHeight() + paddingTop + this.ceY);
            this.ceZ.set(paddingLeft - this.ceY, (this.ceM.getHeight() + paddingTop) - this.ceY, this.ceY + paddingLeft, this.ceM.getHeight() + paddingTop + this.ceY);
            this.ceX.arcTo(this.ceZ, 90.0f, -180.0f);
            this.ceX.lineTo(paddingLeft, paddingTop);
            this.ceX.close();
            int i = this.mBorderWidth / 2;
            this.cfa.set(paddingLeft + i, paddingTop + i, (width + paddingLeft) - i, (height + paddingTop) - i);
            this.mRoundPath.reset();
            this.mRoundPath.addRoundRect(this.cfa, 10.0f, 10.0f, Path.Direction.CCW);
            this.ceX.op(this.mRoundPath, Path.Op.INTERSECT);
            if (this.auJ != null) {
                canvas.drawPath(this.ceX, this.auJ);
            }
            if (this.mBorderPaint != null) {
                canvas.drawPath(this.ceX, this.mBorderPaint);
            }
            if (this.ceT != null && this.ceM != null && this.mBottomView != null) {
                float height2 = paddingTop + this.ceM.getHeight();
                this.ceW.reset();
                this.ceW.moveTo(paddingLeft + this.ceY + 9, height2);
                this.ceW.lineTo(((getWidth() - paddingRight) - this.ceY) - 9, height2);
                canvas.drawPath(this.ceW, this.ceT);
            }
        }
    }
}
