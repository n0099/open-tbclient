package com.baidu.android.pushservice.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.baidu.android.pushservice.a.b;
/* loaded from: classes3.dex */
public interface a extends IInterface {

    /* renamed from: com.baidu.android.pushservice.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static abstract class AbstractBinderC0029a extends Binder implements a {
        public AbstractBinderC0029a() {
            attachInterface(this, "com.baidu.android.pushservice.aidl.IPushService");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
                    a(parcel.readString(), parcel.readString(), parcel.readInt() != 0, b.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
                    a(parcel.readString(), parcel.readString(), b.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
                    b(parcel.readString(), parcel.readString(), b.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
                    String a = a();
                    parcel2.writeNoException();
                    parcel2.writeString(a);
                    return true;
                case 5:
                    parcel.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
                    String b = b();
                    parcel2.writeNoException();
                    parcel2.writeString(b);
                    return true;
                case 6:
                    parcel.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
                    String a2 = a(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(a2);
                    return true;
                case 7:
                    parcel.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
                    String a3 = a(parcel.readString(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeString(a3);
                    return true;
                case 8:
                    parcel.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
                    int a4 = a(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(a4);
                    return true;
                case 9:
                    parcel.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
                    int b2 = b(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(b2);
                    return true;
                case 10:
                    parcel.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
                    int b3 = b(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(b3);
                    return true;
                case 11:
                    parcel.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
                    int c = c(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(c);
                    return true;
                case 12:
                    parcel.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
                    int c2 = c(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(c2);
                    return true;
                case 13:
                    parcel.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
                    boolean a5 = a(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(a5 ? 1 : 0);
                    return true;
                case 14:
                    parcel.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
                    boolean a6 = a(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(a6 ? 1 : 0);
                    return true;
                case 15:
                    parcel.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
                    boolean a7 = a(parcel.readString(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(a7 ? 1 : 0);
                    return true;
                case 16:
                    parcel.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
                    boolean b4 = b(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(b4 ? 1 : 0);
                    return true;
                case 17:
                    parcel.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
                    int d = d(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(d);
                    return true;
                case 18:
                    parcel.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
                    boolean e = e(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(e ? 1 : 0);
                    return true;
                case 19:
                    parcel.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
                    boolean a8 = a(parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    parcel2.writeInt(a8 ? 1 : 0);
                    return true;
                case 20:
                    parcel.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
                    int c3 = c();
                    parcel2.writeNoException();
                    parcel2.writeInt(c3);
                    return true;
                case 21:
                    parcel.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
                    a(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString(), b.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 22:
                    parcel.enforceInterface("com.baidu.android.pushservice.aidl.IPushService");
                    String f = f(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(f);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.baidu.android.pushservice.aidl.IPushService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    int a(String str, int i) throws RemoteException;

    String a() throws RemoteException;

    String a(String str) throws RemoteException;

    String a(String str, int i, boolean z, int i2, int i3) throws RemoteException;

    void a(String str, String str2, b bVar) throws RemoteException;

    void a(String str, String str2, boolean z, b bVar) throws RemoteException;

    void a(String str, String str2, boolean z, String str3, b bVar) throws RemoteException;

    boolean a(String str, String str2) throws RemoteException;

    boolean a(String str, String str2, int i) throws RemoteException;

    boolean a(String str, String str2, String str3, String str4) throws RemoteException;

    boolean a(String str, boolean z) throws RemoteException;

    int b(String str) throws RemoteException;

    int b(String str, int i) throws RemoteException;

    String b() throws RemoteException;

    void b(String str, String str2, b bVar) throws RemoteException;

    boolean b(String str, String str2) throws RemoteException;

    int c() throws RemoteException;

    int c(String str) throws RemoteException;

    int c(String str, int i) throws RemoteException;

    int d(String str) throws RemoteException;

    boolean e(String str) throws RemoteException;

    String f(String str) throws RemoteException;
}
