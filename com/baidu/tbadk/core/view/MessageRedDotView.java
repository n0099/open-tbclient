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
    private int axZ;
    private int dfA;
    private int dfB;
    private Paint dfC;
    private RectF dfD;
    private boolean dfE;
    private int dfF;
    private int dfp;
    private boolean dfq;
    private String dfr;
    private int dfs;
    private Rect dft;
    private int dfu;
    private int dfv;
    private int dfw;
    private RectF dfx;
    private int dfy;
    private int dfz;
    private Drawable mBackgroundDrawable;
    private Paint mShadowPaint;
    private int mShadowRadius;
    private Paint mTextPaint;
    private int mType;

    public MessageRedDotView(@NonNull Context context) {
        super(context);
        this.mType = 1;
        this.dfE = false;
        this.dfF = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 1;
        this.dfE = false;
        this.dfF = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 1;
        this.dfE = false;
        this.dfF = 3;
        initView();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mBackgroundDrawable != null) {
            this.dfy = this.dfv >= this.dfw ? this.mShadowRadius + this.dfv : this.mShadowRadius + this.dfw;
            setMeasuredDimension(this.mBackgroundDrawable.getIntrinsicWidth() + (this.dfy * 2), this.mBackgroundDrawable.getIntrinsicHeight() + (this.dfy * 2));
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
            if (this.dfE) {
                this.mBackgroundDrawable.setBounds(0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds4) + intrinsicWidth, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds4) + intrinsicHeight);
            } else {
                this.mBackgroundDrawable.setBounds(this.dfy, this.dfy, this.dfy + intrinsicWidth, this.dfy + intrinsicHeight);
            }
            this.mBackgroundDrawable.draw(canvas);
            if (!this.dfE) {
                this.dfx.set(this.dfy, this.dfy, this.dfy + intrinsicWidth, this.dfy + intrinsicHeight);
                if (intrinsicWidth != intrinsicHeight) {
                    canvas.drawRoundRect(this.dfx, this.dfz, this.dfz, this.mShadowPaint);
                } else {
                    canvas.drawOval(this.dfx, this.mShadowPaint);
                }
            }
            if (!aq.isEmpty(this.dfr)) {
                if (this.dfr.equals(StringHelper.STRING_MORE)) {
                    x(canvas);
                } else {
                    y(canvas);
                }
            }
        }
    }

    private void x(Canvas canvas) {
        if (this.mBackgroundDrawable != null) {
            int intrinsicWidth = this.dfy + (this.mBackgroundDrawable.getIntrinsicWidth() / 2);
            int intrinsicHeight = (this.mBackgroundDrawable.getIntrinsicHeight() / 2) + this.dfy;
            if (this.dfE) {
                Rect bounds = this.mBackgroundDrawable.getBounds();
                intrinsicWidth = bounds.width() / 2;
                intrinsicHeight = bounds.height() / 2;
            }
            int i = intrinsicWidth - (this.dfA / 2);
            int i2 = intrinsicHeight - (this.dfA / 2);
            int i3 = intrinsicWidth + (this.dfA / 2);
            int i4 = intrinsicHeight + (this.dfA / 2);
            this.dfD.set(i, i2, i3, i4);
            canvas.drawOval(this.dfD, this.dfC);
            this.dfD.set((i - this.dfB) - this.dfA, i2, i - this.dfB, i4);
            canvas.drawOval(this.dfD, this.dfC);
            this.dfD.set(this.dfB + i3, i2, i3 + this.dfB + this.dfA, i4);
            canvas.drawOval(this.dfD, this.dfC);
        }
    }

    private void y(Canvas canvas) {
        if (!aq.isEmpty(this.dfr) && this.mBackgroundDrawable != null) {
            this.mTextPaint.getTextBounds(this.dfr, 0, this.dfr.length(), this.dft);
            Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
            int intrinsicWidth = this.dfy + (this.mBackgroundDrawable.getIntrinsicWidth() / 2);
            float dimension = (getResources().getDimension(R.dimen.tbds10) + fontMetrics.bottom) - fontMetrics.ascent;
            if (this.dfE) {
                Rect bounds = this.mBackgroundDrawable.getBounds();
                intrinsicWidth = bounds.width() / 2;
                dimension = (bounds.height() / 2) - (fontMetrics.descent - ((fontMetrics.descent + (-fontMetrics.ascent)) / 2.0f));
            }
            canvas.drawText(this.dfr, intrinsicWidth, dimension, this.mTextPaint);
        }
    }

    private void initView() {
        setLayerType(1, null);
        aHx();
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setColor(am.getColor(R.color.cp_cont_a));
        if (this.dfE) {
            this.mTextPaint.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize28));
            this.mTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
        } else {
            this.mTextPaint.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize26));
            this.mTextPaint.setTypeface(Typeface.MONOSPACE);
        }
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.dft = new Rect();
        this.axZ = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds13);
        this.dfu = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setStyle(Paint.Style.FILL);
        this.mShadowPaint.setColor(am.getColor(R.color.transparent));
        this.dfv = 0;
        this.mShadowRadius = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.dfw = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds3);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.dfv, this.dfw, am.getColor(R.color.cp_cont_h_alpha66));
        this.dfx = new RectF();
        this.dfz = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds21);
        this.dfA = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.dfB = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6);
        this.dfC = new Paint();
        this.dfC.setAntiAlias(true);
        this.dfC.setStyle(Paint.Style.FILL);
        this.dfC.setColor(am.getColor(R.color.cp_cont_a));
        this.dfD = new RectF();
    }

    private void aHx() {
        String str = Build.MODEL;
        if (str.contains("vivo") && str.contains("X20")) {
            this.dfs = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds2);
        }
    }

    @Deprecated
    public void refresh(int i) {
        int i2;
        if (i <= 0) {
            i2 = R.drawable.icon_news_red_dot;
            this.dfr = null;
        } else if (i < 10) {
            this.dfr = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_one_number;
        } else if (i < 100) {
            this.dfr = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_two_number;
        } else if (this.mType == 1) {
            this.dfr = StringHelper.STRING_MORE;
            i2 = R.drawable.icon_news_red_dot_three_dot_number;
        } else if (this.mType == 2) {
            this.dfr = "99+";
            i2 = R.drawable.icon_news_red_dot_three_number;
        } else {
            i2 = 0;
        }
        if (i2 != this.dfp) {
            this.dfq = true;
        } else {
            this.dfq = false;
        }
        this.dfp = i2;
        onChangeSkinType();
    }

    public void setThreeDotMode(int i) {
        this.mType = i;
    }

    public void setEnterForumStyle(boolean z) {
        this.dfE = z;
    }

    public void onChangeSkinType() {
        this.dfF = TbadkApplication.getInst().getSkinType();
        if (this.dfp > 0) {
            this.mBackgroundDrawable = am.getDrawable(this.dfp);
        } else if (this.mBackgroundDrawable instanceof GradientDrawable) {
            ((GradientDrawable) this.mBackgroundDrawable).setColor(am.getColor(R.color.cp_cont_h));
        }
        this.dfC.setColor(am.getColor(R.color.cp_cont_a));
        if (this.mTextPaint != null) {
            this.mTextPaint.setColor(am.getColor(R.color.cp_cont_a));
        }
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.dfv, this.dfw, am.getColor(R.color.cp_cont_h_alpha66));
        if (this.dfq) {
            this.dfq = false;
            requestLayout();
        }
        invalidate();
    }
}
