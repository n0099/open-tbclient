package com.baidu.nadcore.player.helper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.annotation.Nullable;
import com.baidu.tieba.wr0;
import java.util.Locale;
/* loaded from: classes2.dex */
public class NetUtils {

    /* loaded from: classes2.dex */
    public enum NetStatus {
        NET_DOWN,
        NET_WIFI,
        NET_MOBILE
    }

    static {
        NetStatus netStatus = NetStatus.NET_DOWN;
    }

    public static NetStatus a() {
        NetworkInfo b = b();
        if (b != null) {
            if (1 == b.getType()) {
                return NetStatus.NET_WIFI;
            }
            return NetStatus.NET_MOBILE;
        }
        return NetStatus.NET_DOWN;
    }

    @Nullable
    @SuppressLint({"MissingPermission"})
    public static NetworkInfo b() {
        ConnectivityManager connectivityManager;
        Context b = wr0.b();
        if (b == null || (connectivityManager = (ConnectivityManager) b.getSystemService("connectivity")) == null) {
            return null;
        }
        try {
            return connectivityManager.getActiveNetworkInfo();
        } catch (SecurityException unused) {
            return null;
        }
    }

    public static boolean c() {
        NetworkInfo b = b();
        if (b == null) {
            return false;
        }
        return "wifi".equals(b.getTypeName().toLowerCase(Locale.getDefault()));
    }
}
