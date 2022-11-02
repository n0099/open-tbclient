package com.baidu.platform.base;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapsdkplatform.comapi.util.AlgorithmUtil;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public abstract class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.baidu.platform.util.a a;
    public boolean b;
    public boolean c;

    public abstract String a(com.baidu.platform.domain.c cVar);

    public e() {
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
        this.b = true;
        this.c = true;
        this.a = new com.baidu.platform.util.a();
    }

    private String a(SearchType searchType, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, searchType, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (SearchType.h == searchType) {
                return a(str);
            }
            return str;
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
            } catch (Exception e) {
                Log.e("BaseSearch", "get location failed", e);
            }
            return str.replace(substring, Base64.encodeToString(bArr, 0).trim());
        }
        return (String) invokeL.objValue;
    }

    private boolean b(SearchType searchType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, searchType)) == null) {
            if (SearchType.h == searchType) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.c = z;
        }
    }

    public final String a(PlanNode planNode) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, planNode)) == null) {
            if (planNode == null) {
                return null;
            }
            String str = new String("{");
            LatLng location = planNode.getLocation();
            if (location != null) {
                String str2 = str + "\"type\":1,";
                Point ll2point = CoordUtil.ll2point(location);
                return str2 + "\"xy\":\"" + ll2point.x + "," + ll2point.y + "\"}";
            } else if (planNode.getName() != null) {
                return (str + "\"type\":2,") + "\"keyword\":\"" + planNode.getName() + "\"}";
            } else {
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public String a(SearchType searchType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, searchType)) == null) {
            String a = a(com.baidu.platform.domain.d.a());
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
            if (this.b) {
                this.a.a("token", authToken);
            }
            String a2 = this.a.a();
            if (b(searchType)) {
                a2 = a(searchType, a2);
            }
            String str = a2 + HttpClient.getPhoneInfo();
            if (this.c) {
                str = str + "&sign=" + AppMD5.getSignMD5String(str);
            }
            return a + "?" + str;
        }
        return (String) invokeL.objValue;
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.b = z;
        }
    }
}
