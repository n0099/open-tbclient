package com.baidu.mobads.sdk.api;

import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.dk;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class BaiduHybridAdManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public dk mAdProd;
    public boolean mAppPageReceivedError;
    public String mAppSid;
    public BaiduHybridAdViewListener mBaiduHybridAdViewListener;
    public WebView mWebView;

    public BaiduHybridAdManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mBaiduHybridAdViewListener = new BaiduHybridAdViewListener(this) { // from class: com.baidu.mobads.sdk.api.BaiduHybridAdManager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BaiduHybridAdManager this$0;

            @Override // com.baidu.mobads.sdk.api.BaiduHybridAdViewListener
            public void onAdClick(int i3, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, str) == null) {
                }
            }

            @Override // com.baidu.mobads.sdk.api.BaiduHybridAdViewListener
            public void onAdFailed(int i3, String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3, str, str2) == null) {
                }
            }

            @Override // com.baidu.mobads.sdk.api.BaiduHybridAdViewListener
            public void onAdShow(int i3, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i3, str) == null) {
                }
            }

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }
        };
        this.mAppPageReceivedError = false;
    }

    public void injectJavaScriptBridge(WebView webView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, webView) == null) && !this.mAppPageReceivedError) {
            this.mWebView = webView;
            dk dkVar = new dk(this.mWebView);
            this.mAdProd = dkVar;
            dkVar.h(this.mAppSid);
            this.mAdProd.a(this.mBaiduHybridAdViewListener);
            this.mAdProd.a();
        }
    }

    public void setAppSid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.mAppSid = str;
        }
    }

    public void setBaiduHybridAdViewListener(BaiduHybridAdViewListener baiduHybridAdViewListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, baiduHybridAdViewListener) == null) {
            this.mBaiduHybridAdViewListener = baiduHybridAdViewListener;
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
            this.mAppPageReceivedError = false;
        }
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i, str, str2) == null) {
            this.mAppPageReceivedError = true;
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        InterceptResult invokeLL;
        dk dkVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, webView, str)) == null) {
            if (!this.mAppPageReceivedError && (dkVar = this.mAdProd) != null) {
                dkVar.b(webView, str);
            }
            try {
                Uri parse = Uri.parse(str);
                if (!"mobadssdk".equals(parse.getScheme())) {
                    if ("mobads".equals(parse.getScheme())) {
                        return true;
                    }
                    return false;
                }
                return true;
            } catch (Exception e) {
                System.err.println(e);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
