package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class NetworkErrorView extends CommonEmptyView {

    /* loaded from: classes3.dex */
    public static class a {
        public Object a;

        public a(int i) {
        }
    }

    public NetworkErrorView(Context context) {
        super(context);
        b();
    }

    public static void c(View view2) {
        a aVar = new a(1);
        aVar.a = view2;
        BdEventBus.Companion.getDefault().post(aVar);
    }

    public void setEmptyButtonVisiblity(int i) {
        this.e.setVisibility(i);
    }

    public void setEmptyViewVisiblity(int i) {
        this.a.setVisibility(i);
    }

    public void setNetworkButtonShow(boolean z) {
        int i;
        TextView textView = this.d;
        if (textView != null) {
            if (z) {
                i = 0;
            } else {
                i = 4;
            }
            textView.setVisibility(i);
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

    public void setBottomLayout(View.OnClickListener onClickListener, View view2, RelativeLayout.LayoutParams layoutParams) {
        FrameLayout frameLayout = this.f;
        if (frameLayout != null && view2 != null) {
            frameLayout.setVisibility(0);
            this.f.addView(view2);
            if (layoutParams != null) {
                this.f.setLayoutParams(layoutParams);
            }
            this.f.setOnClickListener(onClickListener);
        }
    }

    public final void b() {
        this.e.setVisibility(0);
        setTitle(getContext().getString(R.string.obfuscated_res_0x7f0f1413));
        setIcon(R.drawable.obfuscated_res_0x7f081264);
    }
}
