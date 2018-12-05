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
    private TextView aiY;
    private ImageView aiZ;
    private Animation aja;

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
        this.aiZ = (ImageView) findViewById(b.c.tip_loading_view);
        this.aiY = (TextView) findViewById(b.c.tip_text_view);
        this.aja = AnimationUtils.loadAnimation(context, b.a.loading_rotate);
    }

    public void setText(String str) {
        this.aiY.setText(str);
    }

    public void setLoading(boolean z) {
        if (z) {
            this.aiZ.setVisibility(0);
            this.aiZ.startAnimation(this.aja);
            return;
        }
        this.aiZ.clearAnimation();
        this.aiZ.setVisibility(8);
    }
}
