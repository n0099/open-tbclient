package com.baidu.swan.ubc;

import android.os.RemoteException;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.u.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.multiprocess.IPCServiceManager;
import com.baidu.swan.ubc.IRemoteUBCService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class OpenStatisticIPCManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            IPCServiceManager.c("open_log", new IRemoteUBCService.Stub() { // from class: com.baidu.swan.ubc.OpenStatisticIPCManager.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.baidu.swan.ubc.IRemoteUBCService
                public void flowAddEvent(Flow flow, String str, String str2) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLLL(1048576, this, flow, str, str2) == null) || flow == null) {
                        return;
                    }
                    flow.addEvent(str, str2);
                }

                @Override // com.baidu.swan.ubc.IRemoteUBCService
                public void flowAddEventWithTime(Flow flow, String str, String str2, long j2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{flow, str, str2, Long.valueOf(j2)}) == null) || flow == null) {
                        return;
                    }
                    flow.addEvent(str, str2, j2);
                }

                @Override // com.baidu.swan.ubc.IRemoteUBCService
                public void flowCancel(Flow flow) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, flow) == null) || flow == null) {
                        return;
                    }
                    flow.cancel();
                }

                @Override // com.baidu.swan.ubc.IRemoteUBCService
                public void flowEnd(Flow flow) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048579, this, flow) == null) || flow == null) {
                        return;
                    }
                    flow.end();
                }

                @Override // com.baidu.swan.ubc.IRemoteUBCService
                public void flowEndSlot(Flow flow, String str) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLL(1048580, this, flow, str) == null) || flow == null) {
                        return;
                    }
                    flow.endSlot(str);
                }

                @Override // com.baidu.swan.ubc.IRemoteUBCService
                public void flowSetValue(Flow flow, String str) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLL(1048581, this, flow, str) == null) || flow == null) {
                        return;
                    }
                    flow.setValue(str);
                }

                @Override // com.baidu.swan.ubc.IRemoteUBCService
                public void flowSetValueWithDuration(Flow flow, String str) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLL(1048582, this, flow, str) == null) || flow == null) {
                        return;
                    }
                    flow.setValueWithDuration(str);
                }

                @Override // com.baidu.swan.ubc.IRemoteUBCService
                public void flowStartSlot(Flow flow, String str, String str2) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLLL(1048583, this, flow, str, str2) == null) || flow == null) {
                        return;
                    }
                    if (TextUtils.isEmpty(str2)) {
                        flow.startSlot(str, null);
                        return;
                    }
                    try {
                        flow.startSlot(str, new JSONObject(str2));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }

                @Override // com.baidu.swan.ubc.IRemoteUBCService
                public Flow ubcBeginFlow(String str, String str2, int i2) throws RemoteException {
                    InterceptResult invokeLLI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLLI = interceptable2.invokeLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, i2)) == null) ? e.e(str, str2, i2) : (Flow) invokeLLI.objValue;
                }

                @Override // com.baidu.swan.ubc.IRemoteUBCService
                public void ubcOnEvent(String str, String str2, int i2) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLI(1048585, this, str, str2, i2) == null) {
                        e.i(str, str2, i2);
                    }
                }
            }, false);
        }
    }
}
