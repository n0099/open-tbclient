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
/* loaded from: classes6.dex */
public class c extends FrameLayout {
    private ImageView cbG;
    private TextView cbH;
    private Animation cbI;
    private boolean cbJ;

    public c(Context context) {
        this(context, null);
    }

    private void aaD() {
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
        this.cbG = (ImageView) findViewById(b.e.toast_loading_view);
        this.cbH = (TextView) findViewById(b.e.toast_text_view);
        this.cbI = AnimationUtils.loadAnimation(context, b.a.loading_rotate);
        setClickable(true);
    }

    public boolean getIsLoading() {
        return this.cbJ;
    }

    public void setLoading(boolean z) {
        aaD();
        this.cbJ = z;
        if (z) {
            setVisibility(0);
            this.cbG.startAnimation(this.cbI);
            return;
        }
        this.cbG.clearAnimation();
        setVisibility(8);
    }

    public void setText(String str) {
        this.cbH.setText(str);
    }

    public c(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public c(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c(context);
    }
}
