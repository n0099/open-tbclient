package a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
/* loaded from: classes.dex */
public abstract class b extends Binder implements a {
    public b() {
        attachInterface(this, "android.app.IActivityWatcher");
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                parcel.enforceInterface("android.app.IActivityWatcher");
                a(parcel.readInt());
                return true;
            case 2:
                parcel.enforceInterface("android.app.IActivityWatcher");
                a(parcel.readString());
                return true;
            case 1598968902:
                parcel2.writeString("android.app.IActivityWatcher");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
