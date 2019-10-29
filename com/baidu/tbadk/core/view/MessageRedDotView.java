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
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class MessageRedDotView extends View {
    private Paint ajo;
    private int alm;
    private int coE;
    private boolean coF;
    private String coG;
    private int coH;
    private Rect coI;
    private int coJ;
    private int coK;
    private int coL;
    private RectF coM;
    private int coN;
    private int coO;
    private int coP;
    private int coQ;
    private Paint coR;
    private RectF coS;
    private int coT;
    private Drawable mBackgroundDrawable;
    private Paint mShadowPaint;
    private int mShadowRadius;
    private int mType;

    public MessageRedDotView(@NonNull Context context) {
        super(context);
        this.mType = 1;
        this.coT = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 1;
        this.coT = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 1;
        this.coT = 3;
        initView();
    }

    @RequiresApi(api = 21)
    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mType = 1;
        this.coT = 3;
        initView();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mBackgroundDrawable != null) {
            this.coN = this.coK >= this.coL ? this.mShadowRadius + this.coK : this.mShadowRadius + this.coL;
            setMeasuredDimension(this.mBackgroundDrawable.getIntrinsicWidth() + (this.coN * 2), this.mBackgroundDrawable.getIntrinsicHeight() + (this.coN * 2));
            return;
        }
        setMeasuredDimension(0, 0);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mBackgroundDrawable != null) {
            int intrinsicWidth = this.mBackgroundDrawable.getIntrinsicWidth();
            int intrinsicHeight = this.mBackgroundDrawable.getIntrinsicHeight();
            this.mBackgroundDrawable.setBounds(this.coN, this.coN, this.coN + intrinsicWidth, this.coN + intrinsicHeight);
            this.mBackgroundDrawable.draw(canvas);
            this.coM.set(this.coN, this.coN, this.coN + intrinsicWidth, this.coN + intrinsicHeight);
            if (intrinsicWidth != intrinsicHeight) {
                canvas.drawRoundRect(this.coM, this.coO, this.coO, this.mShadowPaint);
            } else {
                canvas.drawOval(this.coM, this.mShadowPaint);
            }
            if (!aq.isEmpty(this.coG)) {
                if (this.coG.equals(StringHelper.STRING_MORE)) {
                    A(canvas);
                } else {
                    B(canvas);
                }
            }
        }
    }

    private void A(Canvas canvas) {
        if (this.mBackgroundDrawable != null) {
            int intrinsicWidth = (this.mBackgroundDrawable.getIntrinsicWidth() / 2) + this.coN;
            int intrinsicHeight = (this.mBackgroundDrawable.getIntrinsicHeight() / 2) + this.coN;
            int i = intrinsicWidth - (this.coP / 2);
            int i2 = intrinsicHeight - (this.coP / 2);
            int i3 = intrinsicWidth + (this.coP / 2);
            int i4 = intrinsicHeight + (this.coP / 2);
            this.coS.set(i, i2, i3, i4);
            canvas.drawOval(this.coS, this.coR);
            this.coS.set((i - this.coQ) - this.coP, i2, i - this.coQ, i4);
            canvas.drawOval(this.coS, this.coR);
            this.coS.set(this.coQ + i3, i2, i3 + this.coQ + this.coP, i4);
            canvas.drawOval(this.coS, this.coR);
        }
    }

    private void B(Canvas canvas) {
        if (!aq.isEmpty(this.coG) && this.mBackgroundDrawable != null) {
            this.ajo.getTextBounds(this.coG, 0, this.coG.length(), this.coI);
            Paint.FontMetrics fontMetrics = this.ajo.getFontMetrics();
            int intrinsicWidth = (this.mBackgroundDrawable.getIntrinsicWidth() / 2) + this.coN;
            canvas.drawText(this.coG, intrinsicWidth, (getResources().getDimension(R.dimen.tbds10) + fontMetrics.bottom) - fontMetrics.ascent, this.ajo);
        }
    }

    private void initView() {
        setLayerType(1, null);
        anE();
        this.ajo = new Paint(1);
        this.ajo.setColor(am.getColor(R.color.cp_cont_a));
        this.ajo.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize26));
        this.ajo.setTextAlign(Paint.Align.CENTER);
        this.ajo.setTypeface(Typeface.MONOSPACE);
        this.coI = new Rect();
        this.alm = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds13);
        this.coJ = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setStyle(Paint.Style.FILL);
        this.mShadowPaint.setColor(am.getColor(R.color.transparent));
        this.coK = 0;
        this.mShadowRadius = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.coL = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds3);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.coK, this.coL, am.getColor(R.color.cp_cont_h_alpha66));
        this.coM = new RectF();
        this.coO = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds21);
        this.coP = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.coQ = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6);
        this.coR = new Paint();
        this.coR.setAntiAlias(true);
        this.coR.setStyle(Paint.Style.FILL);
        this.coR.setColor(am.getColor(R.color.cp_cont_a));
        this.coS = new RectF();
    }

    private void anE() {
        String str = Build.MODEL;
        if (str.contains("vivo") && str.contains("X20")) {
            this.coH = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds2);
        }
    }

    @Deprecated
    public void refresh(int i) {
        int i2;
        if (i <= 0) {
            i2 = R.drawable.icon_news_red_dot;
            this.coG = null;
        } else if (i < 10) {
            this.coG = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_one_number;
        } else if (i < 100) {
            this.coG = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_two_number;
        } else if (this.mType == 1) {
            this.coG = StringHelper.STRING_MORE;
            i2 = R.drawable.icon_news_red_dot_three_dot_number;
        } else if (this.mType == 2) {
            this.coG = "99+";
            i2 = R.drawable.icon_news_red_dot_three_number;
        } else {
            i2 = 0;
        }
        if (i2 != this.coE) {
            this.coF = true;
        } else {
            this.coF = false;
        }
        this.coE = i2;
        onChangeSkinType();
    }

    public void setThreeDotMode(int i) {
        this.mType = i;
    }

    public void onChangeSkinType() {
        this.coT = TbadkApplication.getInst().getSkinType();
        if (this.coE > 0) {
            this.mBackgroundDrawable = am.getDrawable(this.coE);
        } else if (this.mBackgroundDrawable instanceof GradientDrawable) {
            ((GradientDrawable) this.mBackgroundDrawable).setColor(am.getColor(R.color.cp_cont_h));
        }
        this.coR.setColor(am.getColor(R.color.cp_cont_a));
        if (this.ajo != null) {
            this.ajo.setColor(am.getColor(R.color.cp_cont_a));
        }
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.coK, this.coL, am.getColor(R.color.cp_cont_h_alpha66));
        if (this.coF) {
            this.coF = false;
            requestLayout();
        }
        invalidate();
    }
}
