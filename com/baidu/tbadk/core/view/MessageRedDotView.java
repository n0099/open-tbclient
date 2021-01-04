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
    private int bHI;
    private Paint bjo;
    private int fjA;
    private int fjk;
    private boolean fjl;
    private String fjm;
    private int fjn;
    private Rect fjo;
    private int fjp;
    private int fjq;
    private int fjr;
    private RectF fjs;
    private int fjt;
    private int fju;
    private int fjv;
    private int fjw;
    private Paint fjx;
    private RectF fjy;
    private boolean fjz;
    private Drawable mBackgroundDrawable;
    private Paint mShadowPaint;
    private int mShadowRadius;
    private int mType;
    private boolean shadowEnabled;

    public MessageRedDotView(@NonNull Context context) {
        super(context);
        this.mType = 1;
        this.fjz = false;
        this.shadowEnabled = false;
        this.fjA = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 1;
        this.fjz = false;
        this.shadowEnabled = false;
        this.fjA = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 1;
        this.fjz = false;
        this.shadowEnabled = false;
        this.fjA = 3;
        initView();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mBackgroundDrawable != null) {
            this.fjt = this.fjq >= this.fjr ? this.mShadowRadius + this.fjq : this.mShadowRadius + this.fjr;
            setMeasuredDimension(this.mBackgroundDrawable.getIntrinsicWidth() + (this.fjt * 2), this.mBackgroundDrawable.getIntrinsicHeight() + (this.fjt * 2));
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
            if (this.fjz) {
                this.mBackgroundDrawable.setBounds(0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds4) + intrinsicWidth, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds4) + intrinsicHeight);
            } else {
                this.mBackgroundDrawable.setBounds(this.fjt, this.fjt, this.fjt + intrinsicWidth, this.fjt + intrinsicHeight);
            }
            this.mBackgroundDrawable.draw(canvas);
            if (!this.fjz && this.shadowEnabled) {
                this.fjs.set(this.fjt, this.fjt, this.fjt + intrinsicWidth, this.fjt + intrinsicHeight);
                if (intrinsicWidth != intrinsicHeight) {
                    canvas.drawRoundRect(this.fjs, this.fju, this.fju, this.mShadowPaint);
                } else {
                    canvas.drawOval(this.fjs, this.mShadowPaint);
                }
            }
            if (!at.isEmpty(this.fjm)) {
                if (this.fjm.equals(StringHelper.STRING_MORE)) {
                    L(canvas);
                } else {
                    M(canvas);
                }
            }
        }
    }

    private void L(Canvas canvas) {
        if (this.mBackgroundDrawable != null) {
            int intrinsicWidth = this.fjt + (this.mBackgroundDrawable.getIntrinsicWidth() / 2);
            int intrinsicHeight = (this.mBackgroundDrawable.getIntrinsicHeight() / 2) + this.fjt;
            if (this.fjz) {
                Rect bounds = this.mBackgroundDrawable.getBounds();
                intrinsicWidth = bounds.width() / 2;
                intrinsicHeight = bounds.height() / 2;
            }
            int i = intrinsicWidth - (this.fjv / 2);
            int i2 = intrinsicHeight - (this.fjv / 2);
            int i3 = intrinsicWidth + (this.fjv / 2);
            int i4 = intrinsicHeight + (this.fjv / 2);
            this.fjy.set(i, i2, i3, i4);
            canvas.drawOval(this.fjy, this.fjx);
            this.fjy.set((i - this.fjw) - this.fjv, i2, i - this.fjw, i4);
            canvas.drawOval(this.fjy, this.fjx);
            this.fjy.set(this.fjw + i3, i2, i3 + this.fjw + this.fjv, i4);
            canvas.drawOval(this.fjy, this.fjx);
        }
    }

    private void M(Canvas canvas) {
        if (!at.isEmpty(this.fjm) && this.mBackgroundDrawable != null) {
            this.bjo.getTextBounds(this.fjm, 0, this.fjm.length(), this.fjo);
            Paint.FontMetrics fontMetrics = this.bjo.getFontMetrics();
            int intrinsicWidth = this.fjt + (this.mBackgroundDrawable.getIntrinsicWidth() / 2);
            float dimension = (getResources().getDimension(R.dimen.tbds10) + fontMetrics.bottom) - fontMetrics.ascent;
            if (this.fjz) {
                Rect bounds = this.mBackgroundDrawable.getBounds();
                intrinsicWidth = bounds.width() / 2;
                dimension = (bounds.height() / 2) - (fontMetrics.descent - ((fontMetrics.descent + (-fontMetrics.ascent)) / 2.0f));
            }
            canvas.drawText(this.fjm, intrinsicWidth, dimension, this.bjo);
        }
    }

    private void initView() {
        setLayerType(1, null);
        bxu();
        this.bjo = new Paint(1);
        this.bjo.setColor(ao.getColor(R.color.CAM_X0101));
        if (this.fjz || !this.shadowEnabled) {
            this.bjo.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize28));
            this.bjo.setTypeface(Typeface.DEFAULT_BOLD);
        } else {
            this.bjo.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize26));
            this.bjo.setTypeface(Typeface.MONOSPACE);
        }
        this.bjo.setTextAlign(Paint.Align.CENTER);
        this.fjo = new Rect();
        this.bHI = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds13);
        this.fjp = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setStyle(Paint.Style.FILL);
        this.mShadowPaint.setColor(ao.getColor(R.color.transparent));
        this.fjq = 0;
        this.mShadowRadius = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.fjr = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds3);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.fjq, this.fjr, ao.getColor(R.color.cp_cont_h_alpha66));
        this.fjs = new RectF();
        this.fju = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds21);
        this.fjv = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.fjw = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6);
        this.fjx = new Paint();
        this.fjx.setAntiAlias(true);
        this.fjx.setStyle(Paint.Style.FILL);
        this.fjx.setColor(ao.getColor(R.color.CAM_X0101));
        this.fjy = new RectF();
    }

    private void bxu() {
        String str = Build.MODEL;
        if (str.contains(RomUtils.MANUFACTURER_VIVO) && str.contains("X20")) {
            this.fjn = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds2);
        }
    }

    @Deprecated
    public void refresh(int i) {
        int i2;
        if (i <= 0) {
            i2 = R.drawable.icon_news_red_dot;
            this.fjm = null;
        } else if (i < 10) {
            this.fjm = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_one_number;
        } else if (i < 100) {
            this.fjm = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_two_number;
        } else if (this.mType == 1) {
            this.fjm = StringHelper.STRING_MORE;
            i2 = R.drawable.icon_news_red_dot_three_dot_number;
        } else if (this.mType == 2) {
            this.fjm = "99+";
            i2 = R.drawable.icon_news_red_dot_three_number;
        } else {
            i2 = 0;
        }
        if (i2 != this.fjk) {
            this.fjl = true;
        } else {
            this.fjl = false;
        }
        this.fjk = i2;
        onChangeSkinType();
    }

    public void setThreeDotMode(int i) {
        this.mType = i;
    }

    public void setEnterForumStyle(boolean z) {
        this.fjz = z;
    }

    public void onChangeSkinType() {
        this.fjA = TbadkApplication.getInst().getSkinType();
        if (this.fjk > 0) {
            this.mBackgroundDrawable = ao.getDrawable(this.fjk);
        } else if (this.mBackgroundDrawable instanceof GradientDrawable) {
            ((GradientDrawable) this.mBackgroundDrawable).setColor(ao.getColor(R.color.CAM_X0301));
        }
        this.fjx.setColor(ao.getColor(R.color.CAM_X0101));
        if (this.bjo != null) {
            this.bjo.setColor(ao.getColor(R.color.CAM_X0101));
        }
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.fjq, this.fjr, ao.getColor(R.color.cp_cont_h_alpha66));
        if (this.fjl) {
            this.fjl = false;
            requestLayout();
        }
        invalidate();
    }

    public void setShadowEnabled(boolean z) {
        this.shadowEnabled = z;
    }
}
