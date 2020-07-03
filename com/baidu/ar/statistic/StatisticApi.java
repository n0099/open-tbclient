package com.baidu.ar.statistic;

import android.content.Context;
import android.os.HandlerThread;
import java.lang.reflect.Constructor;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class StatisticApi {
    private static g vD;
    private static f vE;

    public static f getPerformanceApi() {
        if (vE == null) {
            vE = new o();
        }
        return vE;
    }

    public static void init(Context context) {
        if (vD == null) {
            try {
                Constructor<?> a = com.baidu.ar.f.l.a("com.baidu.ar.statistic.StatisticApiImpl", Context.class, HandlerThread.class);
                if (a != null) {
                    vD = (g) com.baidu.ar.f.l.a(a, context, null);
                }
            } catch (Throwable th) {
                vD = null;
                com.baidu.ar.f.b.aL("Statistic init fail");
                th.printStackTrace();
            }
        }
        if (vE == null) {
            vE = new o();
        }
    }

    public static boolean isAllowPerformanceEvent(String str) {
        if (vD != null) {
            return vD.isAllowPerformanceEvent(str);
        }
        return true;
    }

    public static void onEvent(String str) {
        onEvent(str, "");
    }

    public static void onEvent(String str, String str2) {
        if (vD != null) {
            vD.onEvent(str, str2);
        }
    }

    public static void onEvent(String str, Map<String, String> map) {
        if (vD != null) {
            vD.onEvent(str, map);
        }
    }

    public static void onEventDebounce(String str, long j, String str2) {
        if (vD != null) {
            vD.onEventDebounce(str, j, str2);
        }
    }

    public static void onEventDebounce(String str, long j, Map<String, String> map) {
        if (vD != null) {
            vD.onEventDebounce(str, j, map);
        }
    }

    public static void onEventEnd(String str) {
        if (vD != null) {
            vD.onEventEnd(str);
        }
    }

    public static void onEventStart(String str) {
        if (vD != null) {
            vD.onEventStart(str);
        }
    }

    public static void onEventStatus(String str, String str2, boolean z) {
        if (vD != null) {
            vD.onEventStatus(str, str2, z);
        }
    }

    public static void onPerformance(String str, Map<String, String> map) {
        if (vD != null) {
            vD.onPerformance(str, map);
        }
    }

    public static void onPerformance(String str, JSONObject jSONObject) {
        if (vD != null) {
            vD.onPerformance(str, jSONObject);
        }
    }

    public static void pause() {
        if (vD != null) {
            vD.pause();
        }
    }

    public static void release() {
        vE = null;
        if (vD != null) {
            vD.release();
            vD = null;
        }
    }

    public static void resume() {
        if (vD != null) {
            vD.resume();
        }
    }

    public static void setPubParam(String str, String str2) {
        if (vD != null) {
            vD.setPubParam(str, str2);
        }
    }

    public static void setPubParams(Map<String, String> map) {
        if (vD != null) {
            vD.setPubParams(map);
        }
    }
}
