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
    private int bkB;
    private int eqH;
    private boolean eqI;
    private String eqJ;
    private int eqK;
    private Rect eqL;
    private int eqM;
    private int eqN;
    private int eqO;
    private RectF eqP;
    private int eqQ;
    private int eqR;
    private int eqS;
    private int eqT;
    private Paint eqU;
    private RectF eqV;
    private boolean eqW;
    private boolean eqX;
    private int eqY;
    private Drawable mBackgroundDrawable;
    private Paint mShadowPaint;
    private int mShadowRadius;
    private Paint mTextPaint;
    private int mType;

    public MessageRedDotView(@NonNull Context context) {
        super(context);
        this.mType = 1;
        this.eqW = false;
        this.eqX = false;
        this.eqY = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 1;
        this.eqW = false;
        this.eqX = false;
        this.eqY = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 1;
        this.eqW = false;
        this.eqX = false;
        this.eqY = 3;
        initView();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mBackgroundDrawable != null) {
            this.eqQ = this.eqN >= this.eqO ? this.mShadowRadius + this.eqN : this.mShadowRadius + this.eqO;
            if (this.eqX) {
                setMeasuredDimension(this.mBackgroundDrawable.getIntrinsicWidth() + (this.eqQ * 2), this.mBackgroundDrawable.getIntrinsicHeight() + (this.eqQ * 2));
                return;
            } else {
                setMeasuredDimension(this.mBackgroundDrawable.getIntrinsicWidth(), this.mBackgroundDrawable.getIntrinsicHeight());
                return;
            }
        }
        setMeasuredDimension(0, 0);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mBackgroundDrawable != null) {
            int intrinsicWidth = this.mBackgroundDrawable.getIntrinsicWidth();
            int intrinsicHeight = this.mBackgroundDrawable.getIntrinsicHeight();
            if (this.eqX) {
                if (this.eqW) {
                    this.mBackgroundDrawable.setBounds(0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds4) + intrinsicWidth, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds4) + intrinsicHeight);
                } else {
                    this.mBackgroundDrawable.setBounds(this.eqQ, this.eqQ, this.eqQ + intrinsicWidth, this.eqQ + intrinsicHeight);
                }
            } else {
                this.mBackgroundDrawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            }
            this.mBackgroundDrawable.draw(canvas);
            if (!this.eqW && this.eqX) {
                this.eqP.set(this.eqQ, this.eqQ, this.eqQ + intrinsicWidth, this.eqQ + intrinsicHeight);
                if (intrinsicWidth != intrinsicHeight) {
                    canvas.drawRoundRect(this.eqP, this.eqR, this.eqR, this.mShadowPaint);
                } else {
                    canvas.drawOval(this.eqP, this.mShadowPaint);
                }
            }
            if (!at.isEmpty(this.eqJ)) {
                if (this.eqJ.equals(StringHelper.STRING_MORE)) {
                    D(canvas);
                } else {
                    E(canvas);
                }
            }
        }
    }

    private void D(Canvas canvas) {
        if (this.mBackgroundDrawable != null) {
            int intrinsicWidth = this.eqQ + (this.mBackgroundDrawable.getIntrinsicWidth() / 2);
            int intrinsicHeight = (this.mBackgroundDrawable.getIntrinsicHeight() / 2) + this.eqQ;
            if (this.eqW || !this.eqX) {
                Rect bounds = this.mBackgroundDrawable.getBounds();
                intrinsicWidth = bounds.width() / 2;
                intrinsicHeight = bounds.height() / 2;
            }
            int i = intrinsicWidth - (this.eqS / 2);
            int i2 = intrinsicHeight - (this.eqS / 2);
            int i3 = intrinsicWidth + (this.eqS / 2);
            int i4 = intrinsicHeight + (this.eqS / 2);
            this.eqV.set(i, i2, i3, i4);
            canvas.drawOval(this.eqV, this.eqU);
            this.eqV.set((i - this.eqT) - this.eqS, i2, i - this.eqT, i4);
            canvas.drawOval(this.eqV, this.eqU);
            this.eqV.set(this.eqT + i3, i2, i3 + this.eqT + this.eqS, i4);
            canvas.drawOval(this.eqV, this.eqU);
        }
    }

    private void E(Canvas canvas) {
        if (!at.isEmpty(this.eqJ) && this.mBackgroundDrawable != null) {
            this.mTextPaint.getTextBounds(this.eqJ, 0, this.eqJ.length(), this.eqL);
            Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
            int intrinsicWidth = this.eqQ + (this.mBackgroundDrawable.getIntrinsicWidth() / 2);
            float dimension = (getResources().getDimension(R.dimen.tbds10) + fontMetrics.bottom) - fontMetrics.ascent;
            if (this.eqX) {
                if (this.eqW) {
                    Rect bounds = this.mBackgroundDrawable.getBounds();
                    intrinsicWidth = bounds.width() / 2;
                    dimension = (bounds.height() / 2) - (fontMetrics.descent - ((fontMetrics.descent + (-fontMetrics.ascent)) / 2.0f));
                }
            } else {
                intrinsicWidth = this.mBackgroundDrawable.getIntrinsicWidth() / 2;
                dimension = (this.mBackgroundDrawable.getIntrinsicHeight() / 2) - (fontMetrics.descent - ((fontMetrics.descent + (-fontMetrics.ascent)) / 2.0f));
            }
            canvas.drawText(this.eqJ, intrinsicWidth, dimension, this.mTextPaint);
        }
    }

    private void initView() {
        setLayerType(1, null);
        bko();
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setColor(ap.getColor(R.color.cp_cont_a));
        if (this.eqX) {
            if (this.eqW) {
                this.mTextPaint.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize28));
                this.mTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                this.mTextPaint.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize26));
                this.mTextPaint.setTypeface(Typeface.MONOSPACE);
            }
        } else {
            this.mTextPaint.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize28));
            this.mTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
        }
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.eqL = new Rect();
        this.bkB = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds13);
        this.eqM = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setStyle(Paint.Style.FILL);
        this.mShadowPaint.setColor(ap.getColor(R.color.transparent));
        this.eqN = 0;
        this.mShadowRadius = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.eqO = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds3);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.eqN, this.eqO, ap.getColor(R.color.cp_cont_h_alpha66));
        this.eqP = new RectF();
        this.eqR = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds21);
        this.eqS = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.eqT = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6);
        this.eqU = new Paint();
        this.eqU.setAntiAlias(true);
        this.eqU.setStyle(Paint.Style.FILL);
        this.eqU.setColor(ap.getColor(R.color.cp_cont_a));
        this.eqV = new RectF();
    }

    private void bko() {
        String str = Build.MODEL;
        if (str.contains(RomUtils.MANUFACTURER_VIVO) && str.contains("X20")) {
            this.eqK = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds2);
        }
    }

    @Deprecated
    public void refresh(int i) {
        int i2;
        if (i <= 0) {
            i2 = R.drawable.icon_news_red_dot;
            this.eqJ = null;
        } else if (i < 10) {
            this.eqJ = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_one_number;
        } else if (i < 100) {
            this.eqJ = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_two_number;
        } else if (this.mType == 1) {
            this.eqJ = StringHelper.STRING_MORE;
            i2 = R.drawable.icon_news_red_dot_three_dot_number;
        } else if (this.mType == 2) {
            this.eqJ = "99+";
            i2 = R.drawable.icon_news_red_dot_three_number;
        } else {
            i2 = 0;
        }
        if (i2 != this.eqH) {
            this.eqI = true;
        } else {
            this.eqI = false;
        }
        this.eqH = i2;
        onChangeSkinType();
    }

    public void setThreeDotMode(int i) {
        this.mType = i;
    }

    public void setEnterForumStyle(boolean z) {
        this.eqW = z;
    }

    public void onChangeSkinType() {
        this.eqY = TbadkApplication.getInst().getSkinType();
        if (this.eqH > 0) {
            this.mBackgroundDrawable = ap.getDrawable(this.eqH);
        } else if (this.mBackgroundDrawable instanceof GradientDrawable) {
            ((GradientDrawable) this.mBackgroundDrawable).setColor(ap.getColor(R.color.cp_cont_h));
        }
        this.eqU.setColor(ap.getColor(R.color.cp_cont_a));
        if (this.mTextPaint != null) {
            this.mTextPaint.setColor(ap.getColor(R.color.cp_cont_a));
        }
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.eqN, this.eqO, ap.getColor(R.color.cp_cont_h_alpha66));
        if (this.eqI) {
            this.eqI = false;
            requestLayout();
        }
        invalidate();
    }

    public void setShadowEnabled(boolean z) {
        this.eqX = z;
    }
}
