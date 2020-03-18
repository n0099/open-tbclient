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
    private int ayp;
    private int dfQ;
    private boolean dfR;
    private String dfS;
    private int dfT;
    private Rect dfU;
    private int dfV;
    private int dfW;
    private int dfX;
    private RectF dfY;
    private int dfZ;
    private int dga;
    private int dgb;
    private int dgc;
    private Paint dgd;
    private RectF dge;
    private boolean dgf;
    private int dgg;
    private Drawable mBackgroundDrawable;
    private Paint mShadowPaint;
    private int mShadowRadius;
    private Paint mTextPaint;
    private int mType;

    public MessageRedDotView(@NonNull Context context) {
        super(context);
        this.mType = 1;
        this.dgf = false;
        this.dgg = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 1;
        this.dgf = false;
        this.dgg = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 1;
        this.dgf = false;
        this.dgg = 3;
        initView();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mBackgroundDrawable != null) {
            this.dfZ = this.dfW >= this.dfX ? this.mShadowRadius + this.dfW : this.mShadowRadius + this.dfX;
            setMeasuredDimension(this.mBackgroundDrawable.getIntrinsicWidth() + (this.dfZ * 2), this.mBackgroundDrawable.getIntrinsicHeight() + (this.dfZ * 2));
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
            if (this.dgf) {
                this.mBackgroundDrawable.setBounds(0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds4) + intrinsicWidth, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds4) + intrinsicHeight);
            } else {
                this.mBackgroundDrawable.setBounds(this.dfZ, this.dfZ, this.dfZ + intrinsicWidth, this.dfZ + intrinsicHeight);
            }
            this.mBackgroundDrawable.draw(canvas);
            if (!this.dgf) {
                this.dfY.set(this.dfZ, this.dfZ, this.dfZ + intrinsicWidth, this.dfZ + intrinsicHeight);
                if (intrinsicWidth != intrinsicHeight) {
                    canvas.drawRoundRect(this.dfY, this.dga, this.dga, this.mShadowPaint);
                } else {
                    canvas.drawOval(this.dfY, this.mShadowPaint);
                }
            }
            if (!aq.isEmpty(this.dfS)) {
                if (this.dfS.equals(StringHelper.STRING_MORE)) {
                    x(canvas);
                } else {
                    y(canvas);
                }
            }
        }
    }

    private void x(Canvas canvas) {
        if (this.mBackgroundDrawable != null) {
            int intrinsicWidth = this.dfZ + (this.mBackgroundDrawable.getIntrinsicWidth() / 2);
            int intrinsicHeight = (this.mBackgroundDrawable.getIntrinsicHeight() / 2) + this.dfZ;
            if (this.dgf) {
                Rect bounds = this.mBackgroundDrawable.getBounds();
                intrinsicWidth = bounds.width() / 2;
                intrinsicHeight = bounds.height() / 2;
            }
            int i = intrinsicWidth - (this.dgb / 2);
            int i2 = intrinsicHeight - (this.dgb / 2);
            int i3 = intrinsicWidth + (this.dgb / 2);
            int i4 = intrinsicHeight + (this.dgb / 2);
            this.dge.set(i, i2, i3, i4);
            canvas.drawOval(this.dge, this.dgd);
            this.dge.set((i - this.dgc) - this.dgb, i2, i - this.dgc, i4);
            canvas.drawOval(this.dge, this.dgd);
            this.dge.set(this.dgc + i3, i2, i3 + this.dgc + this.dgb, i4);
            canvas.drawOval(this.dge, this.dgd);
        }
    }

    private void y(Canvas canvas) {
        if (!aq.isEmpty(this.dfS) && this.mBackgroundDrawable != null) {
            this.mTextPaint.getTextBounds(this.dfS, 0, this.dfS.length(), this.dfU);
            Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
            int intrinsicWidth = this.dfZ + (this.mBackgroundDrawable.getIntrinsicWidth() / 2);
            float dimension = (getResources().getDimension(R.dimen.tbds10) + fontMetrics.bottom) - fontMetrics.ascent;
            if (this.dgf) {
                Rect bounds = this.mBackgroundDrawable.getBounds();
                intrinsicWidth = bounds.width() / 2;
                dimension = (bounds.height() / 2) - (fontMetrics.descent - ((fontMetrics.descent + (-fontMetrics.ascent)) / 2.0f));
            }
            canvas.drawText(this.dfS, intrinsicWidth, dimension, this.mTextPaint);
        }
    }

    private void initView() {
        setLayerType(1, null);
        aHE();
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setColor(am.getColor(R.color.cp_cont_a));
        if (this.dgf) {
            this.mTextPaint.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize28));
            this.mTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
        } else {
            this.mTextPaint.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize26));
            this.mTextPaint.setTypeface(Typeface.MONOSPACE);
        }
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.dfU = new Rect();
        this.ayp = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds13);
        this.dfV = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setStyle(Paint.Style.FILL);
        this.mShadowPaint.setColor(am.getColor(R.color.transparent));
        this.dfW = 0;
        this.mShadowRadius = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.dfX = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds3);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.dfW, this.dfX, am.getColor(R.color.cp_cont_h_alpha66));
        this.dfY = new RectF();
        this.dga = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds21);
        this.dgb = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.dgc = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6);
        this.dgd = new Paint();
        this.dgd.setAntiAlias(true);
        this.dgd.setStyle(Paint.Style.FILL);
        this.dgd.setColor(am.getColor(R.color.cp_cont_a));
        this.dge = new RectF();
    }

    private void aHE() {
        String str = Build.MODEL;
        if (str.contains("vivo") && str.contains("X20")) {
            this.dfT = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds2);
        }
    }

    @Deprecated
    public void refresh(int i) {
        int i2;
        if (i <= 0) {
            i2 = R.drawable.icon_news_red_dot;
            this.dfS = null;
        } else if (i < 10) {
            this.dfS = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_one_number;
        } else if (i < 100) {
            this.dfS = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_two_number;
        } else if (this.mType == 1) {
            this.dfS = StringHelper.STRING_MORE;
            i2 = R.drawable.icon_news_red_dot_three_dot_number;
        } else if (this.mType == 2) {
            this.dfS = "99+";
            i2 = R.drawable.icon_news_red_dot_three_number;
        } else {
            i2 = 0;
        }
        if (i2 != this.dfQ) {
            this.dfR = true;
        } else {
            this.dfR = false;
        }
        this.dfQ = i2;
        onChangeSkinType();
    }

    public void setThreeDotMode(int i) {
        this.mType = i;
    }

    public void setEnterForumStyle(boolean z) {
        this.dgf = z;
    }

    public void onChangeSkinType() {
        this.dgg = TbadkApplication.getInst().getSkinType();
        if (this.dfQ > 0) {
            this.mBackgroundDrawable = am.getDrawable(this.dfQ);
        } else if (this.mBackgroundDrawable instanceof GradientDrawable) {
            ((GradientDrawable) this.mBackgroundDrawable).setColor(am.getColor(R.color.cp_cont_h));
        }
        this.dgd.setColor(am.getColor(R.color.cp_cont_a));
        if (this.mTextPaint != null) {
            this.mTextPaint.setColor(am.getColor(R.color.cp_cont_a));
        }
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.dfW, this.dfX, am.getColor(R.color.cp_cont_h_alpha66));
        if (this.dfR) {
            this.dfR = false;
            requestLayout();
        }
        invalidate();
    }
}
