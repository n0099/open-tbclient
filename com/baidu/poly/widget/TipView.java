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
/* loaded from: classes11.dex */
public class TipView extends LinearLayout {
    private ImageView aRR;
    private TextView aRS;
    private Animation aRT;

    public TipView(Context context) {
        this(context, null);
    }

    private void c(Context context) {
        setOrientation(1);
        setGravity(17);
        LayoutInflater.from(context).inflate(b.f.view_tip, (ViewGroup) this, true);
        this.aRR = (ImageView) findViewById(b.e.tip_loading_view);
        this.aRS = (TextView) findViewById(b.e.tip_text_view);
    }

    public void a(String str, String str2) {
        setVisibility(0);
        this.aRR.clearAnimation();
        ViewGroup.LayoutParams layoutParams = this.aRR.getLayoutParams();
        if (layoutParams != null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(b.c.pay_loading_icon_size);
            layoutParams.width = dimensionPixelOffset;
            layoutParams.height = dimensionPixelOffset;
        }
        com.baidu.poly.a.c.b.ED().b(this.aRR, str);
        this.aRS.setText(str2);
    }

    public void b(String str) {
        setVisibility(0);
        if (this.aRT == null) {
            this.aRT = AnimationUtils.loadAnimation(getContext(), b.a.loading_rotate);
        }
        this.aRS.setText(str);
        ViewGroup.LayoutParams layoutParams = this.aRR.getLayoutParams();
        if (layoutParams != null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(b.c.channel_loading_icon_size);
            layoutParams.width = dimensionPixelOffset;
            layoutParams.height = dimensionPixelOffset;
        }
        this.aRR.startAnimation(this.aRT);
    }

    public void f() {
        setVisibility(8);
        this.aRR.clearAnimation();
    }

    public TipView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c(context);
    }
}
