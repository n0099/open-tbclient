package com.baidu.platform.comjni.map.dataengine;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comjni.NativeComponent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class NADataEngine extends NativeComponent {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    private native void nativeCancelThumbImageRequest(long j);

    private native long nativeCreate();

    private native String nativeGetCurrentStreetId(long j);

    private native String nativeGetCurrentStreetInfo(long j, Bundle bundle);

    private native boolean nativeGetHotMapCityInfo(long j, Bundle bundle);

    private native boolean nativeGetStreetCityInfo(long j, Bundle bundle);

    private native boolean nativeQueryThumbImage(long j, String str);

    private native int nativeRelease(long j);

    private native void nativeSetStreetPOIUID(long j, String str);

    private native boolean nativeStreetSwitchByUID(long j, String str, String str2);

    private native boolean nativeStreetSwitchToID(long j, String str, int i);

    private native boolean nativeStreetSwitchToIDFromReGeo(long j, String str, String str2, long j2, long j3);

    private native boolean nativeStreetSwitchToIID(long j, String str, String str2, boolean z);

    public NADataEngine() {
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
                int nativeRelease = nativeRelease(this.mNativePointer);
                this.mNativePointer = 0L;
                return nativeRelease;
            }
            return 0;
        }
        return invokeV.intValue;
    }
}
