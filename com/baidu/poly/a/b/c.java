package com.baidu.poly.a.b;

import android.content.Context;
import android.content.pm.PackageManager;
import com.baidu.poly.util.g;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import com.heytap.mcssdk.mode.CommandMessage;
import java.util.Iterator;
import kotlin.jvm.internal.p;
import kotlin.text.l;
import org.apache.http.cookie.SM;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class c {
    public static final void a(com.baidu.poly.a.a.c cVar) {
        if (cVar != null) {
            cVar.g("channel", "cashiersdk");
            cVar.g(CashierData.DEVICE_TYPE, "ANDROID");
            cVar.g(CommandMessage.SDK_VERSION, "2.7.4");
            cVar.g("appVersion", afp());
            cVar.g("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        }
    }

    private static final String afp() {
        Context afL = g.afL();
        p.n(afL, "SdkRunTime.getAppContext()");
        PackageManager packageManager = afL.getPackageManager();
        try {
            Context afL2 = g.afL();
            p.n(afL2, "SdkRunTime.getAppContext()");
            String str = packageManager.getPackageInfo(afL2.getPackageName(), 0).versionName;
            p.n(str, "packageInfo.versionName");
            return str;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static final com.baidu.poly.a.a.b aw(JSONObject jSONObject) {
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                bVar.g(next, jSONObject.optString(next));
            }
        }
        return bVar;
    }

    public static final void a(com.baidu.poly.a.a.c cVar, String str) {
        boolean z = false;
        if (cVar != null) {
            if (!(str == null || l.isBlank(str))) {
                String str2 = cVar.get(SM.COOKIE);
                String str3 = "BDUSS=" + str;
                if (str2 == null || l.isBlank(str2)) {
                    z = true;
                }
                if (z) {
                    cVar.g(SM.COOKIE, str3);
                } else {
                    cVar.g(SM.COOKIE, str2 + "; " + str3);
                }
            }
        }
    }
}
