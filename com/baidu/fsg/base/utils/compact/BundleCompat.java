package com.baidu.fsg.base.utils.compact;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import com.baidu.fsg.base.utils.reflect.MethodUtils;
/* loaded from: classes4.dex */
public class BundleCompat {
    public static IBinder getBinder(Bundle bundle, String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            return bundle.getBinder(str);
        }
        try {
            return (IBinder) MethodUtils.invokeMethod(bundle, "getIBinder", str);
        } catch (Exception e) {
            throw new RuntimeException("Bundle putIBinder exception:", e);
        }
    }

    public static void putBinder(Bundle bundle, String str, IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 18) {
            bundle.putBinder(str, iBinder);
            return;
        }
        try {
            MethodUtils.invokeMethod(bundle, "putIBinder", str, iBinder);
        } catch (Exception e) {
            throw new RuntimeException("Bundle putIBinder exception:", e);
        }
    }
}
