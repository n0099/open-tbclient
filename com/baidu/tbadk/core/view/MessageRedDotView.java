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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class MessageRedDotView extends View {
    private int bCW;
    private int eZF;
    private boolean eZG;
    private String eZH;
    private int eZI;
    private Rect eZJ;
    private int eZK;
    private int eZL;
    private int eZM;
    private RectF eZN;
    private int eZO;
    private int eZP;
    private int eZQ;
    private int eZR;
    private Paint eZS;
    private RectF eZT;
    private boolean eZU;
    private boolean eZV;
    private int eZW;
    private Drawable mBackgroundDrawable;
    private Paint mShadowPaint;
    private int mShadowRadius;
    private Paint mTextPaint;
    private int mType;

    public MessageRedDotView(@NonNull Context context) {
        super(context);
        this.mType = 1;
        this.eZU = false;
        this.eZV = false;
        this.eZW = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 1;
        this.eZU = false;
        this.eZV = false;
        this.eZW = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 1;
        this.eZU = false;
        this.eZV = false;
        this.eZW = 3;
        initView();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mBackgroundDrawable != null) {
            this.eZO = this.eZL >= this.eZM ? this.mShadowRadius + this.eZL : this.mShadowRadius + this.eZM;
            setMeasuredDimension(this.mBackgroundDrawable.getIntrinsicWidth() + (this.eZO * 2), this.mBackgroundDrawable.getIntrinsicHeight() + (this.eZO * 2));
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
            if (this.eZU) {
                this.mBackgroundDrawable.setBounds(0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds4) + intrinsicWidth, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds4) + intrinsicHeight);
            } else {
                this.mBackgroundDrawable.setBounds(this.eZO, this.eZO, this.eZO + intrinsicWidth, this.eZO + intrinsicHeight);
            }
            this.mBackgroundDrawable.draw(canvas);
            if (!this.eZU && this.eZV) {
                this.eZN.set(this.eZO, this.eZO, this.eZO + intrinsicWidth, this.eZO + intrinsicHeight);
                if (intrinsicWidth != intrinsicHeight) {
                    canvas.drawRoundRect(this.eZN, this.eZP, this.eZP, this.mShadowPaint);
                } else {
                    canvas.drawOval(this.eZN, this.mShadowPaint);
                }
            }
            if (!au.isEmpty(this.eZH)) {
                if (this.eZH.equals(StringHelper.STRING_MORE)) {
                    E(canvas);
                } else {
                    F(canvas);
                }
            }
        }
    }

    private void E(Canvas canvas) {
        if (this.mBackgroundDrawable != null) {
            int intrinsicWidth = this.eZO + (this.mBackgroundDrawable.getIntrinsicWidth() / 2);
            int intrinsicHeight = (this.mBackgroundDrawable.getIntrinsicHeight() / 2) + this.eZO;
            if (this.eZU) {
                Rect bounds = this.mBackgroundDrawable.getBounds();
                intrinsicWidth = bounds.width() / 2;
                intrinsicHeight = bounds.height() / 2;
            }
            int i = intrinsicWidth - (this.eZQ / 2);
            int i2 = intrinsicHeight - (this.eZQ / 2);
            int i3 = intrinsicWidth + (this.eZQ / 2);
            int i4 = intrinsicHeight + (this.eZQ / 2);
            this.eZT.set(i, i2, i3, i4);
            canvas.drawOval(this.eZT, this.eZS);
            this.eZT.set((i - this.eZR) - this.eZQ, i2, i - this.eZR, i4);
            canvas.drawOval(this.eZT, this.eZS);
            this.eZT.set(this.eZR + i3, i2, i3 + this.eZR + this.eZQ, i4);
            canvas.drawOval(this.eZT, this.eZS);
        }
    }

    private void F(Canvas canvas) {
        if (!au.isEmpty(this.eZH) && this.mBackgroundDrawable != null) {
            this.mTextPaint.getTextBounds(this.eZH, 0, this.eZH.length(), this.eZJ);
            Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
            int intrinsicWidth = this.eZO + (this.mBackgroundDrawable.getIntrinsicWidth() / 2);
            float dimension = (getResources().getDimension(R.dimen.tbds10) + fontMetrics.bottom) - fontMetrics.ascent;
            if (this.eZU) {
                Rect bounds = this.mBackgroundDrawable.getBounds();
                intrinsicWidth = bounds.width() / 2;
                dimension = (bounds.height() / 2) - (fontMetrics.descent - ((fontMetrics.descent + (-fontMetrics.ascent)) / 2.0f));
            }
            canvas.drawText(this.eZH, intrinsicWidth, dimension, this.mTextPaint);
        }
    }

    private void initView() {
        setLayerType(1, null);
        buZ();
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setColor(ap.getColor(R.color.CAM_X0101));
        if (this.eZU || !this.eZV) {
            this.mTextPaint.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize28));
            this.mTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
        } else {
            this.mTextPaint.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize26));
            this.mTextPaint.setTypeface(Typeface.MONOSPACE);
        }
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.eZJ = new Rect();
        this.bCW = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds13);
        this.eZK = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setStyle(Paint.Style.FILL);
        this.mShadowPaint.setColor(ap.getColor(R.color.transparent));
        this.eZL = 0;
        this.mShadowRadius = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.eZM = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds3);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.eZL, this.eZM, ap.getColor(R.color.cp_cont_h_alpha66));
        this.eZN = new RectF();
        this.eZP = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds21);
        this.eZQ = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.eZR = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6);
        this.eZS = new Paint();
        this.eZS.setAntiAlias(true);
        this.eZS.setStyle(Paint.Style.FILL);
        this.eZS.setColor(ap.getColor(R.color.CAM_X0101));
        this.eZT = new RectF();
    }

    private void buZ() {
        String str = Build.MODEL;
        if (str.contains(RomUtils.MANUFACTURER_VIVO) && str.contains("X20")) {
            this.eZI = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds2);
        }
    }

    @Deprecated
    public void refresh(int i) {
        int i2;
        if (i <= 0) {
            i2 = R.drawable.icon_news_red_dot;
            this.eZH = null;
        } else if (i < 10) {
            this.eZH = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_one_number;
        } else if (i < 100) {
            this.eZH = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_two_number;
        } else if (this.mType == 1) {
            this.eZH = StringHelper.STRING_MORE;
            i2 = R.drawable.icon_news_red_dot_three_dot_number;
        } else if (this.mType == 2) {
            this.eZH = "99+";
            i2 = R.drawable.icon_news_red_dot_three_number;
        } else {
            i2 = 0;
        }
        if (i2 != this.eZF) {
            this.eZG = true;
        } else {
            this.eZG = false;
        }
        this.eZF = i2;
        onChangeSkinType();
    }

    public void setThreeDotMode(int i) {
        this.mType = i;
    }

    public void setEnterForumStyle(boolean z) {
        this.eZU = z;
    }

    public void onChangeSkinType() {
        this.eZW = TbadkApplication.getInst().getSkinType();
        if (this.eZF > 0) {
            this.mBackgroundDrawable = ap.getDrawable(this.eZF);
        } else if (this.mBackgroundDrawable instanceof GradientDrawable) {
            ((GradientDrawable) this.mBackgroundDrawable).setColor(ap.getColor(R.color.CAM_X0301));
        }
        this.eZS.setColor(ap.getColor(R.color.CAM_X0101));
        if (this.mTextPaint != null) {
            this.mTextPaint.setColor(ap.getColor(R.color.CAM_X0101));
        }
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.eZL, this.eZM, ap.getColor(R.color.cp_cont_h_alpha66));
        if (this.eZG) {
            this.eZG = false;
            requestLayout();
        }
        invalidate();
    }

    public void setShadowEnabled(boolean z) {
        this.eZV = z;
    }
}
