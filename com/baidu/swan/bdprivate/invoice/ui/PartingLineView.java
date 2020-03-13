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
    private Paint auK;
    private View ceO;
    private int ceT;
    private int ceU;
    private Paint ceV;
    private int ceW;
    private int ceX;
    private Path ceY;
    private Path ceZ;
    private int cfa;
    private RectF cfb;
    private RectF cfc;
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
        this.ceT = obtainStyledAttributes.getColor(b.i.PartingLineView_bgNormalColor, SupportMenu.CATEGORY_MASK);
        this.ceU = obtainStyledAttributes.getColor(b.i.PartingLineView_bgPressedColor, SupportMenu.CATEGORY_MASK);
        this.mBorderColor = obtainStyledAttributes.getColor(b.i.PartingLineView_bgBorderColor, ViewCompat.MEASURED_STATE_MASK);
        this.mBorderWidth = obtainStyledAttributes.getDimensionPixelOffset(b.i.PartingLineView_bgBorderWidth, 1);
        this.ceW = obtainStyledAttributes.getColor(b.i.PartingLineView_dividerLineColor, ViewCompat.MEASURED_STATE_MASK);
        this.ceX = obtainStyledAttributes.getDimensionPixelOffset(b.i.PartingLineView_dividerLineHeight, 1);
        this.cfa = obtainStyledAttributes.getDimensionPixelOffset(b.i.PartingLineView_dividerArcRadius, 30);
        obtainStyledAttributes.recycle();
        m27do(context);
    }

    /* renamed from: do  reason: not valid java name */
    private void m27do(Context context) {
        setWillNotDraw(false);
        this.mBgColor = this.ceT;
        this.auK = new Paint();
        this.auK.setStyle(Paint.Style.FILL);
        this.auK.setAntiAlias(true);
        this.auK.setColor(this.mBgColor);
        this.mBorderPaint = new Paint();
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setAntiAlias(true);
        this.mBorderPaint.setColor(this.mBorderColor);
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        this.ceV = new Paint();
        this.ceV.setStyle(Paint.Style.STROKE);
        this.ceV.setAntiAlias(true);
        this.ceV.setColor(this.ceW);
        this.ceV.setPathEffect(new DashPathEffect(new float[]{9.0f, 9.0f}, 0.0f));
        this.ceV.setStrokeWidth(this.ceX);
        this.ceY = new Path();
        this.ceZ = new Path();
        this.mRoundPath = new Path();
        this.cfb = new RectF();
        this.cfc = new RectF();
    }

    public void setContentView(View view, View view2) {
        if (view != null && view2 != null) {
            this.ceO = view;
            this.mBottomView = view2;
            aw(this.ceO);
            aw(this.mBottomView);
            invalidate();
        }
    }

    public void setBgNormalColor(int i) {
        if (this.mContext != null && this.auK != null) {
            this.ceT = this.mContext.getResources().getColor(i);
            this.mBgColor = this.ceT;
            this.auK.setColor(this.mBgColor);
        }
    }

    public void setBgPressedColor(int i) {
        if (this.mContext != null) {
            this.ceU = this.mContext.getResources().getColor(i);
        }
    }

    public void setBorderColor(int i) {
        if (this.mContext != null && this.mBorderPaint != null) {
            this.mBorderColor = this.mContext.getResources().getColor(i);
            this.mBorderPaint.setColor(this.mBorderColor);
        }
    }

    public void setDividerLineColor(int i) {
        if (this.mContext != null && this.ceV != null) {
            this.ceW = this.mContext.getResources().getColor(i);
            this.ceV.setColor(this.ceW);
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
        if (this.auK != null) {
            this.mBgColor = z ? this.ceU : this.ceT;
            this.auK.setColor(this.mBgColor);
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
            setMeasuredDimension(size, (this.ceO != null ? this.ceO.getMeasuredHeight() : 0) + 0 + getPaddingTop() + this.ceX + (this.mBottomView != null ? this.mBottomView.getMeasuredHeight() : 0) + getPaddingBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        if (this.ceO != null) {
            int i6 = paddingTop + 0;
            this.ceO.layout(0 + paddingLeft, i6, 0 + paddingRight + this.ceO.getMeasuredWidth(), this.ceO.getMeasuredHeight() + i6);
            i5 = i6 + this.ceO.getMeasuredHeight();
        } else {
            i5 = 0;
        }
        if (this.mBottomView != null) {
            this.mBottomView.layout(paddingLeft + 0, this.ceX + i5, 0 + paddingRight + this.mBottomView.getMeasuredWidth(), i5 + this.mBottomView.getMeasuredHeight());
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.ceO != null && this.mBottomView != null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int width = (getWidth() - paddingLeft) - paddingRight;
            int height = (getHeight() - paddingTop) - paddingBottom;
            this.ceZ.reset();
            this.ceZ.moveTo(paddingLeft, paddingTop);
            this.ceZ.lineTo(paddingLeft + width, paddingTop);
            this.ceZ.lineTo(paddingLeft + width, (this.ceO.getHeight() + paddingTop) - this.cfa);
            this.cfb.set((paddingLeft + width) - this.cfa, (this.ceO.getHeight() + paddingTop) - this.cfa, paddingLeft + width + this.cfa, this.ceO.getHeight() + paddingTop + this.cfa);
            this.ceZ.arcTo(this.cfb, 270.0f, -180.0f);
            this.ceZ.lineTo(paddingLeft + width, paddingTop + height);
            this.ceZ.lineTo(paddingLeft, paddingTop + height);
            this.ceZ.lineTo(paddingLeft, this.ceO.getHeight() + paddingTop + this.cfa);
            this.cfb.set(paddingLeft - this.cfa, (this.ceO.getHeight() + paddingTop) - this.cfa, this.cfa + paddingLeft, this.ceO.getHeight() + paddingTop + this.cfa);
            this.ceZ.arcTo(this.cfb, 90.0f, -180.0f);
            this.ceZ.lineTo(paddingLeft, paddingTop);
            this.ceZ.close();
            int i = this.mBorderWidth / 2;
            this.cfc.set(paddingLeft + i, paddingTop + i, (width + paddingLeft) - i, (height + paddingTop) - i);
            this.mRoundPath.reset();
            this.mRoundPath.addRoundRect(this.cfc, 10.0f, 10.0f, Path.Direction.CCW);
            this.ceZ.op(this.mRoundPath, Path.Op.INTERSECT);
            if (this.auK != null) {
                canvas.drawPath(this.ceZ, this.auK);
            }
            if (this.mBorderPaint != null) {
                canvas.drawPath(this.ceZ, this.mBorderPaint);
            }
            if (this.ceV != null && this.ceO != null && this.mBottomView != null) {
                float height2 = paddingTop + this.ceO.getHeight();
                this.ceY.reset();
                this.ceY.moveTo(paddingLeft + this.cfa + 9, height2);
                this.ceY.lineTo(((getWidth() - paddingRight) - this.cfa) - 9, height2);
                canvas.drawPath(this.ceY, this.ceV);
            }
        }
    }
}
