package com.baidu.searchbox.logsystem.uploadfile;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class BOSAttachFileUploader_Factory {
    public static /* synthetic */ Interceptable $ic;
    public static volatile BOSAttachFileUploader instance;
    public transient /* synthetic */ FieldHolder $fh;

    public BOSAttachFileUploader_Factory() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static synchronized BOSAttachFileUploader get() {
        InterceptResult invokeV;
        BOSAttachFileUploader bOSAttachFileUploader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (BOSAttachFileUploader_Factory.class) {
                if (instance == null) {
                    instance = new BOSAttachFileUploader();
                }
                bOSAttachFileUploader = instance;
            }
            return bOSAttachFileUploader;
        }
        return (BOSAttachFileUploader) invokeV.objValue;
    }
}
