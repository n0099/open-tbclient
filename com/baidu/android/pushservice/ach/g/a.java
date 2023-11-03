package com.baidu.android.pushservice.ach.g;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.baidu.protect.sdk.Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class a extends Binder implements IInterface {
    public a() {
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
        return (IBinder) Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15943, this, null);
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
        return Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.z(-15938, this, Integer.valueOf(i), parcel, parcel2, Integer.valueOf(i2));
    }
}
