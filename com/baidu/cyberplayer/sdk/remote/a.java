package com.baidu.cyberplayer.sdk.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.Surface;
import com.baidu.cyberplayer.sdk.remote.c;
/* loaded from: classes.dex */
public interface a extends IInterface {

    /* renamed from: com.baidu.cyberplayer.sdk.remote.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC0049a extends Binder implements a {

        /* renamed from: com.baidu.cyberplayer.sdk.remote.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0050a implements a {
            private IBinder a;

            C0050a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.baidu.cyberplayer.sdk.remote.a
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

            @Override // com.baidu.cyberplayer.sdk.remote.a
            public void a(float f) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    obtain.writeFloat(f);
                    this.a.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.a
            public void a(float f, float f2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    obtain.writeFloat(f);
                    obtain.writeFloat(f2);
                    this.a.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.a
            public void a(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    obtain.writeInt(i);
                    this.a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.a
            public void a(int i, int i2, long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    this.a.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.a
            public void a(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    obtain.writeLong(j);
                    this.a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.a
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

            @Override // com.baidu.cyberplayer.sdk.remote.a
            public void a(c cVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    obtain.writeStrongBinder(cVar != null ? cVar.asBinder() : null);
                    this.a.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.a
            public void a(d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    if (dVar != null) {
                        obtain.writeInt(1);
                        dVar.writeToParcel(obtain, 0);
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

            @Override // com.baidu.cyberplayer.sdk.remote.a
            public void a(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.a.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.a
            public void a(String str, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    this.a.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.a
            public void a(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    obtain.writeInt(z ? 1 : 0);
                    this.a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // com.baidu.cyberplayer.sdk.remote.a
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

            @Override // com.baidu.cyberplayer.sdk.remote.a
            public void b(c cVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    obtain.writeStrongBinder(cVar != null ? cVar.asBinder() : null);
                    this.a.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.a
            public void b(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    obtain.writeInt(z ? 1 : 0);
                    this.a.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.a
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

            @Override // com.baidu.cyberplayer.sdk.remote.a
            public void c(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    obtain.writeInt(z ? 1 : 0);
                    this.a.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.a
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

            @Override // com.baidu.cyberplayer.sdk.remote.a
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

            @Override // com.baidu.cyberplayer.sdk.remote.a
            public int f() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    this.a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.a
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

            @Override // com.baidu.cyberplayer.sdk.remote.a
            public boolean h() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    this.a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.a
            public int i() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    this.a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.a
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

            @Override // com.baidu.cyberplayer.sdk.remote.a
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

            @Override // com.baidu.cyberplayer.sdk.remote.a
            public void l() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    this.a.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.a
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

            @Override // com.baidu.cyberplayer.sdk.remote.a
            public boolean n() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    this.a.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.a
            public long o() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    this.a.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.a
            public long p() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    this.a.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public AbstractBinderC0049a() {
            attachInterface(this, "com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0050a(iBinder) : (a) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    int a = a();
                    parcel2.writeNoException();
                    parcel2.writeInt(a);
                    return true;
                case 2:
                    parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    a(parcel.readInt() != 0 ? (Surface) Surface.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    a(parcel.readInt() != 0 ? d.CREATOR.createFromParcel(parcel) : null);
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
                    a(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    a(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    int f = f();
                    parcel2.writeNoException();
                    parcel2.writeInt(f);
                    return true;
                case 11:
                    parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    int g = g();
                    parcel2.writeNoException();
                    parcel2.writeInt(g);
                    return true;
                case 12:
                    parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    boolean h = h();
                    parcel2.writeNoException();
                    parcel2.writeInt(h ? 1 : 0);
                    return true;
                case 13:
                    parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    a(parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    int i3 = i();
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
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
                    l();
                    parcel2.writeNoException();
                    return true;
                case 18:
                    parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    m();
                    parcel2.writeNoException();
                    return true;
                case 19:
                    parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    b(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 20:
                    parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    boolean n = n();
                    parcel2.writeNoException();
                    parcel2.writeInt(n ? 1 : 0);
                    return true;
                case 21:
                    parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    a(parcel.readFloat(), parcel.readFloat());
                    parcel2.writeNoException();
                    return true;
                case 22:
                    parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    a(parcel.readFloat());
                    parcel2.writeNoException();
                    return true;
                case 23:
                    parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    a(parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 24:
                    parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    a(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 25:
                    parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    a(parcel.readInt(), parcel.readInt(), parcel.readLong(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 26:
                    parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    long o = o();
                    parcel2.writeNoException();
                    parcel2.writeLong(o);
                    return true;
                case 27:
                    parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    long p = p();
                    parcel2.writeNoException();
                    parcel2.writeLong(p);
                    return true;
                case 28:
                    parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    c(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 29:
                    parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    a(c.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 30:
                    parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    b(c.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.baidu.cyberplayer.sdk.remote.IRemotePlayer");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    int a() throws RemoteException;

    void a(float f) throws RemoteException;

    void a(float f, float f2) throws RemoteException;

    void a(int i) throws RemoteException;

    void a(int i, int i2, long j, String str) throws RemoteException;

    void a(long j) throws RemoteException;

    void a(Surface surface) throws RemoteException;

    void a(c cVar) throws RemoteException;

    void a(d dVar) throws RemoteException;

    void a(String str, String str2) throws RemoteException;

    void a(String str, boolean z) throws RemoteException;

    void a(boolean z) throws RemoteException;

    void b() throws RemoteException;

    void b(c cVar) throws RemoteException;

    void b(boolean z) throws RemoteException;

    void c() throws RemoteException;

    void c(boolean z) throws RemoteException;

    void d() throws RemoteException;

    void e() throws RemoteException;

    int f() throws RemoteException;

    int g() throws RemoteException;

    boolean h() throws RemoteException;

    int i() throws RemoteException;

    int j() throws RemoteException;

    int k() throws RemoteException;

    void l() throws RemoteException;

    void m() throws RemoteException;

    boolean n() throws RemoteException;

    long o() throws RemoteException;

    long p() throws RemoteException;
}
