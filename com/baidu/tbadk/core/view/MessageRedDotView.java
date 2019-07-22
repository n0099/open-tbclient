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
    private Paint bXw;
    private int bZa;
    private boolean bZb;
    private String bZc;
    private int bZd;
    private Rect bZe;
    private int bZf;
    private int bZg;
    private int bZh;
    private int bZi;
    private RectF bZj;
    private int bZk;
    private int bZl;
    private int bZm;
    private int bZn;
    private Paint bZo;
    private RectF bZp;
    private int bZq;
    private Paint mShadowPaint;
    private int mShadowRadius;
    private int mType;

    public MessageRedDotView(@NonNull Context context) {
        super(context);
        this.mType = 1;
        this.bZq = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 1;
        this.bZq = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 1;
        this.bZq = 3;
        initView();
    }

    @RequiresApi(api = 21)
    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mType = 1;
        this.bZq = 3;
        initView();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.Mp != null) {
            this.bZk = this.bZh >= this.bZi ? this.mShadowRadius + this.bZh : this.mShadowRadius + this.bZi;
            setMeasuredDimension(this.Mp.getIntrinsicWidth() + (this.bZk * 2), this.Mp.getIntrinsicHeight() + (this.bZk * 2));
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
            this.Mp.setBounds(this.bZk, this.bZk, this.bZk + intrinsicWidth, this.bZk + intrinsicHeight);
            this.Mp.draw(canvas);
            this.bZj.set(this.bZk, this.bZk, this.bZk + intrinsicWidth, this.bZk + intrinsicHeight);
            if (intrinsicWidth != intrinsicHeight) {
                canvas.drawRoundRect(this.bZj, this.bZl, this.bZl, this.mShadowPaint);
            } else {
                canvas.drawOval(this.bZj, this.mShadowPaint);
            }
            if (!aq.isEmpty(this.bZc)) {
                if (this.bZc.equals("...")) {
                    x(canvas);
                } else {
                    y(canvas);
                }
            }
        }
    }

    private void x(Canvas canvas) {
        if (this.Mp != null) {
            int intrinsicWidth = (this.Mp.getIntrinsicWidth() / 2) + this.bZk;
            int intrinsicHeight = (this.Mp.getIntrinsicHeight() / 2) + this.bZk;
            int i = intrinsicWidth - (this.bZm / 2);
            int i2 = intrinsicHeight - (this.bZm / 2);
            int i3 = intrinsicWidth + (this.bZm / 2);
            int i4 = intrinsicHeight + (this.bZm / 2);
            this.bZp.set(i, i2, i3, i4);
            canvas.drawOval(this.bZp, this.bZo);
            this.bZp.set((i - this.bZn) - this.bZm, i2, i - this.bZn, i4);
            canvas.drawOval(this.bZp, this.bZo);
            this.bZp.set(this.bZn + i3, i2, i3 + this.bZn + this.bZm, i4);
            canvas.drawOval(this.bZp, this.bZo);
        }
    }

    private void y(Canvas canvas) {
        if (!aq.isEmpty(this.bZc) && this.Mp != null) {
            this.bXw.getTextBounds(this.bZc, 0, this.bZc.length(), this.bZe);
            Paint.FontMetrics fontMetrics = this.bXw.getFontMetrics();
            int intrinsicWidth = (this.Mp.getIntrinsicWidth() / 2) + this.bZk;
            canvas.drawText(this.bZc, intrinsicWidth, (getResources().getDimension(R.dimen.tbds10) + fontMetrics.bottom) - fontMetrics.ascent, this.bXw);
        }
    }

    private void initView() {
        setLayerType(1, null);
        aks();
        this.bXw = new Paint(1);
        this.bXw.setColor(am.getColor(R.color.cp_btn_a));
        this.bXw.setTextSize(com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbfontsize26));
        this.bXw.setTextAlign(Paint.Align.CENTER);
        this.bXw.setTypeface(Typeface.MONOSPACE);
        this.bZe = new Rect();
        this.bZf = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds13);
        this.bZg = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds42);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setStyle(Paint.Style.FILL);
        this.mShadowPaint.setColor(am.getColor(R.color.transparent));
        this.bZh = 0;
        this.mShadowRadius = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds8);
        this.bZi = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds3);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.bZh, this.bZi, am.getColor(R.color.cp_cont_h_alpha66));
        this.bZj = new RectF();
        this.bZl = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds21);
        this.bZm = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds8);
        this.bZn = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds6);
        this.bZo = new Paint();
        this.bZo.setAntiAlias(true);
        this.bZo.setStyle(Paint.Style.FILL);
        this.bZo.setColor(am.getColor(R.color.cp_btn_a));
        this.bZp = new RectF();
    }

    private void aks() {
        String str = Build.MODEL;
        if (str.contains("vivo") && str.contains("X20")) {
            this.bZd = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds2);
        }
    }

    @Deprecated
    public void refresh(int i) {
        int i2;
        if (i <= 0) {
            i2 = R.drawable.icon_news_red_dot;
            this.bZc = null;
        } else if (i < 10) {
            this.bZc = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_one_number;
        } else if (i < 100) {
            this.bZc = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_two_number;
        } else if (this.mType == 1) {
            this.bZc = "...";
            i2 = R.drawable.icon_news_red_dot_three_dot_number;
        } else if (this.mType == 2) {
            this.bZc = "99+";
            i2 = R.drawable.icon_news_red_dot_three_number;
        } else {
            i2 = 0;
        }
        if (i2 != this.bZa) {
            this.bZb = true;
        } else {
            this.bZb = false;
        }
        this.bZa = i2;
        onChangeSkinType();
    }

    public void Q(String str, boolean z) {
        int i;
        if (z) {
            this.bZc = "...";
            i = R.drawable.icon_news_red_dot_three_dot_number;
        } else if (aq.isEmpty(str)) {
            i = R.drawable.icon_news_red_dot;
            this.bZc = null;
        } else {
            int measureText = (int) this.bXw.measureText(str);
            if (this.Mp == null || this.Mp.getIntrinsicWidth() - (this.bZf * 2) != measureText) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setCornerRadius(this.bZl);
                gradientDrawable.setColor(am.getColor(R.color.cp_cont_h));
                gradientDrawable.setSize(((int) this.bXw.measureText(str)) + (this.bZf * 2), this.bZg);
                this.Mp = gradientDrawable;
                this.bZb = true;
            } else if (this.bZq != TbadkApplication.getInst().getSkinType() && (this.Mp instanceof GradientDrawable)) {
                ((GradientDrawable) this.Mp).setColor(am.getColor(R.color.cp_cont_h));
                this.bZb = false;
            }
            this.bZc = str;
            this.bZa = 0;
            onChangeSkinType();
            return;
        }
        if (i != this.bZa) {
            this.bZb = true;
        } else {
            this.bZb = false;
        }
        this.bZa = i;
        onChangeSkinType();
    }

    public void setThreeDotMode(int i) {
        this.mType = i;
    }

    public void onChangeSkinType() {
        this.bZq = TbadkApplication.getInst().getSkinType();
        if (this.bZa > 0) {
            this.Mp = am.getDrawable(this.bZa);
        } else if (this.Mp instanceof GradientDrawable) {
            ((GradientDrawable) this.Mp).setColor(am.getColor(R.color.cp_cont_h));
        }
        this.bZo.setColor(am.getColor(R.color.cp_btn_a));
        if (this.bXw != null) {
            this.bXw.setColor(am.getColor(R.color.cp_btn_a));
        }
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.bZh, this.bZi, am.getColor(R.color.cp_cont_h_alpha66));
        if (this.bZb) {
            this.bZb = false;
            requestLayout();
        }
        invalidate();
    }
}
