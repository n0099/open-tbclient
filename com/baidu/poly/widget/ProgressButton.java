package com.baidu.poly.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.poly.b;
/* loaded from: classes3.dex */
public class ProgressButton extends FrameLayout {
    private boolean ckU;
    private ImageView ckx;
    private TextView cky;
    private Animation ckz;

    public ProgressButton(Context context) {
        this(context, null);
    }

    private void d(Context context, AttributeSet attributeSet) {
        LayoutInflater.from(context).inflate(b.f.button_progress, (ViewGroup) this, true);
        this.cky = (TextView) findViewById(b.e.text_view);
        this.ckx = (ImageView) findViewById(b.e.progress_bar);
        this.ckz = AnimationUtils.loadAnimation(context, b.a.loading_rotate);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.i.ProgressButton);
        this.cky.setTextColor(obtainStyledAttributes.getColor(b.i.ProgressButton_textColor, -1));
        obtainStyledAttributes.recycle();
    }

    public void setEnable(boolean z) {
        super.setEnabled(z);
        this.ckU = z;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        super.setPressed(z);
        if (this.ckU) {
            setAlpha(z ? 0.2f : 1.0f);
        } else {
            setAlpha(0.2f);
        }
    }

    public void setText(String str) {
        this.cky.setText(str);
        this.ckx.setVisibility(4);
        this.cky.setVisibility(0);
    }

    public void startLoading() {
        this.ckx.setVisibility(0);
        this.ckx.startAnimation(this.ckz);
        this.cky.setVisibility(4);
    }

    public ProgressButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProgressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        d(context, attributeSet);
    }
}
