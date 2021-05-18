package com.baidu.cyberplayer.sdk.remote;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public interface a extends IInterface {

    /* renamed from: com.baidu.cyberplayer.sdk.remote.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractBinderC0071a extends Binder implements a {

        /* renamed from: com.baidu.cyberplayer.sdk.remote.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0072a implements a {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f5024a;

            public C0072a(IBinder iBinder) {
                this.f5024a = iBinder;
            }

            @Override // com.baidu.cyberplayer.sdk.remote.a
            public Bundle a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemoteExtractor");
                    this.f5024a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.a
            public void a(int i2, String str, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemoteExtractor");
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    this.f5024a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.a
            public void a(e eVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemoteExtractor");
                    if (eVar != null) {
                        obtain.writeInt(1);
                        eVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f5024a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f5024a;
            }

            @Override // com.baidu.cyberplayer.sdk.remote.a
            public void b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemoteExtractor");
                    this.f5024a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public AbstractBinderC0071a() {
            attachInterface(this, "com.baidu.cyberplayer.sdk.remote.IRemoteExtractor");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.baidu.cyberplayer.sdk.remote.IRemoteExtractor");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0072a(iBinder) : (a) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemoteExtractor");
                a(parcel.readInt() != 0 ? e.CREATOR.createFromParcel(parcel) : null);
            } else if (i2 == 2) {
                parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemoteExtractor");
                a(parcel.readInt(), parcel.readString(), parcel.readLong());
            } else if (i2 == 3) {
                parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemoteExtractor");
                Bundle a2 = a();
                parcel2.writeNoException();
                if (a2 != null) {
                    parcel2.writeInt(1);
                    a2.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            } else if (i2 != 4) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString("com.baidu.cyberplayer.sdk.remote.IRemoteExtractor");
                return true;
            } else {
                parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemoteExtractor");
                b();
            }
            parcel2.writeNoException();
            return true;
        }
    }

    Bundle a() throws RemoteException;

    void a(int i2, String str, long j) throws RemoteException;

    void a(e eVar) throws RemoteException;

    void b() throws RemoteException;
}
