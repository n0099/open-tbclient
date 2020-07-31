package com.baidu.swan.apps.statistic;

import android.support.annotation.NonNull;
import com.baidu.swan.ubc.Flow;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
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
    public static a pg(String str) {
        return new a(com.baidu.swan.ubc.e.uW(str));
    }

    public static void a(@NonNull a aVar, String str, String str2) {
        Flow auf = aVar.auf();
        if (auf != null) {
            auf.addEvent(str, str2);
        }
    }

    public static void a(@NonNull a aVar, String str, String str2, long j) {
        Flow auf = aVar.auf();
        if (auf != null) {
            auf.addEvent(str, str2, j);
        }
    }

    public static void b(@NonNull a aVar) {
        Flow auf = aVar.auf();
        if (auf != null) {
            auf.cancel();
        }
    }

    public static void c(@NonNull a aVar) {
        Flow auf = aVar.auf();
        if (auf != null) {
            auf.end();
        }
    }

    public static void a(@NonNull a aVar, String str) {
        Flow auf = aVar.auf();
        if (auf != null) {
            auf.setValueWithDuration(str);
        }
    }
}
