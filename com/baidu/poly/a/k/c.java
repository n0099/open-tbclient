package com.baidu.poly.a.k;

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
/* loaded from: classes11.dex */
public class c extends FrameLayout {
    private ImageView aRS;
    private TextView aRT;
    private Animation aRU;
    private boolean aRV;

    public c(Context context) {
        this(context, null);
    }

    private void Q() {
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
        this.aRS = (ImageView) findViewById(b.e.toast_loading_view);
        this.aRT = (TextView) findViewById(b.e.toast_text_view);
        this.aRU = AnimationUtils.loadAnimation(context, b.a.loading_rotate);
        setClickable(true);
    }

    public boolean getIsLoading() {
        return this.aRV;
    }

    public void setLoading(boolean z) {
        Q();
        this.aRV = z;
        if (z) {
            setVisibility(0);
            this.aRS.startAnimation(this.aRU);
            return;
        }
        this.aRS.clearAnimation();
        setVisibility(8);
    }

    public void setText(String str) {
        this.aRT.setText(str);
    }

    public c(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public c(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c(context);
    }
}
