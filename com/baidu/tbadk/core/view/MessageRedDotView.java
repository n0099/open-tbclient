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
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class MessageRedDotView extends View {
    private Drawable KV;
    private Paint atD;
    private Drawable avj;
    private int avk;
    private boolean avl;
    private String avm;
    private int avn;
    private Rect avo;
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
            if (!ap.isEmpty(this.avm)) {
                if (this.avm.equals("...")) {
                    h(canvas);
                } else {
                    i(canvas);
                }
            }
        }
    }

    private void h(Canvas canvas) {
        if (this.avj != null && this.KV != null) {
            int intrinsicWidth = this.KV.getIntrinsicWidth() / 2;
            int intrinsicHeight = this.KV.getIntrinsicHeight() / 2;
            int f = com.baidu.adp.lib.util.l.f(getContext(), f.e.tbds6);
            int f2 = com.baidu.adp.lib.util.l.f(getContext(), f.e.tbds7);
            int i = intrinsicWidth - (f / 2);
            int i2 = intrinsicHeight - (f / 2);
            int i3 = intrinsicWidth + (f / 2);
            int i4 = intrinsicHeight + (f / 2);
            this.avj.setBounds(i, i2, i3, i4);
            this.avj.draw(canvas);
            this.avj.setBounds((i - f2) - f, i2, i - f2, i4);
            this.avj.draw(canvas);
            this.avj.setBounds(i3 + f2, i2, i3 + f2 + f, i4);
            this.avj.draw(canvas);
        }
    }

    private void i(Canvas canvas) {
        if (!ap.isEmpty(this.avm) && this.KV != null) {
            this.atD.getTextBounds(this.avm, 0, this.avm.length(), this.avo);
            canvas.drawText(this.avm, this.KV.getIntrinsicWidth() / 2, ((this.KV.getIntrinsicHeight() + this.avo.height()) / 2) - this.avn, this.atD);
        }
    }

    private void initView() {
        Al();
        this.atD = new Paint(1);
        this.atD.setColor(am.getColor(f.d.cp_cont_i));
        this.atD.setTextSize(com.baidu.adp.lib.util.l.f(getContext(), f.e.tbfontsize26));
        this.atD.setTextAlign(Paint.Align.CENTER);
        this.atD.setTypeface(Typeface.MONOSPACE);
        this.avo = new Rect();
    }

    private void Al() {
        String str = Build.MODEL;
        if (str.contains("vivo") && str.contains("X20")) {
            this.avn = com.baidu.adp.lib.util.l.f(getContext(), f.e.tbds2);
        }
    }

    public void refresh(int i) {
        int i2;
        if (i <= 0) {
            i2 = f.C0146f.icon_news_red_dot;
            this.avm = null;
        } else if (i < 10) {
            this.avm = String.valueOf(i);
            i2 = f.C0146f.icon_news_red_dot_one_number;
        } else if (i < 100) {
            this.avm = String.valueOf(i);
            i2 = f.C0146f.icon_news_red_dot_two_number;
        } else if (this.mType == 1) {
            this.avm = "...";
            i2 = f.C0146f.icon_news_red_dot_two_number;
        } else if (this.mType == 2) {
            this.avm = "99+";
            i2 = f.C0146f.icon_news_red_dot_three_number;
        } else {
            i2 = 0;
        }
        if (i2 != this.avk) {
            this.avl = true;
        } else {
            this.avl = false;
        }
        this.avk = i2;
        onChangeSkinType();
    }

    public void setThreeDotMode(int i) {
        this.mType = i;
    }

    public void onChangeSkinType() {
        this.KV = am.getDrawable(this.avk);
        this.avj = am.getDrawable(f.C0146f.icon_news_white_dot);
        if (this.atD != null) {
            this.atD.setColor(am.getColor(f.d.cp_cont_i));
        }
        if (this.avl) {
            this.avl = false;
            requestLayout();
            return;
        }
        invalidate();
    }
}
