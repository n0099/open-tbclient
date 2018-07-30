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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class MessageRedDotView extends View {
    private Drawable KV;
    private Paint atC;
    private Drawable avl;
    private int avm;
    private boolean avn;
    private String avo;
    private int avp;
    private Rect avq;
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
        if (this.KV != null) {
            setMeasuredDimension(this.KV.getIntrinsicWidth(), this.KV.getIntrinsicHeight());
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.KV != null) {
            this.KV.setBounds(0, 0, this.KV.getIntrinsicWidth(), this.KV.getIntrinsicHeight());
            this.KV.draw(canvas);
            if (!ap.isEmpty(this.avo)) {
                if (this.avo.equals("...")) {
                    i(canvas);
                } else {
                    j(canvas);
                }
            }
        }
    }

    private void i(Canvas canvas) {
        if (this.avl != null && this.KV != null) {
            int intrinsicWidth = this.KV.getIntrinsicWidth() / 2;
            int intrinsicHeight = this.KV.getIntrinsicHeight() / 2;
            int f = com.baidu.adp.lib.util.l.f(getContext(), d.e.tbds6);
            int f2 = com.baidu.adp.lib.util.l.f(getContext(), d.e.tbds7);
            int i = intrinsicWidth - (f / 2);
            int i2 = intrinsicHeight - (f / 2);
            int i3 = intrinsicWidth + (f / 2);
            int i4 = intrinsicHeight + (f / 2);
            this.avl.setBounds(i, i2, i3, i4);
            this.avl.draw(canvas);
            this.avl.setBounds((i - f2) - f, i2, i - f2, i4);
            this.avl.draw(canvas);
            this.avl.setBounds(i3 + f2, i2, i3 + f2 + f, i4);
            this.avl.draw(canvas);
        }
    }

    private void j(Canvas canvas) {
        if (!ap.isEmpty(this.avo) && this.KV != null) {
            this.atC.getTextBounds(this.avo, 0, this.avo.length(), this.avq);
            canvas.drawText(this.avo, this.KV.getIntrinsicWidth() / 2, ((this.KV.getIntrinsicHeight() + this.avq.height()) / 2) - this.avp, this.atC);
        }
    }

    private void initView() {
        An();
        this.atC = new Paint(1);
        this.atC.setColor(am.getColor(d.C0140d.cp_cont_i));
        this.atC.setTextSize(com.baidu.adp.lib.util.l.f(getContext(), d.e.tbfontsize26));
        this.atC.setTextAlign(Paint.Align.CENTER);
        this.atC.setTypeface(Typeface.MONOSPACE);
        this.avq = new Rect();
    }

    private void An() {
        String str = Build.MODEL;
        if (str.contains("vivo") && str.contains("X20")) {
            this.avp = com.baidu.adp.lib.util.l.f(getContext(), d.e.tbds2);
        }
    }

    public void refresh(int i) {
        int i2;
        if (i <= 0) {
            i2 = d.f.icon_news_red_dot;
            this.avo = null;
        } else if (i < 10) {
            this.avo = String.valueOf(i);
            i2 = d.f.icon_news_red_dot_one_number;
        } else if (i < 100) {
            this.avo = String.valueOf(i);
            i2 = d.f.icon_news_red_dot_two_number;
        } else if (this.mType == 1) {
            this.avo = "...";
            i2 = d.f.icon_news_red_dot_two_number;
        } else if (this.mType == 2) {
            this.avo = "99+";
            i2 = d.f.icon_news_red_dot_three_number;
        } else {
            i2 = 0;
        }
        if (i2 != this.avm) {
            this.avn = true;
        } else {
            this.avn = false;
        }
        this.avm = i2;
        onChangeSkinType();
    }

    public void setThreeDotMode(int i) {
        this.mType = i;
    }

    public void onChangeSkinType() {
        this.KV = am.getDrawable(this.avm);
        this.avl = am.getDrawable(d.f.icon_news_white_dot);
        if (this.atC != null) {
            this.atC.setColor(am.getColor(d.C0140d.cp_cont_i));
        }
        if (this.avn) {
            this.avn = false;
            requestLayout();
            return;
        }
        invalidate();
    }
}
