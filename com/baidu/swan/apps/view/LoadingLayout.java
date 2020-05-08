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
/* loaded from: classes11.dex */
public class LoadingLayout extends LinearLayout {
    private ImageView cyW;
    private TextView cyX;

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
        this.cyW = (ImageView) inflate.findViewById(a.f.album_loadding_img);
        this.cyX = (TextView) inflate.findViewById(a.f.album_loadding_tv);
        addView(inflate);
    }

    public void ff(boolean z) {
        if (z) {
            setVisibility(0);
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), a.C0248a.swanapp_album_rotate_loading);
            this.cyW.setImageResource(a.e.swanapp_album_progress_icon);
            this.cyW.startAnimation(loadAnimation);
            return;
        }
        setVisibility(8);
    }
}
