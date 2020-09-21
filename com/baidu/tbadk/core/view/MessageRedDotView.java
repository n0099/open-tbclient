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
    private int bnu;
    private int esM;
    private boolean esN;
    private String esO;
    private int esP;
    private Rect esQ;
    private int esR;
    private int esS;
    private int esT;
    private RectF esU;
    private int esV;
    private int esW;
    private int esX;
    private int esY;
    private Paint esZ;
    private RectF eta;
    private boolean etb;
    private boolean etd;
    private int ete;
    private Drawable mBackgroundDrawable;
    private Paint mShadowPaint;
    private int mShadowRadius;
    private Paint mTextPaint;
    private int mType;

    public MessageRedDotView(@NonNull Context context) {
        super(context);
        this.mType = 1;
        this.etb = false;
        this.etd = false;
        this.ete = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 1;
        this.etb = false;
        this.etd = false;
        this.ete = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 1;
        this.etb = false;
        this.etd = false;
        this.ete = 3;
        initView();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mBackgroundDrawable != null) {
            this.esV = this.esS >= this.esT ? this.mShadowRadius + this.esS : this.mShadowRadius + this.esT;
            setMeasuredDimension(this.mBackgroundDrawable.getIntrinsicWidth() + (this.esV * 2), this.mBackgroundDrawable.getIntrinsicHeight() + (this.esV * 2));
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
            if (this.etb) {
                this.mBackgroundDrawable.setBounds(0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds4) + intrinsicWidth, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds4) + intrinsicHeight);
            } else {
                this.mBackgroundDrawable.setBounds(this.esV, this.esV, this.esV + intrinsicWidth, this.esV + intrinsicHeight);
            }
            this.mBackgroundDrawable.draw(canvas);
            if (!this.etb && this.etd) {
                this.esU.set(this.esV, this.esV, this.esV + intrinsicWidth, this.esV + intrinsicHeight);
                if (intrinsicWidth != intrinsicHeight) {
                    canvas.drawRoundRect(this.esU, this.esW, this.esW, this.mShadowPaint);
                } else {
                    canvas.drawOval(this.esU, this.mShadowPaint);
                }
            }
            if (!at.isEmpty(this.esO)) {
                if (this.esO.equals(StringHelper.STRING_MORE)) {
                    D(canvas);
                } else {
                    E(canvas);
                }
            }
        }
    }

    private void D(Canvas canvas) {
        if (this.mBackgroundDrawable != null) {
            int intrinsicWidth = this.esV + (this.mBackgroundDrawable.getIntrinsicWidth() / 2);
            int intrinsicHeight = (this.mBackgroundDrawable.getIntrinsicHeight() / 2) + this.esV;
            if (this.etb) {
                Rect bounds = this.mBackgroundDrawable.getBounds();
                intrinsicWidth = bounds.width() / 2;
                intrinsicHeight = bounds.height() / 2;
            }
            int i = intrinsicWidth - (this.esX / 2);
            int i2 = intrinsicHeight - (this.esX / 2);
            int i3 = intrinsicWidth + (this.esX / 2);
            int i4 = intrinsicHeight + (this.esX / 2);
            this.eta.set(i, i2, i3, i4);
            canvas.drawOval(this.eta, this.esZ);
            this.eta.set((i - this.esY) - this.esX, i2, i - this.esY, i4);
            canvas.drawOval(this.eta, this.esZ);
            this.eta.set(this.esY + i3, i2, i3 + this.esY + this.esX, i4);
            canvas.drawOval(this.eta, this.esZ);
        }
    }

    private void E(Canvas canvas) {
        if (!at.isEmpty(this.esO) && this.mBackgroundDrawable != null) {
            this.mTextPaint.getTextBounds(this.esO, 0, this.esO.length(), this.esQ);
            Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
            int intrinsicWidth = this.esV + (this.mBackgroundDrawable.getIntrinsicWidth() / 2);
            float dimension = (getResources().getDimension(R.dimen.tbds10) + fontMetrics.bottom) - fontMetrics.ascent;
            if (this.etb) {
                Rect bounds = this.mBackgroundDrawable.getBounds();
                intrinsicWidth = bounds.width() / 2;
                dimension = (bounds.height() / 2) - (fontMetrics.descent - ((fontMetrics.descent + (-fontMetrics.ascent)) / 2.0f));
            }
            canvas.drawText(this.esO, intrinsicWidth, dimension, this.mTextPaint);
        }
    }

    private void initView() {
        setLayerType(1, null);
        blj();
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setColor(ap.getColor(R.color.cp_cont_a));
        if (this.etb || !this.etd) {
            this.mTextPaint.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize28));
            this.mTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
        } else {
            this.mTextPaint.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize26));
            this.mTextPaint.setTypeface(Typeface.MONOSPACE);
        }
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.esQ = new Rect();
        this.bnu = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds13);
        this.esR = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setStyle(Paint.Style.FILL);
        this.mShadowPaint.setColor(ap.getColor(R.color.transparent));
        this.esS = 0;
        this.mShadowRadius = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.esT = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds3);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.esS, this.esT, ap.getColor(R.color.cp_cont_h_alpha66));
        this.esU = new RectF();
        this.esW = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds21);
        this.esX = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.esY = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6);
        this.esZ = new Paint();
        this.esZ.setAntiAlias(true);
        this.esZ.setStyle(Paint.Style.FILL);
        this.esZ.setColor(ap.getColor(R.color.cp_cont_a));
        this.eta = new RectF();
    }

    private void blj() {
        String str = Build.MODEL;
        if (str.contains(RomUtils.MANUFACTURER_VIVO) && str.contains("X20")) {
            this.esP = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds2);
        }
    }

    @Deprecated
    public void refresh(int i) {
        int i2;
        if (i <= 0) {
            i2 = R.drawable.icon_news_red_dot;
            this.esO = null;
        } else if (i < 10) {
            this.esO = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_one_number;
        } else if (i < 100) {
            this.esO = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_two_number;
        } else if (this.mType == 1) {
            this.esO = StringHelper.STRING_MORE;
            i2 = R.drawable.icon_news_red_dot_three_dot_number;
        } else if (this.mType == 2) {
            this.esO = "99+";
            i2 = R.drawable.icon_news_red_dot_three_number;
        } else {
            i2 = 0;
        }
        if (i2 != this.esM) {
            this.esN = true;
        } else {
            this.esN = false;
        }
        this.esM = i2;
        onChangeSkinType();
    }

    public void setThreeDotMode(int i) {
        this.mType = i;
    }

    public void setEnterForumStyle(boolean z) {
        this.etb = z;
    }

    public void onChangeSkinType() {
        this.ete = TbadkApplication.getInst().getSkinType();
        if (this.esM > 0) {
            this.mBackgroundDrawable = ap.getDrawable(this.esM);
        } else if (this.mBackgroundDrawable instanceof GradientDrawable) {
            ((GradientDrawable) this.mBackgroundDrawable).setColor(ap.getColor(R.color.cp_cont_h));
        }
        this.esZ.setColor(ap.getColor(R.color.cp_cont_a));
        if (this.mTextPaint != null) {
            this.mTextPaint.setColor(ap.getColor(R.color.cp_cont_a));
        }
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.esS, this.esT, ap.getColor(R.color.cp_cont_h_alpha66));
        if (this.esN) {
            this.esN = false;
            requestLayout();
        }
        invalidate();
    }

    public void setShadowEnabled(boolean z) {
        this.etd = z;
    }
}
