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
    private int bGG;
    private Paint bhF;
    private int fgP;
    private boolean fgQ;
    private String fgR;
    private int fgS;
    private Rect fgT;
    private int fgU;
    private int fgV;
    private int fgW;
    private RectF fgX;
    private int fgY;
    private int fgZ;
    private int fha;
    private int fhb;
    private Paint fhc;
    private RectF fhd;
    private boolean fhe;
    private int fhf;
    private Drawable mBackgroundDrawable;
    private Paint mShadowPaint;
    private int mShadowRadius;
    private int mType;
    private boolean shadowEnabled;

    public MessageRedDotView(@NonNull Context context) {
        super(context);
        this.mType = 1;
        this.fhe = false;
        this.shadowEnabled = false;
        this.fhf = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 1;
        this.fhe = false;
        this.shadowEnabled = false;
        this.fhf = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 1;
        this.fhe = false;
        this.shadowEnabled = false;
        this.fhf = 3;
        initView();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mBackgroundDrawable != null) {
            this.fgY = this.fgV >= this.fgW ? this.mShadowRadius + this.fgV : this.mShadowRadius + this.fgW;
            setMeasuredDimension(this.mBackgroundDrawable.getIntrinsicWidth() + (this.fgY * 2), this.mBackgroundDrawable.getIntrinsicHeight() + (this.fgY * 2));
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
            if (this.fhe) {
                this.mBackgroundDrawable.setBounds(0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds4) + intrinsicWidth, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds4) + intrinsicHeight);
            } else {
                this.mBackgroundDrawable.setBounds(this.fgY, this.fgY, this.fgY + intrinsicWidth, this.fgY + intrinsicHeight);
            }
            this.mBackgroundDrawable.draw(canvas);
            if (!this.fhe && this.shadowEnabled) {
                this.fgX.set(this.fgY, this.fgY, this.fgY + intrinsicWidth, this.fgY + intrinsicHeight);
                if (intrinsicWidth != intrinsicHeight) {
                    canvas.drawRoundRect(this.fgX, this.fgZ, this.fgZ, this.mShadowPaint);
                } else {
                    canvas.drawOval(this.fgX, this.mShadowPaint);
                }
            }
            if (!au.isEmpty(this.fgR)) {
                if (this.fgR.equals(StringHelper.STRING_MORE)) {
                    L(canvas);
                } else {
                    M(canvas);
                }
            }
        }
    }

    private void L(Canvas canvas) {
        if (this.mBackgroundDrawable != null) {
            int intrinsicWidth = this.fgY + (this.mBackgroundDrawable.getIntrinsicWidth() / 2);
            int intrinsicHeight = (this.mBackgroundDrawable.getIntrinsicHeight() / 2) + this.fgY;
            if (this.fhe) {
                Rect bounds = this.mBackgroundDrawable.getBounds();
                intrinsicWidth = bounds.width() / 2;
                intrinsicHeight = bounds.height() / 2;
            }
            int i = intrinsicWidth - (this.fha / 2);
            int i2 = intrinsicHeight - (this.fha / 2);
            int i3 = intrinsicWidth + (this.fha / 2);
            int i4 = intrinsicHeight + (this.fha / 2);
            this.fhd.set(i, i2, i3, i4);
            canvas.drawOval(this.fhd, this.fhc);
            this.fhd.set((i - this.fhb) - this.fha, i2, i - this.fhb, i4);
            canvas.drawOval(this.fhd, this.fhc);
            this.fhd.set(this.fhb + i3, i2, i3 + this.fhb + this.fha, i4);
            canvas.drawOval(this.fhd, this.fhc);
        }
    }

    private void M(Canvas canvas) {
        if (!au.isEmpty(this.fgR) && this.mBackgroundDrawable != null) {
            this.bhF.getTextBounds(this.fgR, 0, this.fgR.length(), this.fgT);
            Paint.FontMetrics fontMetrics = this.bhF.getFontMetrics();
            int intrinsicWidth = this.fgY + (this.mBackgroundDrawable.getIntrinsicWidth() / 2);
            float dimension = (getResources().getDimension(R.dimen.tbds10) + fontMetrics.bottom) - fontMetrics.ascent;
            if (this.fhe) {
                Rect bounds = this.mBackgroundDrawable.getBounds();
                intrinsicWidth = bounds.width() / 2;
                dimension = (bounds.height() / 2) - (fontMetrics.descent - ((fontMetrics.descent + (-fontMetrics.ascent)) / 2.0f));
            }
            canvas.drawText(this.fgR, intrinsicWidth, dimension, this.bhF);
        }
    }

    private void initView() {
        setLayerType(1, null);
        btV();
        this.bhF = new Paint(1);
        this.bhF.setColor(ap.getColor(R.color.CAM_X0101));
        if (this.fhe || !this.shadowEnabled) {
            this.bhF.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize28));
            this.bhF.setTypeface(Typeface.DEFAULT_BOLD);
        } else {
            this.bhF.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize26));
            this.bhF.setTypeface(Typeface.MONOSPACE);
        }
        this.bhF.setTextAlign(Paint.Align.CENTER);
        this.fgT = new Rect();
        this.bGG = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds13);
        this.fgU = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setStyle(Paint.Style.FILL);
        this.mShadowPaint.setColor(ap.getColor(R.color.transparent));
        this.fgV = 0;
        this.mShadowRadius = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.fgW = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds3);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.fgV, this.fgW, ap.getColor(R.color.cp_cont_h_alpha66));
        this.fgX = new RectF();
        this.fgZ = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds21);
        this.fha = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.fhb = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6);
        this.fhc = new Paint();
        this.fhc.setAntiAlias(true);
        this.fhc.setStyle(Paint.Style.FILL);
        this.fhc.setColor(ap.getColor(R.color.CAM_X0101));
        this.fhd = new RectF();
    }

    private void btV() {
        String str = Build.MODEL;
        if (str.contains(RomUtils.MANUFACTURER_VIVO) && str.contains("X20")) {
            this.fgS = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds2);
        }
    }

    @Deprecated
    public void refresh(int i) {
        int i2;
        if (i <= 0) {
            i2 = R.drawable.icon_news_red_dot;
            this.fgR = null;
        } else if (i < 10) {
            this.fgR = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_one_number;
        } else if (i < 100) {
            this.fgR = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_two_number;
        } else if (this.mType == 1) {
            this.fgR = StringHelper.STRING_MORE;
            i2 = R.drawable.icon_news_red_dot_three_dot_number;
        } else if (this.mType == 2) {
            this.fgR = "99+";
            i2 = R.drawable.icon_news_red_dot_three_number;
        } else {
            i2 = 0;
        }
        if (i2 != this.fgP) {
            this.fgQ = true;
        } else {
            this.fgQ = false;
        }
        this.fgP = i2;
        onChangeSkinType();
    }

    public void setThreeDotMode(int i) {
        this.mType = i;
    }

    public void setEnterForumStyle(boolean z) {
        this.fhe = z;
    }

    public void onChangeSkinType() {
        this.fhf = TbadkApplication.getInst().getSkinType();
        if (this.fgP > 0) {
            this.mBackgroundDrawable = ap.getDrawable(this.fgP);
        } else if (this.mBackgroundDrawable instanceof GradientDrawable) {
            ((GradientDrawable) this.mBackgroundDrawable).setColor(ap.getColor(R.color.CAM_X0301));
        }
        this.fhc.setColor(ap.getColor(R.color.CAM_X0101));
        if (this.bhF != null) {
            this.bhF.setColor(ap.getColor(R.color.CAM_X0101));
        }
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.fgV, this.fgW, ap.getColor(R.color.cp_cont_h_alpha66));
        if (this.fgQ) {
            this.fgQ = false;
            requestLayout();
        }
        invalidate();
    }

    public void setShadowEnabled(boolean z) {
        this.shadowEnabled = z;
    }
}
