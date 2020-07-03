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
/* loaded from: classes11.dex */
public class ProgressButton extends FrameLayout {
    private ImageView bAE;
    private TextView bAF;
    private Animation bAG;
    private boolean bAY;

    public ProgressButton(Context context) {
        this(context, null);
    }

    private void c(Context context, AttributeSet attributeSet) {
        LayoutInflater.from(context).inflate(b.f.button_progress, (ViewGroup) this, true);
        this.bAF = (TextView) findViewById(b.e.text_view);
        this.bAE = (ImageView) findViewById(b.e.progress_bar);
        this.bAG = AnimationUtils.loadAnimation(context, b.a.loading_rotate);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.i.ProgressButton);
        this.bAF.setTextColor(obtainStyledAttributes.getColor(b.i.ProgressButton_textColor, -1));
        obtainStyledAttributes.recycle();
    }

    public void setEnable(boolean z) {
        super.setEnabled(z);
        this.bAY = z;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        super.setPressed(z);
        if (this.bAY) {
            setAlpha(z ? 0.2f : 1.0f);
        } else {
            setAlpha(0.2f);
        }
    }

    public void setText(String str) {
        this.bAF.setText(str);
        this.bAE.setVisibility(4);
        this.bAF.setVisibility(0);
    }

    public void startLoading() {
        this.bAE.setVisibility(0);
        this.bAE.startAnimation(this.bAG);
        this.bAF.setVisibility(4);
    }

    public ProgressButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProgressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c(context, attributeSet);
    }
}
