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
    private Paint aGu;
    private Drawable aHY;
    private int aHZ;
    private boolean aIa;
    private String aIb;
    private int aIc;
    private Rect aId;
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
            if (!ao.isEmpty(this.aIb)) {
                if (this.aIb.equals("...")) {
                    h(canvas);
                } else {
                    i(canvas);
                }
            }
        }
    }

    private void h(Canvas canvas) {
        if (this.aHY != null && this.mBackgroundDrawable != null) {
            int intrinsicWidth = this.mBackgroundDrawable.getIntrinsicWidth() / 2;
            int intrinsicHeight = this.mBackgroundDrawable.getIntrinsicHeight() / 2;
            int h = com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.tbds6);
            int h2 = com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.tbds7);
            int i = intrinsicWidth - (h / 2);
            int i2 = intrinsicHeight - (h / 2);
            int i3 = intrinsicWidth + (h / 2);
            int i4 = intrinsicHeight + (h / 2);
            this.aHY.setBounds(i, i2, i3, i4);
            this.aHY.draw(canvas);
            this.aHY.setBounds((i - h2) - h, i2, i - h2, i4);
            this.aHY.draw(canvas);
            this.aHY.setBounds(i3 + h2, i2, i3 + h2 + h, i4);
            this.aHY.draw(canvas);
        }
    }

    private void i(Canvas canvas) {
        if (!ao.isEmpty(this.aIb) && this.mBackgroundDrawable != null) {
            this.aGu.getTextBounds(this.aIb, 0, this.aIb.length(), this.aId);
            canvas.drawText(this.aIb, this.mBackgroundDrawable.getIntrinsicWidth() / 2, ((this.mBackgroundDrawable.getIntrinsicHeight() + this.aId.height()) / 2) - this.aIc, this.aGu);
        }
    }

    private void initView() {
        Fg();
        this.aGu = new Paint(1);
        this.aGu.setColor(al.getColor(e.d.cp_cont_i));
        this.aGu.setTextSize(com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.tbfontsize26));
        this.aGu.setTextAlign(Paint.Align.CENTER);
        this.aGu.setTypeface(Typeface.MONOSPACE);
        this.aId = new Rect();
    }

    private void Fg() {
        String str = Build.MODEL;
        if (str.contains("vivo") && str.contains("X20")) {
            this.aIc = com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.tbds2);
        }
    }

    public void refresh(int i) {
        int i2;
        if (i <= 0) {
            i2 = e.f.icon_news_red_dot;
            this.aIb = null;
        } else if (i < 10) {
            this.aIb = String.valueOf(i);
            i2 = e.f.icon_news_red_dot_one_number;
        } else if (i < 100) {
            this.aIb = String.valueOf(i);
            i2 = e.f.icon_news_red_dot_two_number;
        } else if (this.mType == 1) {
            this.aIb = "...";
            i2 = e.f.icon_news_red_dot_two_number;
        } else if (this.mType == 2) {
            this.aIb = "99+";
            i2 = e.f.icon_news_red_dot_three_number;
        } else {
            i2 = 0;
        }
        if (i2 != this.aHZ) {
            this.aIa = true;
        } else {
            this.aIa = false;
        }
        this.aHZ = i2;
        onChangeSkinType();
    }

    public void setThreeDotMode(int i) {
        this.mType = i;
    }

    public void onChangeSkinType() {
        this.mBackgroundDrawable = al.getDrawable(this.aHZ);
        this.aHY = al.getDrawable(e.f.icon_news_white_dot);
        if (this.aGu != null) {
            this.aGu.setColor(al.getColor(e.d.cp_cont_i));
        }
        if (this.aIa) {
            this.aIa = false;
            requestLayout();
            return;
        }
        invalidate();
    }
}
