package com.baidu.searchbox.retrieve.upload;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class UploaderProvider {
    public static /* synthetic */ Interceptable $ic;
    public static final BaseContentUploader DEFAULT_CONTENT_UPLOADER;
    public static final BaseFileUploader DEFAULT_FILE_UPLOADER;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1323521959, "Lcom/baidu/searchbox/retrieve/upload/UploaderProvider;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1323521959, "Lcom/baidu/searchbox/retrieve/upload/UploaderProvider;");
                return;
            }
        }
        DEFAULT_CONTENT_UPLOADER = new DefaultContentUploader();
        DEFAULT_FILE_UPLOADER = new DefaultFileUploader();
    }

    public UploaderProvider() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static BaseContentUploader getContentUploader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return ContentUploader_Factory.get();
        }
        return (BaseContentUploader) invokeV.objValue;
    }

    public static BaseFileUploader getFileUploader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return DEFAULT_FILE_UPLOADER;
        }
        return (BaseFileUploader) invokeV.objValue;
    }
}
