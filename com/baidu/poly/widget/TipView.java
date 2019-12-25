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
/* loaded from: classes9.dex */
public class TipView extends LinearLayout {
    private TextView aMA;
    private Animation aMB;
    private ImageView aMz;

    public TipView(Context context) {
        this(context, null);
    }

    private void c(Context context) {
        setOrientation(1);
        setGravity(17);
        LayoutInflater.from(context).inflate(b.f.view_tip, (ViewGroup) this, true);
        this.aMz = (ImageView) findViewById(b.e.tip_loading_view);
        this.aMA = (TextView) findViewById(b.e.tip_text_view);
    }

    public void a(String str, String str2) {
        setVisibility(0);
        this.aMz.clearAnimation();
        ViewGroup.LayoutParams layoutParams = this.aMz.getLayoutParams();
        if (layoutParams != null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(b.c.pay_loading_icon_size);
            layoutParams.width = dimensionPixelOffset;
            layoutParams.height = dimensionPixelOffset;
        }
        com.baidu.poly.a.c.b.BJ().b(this.aMz, str);
        this.aMA.setText(str2);
    }

    public void b(String str) {
        setVisibility(0);
        if (this.aMB == null) {
            this.aMB = AnimationUtils.loadAnimation(getContext(), b.a.loading_rotate);
        }
        this.aMA.setText(str);
        ViewGroup.LayoutParams layoutParams = this.aMz.getLayoutParams();
        if (layoutParams != null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(b.c.channel_loading_icon_size);
            layoutParams.width = dimensionPixelOffset;
            layoutParams.height = dimensionPixelOffset;
        }
        this.aMz.startAnimation(this.aMB);
    }

    public void f() {
        setVisibility(8);
        this.aMz.clearAnimation();
    }

    public TipView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c(context);
    }
}
