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
    private View ceN;
    private int ceS;
    private int ceT;
    private Paint ceU;
    private int ceV;
    private int ceW;
    private Path ceX;
    private Path ceY;
    private int ceZ;
    private RectF cfa;
    private RectF cfb;
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
        this.ceS = obtainStyledAttributes.getColor(b.i.PartingLineView_bgNormalColor, SupportMenu.CATEGORY_MASK);
        this.ceT = obtainStyledAttributes.getColor(b.i.PartingLineView_bgPressedColor, SupportMenu.CATEGORY_MASK);
        this.mBorderColor = obtainStyledAttributes.getColor(b.i.PartingLineView_bgBorderColor, ViewCompat.MEASURED_STATE_MASK);
        this.mBorderWidth = obtainStyledAttributes.getDimensionPixelOffset(b.i.PartingLineView_bgBorderWidth, 1);
        this.ceV = obtainStyledAttributes.getColor(b.i.PartingLineView_dividerLineColor, ViewCompat.MEASURED_STATE_MASK);
        this.ceW = obtainStyledAttributes.getDimensionPixelOffset(b.i.PartingLineView_dividerLineHeight, 1);
        this.ceZ = obtainStyledAttributes.getDimensionPixelOffset(b.i.PartingLineView_dividerArcRadius, 30);
        obtainStyledAttributes.recycle();
        m27do(context);
    }

    /* renamed from: do  reason: not valid java name */
    private void m27do(Context context) {
        setWillNotDraw(false);
        this.mBgColor = this.ceS;
        this.auJ = new Paint();
        this.auJ.setStyle(Paint.Style.FILL);
        this.auJ.setAntiAlias(true);
        this.auJ.setColor(this.mBgColor);
        this.mBorderPaint = new Paint();
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setAntiAlias(true);
        this.mBorderPaint.setColor(this.mBorderColor);
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        this.ceU = new Paint();
        this.ceU.setStyle(Paint.Style.STROKE);
        this.ceU.setAntiAlias(true);
        this.ceU.setColor(this.ceV);
        this.ceU.setPathEffect(new DashPathEffect(new float[]{9.0f, 9.0f}, 0.0f));
        this.ceU.setStrokeWidth(this.ceW);
        this.ceX = new Path();
        this.ceY = new Path();
        this.mRoundPath = new Path();
        this.cfa = new RectF();
        this.cfb = new RectF();
    }

    public void setContentView(View view, View view2) {
        if (view != null && view2 != null) {
            this.ceN = view;
            this.mBottomView = view2;
            aw(this.ceN);
            aw(this.mBottomView);
            invalidate();
        }
    }

    public void setBgNormalColor(int i) {
        if (this.mContext != null && this.auJ != null) {
            this.ceS = this.mContext.getResources().getColor(i);
            this.mBgColor = this.ceS;
            this.auJ.setColor(this.mBgColor);
        }
    }

    public void setBgPressedColor(int i) {
        if (this.mContext != null) {
            this.ceT = this.mContext.getResources().getColor(i);
        }
    }

    public void setBorderColor(int i) {
        if (this.mContext != null && this.mBorderPaint != null) {
            this.mBorderColor = this.mContext.getResources().getColor(i);
            this.mBorderPaint.setColor(this.mBorderColor);
        }
    }

    public void setDividerLineColor(int i) {
        if (this.mContext != null && this.ceU != null) {
            this.ceV = this.mContext.getResources().getColor(i);
            this.ceU.setColor(this.ceV);
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
            this.mBgColor = z ? this.ceT : this.ceS;
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
            setMeasuredDimension(size, (this.ceN != null ? this.ceN.getMeasuredHeight() : 0) + 0 + getPaddingTop() + this.ceW + (this.mBottomView != null ? this.mBottomView.getMeasuredHeight() : 0) + getPaddingBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        if (this.ceN != null) {
            int i6 = paddingTop + 0;
            this.ceN.layout(0 + paddingLeft, i6, 0 + paddingRight + this.ceN.getMeasuredWidth(), this.ceN.getMeasuredHeight() + i6);
            i5 = i6 + this.ceN.getMeasuredHeight();
        } else {
            i5 = 0;
        }
        if (this.mBottomView != null) {
            this.mBottomView.layout(paddingLeft + 0, this.ceW + i5, 0 + paddingRight + this.mBottomView.getMeasuredWidth(), i5 + this.mBottomView.getMeasuredHeight());
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.ceN != null && this.mBottomView != null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int width = (getWidth() - paddingLeft) - paddingRight;
            int height = (getHeight() - paddingTop) - paddingBottom;
            this.ceY.reset();
            this.ceY.moveTo(paddingLeft, paddingTop);
            this.ceY.lineTo(paddingLeft + width, paddingTop);
            this.ceY.lineTo(paddingLeft + width, (this.ceN.getHeight() + paddingTop) - this.ceZ);
            this.cfa.set((paddingLeft + width) - this.ceZ, (this.ceN.getHeight() + paddingTop) - this.ceZ, paddingLeft + width + this.ceZ, this.ceN.getHeight() + paddingTop + this.ceZ);
            this.ceY.arcTo(this.cfa, 270.0f, -180.0f);
            this.ceY.lineTo(paddingLeft + width, paddingTop + height);
            this.ceY.lineTo(paddingLeft, paddingTop + height);
            this.ceY.lineTo(paddingLeft, this.ceN.getHeight() + paddingTop + this.ceZ);
            this.cfa.set(paddingLeft - this.ceZ, (this.ceN.getHeight() + paddingTop) - this.ceZ, this.ceZ + paddingLeft, this.ceN.getHeight() + paddingTop + this.ceZ);
            this.ceY.arcTo(this.cfa, 90.0f, -180.0f);
            this.ceY.lineTo(paddingLeft, paddingTop);
            this.ceY.close();
            int i = this.mBorderWidth / 2;
            this.cfb.set(paddingLeft + i, paddingTop + i, (width + paddingLeft) - i, (height + paddingTop) - i);
            this.mRoundPath.reset();
            this.mRoundPath.addRoundRect(this.cfb, 10.0f, 10.0f, Path.Direction.CCW);
            this.ceY.op(this.mRoundPath, Path.Op.INTERSECT);
            if (this.auJ != null) {
                canvas.drawPath(this.ceY, this.auJ);
            }
            if (this.mBorderPaint != null) {
                canvas.drawPath(this.ceY, this.mBorderPaint);
            }
            if (this.ceU != null && this.ceN != null && this.mBottomView != null) {
                float height2 = paddingTop + this.ceN.getHeight();
                this.ceX.reset();
                this.ceX.moveTo(paddingLeft + this.ceZ + 9, height2);
                this.ceX.lineTo(((getWidth() - paddingRight) - this.ceZ) - 9, height2);
                canvas.drawPath(this.ceX, this.ceU);
            }
        }
    }
}
