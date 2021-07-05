package com.baidu.android.imsdk.chatmessage.sync;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class SyncManager {
    public static /* synthetic */ Interceptable $ic;
    public static boolean sSyncDone;
    public static ArrayList<ISyncStateListener> sSyncStateListeners;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1325346442, "Lcom/baidu/android/imsdk/chatmessage/sync/SyncManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1325346442, "Lcom/baidu/android/imsdk/chatmessage/sync/SyncManager;");
                return;
            }
        }
        sSyncStateListeners = new ArrayList<>();
    }

    public SyncManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static Boolean isSyncDone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? Boolean.valueOf(sSyncDone) : (Boolean) invokeV.objValue;
    }

    public static synchronized void notifySyncDone() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            synchronized (SyncManager.class) {
                sSyncDone = true;
                Iterator<ISyncStateListener> it = sSyncStateListeners.iterator();
                while (it.hasNext()) {
                    it.next().onSyncDone();
                }
                sSyncStateListeners.clear();
            }
        }
    }

    public static synchronized void registerSyncStateListener(ISyncStateListener iSyncStateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, null, iSyncStateListener) == null) {
            synchronized (SyncManager.class) {
                if (iSyncStateListener != null) {
                    if (sSyncDone) {
                        iSyncStateListener.onSyncDone();
                    } else if (!sSyncStateListeners.contains(iSyncStateListener)) {
                        sSyncStateListeners.add(iSyncStateListener);
                    }
                }
            }
        }
    }
}
