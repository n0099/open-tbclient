package com.baidu.platform.base;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.Point;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapsdkplatform.comapi.util.AlgorithmUtil;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public abstract class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.platform.util.a f9408a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f9409b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f9410c;

    public e() {
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
        this.f9409b = true;
        this.f9410c = true;
        this.f9408a = new com.baidu.platform.util.a();
    }

    private String a(SearchType searchType, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, searchType, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return SearchType.f9392h == searchType ? a(str) : str;
        }
        return (String) invokeLL.objValue;
    }

    private String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            String substring = str.substring(str.indexOf("location=") + 9, str.indexOf("&", str.indexOf("location=")));
            if (TextUtils.isEmpty(substring)) {
                return str;
            }
            byte[] bArr = {0};
            try {
                bArr = AlgorithmUtil.setUrlNeedInfo(AppMD5.getUrlNeedInfo(), AppMD5.getUrlNeedInfo(), substring.getBytes());
            } catch (Exception e2) {
                Log.e("BaseSearch", "get location failed", e2);
            }
            return str.replace(substring, Base64.encodeToString(bArr, 0).trim());
        }
        return (String) invokeL.objValue;
    }

    private boolean b(SearchType searchType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, this, searchType)) == null) ? SearchType.f9392h == searchType : invokeL.booleanValue;
    }

    public final String a(PlanNode planNode) {
        InterceptResult invokeL;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, planNode)) == null) {
            if (planNode == null) {
                return null;
            }
            String str = new String(StringUtil.ARRAY_START);
            LatLng location = planNode.getLocation();
            if (location != null) {
                String str2 = str + "\"type\":1,";
                Point ll2point = CoordUtil.ll2point(location);
                sb = new StringBuilder();
                sb.append(str2);
                sb.append("\"xy\":\"");
                sb.append(ll2point.x);
                sb.append(",");
                sb.append(ll2point.y);
            } else if (planNode.getName() == null) {
                return str;
            } else {
                sb = new StringBuilder();
                sb.append(str + "\"type\":2,");
                sb.append("\"keyword\":\"");
                sb.append(planNode.getName());
            }
            sb.append("\"}");
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public String a(SearchType searchType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, searchType)) == null) {
            String a2 = a(com.baidu.platform.domain.d.a());
            String authToken = HttpClient.getAuthToken();
            if (authToken == null) {
                Log.e("SearchRequest", "toUrlString get authtoken failed");
                int permissionCheck = PermissionCheck.permissionCheck();
                if (permissionCheck != 0) {
                    Log.e("SearchRequest", "try permissionCheck result is: " + permissionCheck);
                    return null;
                }
                authToken = HttpClient.getAuthToken();
            }
            if (this.f9409b) {
                this.f9408a.a("token", authToken);
            }
            String a3 = this.f9408a.a();
            if (b(searchType)) {
                a3 = a(searchType, a3);
            }
            String str = a3 + HttpClient.getPhoneInfo();
            if (this.f9410c) {
                str = str + "&sign=" + AppMD5.getSignMD5String(str);
            }
            return a2 + "?" + str;
        }
        return (String) invokeL.objValue;
    }

    public abstract String a(com.baidu.platform.domain.c cVar);

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f9410c = z;
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f9409b = z;
        }
    }
}
