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
    private Paint bOF;
    private int bQj;
    private boolean bQk;
    private String bQl;
    private int bQm;
    private Rect bQn;
    private int bQo;
    private int bQp;
    private int bQq;
    private int bQr;
    private RectF bQs;
    private int bQt;
    private int bQu;
    private int bQv;
    private int bQw;
    private Paint bQx;
    private RectF bQy;
    private int bQz;
    private Paint mShadowPaint;
    private int mShadowRadius;
    private int mType;

    public MessageRedDotView(@NonNull Context context) {
        super(context);
        this.mType = 1;
        this.bQz = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 1;
        this.bQz = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 1;
        this.bQz = 3;
        initView();
    }

    @RequiresApi(api = 21)
    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mType = 1;
        this.bQz = 3;
        initView();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.Or != null) {
            this.bQt = this.bQq >= this.bQr ? this.mShadowRadius + this.bQq : this.mShadowRadius + this.bQr;
            setMeasuredDimension(this.Or.getIntrinsicWidth() + (this.bQt * 2), this.Or.getIntrinsicHeight() + (this.bQt * 2));
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
            this.Or.setBounds(this.bQt, this.bQt, this.bQt + intrinsicWidth, this.bQt + intrinsicHeight);
            this.Or.draw(canvas);
            this.bQs.set(this.bQt, this.bQt, this.bQt + intrinsicWidth, this.bQt + intrinsicHeight);
            if (intrinsicWidth != intrinsicHeight) {
                canvas.drawRoundRect(this.bQs, this.bQu, this.bQu, this.mShadowPaint);
            } else {
                canvas.drawOval(this.bQs, this.mShadowPaint);
            }
            if (!ap.isEmpty(this.bQl)) {
                if (this.bQl.equals("...")) {
                    x(canvas);
                } else {
                    y(canvas);
                }
            }
        }
    }

    private void x(Canvas canvas) {
        if (this.Or != null) {
            int intrinsicWidth = (this.Or.getIntrinsicWidth() / 2) + this.bQt;
            int intrinsicHeight = (this.Or.getIntrinsicHeight() / 2) + this.bQt;
            int i = intrinsicWidth - (this.bQv / 2);
            int i2 = intrinsicHeight - (this.bQv / 2);
            int i3 = intrinsicWidth + (this.bQv / 2);
            int i4 = intrinsicHeight + (this.bQv / 2);
            this.bQy.set(i, i2, i3, i4);
            canvas.drawOval(this.bQy, this.bQx);
            this.bQy.set((i - this.bQw) - this.bQv, i2, i - this.bQw, i4);
            canvas.drawOval(this.bQy, this.bQx);
            this.bQy.set(this.bQw + i3, i2, i3 + this.bQw + this.bQv, i4);
            canvas.drawOval(this.bQy, this.bQx);
        }
    }

    private void y(Canvas canvas) {
        if (!ap.isEmpty(this.bQl) && this.Or != null) {
            this.bOF.getTextBounds(this.bQl, 0, this.bQl.length(), this.bQn);
            Paint.FontMetrics fontMetrics = this.bOF.getFontMetrics();
            int intrinsicWidth = (this.Or.getIntrinsicWidth() / 2) + this.bQt;
            canvas.drawText(this.bQl, intrinsicWidth, (getResources().getDimension(d.e.tbds10) + fontMetrics.bottom) - fontMetrics.ascent, this.bOF);
        }
    }

    private void initView() {
        setLayerType(1, null);
        aep();
        this.bOF = new Paint(1);
        this.bOF.setColor(al.getColor(d.C0277d.cp_btn_a));
        this.bOF.setTextSize(com.baidu.adp.lib.util.l.h(getContext(), d.e.tbfontsize26));
        this.bOF.setTextAlign(Paint.Align.CENTER);
        this.bOF.setTypeface(Typeface.MONOSPACE);
        this.bQn = new Rect();
        this.bQo = com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds13);
        this.bQp = com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds42);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setStyle(Paint.Style.FILL);
        this.mShadowPaint.setColor(al.getColor(d.C0277d.transparent));
        this.bQq = 0;
        this.mShadowRadius = com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds8);
        this.bQr = com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds3);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.bQq, this.bQr, al.getColor(d.C0277d.cp_cont_h_alpha66));
        this.bQs = new RectF();
        this.bQu = com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds21);
        this.bQv = com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds8);
        this.bQw = com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds6);
        this.bQx = new Paint();
        this.bQx.setAntiAlias(true);
        this.bQx.setStyle(Paint.Style.FILL);
        this.bQx.setColor(al.getColor(d.C0277d.cp_btn_a));
        this.bQy = new RectF();
    }

    private void aep() {
        String str = Build.MODEL;
        if (str.contains("vivo") && str.contains("X20")) {
            this.bQm = com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds2);
        }
    }

    @Deprecated
    public void refresh(int i) {
        int i2;
        if (i <= 0) {
            i2 = d.f.icon_news_red_dot;
            this.bQl = null;
        } else if (i < 10) {
            this.bQl = String.valueOf(i);
            i2 = d.f.icon_news_red_dot_one_number;
        } else if (i < 100) {
            this.bQl = String.valueOf(i);
            i2 = d.f.icon_news_red_dot_two_number;
        } else if (this.mType == 1) {
            this.bQl = "...";
            i2 = d.f.icon_news_red_dot_three_dot_number;
        } else if (this.mType == 2) {
            this.bQl = "99+";
            i2 = d.f.icon_news_red_dot_three_number;
        } else {
            i2 = 0;
        }
        if (i2 != this.bQj) {
            this.bQk = true;
        } else {
            this.bQk = false;
        }
        this.bQj = i2;
        onChangeSkinType();
    }

    public void M(String str, boolean z) {
        int i;
        if (z) {
            this.bQl = "...";
            i = d.f.icon_news_red_dot_three_dot_number;
        } else if (ap.isEmpty(str)) {
            i = d.f.icon_news_red_dot;
            this.bQl = null;
        } else {
            int measureText = (int) this.bOF.measureText(str);
            if (this.Or == null || this.Or.getIntrinsicWidth() - (this.bQo * 2) != measureText) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setCornerRadius(this.bQu);
                gradientDrawable.setColor(al.getColor(d.C0277d.cp_cont_h));
                gradientDrawable.setSize(((int) this.bOF.measureText(str)) + (this.bQo * 2), this.bQp);
                this.Or = gradientDrawable;
                this.bQk = true;
            } else if (this.bQz != TbadkApplication.getInst().getSkinType() && (this.Or instanceof GradientDrawable)) {
                ((GradientDrawable) this.Or).setColor(al.getColor(d.C0277d.cp_cont_h));
                this.bQk = false;
            }
            this.bQl = str;
            this.bQj = 0;
            onChangeSkinType();
            return;
        }
        if (i != this.bQj) {
            this.bQk = true;
        } else {
            this.bQk = false;
        }
        this.bQj = i;
        onChangeSkinType();
    }

    public void setThreeDotMode(int i) {
        this.mType = i;
    }

    public void onChangeSkinType() {
        this.bQz = TbadkApplication.getInst().getSkinType();
        if (this.bQj > 0) {
            this.Or = al.getDrawable(this.bQj);
        } else if (this.Or instanceof GradientDrawable) {
            ((GradientDrawable) this.Or).setColor(al.getColor(d.C0277d.cp_cont_h));
        }
        this.bQx.setColor(al.getColor(d.C0277d.cp_btn_a));
        if (this.bOF != null) {
            this.bOF.setColor(al.getColor(d.C0277d.cp_btn_a));
        }
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.bQq, this.bQr, al.getColor(d.C0277d.cp_cont_h_alpha66));
        if (this.bQk) {
            this.bQk = false;
            requestLayout();
        }
        invalidate();
    }
}
