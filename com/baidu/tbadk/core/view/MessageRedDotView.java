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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class MessageRedDotView extends View {
    private int bIg;
    private Paint bjh;
    private int fiA;
    private int fiB;
    private int fiC;
    private int fiD;
    private Paint fiE;
    private RectF fiF;
    private boolean fiG;
    private int fiH;
    private int fiq;
    private boolean fir;
    private String fis;
    private int fit;
    private Rect fiu;
    private int fiv;
    private int fiw;
    private int fiy;
    private RectF fiz;
    private Drawable mBackgroundDrawable;
    private Paint mShadowPaint;
    private int mShadowRadius;
    private int mType;
    private boolean shadowEnabled;

    public MessageRedDotView(@NonNull Context context) {
        super(context);
        this.mType = 1;
        this.fiG = false;
        this.shadowEnabled = false;
        this.fiH = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 1;
        this.fiG = false;
        this.shadowEnabled = false;
        this.fiH = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 1;
        this.fiG = false;
        this.shadowEnabled = false;
        this.fiH = 3;
        initView();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mBackgroundDrawable != null) {
            this.fiA = this.fiw >= this.fiy ? this.mShadowRadius + this.fiw : this.mShadowRadius + this.fiy;
            setMeasuredDimension(this.mBackgroundDrawable.getIntrinsicWidth() + (this.fiA * 2), this.mBackgroundDrawable.getIntrinsicHeight() + (this.fiA * 2));
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
            if (this.fiG) {
                this.mBackgroundDrawable.setBounds(0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds4) + intrinsicWidth, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds4) + intrinsicHeight);
            } else {
                this.mBackgroundDrawable.setBounds(this.fiA, this.fiA, this.fiA + intrinsicWidth, this.fiA + intrinsicHeight);
            }
            this.mBackgroundDrawable.draw(canvas);
            if (!this.fiG && this.shadowEnabled) {
                this.fiz.set(this.fiA, this.fiA, this.fiA + intrinsicWidth, this.fiA + intrinsicHeight);
                if (intrinsicWidth != intrinsicHeight) {
                    canvas.drawRoundRect(this.fiz, this.fiB, this.fiB, this.mShadowPaint);
                } else {
                    canvas.drawOval(this.fiz, this.mShadowPaint);
                }
            }
            if (!au.isEmpty(this.fis)) {
                if (this.fis.equals(StringHelper.STRING_MORE)) {
                    L(canvas);
                } else {
                    M(canvas);
                }
            }
        }
    }

    private void L(Canvas canvas) {
        if (this.mBackgroundDrawable != null) {
            int intrinsicWidth = this.fiA + (this.mBackgroundDrawable.getIntrinsicWidth() / 2);
            int intrinsicHeight = (this.mBackgroundDrawable.getIntrinsicHeight() / 2) + this.fiA;
            if (this.fiG) {
                Rect bounds = this.mBackgroundDrawable.getBounds();
                intrinsicWidth = bounds.width() / 2;
                intrinsicHeight = bounds.height() / 2;
            }
            int i = intrinsicWidth - (this.fiC / 2);
            int i2 = intrinsicHeight - (this.fiC / 2);
            int i3 = intrinsicWidth + (this.fiC / 2);
            int i4 = intrinsicHeight + (this.fiC / 2);
            this.fiF.set(i, i2, i3, i4);
            canvas.drawOval(this.fiF, this.fiE);
            this.fiF.set((i - this.fiD) - this.fiC, i2, i - this.fiD, i4);
            canvas.drawOval(this.fiF, this.fiE);
            this.fiF.set(this.fiD + i3, i2, i3 + this.fiD + this.fiC, i4);
            canvas.drawOval(this.fiF, this.fiE);
        }
    }

    private void M(Canvas canvas) {
        if (!au.isEmpty(this.fis) && this.mBackgroundDrawable != null) {
            this.bjh.getTextBounds(this.fis, 0, this.fis.length(), this.fiu);
            Paint.FontMetrics fontMetrics = this.bjh.getFontMetrics();
            int intrinsicWidth = this.fiA + (this.mBackgroundDrawable.getIntrinsicWidth() / 2);
            float dimension = (getResources().getDimension(R.dimen.tbds10) + fontMetrics.bottom) - fontMetrics.ascent;
            if (this.fiG) {
                Rect bounds = this.mBackgroundDrawable.getBounds();
                intrinsicWidth = bounds.width() / 2;
                dimension = (bounds.height() / 2) - (fontMetrics.descent - ((fontMetrics.descent + (-fontMetrics.ascent)) / 2.0f));
            }
            canvas.drawText(this.fis, intrinsicWidth, dimension, this.bjh);
        }
    }

    private void initView() {
        setLayerType(1, null);
        btY();
        this.bjh = new Paint(1);
        this.bjh.setColor(ap.getColor(R.color.CAM_X0101));
        if (this.fiG || !this.shadowEnabled) {
            this.bjh.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize28));
            this.bjh.setTypeface(Typeface.DEFAULT_BOLD);
        } else {
            this.bjh.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize26));
            this.bjh.setTypeface(Typeface.MONOSPACE);
        }
        this.bjh.setTextAlign(Paint.Align.CENTER);
        this.fiu = new Rect();
        this.bIg = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds13);
        this.fiv = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setStyle(Paint.Style.FILL);
        this.mShadowPaint.setColor(ap.getColor(R.color.transparent));
        this.fiw = 0;
        this.mShadowRadius = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.fiy = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds3);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.fiw, this.fiy, ap.getColor(R.color.cp_cont_h_alpha66));
        this.fiz = new RectF();
        this.fiB = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds21);
        this.fiC = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.fiD = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6);
        this.fiE = new Paint();
        this.fiE.setAntiAlias(true);
        this.fiE.setStyle(Paint.Style.FILL);
        this.fiE.setColor(ap.getColor(R.color.CAM_X0101));
        this.fiF = new RectF();
    }

    private void btY() {
        String str = Build.MODEL;
        if (str.contains(RomUtils.MANUFACTURER_VIVO) && str.contains("X20")) {
            this.fit = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds2);
        }
    }

    @Deprecated
    public void refresh(int i) {
        int i2;
        if (i <= 0) {
            i2 = R.drawable.icon_news_red_dot;
            this.fis = null;
        } else if (i < 10) {
            this.fis = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_one_number;
        } else if (i < 100) {
            this.fis = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_two_number;
        } else if (this.mType == 1) {
            this.fis = StringHelper.STRING_MORE;
            i2 = R.drawable.icon_news_red_dot_three_dot_number;
        } else if (this.mType == 2) {
            this.fis = "99+";
            i2 = R.drawable.icon_news_red_dot_three_number;
        } else {
            i2 = 0;
        }
        if (i2 != this.fiq) {
            this.fir = true;
        } else {
            this.fir = false;
        }
        this.fiq = i2;
        onChangeSkinType();
    }

    public void setThreeDotMode(int i) {
        this.mType = i;
    }

    public void setEnterForumStyle(boolean z) {
        this.fiG = z;
    }

    public void onChangeSkinType() {
        this.fiH = TbadkApplication.getInst().getSkinType();
        if (this.fiq > 0) {
            this.mBackgroundDrawable = ap.getDrawable(this.fiq);
        } else if (this.mBackgroundDrawable instanceof GradientDrawable) {
            ((GradientDrawable) this.mBackgroundDrawable).setColor(ap.getColor(R.color.CAM_X0301));
        }
        this.fiE.setColor(ap.getColor(R.color.CAM_X0101));
        if (this.bjh != null) {
            this.bjh.setColor(ap.getColor(R.color.CAM_X0101));
        }
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.fiw, this.fiy, ap.getColor(R.color.cp_cont_h_alpha66));
        if (this.fir) {
            this.fir = false;
            requestLayout();
        }
        invalidate();
    }

    public void setShadowEnabled(boolean z) {
        this.shadowEnabled = z;
    }
}
