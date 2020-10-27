package com.baidu.swan.apps.statistic;

import android.support.annotation.NonNull;
import com.baidu.swan.ubc.Flow;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    public static void onEvent(String str, JSONObject jSONObject) {
        com.baidu.swan.ubc.e.onEvent(str, jSONObject);
    }

    public static void e(String str, String str2, JSONObject jSONObject) {
        com.baidu.swan.ubc.e.onEvent(str2, jSONObject);
    }

    public static void onEvent(String str, String str2) {
        com.baidu.swan.ubc.e.onEvent(str, str2);
    }

    public static void onEvent(String str, Map<String, String> map) {
        com.baidu.swan.ubc.e.onEvent(str, map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a sF(String str) {
        return new a(com.baidu.swan.ubc.e.yG(str));
    }

    public static void a(@NonNull a aVar, String str, String str2) {
        Flow aHB = aVar.aHB();
        if (aHB != null) {
            aHB.addEvent(str, str2);
        }
    }

    public static void a(@NonNull a aVar, String str, String str2, long j) {
        Flow aHB = aVar.aHB();
        if (aHB != null) {
            aHB.addEvent(str, str2, j);
        }
    }

    public static void b(@NonNull a aVar) {
        Flow aHB = aVar.aHB();
        if (aHB != null) {
            aHB.cancel();
        }
    }

    public static void c(@NonNull a aVar) {
        Flow aHB = aVar.aHB();
        if (aHB != null) {
            aHB.end();
        }
    }

    public static void a(@NonNull a aVar, String str) {
        Flow aHB = aVar.aHB();
        if (aHB != null) {
            aHB.setValueWithDuration(str);
        }
    }
}
