package com.asus.msa.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes6.dex */
public interface a extends IInterface {

    /* renamed from: com.asus.msa.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static abstract class AbstractBinderC0012a extends Binder implements a {

        /* renamed from: com.asus.msa.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static class C0013a implements a {
            public IBinder a;

            public C0013a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.asus.msa.a.a
            public boolean a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    this.a.transact(1, obtain, obtain2, 0);
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

            @Override // com.asus.msa.a.a
            public String b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.asus.msa.a.a
            public String c() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.asus.msa.a.a
            public String d() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.asus.msa.a.a
            public String e() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    this.a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0013a(iBinder) : (a) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    boolean a = a();
                    parcel2.writeNoException();
                    parcel2.writeInt(a ? 1 : 0);
                    return true;
                case 2:
                    parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    String b = b();
                    parcel2.writeNoException();
                    parcel2.writeString(b);
                    return true;
                case 3:
                    parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    String c = c();
                    parcel2.writeNoException();
                    parcel2.writeString(c);
                    return true;
                case 4:
                    parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    String d = d();
                    parcel2.writeNoException();
                    parcel2.writeString(d);
                    return true;
                case 5:
                    parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    String e = e();
                    parcel2.writeNoException();
                    parcel2.writeString(e);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    boolean a();

    String b();

    String c();

    String d();

    String e();
}
