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
    private Drawable Nv;
    private Paint awR;
    private Rect ayA;
    private Drawable ayv;
    private int ayw;
    private boolean ayx;
    private String ayy;
    private int ayz;
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
        if (this.Nv != null) {
            setMeasuredDimension(this.Nv.getIntrinsicWidth(), this.Nv.getIntrinsicHeight());
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.Nv != null) {
            this.Nv.setBounds(0, 0, this.Nv.getIntrinsicWidth(), this.Nv.getIntrinsicHeight());
            this.Nv.draw(canvas);
            if (!ao.isEmpty(this.ayy)) {
                if (this.ayy.equals("...")) {
                    h(canvas);
                } else {
                    i(canvas);
                }
            }
        }
    }

    private void h(Canvas canvas) {
        if (this.ayv != null && this.Nv != null) {
            int intrinsicWidth = this.Nv.getIntrinsicWidth() / 2;
            int intrinsicHeight = this.Nv.getIntrinsicHeight() / 2;
            int h = com.baidu.adp.lib.util.l.h(getContext(), e.C0141e.tbds6);
            int h2 = com.baidu.adp.lib.util.l.h(getContext(), e.C0141e.tbds7);
            int i = intrinsicWidth - (h / 2);
            int i2 = intrinsicHeight - (h / 2);
            int i3 = intrinsicWidth + (h / 2);
            int i4 = intrinsicHeight + (h / 2);
            this.ayv.setBounds(i, i2, i3, i4);
            this.ayv.draw(canvas);
            this.ayv.setBounds((i - h2) - h, i2, i - h2, i4);
            this.ayv.draw(canvas);
            this.ayv.setBounds(i3 + h2, i2, i3 + h2 + h, i4);
            this.ayv.draw(canvas);
        }
    }

    private void i(Canvas canvas) {
        if (!ao.isEmpty(this.ayy) && this.Nv != null) {
            this.awR.getTextBounds(this.ayy, 0, this.ayy.length(), this.ayA);
            canvas.drawText(this.ayy, this.Nv.getIntrinsicWidth() / 2, ((this.Nv.getIntrinsicHeight() + this.ayA.height()) / 2) - this.ayz, this.awR);
        }
    }

    private void initView() {
        Bz();
        this.awR = new Paint(1);
        this.awR.setColor(al.getColor(e.d.cp_cont_i));
        this.awR.setTextSize(com.baidu.adp.lib.util.l.h(getContext(), e.C0141e.tbfontsize26));
        this.awR.setTextAlign(Paint.Align.CENTER);
        this.awR.setTypeface(Typeface.MONOSPACE);
        this.ayA = new Rect();
    }

    private void Bz() {
        String str = Build.MODEL;
        if (str.contains("vivo") && str.contains("X20")) {
            this.ayz = com.baidu.adp.lib.util.l.h(getContext(), e.C0141e.tbds2);
        }
    }

    public void refresh(int i) {
        int i2;
        if (i <= 0) {
            i2 = e.f.icon_news_red_dot;
            this.ayy = null;
        } else if (i < 10) {
            this.ayy = String.valueOf(i);
            i2 = e.f.icon_news_red_dot_one_number;
        } else if (i < 100) {
            this.ayy = String.valueOf(i);
            i2 = e.f.icon_news_red_dot_two_number;
        } else if (this.mType == 1) {
            this.ayy = "...";
            i2 = e.f.icon_news_red_dot_two_number;
        } else if (this.mType == 2) {
            this.ayy = "99+";
            i2 = e.f.icon_news_red_dot_three_number;
        } else {
            i2 = 0;
        }
        if (i2 != this.ayw) {
            this.ayx = true;
        } else {
            this.ayx = false;
        }
        this.ayw = i2;
        onChangeSkinType();
    }

    public void setThreeDotMode(int i) {
        this.mType = i;
    }

    public void onChangeSkinType() {
        this.Nv = al.getDrawable(this.ayw);
        this.ayv = al.getDrawable(e.f.icon_news_white_dot);
        if (this.awR != null) {
            this.awR.setColor(al.getColor(e.d.cp_cont_i));
        }
        if (this.ayx) {
            this.ayx = false;
            requestLayout();
            return;
        }
        invalidate();
    }
}
