package com.baidu.searchbox.live.interfaces.upload;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class UploadFileBean {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String ak;
    public String bucketName;
    public String endpoint;
    public String filePath;
    public String objectName;
    public String sk;
    public String token;

    public UploadFileBean() {
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
        this.ak = "";
        this.sk = "";
        this.token = "";
        this.endpoint = "";
        this.bucketName = "";
        this.objectName = "";
        this.filePath = "";
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "UploadFileBean{ak='" + this.ak + "', sk='" + this.sk + "', token='" + this.token + "', endpoint='" + this.endpoint + "', bucketName='" + this.bucketName + "', objectName='" + this.objectName + "', filePath='" + this.filePath + "'}";
        }
        return (String) invokeV.objValue;
    }
}
