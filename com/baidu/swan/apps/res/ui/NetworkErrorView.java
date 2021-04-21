package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.app.event.EventBusWrapper;
import d.b.h0.a.h;
/* loaded from: classes3.dex */
public class NetworkErrorView extends CommonEmptyView {

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Object f12138a;

        public a(int i) {
        }
    }

    public NetworkErrorView(Context context) {
        super(context);
        b();
    }

    public static void c(View view) {
        a aVar = new a(1);
        aVar.f12138a = view;
        EventBusWrapper.post(aVar);
    }

    public final void b() {
        this.i.setVisibility(0);
        setTitle(getContext().getString(h.aiapps_common_emptyview_detail_text));
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

    public void setEmptyButtonVisiblity(int i) {
        this.i.setVisibility(i);
    }

    public void setEmptyViewVisiblity(int i) {
        this.f12111e.setVisibility(i);
    }

    public void setNetworkButtonShow(boolean z) {
        TextView textView = this.f12114h;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 4);
        }
    }

    public void setReloadClickListener(View.OnClickListener onClickListener) {
        setTextButtonClickListener(onClickListener);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i == 0) {
            c(this);
        }
        super.setVisibility(i);
    }

    public NetworkErrorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public NetworkErrorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }
}
