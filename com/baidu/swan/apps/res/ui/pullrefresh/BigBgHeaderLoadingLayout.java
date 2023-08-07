package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class BigBgHeaderLoadingLayout extends LoadingLayout {
    public RelativeLayout e;
    public ImageView f;
    public ProgressBar g;
    public TextView h;
    public TextView i;
    public TextView j;
    public Animation k;
    public Animation l;
    public ImageView m;

    public BigBgHeaderLoadingLayout(Context context) {
        super(context);
        n(context);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setHeaderBigBackground(int i) {
        ImageView imageView = this.m;
        if (imageView != null) {
            imageView.setBackgroundResource(i);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
        int i;
        TextView textView = this.j;
        if (TextUtils.isEmpty(charSequence)) {
            i = 4;
        } else {
            i = 0;
        }
        textView.setVisibility(i);
        this.i.setText(charSequence);
    }

    public BigBgHeaderLoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        n(context);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void l(ILoadingLayout$State iLoadingLayout$State, ILoadingLayout$State iLoadingLayout$State2) {
        this.f.setVisibility(0);
        this.g.setVisibility(4);
        super.l(iLoadingLayout$State, iLoadingLayout$State2);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        return LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d00cb, viewGroup, false);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void d(float f) {
        if (this.m == null) {
            return;
        }
        float f2 = f - 0.3f;
        float f3 = 1.0f;
        if (f2 < 0.0f) {
            f2 = 0.0f;
        } else if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        float f4 = f + 0.8f;
        if (f4 < 0.8f) {
            f3 = 0.8f;
        } else if (f4 <= 1.0f) {
            f3 = f4;
        }
        this.m.setAlpha(f2);
        this.m.setScaleX(f3);
        this.m.setScaleY(f3);
        super.d(f);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void g() {
        if (ILoadingLayout$State.RELEASE_TO_REFRESH == getPreState()) {
            this.f.clearAnimation();
            this.f.startAnimation(this.l);
        }
        this.h.setText(R.string.obfuscated_res_0x7f0f01de);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        RelativeLayout relativeLayout = this.e;
        if (relativeLayout != null) {
            return relativeLayout.getHeight();
        }
        return (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f070166);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void h() {
        this.f.clearAnimation();
        this.f.setVisibility(4);
        this.g.setVisibility(0);
        this.h.setText(R.string.obfuscated_res_0x7f0f01e2);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void j() {
        this.f.clearAnimation();
        this.f.startAnimation(this.k);
        this.h.setText(R.string.obfuscated_res_0x7f0f01df);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void k() {
        this.f.clearAnimation();
        this.h.setText(R.string.obfuscated_res_0x7f0f01de);
    }

    public final void n(Context context) {
        this.e = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091da5);
        this.f = (ImageView) findViewById(R.id.obfuscated_res_0x7f091da3);
        this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f091da6);
        this.g = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f091da7);
        this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f091da9);
        this.j = (TextView) findViewById(R.id.obfuscated_res_0x7f091dab);
        this.m = (ImageView) findViewById(R.id.obfuscated_res_0x7f091da4);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        this.k = rotateAnimation;
        rotateAnimation.setDuration(120L);
        this.k.setFillAfter(true);
        RotateAnimation rotateAnimation2 = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.l = rotateAnimation2;
        rotateAnimation2.setDuration(120L);
        this.l.setFillAfter(true);
    }
}
