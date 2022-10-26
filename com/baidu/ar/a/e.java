package com.baidu.ar.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.h.o;
import com.baidu.ar.h.s;
import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.HttpFactory;
import com.baidu.ar.ihttp.IHttpRequest;
import com.baidu.ar.ihttp.IHttpResponse;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "e";
    public transient /* synthetic */ FieldHolder $fh;
    public IHttpRequest bR;
    public ICallbackWith bS;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1920934196, "Lcom/baidu/ar/a/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1920934196, "Lcom/baidu/ar/a/e;");
        }
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private JSONObject a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, context, str)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                o.g(jSONObject);
                o.b(context, jSONObject);
                o.a(context, jSONObject);
                jSONObject.put("device_platform", "");
                jSONObject.put(HttpConstants.OS_VERSION, Build.VERSION.SDK_INT);
                jSONObject.put(HttpConstants.DEVICE_TYPE, Build.BRAND);
                jSONObject.put("device_id", o.y(context));
                jSONObject.put("app_version", com.baidu.ar.h.c.getVersionCode());
                jSONObject.put("manufacture", Build.MANUFACTURER);
                jSONObject.put(HttpConstants.HTTP_HARDWARE, Build.HARDWARE);
                jSONObject.put(HttpConstants.HTTP_BOARD, Build.BOARD);
                jSONObject.put("classification_id", str);
                String str2 = TAG;
                com.baidu.ar.h.b.c(str2, "params: " + jSONObject.toString());
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    private boolean d(JSONObject jSONObject) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, jSONObject)) == null) {
            if (jSONObject == null || !jSONObject.has("common") || (optJSONObject = jSONObject.optJSONObject("common")) == null || !optJSONObject.has("cpu_score")) {
                return false;
            }
            Object opt = optJSONObject.opt("cpu_score");
            return opt instanceof String ? Integer.parseInt((String) opt) > 0 : (opt instanceof Number) && Integer.parseInt(opt.toString()) > 0;
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                if (this.bS != null) {
                    u("response is empty");
                }
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("err_num", -1);
                if (optInt == 0 && jSONObject.has("data")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject != null && optJSONObject.has("classification")) {
                        a aVar = new a();
                        aVar.bI = optJSONObject.getJSONObject("classification");
                        aVar.bH = optJSONObject.optString("classification_id", "default");
                        if (!d(aVar.bI) && this.bS != null) {
                            com.baidu.ar.h.b.b(TAG, str);
                            u("config format is error. see Logcat filter: " + TAG);
                        }
                        return aVar;
                    }
                } else if (this.bS != null) {
                    String string = jSONObject.has(PmsConstant.Statistic.STATISTIC_ERRMSG) ? jSONObject.getString(PmsConstant.Statistic.STATISTIC_ERRMSG) : "";
                    u("err_num: " + optInt + " " + string);
                }
            } catch (JSONException e) {
                if (this.bS != null) {
                    u(e.getMessage());
                }
                e.printStackTrace();
            }
            return null;
        }
        return (a) invokeL.objValue;
    }

    private void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, str) == null) {
            ICallbackWith iCallbackWith = this.bS;
            iCallbackWith.run("fetch ability scheme config fail. " + str);
        }
    }

    public void a(Context context, String str, ICallbackWith iCallbackWith) {
        IHttpRequest newRequest;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, context, str, iCallbackWith) == null) || (newRequest = HttpFactory.newRequest()) == null) {
            return;
        }
        newRequest.setMethod("POST").setUrl(s.gU()).setBody(a(context, str));
        newRequest.enqueue(new com.baidu.ar.ihttp.a(this, iCallbackWith) { // from class: com.baidu.ar.a.e.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ICallbackWith bT;
            public final /* synthetic */ e bU;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, iCallbackWith};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.bU = this;
                this.bT = iCallbackWith;
            }

            @Override // com.baidu.ar.ihttp.a
            public void a(HttpException httpException) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, httpException) == null) {
                    String str2 = e.TAG;
                    com.baidu.ar.h.b.c(str2, "" + httpException.getMessage());
                }
            }

            @Override // com.baidu.ar.ihttp.a
            public void a(IHttpResponse iHttpResponse) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iHttpResponse) == null) && iHttpResponse.isSuccess() && this.bT != null) {
                    try {
                        String content = iHttpResponse.getContent();
                        String str2 = e.TAG;
                        com.baidu.ar.h.b.c(str2, "response: " + content);
                        a t = this.bU.t(content);
                        if (t != null) {
                            this.bT.run(t);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        this.bR = newRequest;
    }

    public void c(ICallbackWith iCallbackWith) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iCallbackWith) == null) {
            this.bS = iCallbackWith;
        }
    }

    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.bS = null;
            IHttpRequest iHttpRequest = this.bR;
            if (iHttpRequest != null) {
                iHttpRequest.cancel();
                this.bR = null;
            }
        }
    }
}
