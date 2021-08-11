package com.baidu.mobads.container.util;

import android.os.Handler;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IOAdEventDispatcher;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class XAdRemoteEventDispatcher implements IOAdEventDispatcher {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, ArrayList<IOAdEventListener>> evtlisteners;
    public Handler mHandler;

    public XAdRemoteEventDispatcher() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        removeAllListeners();
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    @Override // com.baidu.mobads.container.adrequest.IOAdEventDispatcher
    public void addEventListener(String str, IOAdEventListener iOAdEventListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, iOAdEventListener) == null) || str == null || iOAdEventListener == null) {
            return;
        }
        removeEventListener(str, iOAdEventListener);
        ArrayList<IOAdEventListener> arrayList = this.evtlisteners.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.evtlisteners.put(str, arrayList);
        }
        arrayList.add(iOAdEventListener);
    }

    @Override // com.baidu.mobads.container.adrequest.IOAdEventDispatcher
    public void dispatchEvent(IOAdEvent iOAdEvent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iOAdEvent) == null) || iOAdEvent == null) {
            return;
        }
        try {
            iOAdEvent.setTarget(this);
            ArrayList<IOAdEventListener> arrayList = this.evtlisteners.get(iOAdEvent.getType());
            if (arrayList != null) {
                int size = arrayList.size();
                IOAdEventListener[] iOAdEventListenerArr = new IOAdEventListener[size];
                arrayList.toArray(iOAdEventListenerArr);
                for (int i2 = 0; i2 < size; i2++) {
                    IOAdEventListener iOAdEventListener = iOAdEventListenerArr[i2];
                    if (iOAdEventListener != null) {
                        iOAdEventListener.run(iOAdEvent);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            removeAllListeners();
        }
    }

    public IOAdEventListener getEventType(String str) {
        InterceptResult invokeL;
        ArrayList<IOAdEventListener> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (!hasEventListener(str) || (arrayList = this.evtlisteners.get(str)) == null || arrayList.size() <= 0) {
                return null;
            }
            return arrayList.get(0);
        }
        return (IOAdEventListener) invokeL.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IOAdEventDispatcher
    public boolean hasEventListener(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            ArrayList<IOAdEventListener> arrayList = this.evtlisteners.get(str);
            return (arrayList == null || arrayList.isEmpty()) ? false : true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.mobads.container.adrequest.IOAdEventDispatcher
    public void removeAllListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.evtlisteners = new ConcurrentHashMap();
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IOAdEventDispatcher
    public void removeEventListener(String str, IOAdEventListener iOAdEventListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, str, iOAdEventListener) == null) && str != null && iOAdEventListener != null) {
            try {
                ArrayList<IOAdEventListener> arrayList = this.evtlisteners.get(str);
                if (arrayList == null || arrayList.size() <= 0) {
                    return;
                }
                arrayList.remove(iOAdEventListener);
                if (!arrayList.isEmpty()) {
                    return;
                }
                this.evtlisteners.remove(str);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.baidu.mobads.container.adrequest.IOAdEventDispatcher
    public void removeEventListeners(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.evtlisteners.remove(str);
        }
    }
}
