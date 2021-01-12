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
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class MessageRedDotView extends View {
    private int bCW;
    private Paint bex;
    private boolean feA;
    private String feB;
    private int feC;
    private Rect feD;
    private int feE;
    private int feF;
    private int feG;
    private RectF feH;
    private int feI;
    private int feJ;
    private int feK;
    private int feL;
    private Paint feM;
    private RectF feN;
    private boolean feO;
    private int feP;
    private int fez;
    private Drawable mBackgroundDrawable;
    private Paint mShadowPaint;
    private int mShadowRadius;
    private int mType;
    private boolean shadowEnabled;

    public MessageRedDotView(@NonNull Context context) {
        super(context);
        this.mType = 1;
        this.feO = false;
        this.shadowEnabled = false;
        this.feP = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 1;
        this.feO = false;
        this.shadowEnabled = false;
        this.feP = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 1;
        this.feO = false;
        this.shadowEnabled = false;
        this.feP = 3;
        initView();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mBackgroundDrawable != null) {
            this.feI = this.feF >= this.feG ? this.mShadowRadius + this.feF : this.mShadowRadius + this.feG;
            setMeasuredDimension(this.mBackgroundDrawable.getIntrinsicWidth() + (this.feI * 2), this.mBackgroundDrawable.getIntrinsicHeight() + (this.feI * 2));
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
            if (this.feO) {
                this.mBackgroundDrawable.setBounds(0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds4) + intrinsicWidth, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds4) + intrinsicHeight);
            } else {
                this.mBackgroundDrawable.setBounds(this.feI, this.feI, this.feI + intrinsicWidth, this.feI + intrinsicHeight);
            }
            this.mBackgroundDrawable.draw(canvas);
            if (!this.feO && this.shadowEnabled) {
                this.feH.set(this.feI, this.feI, this.feI + intrinsicWidth, this.feI + intrinsicHeight);
                if (intrinsicWidth != intrinsicHeight) {
                    canvas.drawRoundRect(this.feH, this.feJ, this.feJ, this.mShadowPaint);
                } else {
                    canvas.drawOval(this.feH, this.mShadowPaint);
                }
            }
            if (!at.isEmpty(this.feB)) {
                if (this.feB.equals(StringHelper.STRING_MORE)) {
                    L(canvas);
                } else {
                    M(canvas);
                }
            }
        }
    }

    private void L(Canvas canvas) {
        if (this.mBackgroundDrawable != null) {
            int intrinsicWidth = this.feI + (this.mBackgroundDrawable.getIntrinsicWidth() / 2);
            int intrinsicHeight = (this.mBackgroundDrawable.getIntrinsicHeight() / 2) + this.feI;
            if (this.feO) {
                Rect bounds = this.mBackgroundDrawable.getBounds();
                intrinsicWidth = bounds.width() / 2;
                intrinsicHeight = bounds.height() / 2;
            }
            int i = intrinsicWidth - (this.feK / 2);
            int i2 = intrinsicHeight - (this.feK / 2);
            int i3 = intrinsicWidth + (this.feK / 2);
            int i4 = intrinsicHeight + (this.feK / 2);
            this.feN.set(i, i2, i3, i4);
            canvas.drawOval(this.feN, this.feM);
            this.feN.set((i - this.feL) - this.feK, i2, i - this.feL, i4);
            canvas.drawOval(this.feN, this.feM);
            this.feN.set(this.feL + i3, i2, i3 + this.feL + this.feK, i4);
            canvas.drawOval(this.feN, this.feM);
        }
    }

    private void M(Canvas canvas) {
        if (!at.isEmpty(this.feB) && this.mBackgroundDrawable != null) {
            this.bex.getTextBounds(this.feB, 0, this.feB.length(), this.feD);
            Paint.FontMetrics fontMetrics = this.bex.getFontMetrics();
            int intrinsicWidth = this.feI + (this.mBackgroundDrawable.getIntrinsicWidth() / 2);
            float dimension = (getResources().getDimension(R.dimen.tbds10) + fontMetrics.bottom) - fontMetrics.ascent;
            if (this.feO) {
                Rect bounds = this.mBackgroundDrawable.getBounds();
                intrinsicWidth = bounds.width() / 2;
                dimension = (bounds.height() / 2) - (fontMetrics.descent - ((fontMetrics.descent + (-fontMetrics.ascent)) / 2.0f));
            }
            canvas.drawText(this.feB, intrinsicWidth, dimension, this.bex);
        }
    }

    private void initView() {
        setLayerType(1, null);
        btB();
        this.bex = new Paint(1);
        this.bex.setColor(ao.getColor(R.color.CAM_X0101));
        if (this.feO || !this.shadowEnabled) {
            this.bex.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize28));
            this.bex.setTypeface(Typeface.DEFAULT_BOLD);
        } else {
            this.bex.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize26));
            this.bex.setTypeface(Typeface.MONOSPACE);
        }
        this.bex.setTextAlign(Paint.Align.CENTER);
        this.feD = new Rect();
        this.bCW = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds13);
        this.feE = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setStyle(Paint.Style.FILL);
        this.mShadowPaint.setColor(ao.getColor(R.color.transparent));
        this.feF = 0;
        this.mShadowRadius = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.feG = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds3);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.feF, this.feG, ao.getColor(R.color.cp_cont_h_alpha66));
        this.feH = new RectF();
        this.feJ = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds21);
        this.feK = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.feL = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6);
        this.feM = new Paint();
        this.feM.setAntiAlias(true);
        this.feM.setStyle(Paint.Style.FILL);
        this.feM.setColor(ao.getColor(R.color.CAM_X0101));
        this.feN = new RectF();
    }

    private void btB() {
        String str = Build.MODEL;
        if (str.contains(RomUtils.MANUFACTURER_VIVO) && str.contains("X20")) {
            this.feC = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds2);
        }
    }

    @Deprecated
    public void refresh(int i) {
        int i2;
        if (i <= 0) {
            i2 = R.drawable.icon_news_red_dot;
            this.feB = null;
        } else if (i < 10) {
            this.feB = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_one_number;
        } else if (i < 100) {
            this.feB = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_two_number;
        } else if (this.mType == 1) {
            this.feB = StringHelper.STRING_MORE;
            i2 = R.drawable.icon_news_red_dot_three_dot_number;
        } else if (this.mType == 2) {
            this.feB = "99+";
            i2 = R.drawable.icon_news_red_dot_three_number;
        } else {
            i2 = 0;
        }
        if (i2 != this.fez) {
            this.feA = true;
        } else {
            this.feA = false;
        }
        this.fez = i2;
        onChangeSkinType();
    }

    public void setThreeDotMode(int i) {
        this.mType = i;
    }

    public void setEnterForumStyle(boolean z) {
        this.feO = z;
    }

    public void onChangeSkinType() {
        this.feP = TbadkApplication.getInst().getSkinType();
        if (this.fez > 0) {
            this.mBackgroundDrawable = ao.getDrawable(this.fez);
        } else if (this.mBackgroundDrawable instanceof GradientDrawable) {
            ((GradientDrawable) this.mBackgroundDrawable).setColor(ao.getColor(R.color.CAM_X0301));
        }
        this.feM.setColor(ao.getColor(R.color.CAM_X0101));
        if (this.bex != null) {
            this.bex.setColor(ao.getColor(R.color.CAM_X0101));
        }
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.feF, this.feG, ao.getColor(R.color.cp_cont_h_alpha66));
        if (this.feA) {
            this.feA = false;
            requestLayout();
        }
        invalidate();
    }

    public void setShadowEnabled(boolean z) {
        this.shadowEnabled = z;
    }
}
