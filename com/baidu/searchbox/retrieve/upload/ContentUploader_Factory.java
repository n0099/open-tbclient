package com.baidu.searchbox.retrieve.upload;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class ContentUploader_Factory {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ContentUploader instance;
    public transient /* synthetic */ FieldHolder $fh;

    public ContentUploader_Factory() {
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

    public static synchronized ContentUploader get() {
        InterceptResult invokeV;
        ContentUploader contentUploader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (ContentUploader_Factory.class) {
                if (instance == null) {
                    instance = new ContentUploader();
                }
                contentUploader = instance;
            }
            return contentUploader;
        }
        return (ContentUploader) invokeV.objValue;
    }
}
