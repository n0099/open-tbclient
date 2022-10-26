package com.baidu.searchbox.logsystem.logsys.eventscene.handler;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.logsys.eventscene.EventObject;
import com.baidu.searchbox.logsystem.util.LLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
/* loaded from: classes2.dex */
public class ForwardingDeviceEventSceneHandler extends DeviceEventSceneHandler {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ForwardingCrash";
    public transient /* synthetic */ FieldHolder $fh;
    public final List mEventSceneHandlers;

    public ForwardingDeviceEventSceneHandler() {
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

    public ForwardingDeviceEventSceneHandler(List list) {
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
            Iterator it = list.iterator();
            while (it.hasNext()) {
                DeviceEventSceneHandler deviceEventSceneHandler = (DeviceEventSceneHandler) it.next();
                if (deviceEventSceneHandler != null) {
                    this.mEventSceneHandlers.add(deviceEventSceneHandler);
                }
            }
        }
    }

    public ForwardingDeviceEventSceneHandler(DeviceEventSceneHandler... deviceEventSceneHandlerArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {deviceEventSceneHandlerArr};
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
        if (deviceEventSceneHandlerArr != null && deviceEventSceneHandlerArr.length > 0) {
            for (DeviceEventSceneHandler deviceEventSceneHandler : deviceEventSceneHandlerArr) {
                if (deviceEventSceneHandler != null) {
                    this.mEventSceneHandlers.add(deviceEventSceneHandler);
                }
            }
        }
    }

    public ForwardingDeviceEventSceneHandler addEventHandleCallback(DeviceEventSceneHandler deviceEventSceneHandler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, deviceEventSceneHandler)) == null) {
            if (deviceEventSceneHandler != null) {
                this.mEventSceneHandlers.add(deviceEventSceneHandler);
            } else if (LLog.sDebug) {
                Log.d("ForwardingCrash", "callback instance should not be null in addEventHandleCallback()");
            }
            return this;
        }
        return (ForwardingDeviceEventSceneHandler) invokeL.objValue;
    }

    public ForwardingDeviceEventSceneHandler addEventHandleCallback(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (list != null && list.size() > 0) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    DeviceEventSceneHandler deviceEventSceneHandler = (DeviceEventSceneHandler) it.next();
                    if (deviceEventSceneHandler != null) {
                        this.mEventSceneHandlers.add(deviceEventSceneHandler);
                    }
                }
            }
            return this;
        }
        return (ForwardingDeviceEventSceneHandler) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.logsystem.logsys.eventscene.handler.BaseEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.EventSceneHandler
    public Set getCustomizedSnapshots(Context context, File file, EventObject eventObject) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, file, eventObject)) == null) {
            if (context == null && LLog.sDebug) {
                Log.d("ForwardingCrash", "Context is null in ForwardingEventSceneHandler.getCustomizedSnapshots.");
            }
            HashSet hashSet = null;
            for (EventSceneHandler eventSceneHandler : this.mEventSceneHandlers) {
                if (eventSceneHandler != null) {
                    try {
                        Set customizedSnapshots = eventSceneHandler.getCustomizedSnapshots(context, file, eventObject);
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

    @Override // com.baidu.searchbox.logsystem.logsys.eventscene.handler.DeviceEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.BaseEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.EventSceneHandler
    public Set requireGeneralSnapshots(Context context, EventObject eventObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, eventObject)) == null) {
            HashSet hashSet = null;
            for (DeviceEventSceneHandler deviceEventSceneHandler : this.mEventSceneHandlers) {
                if (deviceEventSceneHandler != null) {
                    try {
                        Set requireGeneralSnapshots = deviceEventSceneHandler.requireGeneralSnapshots(context, eventObject);
                        if (requireGeneralSnapshots != null && requireGeneralSnapshots.size() > 0) {
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
    public boolean saveFragmentSnapshot(Context context, EventObject eventObject, File file) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, context, eventObject, file)) == null) {
            while (true) {
                boolean z = false;
                for (DeviceEventSceneHandler deviceEventSceneHandler : this.mEventSceneHandlers) {
                    if (deviceEventSceneHandler != null) {
                        try {
                            boolean saveFragmentSnapshot = deviceEventSceneHandler.saveFragmentSnapshot(context, eventObject, file);
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
