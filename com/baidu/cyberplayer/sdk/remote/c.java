package com.baidu.cyberplayer.sdk.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.Surface;
import com.baidu.cyberplayer.sdk.remote.e;
/* loaded from: classes3.dex */
public interface c extends IInterface {
    int a() throws RemoteException;

    void a(float f) throws RemoteException;

    void a(float f, float f2) throws RemoteException;

    void a(int i) throws RemoteException;

    void a(int i, int i2) throws RemoteException;

    void a(int i, int i2, long j, String str) throws RemoteException;

    void a(long j, int i) throws RemoteException;

    void a(Surface surface) throws RemoteException;

    void a(e eVar) throws RemoteException;

    void a(f fVar) throws RemoteException;

    void a(String str) throws RemoteException;

    void a(String str, String str2) throws RemoteException;

    void a(String str, boolean z) throws RemoteException;

    void a(boolean z) throws RemoteException;

    void b() throws RemoteException;

    void b(int i, int i2) throws RemoteException;

    void b(e eVar) throws RemoteException;

    void b(String str) throws RemoteException;

    void b(boolean z) throws RemoteException;

    void c() throws RemoteException;

    void c(boolean z) throws RemoteException;

    void d() throws RemoteException;

    void d(boolean z) throws RemoteException;

    void e() throws RemoteException;

    void f() throws RemoteException;

    int g() throws RemoteException;

    int h() throws RemoteException;

    boolean i() throws RemoteException;

    int j() throws RemoteException;

    int k() throws RemoteException;

    int l() throws RemoteException;

    void m() throws RemoteException;

    void n() throws RemoteException;

    boolean o() throws RemoteException;

    long p() throws RemoteException;

    long q() throws RemoteException;

    void r() throws RemoteException;

    String s() throws RemoteException;

