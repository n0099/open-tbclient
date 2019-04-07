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
/* loaded from: classes2.dex */
public class TipView extends LinearLayout {
    private TextView ahN;
    private ImageView ahO;
    private Animation ahP;

    public TipView(Context context) {
        this(context, null);
    }

    public TipView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(b.d.view_tip, (ViewGroup) this, true);
        this.ahO = (ImageView) findViewById(b.c.tip_loading_view);
        this.ahN = (TextView) findViewById(b.c.tip_text_view);
        this.ahP = AnimationUtils.loadAnimation(context, b.a.loading_rotate);
    }

    public void setText(String str) {
        this.ahN.setText(str);
    }

    public void setLoading(boolean z) {
        if (z) {
            this.ahO.setVisibility(0);
            this.ahO.startAnimation(this.ahP);
            return;
        }
        this.ahO.clearAnimation();
        this.ahO.setVisibility(8);
    }
}
