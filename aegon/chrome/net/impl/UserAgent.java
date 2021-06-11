package aegon.chrome.net.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import java.util.Locale;
/* loaded from: classes.dex */
public final class UserAgent {
    public static final Object sLock = new Object();
    public static int sVersionCode;

    public static String from(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getPackageName());
        sb.append('/');
        sb.append(versionFromContext(context));
        sb.append(" (Linux; U; Android ");
        sb.append(Build.VERSION.RELEASE);
        sb.append("; ");
        sb.append(Locale.getDefault().toString());
        String str = Build.MODEL;
        if (str.length() > 0) {
            sb.append("; ");
            sb.append(str);
        }
        String str2 = Build.ID;
        if (str2.length() > 0) {
            sb.append("; Build/");
            sb.append(str2);
        }
        sb.append(";");
        sb.append(" Cronet/");
        sb.append("77.0.3865.0");
        sb.append(')');
        return sb.toString();
    }

    public static String getQuicUserAgentIdFrom(Context context) {
        return context.getPackageName() + " Cronet/77.0.3865.0";
    }

    public static int versionFromContext(Context context) {
        int i2;
        synchronized (sLock) {
            if (sVersionCode == 0) {
                try {
                    sVersionCode = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
                } catch (PackageManager.NameNotFoundException unused) {
                    throw new IllegalStateException("Cannot determine package version");
                }
            }
            i2 = sVersionCode;
        }
        return i2;
    }
}
