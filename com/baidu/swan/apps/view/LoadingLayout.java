package com.baidu.swan.apps.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.swan.apps.a;
/* loaded from: classes10.dex */
public class LoadingLayout extends LinearLayout {
    private ImageView drn;
    private TextView dro;

    public LoadingLayout(Context context) {
        super(context);
    }

    public LoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        initView();
    }

    private void initView() {
        View inflate = LayoutInflater.from(getContext()).inflate(a.g.swanapp_album_loadding_layout, (ViewGroup) null);
        inflate.setBackgroundResource(a.c.aiapps_white);
        this.drn = (ImageView) inflate.findViewById(a.f.album_loadding_img);
        this.dro = (TextView) inflate.findViewById(a.f.album_loadding_tv);
        addView(inflate);
    }

    public void gC(boolean z) {
        if (z) {
            setVisibility(0);
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), a.C0343a.swanapp_album_rotate_loading);
            this.drn.setImageResource(a.e.swanapp_album_progress_icon);
            this.drn.startAnimation(loadAnimation);
            return;
        }
        setVisibility(8);
    }
}
