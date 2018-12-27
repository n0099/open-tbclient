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
    private Paint aFR;
    private Rect aHA;
    private Drawable aHv;
    private int aHw;
    private boolean aHx;
    private String aHy;
    private int aHz;
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
            if (!ao.isEmpty(this.aHy)) {
                if (this.aHy.equals("...")) {
                    h(canvas);
                } else {
                    i(canvas);
                }
            }
        }
    }

    private void h(Canvas canvas) {
        if (this.aHv != null && this.mBackgroundDrawable != null) {
            int intrinsicWidth = this.mBackgroundDrawable.getIntrinsicWidth() / 2;
            int intrinsicHeight = this.mBackgroundDrawable.getIntrinsicHeight() / 2;
            int h = com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.tbds6);
            int h2 = com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.tbds7);
            int i = intrinsicWidth - (h / 2);
            int i2 = intrinsicHeight - (h / 2);
            int i3 = intrinsicWidth + (h / 2);
            int i4 = intrinsicHeight + (h / 2);
            this.aHv.setBounds(i, i2, i3, i4);
            this.aHv.draw(canvas);
            this.aHv.setBounds((i - h2) - h, i2, i - h2, i4);
            this.aHv.draw(canvas);
            this.aHv.setBounds(i3 + h2, i2, i3 + h2 + h, i4);
            this.aHv.draw(canvas);
        }
    }

    private void i(Canvas canvas) {
        if (!ao.isEmpty(this.aHy) && this.mBackgroundDrawable != null) {
            this.aFR.getTextBounds(this.aHy, 0, this.aHy.length(), this.aHA);
            canvas.drawText(this.aHy, this.mBackgroundDrawable.getIntrinsicWidth() / 2, ((this.mBackgroundDrawable.getIntrinsicHeight() + this.aHA.height()) / 2) - this.aHz, this.aFR);
        }
    }

    private void initView() {
        ET();
        this.aFR = new Paint(1);
        this.aFR.setColor(al.getColor(e.d.cp_cont_i));
        this.aFR.setTextSize(com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.tbfontsize26));
        this.aFR.setTextAlign(Paint.Align.CENTER);
        this.aFR.setTypeface(Typeface.MONOSPACE);
        this.aHA = new Rect();
    }

    private void ET() {
        String str = Build.MODEL;
        if (str.contains("vivo") && str.contains("X20")) {
            this.aHz = com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.tbds2);
        }
    }

    public void refresh(int i) {
        int i2;
        if (i <= 0) {
            i2 = e.f.icon_news_red_dot;
            this.aHy = null;
        } else if (i < 10) {
            this.aHy = String.valueOf(i);
            i2 = e.f.icon_news_red_dot_one_number;
        } else if (i < 100) {
            this.aHy = String.valueOf(i);
            i2 = e.f.icon_news_red_dot_two_number;
        } else if (this.mType == 1) {
            this.aHy = "...";
            i2 = e.f.icon_news_red_dot_two_number;
        } else if (this.mType == 2) {
            this.aHy = "99+";
            i2 = e.f.icon_news_red_dot_three_number;
        } else {
            i2 = 0;
        }
        if (i2 != this.aHw) {
            this.aHx = true;
        } else {
            this.aHx = false;
        }
        this.aHw = i2;
        onChangeSkinType();
    }

    public void setThreeDotMode(int i) {
        this.mType = i;
    }

    public void onChangeSkinType() {
        this.mBackgroundDrawable = al.getDrawable(this.aHw);
        this.aHv = al.getDrawable(e.f.icon_news_white_dot);
        if (this.aFR != null) {
            this.aFR.setColor(al.getColor(e.d.cp_cont_i));
        }
        if (this.aHx) {
            this.aHx = false;
            requestLayout();
            return;
        }
        invalidate();
    }
}
