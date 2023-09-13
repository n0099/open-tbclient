package com.baidu.swan.apps.res.ui.pullrefresh;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.baidu.tieba.R;
import com.baidu.tieba.on3;
/* loaded from: classes4.dex */
public class RotateLoadingLayout extends LoadingLayout {
    public static final Interpolator k = new LinearInterpolator();
    public RelativeLayout e;
    public ImageView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public Animation j;

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void g() {
        this.g.setText(R.string.obfuscated_res_0x7f0f01df);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public int getContentSize() {
        RelativeLayout relativeLayout = this.e;
        if (relativeLayout != null) {
            return relativeLayout.getHeight();
        }
        return (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f070168);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void h() {
        o();
        this.f.startAnimation(this.j);
        this.g.setText(R.string.obfuscated_res_0x7f0f01de);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void i() {
        super.i();
        this.g.setText(R.string.obfuscated_res_0x7f0f01dd);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void j() {
        this.g.setText(R.string.obfuscated_res_0x7f0f01e0);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void k() {
        o();
        this.g.setText(R.string.obfuscated_res_0x7f0f01df);
    }

    public final void o() {
        this.f.clearAnimation();
        if (on3.c()) {
            this.f.setRotation(0.0f);
        }
    }

    public RotateLoadingLayout(Context context) {
        super(context);
        n(context);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void d(float f) {
        if (on3.c()) {
            this.f.setRotation(f * 180.0f);
        }
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
        int i;
        TextView textView = this.i;
        if (TextUtils.isEmpty(charSequence)) {
            i = 4;
        } else {
            i = 0;
        }
        textView.setVisibility(i);
        this.h.setText(charSequence);
    }

    public RotateLoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        n(context);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void l(ILoadingLayout$State iLoadingLayout$State, ILoadingLayout$State iLoadingLayout$State2) {
        super.l(iLoadingLayout$State, iLoadingLayout$State2);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public View a(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        return LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d00cf, viewGroup, false);
    }

    public final void n(Context context) {
        this.e = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091df4);
        this.f = (ImageView) findViewById(R.id.obfuscated_res_0x7f091df2);
        this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f091df5);
        this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f091df8);
        this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f091dfa);
        this.f.setScaleType(ImageView.ScaleType.CENTER);
        this.f.setImageResource(R.drawable.obfuscated_res_0x7f08015d);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.j = rotateAnimation;
        rotateAnimation.setFillAfter(true);
        this.j.setInterpolator(k);
        this.j.setDuration(IMLikeRequest.TIME_INTERVAL);
        this.j.setRepeatCount(-1);
        this.j.setRepeatMode(1);
    }
}
