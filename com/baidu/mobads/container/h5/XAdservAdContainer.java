package com.baidu.mobads.container.h5;

import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class XAdservAdContainer extends XBaseHtmlAdContainer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ADSERV_URL = "http://mobads.baidu.com/ads/index.htm";
    public static String ADSERV_VERSION_CODE = "adserv_0";
    public static boolean hasCallAdservVersion;
    public transient /* synthetic */ FieldHolder $fh;
    public BridgeListener bridgeListener;
    public boolean hasAdFailured;
    public boolean inited;
    public boolean isDetached;
    public boolean isRetrying;
    public long mTimestampOfHtmlLoaded;
    public long mTimestampOfStartLoadHtml;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(521417451, "Lcom/baidu/mobads/container/h5/XAdservAdContainer;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(521417451, "Lcom/baidu/mobads/container/h5/XAdservAdContainer;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XAdservAdContainer(XAdContainerContext xAdContainerContext) {
        super(xAdContainerContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xAdContainerContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((XAdContainerContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.inited = false;
        this.isRetrying = false;
        this.hasAdFailured = false;
        this.isDetached = false;
        this.bridgeListener = new BridgeListener(this) { // from class: com.baidu.mobads.container.h5.XAdservAdContainer.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ XAdservAdContainer this$0;

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
                        this.this$0.pullShoubaiExp(iXAdInstanceInfo);
                        return;
                    }
                    XAdRemoteClickHandler xAdRemoteClickHandler = new XAdRemoteClickHandler();
                    XAdservAdContainer xAdservAdContainer = this.this$0;
                    xAdRemoteClickHandler.onAdClicked(xAdservAdContainer, iXAdInstanceInfo, Boolean.TRUE, xAdservAdContainer.getShouBaiLpFlag(xAdservAdContainer.mAdContainerCxt, iXAdInstanceInfo));
                }
            }

            @Override // com.baidu.mobads.container.bridge.BridgeListener
            public void onAdFailed(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                    this.this$0.processAdError(XAdErrorCode.WEBVIEW_LOAD_ERROR, str);
                }
            }

            @Override // com.baidu.mobads.container.bridge.BridgeListener
            public void onAdShow() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.this$0.processAdStart();
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
                    this.this$0.handleAdClose();
                }
            }

            @Override // com.baidu.mobads.container.bridge.BridgeListener
            public void onExpand(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048581, this, z) == null) {
                    this.this$0.handleExpand(z);
                }
            }

            @Override // com.baidu.mobads.container.bridge.BridgeListener
            public void onInited() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048582, this) == null) {
                    this.this$0.inited = true;
                }
            }

            @Override // com.baidu.mobads.container.bridge.BridgeListener
            public void onPlayVideo(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048583, this, str) == null) {
                    this.this$0.handlePlayVideo(str);
                }
            }

            @Override // com.baidu.mobads.container.bridge.BridgeListener
            public void onPreloadEnd(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
                    this.this$0.handlePreloadEnd(z);
                }
            }

            @Override // com.baidu.mobads.container.bridge.BridgeListener
            public void onUseCustomClose(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048585, this, z) == null) {
                    this.this$0.handleUseCustomClose(z);
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
        initWebView(xAdContainerContext.getActivity());
    }

    private void initWebView(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65565, this, context) == null) {
            XMyWebView create = XMyWebView.create(context, RemoteXAdLogger.getInstance(), true, true);
            this.mWebView = create;
            create.setWebViewClient(new WebViewClient(this) { // from class: com.baidu.mobads.container.h5.XAdservAdContainer.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ XAdservAdContainer this$0;

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
                    }
                }

                @Override // android.webkit.WebViewClient
                public void onPageFinished(WebView webView, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str) == null) {
                        this.this$0.mTimestampOfHtmlLoaded = System.currentTimeMillis();
                        super.onPageFinished(webView, str);
                        this.this$0.mBridgeHandler.injectJS();
                        if (this.this$0.mBridgeHandler.needInjectJSWhenPageFinished()) {
                            this.this$0.mBridgeHandler.preLoadAd();
                        }
                        this.this$0.mAdLogger.d("AdContainer onPageFinished");
                        this.this$0.isRetrying = false;
                        if (XAdservAdContainer.hasCallAdservVersion) {
                            return;
                        }
                        boolean unused = XAdservAdContainer.hasCallAdservVersion = true;
                        if (Build.VERSION.SDK_INT >= 19) {
                            this.this$0.mWebView.evaluateJavascript(BridgeJavascript.JS_GET_ADSERV_VERSION, new ValueCallback<String>(this) { // from class: com.baidu.mobads.container.h5.XAdservAdContainer.2.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass2 this$1;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                }

                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // android.webkit.ValueCallback
                                public void onReceiveValue(String str2) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2) == null) {
                                        XAdservAdContainer.ADSERV_VERSION_CODE = str2;
                                    }
                                }
                            });
                        }
                    }
                }

                @Override // android.webkit.WebViewClient
                public void onReceivedError(WebView webView, int i2, String str, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i2, str, str2) == null) {
                        this.this$0.mAdLogger.d("AdContainer onReceivedError", Integer.valueOf(i2), str, str2);
                        if ("banner".equals(this.this$0.mAdContainerCxt.getAdProd()) && str2.startsWith(AdURIUtils.replaceURLWithSupportProtocol("http://mobads.baidu.com/ads/index.htm"))) {
                            if (!this.this$0.isRetrying && !this.this$0.hasAdFailured) {
                                this.this$0.mAdContainerCxt.getAdProdBase().post(new Runnable(this, i2) { // from class: com.baidu.mobads.container.h5.XAdservAdContainer.2.2
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass2 this$1;
                                    public final /* synthetic */ int val$errorCode;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, Integer.valueOf(i2)};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i3 = newInitContext.flag;
                                            if ((i3 & 1) != 0) {
                                                int i4 = i3 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$1 = this;
                                        this.val$errorCode = i2;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            XAdservAdContainer xAdservAdContainer = this.this$1.this$0;
                                            XAdErrorCode xAdErrorCode = XAdErrorCode.NETWORK_UNCONNECT;
                                            xAdservAdContainer.processAdError(xAdErrorCode, "html_onReceivedError-" + this.val$errorCode);
                                        }
                                    }
                                });
                            }
                            this.this$0.retryLoading();
                        }
                        super.onReceivedError(webView, i2, str, str2);
                    }
                }

                @Override // android.webkit.WebViewClient
                public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(1048579, this, webView, sslErrorHandler, sslError) == null) {
                        super.onReceivedSslError(webView, sslErrorHandler, sslError);
                        this.this$0.mAdLogger.d("AdContainer error & proceed!");
                    }
                }

                @Override // android.webkit.WebViewClient
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048580, this, webView, str)) == null) {
                        try {
                            Uri parse = Uri.parse(str);
                            if (BridgeJavascript.BRIDGE_SCHEME.equals(parse.getScheme())) {
                                return this.this$0.mBridgeHandler.handleShouldOverrideUrlLoading(parse);
                            }
                        } catch (Exception e2) {
                            this.this$0.mAdLogger.i("shouldOverrideUrlLoading", str, e2);
                        }
                        return this.this$0.processShouldOverrideUrlLoading(str, webView);
                    }
                    return invokeLL.booleanValue;
                }
            });
            initBridgeHandler();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void retryLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, this) == null) {
            this.mAdLogger.d("adContainer.retryLoading");
            this.isRetrying = true;
            TaskScheduler.getInstance().submitWithDelay(new BaseTask(this) { // from class: com.baidu.mobads.container.h5.XAdservAdContainer.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ XAdservAdContainer this$0;

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

                @Override // com.baidu.mobads.container.executor.BaseTask
                public Object doInBackground() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        try {
                            if (this.this$0.isDetached) {
                                return null;
                            }
                            if (NetworkInfoUtils.isCurrentNetworkAvailable(this.this$0.mAppContext)) {
                                this.this$0.mAdContainerCxt.getAdProdBase().post(new Runnable(this) { // from class: com.baidu.mobads.container.h5.XAdservAdContainer.3.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass3 this$1;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i2 = newInitContext.flag;
                                            if ((i2 & 1) != 0) {
                                                int i3 = i2 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$1 = this;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable3 = $ic;
                                        if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.this$1.this$0.mWebView == null) {
                                            return;
                                        }
                                        this.this$1.this$0.mWebView.loadUrl(AdURIUtils.replaceURLWithSupportProtocol("http://mobads.baidu.com/ads/index.htm"));
                                    }
                                });
                                return null;
                            } else if (this.this$0.mWebView.isDestroy()) {
                                return null;
                            } else {
                                this.this$0.retryLoading();
                                return null;
                            }
                        } catch (Exception e2) {
                            this.this$0.mAdLogger.d(e2);
                            return null;
                        }
                    }
                    return invokeV.objValue;
                }
            }, 5L, TimeUnit.SECONDS);
        }
    }

    public void handleAdClose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public void handlePlayVideo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
        }
    }

    public void handlePreloadEnd(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
        }
    }

    @Override // com.baidu.mobads.container.XBaseHtmlAdContainer
    public void initBridgeHandler() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.mBridgeHandler = new AdservBridgeHandler(this, this.mWebView, this.bridgeListener, this.mAdContainerCxt);
        }
    }

    public boolean isInited() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.inited : invokeV.booleanValue;
    }

    public void onDetached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.isDetached = true;
            if (this.inited) {
                this.mAdLogger.d("AdContainer.onDetached");
                this.mBridgeHandler.detachViewFromViewTree();
            }
        }
    }

    public void setInited(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.inited = z;
        }
    }
}
