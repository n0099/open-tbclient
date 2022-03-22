package com.baidu.searchbox.logsystem.basic.eventhandler;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.logsystem.logsys.eventscene.EventObject;
import com.baidu.searchbox.logsystem.logsys.eventscene.handler.DeviceEventSceneHandler;
import com.baidu.searchbox.logsystem.logsys.eventscene.snapshot.DeviceSnapshotType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class OOMDeviceEventSceneSceneHandler extends DeviceEventSceneHandler {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EGL_BAD_ALLOC = "EGL_BAD_ALLOC";
    public static final String OOM = "java.lang.OutOfMemoryError";
    public transient /* synthetic */ FieldHolder $fh;

    public OOMDeviceEventSceneSceneHandler() {
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

    @Override // com.baidu.searchbox.logsystem.logsys.eventscene.handler.DeviceEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.BaseEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.EventSceneHandler
    @Nullable
    public Set<DeviceSnapshotType> requireGeneralSnapshots(@NonNull Context context, @NonNull EventObject eventObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, eventObject)) == null) {
            if (eventObject.mEventLog.contains("java.lang.OutOfMemoryError")) {
                HashSet hashSet = new HashSet(1);
                hashSet.add(DeviceSnapshotType.DEVICE_APP_DB_INFO);
                if (eventObject.mEventLog.contains(EGL_BAD_ALLOC)) {
                    hashSet.add(DeviceSnapshotType.DEVICE_GUP_MEM);
                    hashSet.add(DeviceSnapshotType.DEVICE_ION_MEM);
                    return hashSet;
                }
                return hashSet;
            }
            return null;
        }
        return (Set) invokeLL.objValue;
    }
}
