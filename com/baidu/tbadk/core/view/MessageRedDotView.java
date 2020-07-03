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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class MessageRedDotView extends View {
    private int beu;
    private int eaL;
    private boolean eaM;
    private String eaN;
    private int eaO;
    private Rect eaP;
    private int eaQ;
    private int eaR;
    private int eaS;
    private RectF eaT;
    private int eaU;
    private int eaV;
    private int eaW;
    private int eaX;
    private Paint eaY;
    private RectF eaZ;
    private boolean eba;
    private int ebb;
    private Drawable mBackgroundDrawable;
    private Paint mShadowPaint;
    private int mShadowRadius;
    private Paint mTextPaint;
    private int mType;

    public MessageRedDotView(@NonNull Context context) {
        super(context);
        this.mType = 1;
        this.eba = false;
        this.ebb = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 1;
        this.eba = false;
        this.ebb = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 1;
        this.eba = false;
        this.ebb = 3;
        initView();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mBackgroundDrawable != null) {
            this.eaU = this.eaR >= this.eaS ? this.mShadowRadius + this.eaR : this.mShadowRadius + this.eaS;
            setMeasuredDimension(this.mBackgroundDrawable.getIntrinsicWidth() + (this.eaU * 2), this.mBackgroundDrawable.getIntrinsicHeight() + (this.eaU * 2));
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
            if (this.eba) {
                this.mBackgroundDrawable.setBounds(0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds4) + intrinsicWidth, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds4) + intrinsicHeight);
            } else {
                this.mBackgroundDrawable.setBounds(this.eaU, this.eaU, this.eaU + intrinsicWidth, this.eaU + intrinsicHeight);
            }
            this.mBackgroundDrawable.draw(canvas);
            if (!this.eba) {
                this.eaT.set(this.eaU, this.eaU, this.eaU + intrinsicWidth, this.eaU + intrinsicHeight);
                if (intrinsicWidth != intrinsicHeight) {
                    canvas.drawRoundRect(this.eaT, this.eaV, this.eaV, this.mShadowPaint);
                } else {
                    canvas.drawOval(this.eaT, this.mShadowPaint);
                }
            }
            if (!ar.isEmpty(this.eaN)) {
                if (this.eaN.equals(StringHelper.STRING_MORE)) {
                    y(canvas);
                } else {
                    z(canvas);
                }
            }
        }
    }

    private void y(Canvas canvas) {
        if (this.mBackgroundDrawable != null) {
            int intrinsicWidth = this.eaU + (this.mBackgroundDrawable.getIntrinsicWidth() / 2);
            int intrinsicHeight = (this.mBackgroundDrawable.getIntrinsicHeight() / 2) + this.eaU;
            if (this.eba) {
                Rect bounds = this.mBackgroundDrawable.getBounds();
                intrinsicWidth = bounds.width() / 2;
                intrinsicHeight = bounds.height() / 2;
            }
            int i = intrinsicWidth - (this.eaW / 2);
            int i2 = intrinsicHeight - (this.eaW / 2);
            int i3 = intrinsicWidth + (this.eaW / 2);
            int i4 = intrinsicHeight + (this.eaW / 2);
            this.eaZ.set(i, i2, i3, i4);
            canvas.drawOval(this.eaZ, this.eaY);
            this.eaZ.set((i - this.eaX) - this.eaW, i2, i - this.eaX, i4);
            canvas.drawOval(this.eaZ, this.eaY);
            this.eaZ.set(this.eaX + i3, i2, i3 + this.eaX + this.eaW, i4);
            canvas.drawOval(this.eaZ, this.eaY);
        }
    }

    private void z(Canvas canvas) {
        if (!ar.isEmpty(this.eaN) && this.mBackgroundDrawable != null) {
            this.mTextPaint.getTextBounds(this.eaN, 0, this.eaN.length(), this.eaP);
            Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
            int intrinsicWidth = this.eaU + (this.mBackgroundDrawable.getIntrinsicWidth() / 2);
            float dimension = (getResources().getDimension(R.dimen.tbds10) + fontMetrics.bottom) - fontMetrics.ascent;
            if (this.eba) {
                Rect bounds = this.mBackgroundDrawable.getBounds();
                intrinsicWidth = bounds.width() / 2;
                dimension = (bounds.height() / 2) - (fontMetrics.descent - ((fontMetrics.descent + (-fontMetrics.ascent)) / 2.0f));
            }
            canvas.drawText(this.eaN, intrinsicWidth, dimension, this.mTextPaint);
        }
    }

    private void initView() {
        setLayerType(1, null);
        aXS();
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setColor(an.getColor(R.color.cp_cont_a));
        if (this.eba) {
            this.mTextPaint.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize28));
            this.mTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
        } else {
            this.mTextPaint.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize26));
            this.mTextPaint.setTypeface(Typeface.MONOSPACE);
        }
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.eaP = new Rect();
        this.beu = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds13);
        this.eaQ = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setStyle(Paint.Style.FILL);
        this.mShadowPaint.setColor(an.getColor(R.color.transparent));
        this.eaR = 0;
        this.mShadowRadius = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.eaS = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds3);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.eaR, this.eaS, an.getColor(R.color.cp_cont_h_alpha66));
        this.eaT = new RectF();
        this.eaV = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds21);
        this.eaW = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.eaX = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6);
        this.eaY = new Paint();
        this.eaY.setAntiAlias(true);
        this.eaY.setStyle(Paint.Style.FILL);
        this.eaY.setColor(an.getColor(R.color.cp_cont_a));
        this.eaZ = new RectF();
    }

    private void aXS() {
        String str = Build.MODEL;
        if (str.contains(RomUtils.MANUFACTURER_VIVO) && str.contains("X20")) {
            this.eaO = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds2);
        }
    }

    @Deprecated
    public void refresh(int i) {
        int i2;
        if (i <= 0) {
            i2 = R.drawable.icon_news_red_dot;
            this.eaN = null;
        } else if (i < 10) {
            this.eaN = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_one_number;
        } else if (i < 100) {
            this.eaN = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_two_number;
        } else if (this.mType == 1) {
            this.eaN = StringHelper.STRING_MORE;
            i2 = R.drawable.icon_news_red_dot_three_dot_number;
        } else if (this.mType == 2) {
            this.eaN = "99+";
            i2 = R.drawable.icon_news_red_dot_three_number;
        } else {
            i2 = 0;
        }
        if (i2 != this.eaL) {
            this.eaM = true;
        } else {
            this.eaM = false;
        }
        this.eaL = i2;
        onChangeSkinType();
    }

    public void setThreeDotMode(int i) {
        this.mType = i;
    }

    public void setEnterForumStyle(boolean z) {
        this.eba = z;
    }

    public void onChangeSkinType() {
        this.ebb = TbadkApplication.getInst().getSkinType();
        if (this.eaL > 0) {
            this.mBackgroundDrawable = an.getDrawable(this.eaL);
        } else if (this.mBackgroundDrawable instanceof GradientDrawable) {
            ((GradientDrawable) this.mBackgroundDrawable).setColor(an.getColor(R.color.cp_cont_h));
        }
        this.eaY.setColor(an.getColor(R.color.cp_cont_a));
        if (this.mTextPaint != null) {
            this.mTextPaint.setColor(an.getColor(R.color.cp_cont_a));
        }
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.eaR, this.eaS, an.getColor(R.color.cp_cont_h_alpha66));
        if (this.eaM) {
            this.eaM = false;
            requestLayout();
        }
        invalidate();
    }
}
