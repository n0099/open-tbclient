package com.baidu.searchbox.logsystem.basic.upload;

import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.logsystem.uploadfile.BOSAttachFileUploader_Factory;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Autowired
/* loaded from: classes3.dex */
public class UploaderProvider {
    public static /* synthetic */ Interceptable $ic;
    public static final BaseContentUploader DEFAULT_CONTENT_UPLOADER;
    public static final BaseAttachFileUploader DEFAULT_FILE_UPLOADER;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(57950149, "Lcom/baidu/searchbox/logsystem/basic/upload/UploaderProvider;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(57950149, "Lcom/baidu/searchbox/logsystem/basic/upload/UploaderProvider;");
                return;
            }
        }
        DEFAULT_CONTENT_UPLOADER = new DefaultContentUploader();
        DEFAULT_FILE_UPLOADER = new DefaultAttachFileUploader();
    }

    public UploaderProvider() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Inject(force = false)
    public static BaseAttachFileUploader getAttachUploader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? BOSAttachFileUploader_Factory.get() : (BaseAttachFileUploader) invokeV.objValue;
    }

    @Inject(force = false)
    public static BaseContentUploader getContentUploader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? DEFAULT_CONTENT_UPLOADER : (BaseContentUploader) invokeV.objValue;
    }

    public static BaseAttachFileUploader getDefaultAttachUploader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? DEFAULT_FILE_UPLOADER : (BaseAttachFileUploader) invokeV.objValue;
    }

    public static BaseContentUploader getDefaultContentUploader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? DEFAULT_CONTENT_UPLOADER : (BaseContentUploader) invokeV.objValue;
    }
}
