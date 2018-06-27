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
    private Drawable KZ;
    private Paint atY;
    private Drawable avF;
    private int avG;
    private boolean avH;
    private String avI;
    private int avJ;
    private Rect avK;
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
        if (this.KZ != null) {
            setMeasuredDimension(this.KZ.getIntrinsicWidth(), this.KZ.getIntrinsicHeight());
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.KZ != null) {
            this.KZ.setBounds(0, 0, this.KZ.getIntrinsicWidth(), this.KZ.getIntrinsicHeight());
            this.KZ.draw(canvas);
            if (!ap.isEmpty(this.avI)) {
                if (this.avI.equals("...")) {
                    j(canvas);
                } else {
                    k(canvas);
                }
            }
        }
    }

    private void j(Canvas canvas) {
        if (this.avF != null && this.KZ != null) {
            int intrinsicWidth = this.KZ.getIntrinsicWidth() / 2;
            int intrinsicHeight = this.KZ.getIntrinsicHeight() / 2;
            int e = com.baidu.adp.lib.util.l.e(getContext(), d.e.tbds6);
            int e2 = com.baidu.adp.lib.util.l.e(getContext(), d.e.tbds7);
            int i = intrinsicWidth - (e / 2);
            int i2 = intrinsicHeight - (e / 2);
            int i3 = intrinsicWidth + (e / 2);
            int i4 = intrinsicHeight + (e / 2);
            this.avF.setBounds(i, i2, i3, i4);
            this.avF.draw(canvas);
            this.avF.setBounds((i - e2) - e, i2, i - e2, i4);
            this.avF.draw(canvas);
            this.avF.setBounds(i3 + e2, i2, i3 + e2 + e, i4);
            this.avF.draw(canvas);
        }
    }

    private void k(Canvas canvas) {
        if (!ap.isEmpty(this.avI) && this.KZ != null) {
            this.atY.getTextBounds(this.avI, 0, this.avI.length(), this.avK);
            canvas.drawText(this.avI, this.KZ.getIntrinsicWidth() / 2, ((this.KZ.getIntrinsicHeight() + this.avK.height()) / 2) - this.avJ, this.atY);
        }
    }

    private void initView() {
        Ax();
        this.atY = new Paint(1);
        this.atY.setColor(am.getColor(d.C0142d.cp_cont_i));
        this.atY.setTextSize(com.baidu.adp.lib.util.l.e(getContext(), d.e.tbfontsize26));
        this.atY.setTextAlign(Paint.Align.CENTER);
        this.atY.setTypeface(Typeface.MONOSPACE);
        this.avK = new Rect();
    }

    private void Ax() {
        String str = Build.MODEL;
        if (str.contains("vivo") && str.contains("X20")) {
            this.avJ = com.baidu.adp.lib.util.l.e(getContext(), d.e.tbds2);
        }
    }

    public void refresh(int i) {
        int i2;
        if (i <= 0) {
            i2 = d.f.icon_news_red_dot;
            this.avI = null;
        } else if (i < 10) {
            this.avI = String.valueOf(i);
            i2 = d.f.icon_news_red_dot_one_number;
        } else if (i < 100) {
            this.avI = String.valueOf(i);
            i2 = d.f.icon_news_red_dot_two_number;
        } else if (this.mType == 1) {
            this.avI = "...";
            i2 = d.f.icon_news_red_dot_two_number;
        } else if (this.mType == 2) {
            this.avI = "99+";
            i2 = d.f.icon_news_red_dot_three_number;
        } else {
            i2 = 0;
        }
        if (i2 != this.avG) {
            this.avH = true;
        } else {
            this.avH = false;
        }
        this.avG = i2;
        onChangeSkinType();
    }

    public void setThreeDotMode(int i) {
        this.mType = i;
    }

    public void onChangeSkinType() {
        this.KZ = am.getDrawable(this.avG);
        this.avF = am.getDrawable(d.f.icon_news_white_dot);
        if (this.atY != null) {
            this.atY.setColor(am.getColor(d.C0142d.cp_cont_i));
        }
        if (this.avH) {
            this.avH = false;
            requestLayout();
            return;
        }
        invalidate();
    }
}
