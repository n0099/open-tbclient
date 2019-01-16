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
    private Paint aGt;
    private Drawable aHX;
    private int aHY;
    private boolean aHZ;
    private String aIa;
    private int aIb;
    private Rect aIc;
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
            if (!ao.isEmpty(this.aIa)) {
                if (this.aIa.equals("...")) {
                    h(canvas);
                } else {
                    i(canvas);
                }
            }
        }
    }

    private void h(Canvas canvas) {
        if (this.aHX != null && this.mBackgroundDrawable != null) {
            int intrinsicWidth = this.mBackgroundDrawable.getIntrinsicWidth() / 2;
            int intrinsicHeight = this.mBackgroundDrawable.getIntrinsicHeight() / 2;
            int h = com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.tbds6);
            int h2 = com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.tbds7);
            int i = intrinsicWidth - (h / 2);
            int i2 = intrinsicHeight - (h / 2);
            int i3 = intrinsicWidth + (h / 2);
            int i4 = intrinsicHeight + (h / 2);
            this.aHX.setBounds(i, i2, i3, i4);
            this.aHX.draw(canvas);
            this.aHX.setBounds((i - h2) - h, i2, i - h2, i4);
            this.aHX.draw(canvas);
            this.aHX.setBounds(i3 + h2, i2, i3 + h2 + h, i4);
            this.aHX.draw(canvas);
        }
    }

    private void i(Canvas canvas) {
        if (!ao.isEmpty(this.aIa) && this.mBackgroundDrawable != null) {
            this.aGt.getTextBounds(this.aIa, 0, this.aIa.length(), this.aIc);
            canvas.drawText(this.aIa, this.mBackgroundDrawable.getIntrinsicWidth() / 2, ((this.mBackgroundDrawable.getIntrinsicHeight() + this.aIc.height()) / 2) - this.aIb, this.aGt);
        }
    }

    private void initView() {
        Fg();
        this.aGt = new Paint(1);
        this.aGt.setColor(al.getColor(e.d.cp_cont_i));
        this.aGt.setTextSize(com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.tbfontsize26));
        this.aGt.setTextAlign(Paint.Align.CENTER);
        this.aGt.setTypeface(Typeface.MONOSPACE);
        this.aIc = new Rect();
    }

    private void Fg() {
        String str = Build.MODEL;
        if (str.contains("vivo") && str.contains("X20")) {
            this.aIb = com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.tbds2);
        }
    }

    public void refresh(int i) {
        int i2;
        if (i <= 0) {
            i2 = e.f.icon_news_red_dot;
            this.aIa = null;
        } else if (i < 10) {
            this.aIa = String.valueOf(i);
            i2 = e.f.icon_news_red_dot_one_number;
        } else if (i < 100) {
            this.aIa = String.valueOf(i);
            i2 = e.f.icon_news_red_dot_two_number;
        } else if (this.mType == 1) {
            this.aIa = "...";
            i2 = e.f.icon_news_red_dot_two_number;
        } else if (this.mType == 2) {
            this.aIa = "99+";
            i2 = e.f.icon_news_red_dot_three_number;
        } else {
            i2 = 0;
        }
        if (i2 != this.aHY) {
            this.aHZ = true;
        } else {
            this.aHZ = false;
        }
        this.aHY = i2;
        onChangeSkinType();
    }

    public void setThreeDotMode(int i) {
        this.mType = i;
    }

    public void onChangeSkinType() {
        this.mBackgroundDrawable = al.getDrawable(this.aHY);
        this.aHX = al.getDrawable(e.f.icon_news_white_dot);
        if (this.aGt != null) {
            this.aGt.setColor(al.getColor(e.d.cp_cont_i));
        }
        if (this.aHZ) {
            this.aHZ = false;
            requestLayout();
            return;
        }
        invalidate();
    }
}
