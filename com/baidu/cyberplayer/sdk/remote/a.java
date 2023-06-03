package com.baidu.cyberplayer.sdk.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes3.dex */
public interface a extends IInterface {
    void a(String str, boolean z, int i, String str2) throws RemoteException;

    /* renamed from: com.baidu.cyberplayer.sdk.remote.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static abstract class AbstractBinderC0094a extends Binder implements a {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        /* renamed from: com.baidu.cyberplayer.sdk.remote.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0095a implements a {
            public IBinder a;

            public C0095a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.baidu.cyberplayer.sdk.remote.a
            public void a(String str, boolean z, int i, String str2) throws RemoteException {
                int i2;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.baidu.cyberplayer.sdk.remote.IPrefetchListener");
                    obtain.writeString(str);
                    if (z) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    this.a.transact(1, obtain, obtain2, 0);
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
        }

        public AbstractBinderC0094a() {
            attachInterface(this, "com.baidu.cyberplayer.sdk.remote.IPrefetchListener");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.baidu.cyberplayer.sdk.remote.IPrefetchListener");
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C0095a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            boolean z;
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.baidu.cyberplayer.sdk.remote.IPrefetchListener");
                return true;
            }
            parcel.enforceInterface("com.baidu.cyberplayer.sdk.remote.IPrefetchListener");
            String readString = parcel.readString();
            if (parcel.readInt() != 0) {
                z = true;
            } else {
                z = false;
            }
            a(readString, z, parcel.readInt(), parcel.readString());
            parcel2.writeNoException();
            return true;
        }
    }
}
