package com.baidu.platform.base;

import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.district.DistrictResult;
import com.baidu.mapsdkplatform.comapi.util.AlgorithmUtil;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Lock f42027a;

    /* renamed from: b  reason: collision with root package name */
    public AsyncHttpClient f42028b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f42029c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f42030d;

    /* renamed from: e  reason: collision with root package name */
    public DistrictResult f42031e;

    /* renamed from: f  reason: collision with root package name */
    public SearchType f42032f;

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
        this.f42028b = new AsyncHttpClient();
        this.f42029c = new Handler(Looper.getMainLooper());
        this.f42027a = new ReentrantLock();
        this.f42030d = true;
        this.f42031e = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            byte[] bArr = {102, 97, 105, 108, 100};
            try {
                bArr = AlgorithmUtil.getUrlNeedInfo(AppMD5.getUrlNeedInfo(), AppMD5.getUrlNeedInfo(), Base64.decode(str.getBytes(), 0));
            } catch (Exception unused) {
            }
            return new String(bArr).trim();
        }
        return (String) invokeL.objValue;
    }

    private void a(AsyncHttpClient asyncHttpClient, HttpClient.ProtoResultCallback protoResultCallback, SearchResult searchResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, asyncHttpClient, protoResultCallback, searchResult) == null) {
            asyncHttpClient.get(new com.baidu.platform.core.a.c(((DistrictResult) searchResult).getCityName()).a(this.f42032f), protoResultCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HttpClient.HttpStateError httpStateError, d dVar, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, this, httpStateError, dVar, obj) == null) {
            a(dVar.a("{SDK_InnerError:{httpStateError:" + httpStateError + "}}"), obj, dVar);
        }
    }

    private void a(SearchResult searchResult, Object obj, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, this, searchResult, obj, dVar) == null) {
            this.f42029c.post(new c(this, dVar, searchResult, obj));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, d dVar, Object obj, AsyncHttpClient asyncHttpClient, HttpClient.ProtoResultCallback protoResultCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65545, this, str, dVar, obj, asyncHttpClient, protoResultCallback) == null) {
            SearchResult a2 = dVar.a(str);
            a2.status = b(str);
            if (a(dVar, a2)) {
                a(asyncHttpClient, protoResultCallback, a2);
            } else if (!(dVar instanceof com.baidu.platform.core.a.b)) {
                a(a2, obj, dVar);
            } else {
                DistrictResult districtResult = this.f42031e;
                if (districtResult != null) {
                    DistrictResult districtResult2 = (DistrictResult) a2;
                    districtResult2.setCityCode(districtResult.getCityCode());
                    districtResult2.setCenterPt(this.f42031e.getCenterPt());
                }
                a(a2, obj, dVar);
                this.f42030d = true;
                this.f42031e = null;
                ((com.baidu.platform.core.a.b) dVar).a(false);
            }
        }
    }

    private boolean a(d dVar, SearchResult searchResult) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, this, dVar, searchResult)) == null) {
            if (dVar instanceof com.baidu.platform.core.a.b) {
                DistrictResult districtResult = (DistrictResult) searchResult;
                if (SearchResult.ERRORNO.RESULT_NOT_FOUND == districtResult.error && districtResult.getCityName() != null && this.f42030d) {
                    this.f42030d = false;
                    this.f42031e = districtResult;
                    ((com.baidu.platform.core.a.b) dVar).a(true);
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
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
                    if (!jSONObject.has("result") || (optJSONObject = jSONObject.optJSONObject("result")) == null) {
                        return 10204;
                    }
                    return optJSONObject.optInt("error");
                } catch (JSONException unused) {
                }
            }
            return 10204;
        }
        return invokeL.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        int permissionCheck;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, str) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("status") || jSONObject.has("status_sp")) {
                    int i2 = jSONObject.has("status") ? jSONObject.getInt("status") : jSONObject.getInt("status_sp");
                    if ((i2 == 105 || i2 == 106) && (permissionCheck = PermissionCheck.permissionCheck()) != 0) {
                        String str2 = "permissionCheck result is: " + permissionCheck;
                    }
                }
            } catch (JSONException unused) {
            }
        }
    }

    public boolean a(e eVar, Object obj, d dVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, eVar, obj, dVar)) == null) {
            if (dVar == null) {
                return false;
            }
            SearchType a2 = dVar.a();
            this.f42032f = a2;
            String a3 = eVar.a(a2);
            if (a3 != null) {
                this.f42028b.get(a3, new b(this, dVar, obj));
                return true;
            }
            String str = "The sendurl is: " + a3;
            a(dVar.a("{SDK_InnerError:{PermissionCheckError:Error}}"), obj, dVar);
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
