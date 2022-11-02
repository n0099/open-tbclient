package com.baidu.searchbox.logsystem.logsys.eventscene.handler;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.logsys.LogFile;
import com.baidu.searchbox.logsystem.logsys.eventscene.EventObject;
import com.baidu.searchbox.logsystem.logsys.eventscene.snapshot.ProcessSnapshotType;
import com.baidu.searchbox.logsystem.util.LLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
/* loaded from: classes2.dex */
public class ForwardingProcessEventSceneHandler extends ProcessEventSceneHandler {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ForwardingCrash";
    public transient /* synthetic */ FieldHolder $fh;
    public final List<ProcessEventSceneHandler> mEventSceneHandlers;

    public ForwardingProcessEventSceneHandler() {
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
        this.mEventSceneHandlers = new LinkedList();
    }

    public ForwardingProcessEventSceneHandler(@NonNull List<ProcessEventSceneHandler> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mEventSceneHandlers = new LinkedList();
        if (list != null && list.size() > 0) {
            for (ProcessEventSceneHandler processEventSceneHandler : list) {
                if (processEventSceneHandler != null) {
                    this.mEventSceneHandlers.add(processEventSceneHandler);
                }
            }
        }
    }

    public ForwardingProcessEventSceneHandler(@NonNull ProcessEventSceneHandler... processEventSceneHandlerArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {processEventSceneHandlerArr};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mEventSceneHandlers = new LinkedList();
        if (processEventSceneHandlerArr != null && processEventSceneHandlerArr.length > 0) {
            for (ProcessEventSceneHandler processEventSceneHandler : processEventSceneHandlerArr) {
                if (processEventSceneHandler != null) {
                    this.mEventSceneHandlers.add(processEventSceneHandler);
                }
            }
        }
    }

    public ForwardingProcessEventSceneHandler addEventHandleCallback(@NonNull ProcessEventSceneHandler processEventSceneHandler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, processEventSceneHandler)) == null) {
            if (processEventSceneHandler != null) {
                this.mEventSceneHandlers.add(processEventSceneHandler);
            } else if (LLog.sDebug) {
                Log.d("ForwardingCrash", "callback instance should not be null in addEventHandleCallback()");
            }
            return this;
        }
        return (ForwardingProcessEventSceneHandler) invokeL.objValue;
    }

    public ForwardingProcessEventSceneHandler addEventHandleCallback(@NonNull List<ProcessEventSceneHandler> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (list != null && list.size() > 0) {
                for (ProcessEventSceneHandler processEventSceneHandler : list) {
                    if (processEventSceneHandler != null) {
                        this.mEventSceneHandlers.add(processEventSceneHandler);
                    }
                }
            }
            return this;
        }
        return (ForwardingProcessEventSceneHandler) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.logsystem.logsys.eventscene.handler.BaseEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.EventSceneHandler
    @Nullable
    public Set<LogFile> getCustomizedSnapshots(@NonNull Context context, @NonNull File file, @NonNull EventObject eventObject) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, file, eventObject)) == null) {
            if (context == null && LLog.sDebug) {
                Log.d("ForwardingCrash", "Context is null in ForwardingEventSceneHandler.getCustomizedSnapshots.");
            }
            HashSet hashSet = null;
            for (ProcessEventSceneHandler processEventSceneHandler : this.mEventSceneHandlers) {
                if (processEventSceneHandler != null) {
                    try {
                        Set<LogFile> customizedSnapshots = processEventSceneHandler.getCustomizedSnapshots(context, file, eventObject);
                        if (customizedSnapshots != null && customizedSnapshots.size() > 0) {
                            if (hashSet == null) {
                                hashSet = new HashSet(customizedSnapshots.size());
                            }
                            hashSet.addAll(customizedSnapshots);
                        }
                    } catch (Exception e) {
                        if (LLog.sDebug) {
                            Log.d("ForwardingCrash", Log.getStackTraceString(e));
                        }
                    }
                }
            }
            return hashSet;
        }
        return (Set) invokeLLL.objValue;
    }

    @Override // com.baidu.searchbox.logsystem.logsys.eventscene.handler.ProcessEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.BaseEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.EventSceneHandler
    public Set<ProcessSnapshotType> requireGeneralSnapshots(@NonNull Context context, @NonNull EventObject eventObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, eventObject)) == null) {
            HashSet hashSet = null;
            for (ProcessEventSceneHandler processEventSceneHandler : this.mEventSceneHandlers) {
                if (processEventSceneHandler != null) {
                    try {
                        Set<T> requireGeneralSnapshots = processEventSceneHandler.requireGeneralSnapshots(context, eventObject);
                        if (requireGeneralSnapshots != 0 && requireGeneralSnapshots.size() > 0) {
                            if (hashSet == null) {
                                hashSet = new HashSet(5);
                            }
                            hashSet.addAll(requireGeneralSnapshots);
                        }
                    } catch (Exception e) {
                        if (LLog.sDebug) {
                            Log.d("ForwardingCrash", Log.getStackTraceString(e));
                        }
                    }
                }
            }
            return hashSet;
        }
        return (Set) invokeLL.objValue;
    }

    @Override // com.baidu.searchbox.logsystem.logsys.eventscene.handler.BaseEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.EventSceneHandler
    public boolean saveFragmentSnapshot(@NonNull Context context, @NonNull EventObject eventObject, @NonNull File file) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, context, eventObject, file)) == null) {
            while (true) {
                boolean z = false;
                for (ProcessEventSceneHandler processEventSceneHandler : this.mEventSceneHandlers) {
                    if (processEventSceneHandler != null) {
                        try {
                            boolean saveFragmentSnapshot = processEventSceneHandler.saveFragmentSnapshot(context, eventObject, file);
                            if (z || saveFragmentSnapshot) {
                                z = true;
                            }
                        } catch (Exception e) {
                            if (LLog.sDebug) {
                                Log.d("ForwardingCrash", Log.getStackTraceString(e));
                            }
                        }
                    }
                }
                return z;
            }
        }
        return invokeLLL.booleanValue;
    }
}
