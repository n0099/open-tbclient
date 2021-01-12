package com.baidu.swan.apps.x;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.swan.menu.g;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    private static boolean DEBUG = b.DEBUG;

    public static void a(final Context context, final SwanAppActionBar swanAppActionBar, final String str) {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.x.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.b(context, swanAppActionBar, str);
            }
        }, "getRefreshTips", 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, final SwanAppActionBar swanAppActionBar, String str) {
        final JSONObject ab = com.baidu.swan.apps.t.a.axi().ab(context, str);
        if (ab != null && swanAppActionBar != null) {
            d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.x.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.a(swanAppActionBar, a.bs(ab));
                }
            });
        }
    }

    public static void a(SwanAppActionBar swanAppActionBar, int i) {
        if (DEBUG) {
            Log.i("messageRefresh", "update_red_dots:" + i);
        }
        if (swanAppActionBar != null) {
            swanAppActionBar.setRightRedDotVisibility(i > 0);
        }
    }

    public static void a(final Context context, final g gVar, final String str) {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.x.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.b(context, gVar, str);
            }
        }, "getMenuToolRefreshTips", 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, final g gVar, String str) {
        JSONObject ab = com.baidu.swan.apps.t.a.axi().ab(context, str);
        if (ab != null && gVar != null) {
            bs(ab);
            final JSONArray optJSONArray = ab.optJSONArray("un_read_list");
            d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.x.a.4
                @Override // java.lang.Runnable
                public void run() {
                    int length = optJSONArray.length();
                    if (optJSONArray != null && length != 0) {
                        for (int i = 0; i < length; i++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                gVar.cM(optJSONObject);
                                a.bt(optJSONObject);
                            }
                        }
                        gVar.bbp();
                    }
                }
            });
        }
    }

    public static boolean gf(boolean z) {
        if (e.aIs() == null) {
            return false;
        }
        e aIs = e.aIs();
        PMSAppInfo ayS = e.aIs().aIv().ayS();
        if (aIs.aIK() || ayS == null || TextUtils.isEmpty(ayS.paNumber)) {
            return false;
        }
        if (z) {
            return true;
        }
        return aIs.aIJ().c("key_unread_counts_message", 0).intValue() <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int bs(JSONObject jSONObject) {
        if (jSONObject == null) {
            return 0;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("un_read_list");
        int length = optJSONArray.length();
        if (optJSONArray == null || length == 0) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            int optInt = optJSONObject.optInt("pa_type");
            if (optInt == 7) {
                i += optJSONObject.optInt("pa_unread_sums");
            }
            if (ak.aNX() && (optInt == 27 || optInt == 17)) {
                i += optJSONObject.optInt("pa_unread_sums");
            }
        }
        if (i == 0) {
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                int optInt2 = optJSONObject2.optInt("pa_type");
                if (optInt2 == 888 || optInt2 == 666 || optInt2 == 999) {
                    i += optJSONObject2.optInt("pa_unread_sums");
                }
            }
        }
        if (e.aIs() != null) {
            e.aIs().aIJ().b("key_unread_counts_message", Integer.valueOf(i));
            return i;
        }
        return i;
    }

    public static void aBY() {
        if (e.aIs() != null) {
            e.aIs().aIJ().b("key_unread_counts_message", (Integer) 0);
        }
    }

    public static void bt(JSONObject jSONObject) {
        if (jSONObject != null && Long.valueOf(jSONObject.optLong("pa_unread_sums")).longValue() > 0) {
            String str = "";
            switch (jSONObject.optInt("pa_type")) {
                case 7:
                    str = "customerService";
                    break;
                case 666:
                    str = "notice";
                    break;
                case 888:
                    str = PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE;
                    break;
                case 999:
                    str = "message";
                    break;
            }
            if (!TextUtils.isEmpty(str)) {
                com.baidu.swan.apps.menu.a.U(str, "1", "show");
            }
        }
    }
}
