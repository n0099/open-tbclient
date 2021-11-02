package com.baidu.mobads.container.template;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class XTemplateAdContainer extends XBaseHtmlAdContainer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "XTemplateAdContainer";
    public transient /* synthetic */ FieldHolder $fh;
    public BridgeListener bridgeListener;
    public boolean isLogSended;
    public BaiduAppJsBridgeHandler mBaiduAppJsBridgeHandler;
    public boolean mCloseHardwareAccelerate;
    public boolean mHorizontalScrollBarEnabled;
    public boolean mLoaded;
    public boolean mVerticalScrollBarEnabled;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XTemplateAdContainer(XAdContainerContext xAdContainerContext) {
        super(xAdContainerContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xAdContainerContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((XAdContainerContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLoaded = false;
        this.isLogSended = false;
        this.mCloseHardwareAccelerate = true;
        this.mVerticalScrollBarEnabled = false;
        this.mHorizontalScrollBarEnabled = false;
        this.bridgeListener = new BridgeListener(this) { // from class: com.baidu.mobads.container.template.XTemplateAdContainer.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ XTemplateAdContainer this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.mobads.container.bridge.BridgeListener
            public void onAdClicked(IXAdInstanceInfo iXAdInstanceInfo) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, iXAdInstanceInfo) == null) {
                    if ("rsplash".equals(this.this$0.mAdContainerCxt.getAdProd())) {
                        boolean optBoolean = this.this$0.mAdContainerCxt.getAdReqParam().optBoolean("popDialogIfDl", true);
                        PackageUtils.sendRsplashLog(this.this$0.mAppContext, this.this$0.mAdContainerCxt, PackageUtils.RSPLASH_HTML_LOG, 7);
                        XTemplateAdContainer xTemplateAdContainer = this.this$0;
                        HashMap<String, Object> shouBaiLpFlag = xTemplateAdContainer.getShouBaiLpFlag(xTemplateAdContainer.mAdContainerCxt, iXAdInstanceInfo);
                        if (shouBaiLpFlag == null) {
                            shouBaiLpFlag = new HashMap<>();
                        }
                        shouBaiLpFlag.put(XBaseAdContainer.USE_DIALOG_FRAME, Boolean.valueOf(optBoolean));
                        new XAdRemoteClickHandler().onAdClicked(this.this$0, iXAdInstanceInfo, Boolean.TRUE, shouBaiLpFlag);
                    } else {
                        XAdRemoteClickHandler xAdRemoteClickHandler = new XAdRemoteClickHandler();
                        XTemplateAdContainer xTemplateAdContainer2 = this.this$0;
                        xAdRemoteClickHandler.onAdClicked(xTemplateAdContainer2, iXAdInstanceInfo, Boolean.TRUE, xTemplateAdContainer2.getShouBaiLpFlag(xTemplateAdContainer2.mAdContainerCxt, iXAdInstanceInfo));
                    }
                    this.this$0.onAdClick();
                }
            }

            @Override // com.baidu.mobads.container.bridge.BridgeListener
            public void onAdFailed(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                }
            }

            @Override // com.baidu.mobads.container.bridge.BridgeListener
            public void onAdShow() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                }
            }

            @Override // com.baidu.mobads.container.bridge.BridgeListener
            public void onAdSwitch() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                }
            }

            @Override // com.baidu.mobads.container.bridge.BridgeListener
            public void onClose() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                }
            }

            @Override // com.baidu.mobads.container.bridge.BridgeListener
            public void onExpand(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048581, this, z) == null) {
                }
            }

            @Override // com.baidu.mobads.container.bridge.BridgeListener
            public void onInited() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048582, this) == null) {
                }
            }

            @Override // com.baidu.mobads.container.bridge.BridgeListener
            public void onPlayVideo(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048583, this, str) == null) {
                }
            }

            @Override // com.baidu.mobads.container.bridge.BridgeListener
            public void onPreloadEnd(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
                }
            }

            @Override // com.baidu.mobads.container.bridge.BridgeListener
            public void onUseCustomClose(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048585, this, z) == null) {
                }
            }

            @Override // com.baidu.mobads.container.bridge.BridgeListener
            public void onVisibilityChanged(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048586, this, z) == null) {
                }
            }

            @Override // com.baidu.mobads.container.bridge.BridgeListener
            public void setVisibility(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048587, this, i4) == null) {
                }
            }
        };
    }

    public boolean closeHardwareAccelerated() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mCloseHardwareAccelerate : invokeV.booleanValue;
    }

    public void doInteractByCpuTemplateContainer(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri) == null) {
        }
    }

    @Override // com.baidu.mobads.container.XBaseAdContainer
    public void doLoadOnUIThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
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
                this.mWebView.setWebViewClient(new XMyWebViewClient(this) { // from class: com.baidu.mobads.container.template.XTemplateAdContainer.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ XTemplateAdContainer this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // android.webkit.WebViewClient
                    public void onLoadResource(WebView webView, String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, webView, str) == null) {
                            super.onLoadResource(webView, str);
                            if (this.this$0.isLogSended || !"rsplash".equals(this.this$0.mAdContainerCxt.getAdProd())) {
                                return;
                            }
                            this.this$0.isLogSended = true;
                            PackageUtils.sendRsplashLog(this.this$0.mAppContext, this.this$0.mAdContainerCxt, PackageUtils.RSPLASH_HTML_LOG, 9);
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str) == null) {
                            XTemplateAdContainer xTemplateAdContainer = this.this$0;
                            xTemplateAdContainer.mLoaded = true;
                            if ("rsplash".equals(xTemplateAdContainer.mAdContainerCxt.getAdProd())) {
                                PackageUtils.sendRsplashLog(this.this$0.mAppContext, this.this$0.mAdContainerCxt, PackageUtils.RSPLASH_HTML_LOG, 3);
                            }
                            super.onPageFinished(webView, str);
                            if (this.this$0.mBridgeHandler.needInjectJSWhenPageFinished()) {
                                BaseHtmlBridgeHandler baseHtmlBridgeHandler = this.this$0.mBridgeHandler;
                                baseHtmlBridgeHandler.executeJavaScript("javascript:" + this.this$0.getJavaScriptSnippet());
                            }
                            this.this$0.mBridgeHandler.injectJS();
                            if (webView.getParent() != null) {
                                ((View) webView.getParent()).setBackgroundResource(0);
                            }
                            this.this$0.mWebView.setVisibility(0);
                            this.this$0.start();
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, bitmap) == null) {
                            super.onPageStarted(webView, str, bitmap);
                            if ("rsplash".equals(this.this$0.mAdContainerCxt.getAdProd())) {
                                PackageUtils.sendRsplashLog(this.this$0.mAppContext, this.this$0.mAdContainerCxt, PackageUtils.RSPLASH_HTML_LOG, 8);
                            }
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i2, String str, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLILL(1048579, this, webView, i2, str, str2) == null) {
                            super.onReceivedError(webView, i2, str, str2);
                            if ("rsplash".equals(this.this$0.mAdContainerCxt.getAdProd())) {
                                PackageUtils.sendRsplashLog(this.this$0.mAppContext, this.this$0.mAdContainerCxt, PackageUtils.RSPLASH_HTML_LOG, 5);
                            }
                            this.this$0.mAdState = 2;
                            XTemplateAdContainer xTemplateAdContainer = this.this$0;
                            XAdErrorCode xAdErrorCode = XAdErrorCode.NETWORK_UNCONNECT;
                            xTemplateAdContainer.processAdError(xAdErrorCode, "模板广告onReceivedError-" + i2);
                        }
                    }

                    @Override // com.baidu.mobads.container.XMyWebViewClient, android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048580, this, webView, str)) == null) {
                            if (this.this$0.loadInSamePage(str).booleanValue()) {
                                webView.loadUrl(str);
                                return true;
                            }
                            try {
                                Uri parse = Uri.parse(str);
                                if (parse.getScheme().equals("nfs")) {
                                    this.this$0.doInteractByCpuTemplateContainer(parse);
                                    return true;
                                }
                            } catch (Exception e2) {
                                this.this$0.mAdLogger.i("shouldOverrideUrlLoading", str, e2);
                            }
                            try {
                                Uri parse2 = Uri.parse(str);
                                if (BridgeJavascript.BRIDGE_SCHEME.equals(parse2.getScheme())) {
                                    return this.this$0.mBridgeHandler.handleShouldOverrideUrlLoading(parse2);
                                }
                            } catch (Exception e3) {
                                this.this$0.mAdLogger.i("shouldOverrideUrlLoading", str, e3);
                            }
                            try {
                                if (this.this$0.mBaiduAppJsBridgeHandler != null && this.this$0.mBaiduAppJsBridgeHandler.isJimuyuUrl(str)) {
                                    this.this$0.mBaiduAppJsBridgeHandler.handleShouldOverrideUrlLoading(str);
                                    return true;
                                }
                            } catch (Throwable th) {
                                this.this$0.mAdLogger.d(XTemplateAdContainer.TAG, th.getMessage());
                            }
                            this.this$0.processShouldOverrideUrlLoading(str, webView);
                            return true;
                        }
                        return invokeLL.booleanValue;
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
    }

    @Override // com.baidu.mobads.container.XBaseAdContainer
    public void doStartOnUIThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.mAdState != 2) {
                TaskScheduler.getInstance().submit(new BaseTask<Void>(this) { // from class: com.baidu.mobads.container.template.XTemplateAdContainer.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ XTemplateAdContainer this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.mobads.container.executor.BaseTask
                    public Void doInBackground() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                            if ("rsplash".equals(this.this$0.mAdContainerCxt.getAdProd())) {
                                PackageUtils.sendRsplashLog(this.this$0.mAppContext, this.this$0.mAdContainerCxt, PackageUtils.RSPLASH_HTML_LOG, 6);
                                this.this$0.checkAndSendRsplashShowLog(2, null);
                            } else {
                                XTemplateAdContainer xTemplateAdContainer = this.this$0;
                                xTemplateAdContainer.sendImpressionLog(xTemplateAdContainer.mAdContainerCxt.getAdInstanceInfo());
                                this.this$0.send3rdImpressionLog();
                                this.this$0.processAdStart();
                            }
                            if (PackageUtils.checkSendInstalled(this.this$0.mAppContext)) {
                                PackageUtils.sendInstalled(this.this$0.mAppContext, this.this$0.mAdContainerCxt);
                                PackageUtils.sendSysInstalled(this.this$0.mAppContext, this.this$0.mAdContainerCxt);
                                PackageUtils.sendInfo(this.this$0.mAppContext, this.this$0.mAdContainerCxt);
                            }
                            return null;
                        }
                        return (Void) invokeV.objValue;
                    }
                }, 2);
            } else {
                this.mAdLogger.d("XH5SplashAdContainer: ad state is stopped, so can not show ad");
            }
        }
    }

    @Override // com.baidu.mobads.container.XBaseAdContainer
    public View getAdView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mWebView : (View) invokeV.objValue;
    }

    public String getJavaScriptSnippet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? XAdTemplateSDKJavaScript.STATIC_JAVASCRIPT_LIBRARY : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.XBaseHtmlAdContainer
    public void initBridgeHandler() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.mBridgeHandler = new TemplateBridgeHandler(this, this.mWebView, this.bridgeListener, this.mAdContainerCxt);
        }
    }

    public void loadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            String htmlSnippet = this.mAdContainerCxt.getAdInstanceInfo().getHtmlSnippet();
            this.isLogSended = false;
            if ("rsplash".equals(this.mAdContainerCxt.getAdProd())) {
                PackageUtils.sendRsplashLog(this.mAppContext, this.mAdContainerCxt, PackageUtils.RSPLASH_HTML_LOG, 2);
            }
            this.mWebView.loadDataWithBaseURL(null, htmlSnippet, SapiWebView.DATA_MIME_TYPE, "UTF-8", null);
        }
    }

    public Boolean loadInSamePage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) ? Boolean.FALSE : (Boolean) invokeL.objValue;
    }

    public void onAdClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Override // com.baidu.mobads.container.XBaseAdContainer
    public void resetAdContainerName() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    public void setCloseHardwareAccelerated(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.mCloseHardwareAccelerate = z;
        }
    }

    public void setHorizontalScrollBarEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.mHorizontalScrollBarEnabled = z;
        }
    }

    public void setVerticalScrollBarEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.mVerticalScrollBarEnabled = z;
        }
    }

    @Override // com.baidu.mobads.container.XBaseAdContainer
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.start();
        }
    }

    @Override // com.baidu.mobads.container.XBaseAdContainer
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.mAdState = 2;
        }
    }
}
