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
    private ImageView aCA;
    private Animation aCB;
    private TextView textView;

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
        LayoutInflater.from(context).inflate(b.e.view_tip, (ViewGroup) this, true);
        this.aCA = (ImageView) findViewById(b.d.tip_loading_view);
        this.textView = (TextView) findViewById(b.d.tip_text_view);
        this.aCB = AnimationUtils.loadAnimation(context, b.a.loading_rotate);
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setLoading(boolean z) {
        if (z) {
            this.aCA.setVisibility(0);
            this.aCA.startAnimation(this.aCB);
            return;
        }
        this.aCA.clearAnimation();
        this.aCA.setVisibility(8);
    }
}
