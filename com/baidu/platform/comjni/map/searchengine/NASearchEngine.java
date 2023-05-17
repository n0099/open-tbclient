package com.baidu.platform.comjni.map.searchengine;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comjni.NativeComponent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class NASearchEngine extends NativeComponent {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static native boolean nativeCancelRequest(long j, int i);

    public static native long nativeCreate();

    public static native String nativeGetJsonResult(long j, int i);

    public static native byte[] nativeGetProtobufResult(long j, int i);

    public static native boolean nativeInit(long j, int i);

    public static native boolean nativeInitWithBundle(long j, String str);

    public static native int nativeRelease(long j);

    public static native int nativeRequest(long j, String str);

    public static native boolean nativeRequestData(long j, byte[] bArr);

    public static native void nativeUpdateOfflineSearchPath(long j, String str);

    public NASearchEngine() {
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
            if (this.mNativePointer != 0) {
                return nativeRelease(this.mNativePointer);
            }
            return 0;
        }
        return invokeV.intValue;
    }
}
