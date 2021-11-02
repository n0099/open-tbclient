package b.q.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Message;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
import org.json.JSONException;
/* loaded from: classes6.dex */
public class l3 extends WebViewClient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f33387a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f33388b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Info f33389c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f33390d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ o3 f33391e;

    public l3(o3 o3Var, Context context, Info info, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {o3Var, context, info, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33391e = o3Var;
        this.f33388b = context;
        this.f33389c = info;
        this.f33390d = str;
    }

    public final boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            Uri parse = Uri.parse(str);
            if (o3.b(parse) || o3.c(parse)) {
                this.f33387a = true;
                if (!a2.b(this.f33388b, parse, null)) {
                    d3.a(this.f33388b, parse);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str) == null) {
            super.onPageFinished(webView, str);
            this.f33391e.f33429c.removeMessages(11);
            if (this.f33387a) {
                return;
            }
            y2 a2 = c3.a(this.f33388b);
            try {
                a2.f33579b = c3.d("ps", new g3(this.f33389c));
                a2.k("co", 2004);
                a2.l("msg", str);
            } catch (JSONException unused) {
            }
            a2.m();
            Message obtain = Message.obtain();
            obtain.what = 12;
            obtain.obj = this.f33390d;
            this.f33391e.f33429c.sendMessage(obtain);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, bitmap) == null) {
            super.onPageStarted(webView, str, bitmap);
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, webResourceRequest)) == null) ? Build.VERSION.SDK_INT >= 24 ? a(webResourceRequest.getUrl().toString()) : super.shouldOverrideUrlLoading(webView, webResourceRequest) : invokeLL.booleanValue;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, str)) == null) ? Build.VERSION.SDK_INT < 24 ? a(str) : super.shouldOverrideUrlLoading(webView, str) : invokeLL.booleanValue;
    }
}
