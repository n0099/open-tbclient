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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class MessageRedDotView extends View {
    private int beN;
    private int egW;
    private boolean egX;
    private String egY;
    private int egZ;
    private Rect eha;
    private int ehb;
    private int ehc;
    private int ehd;
    private RectF ehe;
    private int ehf;
    private int ehg;
    private int ehh;
    private int ehi;
    private Paint ehj;
    private RectF ehk;
    private boolean ehl;
    private boolean ehm;
    private int ehn;
    private Drawable mBackgroundDrawable;
    private Paint mShadowPaint;
    private int mShadowRadius;
    private Paint mTextPaint;
    private int mType;

    public MessageRedDotView(@NonNull Context context) {
        super(context);
        this.mType = 1;
        this.ehl = false;
        this.ehm = false;
        this.ehn = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 1;
        this.ehl = false;
        this.ehm = false;
        this.ehn = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 1;
        this.ehl = false;
        this.ehm = false;
        this.ehn = 3;
        initView();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mBackgroundDrawable != null) {
            this.ehf = this.ehc >= this.ehd ? this.mShadowRadius + this.ehc : this.mShadowRadius + this.ehd;
            if (this.ehm) {
                setMeasuredDimension(this.mBackgroundDrawable.getIntrinsicWidth() + (this.ehf * 2), this.mBackgroundDrawable.getIntrinsicHeight() + (this.ehf * 2));
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
            if (this.ehm) {
                if (this.ehl) {
                    this.mBackgroundDrawable.setBounds(0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds4) + intrinsicWidth, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds4) + intrinsicHeight);
                } else {
                    this.mBackgroundDrawable.setBounds(this.ehf, this.ehf, this.ehf + intrinsicWidth, this.ehf + intrinsicHeight);
                }
            } else {
                this.mBackgroundDrawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            }
            this.mBackgroundDrawable.draw(canvas);
            if (!this.ehl && this.ehm) {
                this.ehe.set(this.ehf, this.ehf, this.ehf + intrinsicWidth, this.ehf + intrinsicHeight);
                if (intrinsicWidth != intrinsicHeight) {
                    canvas.drawRoundRect(this.ehe, this.ehg, this.ehg, this.mShadowPaint);
                } else {
                    canvas.drawOval(this.ehe, this.mShadowPaint);
                }
            }
            if (!as.isEmpty(this.egY)) {
                if (this.egY.equals(StringHelper.STRING_MORE)) {
                    y(canvas);
                } else {
                    z(canvas);
                }
            }
        }
    }

    private void y(Canvas canvas) {
        if (this.mBackgroundDrawable != null) {
            int intrinsicWidth = this.ehf + (this.mBackgroundDrawable.getIntrinsicWidth() / 2);
            int intrinsicHeight = (this.mBackgroundDrawable.getIntrinsicHeight() / 2) + this.ehf;
            if (this.ehl || !this.ehm) {
                Rect bounds = this.mBackgroundDrawable.getBounds();
                intrinsicWidth = bounds.width() / 2;
                intrinsicHeight = bounds.height() / 2;
            }
            int i = intrinsicWidth - (this.ehh / 2);
            int i2 = intrinsicHeight - (this.ehh / 2);
            int i3 = intrinsicWidth + (this.ehh / 2);
            int i4 = intrinsicHeight + (this.ehh / 2);
            this.ehk.set(i, i2, i3, i4);
            canvas.drawOval(this.ehk, this.ehj);
            this.ehk.set((i - this.ehi) - this.ehh, i2, i - this.ehi, i4);
            canvas.drawOval(this.ehk, this.ehj);
            this.ehk.set(this.ehi + i3, i2, i3 + this.ehi + this.ehh, i4);
            canvas.drawOval(this.ehk, this.ehj);
        }
    }

    private void z(Canvas canvas) {
        if (!as.isEmpty(this.egY) && this.mBackgroundDrawable != null) {
            this.mTextPaint.getTextBounds(this.egY, 0, this.egY.length(), this.eha);
            Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
            int intrinsicWidth = this.ehf + (this.mBackgroundDrawable.getIntrinsicWidth() / 2);
            float dimension = (getResources().getDimension(R.dimen.tbds10) + fontMetrics.bottom) - fontMetrics.ascent;
            if (this.ehm) {
                if (this.ehl) {
                    Rect bounds = this.mBackgroundDrawable.getBounds();
                    intrinsicWidth = bounds.width() / 2;
                    dimension = (bounds.height() / 2) - (fontMetrics.descent - ((fontMetrics.descent + (-fontMetrics.ascent)) / 2.0f));
                }
            } else {
                intrinsicWidth = this.mBackgroundDrawable.getIntrinsicWidth() / 2;
                dimension = (this.mBackgroundDrawable.getIntrinsicHeight() / 2) - (fontMetrics.descent - ((fontMetrics.descent + (-fontMetrics.ascent)) / 2.0f));
            }
            canvas.drawText(this.egY, intrinsicWidth, dimension, this.mTextPaint);
        }
    }

    private void initView() {
        setLayerType(1, null);
        bbS();
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setColor(ao.getColor(R.color.cp_cont_a));
        if (this.ehm) {
            if (this.ehl) {
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
        this.eha = new Rect();
        this.beN = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds13);
        this.ehb = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setStyle(Paint.Style.FILL);
        this.mShadowPaint.setColor(ao.getColor(R.color.transparent));
        this.ehc = 0;
        this.mShadowRadius = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.ehd = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds3);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.ehc, this.ehd, ao.getColor(R.color.cp_cont_h_alpha66));
        this.ehe = new RectF();
        this.ehg = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds21);
        this.ehh = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.ehi = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6);
        this.ehj = new Paint();
        this.ehj.setAntiAlias(true);
        this.ehj.setStyle(Paint.Style.FILL);
        this.ehj.setColor(ao.getColor(R.color.cp_cont_a));
        this.ehk = new RectF();
    }

    private void bbS() {
        String str = Build.MODEL;
        if (str.contains(RomUtils.MANUFACTURER_VIVO) && str.contains("X20")) {
            this.egZ = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds2);
        }
    }

    @Deprecated
    public void refresh(int i) {
        int i2;
        if (i <= 0) {
            i2 = R.drawable.icon_news_red_dot;
            this.egY = null;
        } else if (i < 10) {
            this.egY = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_one_number;
        } else if (i < 100) {
            this.egY = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_two_number;
        } else if (this.mType == 1) {
            this.egY = StringHelper.STRING_MORE;
            i2 = R.drawable.icon_news_red_dot_three_dot_number;
        } else if (this.mType == 2) {
            this.egY = "99+";
            i2 = R.drawable.icon_news_red_dot_three_number;
        } else {
            i2 = 0;
        }
        if (i2 != this.egW) {
            this.egX = true;
        } else {
            this.egX = false;
        }
        this.egW = i2;
        onChangeSkinType();
    }

    public void setThreeDotMode(int i) {
        this.mType = i;
    }

    public void setEnterForumStyle(boolean z) {
        this.ehl = z;
    }

    public void onChangeSkinType() {
        this.ehn = TbadkApplication.getInst().getSkinType();
        if (this.egW > 0) {
            this.mBackgroundDrawable = ao.getDrawable(this.egW);
        } else if (this.mBackgroundDrawable instanceof GradientDrawable) {
            ((GradientDrawable) this.mBackgroundDrawable).setColor(ao.getColor(R.color.cp_cont_h));
        }
        this.ehj.setColor(ao.getColor(R.color.cp_cont_a));
        if (this.mTextPaint != null) {
            this.mTextPaint.setColor(ao.getColor(R.color.cp_cont_a));
        }
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.ehc, this.ehd, ao.getColor(R.color.cp_cont_h_alpha66));
        if (this.egX) {
            this.egX = false;
            requestLayout();
        }
        invalidate();
    }

    public void setShadowEnabled(boolean z) {
        this.ehm = z;
    }
}
