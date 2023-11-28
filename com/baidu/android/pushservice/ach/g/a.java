package com.baidu.android.pushservice.ach.g;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.baidu.protect.sdk.Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class a extends Binder implements IInterface {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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
        attachInterface(this, "com.huawei.android.powerkit.adapter.IPowerKitApi");
    }

    public abstract int a(String str, int i);

    public abstract Map a(String str);

    public abstract boolean a(int i);

    public abstract boolean a(b bVar);

    public abstract boolean a(String str, int i, int i2);

    public abstract boolean a(String str, String str2, List list);

    public abstract boolean a(String str, boolean z, int i, int i2);

    public abstract boolean a(String str, boolean z, String str2, int i, long j, String str3) throws RemoteException;

    public abstract boolean a(String str, boolean z, String str2, long j, long j2);

    @Override // android.os.IInterface
    public IBinder asBinder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (IBinder) Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15943, this, null) : (IBinder) invokeV.objValue;
    }

    public abstract int b(String str);

    public abstract boolean b(int i);

    public abstract boolean b(b bVar);

    public abstract float c(String str);

    public abstract String d(String str);

    public abstract int e(String str);

    public abstract int f(String str);

    public abstract boolean g(String str);

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i), parcel, parcel2, Integer.valueOf(i2)})) == null) ? Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.z(-15938, this, Integer.valueOf(i), parcel, parcel2, Integer.valueOf(i2)) : invokeCommon.booleanValue;
    }
}
