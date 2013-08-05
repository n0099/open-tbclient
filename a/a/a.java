package a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
/* loaded from: classes.dex */
public abstract class a extends Binder implements b {
    public a() {
        attachInterface(this, "android.app.IProcessObserver");
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                parcel.enforceInterface("android.app.IProcessObserver");
                a(parcel.readInt(), parcel.readInt(), parcel.readInt() != 0);
                return true;
            case 2:
                parcel.enforceInterface("android.app.IProcessObserver");
                a(parcel.readInt(), parcel.readInt(), parcel.readInt());
                return true;
            case 3:
                parcel.enforceInterface("android.app.IProcessObserver");
                a(parcel.readInt(), parcel.readInt());
                return true;
            case 1598968902:
                parcel2.writeString("android.app.IProcessObserver");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
