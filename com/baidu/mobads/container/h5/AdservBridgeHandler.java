package com.baidu.mobads.container.h5;

import android.webkit.WebView;
import com.baidu.mobads.container.XBaseHtmlAdContainer;
import com.baidu.mobads.container.adrequest.XAdContainerContext;
import com.baidu.mobads.container.bridge.BaseHtmlBridgeHandler;
import com.baidu.mobads.container.bridge.BridgeListener;
import com.baidu.mobads.container.info.XDeviceInfo;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AdservBridgeHandler extends BaseHtmlBridgeHandler {
    public AdservBridgeHandler(XBaseHtmlAdContainer xBaseHtmlAdContainer, WebView webView, BridgeListener bridgeListener, XAdContainerContext xAdContainerContext) {
        super(xBaseHtmlAdContainer, webView, bridgeListener, xAdContainerContext);
    }

    @Override // com.baidu.mobads.container.bridge.BaseHtmlBridgeHandler
    public JSONObject getConfs() {
        return new XDeviceInfo(this.mAdContainerCxt).getConfs();
    }
}
