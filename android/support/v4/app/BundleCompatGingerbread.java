package android.support.v4.app;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
class BundleCompatGingerbread {
    private static Method sGetIBinderMethod;
    private static boolean sGetIBinderMethodFetched;
    private static Method sPutIBinderMethod;
    private static boolean sPutIBinderMethodFetched;

    public static IBinder getBinder(Bundle bundle, String str) {
        if (!sGetIBinderMethodFetched) {
            try {
                sGetIBinderMethod = Bundle.class.getMethod("getIBinder", String.class);
                sGetIBinderMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("BundleCompatGingerbread", "Failed to retrieve getIBinder method", e);
            }
            sGetIBinderMethodFetched = true;
        }
        if (sGetIBinderMethod != null) {
            try {
                return (IBinder) sGetIBinderMethod.invoke(bundle, str);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                Log.i("BundleCompatGingerbread", "Failed to invoke getIBinder via reflection", e2);
                sGetIBinderMethod = null;
            }
        }
        return null;
    }

    public static void putBinder(Bundle bundle, String str, IBinder iBinder) {
        if (!sPutIBinderMethodFetched) {
            try {
                sPutIBinderMethod = Bundle.class.getMethod("putIBinder", String.class, IBinder.class);
                sPutIBinderMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("BundleCompatGingerbread", "Failed to retrieve putIBinder method", e);
            }
            sPutIBinderMethodFetched = true;
        }
        if (sPutIBinderMethod != null) {
            try {
                sPutIBinderMethod.invoke(bundle, str, iBinder);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                Log.i("BundleCompatGingerbread", "Failed to invoke putIBinder via reflection", e2);
                sPutIBinderMethod = null;
            }
        }
    }
}
