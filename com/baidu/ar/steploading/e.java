package com.baidu.ar.steploading;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.bean.ARCaseBundleInfo;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.callback.IError;
import com.baidu.ar.h.o;
import com.baidu.ar.h.s;
import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.HttpFactory;
import com.baidu.ar.ihttp.IHttpRequest;
import com.baidu.ar.ihttp.IHttpResponse;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e extends com.baidu.ar.e.a<String, String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IHttpRequest bR;
    public WeakReference<Context> wn;
    public ARCaseBundleInfo xx;
    public a xz;

    public e(Context context, ARCaseBundleInfo aRCaseBundleInfo, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aRCaseBundleInfo, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.wn = new WeakReference<>(context);
        this.xx = aRCaseBundleInfo;
        this.xz = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aO(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.getInt("errorNum") == 0) {
                String string = jSONObject.getString("data");
                if (TextUtils.isEmpty(string)) {
                    throw new Exception("query res failed");
                }
                return string;
            }
            throw new Exception(jSONObject.optString("errorMsg", "query res failed"));
        }
        return (String) invokeL.objValue;
    }

    private JSONObject e(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, context, str)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                o.g(jSONObject);
                o.b(context, jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.ar.e.a
    public void a(String str, ICallbackWith<String> iCallbackWith, IError iError) {
        Context context;
        ARCaseBundleInfo aRCaseBundleInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, iCallbackWith, iError) == null) || (context = this.wn.get()) == null || (aRCaseBundleInfo = this.xx) == null) {
            return;
        }
        String str2 = aRCaseBundleInfo.arKey;
        f aN = this.xz.aN(str);
        if (aN == null) {
            iError.onError(1, "资源不存在", null);
        } else if (TextUtils.isEmpty(aN.xL)) {
            iError.onError(1, "资源id不存在", null);
        } else if ("local".equals(aN.xL)) {
            iCallbackWith.run("local");
        } else if (TextUtils.isEmpty(aN.xM)) {
            iError.onError(1, "编码不正确", null);
        } else {
            StatisticApi.onEvent(StatisticConstants.LOAD_START_QUERY);
            String gT = s.gT();
            IHttpRequest newRequest = HttpFactory.newRequest();
            this.bR = newRequest;
            newRequest.setUrl(gT).setMethod("POST").addQueryField("id", aN.xL).setBody(e(context, str2)).enqueue(new com.baidu.ar.ihttp.a(this, iCallbackWith, iError) { // from class: com.baidu.ar.steploading.e.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ICallbackWith bT;
                public final /* synthetic */ IError xI;
                public final /* synthetic */ e xJ;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iCallbackWith, iError};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.xJ = this;
                    this.bT = iCallbackWith;
                    this.xI = iError;
                }

                @Override // com.baidu.ar.ihttp.a
                public void a(HttpException httpException) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, httpException) == null) {
                        StatisticApi.onEvent(StatisticConstants.LOAD_QUERY_FAILURE);
                        IError iError2 = this.xI;
                        if (iError2 != null) {
                            iError2.onError(1, httpException.getMessage(), httpException);
                        }
                    }
                }

                /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
                /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
                @Override // com.baidu.ar.ihttp.a
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void a(IHttpResponse iHttpResponse) {
                    int i;
                    String message;
                    JSONException jSONException;
                    Exception exc;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iHttpResponse) == null) {
                        String str3 = null;
                        if (iHttpResponse.isSuccess()) {
                            try {
                                String aO = this.xJ.aO(iHttpResponse.getContent());
                                if (this.bT != null) {
                                    this.bT.run(aO);
                                }
                            } catch (JSONException e) {
                                JSONException jSONException2 = e;
                                jSONException2.printStackTrace();
                                i = 3;
                                message = jSONException2.getMessage();
                                jSONException = jSONException2;
                                Exception exc2 = jSONException;
                                str3 = message;
                                exc = exc2;
                                if (TextUtils.isEmpty(str3)) {
                                }
                            } catch (Exception e2) {
                                Exception exc3 = e2;
                                exc3.printStackTrace();
                                i = 1;
                                message = exc3.getMessage();
                                jSONException = exc3;
                                Exception exc22 = jSONException;
                                str3 = message;
                                exc = exc22;
                                if (TextUtils.isEmpty(str3)) {
                                }
                            }
                        }
                        i = 0;
                        exc = null;
                        if (TextUtils.isEmpty(str3)) {
                            return;
                        }
                        StatisticApi.onEvent(StatisticConstants.LOAD_QUERY_FAILURE);
                        IError iError2 = this.xI;
                        if (iError2 != null) {
                            iError2.onError(i, str3, exc);
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.ar.e.a
    public void fp() {
        IHttpRequest iHttpRequest;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (iHttpRequest = this.bR) == null) {
            return;
        }
        iHttpRequest.cancel();
        this.bR = null;
    }
}
