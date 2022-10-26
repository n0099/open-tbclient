package com.baidu.down.common.intercepter;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public final class ResponseInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String method;
    public Map requestHeaders;
    public Map responseHeaders;
    public int stateCode;
    public String url;

    public ResponseInfo(String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.method = null;
        this.url = null;
        this.stateCode = 200;
        this.requestHeaders = null;
        this.responseHeaders = null;
        this.method = str;
        this.url = str2;
        this.stateCode = i;
        this.requestHeaders = new HashMap();
        this.responseHeaders = new HashMap();
    }

    public String toString() {
        com.baidu.titan.sdk.runtime.InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            StringBuilder sb = new StringBuilder(this.method + " " + this.stateCode + " " + this.url + "\n");
            for (String str : this.requestHeaders.keySet()) {
                sb.append(str);
                sb.append(":");
                sb.append((String) this.requestHeaders.get(str));
                sb.append("\n");
            }
            sb.append("=== Response ===\n");
            for (String str2 : this.responseHeaders.keySet()) {
                sb.append(str2);
                sb.append(":");
                sb.append((String) this.responseHeaders.get(str2));
                sb.append("\n");
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
