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
    private int aya;
    private int dfA;
    private int dfB;
    private int dfC;
    private Paint dfD;
    private RectF dfE;
    private boolean dfF;
    private int dfG;
    private int dfq;
    private boolean dfr;
    private String dfs;
    private int dft;
    private Rect dfu;
    private int dfv;
    private int dfw;
    private int dfx;
    private RectF dfy;
    private int dfz;
    private Drawable mBackgroundDrawable;
    private Paint mShadowPaint;
    private int mShadowRadius;
    private Paint mTextPaint;
    private int mType;

    public MessageRedDotView(@NonNull Context context) {
        super(context);
        this.mType = 1;
        this.dfF = false;
        this.dfG = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 1;
        this.dfF = false;
        this.dfG = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 1;
        this.dfF = false;
        this.dfG = 3;
        initView();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mBackgroundDrawable != null) {
            this.dfz = this.dfw >= this.dfx ? this.mShadowRadius + this.dfw : this.mShadowRadius + this.dfx;
            setMeasuredDimension(this.mBackgroundDrawable.getIntrinsicWidth() + (this.dfz * 2), this.mBackgroundDrawable.getIntrinsicHeight() + (this.dfz * 2));
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
            if (this.dfF) {
                this.mBackgroundDrawable.setBounds(0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds4) + intrinsicWidth, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds4) + intrinsicHeight);
            } else {
                this.mBackgroundDrawable.setBounds(this.dfz, this.dfz, this.dfz + intrinsicWidth, this.dfz + intrinsicHeight);
            }
            this.mBackgroundDrawable.draw(canvas);
            if (!this.dfF) {
                this.dfy.set(this.dfz, this.dfz, this.dfz + intrinsicWidth, this.dfz + intrinsicHeight);
                if (intrinsicWidth != intrinsicHeight) {
                    canvas.drawRoundRect(this.dfy, this.dfA, this.dfA, this.mShadowPaint);
                } else {
                    canvas.drawOval(this.dfy, this.mShadowPaint);
                }
            }
            if (!aq.isEmpty(this.dfs)) {
                if (this.dfs.equals(StringHelper.STRING_MORE)) {
                    x(canvas);
                } else {
                    y(canvas);
                }
            }
        }
    }

    private void x(Canvas canvas) {
        if (this.mBackgroundDrawable != null) {
            int intrinsicWidth = this.dfz + (this.mBackgroundDrawable.getIntrinsicWidth() / 2);
            int intrinsicHeight = (this.mBackgroundDrawable.getIntrinsicHeight() / 2) + this.dfz;
            if (this.dfF) {
                Rect bounds = this.mBackgroundDrawable.getBounds();
                intrinsicWidth = bounds.width() / 2;
                intrinsicHeight = bounds.height() / 2;
            }
            int i = intrinsicWidth - (this.dfB / 2);
            int i2 = intrinsicHeight - (this.dfB / 2);
            int i3 = intrinsicWidth + (this.dfB / 2);
            int i4 = intrinsicHeight + (this.dfB / 2);
            this.dfE.set(i, i2, i3, i4);
            canvas.drawOval(this.dfE, this.dfD);
            this.dfE.set((i - this.dfC) - this.dfB, i2, i - this.dfC, i4);
            canvas.drawOval(this.dfE, this.dfD);
            this.dfE.set(this.dfC + i3, i2, i3 + this.dfC + this.dfB, i4);
            canvas.drawOval(this.dfE, this.dfD);
        }
    }

    private void y(Canvas canvas) {
        if (!aq.isEmpty(this.dfs) && this.mBackgroundDrawable != null) {
            this.mTextPaint.getTextBounds(this.dfs, 0, this.dfs.length(), this.dfu);
            Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
            int intrinsicWidth = this.dfz + (this.mBackgroundDrawable.getIntrinsicWidth() / 2);
            float dimension = (getResources().getDimension(R.dimen.tbds10) + fontMetrics.bottom) - fontMetrics.ascent;
            if (this.dfF) {
                Rect bounds = this.mBackgroundDrawable.getBounds();
                intrinsicWidth = bounds.width() / 2;
                dimension = (bounds.height() / 2) - (fontMetrics.descent - ((fontMetrics.descent + (-fontMetrics.ascent)) / 2.0f));
            }
            canvas.drawText(this.dfs, intrinsicWidth, dimension, this.mTextPaint);
        }
    }

    private void initView() {
        setLayerType(1, null);
        aHz();
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setColor(am.getColor(R.color.cp_cont_a));
        if (this.dfF) {
            this.mTextPaint.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize28));
            this.mTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
        } else {
            this.mTextPaint.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize26));
            this.mTextPaint.setTypeface(Typeface.MONOSPACE);
        }
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.dfu = new Rect();
        this.aya = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds13);
        this.dfv = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setStyle(Paint.Style.FILL);
        this.mShadowPaint.setColor(am.getColor(R.color.transparent));
        this.dfw = 0;
        this.mShadowRadius = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.dfx = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds3);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.dfw, this.dfx, am.getColor(R.color.cp_cont_h_alpha66));
        this.dfy = new RectF();
        this.dfA = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds21);
        this.dfB = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.dfC = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6);
        this.dfD = new Paint();
        this.dfD.setAntiAlias(true);
        this.dfD.setStyle(Paint.Style.FILL);
        this.dfD.setColor(am.getColor(R.color.cp_cont_a));
        this.dfE = new RectF();
    }

    private void aHz() {
        String str = Build.MODEL;
        if (str.contains("vivo") && str.contains("X20")) {
            this.dft = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds2);
        }
    }

    @Deprecated
    public void refresh(int i) {
        int i2;
        if (i <= 0) {
            i2 = R.drawable.icon_news_red_dot;
            this.dfs = null;
        } else if (i < 10) {
            this.dfs = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_one_number;
        } else if (i < 100) {
            this.dfs = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_two_number;
        } else if (this.mType == 1) {
            this.dfs = StringHelper.STRING_MORE;
            i2 = R.drawable.icon_news_red_dot_three_dot_number;
        } else if (this.mType == 2) {
            this.dfs = "99+";
            i2 = R.drawable.icon_news_red_dot_three_number;
        } else {
            i2 = 0;
        }
        if (i2 != this.dfq) {
            this.dfr = true;
        } else {
            this.dfr = false;
        }
        this.dfq = i2;
        onChangeSkinType();
    }

    public void setThreeDotMode(int i) {
        this.mType = i;
    }

    public void setEnterForumStyle(boolean z) {
        this.dfF = z;
    }

    public void onChangeSkinType() {
        this.dfG = TbadkApplication.getInst().getSkinType();
        if (this.dfq > 0) {
            this.mBackgroundDrawable = am.getDrawable(this.dfq);
        } else if (this.mBackgroundDrawable instanceof GradientDrawable) {
            ((GradientDrawable) this.mBackgroundDrawable).setColor(am.getColor(R.color.cp_cont_h));
        }
        this.dfD.setColor(am.getColor(R.color.cp_cont_a));
        if (this.mTextPaint != null) {
            this.mTextPaint.setColor(am.getColor(R.color.cp_cont_a));
        }
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.dfw, this.dfx, am.getColor(R.color.cp_cont_h_alpha66));
        if (this.dfr) {
            this.dfr = false;
            requestLayout();
        }
        invalidate();
    }
}
