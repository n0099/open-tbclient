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
    private Paint bOC;
    private int bQg;
    private boolean bQh;
    private String bQi;
    private int bQj;
    private Rect bQk;
    private int bQl;
    private int bQm;
    private int bQn;
    private int bQo;
    private RectF bQp;
    private int bQq;
    private int bQr;
    private int bQs;
    private int bQt;
    private Paint bQu;
    private RectF bQv;
    private int bQw;
    private Paint mShadowPaint;
    private int mShadowRadius;
    private int mType;

    public MessageRedDotView(@NonNull Context context) {
        super(context);
        this.mType = 1;
        this.bQw = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 1;
        this.bQw = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 1;
        this.bQw = 3;
        initView();
    }

    @RequiresApi(api = 21)
    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mType = 1;
        this.bQw = 3;
        initView();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.Or != null) {
            this.bQq = this.bQn >= this.bQo ? this.mShadowRadius + this.bQn : this.mShadowRadius + this.bQo;
            setMeasuredDimension(this.Or.getIntrinsicWidth() + (this.bQq * 2), this.Or.getIntrinsicHeight() + (this.bQq * 2));
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
            this.Or.setBounds(this.bQq, this.bQq, this.bQq + intrinsicWidth, this.bQq + intrinsicHeight);
            this.Or.draw(canvas);
            this.bQp.set(this.bQq, this.bQq, this.bQq + intrinsicWidth, this.bQq + intrinsicHeight);
            if (intrinsicWidth != intrinsicHeight) {
                canvas.drawRoundRect(this.bQp, this.bQr, this.bQr, this.mShadowPaint);
            } else {
                canvas.drawOval(this.bQp, this.mShadowPaint);
            }
            if (!ap.isEmpty(this.bQi)) {
                if (this.bQi.equals("...")) {
                    x(canvas);
                } else {
                    y(canvas);
                }
            }
        }
    }

    private void x(Canvas canvas) {
        if (this.Or != null) {
            int intrinsicWidth = (this.Or.getIntrinsicWidth() / 2) + this.bQq;
            int intrinsicHeight = (this.Or.getIntrinsicHeight() / 2) + this.bQq;
            int i = intrinsicWidth - (this.bQs / 2);
            int i2 = intrinsicHeight - (this.bQs / 2);
            int i3 = intrinsicWidth + (this.bQs / 2);
            int i4 = intrinsicHeight + (this.bQs / 2);
            this.bQv.set(i, i2, i3, i4);
            canvas.drawOval(this.bQv, this.bQu);
            this.bQv.set((i - this.bQt) - this.bQs, i2, i - this.bQt, i4);
            canvas.drawOval(this.bQv, this.bQu);
            this.bQv.set(this.bQt + i3, i2, i3 + this.bQt + this.bQs, i4);
            canvas.drawOval(this.bQv, this.bQu);
        }
    }

    private void y(Canvas canvas) {
        if (!ap.isEmpty(this.bQi) && this.Or != null) {
            this.bOC.getTextBounds(this.bQi, 0, this.bQi.length(), this.bQk);
            Paint.FontMetrics fontMetrics = this.bOC.getFontMetrics();
            int intrinsicWidth = (this.Or.getIntrinsicWidth() / 2) + this.bQq;
            canvas.drawText(this.bQi, intrinsicWidth, (getResources().getDimension(d.e.tbds10) + fontMetrics.bottom) - fontMetrics.ascent, this.bOC);
        }
    }

    private void initView() {
        setLayerType(1, null);
        aes();
        this.bOC = new Paint(1);
        this.bOC.setColor(al.getColor(d.C0277d.cp_btn_a));
        this.bOC.setTextSize(com.baidu.adp.lib.util.l.h(getContext(), d.e.tbfontsize26));
        this.bOC.setTextAlign(Paint.Align.CENTER);
        this.bOC.setTypeface(Typeface.MONOSPACE);
        this.bQk = new Rect();
        this.bQl = com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds13);
        this.bQm = com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds42);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setStyle(Paint.Style.FILL);
        this.mShadowPaint.setColor(al.getColor(d.C0277d.transparent));
        this.bQn = 0;
        this.mShadowRadius = com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds8);
        this.bQo = com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds3);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.bQn, this.bQo, al.getColor(d.C0277d.cp_cont_h_alpha66));
        this.bQp = new RectF();
        this.bQr = com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds21);
        this.bQs = com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds8);
        this.bQt = com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds6);
        this.bQu = new Paint();
        this.bQu.setAntiAlias(true);
        this.bQu.setStyle(Paint.Style.FILL);
        this.bQu.setColor(al.getColor(d.C0277d.cp_btn_a));
        this.bQv = new RectF();
    }

    private void aes() {
        String str = Build.MODEL;
        if (str.contains("vivo") && str.contains("X20")) {
            this.bQj = com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds2);
        }
    }

    @Deprecated
    public void refresh(int i) {
        int i2;
        if (i <= 0) {
            i2 = d.f.icon_news_red_dot;
            this.bQi = null;
        } else if (i < 10) {
            this.bQi = String.valueOf(i);
            i2 = d.f.icon_news_red_dot_one_number;
        } else if (i < 100) {
            this.bQi = String.valueOf(i);
            i2 = d.f.icon_news_red_dot_two_number;
        } else if (this.mType == 1) {
            this.bQi = "...";
            i2 = d.f.icon_news_red_dot_three_dot_number;
        } else if (this.mType == 2) {
            this.bQi = "99+";
            i2 = d.f.icon_news_red_dot_three_number;
        } else {
            i2 = 0;
        }
        if (i2 != this.bQg) {
            this.bQh = true;
        } else {
            this.bQh = false;
        }
        this.bQg = i2;
        onChangeSkinType();
    }

    public void M(String str, boolean z) {
        int i;
        if (z) {
            this.bQi = "...";
            i = d.f.icon_news_red_dot_three_dot_number;
        } else if (ap.isEmpty(str)) {
            i = d.f.icon_news_red_dot;
            this.bQi = null;
        } else {
            int measureText = (int) this.bOC.measureText(str);
            if (this.Or == null || this.Or.getIntrinsicWidth() - (this.bQl * 2) != measureText) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setCornerRadius(this.bQr);
                gradientDrawable.setColor(al.getColor(d.C0277d.cp_cont_h));
                gradientDrawable.setSize(((int) this.bOC.measureText(str)) + (this.bQl * 2), this.bQm);
                this.Or = gradientDrawable;
                this.bQh = true;
            } else if (this.bQw != TbadkApplication.getInst().getSkinType() && (this.Or instanceof GradientDrawable)) {
                ((GradientDrawable) this.Or).setColor(al.getColor(d.C0277d.cp_cont_h));
                this.bQh = false;
            }
            this.bQi = str;
            this.bQg = 0;
            onChangeSkinType();
            return;
        }
        if (i != this.bQg) {
            this.bQh = true;
        } else {
            this.bQh = false;
        }
        this.bQg = i;
        onChangeSkinType();
    }

    public void setThreeDotMode(int i) {
        this.mType = i;
    }

    public void onChangeSkinType() {
        this.bQw = TbadkApplication.getInst().getSkinType();
        if (this.bQg > 0) {
            this.Or = al.getDrawable(this.bQg);
        } else if (this.Or instanceof GradientDrawable) {
            ((GradientDrawable) this.Or).setColor(al.getColor(d.C0277d.cp_cont_h));
        }
        this.bQu.setColor(al.getColor(d.C0277d.cp_btn_a));
        if (this.bOC != null) {
            this.bOC.setColor(al.getColor(d.C0277d.cp_btn_a));
        }
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.bQn, this.bQo, al.getColor(d.C0277d.cp_cont_h_alpha66));
        if (this.bQh) {
            this.bQh = false;
            requestLayout();
        }
        invalidate();
    }
}
