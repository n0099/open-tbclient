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
/* loaded from: classes2.dex */
public class MessageRedDotView extends View {
    private int bky;
    private int eqD;
    private boolean eqE;
    private String eqF;
    private int eqG;
    private Rect eqH;
    private int eqI;
    private int eqJ;
    private int eqK;
    private RectF eqL;
    private int eqM;
    private int eqN;
    private int eqO;
    private int eqP;
    private Paint eqQ;
    private RectF eqR;
    private boolean eqS;
    private boolean eqT;
    private int eqU;
    private Drawable mBackgroundDrawable;
    private Paint mShadowPaint;
    private int mShadowRadius;
    private Paint mTextPaint;
    private int mType;

    public MessageRedDotView(@NonNull Context context) {
        super(context);
        this.mType = 1;
        this.eqS = false;
        this.eqT = false;
        this.eqU = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 1;
        this.eqS = false;
        this.eqT = false;
        this.eqU = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 1;
        this.eqS = false;
        this.eqT = false;
        this.eqU = 3;
        initView();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mBackgroundDrawable != null) {
            this.eqM = this.eqJ >= this.eqK ? this.mShadowRadius + this.eqJ : this.mShadowRadius + this.eqK;
            if (this.eqT) {
                setMeasuredDimension(this.mBackgroundDrawable.getIntrinsicWidth() + (this.eqM * 2), this.mBackgroundDrawable.getIntrinsicHeight() + (this.eqM * 2));
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
            if (this.eqT) {
                if (this.eqS) {
                    this.mBackgroundDrawable.setBounds(0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds4) + intrinsicWidth, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds4) + intrinsicHeight);
                } else {
                    this.mBackgroundDrawable.setBounds(this.eqM, this.eqM, this.eqM + intrinsicWidth, this.eqM + intrinsicHeight);
                }
            } else {
                this.mBackgroundDrawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            }
            this.mBackgroundDrawable.draw(canvas);
            if (!this.eqS && this.eqT) {
                this.eqL.set(this.eqM, this.eqM, this.eqM + intrinsicWidth, this.eqM + intrinsicHeight);
                if (intrinsicWidth != intrinsicHeight) {
                    canvas.drawRoundRect(this.eqL, this.eqN, this.eqN, this.mShadowPaint);
                } else {
                    canvas.drawOval(this.eqL, this.mShadowPaint);
                }
            }
            if (!at.isEmpty(this.eqF)) {
                if (this.eqF.equals(StringHelper.STRING_MORE)) {
                    D(canvas);
                } else {
                    E(canvas);
                }
            }
        }
    }

    private void D(Canvas canvas) {
        if (this.mBackgroundDrawable != null) {
            int intrinsicWidth = this.eqM + (this.mBackgroundDrawable.getIntrinsicWidth() / 2);
            int intrinsicHeight = (this.mBackgroundDrawable.getIntrinsicHeight() / 2) + this.eqM;
            if (this.eqS || !this.eqT) {
                Rect bounds = this.mBackgroundDrawable.getBounds();
                intrinsicWidth = bounds.width() / 2;
                intrinsicHeight = bounds.height() / 2;
            }
            int i = intrinsicWidth - (this.eqO / 2);
            int i2 = intrinsicHeight - (this.eqO / 2);
            int i3 = intrinsicWidth + (this.eqO / 2);
            int i4 = intrinsicHeight + (this.eqO / 2);
            this.eqR.set(i, i2, i3, i4);
            canvas.drawOval(this.eqR, this.eqQ);
            this.eqR.set((i - this.eqP) - this.eqO, i2, i - this.eqP, i4);
            canvas.drawOval(this.eqR, this.eqQ);
            this.eqR.set(this.eqP + i3, i2, i3 + this.eqP + this.eqO, i4);
            canvas.drawOval(this.eqR, this.eqQ);
        }
    }

    private void E(Canvas canvas) {
        if (!at.isEmpty(this.eqF) && this.mBackgroundDrawable != null) {
            this.mTextPaint.getTextBounds(this.eqF, 0, this.eqF.length(), this.eqH);
            Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
            int intrinsicWidth = this.eqM + (this.mBackgroundDrawable.getIntrinsicWidth() / 2);
            float dimension = (getResources().getDimension(R.dimen.tbds10) + fontMetrics.bottom) - fontMetrics.ascent;
            if (this.eqT) {
                if (this.eqS) {
                    Rect bounds = this.mBackgroundDrawable.getBounds();
                    intrinsicWidth = bounds.width() / 2;
                    dimension = (bounds.height() / 2) - (fontMetrics.descent - ((fontMetrics.descent + (-fontMetrics.ascent)) / 2.0f));
                }
            } else {
                intrinsicWidth = this.mBackgroundDrawable.getIntrinsicWidth() / 2;
                dimension = (this.mBackgroundDrawable.getIntrinsicHeight() / 2) - (fontMetrics.descent - ((fontMetrics.descent + (-fontMetrics.ascent)) / 2.0f));
            }
            canvas.drawText(this.eqF, intrinsicWidth, dimension, this.mTextPaint);
        }
    }

    private void initView() {
        setLayerType(1, null);
        bko();
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setColor(ap.getColor(R.color.cp_cont_a));
        if (this.eqT) {
            if (this.eqS) {
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
        this.eqH = new Rect();
        this.bky = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds13);
        this.eqI = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setStyle(Paint.Style.FILL);
        this.mShadowPaint.setColor(ap.getColor(R.color.transparent));
        this.eqJ = 0;
        this.mShadowRadius = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.eqK = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds3);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.eqJ, this.eqK, ap.getColor(R.color.cp_cont_h_alpha66));
        this.eqL = new RectF();
        this.eqN = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds21);
        this.eqO = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.eqP = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6);
        this.eqQ = new Paint();
        this.eqQ.setAntiAlias(true);
        this.eqQ.setStyle(Paint.Style.FILL);
        this.eqQ.setColor(ap.getColor(R.color.cp_cont_a));
        this.eqR = new RectF();
    }

    private void bko() {
        String str = Build.MODEL;
        if (str.contains(RomUtils.MANUFACTURER_VIVO) && str.contains("X20")) {
            this.eqG = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds2);
        }
    }

    @Deprecated
    public void refresh(int i) {
        int i2;
        if (i <= 0) {
            i2 = R.drawable.icon_news_red_dot;
            this.eqF = null;
        } else if (i < 10) {
            this.eqF = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_one_number;
        } else if (i < 100) {
            this.eqF = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_two_number;
        } else if (this.mType == 1) {
            this.eqF = StringHelper.STRING_MORE;
            i2 = R.drawable.icon_news_red_dot_three_dot_number;
        } else if (this.mType == 2) {
            this.eqF = "99+";
            i2 = R.drawable.icon_news_red_dot_three_number;
        } else {
            i2 = 0;
        }
        if (i2 != this.eqD) {
            this.eqE = true;
        } else {
            this.eqE = false;
        }
        this.eqD = i2;
        onChangeSkinType();
    }

    public void setThreeDotMode(int i) {
        this.mType = i;
    }

    public void setEnterForumStyle(boolean z) {
        this.eqS = z;
    }

    public void onChangeSkinType() {
        this.eqU = TbadkApplication.getInst().getSkinType();
        if (this.eqD > 0) {
            this.mBackgroundDrawable = ap.getDrawable(this.eqD);
        } else if (this.mBackgroundDrawable instanceof GradientDrawable) {
            ((GradientDrawable) this.mBackgroundDrawable).setColor(ap.getColor(R.color.cp_cont_h));
        }
        this.eqQ.setColor(ap.getColor(R.color.cp_cont_a));
        if (this.mTextPaint != null) {
            this.mTextPaint.setColor(ap.getColor(R.color.cp_cont_a));
        }
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.eqJ, this.eqK, ap.getColor(R.color.cp_cont_h_alpha66));
        if (this.eqE) {
            this.eqE = false;
            requestLayout();
        }
        invalidate();
    }

    public void setShadowEnabled(boolean z) {
        this.eqT = z;
    }
}
