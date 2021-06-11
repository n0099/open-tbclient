package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import d.a.l0.a.h;
/* loaded from: classes3.dex */
public class NetworkErrorView extends CommonEmptyView {

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Object f11168a;

        public a(int i2) {
        }
    }

    public NetworkErrorView(Context context) {
        super(context);
        b();
    }

    public static void c(View view) {
        a aVar = new a(1);
        aVar.f11168a = view;
        BdEventBus.Companion.getDefault().post(aVar);
    }

    public final void b() {
        this.f11140i.setVisibility(0);
        setTitle(getContext().getString(h.swanapp_tip_net_unavailable));
    }

    public void setBottomLayout(View.OnClickListener onClickListener, View view, RelativeLayout.LayoutParams layoutParams) {
        FrameLayout frameLayout = this.j;
        if (frameLayout == null || view == null) {
            return;
        }
        frameLayout.setVisibility(0);
        this.j.addView(view);
        if (layoutParams != null) {
            this.j.setLayoutParams(layoutParams);
        }
        this.j.setOnClickListener(onClickListener);
    }

    public void setEmptyButtonVisiblity(int i2) {
        this.f11140i.setVisibility(i2);
    }

    public void setEmptyViewVisiblity(int i2) {
        this.f11136e.setVisibility(i2);
    }

    public void setNetworkButtonShow(boolean z) {
        TextView textView = this.f11139h;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 4);
        }
    }

    public void setReloadClickListener(View.OnClickListener onClickListener) {
        setTextButtonClickListener(onClickListener);
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        if (i2 == 0) {
            c(this);
        }
        super.setVisibility(i2);
    }

    public NetworkErrorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public NetworkErrorView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b();
    }
}
