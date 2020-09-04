package com.baidu.poly.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.poly.b;
/* loaded from: classes6.dex */
public class TipView extends LinearLayout {
    private ImageView bGA;
    private TextView bGB;
    private Animation bGC;

    public TipView(Context context) {
        this(context, null);
    }

    private void c(Context context) {
        setOrientation(1);
        setGravity(17);
        LayoutInflater.from(context).inflate(b.f.view_tip, (ViewGroup) this, true);
        this.bGA = (ImageView) findViewById(b.e.tip_loading_view);
        this.bGB = (TextView) findViewById(b.e.tip_text_view);
    }

    public void a(String str) {
        setVisibility(0);
        if (this.bGC == null) {
            this.bGC = AnimationUtils.loadAnimation(getContext(), b.a.loading_rotate);
        }
        this.bGB.setText(str);
        ViewGroup.LayoutParams layoutParams = this.bGA.getLayoutParams();
        if (layoutParams != null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(b.c.channel_loading_icon_size);
            layoutParams.width = dimensionPixelOffset;
            layoutParams.height = dimensionPixelOffset;
        }
        this.bGA.startAnimation(this.bGC);
    }

    public void b(String str, String str2) {
        setVisibility(0);
        this.bGA.clearAnimation();
        ViewGroup.LayoutParams layoutParams = this.bGA.getLayoutParams();
        if (layoutParams != null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(b.c.pay_loading_icon_size);
            layoutParams.width = dimensionPixelOffset;
            layoutParams.height = dimensionPixelOffset;
        }
        com.baidu.poly.a.d.b.TZ().b(this.bGA, str);
        this.bGB.setText(str2);
    }

    public void j() {
        setVisibility(8);
        this.bGA.clearAnimation();
    }

    public TipView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c(context);
    }
}
