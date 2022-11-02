package com.baidu.platform.comjni.map.commonmemcache;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comjni.NativeComponent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class NACommonMemCache extends NativeComponent {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static native long nativeCreate();

    public static native String nativeDecodeUsync(long j, String str);

    public static native String nativeEnCrypt(long j, String str);

    public static native String nativeEnCryptWithType(long j, String str, String str2);

    public static native String nativeEnCryptWithUsync(long j, String str);

    public static native String nativeGetKeyString(long j, String str);

    public static native String nativeGetPhoneInfoBundle(long j, boolean z);

    public static native String nativeGetPhoneInfoUrl(long j);

    public static native String nativeGetSataInfo(long j, boolean z, int i, int i2);

    public static native void nativeInit(long j, String str);

    public static native int nativeRelease(long j);

    public static native void nativeSetKeyBundle(long j, String str, String str2);

    public static native void nativeSetKeyDouble(long j, String str, double d);

    public static native void nativeSetKeyFloat(long j, String str, float f);

    public static native void nativeSetKeyInt(long j, String str, int i);

    public static native void nativeSetKeyString(long j, String str, String str2);

    public NACommonMemCache() {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            this.mNativePointer = nativeCreate();
            return this.mNativePointer;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.platform.comjni.NativeComponent
    public int dispose() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.mNativePointer != 0) {
                int nativeRelease = nativeRelease(this.mNativePointer);
                this.mNativePointer = 0L;
                return nativeRelease;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            nativeInit(this.mNativePointer, str);
        }
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            nativeSetKeyBundle(this.mNativePointer, str, str2);
        }
    }
}
