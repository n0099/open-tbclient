package com.baidu.ar.statistic;

import android.content.Context;
import android.os.HandlerThread;
import java.lang.reflect.Constructor;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public final class StatisticApi {
    private static g wg;
    private static f wh;

    public static f getPerformanceApi() {
        if (wh == null) {
            wh = new o();
        }
        return wh;
    }

    public static void init(Context context) {
        if (wg == null) {
            try {
                Constructor<?> a2 = com.baidu.ar.g.n.a("com.baidu.ar.statistic.StatisticApiImpl", Context.class, HandlerThread.class);
                if (a2 != null) {
                    wg = (g) com.baidu.ar.g.n.a(a2, context, null);
                }
            } catch (Throwable th) {
                wg = null;
                com.baidu.ar.g.b.aP("Statistic init fail");
                th.printStackTrace();
            }
        }
        if (wh == null) {
            wh = new o();
        }
    }

    public static boolean isAllowPerformanceEvent(String str) {
        if (wg != null) {
            return wg.isAllowPerformanceEvent(str);
        }
        return true;
    }

    public static void onEvent(String str) {
        onEvent(str, "");
    }

    public static void onEvent(String str, String str2) {
        if (wg != null) {
            wg.onEvent(str, str2);
        }
    }

    public static void onEvent(String str, Map<String, String> map) {
        if (wg != null) {
            wg.onEvent(str, map);
        }
    }

    public static void onEventDebounce(String str, long j, String str2) {
        if (wg != null) {
            wg.onEventDebounce(str, j, str2);
        }
    }

    public static void onEventDebounce(String str, long j, Map<String, String> map) {
        if (wg != null) {
            wg.onEventDebounce(str, j, map);
        }
    }

    public static void onEventEnd(String str) {
        if (wg != null) {
            wg.onEventEnd(str);
        }
    }

    public static void onEventStart(String str) {
        if (wg != null) {
            wg.onEventStart(str);
        }
    }

    public static void onEventStatus(String str, String str2, boolean z) {
        if (wg != null) {
            wg.onEventStatus(str, str2, z);
        }
    }

    public static void onPerformance(String str, Map<String, String> map) {
        if (wg != null) {
            wg.onPerformance(str, map);
        }
    }

    public static void onPerformance(String str, JSONObject jSONObject) {
        if (wg != null) {
            wg.onPerformance(str, jSONObject);
        }
    }

    public static void pause() {
        if (wg != null) {
            wg.pause();
        }
    }

    public static void release() {
        wh = null;
        if (wg != null) {
            wg.release();
            wg = null;
        }
    }

    public static void resume() {
        if (wg != null) {
            wg.resume();
        }
    }

    public static void setPubParam(String str, String str2) {
        if (wg != null) {
            wg.setPubParam(str, str2);
        }
    }

    public static void setPubParams(Map<String, String> map) {
        if (wg != null) {
            wg.setPubParams(map);
        }
    }
}
