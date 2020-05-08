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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class MessageRedDotView extends View {
    private int aRZ;
    private int dFA;
    private int dFB;
    private int dFC;
    private int dFD;
    private Paint dFE;
    private RectF dFF;
    private boolean dFG;
    private int dFH;
    private int dFr;
    private boolean dFs;
    private String dFt;
    private int dFu;
    private Rect dFv;
    private int dFw;
    private int dFx;
    private int dFy;
    private RectF dFz;
    private Drawable mBackgroundDrawable;
    private Paint mShadowPaint;
    private int mShadowRadius;
    private Paint mTextPaint;
    private int mType;

    public MessageRedDotView(@NonNull Context context) {
        super(context);
        this.mType = 1;
        this.dFG = false;
        this.dFH = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 1;
        this.dFG = false;
        this.dFH = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 1;
        this.dFG = false;
        this.dFH = 3;
        initView();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mBackgroundDrawable != null) {
            this.dFA = this.dFx >= this.dFy ? this.mShadowRadius + this.dFx : this.mShadowRadius + this.dFy;
            setMeasuredDimension(this.mBackgroundDrawable.getIntrinsicWidth() + (this.dFA * 2), this.mBackgroundDrawable.getIntrinsicHeight() + (this.dFA * 2));
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
            if (this.dFG) {
                this.mBackgroundDrawable.setBounds(0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds4) + intrinsicWidth, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds4) + intrinsicHeight);
            } else {
                this.mBackgroundDrawable.setBounds(this.dFA, this.dFA, this.dFA + intrinsicWidth, this.dFA + intrinsicHeight);
            }
            this.mBackgroundDrawable.draw(canvas);
            if (!this.dFG) {
                this.dFz.set(this.dFA, this.dFA, this.dFA + intrinsicWidth, this.dFA + intrinsicHeight);
                if (intrinsicWidth != intrinsicHeight) {
                    canvas.drawRoundRect(this.dFz, this.dFB, this.dFB, this.mShadowPaint);
                } else {
                    canvas.drawOval(this.dFz, this.mShadowPaint);
                }
            }
            if (!aq.isEmpty(this.dFt)) {
                if (this.dFt.equals(StringHelper.STRING_MORE)) {
                    x(canvas);
                } else {
                    y(canvas);
                }
            }
        }
    }

    private void x(Canvas canvas) {
        if (this.mBackgroundDrawable != null) {
            int intrinsicWidth = this.dFA + (this.mBackgroundDrawable.getIntrinsicWidth() / 2);
            int intrinsicHeight = (this.mBackgroundDrawable.getIntrinsicHeight() / 2) + this.dFA;
            if (this.dFG) {
                Rect bounds = this.mBackgroundDrawable.getBounds();
                intrinsicWidth = bounds.width() / 2;
                intrinsicHeight = bounds.height() / 2;
            }
            int i = intrinsicWidth - (this.dFC / 2);
            int i2 = intrinsicHeight - (this.dFC / 2);
            int i3 = intrinsicWidth + (this.dFC / 2);
            int i4 = intrinsicHeight + (this.dFC / 2);
            this.dFF.set(i, i2, i3, i4);
            canvas.drawOval(this.dFF, this.dFE);
            this.dFF.set((i - this.dFD) - this.dFC, i2, i - this.dFD, i4);
            canvas.drawOval(this.dFF, this.dFE);
            this.dFF.set(this.dFD + i3, i2, i3 + this.dFD + this.dFC, i4);
            canvas.drawOval(this.dFF, this.dFE);
        }
    }

    private void y(Canvas canvas) {
        if (!aq.isEmpty(this.dFt) && this.mBackgroundDrawable != null) {
            this.mTextPaint.getTextBounds(this.dFt, 0, this.dFt.length(), this.dFv);
            Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
            int intrinsicWidth = this.dFA + (this.mBackgroundDrawable.getIntrinsicWidth() / 2);
            float dimension = (getResources().getDimension(R.dimen.tbds10) + fontMetrics.bottom) - fontMetrics.ascent;
            if (this.dFG) {
                Rect bounds = this.mBackgroundDrawable.getBounds();
                intrinsicWidth = bounds.width() / 2;
                dimension = (bounds.height() / 2) - (fontMetrics.descent - ((fontMetrics.descent + (-fontMetrics.ascent)) / 2.0f));
            }
            canvas.drawText(this.dFt, intrinsicWidth, dimension, this.mTextPaint);
        }
    }

    private void initView() {
        setLayerType(1, null);
        aPT();
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setColor(am.getColor(R.color.cp_cont_a));
        if (this.dFG) {
            this.mTextPaint.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize28));
            this.mTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
        } else {
            this.mTextPaint.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize26));
            this.mTextPaint.setTypeface(Typeface.MONOSPACE);
        }
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.dFv = new Rect();
        this.aRZ = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds13);
        this.dFw = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setStyle(Paint.Style.FILL);
        this.mShadowPaint.setColor(am.getColor(R.color.transparent));
        this.dFx = 0;
        this.mShadowRadius = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.dFy = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds3);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.dFx, this.dFy, am.getColor(R.color.cp_cont_h_alpha66));
        this.dFz = new RectF();
        this.dFB = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds21);
        this.dFC = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.dFD = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6);
        this.dFE = new Paint();
        this.dFE.setAntiAlias(true);
        this.dFE.setStyle(Paint.Style.FILL);
        this.dFE.setColor(am.getColor(R.color.cp_cont_a));
        this.dFF = new RectF();
    }

    private void aPT() {
        String str = Build.MODEL;
        if (str.contains(RomUtils.MANUFACTURER_VIVO) && str.contains("X20")) {
            this.dFu = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds2);
        }
    }

    @Deprecated
    public void refresh(int i) {
        int i2;
        if (i <= 0) {
            i2 = R.drawable.icon_news_red_dot;
            this.dFt = null;
        } else if (i < 10) {
            this.dFt = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_one_number;
        } else if (i < 100) {
            this.dFt = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_two_number;
        } else if (this.mType == 1) {
            this.dFt = StringHelper.STRING_MORE;
            i2 = R.drawable.icon_news_red_dot_three_dot_number;
        } else if (this.mType == 2) {
            this.dFt = "99+";
            i2 = R.drawable.icon_news_red_dot_three_number;
        } else {
            i2 = 0;
        }
        if (i2 != this.dFr) {
            this.dFs = true;
        } else {
            this.dFs = false;
        }
        this.dFr = i2;
        onChangeSkinType();
    }

    public void setThreeDotMode(int i) {
        this.mType = i;
    }

    public void setEnterForumStyle(boolean z) {
        this.dFG = z;
    }

    public void onChangeSkinType() {
        this.dFH = TbadkApplication.getInst().getSkinType();
        if (this.dFr > 0) {
            this.mBackgroundDrawable = am.getDrawable(this.dFr);
        } else if (this.mBackgroundDrawable instanceof GradientDrawable) {
            ((GradientDrawable) this.mBackgroundDrawable).setColor(am.getColor(R.color.cp_cont_h));
        }
        this.dFE.setColor(am.getColor(R.color.cp_cont_a));
        if (this.mTextPaint != null) {
            this.mTextPaint.setColor(am.getColor(R.color.cp_cont_a));
        }
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.dFx, this.dFy, am.getColor(R.color.cp_cont_h_alpha66));
        if (this.dFs) {
            this.dFs = false;
            requestLayout();
        }
        invalidate();
    }
}
