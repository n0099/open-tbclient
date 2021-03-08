package com.baidu.poly.a.l;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.poly.b;
/* loaded from: classes14.dex */
public class c extends FrameLayout {
    private ImageView cqq;
    private TextView cqr;
    private Animation cqs;
    private boolean cqt;

    public c(Context context) {
        this(context, null);
    }

    private void adF() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        layoutParams.width = -1;
        layoutParams.height = -1;
    }

    private void c(Context context) {
        LayoutInflater.from(context).inflate(b.f.view_toast_loading, (ViewGroup) this, true);
        this.cqq = (ImageView) findViewById(b.e.toast_loading_view);
        this.cqr = (TextView) findViewById(b.e.toast_text_view);
        this.cqs = AnimationUtils.loadAnimation(context, b.a.loading_rotate);
        setClickable(true);
    }

    public boolean getIsLoading() {
        return this.cqt;
    }

    public void setLoading(boolean z) {
        adF();
        this.cqt = z;
        if (z) {
            setVisibility(0);
            this.cqq.startAnimation(this.cqs);
            return;
        }
        this.cqq.clearAnimation();
        setVisibility(8);
    }

    public void setText(String str) {
        this.cqr.setText(str);
    }

    public c(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public c(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c(context);
    }
}
