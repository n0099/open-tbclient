package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.android.app.event.EventBusWrapper;
import com.baidu.swan.apps.a;
/* loaded from: classes9.dex */
public class NetworkErrorView extends CommonEmptyView {
    public NetworkErrorView(Context context) {
        super(context);
        init();
    }

    public NetworkErrorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public NetworkErrorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.dvt.setVisibility(0);
        setTitle(getContext().getString(a.h.aiapps_common_emptyview_detail_text));
    }

    public void setReloadClickListener(View.OnClickListener onClickListener) {
        setTextButtonClickListener(onClickListener);
    }

    public void setEmptyViewVisiblity(int i) {
        this.dvq.setVisibility(i);
    }

    public void setEmptyButtonVisiblity(int i) {
        this.dvt.setVisibility(i);
    }

    public void setNetworkButtonShow(boolean z) {
        if (this.dvs != null) {
            this.dvs.setVisibility(z ? 0 : 4);
        }
    }

    public void setBottomLayout(View.OnClickListener onClickListener, View view, RelativeLayout.LayoutParams layoutParams) {
        if (this.dvu != null && view != null) {
            this.dvu.setVisibility(0);
            this.dvu.addView(view);
            if (layoutParams != null) {
                this.dvu.setLayoutParams(layoutParams);
            }
            this.dvu.setOnClickListener(onClickListener);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i == 0) {
            aE(this);
        }
        super.setVisibility(i);
    }

    public static void aE(View view) {
        a aVar = new a(1);
        aVar.arg0 = 1;
        aVar.obj = view;
        EventBusWrapper.post(aVar);
    }

    /* loaded from: classes9.dex */
    public static class a {
        public int arg0;
        public int messageId;
        public Object obj;

        public a(int i) {
            this.messageId = i;
        }
    }
}
