package com.baidu.searchbox.logsystem.basic.eventhandler;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.logsystem.logsys.eventscene.EventObject;
import com.baidu.searchbox.logsystem.logsys.eventscene.snapshot.ProcessSnapshotType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes7.dex */
public class VssOOMEventSceneSceneHandler extends OOMEventSceneSceneHandler {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CWA = "android.database.CursorWindowAllocationException: Cursor window allocation";
    public static final String PC = "pthread_create";
    public transient /* synthetic */ FieldHolder $fh;

    public VssOOMEventSceneSceneHandler() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.searchbox.logsystem.basic.eventhandler.OOMEventSceneSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.ProcessEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.BaseEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.EventSceneHandler
    @Nullable
    public Set<ProcessSnapshotType> requireGeneralSnapshots(@NonNull Context context, @NonNull EventObject eventObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, eventObject)) == null) {
            String str = eventObject.mEventLog;
            if ((str.contains("java.lang.OutOfMemoryError") && str.contains(PC)) || str.contains(CWA)) {
                Set<ProcessSnapshotType> requireGeneralSnapshots = super.requireGeneralSnapshots(context, eventObject);
                if (requireGeneralSnapshots == null) {
                    requireGeneralSnapshots = new HashSet<>(4);
                }
                requireGeneralSnapshots.add(ProcessSnapshotType.PROCESS_SMAPS);
                requireGeneralSnapshots.add(ProcessSnapshotType.PROCESS_MAPS);
                requireGeneralSnapshots.add(ProcessSnapshotType.PROCESS_THREAD_LIST);
                requireGeneralSnapshots.add(ProcessSnapshotType.PROCESS_FILE_DESCRIPTOR);
                return requireGeneralSnapshots;
            }
            return null;
        }
        return (Set) invokeLL.objValue;
    }
}
