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
    private ImageView bGw;
    private TextView bGx;
    private Animation bGy;

    public TipView(Context context) {
        this(context, null);
    }

    private void c(Context context) {
        setOrientation(1);
        setGravity(17);
        LayoutInflater.from(context).inflate(b.f.view_tip, (ViewGroup) this, true);
        this.bGw = (ImageView) findViewById(b.e.tip_loading_view);
        this.bGx = (TextView) findViewById(b.e.tip_text_view);
    }

    public void a(String str) {
        setVisibility(0);
        if (this.bGy == null) {
            this.bGy = AnimationUtils.loadAnimation(getContext(), b.a.loading_rotate);
        }
        this.bGx.setText(str);
        ViewGroup.LayoutParams layoutParams = this.bGw.getLayoutParams();
        if (layoutParams != null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(b.c.channel_loading_icon_size);
            layoutParams.width = dimensionPixelOffset;
            layoutParams.height = dimensionPixelOffset;
        }
        this.bGw.startAnimation(this.bGy);
    }

    public void b(String str, String str2) {
        setVisibility(0);
        this.bGw.clearAnimation();
        ViewGroup.LayoutParams layoutParams = this.bGw.getLayoutParams();
        if (layoutParams != null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(b.c.pay_loading_icon_size);
            layoutParams.width = dimensionPixelOffset;
            layoutParams.height = dimensionPixelOffset;
        }
        com.baidu.poly.a.d.b.TZ().b(this.bGw, str);
        this.bGx.setText(str2);
    }

    public void j() {
        setVisibility(8);
        this.bGw.clearAnimation();
    }

    public TipView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c(context);
    }
}
