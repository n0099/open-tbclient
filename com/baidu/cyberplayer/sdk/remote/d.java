package com.baidu.cyberplayer.sdk.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.baidu.cyberplayer.sdk.remote.a;
/* loaded from: classes3.dex */
public interface d extends IInterface {
    IBinder a() throws RemoteException;

    IBinder a(int i) throws RemoteException;

    void a(com.baidu.cyberplayer.sdk.remote.a aVar) throws RemoteException;

    void a(String str, int i, long j, String str2, PrefetchOptions prefetchOptions) throws RemoteException;

    void a(String str, String str2, String str3, int i, int i2, int i3, String str4, int i4, int i5, int i6, int i7, PrefetchOptions prefetchOptions) throws RemoteException;

    boolean a(String str) throws RemoteException;

    long b() throws RemoteException;

    void b(int i) throws RemoteException;

    boolean b(String str) throws RemoteException;

    /* loaded from: classes3.dex */
    public static abstract class a extends Binder implements d {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        /* renamed from: com.baidu.cyberplayer.sdk.remote.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0098a implements d {
            public IBinder a;

            public C0098a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.baidu.cyberplayer.sdk.remote.d
            public IBinder a(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory");
                    obtain.writeInt(i);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readStrongBinder();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.d
            public void b(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory");
                    obtain.writeInt(i);
                    this.a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.d
            public IBinder a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory");
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readStrongBinder();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // com.baidu.cyberplayer.sdk.remote.d
            public long b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory");
                    this.a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.d
            public void a(com.baidu.cyberplayer.sdk.remote.a aVar) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory");
                    if (aVar != null) {
                        iBinder = aVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.d
            public boolean b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory");
                    obtain.writeString(str);
                    boolean z = false;
                    this.a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.d
            public void a(String str, int i, long j, String str2, PrefetchOptions prefetchOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    obtain.writeString(str2);
                    if (prefetchOptions != null) {
                        obtain.writeInt(1);
                        prefetchOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.d
            public void a(String str, String str2, String str3, int i, int i2, int i3, String str4, int i4, int i5, int i6, int i7, PrefetchOptions prefetchOptions) throws RemoteException {
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
                    obtain.writeString(str4);
                    obtain.writeInt(i4);
                    obtain.writeInt(i5);
                    obtain.writeInt(i6);
                    obtain.writeInt(i7);
                    if (prefetchOptions != null) {
                        obtain.writeInt(1);
                        prefetchOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.d
            public boolean a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory");
                    obtain.writeString(str);
                    boolean z = false;
                    this.a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory");
        }

        public static d a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory");
            if (queryLocalInterface != null && (queryLocalInterface instanceof d)) {
                return (d) queryLocalInterface;
            }
            return new C0098a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            PrefetchOptions prefetchOptions;
            PrefetchOptions prefetchOptions2;
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory");
                        IBinder a = a(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(a);
                        return true;
                    case 2:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory");
                        IBinder a2 = a();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(a2);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory");
                        String readString = parcel.readString();
                        String readString2 = parcel.readString();
                        String readString3 = parcel.readString();
                        int readInt = parcel.readInt();
                        int readInt2 = parcel.readInt();
                        int readInt3 = parcel.readInt();
                        String readString4 = parcel.readString();
                        int readInt4 = parcel.readInt();
                        int readInt5 = parcel.readInt();
                        int readInt6 = parcel.readInt();
                        int readInt7 = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            prefetchOptions = PrefetchOptions.CREATOR.createFromParcel(parcel);
                        } else {
                            prefetchOptions = null;
                        }
                        a(readString, readString2, readString3, readInt, readInt2, readInt3, readString4, readInt4, readInt5, readInt6, readInt7, prefetchOptions);
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory");
                        a(a.AbstractBinderC0094a.a(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory");
                        boolean a3 = a(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(a3 ? 1 : 0);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory");
                        boolean b = b(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(b ? 1 : 0);
                        return true;
                    case 7:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory");
                        String readString5 = parcel.readString();
                        int readInt8 = parcel.readInt();
                        long readLong = parcel.readLong();
                        String readString6 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            prefetchOptions2 = PrefetchOptions.CREATOR.createFromParcel(parcel);
                        } else {
                            prefetchOptions2 = null;
                        }
                        a(readString5, readInt8, readLong, readString6, prefetchOptions2);
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory");
                        b(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory");
                        long b2 = b();
                        parcel2.writeNoException();
                        parcel2.writeLong(b2);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString("com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory");
            return true;
        }
    }
}
