package com.baidu.platform.comjni.map.msgcenter;

import com.baidu.platform.comjni.JNIBaseApi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class NAMsgCenter extends JNIBaseApi {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    private native boolean nativeCancelRequest(long j);

    private native long nativeCreate();

    private native boolean nativeFetchAccessToken(long j);

    private native String nativeGetCenterParam(long j, String str);

    private native boolean nativeMSGCStartup(long j);

    private native boolean nativeRegMsgCenter(long j, String str);

    private native int nativeRelease(long j);

    private native boolean nativeSetCenterParam(long j, String str);

    public NAMsgCenter() {
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
        this.a = 0L;
    }
}
