package android.content.pm;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes.dex */
public interface IPackageInstallObserver extends IInterface {

    /* loaded from: classes.dex */
    public abstract class Stub extends Binder implements IPackageInstallObserver {
        public static IPackageInstallObserver asInterface(IBinder iBinder) {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            return false;
        }
    }

    void packageInstalled(String str, int i);
}
