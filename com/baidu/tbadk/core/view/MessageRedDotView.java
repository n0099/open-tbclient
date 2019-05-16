package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class MessageRedDotView extends View {
    private Drawable Mb;
    private Paint bWt;
    private int bXX;
    private boolean bXY;
    private String bXZ;
    private int bYa;
    private Rect bYb;
    private int bYc;
    private int bYd;
    private int bYe;
    private int bYf;
    private RectF bYg;
    private int bYh;
    private int bYi;
    private int bYj;
    private int bYk;
    private Paint bYl;
    private RectF bYm;
    private int bYn;
    private Paint mShadowPaint;
    private int mShadowRadius;
    private int mType;

    public MessageRedDotView(@NonNull Context context) {
        super(context);
        this.mType = 1;
        this.bYn = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 1;
        this.bYn = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 1;
        this.bYn = 3;
        initView();
    }

    @RequiresApi(api = 21)
    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mType = 1;
        this.bYn = 3;
        initView();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.Mb != null) {
            this.bYh = this.bYe >= this.bYf ? this.mShadowRadius + this.bYe : this.mShadowRadius + this.bYf;
            setMeasuredDimension(this.Mb.getIntrinsicWidth() + (this.bYh * 2), this.Mb.getIntrinsicHeight() + (this.bYh * 2));
            return;
        }
        setMeasuredDimension(0, 0);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.Mb != null) {
            int intrinsicWidth = this.Mb.getIntrinsicWidth();
            int intrinsicHeight = this.Mb.getIntrinsicHeight();
            this.Mb.setBounds(this.bYh, this.bYh, this.bYh + intrinsicWidth, this.bYh + intrinsicHeight);
            this.Mb.draw(canvas);
            this.bYg.set(this.bYh, this.bYh, this.bYh + intrinsicWidth, this.bYh + intrinsicHeight);
            if (intrinsicWidth != intrinsicHeight) {
                canvas.drawRoundRect(this.bYg, this.bYi, this.bYi, this.mShadowPaint);
            } else {
                canvas.drawOval(this.bYg, this.mShadowPaint);
            }
            if (!ap.isEmpty(this.bXZ)) {
                if (this.bXZ.equals("...")) {
                    x(canvas);
                } else {
                    y(canvas);
                }
            }
        }
    }

    private void x(Canvas canvas) {
        if (this.Mb != null) {
            int intrinsicWidth = (this.Mb.getIntrinsicWidth() / 2) + this.bYh;
            int intrinsicHeight = (this.Mb.getIntrinsicHeight() / 2) + this.bYh;
            int i = intrinsicWidth - (this.bYj / 2);
            int i2 = intrinsicHeight - (this.bYj / 2);
            int i3 = intrinsicWidth + (this.bYj / 2);
            int i4 = intrinsicHeight + (this.bYj / 2);
            this.bYm.set(i, i2, i3, i4);
            canvas.drawOval(this.bYm, this.bYl);
            this.bYm.set((i - this.bYk) - this.bYj, i2, i - this.bYk, i4);
            canvas.drawOval(this.bYm, this.bYl);
            this.bYm.set(this.bYk + i3, i2, i3 + this.bYk + this.bYj, i4);
            canvas.drawOval(this.bYm, this.bYl);
        }
    }

    private void y(Canvas canvas) {
        if (!ap.isEmpty(this.bXZ) && this.Mb != null) {
            this.bWt.getTextBounds(this.bXZ, 0, this.bXZ.length(), this.bYb);
            Paint.FontMetrics fontMetrics = this.bWt.getFontMetrics();
            int intrinsicWidth = (this.Mb.getIntrinsicWidth() / 2) + this.bYh;
            canvas.drawText(this.bXZ, intrinsicWidth, (getResources().getDimension(R.dimen.tbds10) + fontMetrics.bottom) - fontMetrics.ascent, this.bWt);
        }
    }

    private void initView() {
        setLayerType(1, null);
        ajo();
        this.bWt = new Paint(1);
        this.bWt.setColor(al.getColor(R.color.cp_btn_a));
        this.bWt.setTextSize(com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbfontsize26));
        this.bWt.setTextAlign(Paint.Align.CENTER);
        this.bWt.setTypeface(Typeface.MONOSPACE);
        this.bYb = new Rect();
        this.bYc = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds13);
        this.bYd = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds42);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setStyle(Paint.Style.FILL);
        this.mShadowPaint.setColor(al.getColor(R.color.transparent));
        this.bYe = 0;
        this.mShadowRadius = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds8);
        this.bYf = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds3);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.bYe, this.bYf, al.getColor(R.color.cp_cont_h_alpha66));
        this.bYg = new RectF();
        this.bYi = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds21);
        this.bYj = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds8);
        this.bYk = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds6);
        this.bYl = new Paint();
        this.bYl.setAntiAlias(true);
        this.bYl.setStyle(Paint.Style.FILL);
        this.bYl.setColor(al.getColor(R.color.cp_btn_a));
        this.bYm = new RectF();
    }

    private void ajo() {
        String str = Build.MODEL;
        if (str.contains("vivo") && str.contains("X20")) {
            this.bYa = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds2);
        }
    }

    @Deprecated
    public void refresh(int i) {
        int i2;
        if (i <= 0) {
            i2 = R.drawable.icon_news_red_dot;
            this.bXZ = null;
        } else if (i < 10) {
            this.bXZ = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_one_number;
        } else if (i < 100) {
            this.bXZ = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_two_number;
        } else if (this.mType == 1) {
            this.bXZ = "...";
            i2 = R.drawable.icon_news_red_dot_three_dot_number;
        } else if (this.mType == 2) {
            this.bXZ = "99+";
            i2 = R.drawable.icon_news_red_dot_three_number;
        } else {
            i2 = 0;
        }
        if (i2 != this.bXX) {
            this.bXY = true;
        } else {
            this.bXY = false;
        }
        this.bXX = i2;
        onChangeSkinType();
    }

    public void setThreeDotMode(int i) {
        this.mType = i;
    }

    public void onChangeSkinType() {
        this.bYn = TbadkApplication.getInst().getSkinType();
        if (this.bXX > 0) {
            this.Mb = al.getDrawable(this.bXX);
        } else if (this.Mb instanceof GradientDrawable) {
            ((GradientDrawable) this.Mb).setColor(al.getColor(R.color.cp_cont_h));
        }
        this.bYl.setColor(al.getColor(R.color.cp_btn_a));
        if (this.bWt != null) {
            this.bWt.setColor(al.getColor(R.color.cp_btn_a));
        }
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.bYe, this.bYf, al.getColor(R.color.cp_cont_h_alpha66));
        if (this.bXY) {
            this.bXY = false;
            requestLayout();
        }
        invalidate();
    }
}
