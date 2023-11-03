package com.baidu.android.pushservice.ach.c.e;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.baidu.protect.sdk.Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class b extends Binder implements IInterface {
    public final Map<Integer, Method> a = new HashMap();
    public Class<?> b = null;
    public Class<?> c = null;
    public Object d = null;

    /* loaded from: classes.dex */
    public class a implements InvocationHandler {
        public final /* synthetic */ Map a;

        public a(Map map) {
            this.a = map;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            return Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15984, this, obj, method, objArr);
        }
    }

    public b() {
        attachInterface(this, "IDBinder.Stub");
    }

    public final int a(Method method) throws Exception {
        return Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.i(-15983, this, method);
    }

    public final Object a(Class<?> cls, Parcel parcel) {
        return Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15978, this, cls, parcel);
    }

    public Object a(Class<?> cls, Map<String, com.baidu.android.pushservice.ach.c.e.a<Object[], Object>> map) {
        return Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15977, this, cls, map);
    }

    public final String a(String str) {
        return (String) Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15980, this, str);
    }

    public final void a() {
        Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15979, this, null);
    }

    public final void a(Class<?> cls, Parcel parcel, Object obj) {
        Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-15974, this, cls, parcel, obj);
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return (IBinder) Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15973, this, null);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        return Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.z(-15976, this, Integer.valueOf(i), parcel, parcel2, Integer.valueOf(i2));
    }
}
