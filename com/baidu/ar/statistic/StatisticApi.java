package com.baidu.ar.statistic;

import android.content.Context;
import android.os.HandlerThread;
import java.lang.reflect.Constructor;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class StatisticApi {
    public static g wU;
    public static f wV;

    public static f getPerformanceApi() {
        if (wV == null) {
            wV = new o();
        }
        return wV;
    }

    public static void init(Context context) {
        if (wU == null) {
            try {
                Constructor<?> a = com.baidu.ar.h.n.a("com.baidu.ar.statistic.StatisticApiImpl", Context.class, HandlerThread.class);
                if (a != null) {
                    wU = (g) com.baidu.ar.h.n.a(a, context, null);
                }
            } catch (Throwable th) {
                wU = null;
                com.baidu.ar.h.b.aS("Statistic init fail");
                th.printStackTrace();
            }
        }
        if (wV == null) {
            wV = new o();
        }
    }

    public static boolean isAllowPerformanceEvent(String str) {
        g gVar = wU;
        if (gVar != null) {
            return gVar.isAllowPerformanceEvent(str);
        }
        return true;
    }

    public static void onEvent(String str) {
        onEvent(str, "");
    }

    public static void onEvent(String str, String str2) {
        g gVar = wU;
        if (gVar != null) {
            gVar.onEvent(str, str2);
        }
    }

    public static void onEvent(String str, Map<String, String> map) {
        g gVar = wU;
        if (gVar != null) {
            gVar.onEvent(str, map);
        }
    }

    public static void onEventDebounce(String str, long j, String str2) {
        g gVar = wU;
        if (gVar != null) {
            gVar.onEventDebounce(str, j, str2);
        }
    }

    public static void onEventDebounce(String str, long j, Map<String, String> map) {
        g gVar = wU;
        if (gVar != null) {
            gVar.onEventDebounce(str, j, map);
        }
    }

    public static void onEventEnd(String str) {
        g gVar = wU;
        if (gVar != null) {
            gVar.onEventEnd(str);
        }
    }

    public static void onEventStart(String str) {
        g gVar = wU;
        if (gVar != null) {
            gVar.onEventStart(str);
        }
    }

    public static void onEventStatus(String str, String str2, boolean z) {
        g gVar = wU;
        if (gVar != null) {
            gVar.onEventStatus(str, str2, z);
        }
    }

    public static void onPerformance(String str, Map<String, String> map) {
        g gVar = wU;
        if (gVar != null) {
            gVar.onPerformance(str, map);
        }
    }

    public static void onPerformance(String str, JSONObject jSONObject) {
        g gVar = wU;
        if (gVar != null) {
            gVar.onPerformance(str, jSONObject);
        }
    }

    public static void pause() {
        g gVar = wU;
        if (gVar != null) {
            gVar.pause();
        }
    }

    public static void release() {
        wV = null;
        g gVar = wU;
        if (gVar != null) {
            gVar.release();
            wU = null;
        }
    }

    public static void resume() {
        g gVar = wU;
        if (gVar != null) {
            gVar.resume();
        }
    }

    public static void setPubParam(String str, String str2) {
        g gVar = wU;
        if (gVar != null) {
            gVar.setPubParam(str, str2);
        }
    }

    public static void setPubParams(Map<String, String> map) {
        g gVar = wU;
        if (gVar != null) {
            gVar.setPubParams(map);
        }
    }
}
