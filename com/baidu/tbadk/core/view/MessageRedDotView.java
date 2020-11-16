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
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class MessageRedDotView extends View {
    private int bxO;
    private boolean eSA;
    private int eSB;
    private int eSk;
    private boolean eSl;
    private String eSm;
    private int eSn;
    private Rect eSo;
    private int eSp;
    private int eSq;
    private int eSr;
    private RectF eSs;
    private int eSt;
    private int eSu;
    private int eSv;
    private int eSw;
    private Paint eSx;
    private RectF eSy;
    private boolean eSz;
    private Drawable mBackgroundDrawable;
    private Paint mShadowPaint;
    private int mShadowRadius;
    private Paint mTextPaint;
    private int mType;

    public MessageRedDotView(@NonNull Context context) {
        super(context);
        this.mType = 1;
        this.eSz = false;
        this.eSA = false;
        this.eSB = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 1;
        this.eSz = false;
        this.eSA = false;
        this.eSB = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 1;
        this.eSz = false;
        this.eSA = false;
        this.eSB = 3;
        initView();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mBackgroundDrawable != null) {
            this.eSt = this.eSq >= this.eSr ? this.mShadowRadius + this.eSq : this.mShadowRadius + this.eSr;
            setMeasuredDimension(this.mBackgroundDrawable.getIntrinsicWidth() + (this.eSt * 2), this.mBackgroundDrawable.getIntrinsicHeight() + (this.eSt * 2));
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
            if (this.eSz) {
                this.mBackgroundDrawable.setBounds(0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds4) + intrinsicWidth, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds4) + intrinsicHeight);
            } else {
                this.mBackgroundDrawable.setBounds(this.eSt, this.eSt, this.eSt + intrinsicWidth, this.eSt + intrinsicHeight);
            }
            this.mBackgroundDrawable.draw(canvas);
            if (!this.eSz && this.eSA) {
                this.eSs.set(this.eSt, this.eSt, this.eSt + intrinsicWidth, this.eSt + intrinsicHeight);
                if (intrinsicWidth != intrinsicHeight) {
                    canvas.drawRoundRect(this.eSs, this.eSu, this.eSu, this.mShadowPaint);
                } else {
                    canvas.drawOval(this.eSs, this.mShadowPaint);
                }
            }
            if (!au.isEmpty(this.eSm)) {
                if (this.eSm.equals(StringHelper.STRING_MORE)) {
                    E(canvas);
                } else {
                    F(canvas);
                }
            }
        }
    }

    private void E(Canvas canvas) {
        if (this.mBackgroundDrawable != null) {
            int intrinsicWidth = this.eSt + (this.mBackgroundDrawable.getIntrinsicWidth() / 2);
            int intrinsicHeight = (this.mBackgroundDrawable.getIntrinsicHeight() / 2) + this.eSt;
            if (this.eSz) {
                Rect bounds = this.mBackgroundDrawable.getBounds();
                intrinsicWidth = bounds.width() / 2;
                intrinsicHeight = bounds.height() / 2;
            }
            int i = intrinsicWidth - (this.eSv / 2);
            int i2 = intrinsicHeight - (this.eSv / 2);
            int i3 = intrinsicWidth + (this.eSv / 2);
            int i4 = intrinsicHeight + (this.eSv / 2);
            this.eSy.set(i, i2, i3, i4);
            canvas.drawOval(this.eSy, this.eSx);
            this.eSy.set((i - this.eSw) - this.eSv, i2, i - this.eSw, i4);
            canvas.drawOval(this.eSy, this.eSx);
            this.eSy.set(this.eSw + i3, i2, i3 + this.eSw + this.eSv, i4);
            canvas.drawOval(this.eSy, this.eSx);
        }
    }

    private void F(Canvas canvas) {
        if (!au.isEmpty(this.eSm) && this.mBackgroundDrawable != null) {
            this.mTextPaint.getTextBounds(this.eSm, 0, this.eSm.length(), this.eSo);
            Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
            int intrinsicWidth = this.eSt + (this.mBackgroundDrawable.getIntrinsicWidth() / 2);
            float dimension = (getResources().getDimension(R.dimen.tbds10) + fontMetrics.bottom) - fontMetrics.ascent;
            if (this.eSz) {
                Rect bounds = this.mBackgroundDrawable.getBounds();
                intrinsicWidth = bounds.width() / 2;
                dimension = (bounds.height() / 2) - (fontMetrics.descent - ((fontMetrics.descent + (-fontMetrics.ascent)) / 2.0f));
            }
            canvas.drawText(this.eSm, intrinsicWidth, dimension, this.mTextPaint);
        }
    }

    private void initView() {
        setLayerType(1, null);
        brA();
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setColor(ap.getColor(R.color.CAM_X0101));
        if (this.eSz || !this.eSA) {
            this.mTextPaint.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize28));
            this.mTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
        } else {
            this.mTextPaint.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize26));
            this.mTextPaint.setTypeface(Typeface.MONOSPACE);
        }
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.eSo = new Rect();
        this.bxO = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds13);
        this.eSp = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setStyle(Paint.Style.FILL);
        this.mShadowPaint.setColor(ap.getColor(R.color.transparent));
        this.eSq = 0;
        this.mShadowRadius = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.eSr = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds3);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.eSq, this.eSr, ap.getColor(R.color.cp_cont_h_alpha66));
        this.eSs = new RectF();
        this.eSu = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds21);
        this.eSv = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.eSw = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6);
        this.eSx = new Paint();
        this.eSx.setAntiAlias(true);
        this.eSx.setStyle(Paint.Style.FILL);
        this.eSx.setColor(ap.getColor(R.color.CAM_X0101));
        this.eSy = new RectF();
    }

    private void brA() {
        String str = Build.MODEL;
        if (str.contains(RomUtils.MANUFACTURER_VIVO) && str.contains("X20")) {
            this.eSn = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds2);
        }
    }

    @Deprecated
    public void refresh(int i) {
        int i2;
        if (i <= 0) {
            i2 = R.drawable.icon_news_red_dot;
            this.eSm = null;
        } else if (i < 10) {
            this.eSm = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_one_number;
        } else if (i < 100) {
            this.eSm = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_two_number;
        } else if (this.mType == 1) {
            this.eSm = StringHelper.STRING_MORE;
            i2 = R.drawable.icon_news_red_dot_three_dot_number;
        } else if (this.mType == 2) {
            this.eSm = "99+";
            i2 = R.drawable.icon_news_red_dot_three_number;
        } else {
            i2 = 0;
        }
        if (i2 != this.eSk) {
            this.eSl = true;
        } else {
            this.eSl = false;
        }
        this.eSk = i2;
        onChangeSkinType();
    }

    public void setThreeDotMode(int i) {
        this.mType = i;
    }

    public void setEnterForumStyle(boolean z) {
        this.eSz = z;
    }

    public void onChangeSkinType() {
        this.eSB = TbadkApplication.getInst().getSkinType();
        if (this.eSk > 0) {
            this.mBackgroundDrawable = ap.getDrawable(this.eSk);
        } else if (this.mBackgroundDrawable instanceof GradientDrawable) {
            ((GradientDrawable) this.mBackgroundDrawable).setColor(ap.getColor(R.color.CAM_X0301));
        }
        this.eSx.setColor(ap.getColor(R.color.CAM_X0101));
        if (this.mTextPaint != null) {
            this.mTextPaint.setColor(ap.getColor(R.color.CAM_X0101));
        }
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.eSq, this.eSr, ap.getColor(R.color.cp_cont_h_alpha66));
        if (this.eSl) {
            this.eSl = false;
            requestLayout();
        }
        invalidate();
    }

    public void setShadowEnabled(boolean z) {
        this.eSA = z;
    }
}
