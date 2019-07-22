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
        this.aIN.setVisibility(0);
    }

    public NetworkErrorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aIN.setVisibility(0);
    }

    public NetworkErrorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aIN.setVisibility(0);
    }

    public void setReloadClickListener(View.OnClickListener onClickListener) {
        setTextButtonClickListener(onClickListener);
    }

    public void setEmptyViewVisiblity(int i) {
        this.mIcon.setVisibility(i);
    }

    public void setEmptyButtonVisiblity(int i) {
        this.aIN.setVisibility(i);
    }

    public void setNetworkButtonShow(boolean z) {
        if (this.aIM != null) {
            this.aIM.setVisibility(z ? 0 : 4);
        }
    }

    public void setBottomLayout(View.OnClickListener onClickListener, View view, RelativeLayout.LayoutParams layoutParams) {
        if (this.aIO != null && view != null) {
            this.aIO.setVisibility(0);
            this.aIO.addView(view);
            if (layoutParams != null) {
                this.aIO.setLayoutParams(layoutParams);
            }
            this.aIO.setOnClickListener(onClickListener);
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
        aVar.aJK = 1;
        aVar.Kv = view;
        EventBusWrapper.post(aVar);
    }

    /* loaded from: classes2.dex */
    public static class a {
        public Object Kv;
        public int aJK;
        public int messageId;

        public a(int i) {
            this.messageId = i;
        }
    }
}
