package com.baidu.mobads.container.template;

import android.webkit.WebView;
import com.baidu.mobads.container.XBaseHtmlAdContainer;
import com.baidu.mobads.container.adrequest.XAdContainerContext;
import com.baidu.mobads.container.bridge.BaseHtmlBridgeHandler;
import com.baidu.mobads.container.bridge.BridgeListener;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class TemplateBridgeHandler extends BaseHtmlBridgeHandler {
    public TemplateBridgeHandler(XBaseHtmlAdContainer xBaseHtmlAdContainer, WebView webView, BridgeListener bridgeListener, XAdContainerContext xAdContainerContext) {
        super(xBaseHtmlAdContainer, webView, bridgeListener, xAdContainerContext);
    }

    @Override // com.baidu.mobads.container.bridge.BaseHtmlBridgeHandler
    public JSONObject getConfs() {
        return null;
    }
}
