package com.baidu.mobads.container.h5;

import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.mobads.container.XBaseHtmlAdContainer;
import com.baidu.mobads.container.XMyWebView;
import com.baidu.mobads.container.adrequest.IXAdInstanceInfo;
import com.baidu.mobads.container.adrequest.XAdContainerContext;
import com.baidu.mobads.container.bridge.BridgeJavascript;
import com.baidu.mobads.container.bridge.BridgeListener;
import com.baidu.mobads.container.components.utils.XAdRemoteClickHandler;
import com.baidu.mobads.container.error.XAdErrorCode;
import com.baidu.mobads.container.executor.BaseTask;
import com.baidu.mobads.container.executor.TaskScheduler;
import com.baidu.mobads.container.util.AdURIUtils;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.mobads.container.util.network.NetworkInfoUtils;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class XAdservAdContainer extends XBaseHtmlAdContainer {
    public static final String ADSERV_URL = "http://mobads.baidu.com/ads/index.htm";
    public static String ADSERV_VERSION_CODE = "adserv_0";
    public static boolean hasCallAdservVersion;
    public BridgeListener bridgeListener;
    public boolean hasAdFailured;
    public boolean inited;
    public boolean isDetached;
    public boolean isRetrying;
    public long mTimestampOfHtmlLoaded;
    public long mTimestampOfStartLoadHtml;

    public XAdservAdContainer(XAdContainerContext xAdContainerContext) {
        super(xAdContainerContext);
        this.inited = false;
        this.isRetrying = false;
        this.hasAdFailured = false;
        this.isDetached = false;
        this.bridgeListener = new BridgeListener() { // from class: com.baidu.mobads.container.h5.XAdservAdContainer.1
            @Override // com.baidu.mobads.container.bridge.BridgeListener
            public void onAdClicked(IXAdInstanceInfo iXAdInstanceInfo) {
                boolean z = false;
                try {
                    JSONObject originJsonObject = iXAdInstanceInfo.getOriginJsonObject();
                    JSONObject jSONObject = originJsonObject != null ? new JSONObject(originJsonObject.optString("control_flags")) : null;
                    if (jSONObject != null) {
                        z = jSONObject.optBoolean("enable_deeplink_flag");
                    }
                } catch (Exception unused) {
                }
                if (z && iXAdInstanceInfo.getActionType() == 512) {
                    iXAdInstanceInfo.setClickThroughUrl("https://mobads-logs.baidu.com/dz.zb?type=425");
                    XAdservAdContainer.this.pullShoubaiExp(iXAdInstanceInfo);
                    return;
                }
                XAdRemoteClickHandler xAdRemoteClickHandler = new XAdRemoteClickHandler();
                XAdservAdContainer xAdservAdContainer = XAdservAdContainer.this;
                xAdRemoteClickHandler.onAdClicked(xAdservAdContainer, iXAdInstanceInfo, Boolean.TRUE, xAdservAdContainer.getShouBaiLpFlag(xAdservAdContainer.mAdContainerCxt, iXAdInstanceInfo));
            }

            @Override // com.baidu.mobads.container.bridge.BridgeListener
            public void onAdFailed(String str) {
                XAdservAdContainer.this.processAdError(XAdErrorCode.WEBVIEW_LOAD_ERROR, str);
            }

            @Override // com.baidu.mobads.container.bridge.BridgeListener
            public void onAdShow() {
                XAdservAdContainer.this.processAdStart();
            }

            @Override // com.baidu.mobads.container.bridge.BridgeListener
            public void onAdSwitch() {
            }

            @Override // com.baidu.mobads.container.bridge.BridgeListener
            public void onClose() {
                XAdservAdContainer.this.handleAdClose();
            }

            @Override // com.baidu.mobads.container.bridge.BridgeListener
            public void onExpand(boolean z) {
                XAdservAdContainer.this.handleExpand(z);
            }

            @Override // com.baidu.mobads.container.bridge.BridgeListener
            public void onInited() {
                XAdservAdContainer.this.inited = true;
            }

            @Override // com.baidu.mobads.container.bridge.BridgeListener
            public void onPlayVideo(String str) {
                XAdservAdContainer.this.handlePlayVideo(str);
            }

            @Override // com.baidu.mobads.container.bridge.BridgeListener
            public void onPreloadEnd(boolean z) {
                XAdservAdContainer.this.handlePreloadEnd(z);
            }

            @Override // com.baidu.mobads.container.bridge.BridgeListener
            public void onUseCustomClose(boolean z) {
                XAdservAdContainer.this.handleUseCustomClose(z);
            }

            @Override // com.baidu.mobads.container.bridge.BridgeListener
            public void onVisibilityChanged(boolean z) {
            }

            @Override // com.baidu.mobads.container.bridge.BridgeListener
            public void setVisibility(int i) {
            }
        };
        initWebView(xAdContainerContext.getActivity());
    }

    private void initWebView(Context context) {
        XMyWebView create = XMyWebView.create(context, RemoteXAdLogger.getInstance(), true, true);
        this.mWebView = create;
        create.setWebViewClient(new WebViewClient() { // from class: com.baidu.mobads.container.h5.XAdservAdContainer.2
            @Override // android.webkit.WebViewClient
            public void onLoadResource(WebView webView, String str) {
                super.onLoadResource(webView, str);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                XAdservAdContainer.this.mTimestampOfHtmlLoaded = System.currentTimeMillis();
                super.onPageFinished(webView, str);
                XAdservAdContainer.this.mBridgeHandler.injectJS();
                if (XAdservAdContainer.this.mBridgeHandler.needInjectJSWhenPageFinished()) {
                    XAdservAdContainer.this.mBridgeHandler.preLoadAd();
                }
                XAdservAdContainer.this.mAdLogger.d("AdContainer onPageFinished");
                XAdservAdContainer.this.isRetrying = false;
                if (XAdservAdContainer.hasCallAdservVersion) {
                    return;
                }
                boolean unused = XAdservAdContainer.hasCallAdservVersion = true;
                if (Build.VERSION.SDK_INT >= 19) {
                    XAdservAdContainer.this.mWebView.evaluateJavascript(BridgeJavascript.JS_GET_ADSERV_VERSION, new ValueCallback<String>() { // from class: com.baidu.mobads.container.h5.XAdservAdContainer.2.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str2) {
                            XAdservAdContainer.ADSERV_VERSION_CODE = str2;
                        }
                    });
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, final int i, String str, String str2) {
                XAdservAdContainer.this.mAdLogger.d("AdContainer onReceivedError", Integer.valueOf(i), str, str2);
                if ("banner".equals(XAdservAdContainer.this.mAdContainerCxt.getAdProd()) && str2.startsWith(AdURIUtils.replaceURLWithSupportProtocol("http://mobads.baidu.com/ads/index.htm"))) {
                    if (!XAdservAdContainer.this.isRetrying && !XAdservAdContainer.this.hasAdFailured) {
                        XAdservAdContainer.this.mAdContainerCxt.getAdProdBase().post(new Runnable() { // from class: com.baidu.mobads.container.h5.XAdservAdContainer.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                XAdservAdContainer xAdservAdContainer = XAdservAdContainer.this;
                                XAdErrorCode xAdErrorCode = XAdErrorCode.NETWORK_UNCONNECT;
                                xAdservAdContainer.processAdError(xAdErrorCode, "html_onReceivedError-" + i);
                            }
                        });
                    }
                    XAdservAdContainer.this.retryLoading();
                }
                super.onReceivedError(webView, i, str, str2);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
                XAdservAdContainer.this.mAdLogger.d("AdContainer error & proceed!");
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                try {
                    Uri parse = Uri.parse(str);
                    if (BridgeJavascript.BRIDGE_SCHEME.equals(parse.getScheme())) {
                        return XAdservAdContainer.this.mBridgeHandler.handleShouldOverrideUrlLoading(parse);
                    }
                } catch (Exception e2) {
                    XAdservAdContainer.this.mAdLogger.i("shouldOverrideUrlLoading", str, e2);
                }
                return XAdservAdContainer.this.processShouldOverrideUrlLoading(str, webView);
            }
        });
        initBridgeHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void retryLoading() {
        this.mAdLogger.d("adContainer.retryLoading");
        this.isRetrying = true;
        TaskScheduler.getInstance().submitWithDelay(new BaseTask() { // from class: com.baidu.mobads.container.h5.XAdservAdContainer.3
            @Override // com.baidu.mobads.container.executor.BaseTask
            public Object doInBackground() {
                try {
                    if (!XAdservAdContainer.this.isDetached) {
                        if (NetworkInfoUtils.isCurrentNetworkAvailable(XAdservAdContainer.this.mAppContext)) {
                            XAdservAdContainer.this.mAdContainerCxt.getAdProdBase().post(new Runnable() { // from class: com.baidu.mobads.container.h5.XAdservAdContainer.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (XAdservAdContainer.this.mWebView != null) {
                                        XAdservAdContainer.this.mWebView.loadUrl(AdURIUtils.replaceURLWithSupportProtocol("http://mobads.baidu.com/ads/index.htm"));
                                    }
                                }
                            });
                        } else if (!XAdservAdContainer.this.mWebView.isDestroy()) {
                            XAdservAdContainer.this.retryLoading();
                        }
                    }
                    return null;
                } catch (Exception e2) {
                    XAdservAdContainer.this.mAdLogger.d(e2);
                    return null;
                }
            }
        }, 5L, TimeUnit.SECONDS);
    }

    public void handleAdClose() {
    }

    public void handlePlayVideo(String str) {
    }

    public void handlePreloadEnd(boolean z) {
    }

    @Override // com.baidu.mobads.container.XBaseHtmlAdContainer
    public void initBridgeHandler() {
        this.mBridgeHandler = new AdservBridgeHandler(this, this.mWebView, this.bridgeListener, this.mAdContainerCxt);
    }

    public boolean isInited() {
        return this.inited;
    }

    public void onDetached() {
        this.isDetached = true;
        if (this.inited) {
            this.mAdLogger.d("AdContainer.onDetached");
            this.mBridgeHandler.detachViewFromViewTree();
        }
    }

    public void setInited(boolean z) {
        this.inited = z;
    }
}
