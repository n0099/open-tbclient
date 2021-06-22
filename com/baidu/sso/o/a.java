package com.baidu.sso.o;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes2.dex */
public interface a extends IInterface {

    /* renamed from: com.baidu.sso.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractBinderC0151a extends Binder implements a {

        /* renamed from: com.baidu.sso.o.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0152a implements a {

            /* renamed from: a  reason: collision with root package name */
            public static a f10471a;

            /* renamed from: b  reason: collision with root package name */
            public IBinder f10472b;

            public C0152a(IBinder iBinder) {
                this.f10472b = iBinder;
            }

            public String a(String str, String str2, String str3) {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (this.f10472b.transact(1, obtain, obtain2, 0) || AbstractBinderC0151a.a() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = ((C0152a) AbstractBinderC0151a.a()).a(str, str2, str3);
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f10472b;
            }
        }

        public static a a() {
            return C0152a.f10471a;
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0152a(iBinder) : (a) queryLocalInterface;
        }
    }
}
