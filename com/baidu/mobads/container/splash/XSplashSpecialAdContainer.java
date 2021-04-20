package com.baidu.mobads.container.splash;

import android.graphics.Color;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.container.XBaseAdContainer;
import com.baidu.mobads.container.adrequest.IXAdInstanceInfo;
import com.baidu.mobads.container.adrequest.XAdContainerContext;
import com.baidu.mobads.container.util.ScreenUtils;
/* loaded from: classes2.dex */
public abstract class XSplashSpecialAdContainer extends XBaseAdContainer {
    public IXAdInstanceInfo mAdInstanceInfo;
    public TextView textView;

    public XSplashSpecialAdContainer(XAdContainerContext xAdContainerContext) {
        super(xAdContainerContext);
        this.textView = null;
        this.mAdInstanceInfo = this.mAdContainerCxt.getAdInstanceInfo();
    }

    public void addWifiHint() {
        if ("bb3808eb".equals(this.mAdContainerCxt.getAppsid())) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = ScreenUtils.getPixel(this.mAppContext, 14);
        layoutParams.leftMargin = ScreenUtils.getPixel(this.mAppContext, 14);
        TextView textView = new TextView(this.mActivity);
        this.textView = textView;
        textView.setText("已于Wi-Fi环境预加载");
        this.textView.setTextColor(Color.parseColor("#999999"));
        this.textView.setTextSize(0, ScreenUtils.getPixel(this.mActivity, 11));
        this.mAdContainerCxt.getAdProdBase().addView(this.textView, layoutParams);
    }

    @Override // com.baidu.mobads.container.XBaseAdContainer
    public void destroy() {
        this.textView = null;
        super.destroy();
    }

    @Override // com.baidu.mobads.container.XBaseAdContainer
    public void load() {
        super.load();
    }
}
