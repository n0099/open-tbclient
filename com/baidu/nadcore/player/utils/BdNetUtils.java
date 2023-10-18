package com.baidu.nadcore.player.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.e01;
import com.baidu.tieba.pe0;
import java.util.Locale;
/* loaded from: classes3.dex */
public class BdNetUtils {

    /* loaded from: classes3.dex */
    public enum NetStatus {
        NET_DOWN,
        NET_WIFI,
        NET_MOBILE
    }

    public static boolean c() {
        return false;
    }

    static {
        NetStatus netStatus = NetStatus.NET_DOWN;
    }

    public static NetStatus a() {
        NetworkInfo b = b();
        if (b == null) {
            return NetStatus.NET_DOWN;
        }
        if (1 == b.getType()) {
            return NetStatus.NET_WIFI;
        }
        return NetStatus.NET_MOBILE;
    }

    @SuppressLint({"MissingPermission"})
    public static NetworkInfo b() {
        try {
            return ((ConnectivityManager) pe0.b().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean d() {
        NetworkInfo b = b();
        if (b == null) {
            return false;
        }
        return !"wifi".equals(b.getTypeName().toLowerCase(Locale.getDefault()));
    }

    public static boolean e() {
        if (b() == null) {
            return true;
        }
        return false;
    }

    public static boolean f() {
        if (b() != null) {
            return true;
        }
        return false;
    }

    public static boolean g() {
        NetworkInfo b = b();
        if (b == null) {
            return false;
        }
        return "wifi".equals(b.getTypeName().toLowerCase(Locale.getDefault()));
    }

    public static boolean h() {
        if (!c() && !g()) {
            return false;
        }
        return true;
    }

    public static void i(Context context, String str) {
        StringBuilder sb = new StringBuilder(context.getString(R.string.nad_player_message_network_3g));
        if (!TextUtils.isEmpty(str)) {
            sb.append("，\n");
            sb.append(context.getString(R.string.nad_video_net_tip_size_toast));
            sb.append(str);
            sb.append("MB");
        }
        e01.a().showToast(context, sb.toString());
    }
}
