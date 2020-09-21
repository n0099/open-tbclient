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
/* loaded from: classes9.dex */
public class ProgressButton extends FrameLayout {
    private ImageView bIB;
    private TextView bIC;
    private Animation bID;
    private boolean bIY;

    public ProgressButton(Context context) {
        this(context, null);
    }

    private void c(Context context, AttributeSet attributeSet) {
        LayoutInflater.from(context).inflate(b.f.button_progress, (ViewGroup) this, true);
        this.bIC = (TextView) findViewById(b.e.text_view);
        this.bIB = (ImageView) findViewById(b.e.progress_bar);
        this.bID = AnimationUtils.loadAnimation(context, b.a.loading_rotate);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.i.ProgressButton);
        this.bIC.setTextColor(obtainStyledAttributes.getColor(b.i.ProgressButton_textColor, -1));
        obtainStyledAttributes.recycle();
    }

    public void setEnable(boolean z) {
        super.setEnabled(z);
        this.bIY = z;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        super.setPressed(z);
        if (this.bIY) {
            setAlpha(z ? 0.2f : 1.0f);
        } else {
            setAlpha(0.2f);
        }
    }

    public void setText(String str) {
        this.bIC.setText(str);
        this.bIB.setVisibility(4);
        this.bIC.setVisibility(0);
    }

    public void startLoading() {
        this.bIB.setVisibility(0);
        this.bIB.startAnimation(this.bID);
        this.bIC.setVisibility(4);
    }

    public ProgressButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProgressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c(context, attributeSet);
    }
}
