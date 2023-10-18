package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.BaiduHybridAdViewListener;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IXHybridAdRenderer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class dk extends bf {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WebView a;
    public BaiduHybridAdViewListener q;
    public IXHybridAdRenderer r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dk(WebView webView) {
        super(webView.getContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = webView;
        webView.removeJavascriptInterface("searchBoxJavaBridge_");
        this.a.removeJavascriptInterface("accessibility");
        this.a.removeJavascriptInterface("accessibilityTraversal");
        this.a.getSettings().setAllowContentAccess(false);
        this.a.getSettings().setSavePassword(false);
        this.a.getSettings().setAllowFileAccess(false);
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.r == null) {
                this.l = false;
                return;
            }
            this.l = true;
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_JSSDK);
                this.r.createProdHandler(jSONObject3);
                n();
                if (!TextUtils.isEmpty(this.o)) {
                    jSONObject.put("appid", this.o);
                }
                jSONObject.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_JSSDK);
                jSONObject2.put("timeout", 10000);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.r.loadAd(jSONObject, jSONObject2);
        }
    }

    public void a(WebView webView, int i, String str, String str2) {
        IXHybridAdRenderer iXHybridAdRenderer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, i, str, str2) == null) && (iXHybridAdRenderer = this.r) != null) {
            iXHybridAdRenderer.onReceivedError(webView, i, str, str2);
        }
    }

    public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        IXHybridAdRenderer iXHybridAdRenderer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, sslErrorHandler, sslError) == null) && (iXHybridAdRenderer = this.r) != null) {
            iXHybridAdRenderer.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    public void a(WebView webView, String str) {
        IXHybridAdRenderer iXHybridAdRenderer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, webView, str) == null) && (iXHybridAdRenderer = this.r) != null) {
            iXHybridAdRenderer.onPageFinished(webView, str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void b(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, str, i) == null) {
            super.b(str, i);
            BaiduHybridAdViewListener baiduHybridAdViewListener = this.q;
            if (baiduHybridAdViewListener != null) {
                baiduHybridAdViewListener.onAdFailed(0, "", str);
            }
        }
    }

    public void a(WebView webView, String str, Bitmap bitmap) {
        IXHybridAdRenderer iXHybridAdRenderer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048580, this, webView, str, bitmap) == null) && (iXHybridAdRenderer = this.r) != null) {
            iXHybridAdRenderer.onPageStarted(webView, str, bitmap);
        }
    }

    public void a(BaiduHybridAdViewListener baiduHybridAdViewListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, baiduHybridAdViewListener) == null) {
            this.q = baiduHybridAdViewListener;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void h(IOAdEvent iOAdEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, iOAdEvent) == null) {
            super.h(iOAdEvent);
            BaiduHybridAdViewListener baiduHybridAdViewListener = this.q;
            if (baiduHybridAdViewListener != null) {
                baiduHybridAdViewListener.onAdClick(0, null);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a(IOAdEvent iOAdEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, iOAdEvent) == null) {
            this.r.setCustomerWebView(this.a);
        }
    }

    public boolean b(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webView, str)) == null) {
            IXHybridAdRenderer iXHybridAdRenderer = this.r;
            if (iXHybridAdRenderer == null) {
                return false;
            }
            return iXHybridAdRenderer.shouldOverrideUrlLoading(webView, str);
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            IXHybridAdRenderer iXHybridAdRenderer = (IXHybridAdRenderer) ar.a(w.j, bq.a(this.h), new Class[]{Context.class}, this.h);
            this.r = iXHybridAdRenderer;
            this.k = iXHybridAdRenderer;
            if (!this.l) {
                a();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.q();
            BaiduHybridAdViewListener baiduHybridAdViewListener = this.q;
            if (baiduHybridAdViewListener != null) {
                baiduHybridAdViewListener.onAdShow(0, null);
            }
        }
    }
}
