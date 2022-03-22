package com.baidu.ar.statistic;

import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.h.s;
import com.baidu.ar.ihttp.HttpFactory;
import com.baidu.ar.ihttp.IHttpRequest;
import com.baidu.ar.ihttp.IHttpResponse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class l extends AsyncTask<String, Void, List<String>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a wP;

    /* loaded from: classes3.dex */
    public interface a {
        void onPerformanceRequestFinished(List<String> list);
    }

    public l(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.wP = aVar;
    }

    private List<String> aL(String str) {
        InterceptResult invokeL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
                JSONObject jSONObject = optJSONObject != null ? optJSONObject.getJSONObject("statistic_swtich") : null;
                if (jSONObject != null && (length = jSONObject.length()) > 0) {
                    ArrayList arrayList = new ArrayList(length);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if ("1".equals(jSONObject.opt(next))) {
                            arrayList.add(next);
                        }
                    }
                    return arrayList;
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    private String aM(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    private String gq() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? String.format("%s=%s&%s=%s&%s=%s&%s=%s&%s=%s", "os_type", "android", HttpConstants.HTTP_ENGINE_VERSION, String.valueOf(com.baidu.ar.h.c.getVersionCode()), "manufacture", aM(Build.MANUFACTURER), HttpConstants.HTTP_BOARD, aM(Build.BOARD), HttpConstants.HTTP_HARDWARE, aM(Build.HARDWARE)) : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public List<String> doInBackground(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
            IHttpRequest newRequest = HttpFactory.newRequest();
            if (newRequest == null) {
                return null;
            }
            newRequest.setUrl(s.gS()).setMethod("POST").setBody(gq()).addHeader("Content-Type: application/x-www-form-urlencoded");
            try {
                IHttpResponse execute = newRequest.execute();
                if (execute.isSuccess()) {
                    return aL(execute.getContent());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.AsyncTask
    /* renamed from: k */
    public void onPostExecute(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            super.onPostExecute(list);
            a aVar = this.wP;
            if (aVar != null) {
                aVar.onPerformanceRequestFinished(list);
            }
            this.wP = null;
        }
    }
}
