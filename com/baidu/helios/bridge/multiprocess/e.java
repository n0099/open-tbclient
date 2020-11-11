package com.baidu.helios.bridge.multiprocess;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.baidu.helios.bridge.multiprocess.f;
/* loaded from: classes17.dex */
public interface e extends IInterface {

    /* loaded from: classes17.dex */
    public static abstract class a extends Binder implements e {

        /* renamed from: a  reason: collision with root package name */
        private static final String f1792a = "com.baidu.helios.bridge.multiprocess.IMultiProcessBridge";
        static final int b = 1;
        static final int c = 2;
        static final int d = 3;

        /* renamed from: com.baidu.helios.bridge.multiprocess.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes17.dex */
        private static class C0146a implements e {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f1793a;

            C0146a(IBinder iBinder) {
                this.f1793a = iBinder;
            }

            @Override // com.baidu.helios.bridge.multiprocess.e
            public Bundle a(String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f1792a);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1793a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String a() {
                return a.f1792a;
            }

            @Override // com.baidu.helios.bridge.multiprocess.e
            public void a(String str, Bundle bundle, f fVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f1792a);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(fVar != null ? fVar.asBinder() : null);
                    this.f1793a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.helios.bridge.multiprocess.e
            public boolean a(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f1792a);
                    obtain.writeString(str);
                    this.f1793a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1793a;
            }
        }

        public a() {
            attachInterface(this, f1792a);
        }

        public static e a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f1792a);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof e)) ? new C0146a(iBinder) : (e) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface(f1792a);
                    Bundle a2 = a(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (a2 == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    a2.writeToParcel(parcel2, 1);
                    return true;
                case 2:
                    parcel.enforceInterface(f1792a);
                    a(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, f.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(f1792a);
                    boolean a3 = a(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(a3 ? 1 : 0);
                    return true;
                case 1598968902:
                    parcel2.writeString(f1792a);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    Bundle a(String str, Bundle bundle);

    void a(String str, Bundle bundle, f fVar);

    boolean a(String str);
}
