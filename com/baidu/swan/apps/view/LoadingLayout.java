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
import d.a.m0.a.a;
import d.a.m0.a.e;
import d.a.m0.a.f;
import d.a.m0.a.g;
/* loaded from: classes3.dex */
public class LoadingLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public ImageView f11477e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f11478f;

    public LoadingLayout(Context context) {
        super(context);
    }

    public final void a() {
        View inflate = LayoutInflater.from(getContext()).inflate(g.swanapp_album_loadding_layout, (ViewGroup) null);
        inflate.setBackgroundColor(-1);
        this.f11477e = (ImageView) inflate.findViewById(f.album_loadding_img);
        this.f11478f = (TextView) inflate.findViewById(f.album_loadding_tv);
        addView(inflate);
    }

    public void b(boolean z) {
        if (z) {
            setVisibility(0);
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), a.swanapp_album_rotate_loading);
            this.f11477e.setImageResource(e.swanapp_album_progress_icon);
            this.f11477e.startAnimation(loadAnimation);
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
