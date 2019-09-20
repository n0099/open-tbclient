package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.android.app.event.EventBusWrapper;
/* loaded from: classes2.dex */
public class NetworkErrorView extends CommonEmptyView {
    public NetworkErrorView(Context context) {
        super(context);
        this.aJl.setVisibility(0);
    }

    public NetworkErrorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aJl.setVisibility(0);
    }

    public NetworkErrorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aJl.setVisibility(0);
    }

    public void setReloadClickListener(View.OnClickListener onClickListener) {
        setTextButtonClickListener(onClickListener);
    }

    public void setEmptyViewVisiblity(int i) {
        this.mIcon.setVisibility(i);
    }

    public void setEmptyButtonVisiblity(int i) {
        this.aJl.setVisibility(i);
    }

    public void setNetworkButtonShow(boolean z) {
        if (this.aJk != null) {
            this.aJk.setVisibility(z ? 0 : 4);
        }
    }

    public void setBottomLayout(View.OnClickListener onClickListener, View view, RelativeLayout.LayoutParams layoutParams) {
        if (this.aJm != null && view != null) {
            this.aJm.setVisibility(0);
            this.aJm.addView(view);
            if (layoutParams != null) {
                this.aJm.setLayoutParams(layoutParams);
            }
            this.aJm.setOnClickListener(onClickListener);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i == 0) {
            aa(this);
        }
        super.setVisibility(i);
    }

    public static void aa(View view) {
        a aVar = new a(1);
        aVar.aKi = 1;
        aVar.Kv = view;
        EventBusWrapper.post(aVar);
    }

    /* loaded from: classes2.dex */
    public static class a {
        public Object Kv;
        public int aKi;
        public int messageId;

        public a(int i) {
            this.messageId = i;
        }
    }
}
