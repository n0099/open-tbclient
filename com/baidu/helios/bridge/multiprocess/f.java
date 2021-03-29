package com.baidu.helios.bridge.multiprocess;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes2.dex */
public interface f extends IInterface {

    /* loaded from: classes2.dex */
    public static abstract class a extends Binder implements f {

        /* renamed from: a  reason: collision with root package name */
        public static final int f6204a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final int f6205b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final String f6206c = "com.baidu.helios.bridge.multiprocess.OnGetResultRemoteCallback";

        /* renamed from: com.baidu.helios.bridge.multiprocess.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0087a implements f {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f6207a;

            public C0087a(IBinder iBinder) {
                this.f6207a = iBinder;
            }

            public String a() {
                return a.f6206c;
            }

            @Override // com.baidu.helios.bridge.multiprocess.f
            public void a(int i, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f6206c);
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f6207a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.helios.bridge.multiprocess.f
            public void a(String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f6206c);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f6207a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f6207a;
            }
        }

        public a() {
            attachInterface(this, f6206c);
        }

        public static f a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f6206c);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof f)) ? new C0087a(iBinder) : (f) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface(f6206c);
                a(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            } else if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(f6206c);
                return true;
            } else {
                parcel.enforceInterface(f6206c);
                a(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void a(int i, Bundle bundle);

    void a(String str, Bundle bundle);
}
