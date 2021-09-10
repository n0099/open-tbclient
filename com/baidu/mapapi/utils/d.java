package com.baidu.mapapi.utils;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapframework.open.aidl.a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class d implements ServiceConnection {
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

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Thread thread;
        com.baidu.mapframework.open.aidl.a aVar;
        com.baidu.mapframework.open.aidl.a aVar2;
        com.baidu.mapframework.open.aidl.a aVar3;
        Thread thread2;
        String unused;
        String unused2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
            thread = b.v;
            if (thread != null) {
                thread2 = b.v;
                thread2.interrupt();
            }
            unused = b.f42013c;
            String str = "onServiceConnected " + componentName;
            try {
                aVar2 = b.f42014d;
                if (aVar2 != null) {
                    com.baidu.mapframework.open.aidl.a unused3 = b.f42014d = null;
                }
                com.baidu.mapframework.open.aidl.a unused4 = b.f42014d = a.AbstractBinderC1666a.a(iBinder);
                aVar3 = b.f42014d;
                aVar3.a(new e(this));
            } catch (RemoteException unused5) {
                unused2 = b.f42013c;
                aVar = b.f42014d;
                if (aVar != null) {
                    com.baidu.mapframework.open.aidl.a unused6 = b.f42014d = null;
                }
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        com.baidu.mapframework.open.aidl.a aVar;
        String unused;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
            unused = b.f42013c;
            String str = "onServiceDisconnected " + componentName;
            aVar = b.f42014d;
            if (aVar != null) {
                com.baidu.mapframework.open.aidl.a unused2 = b.f42014d = null;
                boolean unused3 = b.u = false;
            }
        }
    }
}
