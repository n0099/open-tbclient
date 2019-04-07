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
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class MessageRedDotView extends View {
    private Drawable Or;
    private Paint bOE;
    private int bQi;
    private boolean bQj;
    private String bQk;
    private int bQl;
    private Rect bQm;
    private int bQn;
    private int bQo;
    private int bQp;
    private int bQq;
    private RectF bQr;
    private int bQs;
    private int bQt;
    private int bQu;
    private int bQv;
    private Paint bQw;
    private RectF bQx;
    private int bQy;
    private Paint mShadowPaint;
    private int mShadowRadius;
    private int mType;

    public MessageRedDotView(@NonNull Context context) {
        super(context);
        this.mType = 1;
        this.bQy = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 1;
        this.bQy = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 1;
        this.bQy = 3;
        initView();
    }

    @RequiresApi(api = 21)
    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mType = 1;
        this.bQy = 3;
        initView();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.Or != null) {
            this.bQs = this.bQp >= this.bQq ? this.mShadowRadius + this.bQp : this.mShadowRadius + this.bQq;
            setMeasuredDimension(this.Or.getIntrinsicWidth() + (this.bQs * 2), this.Or.getIntrinsicHeight() + (this.bQs * 2));
            return;
        }
        setMeasuredDimension(0, 0);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.Or != null) {
            int intrinsicWidth = this.Or.getIntrinsicWidth();
            int intrinsicHeight = this.Or.getIntrinsicHeight();
            this.Or.setBounds(this.bQs, this.bQs, this.bQs + intrinsicWidth, this.bQs + intrinsicHeight);
            this.Or.draw(canvas);
            this.bQr.set(this.bQs, this.bQs, this.bQs + intrinsicWidth, this.bQs + intrinsicHeight);
            if (intrinsicWidth != intrinsicHeight) {
                canvas.drawRoundRect(this.bQr, this.bQt, this.bQt, this.mShadowPaint);
            } else {
                canvas.drawOval(this.bQr, this.mShadowPaint);
            }
            if (!ap.isEmpty(this.bQk)) {
                if (this.bQk.equals("...")) {
                    x(canvas);
                } else {
                    y(canvas);
                }
            }
        }
    }

    private void x(Canvas canvas) {
        if (this.Or != null) {
            int intrinsicWidth = (this.Or.getIntrinsicWidth() / 2) + this.bQs;
            int intrinsicHeight = (this.Or.getIntrinsicHeight() / 2) + this.bQs;
            int i = intrinsicWidth - (this.bQu / 2);
            int i2 = intrinsicHeight - (this.bQu / 2);
            int i3 = intrinsicWidth + (this.bQu / 2);
            int i4 = intrinsicHeight + (this.bQu / 2);
            this.bQx.set(i, i2, i3, i4);
            canvas.drawOval(this.bQx, this.bQw);
            this.bQx.set((i - this.bQv) - this.bQu, i2, i - this.bQv, i4);
            canvas.drawOval(this.bQx, this.bQw);
            this.bQx.set(this.bQv + i3, i2, i3 + this.bQv + this.bQu, i4);
            canvas.drawOval(this.bQx, this.bQw);
        }
    }

    private void y(Canvas canvas) {
        if (!ap.isEmpty(this.bQk) && this.Or != null) {
            this.bOE.getTextBounds(this.bQk, 0, this.bQk.length(), this.bQm);
            Paint.FontMetrics fontMetrics = this.bOE.getFontMetrics();
            int intrinsicWidth = (this.Or.getIntrinsicWidth() / 2) + this.bQs;
            canvas.drawText(this.bQk, intrinsicWidth, (getResources().getDimension(d.e.tbds10) + fontMetrics.bottom) - fontMetrics.ascent, this.bOE);
        }
    }

    private void initView() {
        setLayerType(1, null);
        aep();
        this.bOE = new Paint(1);
        this.bOE.setColor(al.getColor(d.C0277d.cp_btn_a));
        this.bOE.setTextSize(com.baidu.adp.lib.util.l.h(getContext(), d.e.tbfontsize26));
        this.bOE.setTextAlign(Paint.Align.CENTER);
        this.bOE.setTypeface(Typeface.MONOSPACE);
        this.bQm = new Rect();
        this.bQn = com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds13);
        this.bQo = com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds42);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setStyle(Paint.Style.FILL);
        this.mShadowPaint.setColor(al.getColor(d.C0277d.transparent));
        this.bQp = 0;
        this.mShadowRadius = com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds8);
        this.bQq = com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds3);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.bQp, this.bQq, al.getColor(d.C0277d.cp_cont_h_alpha66));
        this.bQr = new RectF();
        this.bQt = com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds21);
        this.bQu = com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds8);
        this.bQv = com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds6);
        this.bQw = new Paint();
        this.bQw.setAntiAlias(true);
        this.bQw.setStyle(Paint.Style.FILL);
        this.bQw.setColor(al.getColor(d.C0277d.cp_btn_a));
        this.bQx = new RectF();
    }

    private void aep() {
        String str = Build.MODEL;
        if (str.contains("vivo") && str.contains("X20")) {
            this.bQl = com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds2);
        }
    }

    @Deprecated
    public void refresh(int i) {
        int i2;
        if (i <= 0) {
            i2 = d.f.icon_news_red_dot;
            this.bQk = null;
        } else if (i < 10) {
            this.bQk = String.valueOf(i);
            i2 = d.f.icon_news_red_dot_one_number;
        } else if (i < 100) {
            this.bQk = String.valueOf(i);
            i2 = d.f.icon_news_red_dot_two_number;
        } else if (this.mType == 1) {
            this.bQk = "...";
            i2 = d.f.icon_news_red_dot_three_dot_number;
        } else if (this.mType == 2) {
            this.bQk = "99+";
            i2 = d.f.icon_news_red_dot_three_number;
        } else {
            i2 = 0;
        }
        if (i2 != this.bQi) {
            this.bQj = true;
        } else {
            this.bQj = false;
        }
        this.bQi = i2;
        onChangeSkinType();
    }

    public void M(String str, boolean z) {
        int i;
        if (z) {
            this.bQk = "...";
            i = d.f.icon_news_red_dot_three_dot_number;
        } else if (ap.isEmpty(str)) {
            i = d.f.icon_news_red_dot;
            this.bQk = null;
        } else {
            int measureText = (int) this.bOE.measureText(str);
            if (this.Or == null || this.Or.getIntrinsicWidth() - (this.bQn * 2) != measureText) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setCornerRadius(this.bQt);
                gradientDrawable.setColor(al.getColor(d.C0277d.cp_cont_h));
                gradientDrawable.setSize(((int) this.bOE.measureText(str)) + (this.bQn * 2), this.bQo);
                this.Or = gradientDrawable;
                this.bQj = true;
            } else if (this.bQy != TbadkApplication.getInst().getSkinType() && (this.Or instanceof GradientDrawable)) {
                ((GradientDrawable) this.Or).setColor(al.getColor(d.C0277d.cp_cont_h));
                this.bQj = false;
            }
            this.bQk = str;
            this.bQi = 0;
            onChangeSkinType();
            return;
        }
        if (i != this.bQi) {
            this.bQj = true;
        } else {
            this.bQj = false;
        }
        this.bQi = i;
        onChangeSkinType();
    }

    public void setThreeDotMode(int i) {
        this.mType = i;
    }

    public void onChangeSkinType() {
        this.bQy = TbadkApplication.getInst().getSkinType();
        if (this.bQi > 0) {
            this.Or = al.getDrawable(this.bQi);
        } else if (this.Or instanceof GradientDrawable) {
            ((GradientDrawable) this.Or).setColor(al.getColor(d.C0277d.cp_cont_h));
        }
        this.bQw.setColor(al.getColor(d.C0277d.cp_btn_a));
        if (this.bOE != null) {
            this.bOE.setColor(al.getColor(d.C0277d.cp_btn_a));
        }
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.bQp, this.bQq, al.getColor(d.C0277d.cp_cont_h_alpha66));
        if (this.bQj) {
            this.bQj = false;
            requestLayout();
        }
        invalidate();
    }
}
