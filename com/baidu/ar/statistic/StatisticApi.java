package com.baidu.ar.statistic;

import android.content.Context;
import android.os.HandlerThread;
import java.lang.reflect.Constructor;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class StatisticApi {
    private static g wU;
    private static f wV;

    public static f getPerformanceApi() {
        if (wV == null) {
            wV = new o();
        }
        return wV;
    }

    public static void init(Context context) {
        if (wU == null) {
            try {
                Constructor<?> a2 = com.baidu.ar.h.n.a("com.baidu.ar.statistic.StatisticApiImpl", Context.class, HandlerThread.class);
                if (a2 != null) {
                    wU = (g) com.baidu.ar.h.n.a(a2, context, null);
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
        if (wU != null) {
            return wU.isAllowPerformanceEvent(str);
        }
        return true;
    }

    public static void onEvent(String str) {
        onEvent(str, "");
    }

    public static void onEvent(String str, String str2) {
        if (wU != null) {
            wU.onEvent(str, str2);
        }
    }

    public static void onEvent(String str, Map<String, String> map) {
        if (wU != null) {
            wU.onEvent(str, map);
        }
    }

    public static void onEventDebounce(String str, long j, String str2) {
        if (wU != null) {
            wU.onEventDebounce(str, j, str2);
        }
    }

    public static void onEventDebounce(String str, long j, Map<String, String> map) {
        if (wU != null) {
            wU.onEventDebounce(str, j, map);
        }
    }

    public static void onEventEnd(String str) {
        if (wU != null) {
            wU.onEventEnd(str);
        }
    }

    public static void onEventStart(String str) {
        if (wU != null) {
            wU.onEventStart(str);
        }
    }

    public static void onEventStatus(String str, String str2, boolean z) {
        if (wU != null) {
            wU.onEventStatus(str, str2, z);
        }
    }

    public static void onPerformance(String str, Map<String, String> map) {
        if (wU != null) {
            wU.onPerformance(str, map);
        }
    }

    public static void onPerformance(String str, JSONObject jSONObject) {
        if (wU != null) {
            wU.onPerformance(str, jSONObject);
        }
    }

    public static void pause() {
        if (wU != null) {
            wU.pause();
        }
    }

    public static void release() {
        wV = null;
        if (wU != null) {
            wU.release();
            wU = null;
        }
    }

    public static void resume() {
        if (wU != null) {
            wU.resume();
        }
    }

    public static void setPubParam(String str, String str2) {
        if (wU != null) {
            wU.setPubParam(str, str2);
        }
    }

    public static void setPubParams(Map<String, String> map) {
        if (wU != null) {
            wU.setPubParams(map);
        }
    }
}
