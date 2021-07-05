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
/* loaded from: classes3.dex */
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
            str = b.f7485c;
            Log.d(str, "onServiceConnected " + componentName);
            try {
                aVar2 = b.f7486d;
                if (aVar2 != null) {
                    com.baidu.mapframework.open.aidl.a unused = b.f7486d = null;
                }
                com.baidu.mapframework.open.aidl.a unused2 = b.f7486d = a.AbstractBinderC0114a.a(iBinder);
                aVar3 = b.f7486d;
                aVar3.a(new e(this));
            } catch (RemoteException e2) {
                str2 = b.f7485c;
                Log.d(str2, "getComOpenClient ", e2);
                aVar = b.f7486d;
                if (aVar != null) {
                    com.baidu.mapframework.open.aidl.a unused3 = b.f7486d = null;
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
            str = b.f7485c;
            Log.d(str, "onServiceDisconnected " + componentName);
            aVar = b.f7486d;
            if (aVar != null) {
                com.baidu.mapframework.open.aidl.a unused = b.f7486d = null;
                boolean unused2 = b.u = false;
            }
        }
    }
}
