package c.a.s0.s.c0;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.logsys.LogFile;
import com.baidu.searchbox.logsystem.logsys.eventscene.EventObject;
import com.baidu.searchbox.logsystem.logsys.eventscene.handler.ProcessEventSceneHandler;
import com.baidu.searchbox.logsystem.logsys.eventscene.snapshot.ProcessSnapshotType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public class d extends ProcessEventSceneHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d() {
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

    @Override // com.baidu.searchbox.logsystem.logsys.eventscene.handler.BaseEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.EventSceneHandler
    @Nullable
    public Set<LogFile> getCustomizedSnapshots(@NonNull Context context, @NonNull File file, @NonNull EventObject eventObject) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, file, eventObject)) == null) {
            return null;
        }
        return (Set) invokeLLL.objValue;
    }

    @Override // com.baidu.searchbox.logsystem.logsys.eventscene.handler.ProcessEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.BaseEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.EventSceneHandler
    public Set<ProcessSnapshotType> requireGeneralSnapshots(@NonNull Context context, @NonNull EventObject eventObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, eventObject)) == null) {
            if (eventObject.mEventLog.contains("OutOfMemoryError")) {
                HashSet hashSet = new HashSet(1);
                hashSet.add(ProcessSnapshotType.PROCESS_MEMORY_STATUS);
                return hashSet;
            }
            return null;
        }
        return (Set) invokeLL.objValue;
    }

    @Override // com.baidu.searchbox.logsystem.logsys.eventscene.handler.BaseEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.EventSceneHandler
    public boolean saveFragmentSnapshot(@NonNull Context context, @NonNull EventObject eventObject, @NonNull File file) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, eventObject, file)) == null) {
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
