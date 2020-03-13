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
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class MessageRedDotView extends View {
    private int ayb;
    private int dfD;
    private boolean dfE;
    private String dfF;
    private int dfG;
    private Rect dfH;
    private int dfI;
    private int dfJ;
    private int dfK;
    private RectF dfL;
    private int dfM;
    private int dfN;
    private int dfO;
    private int dfP;
    private Paint dfQ;
    private RectF dfR;
    private boolean dfS;
    private int dfT;
    private Drawable mBackgroundDrawable;
    private Paint mShadowPaint;
    private int mShadowRadius;
    private Paint mTextPaint;
    private int mType;

    public MessageRedDotView(@NonNull Context context) {
        super(context);
        this.mType = 1;
        this.dfS = false;
        this.dfT = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 1;
        this.dfS = false;
        this.dfT = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 1;
        this.dfS = false;
        this.dfT = 3;
        initView();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mBackgroundDrawable != null) {
            this.dfM = this.dfJ >= this.dfK ? this.mShadowRadius + this.dfJ : this.mShadowRadius + this.dfK;
            setMeasuredDimension(this.mBackgroundDrawable.getIntrinsicWidth() + (this.dfM * 2), this.mBackgroundDrawable.getIntrinsicHeight() + (this.dfM * 2));
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
            if (this.dfS) {
                this.mBackgroundDrawable.setBounds(0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds4) + intrinsicWidth, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds4) + intrinsicHeight);
            } else {
                this.mBackgroundDrawable.setBounds(this.dfM, this.dfM, this.dfM + intrinsicWidth, this.dfM + intrinsicHeight);
            }
            this.mBackgroundDrawable.draw(canvas);
            if (!this.dfS) {
                this.dfL.set(this.dfM, this.dfM, this.dfM + intrinsicWidth, this.dfM + intrinsicHeight);
                if (intrinsicWidth != intrinsicHeight) {
                    canvas.drawRoundRect(this.dfL, this.dfN, this.dfN, this.mShadowPaint);
                } else {
                    canvas.drawOval(this.dfL, this.mShadowPaint);
                }
            }
            if (!aq.isEmpty(this.dfF)) {
                if (this.dfF.equals(StringHelper.STRING_MORE)) {
                    x(canvas);
                } else {
                    y(canvas);
                }
            }
        }
    }

    private void x(Canvas canvas) {
        if (this.mBackgroundDrawable != null) {
            int intrinsicWidth = this.dfM + (this.mBackgroundDrawable.getIntrinsicWidth() / 2);
            int intrinsicHeight = (this.mBackgroundDrawable.getIntrinsicHeight() / 2) + this.dfM;
            if (this.dfS) {
                Rect bounds = this.mBackgroundDrawable.getBounds();
                intrinsicWidth = bounds.width() / 2;
                intrinsicHeight = bounds.height() / 2;
            }
            int i = intrinsicWidth - (this.dfO / 2);
            int i2 = intrinsicHeight - (this.dfO / 2);
            int i3 = intrinsicWidth + (this.dfO / 2);
            int i4 = intrinsicHeight + (this.dfO / 2);
            this.dfR.set(i, i2, i3, i4);
            canvas.drawOval(this.dfR, this.dfQ);
            this.dfR.set((i - this.dfP) - this.dfO, i2, i - this.dfP, i4);
            canvas.drawOval(this.dfR, this.dfQ);
            this.dfR.set(this.dfP + i3, i2, i3 + this.dfP + this.dfO, i4);
            canvas.drawOval(this.dfR, this.dfQ);
        }
    }

    private void y(Canvas canvas) {
        if (!aq.isEmpty(this.dfF) && this.mBackgroundDrawable != null) {
            this.mTextPaint.getTextBounds(this.dfF, 0, this.dfF.length(), this.dfH);
            Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
            int intrinsicWidth = this.dfM + (this.mBackgroundDrawable.getIntrinsicWidth() / 2);
            float dimension = (getResources().getDimension(R.dimen.tbds10) + fontMetrics.bottom) - fontMetrics.ascent;
            if (this.dfS) {
                Rect bounds = this.mBackgroundDrawable.getBounds();
                intrinsicWidth = bounds.width() / 2;
                dimension = (bounds.height() / 2) - (fontMetrics.descent - ((fontMetrics.descent + (-fontMetrics.ascent)) / 2.0f));
            }
            canvas.drawText(this.dfF, intrinsicWidth, dimension, this.mTextPaint);
        }
    }

    private void initView() {
        setLayerType(1, null);
        aHA();
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setColor(am.getColor(R.color.cp_cont_a));
        if (this.dfS) {
            this.mTextPaint.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize28));
            this.mTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
        } else {
            this.mTextPaint.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize26));
            this.mTextPaint.setTypeface(Typeface.MONOSPACE);
        }
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.dfH = new Rect();
        this.ayb = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds13);
        this.dfI = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setStyle(Paint.Style.FILL);
        this.mShadowPaint.setColor(am.getColor(R.color.transparent));
        this.dfJ = 0;
        this.mShadowRadius = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.dfK = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds3);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.dfJ, this.dfK, am.getColor(R.color.cp_cont_h_alpha66));
        this.dfL = new RectF();
        this.dfN = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds21);
        this.dfO = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.dfP = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6);
        this.dfQ = new Paint();
        this.dfQ.setAntiAlias(true);
        this.dfQ.setStyle(Paint.Style.FILL);
        this.dfQ.setColor(am.getColor(R.color.cp_cont_a));
        this.dfR = new RectF();
    }

    private void aHA() {
        String str = Build.MODEL;
        if (str.contains("vivo") && str.contains("X20")) {
            this.dfG = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds2);
        }
    }

    @Deprecated
    public void refresh(int i) {
        int i2;
        if (i <= 0) {
            i2 = R.drawable.icon_news_red_dot;
            this.dfF = null;
        } else if (i < 10) {
            this.dfF = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_one_number;
        } else if (i < 100) {
            this.dfF = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_two_number;
        } else if (this.mType == 1) {
            this.dfF = StringHelper.STRING_MORE;
            i2 = R.drawable.icon_news_red_dot_three_dot_number;
        } else if (this.mType == 2) {
            this.dfF = "99+";
            i2 = R.drawable.icon_news_red_dot_three_number;
        } else {
            i2 = 0;
        }
        if (i2 != this.dfD) {
            this.dfE = true;
        } else {
            this.dfE = false;
        }
        this.dfD = i2;
        onChangeSkinType();
    }

    public void setThreeDotMode(int i) {
        this.mType = i;
    }

    public void setEnterForumStyle(boolean z) {
        this.dfS = z;
    }

    public void onChangeSkinType() {
        this.dfT = TbadkApplication.getInst().getSkinType();
        if (this.dfD > 0) {
            this.mBackgroundDrawable = am.getDrawable(this.dfD);
        } else if (this.mBackgroundDrawable instanceof GradientDrawable) {
            ((GradientDrawable) this.mBackgroundDrawable).setColor(am.getColor(R.color.cp_cont_h));
        }
        this.dfQ.setColor(am.getColor(R.color.cp_cont_a));
        if (this.mTextPaint != null) {
            this.mTextPaint.setColor(am.getColor(R.color.cp_cont_a));
        }
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.dfJ, this.dfK, am.getColor(R.color.cp_cont_h_alpha66));
        if (this.dfE) {
            this.dfE = false;
            requestLayout();
        }
        invalidate();
    }
}
