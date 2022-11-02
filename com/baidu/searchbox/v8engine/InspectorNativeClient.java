package com.baidu.searchbox.v8engine;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@NotProguard
/* loaded from: classes2.dex */
public class InspectorNativeClient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public InspectorNativeChannel mChannel;
    public long mNativePtr;

    private native void nativeDestroyInspector(long j);

    private native void nativeDispatchProtocolMessage(long j, String str);

    private native long nativeInitInspector(long j, InspectorNativeChannel inspectorNativeChannel);

    private native void nativeScheduleBreak(long j);

    public InspectorNativeClient(long j, InspectorNativeChannel inspectorNativeChannel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), inspectorNativeChannel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mChannel = inspectorNativeChannel;
        this.mNativePtr = nativeInitInspector(j, inspectorNativeChannel);
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            nativeDestroyInspector(this.mNativePtr);
        }
    }

    public void scheduleBreak() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            nativeScheduleBreak(this.mNativePtr);
        }
    }

    public void dispatchProtocolMessage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            nativeDispatchProtocolMessage(this.mNativePtr, str);
        }
    }
}
