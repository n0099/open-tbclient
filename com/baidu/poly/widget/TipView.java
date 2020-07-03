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
    private ImageView bAE;
    private TextView bAF;
    private Animation bAG;

    public TipView(Context context) {
        this(context, null);
    }

    private void c(Context context) {
        setOrientation(1);
        setGravity(17);
        LayoutInflater.from(context).inflate(b.f.view_tip, (ViewGroup) this, true);
        this.bAE = (ImageView) findViewById(b.e.tip_loading_view);
        this.bAF = (TextView) findViewById(b.e.tip_text_view);
    }

    public void a(String str) {
        setVisibility(0);
        if (this.bAG == null) {
            this.bAG = AnimationUtils.loadAnimation(getContext(), b.a.loading_rotate);
        }
        this.bAF.setText(str);
        ViewGroup.LayoutParams layoutParams = this.bAE.getLayoutParams();
        if (layoutParams != null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(b.c.channel_loading_icon_size);
            layoutParams.width = dimensionPixelOffset;
            layoutParams.height = dimensionPixelOffset;
        }
        this.bAE.startAnimation(this.bAG);
    }

    public void b(String str, String str2) {
        setVisibility(0);
        this.bAE.clearAnimation();
        ViewGroup.LayoutParams layoutParams = this.bAE.getLayoutParams();
        if (layoutParams != null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(b.c.pay_loading_icon_size);
            layoutParams.width = dimensionPixelOffset;
            layoutParams.height = dimensionPixelOffset;
        }
        com.baidu.poly.a.c.b.NY().b(this.bAE, str);
        this.bAF.setText(str2);
    }

    public void h() {
        setVisibility(8);
        this.bAE.clearAnimation();
    }

    public TipView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c(context);
    }
}
