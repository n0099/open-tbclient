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
        this.aGh.setVisibility(0);
    }

    public NetworkErrorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGh.setVisibility(0);
    }

    public NetworkErrorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aGh.setVisibility(0);
    }

    public void setReloadClickListener(View.OnClickListener onClickListener) {
        setTextButtonClickListener(onClickListener);
    }

    public void setEmptyViewVisiblity(int i) {
        this.mIcon.setVisibility(i);
    }

    public void setEmptyButtonVisiblity(int i) {
        this.aGh.setVisibility(i);
    }

    public void setNetworkButtonShow(boolean z) {
        if (this.aGg != null) {
            this.aGg.setVisibility(z ? 0 : 4);
        }
    }

    public void setBottomLayout(View.OnClickListener onClickListener, View view, RelativeLayout.LayoutParams layoutParams) {
        if (this.aGi != null && view != null) {
            this.aGi.setVisibility(0);
            this.aGi.addView(view);
            if (layoutParams != null) {
                this.aGi.setLayoutParams(layoutParams);
            }
            this.aGi.setOnClickListener(onClickListener);
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
        aVar.aHe = 1;
        aVar.obj = view;
        EventBusWrapper.post(aVar);
    }

    /* loaded from: classes2.dex */
    public static class a {
        public int aHe;
        public int messageId;
        public Object obj;

        public a(int i) {
            this.messageId = i;
        }
    }
}
