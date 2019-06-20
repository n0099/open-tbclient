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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class MessageRedDotView extends View {
    private Drawable Ma;
    private Paint bWu;
    private int bXY;
    private boolean bXZ;
    private String bYa;
    private int bYb;
    private Rect bYc;
    private int bYd;
    private int bYe;
    private int bYf;
    private int bYg;
    private RectF bYh;
    private int bYi;
    private int bYj;
    private int bYk;
    private int bYl;
    private Paint bYm;
    private RectF bYn;
    private int bYo;
    private Paint mShadowPaint;
    private int mShadowRadius;
    private int mType;

    public MessageRedDotView(@NonNull Context context) {
        super(context);
        this.mType = 1;
        this.bYo = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 1;
        this.bYo = 3;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 1;
        this.bYo = 3;
        initView();
    }

    @RequiresApi(api = 21)
    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mType = 1;
        this.bYo = 3;
        initView();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.Ma != null) {
            this.bYi = this.bYf >= this.bYg ? this.mShadowRadius + this.bYf : this.mShadowRadius + this.bYg;
            setMeasuredDimension(this.Ma.getIntrinsicWidth() + (this.bYi * 2), this.Ma.getIntrinsicHeight() + (this.bYi * 2));
            return;
        }
        setMeasuredDimension(0, 0);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.Ma != null) {
            int intrinsicWidth = this.Ma.getIntrinsicWidth();
            int intrinsicHeight = this.Ma.getIntrinsicHeight();
            this.Ma.setBounds(this.bYi, this.bYi, this.bYi + intrinsicWidth, this.bYi + intrinsicHeight);
            this.Ma.draw(canvas);
            this.bYh.set(this.bYi, this.bYi, this.bYi + intrinsicWidth, this.bYi + intrinsicHeight);
            if (intrinsicWidth != intrinsicHeight) {
                canvas.drawRoundRect(this.bYh, this.bYj, this.bYj, this.mShadowPaint);
            } else {
                canvas.drawOval(this.bYh, this.mShadowPaint);
            }
            if (!ap.isEmpty(this.bYa)) {
                if (this.bYa.equals("...")) {
                    x(canvas);
                } else {
                    y(canvas);
                }
            }
        }
    }

    private void x(Canvas canvas) {
        if (this.Ma != null) {
            int intrinsicWidth = (this.Ma.getIntrinsicWidth() / 2) + this.bYi;
            int intrinsicHeight = (this.Ma.getIntrinsicHeight() / 2) + this.bYi;
            int i = intrinsicWidth - (this.bYk / 2);
            int i2 = intrinsicHeight - (this.bYk / 2);
            int i3 = intrinsicWidth + (this.bYk / 2);
            int i4 = intrinsicHeight + (this.bYk / 2);
            this.bYn.set(i, i2, i3, i4);
            canvas.drawOval(this.bYn, this.bYm);
            this.bYn.set((i - this.bYl) - this.bYk, i2, i - this.bYl, i4);
            canvas.drawOval(this.bYn, this.bYm);
            this.bYn.set(this.bYl + i3, i2, i3 + this.bYl + this.bYk, i4);
            canvas.drawOval(this.bYn, this.bYm);
        }
    }

    private void y(Canvas canvas) {
        if (!ap.isEmpty(this.bYa) && this.Ma != null) {
            this.bWu.getTextBounds(this.bYa, 0, this.bYa.length(), this.bYc);
            Paint.FontMetrics fontMetrics = this.bWu.getFontMetrics();
            int intrinsicWidth = (this.Ma.getIntrinsicWidth() / 2) + this.bYi;
            canvas.drawText(this.bYa, intrinsicWidth, (getResources().getDimension(R.dimen.tbds10) + fontMetrics.bottom) - fontMetrics.ascent, this.bWu);
        }
    }

    private void initView() {
        setLayerType(1, null);
        ajo();
        this.bWu = new Paint(1);
        this.bWu.setColor(al.getColor(R.color.cp_btn_a));
        this.bWu.setTextSize(com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbfontsize26));
        this.bWu.setTextAlign(Paint.Align.CENTER);
        this.bWu.setTypeface(Typeface.MONOSPACE);
        this.bYc = new Rect();
        this.bYd = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds13);
        this.bYe = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds42);
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setStyle(Paint.Style.FILL);
        this.mShadowPaint.setColor(al.getColor(R.color.transparent));
        this.bYf = 0;
        this.mShadowRadius = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds8);
        this.bYg = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds3);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.bYf, this.bYg, al.getColor(R.color.cp_cont_h_alpha66));
        this.bYh = new RectF();
        this.bYj = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds21);
        this.bYk = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds8);
        this.bYl = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds6);
        this.bYm = new Paint();
        this.bYm.setAntiAlias(true);
        this.bYm.setStyle(Paint.Style.FILL);
        this.bYm.setColor(al.getColor(R.color.cp_btn_a));
        this.bYn = new RectF();
    }

    private void ajo() {
        String str = Build.MODEL;
        if (str.contains("vivo") && str.contains("X20")) {
            this.bYb = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds2);
        }
    }

    @Deprecated
    public void refresh(int i) {
        int i2;
        if (i <= 0) {
            i2 = R.drawable.icon_news_red_dot;
            this.bYa = null;
        } else if (i < 10) {
            this.bYa = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_one_number;
        } else if (i < 100) {
            this.bYa = String.valueOf(i);
            i2 = R.drawable.icon_news_red_dot_two_number;
        } else if (this.mType == 1) {
            this.bYa = "...";
            i2 = R.drawable.icon_news_red_dot_three_dot_number;
        } else if (this.mType == 2) {
            this.bYa = "99+";
            i2 = R.drawable.icon_news_red_dot_three_number;
        } else {
            i2 = 0;
        }
        if (i2 != this.bXY) {
            this.bXZ = true;
        } else {
            this.bXZ = false;
        }
        this.bXY = i2;
        onChangeSkinType();
    }

    public void setThreeDotMode(int i) {
        this.mType = i;
    }

    public void onChangeSkinType() {
        this.bYo = TbadkApplication.getInst().getSkinType();
        if (this.bXY > 0) {
            this.Ma = al.getDrawable(this.bXY);
        } else if (this.Ma instanceof GradientDrawable) {
            ((GradientDrawable) this.Ma).setColor(al.getColor(R.color.cp_cont_h));
        }
        this.bYm.setColor(al.getColor(R.color.cp_btn_a));
        if (this.bWu != null) {
            this.bWu.setColor(al.getColor(R.color.cp_btn_a));
        }
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.bYf, this.bYg, al.getColor(R.color.cp_cont_h_alpha66));
        if (this.bXZ) {
            this.bXZ = false;
            requestLayout();
        }
        invalidate();
    }
}
