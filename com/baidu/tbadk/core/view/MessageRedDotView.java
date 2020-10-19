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
    private int brh;
    private int eEX;
    private boolean eEY;
    private String eEZ;
    private int eFa;
    private Rect eFb;
    private int eFc;
    private int eFd;
    private int eFe;
    private RectF eFf;
    private int eFg;
    private int eFh;
    private int eFi;
    private int eFj;
    private Paint eFk;
    private RectF eFl;
    private boolean eFm;
    private boolean eFn;
    private int eFo;
    private Drawable mBackgroundDrawable;
    private Paint mShadowPaint;
    private int mShadowRadius;
    private Paint mTextPaint;
    private int mType;

    public MessageRedDotView(@NonNull Context context) {
        super(context);
        this.mType = 1;
        this.eFm = false;
        this.eFn = false;
        this.eFo = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 1;
        this.eFm = false;
        this.eFn = false;
        this.eFo = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 1;
        this.eFm = false;
        this.eFn = false;
        this.eFo = 3;
        initView();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mBackgroundDrawable != null) {
            this.eFg = this.eFd >= this.eFe ? this.mShadowRadius + this.eFd : this.mShadowRadius + this.eFe;
            setMeasuredDimension(this.mBackgroundDrawable.getIntrinsicWidth() + (this.eFg * 2), this.mBackgroundDrawable.getIntrinsicHeight() + (this.eFg * 2));
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
            if (this.eFm) {
                this.mBackgroundDrawable.setBounds(0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds4) + intrinsicWidth, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds4) + intrinsicHeight);
            } else {
                this.mBackgroundDrawable.setBounds(this.eFg, this.eFg, this.eFg + intrinsicWidth, this.eFg + intrinsicHeight);
            }
            this.mBackgroundDrawable.draw(canvas);
            if (!this.eFm && this.eFn) {
                this.eFf.set(this.eFg, this.eFg, this.eFg + intrinsicWidth, this.eFg + intrinsicHeight);
                if (intrinsicWidth != intrinsicHeight) {
                    canvas.drawRoundRect(this.eFf, this.eFh, this.eFh, this.mShadowPaint);
                } else {
                    canvas.drawOval(this.eFf, this.mShadowPaint);
                }
            }
            if (!at.isEmpty(this.eEZ)) {
                if (this.eEZ.equals(StringHelper.STRING_MORE)) {
                    D(canvas);
                } else {
                    E(canvas);
                }
            }
        }
    }

    private void D(Canvas canvas) {
        if (this.mBackgroundDrawable != null) {
            int intrinsicWidth = this.eFg + (this.mBackgroundDrawable.getIntrinsicWidth() / 2);
            int intrinsicHeight = (this.mBackgroundDrawable.getIntrinsicHeight() / 2) + this.eFg;
            if (this.eFm) {
                Rect bounds = this.mBackgroundDrawable.getBounds();
                intrinsicWidth = bounds.width() / 2;
                intrinsicHeight = bounds.height() / 2;
            }
            int i = intrinsicWidth - (this.eFi / 2);
            int i2 = intrinsicHeight - (this.eFi / 2);
            int i3 = intrinsicWidth + (this.eFi / 2);
            int i4 = intrinsicHeight + (this.eFi / 2);
            this.eFl.set(i, i2, i3, i4);
            canvas.drawOval(this.eFl, this.eFk);
            this.eFl.set((i - this.eFj) - this.eFi, i2, i - this.eFj, i4);
            canvas.drawOval(this.eFl, this.eFk);
            this.eFl.set(this.eFj + i3, i2, i3 + this.eFj + this.eFi, i4);
            canvas.drawOval(this.eFl, this.eFk);
        }
    }

    private void E(Canvas canvas) {
        if (!at.isEmpty(this.eEZ) && this.mBackgroundDrawable != null) {
            this.mTextPaint.getTextBounds(this.eEZ, 0, this.eEZ.length(), this.eFb);
            Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
            int intrinsicWidth = this.eFg + (this.mBackgroundDrawable.getIntrinsicWidth() / 2);
            float dimension = (getResources().getDimension(R.dimen.tbds10) + fontMetrics.bottom) - fontMetrics.ascent;
            if (this.eFm) {
                Rect bounds = this.mBackgroundDrawable.getBounds();
                intrinsicWidth = bounds.width() / 2;
                dimension = (bounds.height() / 2) - (fontMetrics.descent - ((fontMetrics.descent + (-fontMetrics.ascent)) / 2.0f));
            }
            canvas.drawText(this.eEZ, intrinsicWidth, dimension, this.mTextPaint);
        }
    }

    private void initView() {
        setLayerType(1, null);
        bnT();
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setColor(ap.getColor(R.color.cp_cont_a));
        if (this.eFm || !this.eFn) {
            this.mTextPaint.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize28));
            this.mTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
        } else {
            this.mTextPaint.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize26));
            this.mTextPaint.setTypeface(Typeface.MONOSPACE);
        }
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.eFb = new Rect();
        this.brh = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds13);
        this.eFc = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setStyle(Paint.Style.FILL);
        this.mShadowPaint.setColor(ap.getColor(R.color.transparent));
        this.eFd = 0;
        this.mShadowRadius = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.eFe = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds3);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.eFd, this.eFe, ap.getColor(R.color.cp_cont_h_alpha66));
        this.eFf = new RectF();
        this.eFh = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds21);
        this.eFi = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.eFj = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6);
        this.eFk = new Paint();
        this.eFk.setAntiAlias(true);
        this.eFk.setStyle(Paint.Style.FILL);
        this.eFk.setColor(ap.getColor(R.color.cp_cont_a));
        this.eFl = new RectF();
    }

    private void bnT() {
        String str = Build.MODEL;
        if (str.contains(RomUtils.MANUFACTURER_VIVO) && str.contains("X20")) {
            this.eFa = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds2);
        }
    }

    @Deprecated
    public void refresh(int i) {
        int i2;
        if (i <= 0) {
            i2 = R.drawable.icon_news_red_dot;
            this.eEZ = null;
        } else if (i < 10) {
            this.eEZ = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_one_number;
        } else if (i < 100) {
            this.eEZ = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_two_number;
        } else if (this.mType == 1) {
            this.eEZ = StringHelper.STRING_MORE;
            i2 = R.drawable.icon_news_red_dot_three_dot_number;
        } else if (this.mType == 2) {
            this.eEZ = "99+";
            i2 = R.drawable.icon_news_red_dot_three_number;
        } else {
            i2 = 0;
        }
        if (i2 != this.eEX) {
            this.eEY = true;
        } else {
            this.eEY = false;
        }
        this.eEX = i2;
        onChangeSkinType();
    }

    public void setThreeDotMode(int i) {
        this.mType = i;
    }

    public void setEnterForumStyle(boolean z) {
        this.eFm = z;
    }

    public void onChangeSkinType() {
        this.eFo = TbadkApplication.getInst().getSkinType();
        if (this.eEX > 0) {
            this.mBackgroundDrawable = ap.getDrawable(this.eEX);
        } else if (this.mBackgroundDrawable instanceof GradientDrawable) {
            ((GradientDrawable) this.mBackgroundDrawable).setColor(ap.getColor(R.color.cp_cont_h));
        }
        this.eFk.setColor(ap.getColor(R.color.cp_cont_a));
        if (this.mTextPaint != null) {
            this.mTextPaint.setColor(ap.getColor(R.color.cp_cont_a));
        }
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.eFd, this.eFe, ap.getColor(R.color.cp_cont_h_alpha66));
        if (this.eEY) {
            this.eEY = false;
            requestLayout();
        }
        invalidate();
    }

    public void setShadowEnabled(boolean z) {
        this.eFn = z;
    }
}
