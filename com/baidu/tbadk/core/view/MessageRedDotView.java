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
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class MessageRedDotView extends View {
    private Paint aiW;
    private int akT;
    private int cnN;
    private boolean cnO;
    private String cnP;
    private int cnQ;
    private Rect cnR;
    private int cnS;
    private int cnT;
    private int cnU;
    private RectF cnV;
    private int cnW;
    private int cnX;
    private int cnY;
    private int cnZ;
    private Paint coa;
    private RectF cob;
    private int coc;
    private Drawable mBackgroundDrawable;
    private Paint mShadowPaint;
    private int mShadowRadius;
    private int mType;

    public MessageRedDotView(@NonNull Context context) {
        super(context);
        this.mType = 1;
        this.coc = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 1;
        this.coc = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 1;
        this.coc = 3;
        initView();
    }

    @RequiresApi(api = 21)
    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mType = 1;
        this.coc = 3;
        initView();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mBackgroundDrawable != null) {
            this.cnW = this.cnT >= this.cnU ? this.mShadowRadius + this.cnT : this.mShadowRadius + this.cnU;
            setMeasuredDimension(this.mBackgroundDrawable.getIntrinsicWidth() + (this.cnW * 2), this.mBackgroundDrawable.getIntrinsicHeight() + (this.cnW * 2));
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
            this.mBackgroundDrawable.setBounds(this.cnW, this.cnW, this.cnW + intrinsicWidth, this.cnW + intrinsicHeight);
            this.mBackgroundDrawable.draw(canvas);
            this.cnV.set(this.cnW, this.cnW, this.cnW + intrinsicWidth, this.cnW + intrinsicHeight);
            if (intrinsicWidth != intrinsicHeight) {
                canvas.drawRoundRect(this.cnV, this.cnX, this.cnX, this.mShadowPaint);
            } else {
                canvas.drawOval(this.cnV, this.mShadowPaint);
            }
            if (!aq.isEmpty(this.cnP)) {
                if (this.cnP.equals(StringHelper.STRING_MORE)) {
                    A(canvas);
                } else {
                    B(canvas);
                }
            }
        }
    }

    private void A(Canvas canvas) {
        if (this.mBackgroundDrawable != null) {
            int intrinsicWidth = (this.mBackgroundDrawable.getIntrinsicWidth() / 2) + this.cnW;
            int intrinsicHeight = (this.mBackgroundDrawable.getIntrinsicHeight() / 2) + this.cnW;
            int i = intrinsicWidth - (this.cnY / 2);
            int i2 = intrinsicHeight - (this.cnY / 2);
            int i3 = intrinsicWidth + (this.cnY / 2);
            int i4 = intrinsicHeight + (this.cnY / 2);
            this.cob.set(i, i2, i3, i4);
            canvas.drawOval(this.cob, this.coa);
            this.cob.set((i - this.cnZ) - this.cnY, i2, i - this.cnZ, i4);
            canvas.drawOval(this.cob, this.coa);
            this.cob.set(this.cnZ + i3, i2, i3 + this.cnZ + this.cnY, i4);
            canvas.drawOval(this.cob, this.coa);
        }
    }

    private void B(Canvas canvas) {
        if (!aq.isEmpty(this.cnP) && this.mBackgroundDrawable != null) {
            this.aiW.getTextBounds(this.cnP, 0, this.cnP.length(), this.cnR);
            Paint.FontMetrics fontMetrics = this.aiW.getFontMetrics();
            int intrinsicWidth = (this.mBackgroundDrawable.getIntrinsicWidth() / 2) + this.cnW;
            canvas.drawText(this.cnP, intrinsicWidth, (getResources().getDimension(R.dimen.tbds10) + fontMetrics.bottom) - fontMetrics.ascent, this.aiW);
        }
    }

    private void initView() {
        setLayerType(1, null);
        anC();
        this.aiW = new Paint(1);
        this.aiW.setColor(am.getColor(R.color.cp_cont_a));
        this.aiW.setTextSize(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbfontsize26));
        this.aiW.setTextAlign(Paint.Align.CENTER);
        this.aiW.setTypeface(Typeface.MONOSPACE);
        this.cnR = new Rect();
        this.akT = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds13);
        this.cnS = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds42);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setStyle(Paint.Style.FILL);
        this.mShadowPaint.setColor(am.getColor(R.color.transparent));
        this.cnT = 0;
        this.mShadowRadius = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.cnU = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds3);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.cnT, this.cnU, am.getColor(R.color.cp_cont_h_alpha66));
        this.cnV = new RectF();
        this.cnX = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds21);
        this.cnY = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds8);
        this.cnZ = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6);
        this.coa = new Paint();
        this.coa.setAntiAlias(true);
        this.coa.setStyle(Paint.Style.FILL);
        this.coa.setColor(am.getColor(R.color.cp_cont_a));
        this.cob = new RectF();
    }

    private void anC() {
        String str = Build.MODEL;
        if (str.contains("vivo") && str.contains("X20")) {
            this.cnQ = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds2);
        }
    }

    @Deprecated
    public void refresh(int i) {
        int i2;
        if (i <= 0) {
            i2 = R.drawable.icon_news_red_dot;
            this.cnP = null;
        } else if (i < 10) {
            this.cnP = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_one_number;
        } else if (i < 100) {
            this.cnP = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_two_number;
        } else if (this.mType == 1) {
            this.cnP = StringHelper.STRING_MORE;
            i2 = R.drawable.icon_news_red_dot_three_dot_number;
        } else if (this.mType == 2) {
            this.cnP = "99+";
            i2 = R.drawable.icon_news_red_dot_three_number;
        } else {
            i2 = 0;
        }
        if (i2 != this.cnN) {
            this.cnO = true;
        } else {
            this.cnO = false;
        }
        this.cnN = i2;
        onChangeSkinType();
    }

    public void setThreeDotMode(int i) {
        this.mType = i;
    }

    public void onChangeSkinType() {
        this.coc = TbadkApplication.getInst().getSkinType();
        if (this.cnN > 0) {
            this.mBackgroundDrawable = am.getDrawable(this.cnN);
        } else if (this.mBackgroundDrawable instanceof GradientDrawable) {
            ((GradientDrawable) this.mBackgroundDrawable).setColor(am.getColor(R.color.cp_cont_h));
        }
        this.coa.setColor(am.getColor(R.color.cp_cont_a));
        if (this.aiW != null) {
            this.aiW.setColor(am.getColor(R.color.cp_cont_a));
        }
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.cnT, this.cnU, am.getColor(R.color.cp_cont_h_alpha66));
        if (this.cnO) {
            this.cnO = false;
            requestLayout();
        }
        invalidate();
    }
}
