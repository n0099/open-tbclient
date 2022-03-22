package com.baidu.ar.auth;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.auth.k;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.bean.DuMixARConfig;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.h.o;
import com.baidu.ar.h.s;
import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.HttpFactory;
import com.baidu.ar.ihttp.IHttpRequest;
import com.baidu.ar.ihttp.IHttpResponse;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c implements k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean jr;
    public k.a ju;

    public c(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.jr = fVar.jI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(IAuthCallback iAuthCallback, HttpException httpException) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, this, iAuthCallback, httpException) == null) || iAuthCallback == null) {
            return;
        }
        if (this.jr && httpException.getCode() == 1) {
            iAuthCallback.onSuccess();
        } else {
            iAuthCallback.onError(httpException.getMessage(), 0);
        }
    }

    private JSONObject k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                o.g(jSONObject);
                o.b(context, jSONObject);
                jSONObject.put(HttpConstants.SDK_TYPE, com.baidu.ar.h.c.gx());
                jSONObject.put(HttpConstants.FUNCTION_TYPE, com.baidu.ar.h.c.gy());
                jSONObject.put(HttpConstants.SDK_VERSION_CODE, com.baidu.ar.h.c.getVersionCode());
                jSONObject.put(HttpConstants.SDK_VERSION_NAME, com.baidu.ar.h.c.getVersionName());
                jSONObject.put("os_type", "android");
                jSONObject.put(HttpConstants.OS_VERSION, Build.VERSION.RELEASE);
                jSONObject.put("device_id", Build.MODEL.toLowerCase());
                jSONObject.put("ar_key", ARConfig.getARKey());
                jSONObject.put("ar_type", ARConfig.getARType());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    private String l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, context)) == null) {
            try {
                String l = d.l(context);
                if (TextUtils.isEmpty(l) || !l.contains("-")) {
                    return l;
                }
                String substring = l.substring(0, l.lastIndexOf("-"));
                return substring + "-" + DuMixARConfig.getAipAppId();
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.ar.auth.k
    public void a(k.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.ju = aVar;
        }
    }

    @Override // com.baidu.ar.auth.k
    public void doAuth(Context context, IAuthCallback iAuthCallback) {
        IHttpRequest newRequest;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, iAuthCallback) == null) || (newRequest = HttpFactory.newRequest()) == null) {
            return;
        }
        newRequest.setMethod("POST").setUrl(s.gO()).addQueryField("access_token", l(context)).setBody(k(context));
        newRequest.enqueue(new com.baidu.ar.ihttp.a(this, iAuthCallback) { // from class: com.baidu.ar.auth.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c jA;
            public final /* synthetic */ IAuthCallback jl;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, iAuthCallback};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.jA = this;
                this.jl = iAuthCallback;
            }

            @Override // com.baidu.ar.ihttp.a
            public void a(HttpException httpException) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, httpException) == null) {
                    this.jA.a(this.jl, httpException);
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:13:0x0038 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
            @Override // com.baidu.ar.ihttp.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void a(IHttpResponse iHttpResponse) {
                c cVar;
                IAuthCallback iAuthCallback2;
                HttpException httpException;
                JSONObject jSONObject;
                String message;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iHttpResponse) != null) {
                    return;
                }
                if (iHttpResponse.isSuccess()) {
                    try {
                        jSONObject = new JSONObject(iHttpResponse.getContent());
                    } catch (Exception e2) {
                        cVar = this.jA;
                        iAuthCallback2 = this.jl;
                        httpException = new HttpException(4, e2.getMessage());
                    }
                    if (jSONObject != null) {
                        return;
                    }
                    if (jSONObject != null && jSONObject.has(GameCodeGetResponseMsg.PARAM_ERROR_MSG)) {
                        try {
                            message = jSONObject.getString(GameCodeGetResponseMsg.PARAM_ERROR_MSG);
                        } catch (JSONException e3) {
                            message = e3.getMessage();
                        }
                        IAuthCallback iAuthCallback3 = this.jl;
                        if (iAuthCallback3 != null) {
                            iAuthCallback3.onError(message, 0);
                            return;
                        }
                        return;
                    }
                    if (this.jA.ju != null) {
                        HashSet hashSet = new HashSet();
                        hashSet.addAll(FeatureCodes.getAll());
                        this.jA.ju.a(hashSet);
                    }
                    IAuthCallback iAuthCallback4 = this.jl;
                    if (iAuthCallback4 != null) {
                        iAuthCallback4.onSuccess();
                        return;
                    }
                    return;
                }
                cVar = this.jA;
                iAuthCallback2 = this.jl;
                httpException = new HttpException(1, iHttpResponse.getMessage());
                cVar.a(iAuthCallback2, httpException);
                jSONObject = null;
                if (jSONObject != null) {
                }
            }
        });
    }
}
