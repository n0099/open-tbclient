package com.baidu.mobads.container.template;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.baidu.mobads.container.XBaseAdContainer;
import com.baidu.mobads.container.XBaseHtmlAdContainer;
import com.baidu.mobads.container.XMyWebView;
import com.baidu.mobads.container.XMyWebViewClient;
import com.baidu.mobads.container.adrequest.IXAdInstanceInfo;
import com.baidu.mobads.container.adrequest.XAdContainerContext;
import com.baidu.mobads.container.bridge.BaiduAppJsBridgeHandler;
import com.baidu.mobads.container.bridge.BaseHtmlBridgeHandler;
import com.baidu.mobads.container.bridge.BridgeJavascript;
import com.baidu.mobads.container.bridge.BridgeListener;
import com.baidu.mobads.container.components.utils.XAdRemoteClickHandler;
import com.baidu.mobads.container.error.XAdErrorCode;
import com.baidu.mobads.container.executor.BaseTask;
import com.baidu.mobads.container.executor.TaskScheduler;
import com.baidu.mobads.container.util.PackageUtils;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.sapi2.SapiWebView;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class XTemplateAdContainer extends XBaseHtmlAdContainer {
    public static final String TAG = "XTemplateAdContainer";
    public BridgeListener bridgeListener;
    public boolean isLogSended;
    public BaiduAppJsBridgeHandler mBaiduAppJsBridgeHandler;
    public boolean mCloseHardwareAccelerate;
    public boolean mHorizontalScrollBarEnabled;
    public boolean mLoaded;
    public boolean mVerticalScrollBarEnabled;

    public XTemplateAdContainer(XAdContainerContext xAdContainerContext) {
        super(xAdContainerContext);
        this.mLoaded = false;
        this.isLogSended = false;
        this.mCloseHardwareAccelerate = true;
        this.mVerticalScrollBarEnabled = false;
        this.mHorizontalScrollBarEnabled = false;
        this.bridgeListener = new BridgeListener() { // from class: com.baidu.mobads.container.template.XTemplateAdContainer.2
            @Override // com.baidu.mobads.container.bridge.BridgeListener
            public void onAdClicked(IXAdInstanceInfo iXAdInstanceInfo) {
                if ("rsplash".equals(XTemplateAdContainer.this.mAdContainerCxt.getAdProd())) {
                    boolean optBoolean = XTemplateAdContainer.this.mAdContainerCxt.getAdReqParam().optBoolean("popDialogIfDl", true);
                    PackageUtils.sendRsplashLog(XTemplateAdContainer.this.mAppContext, XTemplateAdContainer.this.mAdContainerCxt, PackageUtils.RSPLASH_HTML_LOG, 7);
                    XTemplateAdContainer xTemplateAdContainer = XTemplateAdContainer.this;
                    HashMap<String, Object> shouBaiLpFlag = xTemplateAdContainer.getShouBaiLpFlag(xTemplateAdContainer.mAdContainerCxt, iXAdInstanceInfo);
                    if (shouBaiLpFlag == null) {
                        shouBaiLpFlag = new HashMap<>();
                    }
                    shouBaiLpFlag.put(XBaseAdContainer.USE_DIALOG_FRAME, Boolean.valueOf(optBoolean));
                    new XAdRemoteClickHandler().onAdClicked(XTemplateAdContainer.this, iXAdInstanceInfo, Boolean.TRUE, shouBaiLpFlag);
                } else {
                    XAdRemoteClickHandler xAdRemoteClickHandler = new XAdRemoteClickHandler();
                    XTemplateAdContainer xTemplateAdContainer2 = XTemplateAdContainer.this;
                    xAdRemoteClickHandler.onAdClicked(xTemplateAdContainer2, iXAdInstanceInfo, Boolean.TRUE, xTemplateAdContainer2.getShouBaiLpFlag(xTemplateAdContainer2.mAdContainerCxt, iXAdInstanceInfo));
                }
                XTemplateAdContainer.this.onAdClick();
            }

            @Override // com.baidu.mobads.container.bridge.BridgeListener
            public void onAdFailed(String str) {
            }

            @Override // com.baidu.mobads.container.bridge.BridgeListener
            public void onAdShow() {
            }

            @Override // com.baidu.mobads.container.bridge.BridgeListener
            public void onAdSwitch() {
            }

            @Override // com.baidu.mobads.container.bridge.BridgeListener
            public void onClose() {
            }

            @Override // com.baidu.mobads.container.bridge.BridgeListener
            public void onExpand(boolean z) {
            }

            @Override // com.baidu.mobads.container.bridge.BridgeListener
            public void onInited() {
            }

            @Override // com.baidu.mobads.container.bridge.BridgeListener
            public void onPlayVideo(String str) {
            }

            @Override // com.baidu.mobads.container.bridge.BridgeListener
            public void onPreloadEnd(boolean z) {
            }

            @Override // com.baidu.mobads.container.bridge.BridgeListener
            public void onUseCustomClose(boolean z) {
            }

            @Override // com.baidu.mobads.container.bridge.BridgeListener
            public void onVisibilityChanged(boolean z) {
            }

            @Override // com.baidu.mobads.container.bridge.BridgeListener
            public void setVisibility(int i) {
            }
        };
    }

    public boolean closeHardwareAccelerated() {
        return this.mCloseHardwareAccelerate;
    }

    public void doInteractByCpuTemplateContainer(Uri uri) {
    }

    @Override // com.baidu.mobads.container.XBaseAdContainer
    public void doLoadOnUIThread() {
        if ("rsplash".equals(this.mAdContainerCxt.getAdProd())) {
            PackageUtils.sendRsplashLog(this.mAppContext, this.mAdContainerCxt, PackageUtils.RSPLASH_HTML_LOG, 1);
        }
        if (this.mAdContainerCxt.getAdInstanceInfo().getHtmlSnippet() != null && this.mAdContainerCxt.getAdInstanceInfo().getHtmlSnippet().length() > 0) {
            XMyWebView.ParameterInfo parameterInfo = new XMyWebView.ParameterInfo();
            parameterInfo.mCloseHardwareAccelerated = closeHardwareAccelerated();
            this.mWebView = XMyWebView.create(this.mAdContainerCxt.getActivity(), RemoteXAdLogger.getInstance(), true, true, parameterInfo);
            if (this.mAdContainerCxt.getAdProdBase() != null) {
                this.mWebView.setVisibility(4);
                this.mAdContainerCxt.getAdProdBase().addView(this.mWebView, new RelativeLayout.LayoutParams(-1, -1));
            }
            this.mWebView.setVerticalScrollBarEnabled(this.mVerticalScrollBarEnabled);
            this.mWebView.setHorizontalScrollBarEnabled(this.mHorizontalScrollBarEnabled);
            this.mWebView.setWebViewClient(new XMyWebViewClient() { // from class: com.baidu.mobads.container.template.XTemplateAdContainer.1
                @Override // android.webkit.WebViewClient
                public void onLoadResource(WebView webView, String str) {
                    super.onLoadResource(webView, str);
                    if (XTemplateAdContainer.this.isLogSended || !"rsplash".equals(XTemplateAdContainer.this.mAdContainerCxt.getAdProd())) {
                        return;
                    }
                    XTemplateAdContainer.this.isLogSended = true;
                    PackageUtils.sendRsplashLog(XTemplateAdContainer.this.mAppContext, XTemplateAdContainer.this.mAdContainerCxt, PackageUtils.RSPLASH_HTML_LOG, 9);
                }

                @Override // android.webkit.WebViewClient
                public void onPageFinished(WebView webView, String str) {
                    XTemplateAdContainer xTemplateAdContainer = XTemplateAdContainer.this;
                    xTemplateAdContainer.mLoaded = true;
                    if ("rsplash".equals(xTemplateAdContainer.mAdContainerCxt.getAdProd())) {
                        PackageUtils.sendRsplashLog(XTemplateAdContainer.this.mAppContext, XTemplateAdContainer.this.mAdContainerCxt, PackageUtils.RSPLASH_HTML_LOG, 3);
                    }
                    super.onPageFinished(webView, str);
                    if (XTemplateAdContainer.this.mBridgeHandler.needInjectJSWhenPageFinished()) {
                        BaseHtmlBridgeHandler baseHtmlBridgeHandler = XTemplateAdContainer.this.mBridgeHandler;
                        baseHtmlBridgeHandler.executeJavaScript("javascript:" + XTemplateAdContainer.this.getJavaScriptSnippet());
                    }
                    XTemplateAdContainer.this.mBridgeHandler.injectJS();
                    if (webView.getParent() != null) {
                        ((View) webView.getParent()).setBackgroundResource(0);
                    }
                    XTemplateAdContainer.this.mWebView.setVisibility(0);
                    XTemplateAdContainer.this.start();
                }

                @Override // android.webkit.WebViewClient
                public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                    super.onPageStarted(webView, str, bitmap);
                    if ("rsplash".equals(XTemplateAdContainer.this.mAdContainerCxt.getAdProd())) {
                        PackageUtils.sendRsplashLog(XTemplateAdContainer.this.mAppContext, XTemplateAdContainer.this.mAdContainerCxt, PackageUtils.RSPLASH_HTML_LOG, 8);
                    }
                }

                @Override // android.webkit.WebViewClient
                public void onReceivedError(WebView webView, int i, String str, String str2) {
                    super.onReceivedError(webView, i, str, str2);
                    if ("rsplash".equals(XTemplateAdContainer.this.mAdContainerCxt.getAdProd())) {
                        PackageUtils.sendRsplashLog(XTemplateAdContainer.this.mAppContext, XTemplateAdContainer.this.mAdContainerCxt, PackageUtils.RSPLASH_HTML_LOG, 5);
                    }
                    XTemplateAdContainer.this.mAdState = 2;
                    XTemplateAdContainer xTemplateAdContainer = XTemplateAdContainer.this;
                    XAdErrorCode xAdErrorCode = XAdErrorCode.NETWORK_UNCONNECT;
                    xTemplateAdContainer.processAdError(xAdErrorCode, "模板广告onReceivedError-" + i);
                }

                @Override // com.baidu.mobads.container.XMyWebViewClient, android.webkit.WebViewClient
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    if (XTemplateAdContainer.this.loadInSamePage(str).booleanValue()) {
                        webView.loadUrl(str);
                        return true;
                    }
                    try {
                        Uri parse = Uri.parse(str);
                        if (parse.getScheme().equals("nfs")) {
                            XTemplateAdContainer.this.doInteractByCpuTemplateContainer(parse);
                            return true;
                        }
                    } catch (Exception e2) {
                        XTemplateAdContainer.this.mAdLogger.i("shouldOverrideUrlLoading", str, e2);
                    }
                    try {
                        Uri parse2 = Uri.parse(str);
                        if (BridgeJavascript.BRIDGE_SCHEME.equals(parse2.getScheme())) {
                            return XTemplateAdContainer.this.mBridgeHandler.handleShouldOverrideUrlLoading(parse2);
                        }
                    } catch (Exception e3) {
                        XTemplateAdContainer.this.mAdLogger.i("shouldOverrideUrlLoading", str, e3);
                    }
                    try {
                        if (XTemplateAdContainer.this.mBaiduAppJsBridgeHandler != null && XTemplateAdContainer.this.mBaiduAppJsBridgeHandler.isJimuyuUrl(str)) {
                            XTemplateAdContainer.this.mBaiduAppJsBridgeHandler.handleShouldOverrideUrlLoading(str);
                            return true;
                        }
                    } catch (Throwable th) {
                        XTemplateAdContainer.this.mAdLogger.d(XTemplateAdContainer.TAG, th.getMessage());
                    }
                    XTemplateAdContainer.this.processShouldOverrideUrlLoading(str, webView);
                    return true;
                }
            });
            initBridgeHandler();
            loadData();
            return;
        }
        if ("rsplash".equals(this.mAdContainerCxt.getAdProd())) {
            PackageUtils.sendRsplashLog(this.mAppContext, this.mAdContainerCxt, PackageUtils.RSPLASH_HTML_LOG, 4);
        }
        processAdError(XAdErrorCode.RESPONSE_HTML_ERROR, "模板广告返回无模板素材");
    }

    @Override // com.baidu.mobads.container.XBaseAdContainer
    public void doStartOnUIThread() {
        if (this.mAdState != 2) {
            TaskScheduler.getInstance().submit(new BaseTask<Void>() { // from class: com.baidu.mobads.container.template.XTemplateAdContainer.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.mobads.container.executor.BaseTask
                public Void doInBackground() {
                    if ("rsplash".equals(XTemplateAdContainer.this.mAdContainerCxt.getAdProd())) {
                        PackageUtils.sendRsplashLog(XTemplateAdContainer.this.mAppContext, XTemplateAdContainer.this.mAdContainerCxt, PackageUtils.RSPLASH_HTML_LOG, 6);
                        XTemplateAdContainer.this.checkAndSendRsplashShowLog(2, null);
                    } else {
                        XTemplateAdContainer xTemplateAdContainer = XTemplateAdContainer.this;
                        xTemplateAdContainer.sendImpressionLog(xTemplateAdContainer.mAdContainerCxt.getAdInstanceInfo());
                        XTemplateAdContainer.this.send3rdImpressionLog();
                        XTemplateAdContainer.this.processAdStart();
                    }
                    if (PackageUtils.checkSendInstalled(XTemplateAdContainer.this.mAppContext)) {
                        PackageUtils.sendInstalled(XTemplateAdContainer.this.mAppContext, XTemplateAdContainer.this.mAdContainerCxt);
                        PackageUtils.sendSysInstalled(XTemplateAdContainer.this.mAppContext, XTemplateAdContainer.this.mAdContainerCxt);
                        PackageUtils.sendInfo(XTemplateAdContainer.this.mAppContext, XTemplateAdContainer.this.mAdContainerCxt);
                    }
                    return null;
                }
            }, 2);
        } else {
            this.mAdLogger.d("XH5SplashAdContainer: ad state is stopped, so can not show ad");
        }
    }

    @Override // com.baidu.mobads.container.XBaseAdContainer
    public View getAdView() {
        return this.mWebView;
    }

    public String getJavaScriptSnippet() {
        return XAdTemplateSDKJavaScript.STATIC_JAVASCRIPT_LIBRARY;
    }

    @Override // com.baidu.mobads.container.XBaseHtmlAdContainer
    public void initBridgeHandler() {
        this.mBridgeHandler = new TemplateBridgeHandler(this, this.mWebView, this.bridgeListener, this.mAdContainerCxt);
    }

    public void loadData() {
        String htmlSnippet = this.mAdContainerCxt.getAdInstanceInfo().getHtmlSnippet();
        this.isLogSended = false;
        if ("rsplash".equals(this.mAdContainerCxt.getAdProd())) {
            PackageUtils.sendRsplashLog(this.mAppContext, this.mAdContainerCxt, PackageUtils.RSPLASH_HTML_LOG, 2);
        }
        this.mWebView.loadDataWithBaseURL(null, htmlSnippet, SapiWebView.K, "UTF-8", null);
    }

    public Boolean loadInSamePage(String str) {
        return Boolean.FALSE;
    }

    public void onAdClick() {
    }

    @Override // com.baidu.mobads.container.XBaseAdContainer
    public void resetAdContainerName() {
    }

    public void setCloseHardwareAccelerated(boolean z) {
        this.mCloseHardwareAccelerate = z;
    }

    public void setHorizontalScrollBarEnabled(boolean z) {
        this.mHorizontalScrollBarEnabled = z;
    }

    public void setVerticalScrollBarEnabled(boolean z) {
        this.mVerticalScrollBarEnabled = z;
    }

    @Override // com.baidu.mobads.container.XBaseAdContainer
    public void start() {
        super.start();
    }

    @Override // com.baidu.mobads.container.XBaseAdContainer
    public void stop() {
        this.mAdState = 2;
    }
}
