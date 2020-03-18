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
    private Paint auU;
    private View ceZ;
    private int cfe;
    private int cff;
    private Paint cfg;
    private int cfh;
    private int cfi;
    private Path cfj;
    private Path cfk;
    private int cfl;
    private RectF cfm;
    private RectF cfn;
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
        this.cfe = obtainStyledAttributes.getColor(b.i.PartingLineView_bgNormalColor, SupportMenu.CATEGORY_MASK);
        this.cff = obtainStyledAttributes.getColor(b.i.PartingLineView_bgPressedColor, SupportMenu.CATEGORY_MASK);
        this.mBorderColor = obtainStyledAttributes.getColor(b.i.PartingLineView_bgBorderColor, ViewCompat.MEASURED_STATE_MASK);
        this.mBorderWidth = obtainStyledAttributes.getDimensionPixelOffset(b.i.PartingLineView_bgBorderWidth, 1);
        this.cfh = obtainStyledAttributes.getColor(b.i.PartingLineView_dividerLineColor, ViewCompat.MEASURED_STATE_MASK);
        this.cfi = obtainStyledAttributes.getDimensionPixelOffset(b.i.PartingLineView_dividerLineHeight, 1);
        this.cfl = obtainStyledAttributes.getDimensionPixelOffset(b.i.PartingLineView_dividerArcRadius, 30);
        obtainStyledAttributes.recycle();
        dn(context);
    }

    private void dn(Context context) {
        setWillNotDraw(false);
        this.mBgColor = this.cfe;
        this.auU = new Paint();
        this.auU.setStyle(Paint.Style.FILL);
        this.auU.setAntiAlias(true);
        this.auU.setColor(this.mBgColor);
        this.mBorderPaint = new Paint();
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setAntiAlias(true);
        this.mBorderPaint.setColor(this.mBorderColor);
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
        this.cfg = new Paint();
        this.cfg.setStyle(Paint.Style.STROKE);
        this.cfg.setAntiAlias(true);
        this.cfg.setColor(this.cfh);
        this.cfg.setPathEffect(new DashPathEffect(new float[]{9.0f, 9.0f}, 0.0f));
        this.cfg.setStrokeWidth(this.cfi);
        this.cfj = new Path();
        this.cfk = new Path();
        this.mRoundPath = new Path();
        this.cfm = new RectF();
        this.cfn = new RectF();
    }

    public void setContentView(View view, View view2) {
        if (view != null && view2 != null) {
            this.ceZ = view;
            this.mBottomView = view2;
            aw(this.ceZ);
            aw(this.mBottomView);
            invalidate();
        }
    }

    public void setBgNormalColor(int i) {
        if (this.mContext != null && this.auU != null) {
            this.cfe = this.mContext.getResources().getColor(i);
            this.mBgColor = this.cfe;
            this.auU.setColor(this.mBgColor);
        }
    }

    public void setBgPressedColor(int i) {
        if (this.mContext != null) {
            this.cff = this.mContext.getResources().getColor(i);
        }
    }

    public void setBorderColor(int i) {
        if (this.mContext != null && this.mBorderPaint != null) {
            this.mBorderColor = this.mContext.getResources().getColor(i);
            this.mBorderPaint.setColor(this.mBorderColor);
        }
    }

    public void setDividerLineColor(int i) {
        if (this.mContext != null && this.cfg != null) {
            this.cfh = this.mContext.getResources().getColor(i);
            this.cfg.setColor(this.cfh);
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

    public void ev(boolean z) {
        if (this.auU != null) {
            this.mBgColor = z ? this.cff : this.cfe;
            this.auU.setColor(this.mBgColor);
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
            setMeasuredDimension(size, (this.ceZ != null ? this.ceZ.getMeasuredHeight() : 0) + 0 + getPaddingTop() + this.cfi + (this.mBottomView != null ? this.mBottomView.getMeasuredHeight() : 0) + getPaddingBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        if (this.ceZ != null) {
            int i6 = paddingTop + 0;
            this.ceZ.layout(0 + paddingLeft, i6, 0 + paddingRight + this.ceZ.getMeasuredWidth(), this.ceZ.getMeasuredHeight() + i6);
            i5 = i6 + this.ceZ.getMeasuredHeight();
        } else {
            i5 = 0;
        }
        if (this.mBottomView != null) {
            this.mBottomView.layout(paddingLeft + 0, this.cfi + i5, 0 + paddingRight + this.mBottomView.getMeasuredWidth(), i5 + this.mBottomView.getMeasuredHeight());
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.ceZ != null && this.mBottomView != null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int width = (getWidth() - paddingLeft) - paddingRight;
            int height = (getHeight() - paddingTop) - paddingBottom;
            this.cfk.reset();
            this.cfk.moveTo(paddingLeft, paddingTop);
            this.cfk.lineTo(paddingLeft + width, paddingTop);
            this.cfk.lineTo(paddingLeft + width, (this.ceZ.getHeight() + paddingTop) - this.cfl);
            this.cfm.set((paddingLeft + width) - this.cfl, (this.ceZ.getHeight() + paddingTop) - this.cfl, paddingLeft + width + this.cfl, this.ceZ.getHeight() + paddingTop + this.cfl);
            this.cfk.arcTo(this.cfm, 270.0f, -180.0f);
            this.cfk.lineTo(paddingLeft + width, paddingTop + height);
            this.cfk.lineTo(paddingLeft, paddingTop + height);
            this.cfk.lineTo(paddingLeft, this.ceZ.getHeight() + paddingTop + this.cfl);
            this.cfm.set(paddingLeft - this.cfl, (this.ceZ.getHeight() + paddingTop) - this.cfl, this.cfl + paddingLeft, this.ceZ.getHeight() + paddingTop + this.cfl);
            this.cfk.arcTo(this.cfm, 90.0f, -180.0f);
            this.cfk.lineTo(paddingLeft, paddingTop);
            this.cfk.close();
            int i = this.mBorderWidth / 2;
            this.cfn.set(paddingLeft + i, paddingTop + i, (width + paddingLeft) - i, (height + paddingTop) - i);
            this.mRoundPath.reset();
            this.mRoundPath.addRoundRect(this.cfn, 10.0f, 10.0f, Path.Direction.CCW);
            this.cfk.op(this.mRoundPath, Path.Op.INTERSECT);
            if (this.auU != null) {
                canvas.drawPath(this.cfk, this.auU);
            }
            if (this.mBorderPaint != null) {
                canvas.drawPath(this.cfk, this.mBorderPaint);
            }
            if (this.cfg != null && this.ceZ != null && this.mBottomView != null) {
                float height2 = paddingTop + this.ceZ.getHeight();
                this.cfj.reset();
                this.cfj.moveTo(paddingLeft + this.cfl + 9, height2);
                this.cfj.lineTo(((getWidth() - paddingRight) - this.cfl) - 9, height2);
                canvas.drawPath(this.cfj, this.cfg);
            }
        }
    }
}
