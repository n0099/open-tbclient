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
        this.aGm.setVisibility(0);
    }

    public NetworkErrorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGm.setVisibility(0);
    }

    public NetworkErrorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aGm.setVisibility(0);
    }

    public void setReloadClickListener(View.OnClickListener onClickListener) {
        setTextButtonClickListener(onClickListener);
    }

    public void setEmptyViewVisiblity(int i) {
        this.mIcon.setVisibility(i);
    }

    public void setEmptyButtonVisiblity(int i) {
        this.aGm.setVisibility(i);
    }

    public void setNetworkButtonShow(boolean z) {
        if (this.aGl != null) {
            this.aGl.setVisibility(z ? 0 : 4);
        }
    }

    public void setBottomLayout(View.OnClickListener onClickListener, View view, RelativeLayout.LayoutParams layoutParams) {
        if (this.aGn != null && view != null) {
            this.aGn.setVisibility(0);
            this.aGn.addView(view);
            if (layoutParams != null) {
                this.aGn.setLayoutParams(layoutParams);
            }
            this.aGn.setOnClickListener(onClickListener);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i == 0) {
            Y(this);
        }
        super.setVisibility(i);
    }

    public static void Y(View view) {
        a aVar = new a(1);
        aVar.aHj = 1;
        aVar.obj = view;
        EventBusWrapper.post(aVar);
    }

    /* loaded from: classes2.dex */
    public static class a {
        public int aHj;
        public int messageId;
        public Object obj;

        public a(int i) {
            this.messageId = i;
        }
    }
}
