package com.baidu.platform.comapi.pano;

import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AsyncHttpClient a;

    /* renamed from: com.baidu.platform.comapi.pano.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC1850a<T> {
        void a(HttpClient.HttpStateError httpStateError);

        void a(T t);
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new AsyncHttpClient();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            if (str == null || str.equals("")) {
                return new c(PanoStateError.f37971c);
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject optJSONObject = jSONObject.optJSONObject("result");
                if (optJSONObject == null) {
                    return new c(PanoStateError.f37971c);
                }
                if (optJSONObject.optInt("error") == 0) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("content");
                    if (optJSONArray == null) {
                        return new c(PanoStateError.f37971c);
                    }
                    c cVar = null;
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2).optJSONObject("poiinfo");
                        if (optJSONObject2 != null) {
                            cVar = new c(PanoStateError.a);
                            cVar.a(optJSONObject2.optString("PID"));
                            cVar.a(optJSONObject2.optInt("hasstreet"));
                        }
                    }
                    return cVar;
                }
                return new c(PanoStateError.f37970b);
            } catch (JSONException e2) {
                e2.printStackTrace();
                return new c(PanoStateError.f37971c);
            }
        }
        return (c) invokeL.objValue;
    }

    private String a(Uri.Builder builder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, builder)) == null) {
            String uri = builder.build().toString();
            Uri.Builder buildUpon = Uri.parse(uri + HttpClient.getPhoneInfo()).buildUpon();
            buildUpon.appendQueryParameter("sign", AppMD5.getSignMD5String(buildUpon.build().getEncodedQuery()));
            return buildUpon.build().toString();
        }
        return (String) invokeL.objValue;
    }

    private void a(Uri.Builder builder, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, builder, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        builder.appendQueryParameter(str, str2);
    }

    public void a(String str, InterfaceC1850a<c> interfaceC1850a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, interfaceC1850a) == null) {
            Uri.Builder builder = new Uri.Builder();
            builder.scheme(HttpClient.isHttpsEnable ? "https" : "http");
            builder.encodedAuthority("api.map.baidu.com");
            builder.path("/sdkproxy/lbs_androidsdk/pano/v1/");
            a(builder, "qt", "poi");
            a(builder, "uid", str);
            a(builder, "action", "0");
            String authToken = HttpClient.getAuthToken();
            if (authToken == null) {
                interfaceC1850a.a((InterfaceC1850a<c>) new c(PanoStateError.f37972d));
                return;
            }
            a(builder, "token", authToken);
            this.a.get(a(builder), new b(this, interfaceC1850a));
        }
    }
}
