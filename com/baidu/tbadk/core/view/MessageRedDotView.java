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
import android.util.AttributeSet;
import android.view.View;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class MessageRedDotView extends View {
    private int aZn;
    private int dTD;
    private boolean dTE;
    private String dTF;
    private int dTG;
    private Rect dTH;
    private int dTI;
    private int dTJ;
    private int dTK;
    private RectF dTL;
    private int dTM;
    private int dTN;
    private int dTO;
    private int dTP;
    private Paint dTQ;
    private RectF dTR;
    private boolean dTS;
    private int dTT;
    private Drawable mBackgroundDrawable;
    private Paint mShadowPaint;
    private int mShadowRadius;
    private Paint mTextPaint;
    private int mType;

    public MessageRedDotView(@NonNull Context context) {
        super(context);
        this.mType = 1;
        this.dTS = false;
        this.dTT = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 1;
        this.dTS = false;
        this.dTT = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 1;
        this.dTS = false;
        this.dTT = 3;
        initView();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mBackgroundDrawable != null) {
            this.dTM = this.dTJ >= this.dTK ? this.mShadowRadius + this.dTJ : this.mShadowRadius + this.dTK;
            setMeasuredDimension(this.mBackgroundDrawable.getIntrinsicWidth() + (this.dTM * 2), this.mBackgroundDrawable.getIntrinsicHeight() + (this.dTM * 2));
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
            if (this.dTS) {
                this.mBackgroundDrawable.setBounds(0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds4) + intrinsicWidth, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds4) + intrinsicHeight);
            } else {
                this.mBackgroundDrawable.setBounds(this.dTM, this.dTM, this.dTM + intrinsicWidth, this.dTM + intrinsicHeight);
            }
            this.mBackgroundDrawable.draw(canvas);
            if (!this.dTS) {
                this.dTL.set(this.dTM, this.dTM, this.dTM + intrinsicWidth, this.dTM + intrinsicHeight);
                if (intrinsicWidth != intrinsicHeight) {
                    canvas.drawRoundRect(this.dTL, this.dTN, this.dTN, this.mShadowPaint);
                } else {
                    canvas.drawOval(this.dTL, this.mShadowPaint);
                }
            }
            if (!aq.isEmpty(this.dTF)) {
                if (this.dTF.equals(StringHelper.STRING_MORE)) {
                    y(canvas);
                } else {
                    z(canvas);
                }
            }
        }
    }

    private void y(Canvas canvas) {
        if (this.mBackgroundDrawable != null) {
            int intrinsicWidth = this.dTM + (this.mBackgroundDrawable.getIntrinsicWidth() / 2);
            int intrinsicHeight = (this.mBackgroundDrawable.getIntrinsicHeight() / 2) + this.dTM;
            if (this.dTS) {
                Rect bounds = this.mBackgroundDrawable.getBounds();
                intrinsicWidth = bounds.width() / 2;
                intrinsicHeight = bounds.height() / 2;
            }
            int i = intrinsicWidth - (this.dTO / 2);
            int i2 = intrinsicHeight - (this.dTO / 2);
            int i3 = intrinsicWidth + (this.dTO / 2);
            int i4 = intrinsicHeight + (this.dTO / 2);
            this.dTR.set(i, i2, i3, i4);
            canvas.drawOval(this.dTR, this.dTQ);
            this.dTR.set((i - this.dTP) - this.dTO, i2, i - this.dTP, i4);
            canvas.drawOval(this.dTR, this.dTQ);
            this.dTR.set(this.dTP + i3, i2, i3 + this.dTP + this.dTO, i4);
            canvas.drawOval(this.dTR, this.dTQ);
        }
    }

    private void z(Canvas canvas) {
        if (!aq.isEmpty(this.dTF) && this.mBackgroundDrawable != null) {
            this.mTextPaint.getTextBounds(this.dTF, 0, this.dTF.length(), this.dTH);
            Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
            int intrinsicWidth = this.dTM + (this.mBackgroundDrawable.getIntrinsicWidth() / 2);
            float dimension = (getResources().getDimension(R.dimen.tbds10) + fontMetrics.bottom) - fontMetrics.ascent;
            if (this.dTS) {
                Rect bounds = this.mBackgroundDrawable.getBounds();
                intrinsicWidth = bounds.width() / 2;
                dimension = (bounds.height() / 2) - (fontMetrics.descent - ((fontMetrics.descent + (-fontMetrics.ascent)) / 2.0f));
            }
            canvas.drawText(this.dTF, intrinsicWidth, dimension, this.mTextPaint);
        }
    }

    private void initView() {
        setLayerType(1, null);
        aVX();
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setColor(am.getColor(R.color.cp_cont_a));
        if (this.dTS) {
            this.mTextPaint.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize28));
            this.mTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
        } else {
            this.mTextPaint.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize26));
            this.mTextPaint.setTypeface(Typeface.MONOSPACE);
        }
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.dTH = new Rect();
        this.aZn = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds13);
        this.dTI = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setStyle(Paint.Style.FILL);
        this.mShadowPaint.setColor(am.getColor(R.color.transparent));
        this.dTJ = 0;
        this.mShadowRadius = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.dTK = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds3);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.dTJ, this.dTK, am.getColor(R.color.cp_cont_h_alpha66));
        this.dTL = new RectF();
        this.dTN = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds21);
        this.dTO = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.dTP = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6);
        this.dTQ = new Paint();
        this.dTQ.setAntiAlias(true);
        this.dTQ.setStyle(Paint.Style.FILL);
        this.dTQ.setColor(am.getColor(R.color.cp_cont_a));
        this.dTR = new RectF();
    }

    private void aVX() {
        String str = Build.MODEL;
        if (str.contains(RomUtils.MANUFACTURER_VIVO) && str.contains("X20")) {
            this.dTG = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds2);
        }
    }

    @Deprecated
    public void refresh(int i) {
        int i2;
        if (i <= 0) {
            i2 = R.drawable.icon_news_red_dot;
            this.dTF = null;
        } else if (i < 10) {
            this.dTF = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_one_number;
        } else if (i < 100) {
            this.dTF = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_two_number;
        } else if (this.mType == 1) {
            this.dTF = StringHelper.STRING_MORE;
            i2 = R.drawable.icon_news_red_dot_three_dot_number;
        } else if (this.mType == 2) {
            this.dTF = "99+";
            i2 = R.drawable.icon_news_red_dot_three_number;
        } else {
            i2 = 0;
        }
        if (i2 != this.dTD) {
            this.dTE = true;
        } else {
            this.dTE = false;
        }
        this.dTD = i2;
        onChangeSkinType();
    }

    public void setThreeDotMode(int i) {
        this.mType = i;
    }

    public void setEnterForumStyle(boolean z) {
        this.dTS = z;
    }

    public void onChangeSkinType() {
        this.dTT = TbadkApplication.getInst().getSkinType();
        if (this.dTD > 0) {
            this.mBackgroundDrawable = am.getDrawable(this.dTD);
        } else if (this.mBackgroundDrawable instanceof GradientDrawable) {
            ((GradientDrawable) this.mBackgroundDrawable).setColor(am.getColor(R.color.cp_cont_h));
        }
        this.dTQ.setColor(am.getColor(R.color.cp_cont_a));
        if (this.mTextPaint != null) {
            this.mTextPaint.setColor(am.getColor(R.color.cp_cont_a));
        }
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.dTJ, this.dTK, am.getColor(R.color.cp_cont_h_alpha66));
        if (this.dTE) {
            this.dTE = false;
            requestLayout();
        }
        invalidate();
    }
}
