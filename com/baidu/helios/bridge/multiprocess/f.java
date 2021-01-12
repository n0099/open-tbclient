package com.baidu.helios.bridge.multiprocess;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes14.dex */
public interface f extends IInterface {

    /* loaded from: classes14.dex */
    public static abstract class a extends Binder implements f {

        /* renamed from: a  reason: collision with root package name */
        static final int f2412a = 1;

        /* renamed from: b  reason: collision with root package name */
        static final int f2413b = 2;
        private static final String c = "com.baidu.helios.bridge.multiprocess.OnGetResultRemoteCallback";

        /* renamed from: com.baidu.helios.bridge.multiprocess.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes14.dex */
        private static class C0127a implements f {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f2414a;

            C0127a(IBinder iBinder) {
                this.f2414a = iBinder;
            }

            public String a() {
                return a.c;
            }

            @Override // com.baidu.helios.bridge.multiprocess.f
            public void a(int i, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.c);
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2414a.transact(2, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken(a.c);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2414a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2414a;
            }
        }

        public a() {
            attachInterface(this, c);
        }

        public static f a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(c);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof f)) ? new C0127a(iBinder) : (f) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface(c);
                    a(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(c);
                    a(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString(c);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a(int i, Bundle bundle);

    void a(String str, Bundle bundle);
}
