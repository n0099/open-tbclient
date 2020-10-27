package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.android.app.event.EventBusWrapper;
import com.baidu.swan.apps.a;
/* loaded from: classes10.dex */
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
        this.mRefreshTextBtn.setVisibility(0);
        setTitle(getContext().getString(a.h.aiapps_common_emptyview_detail_text));
    }

    public void setReloadClickListener(View.OnClickListener onClickListener) {
        setTextButtonClickListener(onClickListener);
    }

    public void setEmptyViewVisiblity(int i) {
        this.mIcon.setVisibility(i);
    }

    public void setEmptyButtonVisiblity(int i) {
        this.mRefreshTextBtn.setVisibility(i);
    }

    public void setNetworkButtonShow(boolean z) {
        if (this.mLinkText != null) {
            this.mLinkText.setVisibility(z ? 0 : 4);
        }
    }

    public void setBottomLayout(View.OnClickListener onClickListener, View view, RelativeLayout.LayoutParams layoutParams) {
        if (this.mBottomLayout != null && view != null) {
            this.mBottomLayout.setVisibility(0);
            this.mBottomLayout.addView(view);
            if (layoutParams != null) {
                this.mBottomLayout.setLayoutParams(layoutParams);
            }
            this.mBottomLayout.setOnClickListener(onClickListener);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i == 0) {
            av(this);
        }
        super.setVisibility(i);
    }

    public static void av(View view) {
        a aVar = new a(1);
        aVar.arg0 = 1;
        aVar.obj = view;
        EventBusWrapper.post(aVar);
    }

    /* loaded from: classes10.dex */
    public static class a {
        public int arg0;
        public int messageId;
        public Object obj;

        public a(int i) {
            this.messageId = i;
        }
    }
}
