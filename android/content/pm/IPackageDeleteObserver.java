package android.content.pm;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes.dex */
public interface IPackageDeleteObserver extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IPackageDeleteObserver {
        public static IPackageDeleteObserver asInterface(IBinder iBinder) {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            return false;
        }
    }

    void packageDeleted(String str, int i) throws RemoteException;
}
