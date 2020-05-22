package com.baidu.cyberplayer.sdk.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public interface d extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements d {

        /* renamed from: com.baidu.cyberplayer.sdk.remote.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0113a implements d {
            private IBinder a;

            C0113a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.baidu.cyberplayer.sdk.remote.d
            public void a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener");
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.d
            public void a(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener");
                    obtain.writeInt(i);
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.d
            public void a(int i, int i2, int i3, int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    this.a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.d
            public void a(String str, List<String> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener");
                    obtain.writeString(str);
                    obtain.writeStringList(list);
                    this.a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    obtain2.readStringList(list);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.d
            public boolean a(int i, int i2, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    this.a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
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
            public void b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener");
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.d
            public boolean b(int i, int i2, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    this.a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.d
            public void c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener");
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener");
        }

        public static d a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof d)) ? new C0113a(iBinder) : (d) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener");
                    a();
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener");
                    b();
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener");
                    a(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener");
                    c();
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener");
                    a(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener");
                    boolean a = a(parcel.readInt(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(a ? 1 : 0);
                    return true;
                case 7:
                    parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener");
                    boolean b = b(parcel.readInt(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(b ? 1 : 0);
                    return true;
                case 8:
                    parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener");
                    String readString = parcel.readString();
                    ArrayList<String> createStringArrayList = parcel.createStringArrayList();
                    a(readString, createStringArrayList);
                    parcel2.writeNoException();
                    parcel2.writeStringList(createStringArrayList);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a() throws RemoteException;

    void a(int i) throws RemoteException;

    void a(int i, int i2, int i3, int i4) throws RemoteException;

    void a(String str, List<String> list) throws RemoteException;

    boolean a(int i, int i2, String str) throws RemoteException;

    void b() throws RemoteException;

    boolean b(int i, int i2, String str) throws RemoteException;

    void c() throws RemoteException;
}
