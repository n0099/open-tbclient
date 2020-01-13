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
/* loaded from: classes10.dex */
public class PartingLineView extends ViewGroup {
    private Paint arF;
    private View caG;
    private int caL;
    private int caM;
    private Paint caN;
    private int caO;
    private int caP;
    private Path caQ;
    private Path caR;
    private int caS;
    private RectF caT;
    private RectF caU;
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
        this.caL = obtainStyledAttributes.getColor(b.i.PartingLineView_bgNormalColor, SupportMenu.CATEGORY_MASK);
        this.caM = obtainStyledAttributes.getColor(b.i.PartingLineView_bgPressedColor, SupportMenu.CATEGORY_MASK);
        this.mBorderColor = obtainStyledAttributes.getColor(b.i.PartingLineView_bgBorderColor, ViewCompat.MEASURED_STATE_MASK);
        this.mBorderWidth = obtainStyledAttributes.getDimensionPixelOffset(b.i.PartingLineView_bgBorderWidth, 1);
        this.caO = obtainStyledAttributes.getColor(b.i.PartingLineView_dividerLineColor, ViewCompat.MEASURED_STATE_MASK);
        this.caP = obtainStyledAttributes.getDimensionPixelOffset(b.i.PartingLineView_dividerLineHeight, 1);
        this.caS = obtainStyledAttributes.getDimensionPixelOffset(b.i.PartingLineView_dividerArcRadius, 30);
        obtainStyledAttributes.recycle();
        dk(context);
    }

    private void dk(Context context) {
        setWillNotDraw(false);
        this.mBgColor = this.caL;
        this.arF = new Paint();
        this.arF.setStyle(Paint.Style.FILL);
        this.arF.setAntiAlias(true);
        this.arF.setColor(this.mBgColor);
        this.mBorderPaint = new Paint();
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setAntiAlias(true);
        this.mBorderPaint.setColor(this.mBorderColor);
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        this.caN = new Paint();
        this.caN.setStyle(Paint.Style.STROKE);
        this.caN.setAntiAlias(true);
        this.caN.setColor(this.caO);
        this.caN.setPathEffect(new DashPathEffect(new float[]{9.0f, 9.0f}, 0.0f));
        this.caN.setStrokeWidth(this.caP);
        this.caQ = new Path();
        this.caR = new Path();
        this.mRoundPath = new Path();
        this.caT = new RectF();
        this.caU = new RectF();
    }

    public void setContentView(View view, View view2) {
        if (view != null && view2 != null) {
            this.caG = view;
            this.mBottomView = view2;
            aw(this.caG);
            aw(this.mBottomView);
            invalidate();
        }
    }

    public void setBgNormalColor(int i) {
        if (this.mContext != null && this.arF != null) {
            this.caL = this.mContext.getResources().getColor(i);
            this.mBgColor = this.caL;
            this.arF.setColor(this.mBgColor);
        }
    }

    public void setBgPressedColor(int i) {
        if (this.mContext != null) {
            this.caM = this.mContext.getResources().getColor(i);
        }
    }

    public void setBorderColor(int i) {
        if (this.mContext != null && this.mBorderPaint != null) {
            this.mBorderColor = this.mContext.getResources().getColor(i);
            this.mBorderPaint.setColor(this.mBorderColor);
        }
    }

    public void setDividerLineColor(int i) {
        if (this.mContext != null && this.caN != null) {
            this.caO = this.mContext.getResources().getColor(i);
            this.caN.setColor(this.caO);
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

    public void en(boolean z) {
        if (this.arF != null) {
            this.mBgColor = z ? this.caM : this.caL;
            this.arF.setColor(this.mBgColor);
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
            setMeasuredDimension(size, (this.caG != null ? this.caG.getMeasuredHeight() : 0) + 0 + getPaddingTop() + this.caP + (this.mBottomView != null ? this.mBottomView.getMeasuredHeight() : 0) + getPaddingBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        if (this.caG != null) {
            int i6 = paddingTop + 0;
            this.caG.layout(0 + paddingLeft, i6, 0 + paddingRight + this.caG.getMeasuredWidth(), this.caG.getMeasuredHeight() + i6);
            i5 = i6 + this.caG.getMeasuredHeight();
        } else {
            i5 = 0;
        }
        if (this.mBottomView != null) {
            this.mBottomView.layout(paddingLeft + 0, this.caP + i5, 0 + paddingRight + this.mBottomView.getMeasuredWidth(), i5 + this.mBottomView.getMeasuredHeight());
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.caG != null && this.mBottomView != null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int width = (getWidth() - paddingLeft) - paddingRight;
            int height = (getHeight() - paddingTop) - paddingBottom;
            this.caR.reset();
            this.caR.moveTo(paddingLeft, paddingTop);
            this.caR.lineTo(paddingLeft + width, paddingTop);
            this.caR.lineTo(paddingLeft + width, (this.caG.getHeight() + paddingTop) - this.caS);
            this.caT.set((paddingLeft + width) - this.caS, (this.caG.getHeight() + paddingTop) - this.caS, paddingLeft + width + this.caS, this.caG.getHeight() + paddingTop + this.caS);
            this.caR.arcTo(this.caT, 270.0f, -180.0f);
            this.caR.lineTo(paddingLeft + width, paddingTop + height);
            this.caR.lineTo(paddingLeft, paddingTop + height);
            this.caR.lineTo(paddingLeft, this.caG.getHeight() + paddingTop + this.caS);
            this.caT.set(paddingLeft - this.caS, (this.caG.getHeight() + paddingTop) - this.caS, this.caS + paddingLeft, this.caG.getHeight() + paddingTop + this.caS);
            this.caR.arcTo(this.caT, 90.0f, -180.0f);
            this.caR.lineTo(paddingLeft, paddingTop);
            this.caR.close();
            int i = this.mBorderWidth / 2;
            this.caU.set(paddingLeft + i, paddingTop + i, (width + paddingLeft) - i, (height + paddingTop) - i);
            this.mRoundPath.reset();
            this.mRoundPath.addRoundRect(this.caU, 10.0f, 10.0f, Path.Direction.CCW);
            this.caR.op(this.mRoundPath, Path.Op.INTERSECT);
            if (this.arF != null) {
                canvas.drawPath(this.caR, this.arF);
            }
            if (this.mBorderPaint != null) {
                canvas.drawPath(this.caR, this.mBorderPaint);
            }
            if (this.caN != null && this.caG != null && this.mBottomView != null) {
                float height2 = paddingTop + this.caG.getHeight();
                this.caQ.reset();
                this.caQ.moveTo(paddingLeft + this.caS + 9, height2);
                this.caQ.lineTo(((getWidth() - paddingRight) - this.caS) - 9, height2);
                canvas.drawPath(this.caQ, this.caN);
            }
        }
    }
}
