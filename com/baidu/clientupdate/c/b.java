package com.baidu.clientupdate.c;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.util.Base64Encoder;
import com.baidu.util.LogUtil;
import java.net.URLEncoder;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public StringBuilder f4682a;

    public b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f4682a = new StringBuilder(str);
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || TextUtils.isEmpty(str2)) {
            return;
        }
        StringBuilder sb = this.f4682a;
        sb.append("&" + str + "=");
        byte[] b64Encode = Base64Encoder.b64Encode(URLEncoder.encode(str2).getBytes());
        this.f4682a.append(new String(b64Encode));
        LogUtil.logD("ClientUpdateUriHelper", "key: " + str + ", value: " + str2);
        LogUtil.logD("ClientUpdateUriHelper", "b64encode key: " + str + ", value: " + new String(b64Encode));
    }

    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || TextUtils.isEmpty(str2)) {
            return;
        }
        StringBuilder sb = this.f4682a;
        sb.append("&" + str + "=");
        this.f4682a.append(URLEncoder.encode(str2));
        LogUtil.logD("ClientUpdateUriHelper", "key: " + str + ", value: " + str2);
        LogUtil.logD("ClientUpdateUriHelper", "b64encode key: " + str + ", value: " + str2);
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f4682a.toString() : (String) invokeV.objValue;
    }
}
