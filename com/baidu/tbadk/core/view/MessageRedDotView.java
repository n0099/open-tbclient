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
    private int aRU;
    private Paint dFA;
    private RectF dFB;
    private boolean dFC;
    private int dFD;
    private int dFn;
    private boolean dFo;
    private String dFp;
    private int dFq;
    private Rect dFr;
    private int dFs;
    private int dFt;
    private int dFu;
    private RectF dFv;
    private int dFw;
    private int dFx;
    private int dFy;
    private int dFz;
    private Drawable mBackgroundDrawable;
    private Paint mShadowPaint;
    private int mShadowRadius;
    private Paint mTextPaint;
    private int mType;

    public MessageRedDotView(@NonNull Context context) {
        super(context);
        this.mType = 1;
        this.dFC = false;
        this.dFD = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 1;
        this.dFC = false;
        this.dFD = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 1;
        this.dFC = false;
        this.dFD = 3;
        initView();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mBackgroundDrawable != null) {
            this.dFw = this.dFt >= this.dFu ? this.mShadowRadius + this.dFt : this.mShadowRadius + this.dFu;
            setMeasuredDimension(this.mBackgroundDrawable.getIntrinsicWidth() + (this.dFw * 2), this.mBackgroundDrawable.getIntrinsicHeight() + (this.dFw * 2));
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
            if (this.dFC) {
                this.mBackgroundDrawable.setBounds(0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds4) + intrinsicWidth, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds4) + intrinsicHeight);
            } else {
                this.mBackgroundDrawable.setBounds(this.dFw, this.dFw, this.dFw + intrinsicWidth, this.dFw + intrinsicHeight);
            }
            this.mBackgroundDrawable.draw(canvas);
            if (!this.dFC) {
                this.dFv.set(this.dFw, this.dFw, this.dFw + intrinsicWidth, this.dFw + intrinsicHeight);
                if (intrinsicWidth != intrinsicHeight) {
                    canvas.drawRoundRect(this.dFv, this.dFx, this.dFx, this.mShadowPaint);
                } else {
                    canvas.drawOval(this.dFv, this.mShadowPaint);
                }
            }
            if (!aq.isEmpty(this.dFp)) {
                if (this.dFp.equals(StringHelper.STRING_MORE)) {
                    x(canvas);
                } else {
                    y(canvas);
                }
            }
        }
    }

    private void x(Canvas canvas) {
        if (this.mBackgroundDrawable != null) {
            int intrinsicWidth = this.dFw + (this.mBackgroundDrawable.getIntrinsicWidth() / 2);
            int intrinsicHeight = (this.mBackgroundDrawable.getIntrinsicHeight() / 2) + this.dFw;
            if (this.dFC) {
                Rect bounds = this.mBackgroundDrawable.getBounds();
                intrinsicWidth = bounds.width() / 2;
                intrinsicHeight = bounds.height() / 2;
            }
            int i = intrinsicWidth - (this.dFy / 2);
            int i2 = intrinsicHeight - (this.dFy / 2);
            int i3 = intrinsicWidth + (this.dFy / 2);
            int i4 = intrinsicHeight + (this.dFy / 2);
            this.dFB.set(i, i2, i3, i4);
            canvas.drawOval(this.dFB, this.dFA);
            this.dFB.set((i - this.dFz) - this.dFy, i2, i - this.dFz, i4);
            canvas.drawOval(this.dFB, this.dFA);
            this.dFB.set(this.dFz + i3, i2, i3 + this.dFz + this.dFy, i4);
            canvas.drawOval(this.dFB, this.dFA);
        }
    }

    private void y(Canvas canvas) {
        if (!aq.isEmpty(this.dFp) && this.mBackgroundDrawable != null) {
            this.mTextPaint.getTextBounds(this.dFp, 0, this.dFp.length(), this.dFr);
            Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
            int intrinsicWidth = this.dFw + (this.mBackgroundDrawable.getIntrinsicWidth() / 2);
            float dimension = (getResources().getDimension(R.dimen.tbds10) + fontMetrics.bottom) - fontMetrics.ascent;
            if (this.dFC) {
                Rect bounds = this.mBackgroundDrawable.getBounds();
                intrinsicWidth = bounds.width() / 2;
                dimension = (bounds.height() / 2) - (fontMetrics.descent - ((fontMetrics.descent + (-fontMetrics.ascent)) / 2.0f));
            }
            canvas.drawText(this.dFp, intrinsicWidth, dimension, this.mTextPaint);
        }
    }

    private void initView() {
        setLayerType(1, null);
        aPW();
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setColor(am.getColor(R.color.cp_cont_a));
        if (this.dFC) {
            this.mTextPaint.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize28));
            this.mTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
        } else {
            this.mTextPaint.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize26));
            this.mTextPaint.setTypeface(Typeface.MONOSPACE);
        }
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.dFr = new Rect();
        this.aRU = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds13);
        this.dFs = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setStyle(Paint.Style.FILL);
        this.mShadowPaint.setColor(am.getColor(R.color.transparent));
        this.dFt = 0;
        this.mShadowRadius = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.dFu = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds3);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.dFt, this.dFu, am.getColor(R.color.cp_cont_h_alpha66));
        this.dFv = new RectF();
        this.dFx = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds21);
        this.dFy = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.dFz = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6);
        this.dFA = new Paint();
        this.dFA.setAntiAlias(true);
        this.dFA.setStyle(Paint.Style.FILL);
        this.dFA.setColor(am.getColor(R.color.cp_cont_a));
        this.dFB = new RectF();
    }

    private void aPW() {
        String str = Build.MODEL;
        if (str.contains(RomUtils.MANUFACTURER_VIVO) && str.contains("X20")) {
            this.dFq = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds2);
        }
    }

    @Deprecated
    public void refresh(int i) {
        int i2;
        if (i <= 0) {
            i2 = R.drawable.icon_news_red_dot;
            this.dFp = null;
        } else if (i < 10) {
            this.dFp = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_one_number;
        } else if (i < 100) {
            this.dFp = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_two_number;
        } else if (this.mType == 1) {
            this.dFp = StringHelper.STRING_MORE;
            i2 = R.drawable.icon_news_red_dot_three_dot_number;
        } else if (this.mType == 2) {
            this.dFp = "99+";
            i2 = R.drawable.icon_news_red_dot_three_number;
        } else {
            i2 = 0;
        }
        if (i2 != this.dFn) {
            this.dFo = true;
        } else {
            this.dFo = false;
        }
        this.dFn = i2;
        onChangeSkinType();
    }

    public void setThreeDotMode(int i) {
        this.mType = i;
    }

    public void setEnterForumStyle(boolean z) {
        this.dFC = z;
    }

    public void onChangeSkinType() {
        this.dFD = TbadkApplication.getInst().getSkinType();
        if (this.dFn > 0) {
            this.mBackgroundDrawable = am.getDrawable(this.dFn);
        } else if (this.mBackgroundDrawable instanceof GradientDrawable) {
            ((GradientDrawable) this.mBackgroundDrawable).setColor(am.getColor(R.color.cp_cont_h));
        }
        this.dFA.setColor(am.getColor(R.color.cp_cont_a));
        if (this.mTextPaint != null) {
            this.mTextPaint.setColor(am.getColor(R.color.cp_cont_a));
        }
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.dFt, this.dFu, am.getColor(R.color.cp_cont_h_alpha66));
        if (this.dFo) {
            this.dFo = false;
            requestLayout();
        }
        invalidate();
    }
}
