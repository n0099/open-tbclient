package com.baidu.sso.m;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.uodis.opendevice.aidl.OpenDeviceIdentifierService;
/* loaded from: classes3.dex */
public interface d extends IInterface {

    /* loaded from: classes3.dex */
    public static abstract class a extends Binder implements d {

        /* renamed from: com.baidu.sso.m.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0162a implements d {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f11862a;

            public C0162a(IBinder iBinder) {
                this.f11862a = iBinder;
            }

            @Override // com.baidu.sso.m.d
            public final String a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(OpenDeviceIdentifierService.Stub.DESCRIPTOR);
                    this.f11862a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f11862a;
            }
        }

        public static d a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(OpenDeviceIdentifierService.Stub.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof d)) ? new C0162a(iBinder) : (d) queryLocalInterface;
        }
    }

    String a();
}
