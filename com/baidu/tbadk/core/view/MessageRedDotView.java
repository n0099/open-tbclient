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
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class MessageRedDotView extends View {
    private int btm;
    private int eNA;
    private RectF eNB;
    private int eNC;
    private int eND;
    private int eNE;
    private int eNF;
    private Paint eNG;
    private RectF eNH;
    private boolean eNI;
    private boolean eNJ;
    private int eNK;
    private int eNt;
    private boolean eNu;
    private String eNv;
    private int eNw;
    private Rect eNx;
    private int eNy;
    private int eNz;
    private Drawable mBackgroundDrawable;
    private Paint mShadowPaint;
    private int mShadowRadius;
    private Paint mTextPaint;
    private int mType;

    public MessageRedDotView(@NonNull Context context) {
        super(context);
        this.mType = 1;
        this.eNI = false;
        this.eNJ = false;
        this.eNK = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 1;
        this.eNI = false;
        this.eNJ = false;
        this.eNK = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 1;
        this.eNI = false;
        this.eNJ = false;
        this.eNK = 3;
        initView();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mBackgroundDrawable != null) {
            this.eNC = this.eNz >= this.eNA ? this.mShadowRadius + this.eNz : this.mShadowRadius + this.eNA;
            setMeasuredDimension(this.mBackgroundDrawable.getIntrinsicWidth() + (this.eNC * 2), this.mBackgroundDrawable.getIntrinsicHeight() + (this.eNC * 2));
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
            if (this.eNI) {
                this.mBackgroundDrawable.setBounds(0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds4) + intrinsicWidth, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds4) + intrinsicHeight);
            } else {
                this.mBackgroundDrawable.setBounds(this.eNC, this.eNC, this.eNC + intrinsicWidth, this.eNC + intrinsicHeight);
            }
            this.mBackgroundDrawable.draw(canvas);
            if (!this.eNI && this.eNJ) {
                this.eNB.set(this.eNC, this.eNC, this.eNC + intrinsicWidth, this.eNC + intrinsicHeight);
                if (intrinsicWidth != intrinsicHeight) {
                    canvas.drawRoundRect(this.eNB, this.eND, this.eND, this.mShadowPaint);
                } else {
                    canvas.drawOval(this.eNB, this.mShadowPaint);
                }
            }
            if (!at.isEmpty(this.eNv)) {
                if (this.eNv.equals(StringHelper.STRING_MORE)) {
                    D(canvas);
                } else {
                    E(canvas);
                }
            }
        }
    }

    private void D(Canvas canvas) {
        if (this.mBackgroundDrawable != null) {
            int intrinsicWidth = this.eNC + (this.mBackgroundDrawable.getIntrinsicWidth() / 2);
            int intrinsicHeight = (this.mBackgroundDrawable.getIntrinsicHeight() / 2) + this.eNC;
            if (this.eNI) {
                Rect bounds = this.mBackgroundDrawable.getBounds();
                intrinsicWidth = bounds.width() / 2;
                intrinsicHeight = bounds.height() / 2;
            }
            int i = intrinsicWidth - (this.eNE / 2);
            int i2 = intrinsicHeight - (this.eNE / 2);
            int i3 = intrinsicWidth + (this.eNE / 2);
            int i4 = intrinsicHeight + (this.eNE / 2);
            this.eNH.set(i, i2, i3, i4);
            canvas.drawOval(this.eNH, this.eNG);
            this.eNH.set((i - this.eNF) - this.eNE, i2, i - this.eNF, i4);
            canvas.drawOval(this.eNH, this.eNG);
            this.eNH.set(this.eNF + i3, i2, i3 + this.eNF + this.eNE, i4);
            canvas.drawOval(this.eNH, this.eNG);
        }
    }

    private void E(Canvas canvas) {
        if (!at.isEmpty(this.eNv) && this.mBackgroundDrawable != null) {
            this.mTextPaint.getTextBounds(this.eNv, 0, this.eNv.length(), this.eNx);
            Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
            int intrinsicWidth = this.eNC + (this.mBackgroundDrawable.getIntrinsicWidth() / 2);
            float dimension = (getResources().getDimension(R.dimen.tbds10) + fontMetrics.bottom) - fontMetrics.ascent;
            if (this.eNI) {
                Rect bounds = this.mBackgroundDrawable.getBounds();
                intrinsicWidth = bounds.width() / 2;
                dimension = (bounds.height() / 2) - (fontMetrics.descent - ((fontMetrics.descent + (-fontMetrics.ascent)) / 2.0f));
            }
            canvas.drawText(this.eNv, intrinsicWidth, dimension, this.mTextPaint);
        }
    }

    private void initView() {
        setLayerType(1, null);
        bpM();
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setColor(ap.getColor(R.color.cp_cont_a));
        if (this.eNI || !this.eNJ) {
            this.mTextPaint.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize28));
            this.mTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
        } else {
            this.mTextPaint.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize26));
            this.mTextPaint.setTypeface(Typeface.MONOSPACE);
        }
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.eNx = new Rect();
        this.btm = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds13);
        this.eNy = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setStyle(Paint.Style.FILL);
        this.mShadowPaint.setColor(ap.getColor(R.color.transparent));
        this.eNz = 0;
        this.mShadowRadius = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.eNA = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds3);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.eNz, this.eNA, ap.getColor(R.color.cp_cont_h_alpha66));
        this.eNB = new RectF();
        this.eND = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds21);
        this.eNE = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.eNF = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6);
        this.eNG = new Paint();
        this.eNG.setAntiAlias(true);
        this.eNG.setStyle(Paint.Style.FILL);
        this.eNG.setColor(ap.getColor(R.color.cp_cont_a));
        this.eNH = new RectF();
    }

    private void bpM() {
        String str = Build.MODEL;
        if (str.contains(RomUtils.MANUFACTURER_VIVO) && str.contains("X20")) {
            this.eNw = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds2);
        }
    }

    @Deprecated
    public void refresh(int i) {
        int i2;
        if (i <= 0) {
            i2 = R.drawable.icon_news_red_dot;
            this.eNv = null;
        } else if (i < 10) {
            this.eNv = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_one_number;
        } else if (i < 100) {
            this.eNv = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_two_number;
        } else if (this.mType == 1) {
            this.eNv = StringHelper.STRING_MORE;
            i2 = R.drawable.icon_news_red_dot_three_dot_number;
        } else if (this.mType == 2) {
            this.eNv = "99+";
            i2 = R.drawable.icon_news_red_dot_three_number;
        } else {
            i2 = 0;
        }
        if (i2 != this.eNt) {
            this.eNu = true;
        } else {
            this.eNu = false;
        }
        this.eNt = i2;
        onChangeSkinType();
    }

    public void setThreeDotMode(int i) {
        this.mType = i;
    }

    public void setEnterForumStyle(boolean z) {
        this.eNI = z;
    }

    public void onChangeSkinType() {
        this.eNK = TbadkApplication.getInst().getSkinType();
        if (this.eNt > 0) {
            this.mBackgroundDrawable = ap.getDrawable(this.eNt);
        } else if (this.mBackgroundDrawable instanceof GradientDrawable) {
            ((GradientDrawable) this.mBackgroundDrawable).setColor(ap.getColor(R.color.cp_cont_h));
        }
        this.eNG.setColor(ap.getColor(R.color.cp_cont_a));
        if (this.mTextPaint != null) {
            this.mTextPaint.setColor(ap.getColor(R.color.cp_cont_a));
        }
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.eNz, this.eNA, ap.getColor(R.color.cp_cont_h_alpha66));
        if (this.eNu) {
            this.eNu = false;
            requestLayout();
        }
        invalidate();
    }

    public void setShadowEnabled(boolean z) {
        this.eNJ = z;
    }
}
