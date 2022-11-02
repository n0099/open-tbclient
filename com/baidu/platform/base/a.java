package com.baidu.platform.base;

import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.district.DistrictResult;
import com.baidu.mapsdkplatform.comapi.util.AlgorithmUtil;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lock a;
    public AsyncHttpClient b;
    public Handler c;
    public boolean d;
    public DistrictResult e;
    public SearchType f;

    public a() {
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
        this.b = new AsyncHttpClient();
        this.c = new Handler(Looper.getMainLooper());
        this.a = new ReentrantLock();
        this.d = true;
        this.e = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            byte[] bArr = {102, 97, 105, 108, 100};
            try {
                bArr = AlgorithmUtil.getUrlNeedInfo(AppMD5.getUrlNeedInfo(), AppMD5.getUrlNeedInfo(), Base64.decode(str.getBytes(), 0));
            } catch (Exception unused) {
                Log.e("BaseSearch", "transform result failed");
            }
            return new String(bArr).trim();
        }
        return (String) invokeL.objValue;
    }

    private int b(String str) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, str)) == null) {
            if (str != null && !str.equals("")) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("status")) {
                        return jSONObject.getInt("status");
                    }
                    if (jSONObject.has("status_sp")) {
                        return jSONObject.getInt("status_sp");
                    }
                    if (!jSONObject.has(TiebaStatic.LogFields.RESULT) || (optJSONObject = jSONObject.optJSONObject(TiebaStatic.LogFields.RESULT)) == null) {
                        return 10204;
                    }
                    return optJSONObject.optInt("error");
                } catch (JSONException unused) {
                    Log.e("BaseSearch", "Create JSONObject failed when get response result status");
                }
            }
            return 10204;
        }
        return invokeL.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(String str) {
        InterceptResult invokeL;
        int i;
        int permissionCheck;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, this, str)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("status") || jSONObject.has("status_sp")) {
                    if (jSONObject.has("status")) {
                        i = jSONObject.getInt("status");
                    } else {
                        i = jSONObject.getInt("status_sp");
                    }
                    if ((i == 105 || i == 106) && (permissionCheck = PermissionCheck.permissionCheck()) != 0) {
                        Log.e("BaseSearch", "permissionCheck result is: " + permissionCheck);
                        return true;
                    }
                    return true;
                }
                return true;
            } catch (JSONException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    private void a(AsyncHttpClient asyncHttpClient, HttpClient.ProtoResultCallback protoResultCallback, SearchResult searchResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, this, asyncHttpClient, protoResultCallback, searchResult) == null) {
            asyncHttpClient.get(new com.baidu.platform.core.b.c(((DistrictResult) searchResult).getCityName()).a(this.f), protoResultCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HttpClient.HttpStateError httpStateError, d dVar, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, httpStateError, dVar, obj) == null) {
            a(dVar.a("{SDK_InnerError:{httpStateError:" + httpStateError + "}}"), obj, dVar);
        }
    }

    private void a(SearchResult searchResult, Object obj, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, this, searchResult, obj, dVar) == null) {
            this.c.post(new c(this, dVar, searchResult, obj));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, d dVar, Object obj, AsyncHttpClient asyncHttpClient, HttpClient.ProtoResultCallback protoResultCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65544, this, str, dVar, obj, asyncHttpClient, protoResultCallback) == null) {
            SearchResult a = dVar.a(str);
            a.status = b(str);
            if (a(dVar, a)) {
                a(asyncHttpClient, protoResultCallback, a);
            } else if (dVar instanceof com.baidu.platform.core.b.b) {
                DistrictResult districtResult = this.e;
                if (districtResult != null) {
                    DistrictResult districtResult2 = (DistrictResult) a;
                    districtResult2.setCityCode(districtResult.getCityCode());
                    districtResult2.setCenterPt(this.e.getCenterPt());
                }
                a(a, obj, dVar);
                this.d = true;
                this.e = null;
                ((com.baidu.platform.core.b.b) dVar).a(false);
            } else {
                a(a, obj, dVar);
            }
        }
    }

    private boolean a(d dVar, SearchResult searchResult) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, this, dVar, searchResult)) == null) {
            if (!(dVar instanceof com.baidu.platform.core.b.b)) {
                return false;
            }
            DistrictResult districtResult = (DistrictResult) searchResult;
            if (SearchResult.ERRORNO.RESULT_NOT_FOUND != districtResult.error || districtResult.getCityName() == null || !this.d) {
                return false;
            }
            this.d = false;
            this.e = districtResult;
            ((com.baidu.platform.core.b.b) dVar).a(true);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean a(e eVar, Object obj, d dVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, eVar, obj, dVar)) == null) {
            if (dVar == null) {
                Log.e(a.class.getSimpleName(), "The SearchParser is null, must be applied.");
                return false;
            }
            SearchType a = dVar.a();
            this.f = a;
            String a2 = eVar.a(a);
            if (a2 == null) {
                Log.e("BaseSearch", "The sendurl is: " + a2);
                a(dVar.a("{SDK_InnerError:{PermissionCheckError:Error}}"), obj, dVar);
                return false;
            }
            this.b.get(a2, new b(this, dVar, obj));
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
