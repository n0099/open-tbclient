package com.baidu.platform.comjni.base.networkdetect;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comjni.NativeComponent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class NANetworkDetect extends NativeComponent {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    private native long nativeCreate();

    private native boolean nativeNetworkDetect(long j, String str);

    private native int nativeRelease(long j);

    public NANetworkDetect() {
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
        create();
    }

    @Override // com.baidu.platform.comjni.NativeComponent
    public long create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.mNativePointer = nativeCreate();
            return this.mNativePointer;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.platform.comjni.NativeComponent
    public int dispose() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return nativeRelease(this.mNativePointer);
        }
        return invokeV.intValue;
    }
}
