package com.baidu.mapapi.utils;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapframework.open.aidl.a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public final class d implements ServiceConnection {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d() {
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

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Thread thread;
        String str;
        String str2;
        com.baidu.mapframework.open.aidl.a aVar;
        com.baidu.mapframework.open.aidl.a aVar2;
        com.baidu.mapframework.open.aidl.a aVar3;
        Thread thread2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
            thread = b.v;
            if (thread != null) {
                thread2 = b.v;
                thread2.interrupt();
            }
            str = b.c;
            Log.d(str, "onServiceConnected " + componentName);
            try {
                aVar2 = b.d;
                if (aVar2 != null) {
                    com.baidu.mapframework.open.aidl.a unused = b.d = null;
                }
                com.baidu.mapframework.open.aidl.a unused2 = b.d = a.AbstractBinderC0106a.a(iBinder);
                aVar3 = b.d;
                aVar3.a(new e(this));
            } catch (RemoteException e) {
                str2 = b.c;
                Log.d(str2, "getComOpenClient ", e);
                aVar = b.d;
                if (aVar != null) {
                    com.baidu.mapframework.open.aidl.a unused3 = b.d = null;
                }
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        String str;
        com.baidu.mapframework.open.aidl.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
            str = b.c;
            Log.d(str, "onServiceDisconnected " + componentName);
            aVar = b.d;
            if (aVar != null) {
                com.baidu.mapframework.open.aidl.a unused = b.d = null;
                boolean unused2 = b.u = false;
            }
        }
    }
}
