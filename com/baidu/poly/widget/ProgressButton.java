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
/* loaded from: classes2.dex */
public class ProgressButton extends FrameLayout {
    private TextView aiY;
    private ImageView aiZ;
    private Animation aja;
    private boolean enable;

    public ProgressButton(Context context) {
        this(context, null);
    }

    public ProgressButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProgressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c(context, attributeSet);
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        super.setPressed(z);
        if (this.enable) {
            setAlpha(z ? 0.2f : 1.0f);
        } else {
            setAlpha(0.2f);
        }
    }

    public void setEnable(boolean z) {
        this.enable = z;
    }

    private void c(Context context, AttributeSet attributeSet) {
        LayoutInflater.from(context).inflate(b.d.button_progress, (ViewGroup) this, true);
        this.aiY = (TextView) findViewById(b.c.text_view);
        this.aiZ = (ImageView) findViewById(b.c.progress_bar);
        this.aja = AnimationUtils.loadAnimation(context, b.a.loading_rotate);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.e.ProgressButton);
        this.aiY.setTextColor(obtainStyledAttributes.getColor(b.e.ProgressButton_textColor, -1));
        obtainStyledAttributes.recycle();
    }

    public void setText(String str) {
        this.aiY.setText(str);
        this.aiZ.setVisibility(4);
        this.aiY.setVisibility(0);
    }

    public void startLoading() {
        this.aiZ.setVisibility(0);
        this.aiZ.startAnimation(this.aja);
        this.aiY.setVisibility(4);
    }
}
