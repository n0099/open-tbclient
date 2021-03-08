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
/* loaded from: classes14.dex */
public class TipView extends LinearLayout {
    private ImageView cqq;
    private TextView cqr;
    private Animation cqs;

    public TipView(Context context) {
        this(context, null);
    }

    private void c(Context context) {
        setOrientation(1);
        setGravity(17);
        LayoutInflater.from(context).inflate(b.f.view_tip, (ViewGroup) this, true);
        this.cqq = (ImageView) findViewById(b.e.tip_loading_view);
        this.cqr = (TextView) findViewById(b.e.tip_text_view);
    }

    public void a(String str) {
        setVisibility(0);
        if (this.cqs == null) {
            this.cqs = AnimationUtils.loadAnimation(getContext(), b.a.loading_rotate);
        }
        this.cqr.setText(str);
        ViewGroup.LayoutParams layoutParams = this.cqq.getLayoutParams();
        if (layoutParams != null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(b.c.channel_loading_icon_size);
            layoutParams.width = dimensionPixelOffset;
            layoutParams.height = dimensionPixelOffset;
        }
        this.cqq.startAnimation(this.cqs);
    }

    public void b(String str, String str2) {
        setVisibility(0);
        this.cqq.clearAnimation();
        ViewGroup.LayoutParams layoutParams = this.cqq.getLayoutParams();
        if (layoutParams != null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(b.c.pay_loading_icon_size);
            layoutParams.width = dimensionPixelOffset;
            layoutParams.height = dimensionPixelOffset;
        }
        com.baidu.poly.a.d.b.ads().b(this.cqq, str);
        this.cqr.setText(str2);
    }

    public void j() {
        setVisibility(8);
        this.cqq.clearAnimation();
    }

    public TipView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c(context);
    }
}
