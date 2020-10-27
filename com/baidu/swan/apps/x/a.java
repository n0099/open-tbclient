package com.baidu.swan.apps.x;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.swan.menu.h;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
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
        final JSONObject V = com.baidu.swan.apps.t.a.auK().V(context, str);
        if (V != null && swanAppActionBar != null) {
            d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.x.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.a(swanAppActionBar, a.bi(V));
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

    public static void a(final Context context, final h hVar, final String str) {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.x.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.b(context, hVar, str);
            }
        }, "getMenuToolRefreshTips", 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, final h hVar, String str) {
        JSONObject V = com.baidu.swan.apps.t.a.auK().V(context, str);
        if (V != null && hVar != null) {
            bi(V);
            final JSONArray optJSONArray = V.optJSONArray("un_read_list");
            d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.x.a.4
                @Override // java.lang.Runnable
                public void run() {
                    int length = optJSONArray.length();
                    if (optJSONArray != null && length != 0) {
                        for (int i = 0; i < length; i++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                hVar.cC(optJSONObject);
                                a.bj(optJSONObject);
                            }
                        }
                        hVar.aXR();
                    }
                }
            });
        }
    }

    public static boolean fz(boolean z) {
        if (e.aEV() == null) {
            return false;
        }
        e aEV = e.aEV();
        PMSAppInfo awt = e.aEV().aEY().awt();
        if (aEV.aFn() || awt == null || TextUtils.isEmpty(awt.paNumber)) {
            return false;
        }
        if (z) {
            return true;
        }
        return aEV.aFm().b("key_unread_counts_message", (Integer) 0).intValue() <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int bi(JSONObject jSONObject) {
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
            if (ak.aKB() && (optInt == 27 || optInt == 17)) {
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
        if (e.aEV() != null) {
            e.aEV().aFm().a("key_unread_counts_message", Integer.valueOf(i));
            return i;
        }
        return i;
    }

    public static void azx() {
        if (e.aEV() != null) {
            e.aEV().aFm().a("key_unread_counts_message", (Integer) 0);
        }
    }

    public static void bj(JSONObject jSONObject) {
        if (jSONObject != null && Long.valueOf(jSONObject.optLong("pa_unread_sums")).longValue() > 0) {
            String str = "";
            switch (jSONObject.optInt("pa_type")) {
                case 7:
                    str = "customerService";
                    break;
                case 666:
                    str = LogConfig.KEY_NOTICE;
                    break;
                case 888:
                    str = PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE;
                    break;
                case 999:
                    str = "message";
                    break;
            }
            if (!TextUtils.isEmpty(str)) {
                com.baidu.swan.apps.menu.a.P(str, "1", "show");
            }
        }
    }
}
