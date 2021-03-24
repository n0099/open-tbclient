package com.baidu.sso.n;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes3.dex */
public interface a extends IInterface {

    /* renamed from: com.baidu.sso.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static abstract class AbstractBinderC0163a extends Binder implements a {

        /* renamed from: com.baidu.sso.n.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0164a implements a {

            /* renamed from: a  reason: collision with root package name */
            public static a f11863a;

            /* renamed from: b  reason: collision with root package name */
            public IBinder f11864b;

            public C0164a(IBinder iBinder) {
                this.f11864b = iBinder;
            }

            @Override // com.baidu.sso.n.a
            public final String a(String str, String str2, String str3) {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (this.f11864b.transact(1, obtain, obtain2, 0) || AbstractBinderC0163a.a() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = AbstractBinderC0163a.a().a(str, str2, str3);
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f11864b;
            }
        }

        public static a a() {
            return C0164a.f11863a;
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0164a(iBinder) : (a) queryLocalInterface;
        }
    }

    String a(String str, String str2, String str3);
}
