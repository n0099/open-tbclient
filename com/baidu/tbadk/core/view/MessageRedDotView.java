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
    private Drawable Oq;
    private Paint bOB;
    private int bQf;
    private boolean bQg;
    private String bQh;
    private int bQi;
    private Rect bQj;
    private int bQk;
    private int bQl;
    private int bQm;
    private int bQn;
    private RectF bQo;
    private int bQp;
    private int bQq;
    private int bQr;
    private int bQs;
    private Paint bQt;
    private RectF bQu;
    private int bQv;
    private Paint mShadowPaint;
    private int mShadowRadius;
    private int mType;

    public MessageRedDotView(@NonNull Context context) {
        super(context);
        this.mType = 1;
        this.bQv = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 1;
        this.bQv = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 1;
        this.bQv = 3;
        initView();
    }

    @RequiresApi(api = 21)
    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mType = 1;
        this.bQv = 3;
        initView();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.Oq != null) {
            this.bQp = this.bQm >= this.bQn ? this.mShadowRadius + this.bQm : this.mShadowRadius + this.bQn;
            setMeasuredDimension(this.Oq.getIntrinsicWidth() + (this.bQp * 2), this.Oq.getIntrinsicHeight() + (this.bQp * 2));
            return;
        }
        setMeasuredDimension(0, 0);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.Oq != null) {
            int intrinsicWidth = this.Oq.getIntrinsicWidth();
            int intrinsicHeight = this.Oq.getIntrinsicHeight();
            this.Oq.setBounds(this.bQp, this.bQp, this.bQp + intrinsicWidth, this.bQp + intrinsicHeight);
            this.Oq.draw(canvas);
            this.bQo.set(this.bQp, this.bQp, this.bQp + intrinsicWidth, this.bQp + intrinsicHeight);
            if (intrinsicWidth != intrinsicHeight) {
                canvas.drawRoundRect(this.bQo, this.bQq, this.bQq, this.mShadowPaint);
            } else {
                canvas.drawOval(this.bQo, this.mShadowPaint);
            }
            if (!ap.isEmpty(this.bQh)) {
                if (this.bQh.equals("...")) {
                    x(canvas);
                } else {
                    y(canvas);
                }
            }
        }
    }

    private void x(Canvas canvas) {
        if (this.Oq != null) {
            int intrinsicWidth = (this.Oq.getIntrinsicWidth() / 2) + this.bQp;
            int intrinsicHeight = (this.Oq.getIntrinsicHeight() / 2) + this.bQp;
            int i = intrinsicWidth - (this.bQr / 2);
            int i2 = intrinsicHeight - (this.bQr / 2);
            int i3 = intrinsicWidth + (this.bQr / 2);
            int i4 = intrinsicHeight + (this.bQr / 2);
            this.bQu.set(i, i2, i3, i4);
            canvas.drawOval(this.bQu, this.bQt);
            this.bQu.set((i - this.bQs) - this.bQr, i2, i - this.bQs, i4);
            canvas.drawOval(this.bQu, this.bQt);
            this.bQu.set(this.bQs + i3, i2, i3 + this.bQs + this.bQr, i4);
            canvas.drawOval(this.bQu, this.bQt);
        }
    }

    private void y(Canvas canvas) {
        if (!ap.isEmpty(this.bQh) && this.Oq != null) {
            this.bOB.getTextBounds(this.bQh, 0, this.bQh.length(), this.bQj);
            Paint.FontMetrics fontMetrics = this.bOB.getFontMetrics();
            int intrinsicWidth = (this.Oq.getIntrinsicWidth() / 2) + this.bQp;
            canvas.drawText(this.bQh, intrinsicWidth, (getResources().getDimension(d.e.tbds10) + fontMetrics.bottom) - fontMetrics.ascent, this.bOB);
        }
    }

    private void initView() {
        setLayerType(1, null);
        aes();
        this.bOB = new Paint(1);
        this.bOB.setColor(al.getColor(d.C0236d.cp_btn_a));
        this.bOB.setTextSize(com.baidu.adp.lib.util.l.h(getContext(), d.e.tbfontsize26));
        this.bOB.setTextAlign(Paint.Align.CENTER);
        this.bOB.setTypeface(Typeface.MONOSPACE);
        this.bQj = new Rect();
        this.bQk = com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds13);
        this.bQl = com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds42);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setStyle(Paint.Style.FILL);
        this.mShadowPaint.setColor(al.getColor(d.C0236d.transparent));
        this.bQm = 0;
        this.mShadowRadius = com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds8);
        this.bQn = com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds3);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.bQm, this.bQn, al.getColor(d.C0236d.cp_cont_h_alpha66));
        this.bQo = new RectF();
        this.bQq = com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds21);
        this.bQr = com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds8);
        this.bQs = com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds6);
        this.bQt = new Paint();
        this.bQt.setAntiAlias(true);
        this.bQt.setStyle(Paint.Style.FILL);
        this.bQt.setColor(al.getColor(d.C0236d.cp_btn_a));
        this.bQu = new RectF();
    }

    private void aes() {
        String str = Build.MODEL;
        if (str.contains("vivo") && str.contains("X20")) {
            this.bQi = com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds2);
        }
    }

    @Deprecated
    public void refresh(int i) {
        int i2;
        if (i <= 0) {
            i2 = d.f.icon_news_red_dot;
            this.bQh = null;
        } else if (i < 10) {
            this.bQh = String.valueOf(i);
            i2 = d.f.icon_news_red_dot_one_number;
        } else if (i < 100) {
            this.bQh = String.valueOf(i);
            i2 = d.f.icon_news_red_dot_two_number;
        } else if (this.mType == 1) {
            this.bQh = "...";
            i2 = d.f.icon_news_red_dot_three_dot_number;
        } else if (this.mType == 2) {
            this.bQh = "99+";
            i2 = d.f.icon_news_red_dot_three_number;
        } else {
            i2 = 0;
        }
        if (i2 != this.bQf) {
            this.bQg = true;
        } else {
            this.bQg = false;
        }
        this.bQf = i2;
        onChangeSkinType();
    }

    public void M(String str, boolean z) {
        int i;
        if (z) {
            this.bQh = "...";
            i = d.f.icon_news_red_dot_three_dot_number;
        } else if (ap.isEmpty(str)) {
            i = d.f.icon_news_red_dot;
            this.bQh = null;
        } else {
            int measureText = (int) this.bOB.measureText(str);
            if (this.Oq == null || this.Oq.getIntrinsicWidth() - (this.bQk * 2) != measureText) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setCornerRadius(this.bQq);
                gradientDrawable.setColor(al.getColor(d.C0236d.cp_cont_h));
                gradientDrawable.setSize(((int) this.bOB.measureText(str)) + (this.bQk * 2), this.bQl);
                this.Oq = gradientDrawable;
                this.bQg = true;
            } else if (this.bQv != TbadkApplication.getInst().getSkinType() && (this.Oq instanceof GradientDrawable)) {
                ((GradientDrawable) this.Oq).setColor(al.getColor(d.C0236d.cp_cont_h));
                this.bQg = false;
            }
            this.bQh = str;
            this.bQf = 0;
            onChangeSkinType();
            return;
        }
        if (i != this.bQf) {
            this.bQg = true;
        } else {
            this.bQg = false;
        }
        this.bQf = i;
        onChangeSkinType();
    }

    public void setThreeDotMode(int i) {
        this.mType = i;
    }

    public void onChangeSkinType() {
        this.bQv = TbadkApplication.getInst().getSkinType();
        if (this.bQf > 0) {
            this.Oq = al.getDrawable(this.bQf);
        } else if (this.Oq instanceof GradientDrawable) {
            ((GradientDrawable) this.Oq).setColor(al.getColor(d.C0236d.cp_cont_h));
        }
        this.bQt.setColor(al.getColor(d.C0236d.cp_btn_a));
        if (this.bOB != null) {
            this.bOB.setColor(al.getColor(d.C0236d.cp_btn_a));
        }
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.bQm, this.bQn, al.getColor(d.C0236d.cp_cont_h_alpha66));
        if (this.bQg) {
            this.bQg = false;
            requestLayout();
        }
        invalidate();
    }
}
