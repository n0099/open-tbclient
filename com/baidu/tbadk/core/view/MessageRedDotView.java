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
    private int bzz;
    private int eTi;
    private boolean eTj;
    private String eTk;
    private int eTl;
    private Rect eTm;
    private int eTn;
    private int eTo;
    private int eTp;
    private RectF eTq;
    private int eTr;
    private int eTs;
    private int eTt;
    private int eTu;
    private Paint eTv;
    private RectF eTw;
    private boolean eTx;
    private boolean eTy;
    private int eTz;
    private Drawable mBackgroundDrawable;
    private Paint mShadowPaint;
    private int mShadowRadius;
    private Paint mTextPaint;
    private int mType;

    public MessageRedDotView(@NonNull Context context) {
        super(context);
        this.mType = 1;
        this.eTx = false;
        this.eTy = false;
        this.eTz = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 1;
        this.eTx = false;
        this.eTy = false;
        this.eTz = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 1;
        this.eTx = false;
        this.eTy = false;
        this.eTz = 3;
        initView();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mBackgroundDrawable != null) {
            this.eTr = this.eTo >= this.eTp ? this.mShadowRadius + this.eTo : this.mShadowRadius + this.eTp;
            setMeasuredDimension(this.mBackgroundDrawable.getIntrinsicWidth() + (this.eTr * 2), this.mBackgroundDrawable.getIntrinsicHeight() + (this.eTr * 2));
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
            if (this.eTx) {
                this.mBackgroundDrawable.setBounds(0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds4) + intrinsicWidth, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds4) + intrinsicHeight);
            } else {
                this.mBackgroundDrawable.setBounds(this.eTr, this.eTr, this.eTr + intrinsicWidth, this.eTr + intrinsicHeight);
            }
            this.mBackgroundDrawable.draw(canvas);
            if (!this.eTx && this.eTy) {
                this.eTq.set(this.eTr, this.eTr, this.eTr + intrinsicWidth, this.eTr + intrinsicHeight);
                if (intrinsicWidth != intrinsicHeight) {
                    canvas.drawRoundRect(this.eTq, this.eTs, this.eTs, this.mShadowPaint);
                } else {
                    canvas.drawOval(this.eTq, this.mShadowPaint);
                }
            }
            if (!at.isEmpty(this.eTk)) {
                if (this.eTk.equals(StringHelper.STRING_MORE)) {
                    D(canvas);
                } else {
                    E(canvas);
                }
            }
        }
    }

    private void D(Canvas canvas) {
        if (this.mBackgroundDrawable != null) {
            int intrinsicWidth = this.eTr + (this.mBackgroundDrawable.getIntrinsicWidth() / 2);
            int intrinsicHeight = (this.mBackgroundDrawable.getIntrinsicHeight() / 2) + this.eTr;
            if (this.eTx) {
                Rect bounds = this.mBackgroundDrawable.getBounds();
                intrinsicWidth = bounds.width() / 2;
                intrinsicHeight = bounds.height() / 2;
            }
            int i = intrinsicWidth - (this.eTt / 2);
            int i2 = intrinsicHeight - (this.eTt / 2);
            int i3 = intrinsicWidth + (this.eTt / 2);
            int i4 = intrinsicHeight + (this.eTt / 2);
            this.eTw.set(i, i2, i3, i4);
            canvas.drawOval(this.eTw, this.eTv);
            this.eTw.set((i - this.eTu) - this.eTt, i2, i - this.eTu, i4);
            canvas.drawOval(this.eTw, this.eTv);
            this.eTw.set(this.eTu + i3, i2, i3 + this.eTu + this.eTt, i4);
            canvas.drawOval(this.eTw, this.eTv);
        }
    }

    private void E(Canvas canvas) {
        if (!at.isEmpty(this.eTk) && this.mBackgroundDrawable != null) {
            this.mTextPaint.getTextBounds(this.eTk, 0, this.eTk.length(), this.eTm);
            Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
            int intrinsicWidth = this.eTr + (this.mBackgroundDrawable.getIntrinsicWidth() / 2);
            float dimension = (getResources().getDimension(R.dimen.tbds10) + fontMetrics.bottom) - fontMetrics.ascent;
            if (this.eTx) {
                Rect bounds = this.mBackgroundDrawable.getBounds();
                intrinsicWidth = bounds.width() / 2;
                dimension = (bounds.height() / 2) - (fontMetrics.descent - ((fontMetrics.descent + (-fontMetrics.ascent)) / 2.0f));
            }
            canvas.drawText(this.eTk, intrinsicWidth, dimension, this.mTextPaint);
        }
    }

    private void initView() {
        setLayerType(1, null);
        bsm();
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setColor(ap.getColor(R.color.cp_cont_a));
        if (this.eTx || !this.eTy) {
            this.mTextPaint.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize28));
            this.mTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
        } else {
            this.mTextPaint.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize26));
            this.mTextPaint.setTypeface(Typeface.MONOSPACE);
        }
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.eTm = new Rect();
        this.bzz = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds13);
        this.eTn = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setStyle(Paint.Style.FILL);
        this.mShadowPaint.setColor(ap.getColor(R.color.transparent));
        this.eTo = 0;
        this.mShadowRadius = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.eTp = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds3);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.eTo, this.eTp, ap.getColor(R.color.cp_cont_h_alpha66));
        this.eTq = new RectF();
        this.eTs = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds21);
        this.eTt = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.eTu = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6);
        this.eTv = new Paint();
        this.eTv.setAntiAlias(true);
        this.eTv.setStyle(Paint.Style.FILL);
        this.eTv.setColor(ap.getColor(R.color.cp_cont_a));
        this.eTw = new RectF();
    }

    private void bsm() {
        String str = Build.MODEL;
        if (str.contains(RomUtils.MANUFACTURER_VIVO) && str.contains("X20")) {
            this.eTl = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds2);
        }
    }

    @Deprecated
    public void refresh(int i) {
        int i2;
        if (i <= 0) {
            i2 = R.drawable.icon_news_red_dot;
            this.eTk = null;
        } else if (i < 10) {
            this.eTk = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_one_number;
        } else if (i < 100) {
            this.eTk = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_two_number;
        } else if (this.mType == 1) {
            this.eTk = StringHelper.STRING_MORE;
            i2 = R.drawable.icon_news_red_dot_three_dot_number;
        } else if (this.mType == 2) {
            this.eTk = "99+";
            i2 = R.drawable.icon_news_red_dot_three_number;
        } else {
            i2 = 0;
        }
        if (i2 != this.eTi) {
            this.eTj = true;
        } else {
            this.eTj = false;
        }
        this.eTi = i2;
        onChangeSkinType();
    }

    public void setThreeDotMode(int i) {
        this.mType = i;
    }

    public void setEnterForumStyle(boolean z) {
        this.eTx = z;
    }

    public void onChangeSkinType() {
        this.eTz = TbadkApplication.getInst().getSkinType();
        if (this.eTi > 0) {
            this.mBackgroundDrawable = ap.getDrawable(this.eTi);
        } else if (this.mBackgroundDrawable instanceof GradientDrawable) {
            ((GradientDrawable) this.mBackgroundDrawable).setColor(ap.getColor(R.color.cp_cont_h));
        }
        this.eTv.setColor(ap.getColor(R.color.cp_cont_a));
        if (this.mTextPaint != null) {
            this.mTextPaint.setColor(ap.getColor(R.color.cp_cont_a));
        }
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.eTo, this.eTp, ap.getColor(R.color.cp_cont_h_alpha66));
        if (this.eTj) {
            this.eTj = false;
            requestLayout();
        }
        invalidate();
    }

    public void setShadowEnabled(boolean z) {
        this.eTy = z;
    }
}
