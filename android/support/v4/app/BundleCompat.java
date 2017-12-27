package android.support.v4.app;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
/* loaded from: classes2.dex */
public final class BundleCompat {
    private BundleCompat() {
    }

    public static IBinder getBinder(Bundle bundle, String str) {
        return Build.VERSION.SDK_INT >= 18 ? BundleCompatJellybeanMR2.getBinder(bundle, str) : BundleCompatGingerbread.getBinder(bundle, str);
    }

    public static void putBinder(Bundle bundle, String str, IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 18) {
            BundleCompatJellybeanMR2.putBinder(bundle, str, iBinder);
        } else {
            BundleCompatGingerbread.putBinder(bundle, str, iBinder);
        }
    }
}