    /* loaded from: classes3.dex */
    public static abstract class a extends Binder implements c {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        /* renamed from: com.baidu.cyberplayer.sdk.remote.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0097a implements c {
            public IBinder a;

            public C0097a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.baidu.cyberplayer.sdk.remote.c
            public void a(float f) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    obtain.writeFloat(f);
                    this.a.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.c
            public void b(e eVar) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    if (eVar != null) {
                        iBinder = eVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.a.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.c
            public void c(boolean z) throws RemoteException {
                int i;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    if (z) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.a.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.c
            public void d(boolean z) throws RemoteException {
                int i;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    if (z) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.a.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.c
            public int a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // com.baidu.cyberplayer.sdk.remote.c
            public void b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.c
            public void c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    this.a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.c
            public void d() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    this.a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.c
            public void e() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    this.a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.c
            public void f() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    this.a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.c
            public int g() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    this.a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.c
            public int h() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    this.a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.c
            public boolean i() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    boolean z = false;
                    this.a.transact(13, obtain, obtain2, 0);
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

            @Override // com.baidu.cyberplayer.sdk.remote.c
            public int j() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    this.a.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.c
            public int k() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    this.a.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.c
            public int l() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    this.a.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.c
            public void m() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    this.a.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.c
            public void n() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    this.a.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.c
            public boolean o() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    boolean z = false;
                    this.a.transact(21, obtain, obtain2, 0);
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

            @Override // com.baidu.cyberplayer.sdk.remote.c
            public long p() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    this.a.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.c
            public long q() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    this.a.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.c
            public void r() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    this.a.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.c
            public String s() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    this.a.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.c
            public void a(float f, float f2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    obtain.writeFloat(f);
                    obtain.writeFloat(f2);
                    this.a.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.c
            public void b(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.a.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.c
            public void a(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    obtain.writeInt(i);
                    this.a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.c
            public void b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    obtain.writeString(str);
                    this.a.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.c
            public void a(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.a.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.c
            public void a(int i, int i2, long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    this.a.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.c
            public void a(long j, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    obtain.writeLong(j);
                    obtain.writeInt(i);
                    this.a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.c
            public void a(Surface surface) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    if (surface != null) {
                        obtain.writeInt(1);
                        surface.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.c
            public void a(e eVar) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    if (eVar != null) {
                        iBinder = eVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.a.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.c
            public void b(boolean z) throws RemoteException {
                int i;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    if (z) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.a.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.c
            public void a(f fVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    if (fVar != null) {
                        obtain.writeInt(1);
                        fVar.writeToParcel(obtain, 0);
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

            @Override // com.baidu.cyberplayer.sdk.remote.c
            public void a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    obtain.writeString(str);
                    this.a.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.c
            public void a(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.a.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.c
            public void a(String str, boolean z) throws RemoteException {
                int i;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.a.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.c
            public void a(boolean z) throws RemoteException {
                int i;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    if (z) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
        }

        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
            if (queryLocalInterface != null && (queryLocalInterface instanceof c)) {
                return (c) queryLocalInterface;
            }
            return new C0097a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                Surface surface = null;
                f fVar = null;
                boolean z = false;
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        int a = a();
                        parcel2.writeNoException();
                        parcel2.writeInt(a);
                        return true;
                    case 2:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        if (parcel.readInt() != 0) {
                            surface = (Surface) Surface.CREATOR.createFromParcel(parcel);
                        }
                        a(surface);
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        if (parcel.readInt() != 0) {
                            fVar = f.CREATOR.createFromParcel(parcel);
                        }
                        a(fVar);
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        b();
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        c();
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        d();
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        e();
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        f();
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        a(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        a(z);
                        parcel2.writeNoException();
                        return true;
                    case 11:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        int g = g();
                        parcel2.writeNoException();
                        parcel2.writeInt(g);
                        return true;
                    case 12:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        int h = h();
                        parcel2.writeNoException();
                        parcel2.writeInt(h);
                        return true;
                    case 13:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        boolean i3 = i();
                        parcel2.writeNoException();
                        parcel2.writeInt(i3 ? 1 : 0);
                        return true;
                    case 14:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        a(parcel.readLong(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 15:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        int j = j();
                        parcel2.writeNoException();
                        parcel2.writeInt(j);
                        return true;
                    case 16:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        int k = k();
                        parcel2.writeNoException();
                        parcel2.writeInt(k);
                        return true;
                    case 17:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        int l = l();
                        parcel2.writeNoException();
                        parcel2.writeInt(l);
                        return true;
                    case 18:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        m();
                        parcel2.writeNoException();
                        return true;
                    case 19:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        n();
                        parcel2.writeNoException();
                        return true;
                    case 20:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        b(z);
                        parcel2.writeNoException();
                        return true;
                    case 21:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        boolean o = o();
                        parcel2.writeNoException();
                        parcel2.writeInt(o ? 1 : 0);
                        return true;
                    case 22:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        a(parcel.readFloat(), parcel.readFloat());
                        parcel2.writeNoException();
                        return true;
                    case 23:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        a(parcel.readFloat());
                        parcel2.writeNoException();
                        return true;
                    case 24:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        String readString = parcel.readString();
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        a(readString, z);
                        parcel2.writeNoException();
                        return true;
                    case 25:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        a(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 26:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        a(parcel.readInt(), parcel.readInt(), parcel.readLong(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 27:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        c(z);
                        parcel2.writeNoException();
                        return true;
                    case 28:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        long p = p();
                        parcel2.writeNoException();
                        parcel2.writeLong(p);
                        return true;
                    case 29:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        long q = q();
                        parcel2.writeNoException();
                        parcel2.writeLong(q);
                        return true;
                    case 30:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        d(z);
                        parcel2.writeNoException();
                        return true;
                    case 31:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        a(e.a.a(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 32:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        b(e.a.a(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 33:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        a(parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 34:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        a(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 35:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        b(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 36:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        b(parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 37:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        r();
                        parcel2.writeNoException();
                        return true;
                    case 38:
                        parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                        String s = s();
                        parcel2.writeNoException();
                        parcel2.writeString(s);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
            return true;
        }
    }
}
