package com.baidu.tbadk.browser.auth;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.alipay.sdk.app.OpenAuthTask;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.browser.auth.AliAuthHttpProxy;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.b39;
import com.baidu.tieba.video.VideoConvertUtil;
import com.baidu.tieba.w29;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes3.dex */
public final class AliAuthHttpProxy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final WeakReference<WebView> a;
    public final BdUniqueId b;
    public w29 c;
    public final Handler d;

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AliAuthHttpProxy a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AliAuthHttpProxy aliAuthHttpProxy, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aliAuthHttpProxy, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aliAuthHttpProxy;
        }

        public /* synthetic */ void a(AuthHttpRequestMsg authHttpRequestMsg) {
            MessageManager.getInstance().sendMessage(authHttpRequestMsg, this.a.i());
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) {
                if (message.what == 1118481) {
                    final AuthHttpRequestMsg authHttpRequestMsg = (AuthHttpRequestMsg) message.obj;
                    authHttpRequestMsg.pollingTimesIncrease();
                    this.a.d.postDelayed(new Runnable() { // from class: com.baidu.tieba.ru4
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                AliAuthHttpProxy.a.this.a(authHttpRequestMsg);
                            }
                        }
                    }, 1000L);
                    return;
                }
                super.handleMessage(message);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AliAuthHttpProxy a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AliAuthHttpProxy aliAuthHttpProxy, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aliAuthHttpProxy, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aliAuthHttpProxy;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && this.a.n(httpResponsedMessage)) {
                AuthHttpResponseMsg authHttpResponseMsg = (AuthHttpResponseMsg) httpResponsedMessage;
                AuthHttpRequestMsg authHttpRequestMsg = (AuthHttpRequestMsg) authHttpResponseMsg.getOrginalMessage();
                if (authHttpResponseMsg.getData() != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("status", authHttpResponseMsg.getErrorCode());
                    hashMap.put("message", authHttpResponseMsg.getErrorMessage());
                    if (authHttpResponseMsg.getData() != null) {
                        hashMap.put("message", "数据请求成功");
                        hashMap.put("avatar", authHttpResponseMsg.getData().optString("avatar"));
                        hashMap.put("nick_name", authHttpResponseMsg.getData().optString("nick_name"));
                        hashMap.put("alipay_user_id", authHttpResponseMsg.getData().optString("user_id"));
                    }
                    this.a.c.i((WebView) this.a.a.get(), "aliAuthResult", hashMap);
                } else if (authHttpRequestMsg.checkAllowToPolling()) {
                    Message obtainMessage = this.a.d.obtainMessage(1118481);
                    obtainMessage.obj = authHttpRequestMsg;
                    this.a.d.sendMessage(obtainMessage);
                } else {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("status", "100000");
                    hashMap2.put("message", "其他异常");
                    this.a.c.i((WebView) this.a.a.get(), "aliAuthResult", hashMap2);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements OpenAuthTask.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AliAuthHttpProxy a;

        public c(AliAuthHttpProxy aliAuthHttpProxy) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aliAuthHttpProxy};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aliAuthHttpProxy;
        }

        @Override // com.alipay.sdk.app.OpenAuthTask.Callback
        public void onResult(int i, String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, bundle) == null) {
                if (i == 9000) {
                    Object obj = bundle.get("auth_code");
                    if (obj != null && !TextUtils.isEmpty(obj.toString())) {
                        MessageManager.getInstance().sendMessage(this.a.j(obj.toString()), this.a.h());
                        return;
                    }
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("status", i + "");
                hashMap.put("message", str);
                this.a.c.i((WebView) this.a.a.get(), "aliAuthResult", hashMap);
            }
        }
    }

    public AliAuthHttpProxy(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new a(this, Looper.getMainLooper());
        this.a = new WeakReference<>(webView);
        this.b = BdUniqueId.gen();
        b bVar = new b(this, CmdConfigHttp.CMD_GET_ALI_AUTH_INFO);
        bVar.setTag(this.b);
        bVar.setSelfListener(true);
        MessageManager.getInstance().registerListener(bVar);
    }

    public void m(w29 w29Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, w29Var) == null) {
            this.c = w29Var;
        }
    }

    public final boolean n(HttpResponsedMessage httpResponsedMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, httpResponsedMessage)) == null) {
            if (httpResponsedMessage instanceof AuthHttpResponseMsg) {
                return httpResponsedMessage.getOrginalMessage() instanceof AuthHttpRequestMsg;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final TbHttpMessageTask h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_ALI_AUTH_INFO, TbConfig.USER_GROWTH_APPLY_ALI_AUTH_INFO_URL);
            tbHttpMessageTask.setResponsedClass(AuthHttpResponseMsg.class);
            tbHttpMessageTask.setPriority(4);
            tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
            return tbHttpMessageTask;
        }
        return (TbHttpMessageTask) invokeV.objValue;
    }

    public final TbHttpMessageTask i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_ALI_AUTH_INFO, TbConfig.USER_GROWTH_GET_ALI_AUTH_INFO_URL);
            tbHttpMessageTask.setResponsedClass(AuthHttpResponseMsg.class);
            tbHttpMessageTask.setPriority(4);
            tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
            return tbHttpMessageTask;
        }
        return (TbHttpMessageTask) invokeV.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.d.removeMessages(1118481);
            MessageManager.getInstance().unRegisterListener(this.b);
            MessageManager.getInstance().removeMessage(this.b);
            this.c = null;
        }
    }

    public final HttpMessage j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            AuthHttpRequestMsg authHttpRequestMsg = new AuthHttpRequestMsg();
            authHttpRequestMsg.setTag(this.b);
            CookieSyncManager.createInstance(TbadkCoreApplication.getInst());
            String cookie = CookieManager.getInstance().getCookie("tieba.baidu.com");
            if (!TextUtils.isEmpty(cookie)) {
                HashMap<String, String> headers = authHttpRequestMsg.getHeaders();
                if (headers != null) {
                    String str2 = headers.get("Cookie");
                    if (!TextUtils.isEmpty(str2)) {
                        if (str2.endsWith(";")) {
                            cookie = str2 + cookie;
                        } else {
                            cookie = str2 + ";" + cookie;
                        }
                    }
                    authHttpRequestMsg.addHeader("Cookie", cookie);
                } else {
                    authHttpRequestMsg.addHeader("Cookie", cookie);
                }
            }
            String p = VideoConvertUtil.p(String.format("auth_code=%s&sign_key=nAgokhg4I68siPMVp4oX5tHFiWXPkVCu", str));
            authHttpRequestMsg.addParam("auth_code", str);
            authHttpRequestMsg.addParam("auth_sign", p);
            authHttpRequestMsg.addParam(HttpRequest.TBS, TbadkCoreApplication.getInst().getTbs());
            return authHttpRequestMsg;
        }
        return (HttpMessage) invokeL.objValue;
    }

    public b39 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            b39 b39Var = new b39();
            b39Var.x(0);
            Activity activityByView = TbPageExtraHelper.getActivityByView(this.a.get());
            if (activityByView == null) {
                return b39Var;
            }
            new OpenAuthTask(activityByView).execute("__tb_account_auth__", OpenAuthTask.BizType.AccountAuth, new HashMap<String, String>(this) { // from class: com.baidu.tbadk.browser.auth.AliAuthHttpProxy.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AliAuthHttpProxy this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    put("url", "https://authweb.alipay.com/auth?auth_type=PURE_OAUTH_SDK&app_id=2021003145680066&scope=auth_user&state=init");
                }
            }, new c(this), true);
            return b39Var;
        }
        return (b39) invokeV.objValue;
    }
}
