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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class MessageRedDotView extends View {
    private Drawable Mp;
    private Paint bXC;
    private int bZg;
    private boolean bZh;
    private String bZi;
    private int bZj;
    private Rect bZk;
    private int bZl;
    private int bZm;
    private int bZn;
    private int bZo;
    private RectF bZp;
    private int bZq;
    private int bZr;
    private int bZs;
    private int bZt;
    private Paint bZu;
    private RectF bZv;
    private int bZw;
    private Paint mShadowPaint;
    private int mShadowRadius;
    private int mType;

    public MessageRedDotView(@NonNull Context context) {
        super(context);
        this.mType = 1;
        this.bZw = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 1;
        this.bZw = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 1;
        this.bZw = 3;
        initView();
    }

    @RequiresApi(api = 21)
    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mType = 1;
        this.bZw = 3;
        initView();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.Mp != null) {
            this.bZq = this.bZn >= this.bZo ? this.mShadowRadius + this.bZn : this.mShadowRadius + this.bZo;
            setMeasuredDimension(this.Mp.getIntrinsicWidth() + (this.bZq * 2), this.Mp.getIntrinsicHeight() + (this.bZq * 2));
            return;
        }
        setMeasuredDimension(0, 0);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.Mp != null) {
            int intrinsicWidth = this.Mp.getIntrinsicWidth();
            int intrinsicHeight = this.Mp.getIntrinsicHeight();
            this.Mp.setBounds(this.bZq, this.bZq, this.bZq + intrinsicWidth, this.bZq + intrinsicHeight);
            this.Mp.draw(canvas);
            this.bZp.set(this.bZq, this.bZq, this.bZq + intrinsicWidth, this.bZq + intrinsicHeight);
            if (intrinsicWidth != intrinsicHeight) {
                canvas.drawRoundRect(this.bZp, this.bZr, this.bZr, this.mShadowPaint);
            } else {
                canvas.drawOval(this.bZp, this.mShadowPaint);
            }
            if (!aq.isEmpty(this.bZi)) {
                if (this.bZi.equals("...")) {
                    x(canvas);
                } else {
                    y(canvas);
                }
            }
        }
    }

    private void x(Canvas canvas) {
        if (this.Mp != null) {
            int intrinsicWidth = (this.Mp.getIntrinsicWidth() / 2) + this.bZq;
            int intrinsicHeight = (this.Mp.getIntrinsicHeight() / 2) + this.bZq;
            int i = intrinsicWidth - (this.bZs / 2);
            int i2 = intrinsicHeight - (this.bZs / 2);
            int i3 = intrinsicWidth + (this.bZs / 2);
            int i4 = intrinsicHeight + (this.bZs / 2);
            this.bZv.set(i, i2, i3, i4);
            canvas.drawOval(this.bZv, this.bZu);
            this.bZv.set((i - this.bZt) - this.bZs, i2, i - this.bZt, i4);
            canvas.drawOval(this.bZv, this.bZu);
            this.bZv.set(this.bZt + i3, i2, i3 + this.bZt + this.bZs, i4);
            canvas.drawOval(this.bZv, this.bZu);
        }
    }

    private void y(Canvas canvas) {
        if (!aq.isEmpty(this.bZi) && this.Mp != null) {
            this.bXC.getTextBounds(this.bZi, 0, this.bZi.length(), this.bZk);
            Paint.FontMetrics fontMetrics = this.bXC.getFontMetrics();
            int intrinsicWidth = (this.Mp.getIntrinsicWidth() / 2) + this.bZq;
            canvas.drawText(this.bZi, intrinsicWidth, (getResources().getDimension(R.dimen.tbds10) + fontMetrics.bottom) - fontMetrics.ascent, this.bXC);
        }
    }

    private void initView() {
        setLayerType(1, null);
        aku();
        this.bXC = new Paint(1);
        this.bXC.setColor(am.getColor(R.color.cp_btn_a));
        this.bXC.setTextSize(com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbfontsize26));
        this.bXC.setTextAlign(Paint.Align.CENTER);
        this.bXC.setTypeface(Typeface.MONOSPACE);
        this.bZk = new Rect();
        this.bZl = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds13);
        this.bZm = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds42);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setStyle(Paint.Style.FILL);
        this.mShadowPaint.setColor(am.getColor(R.color.transparent));
        this.bZn = 0;
        this.mShadowRadius = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds8);
        this.bZo = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds3);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.bZn, this.bZo, am.getColor(R.color.cp_cont_h_alpha66));
        this.bZp = new RectF();
        this.bZr = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds21);
        this.bZs = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds8);
        this.bZt = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds6);
        this.bZu = new Paint();
        this.bZu.setAntiAlias(true);
        this.bZu.setStyle(Paint.Style.FILL);
        this.bZu.setColor(am.getColor(R.color.cp_btn_a));
        this.bZv = new RectF();
    }

    private void aku() {
        String str = Build.MODEL;
        if (str.contains("vivo") && str.contains("X20")) {
            this.bZj = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds2);
        }
    }

    @Deprecated
    public void refresh(int i) {
        int i2;
        if (i <= 0) {
            i2 = R.drawable.icon_news_red_dot;
            this.bZi = null;
        } else if (i < 10) {
            this.bZi = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_one_number;
        } else if (i < 100) {
            this.bZi = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_two_number;
        } else if (this.mType == 1) {
            this.bZi = "...";
            i2 = R.drawable.icon_news_red_dot_three_dot_number;
        } else if (this.mType == 2) {
            this.bZi = "99+";
            i2 = R.drawable.icon_news_red_dot_three_number;
        } else {
            i2 = 0;
        }
        if (i2 != this.bZg) {
            this.bZh = true;
        } else {
            this.bZh = false;
        }
        this.bZg = i2;
        onChangeSkinType();
    }

    public void Q(String str, boolean z) {
        int i;
        if (z) {
            this.bZi = "...";
            i = R.drawable.icon_news_red_dot_three_dot_number;
        } else if (aq.isEmpty(str)) {
            i = R.drawable.icon_news_red_dot;
            this.bZi = null;
        } else {
            int measureText = (int) this.bXC.measureText(str);
            if (this.Mp == null || this.Mp.getIntrinsicWidth() - (this.bZl * 2) != measureText) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setCornerRadius(this.bZr);
                gradientDrawable.setColor(am.getColor(R.color.cp_cont_h));
                gradientDrawable.setSize(((int) this.bXC.measureText(str)) + (this.bZl * 2), this.bZm);
                this.Mp = gradientDrawable;
                this.bZh = true;
            } else if (this.bZw != TbadkApplication.getInst().getSkinType() && (this.Mp instanceof GradientDrawable)) {
                ((GradientDrawable) this.Mp).setColor(am.getColor(R.color.cp_cont_h));
                this.bZh = false;
            }
            this.bZi = str;
            this.bZg = 0;
            onChangeSkinType();
            return;
        }
        if (i != this.bZg) {
            this.bZh = true;
        } else {
            this.bZh = false;
        }
        this.bZg = i;
        onChangeSkinType();
    }

    public void setThreeDotMode(int i) {
        this.mType = i;
    }

    public void onChangeSkinType() {
        this.bZw = TbadkApplication.getInst().getSkinType();
        if (this.bZg > 0) {
            this.Mp = am.getDrawable(this.bZg);
        } else if (this.Mp instanceof GradientDrawable) {
            ((GradientDrawable) this.Mp).setColor(am.getColor(R.color.cp_cont_h));
        }
        this.bZu.setColor(am.getColor(R.color.cp_btn_a));
        if (this.bXC != null) {
            this.bXC.setColor(am.getColor(R.color.cp_btn_a));
        }
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.bZn, this.bZo, am.getColor(R.color.cp_cont_h_alpha66));
        if (this.bZh) {
            this.bZh = false;
            requestLayout();
        }
        invalidate();
    }
}
