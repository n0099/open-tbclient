package com.baidu.cyberplayer.sdk.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes12.dex */
public interface c extends IInterface {

    /* loaded from: classes12.dex */
    public static abstract class a extends Binder implements c {

        /* renamed from: com.baidu.cyberplayer.sdk.remote.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        private static class C0114a implements c {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f1407a;

            C0114a(IBinder iBinder) {
                this.f1407a = iBinder;
            }

            @Override // com.baidu.cyberplayer.sdk.remote.c
            public IBinder a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory");
                    this.f1407a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readStrongBinder();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.c
            public IBinder a(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory");
                    obtain.writeInt(i);
                    this.f1407a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readStrongBinder();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.c
            public void a(String str, String str2, String str3, int i, int i2, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    this.f1407a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.c
            public boolean a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory");
                    obtain.writeString(str);
                    this.f1407a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1407a;
            }
        }

        public a() {
            attachInterface(this, "com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory");
        }

        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof c)) ? new C0114a(iBinder) : (c) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory");
                    IBinder a2 = a(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(a2);
                    return true;
                case 2:
                    parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory");
                    IBinder a3 = a();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(a3);
                    return true;
                case 3:
                    parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory");
                    a(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory");
                    boolean a4 = a(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(a4 ? 1 : 0);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    IBinder a() throws RemoteException;

    IBinder a(int i) throws RemoteException;

    void a(String str, String str2, String str3, int i, int i2, int i3) throws RemoteException;

    boolean a(String str) throws RemoteException;
}
