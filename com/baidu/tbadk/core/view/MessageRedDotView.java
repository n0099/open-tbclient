package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class MessageRedDotView extends View {
    private Paint aCq;
    private Drawable aDU;
    private int aDV;
    private boolean aDW;
    private String aDX;
    private int aDY;
    private Rect aDZ;
    private Drawable mBackgroundDrawable;
    private int mType;

    public MessageRedDotView(@NonNull Context context) {
        super(context);
        this.mType = 1;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 1;
        initView();
    }

    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 1;
        initView();
    }

    @RequiresApi(api = 21)
    public MessageRedDotView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mType = 1;
        initView();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mBackgroundDrawable != null) {
            setMeasuredDimension(this.mBackgroundDrawable.getIntrinsicWidth(), this.mBackgroundDrawable.getIntrinsicHeight());
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mBackgroundDrawable != null) {
            this.mBackgroundDrawable.setBounds(0, 0, this.mBackgroundDrawable.getIntrinsicWidth(), this.mBackgroundDrawable.getIntrinsicHeight());
            this.mBackgroundDrawable.draw(canvas);
            if (!ao.isEmpty(this.aDX)) {
                if (this.aDX.equals("...")) {
                    h(canvas);
                } else {
                    i(canvas);
                }
            }
        }
    }

    private void h(Canvas canvas) {
        if (this.aDU != null && this.mBackgroundDrawable != null) {
            int intrinsicWidth = this.mBackgroundDrawable.getIntrinsicWidth() / 2;
            int intrinsicHeight = this.mBackgroundDrawable.getIntrinsicHeight() / 2;
            int h = com.baidu.adp.lib.util.l.h(getContext(), e.C0200e.tbds6);
            int h2 = com.baidu.adp.lib.util.l.h(getContext(), e.C0200e.tbds7);
            int i = intrinsicWidth - (h / 2);
            int i2 = intrinsicHeight - (h / 2);
            int i3 = intrinsicWidth + (h / 2);
            int i4 = intrinsicHeight + (h / 2);
            this.aDU.setBounds(i, i2, i3, i4);
            this.aDU.draw(canvas);
            this.aDU.setBounds((i - h2) - h, i2, i - h2, i4);
            this.aDU.draw(canvas);
            this.aDU.setBounds(i3 + h2, i2, i3 + h2 + h, i4);
            this.aDU.draw(canvas);
        }
    }

    private void i(Canvas canvas) {
        if (!ao.isEmpty(this.aDX) && this.mBackgroundDrawable != null) {
            this.aCq.getTextBounds(this.aDX, 0, this.aDX.length(), this.aDZ);
            canvas.drawText(this.aDX, this.mBackgroundDrawable.getIntrinsicWidth() / 2, ((this.mBackgroundDrawable.getIntrinsicHeight() + this.aDZ.height()) / 2) - this.aDY, this.aCq);
        }
    }

    private void initView() {
        DP();
        this.aCq = new Paint(1);
        this.aCq.setColor(al.getColor(e.d.cp_cont_i));
        this.aCq.setTextSize(com.baidu.adp.lib.util.l.h(getContext(), e.C0200e.tbfontsize26));
        this.aCq.setTextAlign(Paint.Align.CENTER);
        this.aCq.setTypeface(Typeface.MONOSPACE);
        this.aDZ = new Rect();
    }

    private void DP() {
        String str = Build.MODEL;
        if (str.contains("vivo") && str.contains("X20")) {
            this.aDY = com.baidu.adp.lib.util.l.h(getContext(), e.C0200e.tbds2);
        }
    }

    public void refresh(int i) {
        int i2;
        if (i <= 0) {
            i2 = e.f.icon_news_red_dot;
            this.aDX = null;
        } else if (i < 10) {
            this.aDX = String.valueOf(i);
            i2 = e.f.icon_news_red_dot_one_number;
        } else if (i < 100) {
            this.aDX = String.valueOf(i);
            i2 = e.f.icon_news_red_dot_two_number;
        } else if (this.mType == 1) {
            this.aDX = "...";
            i2 = e.f.icon_news_red_dot_two_number;
        } else if (this.mType == 2) {
            this.aDX = "99+";
            i2 = e.f.icon_news_red_dot_three_number;
        } else {
            i2 = 0;
        }
        if (i2 != this.aDV) {
            this.aDW = true;
        } else {
            this.aDW = false;
        }
        this.aDV = i2;
        onChangeSkinType();
    }

    public void setThreeDotMode(int i) {
        this.mType = i;
    }

    public void onChangeSkinType() {
        this.mBackgroundDrawable = al.getDrawable(this.aDV);
        this.aDU = al.getDrawable(e.f.icon_news_white_dot);
        if (this.aCq != null) {
            this.aCq.setColor(al.getColor(e.d.cp_cont_i));
        }
        if (this.aDW) {
            this.aDW = false;
            requestLayout();
            return;
        }
        invalidate();
    }
}
