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
    private Paint bYv;
    private int bZZ;
    private boolean caa;
    private String cab;
    private int cac;
    private Rect cad;
    private int cae;
    private int caf;
    private int cag;
    private int cah;
    private RectF cai;
    private int caj;
    private int cak;
    private int cal;
    private int cam;
    private Paint can;
    private RectF cao;
    private int cap;
    private Paint mShadowPaint;
    private int mShadowRadius;
    private int mType;

    public MessageRedDotView(@NonNull Context context) {
        super(context);
        this.mType = 1;
        this.cap = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 1;
        this.cap = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 1;
        this.cap = 3;
        initView();
    }

    @RequiresApi(api = 21)
    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mType = 1;
        this.cap = 3;
        initView();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.Mp != null) {
            this.caj = this.cag >= this.cah ? this.mShadowRadius + this.cag : this.mShadowRadius + this.cah;
            setMeasuredDimension(this.Mp.getIntrinsicWidth() + (this.caj * 2), this.Mp.getIntrinsicHeight() + (this.caj * 2));
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
            this.Mp.setBounds(this.caj, this.caj, this.caj + intrinsicWidth, this.caj + intrinsicHeight);
            this.Mp.draw(canvas);
            this.cai.set(this.caj, this.caj, this.caj + intrinsicWidth, this.caj + intrinsicHeight);
            if (intrinsicWidth != intrinsicHeight) {
                canvas.drawRoundRect(this.cai, this.cak, this.cak, this.mShadowPaint);
            } else {
                canvas.drawOval(this.cai, this.mShadowPaint);
            }
            if (!aq.isEmpty(this.cab)) {
                if (this.cab.equals("...")) {
                    x(canvas);
                } else {
                    y(canvas);
                }
            }
        }
    }

    private void x(Canvas canvas) {
        if (this.Mp != null) {
            int intrinsicWidth = (this.Mp.getIntrinsicWidth() / 2) + this.caj;
            int intrinsicHeight = (this.Mp.getIntrinsicHeight() / 2) + this.caj;
            int i = intrinsicWidth - (this.cal / 2);
            int i2 = intrinsicHeight - (this.cal / 2);
            int i3 = intrinsicWidth + (this.cal / 2);
            int i4 = intrinsicHeight + (this.cal / 2);
            this.cao.set(i, i2, i3, i4);
            canvas.drawOval(this.cao, this.can);
            this.cao.set((i - this.cam) - this.cal, i2, i - this.cam, i4);
            canvas.drawOval(this.cao, this.can);
            this.cao.set(this.cam + i3, i2, i3 + this.cam + this.cal, i4);
            canvas.drawOval(this.cao, this.can);
        }
    }

    private void y(Canvas canvas) {
        if (!aq.isEmpty(this.cab) && this.Mp != null) {
            this.bYv.getTextBounds(this.cab, 0, this.cab.length(), this.cad);
            Paint.FontMetrics fontMetrics = this.bYv.getFontMetrics();
            int intrinsicWidth = (this.Mp.getIntrinsicWidth() / 2) + this.caj;
            canvas.drawText(this.cab, intrinsicWidth, (getResources().getDimension(R.dimen.tbds10) + fontMetrics.bottom) - fontMetrics.ascent, this.bYv);
        }
    }

    private void initView() {
        setLayerType(1, null);
        akG();
        this.bYv = new Paint(1);
        this.bYv.setColor(am.getColor(R.color.cp_cont_a));
        this.bYv.setTextSize(com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbfontsize26));
        this.bYv.setTextAlign(Paint.Align.CENTER);
        this.bYv.setTypeface(Typeface.MONOSPACE);
        this.cad = new Rect();
        this.cae = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds13);
        this.caf = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds42);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setStyle(Paint.Style.FILL);
        this.mShadowPaint.setColor(am.getColor(R.color.transparent));
        this.cag = 0;
        this.mShadowRadius = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds8);
        this.cah = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds3);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.cag, this.cah, am.getColor(R.color.cp_cont_h_alpha66));
        this.cai = new RectF();
        this.cak = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds21);
        this.cal = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds8);
        this.cam = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds6);
        this.can = new Paint();
        this.can.setAntiAlias(true);
        this.can.setStyle(Paint.Style.FILL);
        this.can.setColor(am.getColor(R.color.cp_cont_a));
        this.cao = new RectF();
    }

    private void akG() {
        String str = Build.MODEL;
        if (str.contains("vivo") && str.contains("X20")) {
            this.cac = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds2);
        }
    }

    @Deprecated
    public void refresh(int i) {
        int i2;
        if (i <= 0) {
            i2 = R.drawable.icon_news_red_dot;
            this.cab = null;
        } else if (i < 10) {
            this.cab = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_one_number;
        } else if (i < 100) {
            this.cab = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_two_number;
        } else if (this.mType == 1) {
            this.cab = "...";
            i2 = R.drawable.icon_news_red_dot_three_dot_number;
        } else if (this.mType == 2) {
            this.cab = "99+";
            i2 = R.drawable.icon_news_red_dot_three_number;
        } else {
            i2 = 0;
        }
        if (i2 != this.bZZ) {
            this.caa = true;
        } else {
            this.caa = false;
        }
        this.bZZ = i2;
        onChangeSkinType();
    }

    public void Q(String str, boolean z) {
        int i;
        if (z) {
            this.cab = "...";
            i = R.drawable.icon_news_red_dot_three_dot_number;
        } else if (aq.isEmpty(str)) {
            i = R.drawable.icon_news_red_dot;
            this.cab = null;
        } else {
            int measureText = (int) this.bYv.measureText(str);
            if (this.Mp == null || this.Mp.getIntrinsicWidth() - (this.cae * 2) != measureText) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setCornerRadius(this.cak);
                gradientDrawable.setColor(am.getColor(R.color.cp_cont_h));
                gradientDrawable.setSize(((int) this.bYv.measureText(str)) + (this.cae * 2), this.caf);
                this.Mp = gradientDrawable;
                this.caa = true;
            } else if (this.cap != TbadkApplication.getInst().getSkinType() && (this.Mp instanceof GradientDrawable)) {
                ((GradientDrawable) this.Mp).setColor(am.getColor(R.color.cp_cont_h));
                this.caa = false;
            }
            this.cab = str;
            this.bZZ = 0;
            onChangeSkinType();
            return;
        }
        if (i != this.bZZ) {
            this.caa = true;
        } else {
            this.caa = false;
        }
        this.bZZ = i;
        onChangeSkinType();
    }

    public void setThreeDotMode(int i) {
        this.mType = i;
    }

    public void onChangeSkinType() {
        this.cap = TbadkApplication.getInst().getSkinType();
        if (this.bZZ > 0) {
            this.Mp = am.getDrawable(this.bZZ);
        } else if (this.Mp instanceof GradientDrawable) {
            ((GradientDrawable) this.Mp).setColor(am.getColor(R.color.cp_cont_h));
        }
        this.can.setColor(am.getColor(R.color.cp_cont_a));
        if (this.bYv != null) {
            this.bYv.setColor(am.getColor(R.color.cp_cont_a));
        }
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.cag, this.cah, am.getColor(R.color.cp_cont_h_alpha66));
        if (this.caa) {
            this.caa = false;
            requestLayout();
        }
        invalidate();
    }
}
