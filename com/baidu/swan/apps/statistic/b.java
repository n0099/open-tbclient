package com.baidu.swan.apps.statistic;

import android.support.annotation.NonNull;
import com.baidu.swan.ubc.Flow;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
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
    public static a rz(String str) {
        return new a(com.baidu.swan.ubc.e.xB(str));
    }

    public static void a(@NonNull a aVar, String str, String str2) {
        Flow aCY = aVar.aCY();
        if (aCY != null) {
            aCY.addEvent(str, str2);
        }
    }

    public static void a(@NonNull a aVar, String str, String str2, long j) {
        Flow aCY = aVar.aCY();
        if (aCY != null) {
            aCY.addEvent(str, str2, j);
        }
    }

    public static void b(@NonNull a aVar) {
        Flow aCY = aVar.aCY();
        if (aCY != null) {
            aCY.cancel();
        }
    }

    public static void c(@NonNull a aVar) {
        Flow aCY = aVar.aCY();
        if (aCY != null) {
            aCY.end();
        }
    }

    public static void a(@NonNull a aVar, String str) {
        Flow aCY = aVar.aCY();
        if (aCY != null) {
            aCY.setValueWithDuration(str);
        }
    }
}
