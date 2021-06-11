package com.baidu.sofire.j;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes2.dex */
public interface a extends IInterface {

    /* renamed from: com.baidu.sofire.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractBinderC0142a extends Binder implements a {

        /* renamed from: com.baidu.sofire.j.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0143a implements a {

            /* renamed from: a  reason: collision with root package name */
            public static a f10341a;

            /* renamed from: b  reason: collision with root package name */
            public IBinder f10342b;

            public C0143a(IBinder iBinder) {
                this.f10342b = iBinder;
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
                    if (this.f10342b.transact(1, obtain, obtain2, 0) || AbstractBinderC0142a.a() == null) {
                        obtain2.readException();
                        return obtain2.readString();
                    }
                    return AbstractBinderC0142a.a().a(str, str2, str3);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f10342b;
            }
        }

        public static a a() {
            return C0143a.f10341a;
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0143a(iBinder) : (a) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 != 1) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
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
