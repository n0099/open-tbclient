package com.baidu.sofire.l;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes12.dex */
public interface a extends IInterface {

    /* renamed from: com.baidu.sofire.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static abstract class AbstractBinderC0318a extends Binder implements a {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.sofire.l.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        public static class C0319a implements a {
            public static a a;
            private IBinder b;

            C0319a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.baidu.sofire.l.a
            public final String a(String str, String str2, String str3) {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (this.b.transact(1, obtain, obtain2, 0) || AbstractBinderC0318a.a() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = AbstractBinderC0318a.a().a(str, str2, str3);
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.b;
            }
        }

        public static a a() {
            return C0319a.a;
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0319a(iBinder) : (a) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.heytap.openid.IOpenID");
                    String a = a(parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(a);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.heytap.openid.IOpenID");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    String a(String str, String str2, String str3);
}
