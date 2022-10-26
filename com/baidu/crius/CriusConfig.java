package com.baidu.crius;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class CriusConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long mNativePointer;

    private native void jni_CSConfigFree(long j);

    private native long jni_CSConfigNew();

    private native void jni_CSConfigSetLoggerEnabled(long j, boolean z);

    private native void jni_CSConfigSetPointScaleFactor(long j, float f);

    public CriusConfig() {
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
        long jni_CSConfigNew = jni_CSConfigNew();
        this.mNativePointer = jni_CSConfigNew;
        if (jni_CSConfigNew == 0 && CriusConstants.DEBUG) {
            throw new IllegalStateException("Failed to allocate native memory");
        }
    }

    public void finalize() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                jni_CSConfigFree(this.mNativePointer);
            } finally {
                super.finalize();
            }
        }
    }

    public void setLoggerEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            jni_CSConfigSetLoggerEnabled(this.mNativePointer, z);
        }
    }

    public void setPointScaleFactor(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f) == null) {
            jni_CSConfigSetPointScaleFactor(this.mNativePointer, f);
        }
    }
}
