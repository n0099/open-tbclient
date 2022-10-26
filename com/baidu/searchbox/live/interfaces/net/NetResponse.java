package com.baidu.searchbox.live.interfaces.net;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes2.dex */
public class NetResponse {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String contentEncoding;
    public String contentLength;
    public String contentType;
    public String decodedResponseStr;
    public int downSize;
    public String exception;
    public Map headers;
    public int netErrorCode;
    public String realHost;
    public int responseCode;
    public byte[] retBytes;
    public NetStatData statData;
    public String traceid;

    public NetResponse() {
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
        this.responseCode = 0;
        this.netErrorCode = 0;
        this.exception = null;
        this.contentEncoding = "";
        this.contentType = "";
        this.contentLength = "";
    }

    public boolean isSuccessful() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i = this.responseCode;
            if (i >= 200 && i < 300) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
