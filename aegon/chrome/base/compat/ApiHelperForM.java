package aegon.chrome.base.compat;

import aegon.chrome.base.annotations.DoNotInline;
import android.annotation.TargetApi;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
@DoNotInline
@TargetApi(23)
/* loaded from: classes5.dex */
public final class ApiHelperForM {
    public static Network getActiveNetwork(ConnectivityManager connectivityManager) {
        try {
            return connectivityManager.getActiveNetwork();
        } catch (Exception e) {
            return null;
        }
    }

    public static long getLongVersionCode(PackageInfo packageInfo) {
        return packageInfo.getLongVersionCode();
    }

    public static String getPrivateDnsServerName(LinkProperties linkProperties) {
        return linkProperties.getPrivateDnsServerName();
    }

    public static boolean isPrivateDnsActive(LinkProperties linkProperties) {
        return linkProperties.isPrivateDnsActive();
    }
}
