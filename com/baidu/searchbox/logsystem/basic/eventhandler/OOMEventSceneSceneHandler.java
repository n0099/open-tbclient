package com.baidu.searchbox.logsystem.basic.eventhandler;

import android.content.Context;
import com.baidu.searchbox.logsystem.logsys.eventscene.EventObject;
import com.baidu.searchbox.logsystem.logsys.eventscene.handler.ProcessEventSceneHandler;
import com.baidu.searchbox.logsystem.logsys.eventscene.snapshot.ProcessSnapshotType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class OOMEventSceneSceneHandler extends ProcessEventSceneHandler {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String OOM = "java.lang.OutOfMemoryError";
    public transient /* synthetic */ FieldHolder $fh;

    public OOMEventSceneSceneHandler() {
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

    @Override // com.baidu.searchbox.logsystem.logsys.eventscene.handler.ProcessEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.BaseEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.EventSceneHandler
    public Set requireGeneralSnapshots(Context context, EventObject eventObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, eventObject)) == null) {
            if (eventObject.mEventLog.contains("java.lang.OutOfMemoryError")) {
                HashSet hashSet = new HashSet(1);
                hashSet.add(ProcessSnapshotType.PROCESS_MEMORY_STATUS);
                return hashSet;
            }
            return null;
        }
        return (Set) invokeLL.objValue;
    }
}
