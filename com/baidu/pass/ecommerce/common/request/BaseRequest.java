package com.baidu.pass.ecommerce.common.request;

import android.os.Handler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.ecommerce.EcommerceRouter;
import com.baidu.sapi2.ecommerce.dto.AddressManageDTO;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class BaseRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CLIENT = "android";
    public static final String CLIENT_FROM = "native";
    public static final int HTTP_OK_CODE = 200;
    public static final String KEY_CODE = "code";
    public static final String KEY_MSG = "msg";
    public static final String KEY_RESPONSE_CODE = "errno";
    public static final String KEY_RESPONSE_MSG = "errmsg";
    public static final String PASS_TPL = "pp";
    public static final String TAG = "BaseRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public long OPTION_NET_LOADING_LIMIT_TIME;
    public SapiAccount account;
    public Handler actionTimeHandler;
    public AddressManageDTO addressManageDTO;
    public SapiConfiguration configuration;
    public List cookies;
    public HttpHashMapWrap paramsMap;

    public abstract String getRelativeUrl();

    public String getUserAgent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    public BaseRequest() {
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
        this.configuration = SapiAccountManager.getInstance().getSapiConfiguration();
        this.addressManageDTO = EcommerceRouter.getInstance().getAddressManageDTO();
        this.account = SapiContext.getInstance().getCurrentAccount();
        this.OPTION_NET_LOADING_LIMIT_TIME = 300L;
        this.paramsMap = new HttpHashMapWrap(this) { // from class: com.baidu.pass.ecommerce.common.request.BaseRequest.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BaseRequest this$0;

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
                put("client", "android");
                put("clientfrom", "native");
                put("tpl", this.this$0.configuration.tpl);
                if (this.this$0.addressManageDTO != null) {
                    put("tplse", this.this$0.addressManageDTO.tplse);
                    put("tplt", this.this$0.addressManageDTO.tplt);
                }
            }
        };
        this.cookies = new ArrayList(this) { // from class: com.baidu.pass.ecommerce.common.request.BaseRequest.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BaseRequest this$0;

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
                add(this.this$0.buildCookie("BAIDUID", SapiUtils.getCookie("https://baidu.com", "BAIDUID")));
                BaseRequest baseRequest = this.this$0;
                add(baseRequest.buildCookie("cuid", SapiUtils.getClientId(baseRequest.configuration.context)));
                if (this.this$0.account != null) {
                    BaseRequest baseRequest2 = this.this$0;
                    add(baseRequest2.buildCookie(HttpRequest.BDUSS, baseRequest2.account.bduss));
                    BaseRequest baseRequest3 = this.this$0;
                    add(baseRequest3.buildCookie("STOKEN", baseRequest3.getPPSToken()));
                }
            }
        };
    }

    public void addCookie(HttpCookie httpCookie) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, httpCookie) == null) {
            this.cookies.add(httpCookie);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HttpCookie buildCookie(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, this, str, str2)) == null) {
            HttpCookie httpCookie = new HttpCookie(str, str2);
            httpCookie.setDomain(this.configuration.environment.getUrlDomain());
            httpCookie.setPath("/");
            return httpCookie;
        }
        return (HttpCookie) invokeLL.objValue;
    }

    public void addParams(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            this.paramsMap.put(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getPPSToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add("pp");
            return (String) SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback(this) { // from class: com.baidu.pass.ecommerce.common.request.BaseRequest.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseRequest this$0;

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFailure(GetTplStokenResult getTplStokenResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, getTplStokenResult) == null) {
                    }
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFinish() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    }
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onStart() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onSuccess(GetTplStokenResult getTplStokenResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048580, this, getTplStokenResult) == null) {
                    }
                }

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
                }
            }, this.account.bduss, arrayList).get("pp");
        }
        return (String) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseActionTimeHandler() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65545, this) == null) && this.actionTimeHandler != null) {
            Log.d(TAG, "releaseActionTimeHandler");
            this.actionTimeHandler.removeCallbacksAndMessages(null);
            this.actionTimeHandler = null;
        }
    }

    public void submit(NetCallback netCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, netCallback) == null) {
            Handler handler = new Handler();
            this.actionTimeHandler = handler;
            handler.postDelayed(new Runnable(this, netCallback) { // from class: com.baidu.pass.ecommerce.common.request.BaseRequest.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseRequest this$0;
                public final /* synthetic */ NetCallback val$callback;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, netCallback};
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
                    this.val$callback = netCallback;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.val$callback.onShowLoading();
                    }
                }
            }, this.OPTION_NET_LOADING_LIMIT_TIME);
            new HttpClientWrap().post(getRelativeUrl(), this.paramsMap, this.cookies, getUserAgent(), new HttpHandlerWrap(this, netCallback) { // from class: com.baidu.pass.ecommerce.common.request.BaseRequest.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseRequest this$0;
                public final /* synthetic */ NetCallback val$callback;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, netCallback};
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
                    this.val$callback = netCallback;
                }

                /* JADX WARN: Code restructure failed: missing block: B:12:0x0051, code lost:
                    if (android.text.TextUtils.isEmpty(r7) == false) goto L11;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:14:0x0054, code lost:
                    r7 = "未知错误";
                 */
                /* JADX WARN: Code restructure failed: missing block: B:15:0x0057, code lost:
                    r4.val$callback.onFailure(-10000, r7);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:16:0x005e, code lost:
                    return;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:9:0x004a, code lost:
                    if (android.text.TextUtils.isEmpty(r7) == false) goto L11;
                 */
                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onFailure(Throwable th, int i, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, th, i, str) == null) {
                        this.this$0.releaseActionTimeHandler();
                        Log.d(BaseRequest.TAG, "Failure: url=" + this.this$0.getRelativeUrl() + " code=" + i + " response=" + str);
                        if (this.val$callback == null) {
                            return;
                        }
                        if (th != null) {
                            str = th.getMessage();
                        }
                    }
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onSuccess(int i, String str) {
                    int i2;
                    String str2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                        this.this$0.releaseActionTimeHandler();
                        Log.d(BaseRequest.TAG, "Success: url=" + this.this$0.getRelativeUrl() + " response=" + str);
                        NetCallback netCallback2 = this.val$callback;
                        if (netCallback2 == null) {
                            return;
                        }
                        if (200 != i) {
                            netCallback2.onFailure(i, str);
                            return;
                        }
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            if (jSONObject.has("errno")) {
                                i2 = jSONObject.optInt("errno", -10000);
                            } else if (jSONObject.has("code")) {
                                i2 = jSONObject.optInt("code", -10000);
                            } else {
                                i2 = -10000;
                            }
                            if (i2 == 0) {
                                this.val$callback.onSuccess(jSONObject);
                                return;
                            }
                            if (jSONObject.has("errmsg")) {
                                str2 = jSONObject.optString("errmsg");
                            } else if (jSONObject.has("msg")) {
                                str2 = jSONObject.optString("msg");
                            } else {
                                str2 = "未知错误";
                            }
                            this.val$callback.onFailure(i2, str2);
                        } catch (JSONException e) {
                            this.val$callback.onFailure(-10000, e.getMessage());
                        }
                    }
                }
            });
        }
    }
}
