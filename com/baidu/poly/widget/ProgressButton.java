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
    private ImageView aiG;
    private Animation aiH;
    private boolean enable;
    private TextView textView;

    public ProgressButton(Context context) {
        this(context, null);
    }

    public ProgressButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProgressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        d(context, attributeSet);
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

    private void d(Context context, AttributeSet attributeSet) {
        LayoutInflater.from(context).inflate(b.e.button_progress, (ViewGroup) this, true);
        this.textView = (TextView) findViewById(b.d.text_view);
        this.aiG = (ImageView) findViewById(b.d.progress_bar);
        this.aiH = AnimationUtils.loadAnimation(context, b.a.loading_rotate);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.f.ProgressButton);
        this.textView.setTextColor(obtainStyledAttributes.getColor(b.f.ProgressButton_textColor, -1));
        obtainStyledAttributes.recycle();
    }

    public void setText(String str) {
        this.textView.setText(str);
        this.aiG.setVisibility(4);
        this.textView.setVisibility(0);
    }

    public void startLoading() {
        this.aiG.setVisibility(0);
        this.aiG.startAnimation(this.aiH);
        this.textView.setVisibility(4);
    }
}
