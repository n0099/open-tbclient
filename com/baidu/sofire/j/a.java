package com.baidu.sofire.j;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes2.dex */
public interface a extends IInterface {

    /* renamed from: com.baidu.sofire.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractBinderC0161a extends Binder implements a {

        /* renamed from: com.baidu.sofire.j.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0162a implements a {

            /* renamed from: a  reason: collision with root package name */
            public static a f11486a;

            /* renamed from: b  reason: collision with root package name */
            public IBinder f11487b;

            public C0162a(IBinder iBinder) {
                this.f11487b = iBinder;
            }

            @Override // com.baidu.sofire.j.a
            public final String a(String str, String str2, String str3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (this.f11487b.transact(1, obtain, obtain2, 0) || AbstractBinderC0161a.a() == null) {
                        obtain2.readException();
                        return obtain2.readString();
                    }
                    return AbstractBinderC0161a.a().a(str, str2, str3);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f11487b;
            }
        }

        public static a a() {
            return C0162a.f11486a;
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0162a(iBinder) : (a) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.heytap.openid.IOpenID");
                return true;
            }
            parcel.enforceInterface("com.heytap.openid.IOpenID");
            String a2 = a(parcel.readString(), parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(a2);
            return true;
        }
    }

    String a(String str, String str2, String str3);
}
