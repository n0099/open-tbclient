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
import d.a.h0.a.a;
import d.a.h0.a.c;
import d.a.h0.a.e;
import d.a.h0.a.f;
import d.a.h0.a.g;
/* loaded from: classes3.dex */
public class LoadingLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public ImageView f12226e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f12227f;

    public LoadingLayout(Context context) {
        super(context);
    }

    public final void a() {
        View inflate = LayoutInflater.from(getContext()).inflate(g.swanapp_album_loadding_layout, (ViewGroup) null);
        inflate.setBackgroundResource(c.aiapps_white);
        this.f12226e = (ImageView) inflate.findViewById(f.album_loadding_img);
        this.f12227f = (TextView) inflate.findViewById(f.album_loadding_tv);
        addView(inflate);
    }

    public void b(boolean z) {
        if (z) {
            setVisibility(0);
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), a.swanapp_album_rotate_loading);
            this.f12226e.setImageResource(e.swanapp_album_progress_icon);
            this.f12226e.startAnimation(loadAnimation);
            return;
        }
        setVisibility(8);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        a();
    }

    public LoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
