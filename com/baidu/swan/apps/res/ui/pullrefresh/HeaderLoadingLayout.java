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
public class HeaderLoadingLayout extends LoadingLayout {
    public RelativeLayout e;
    public ImageView f;
    public ProgressBar g;
    public TextView h;
    public TextView i;
    public TextView j;
    public Animation k;
    public Animation l;

    public HeaderLoadingLayout(Context context) {
        super(context);
        n(context);
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

    public HeaderLoadingLayout(Context context, AttributeSet attributeSet) {
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
        return LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d00ca, viewGroup, false);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void g() {
        if (ILoadingLayout$State.RELEASE_TO_REFRESH == getPreState()) {
            this.f.clearAnimation();
            this.f.startAnimation(this.l);
        }
        this.h.setText(R.string.obfuscated_res_0x7f0f01dc);
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
        this.h.setText(R.string.obfuscated_res_0x7f0f01db);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void j() {
        this.f.clearAnimation();
        this.f.startAnimation(this.k);
        this.h.setText(R.string.obfuscated_res_0x7f0f01dd);
    }

    @Override // com.baidu.swan.apps.res.ui.pullrefresh.LoadingLayout
    public void k() {
        this.f.clearAnimation();
        this.h.setText(R.string.obfuscated_res_0x7f0f01dc);
    }

    public final void n(Context context) {
        this.e = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091d1a);
        this.f = (ImageView) findViewById(R.id.obfuscated_res_0x7f091d18);
        this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f091d1b);
        this.g = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f091d1c);
        this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f091d1e);
        this.j = (TextView) findViewById(R.id.obfuscated_res_0x7f091d20);
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
