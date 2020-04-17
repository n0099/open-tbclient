package com.baidu.ar.statistic;

import android.content.Context;
import android.os.HandlerThread;
import java.lang.reflect.Constructor;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class StatisticApi {
    private static g vd;
    private static f ve;

    public static f getPerformanceApi() {
        if (ve == null) {
            ve = new o();
        }
        return ve;
    }

    public static void init(Context context) {
        if (vd == null) {
            try {
                Constructor<?> a = com.baidu.ar.f.l.a("com.baidu.ar.statistic.StatisticApiImpl", Context.class, HandlerThread.class);
                if (a != null) {
                    vd = (g) com.baidu.ar.f.l.a(a, context, null);
                }
            } catch (Throwable th) {
                vd = null;
                com.baidu.ar.f.b.aK("Statistic init fail");
                th.printStackTrace();
            }
        }
        if (ve == null) {
            ve = new o();
        }
    }

    public static boolean isAllowPerformanceEvent(String str) {
        if (vd != null) {
            return vd.isAllowPerformanceEvent(str);
        }
        return true;
    }

    public static void onEvent(String str) {
        onEvent(str, "");
    }

    public static void onEvent(String str, String str2) {
        if (vd != null) {
            vd.onEvent(str, str2);
        }
    }

    public static void onEvent(String str, Map<String, String> map) {
        if (vd != null) {
            vd.onEvent(str, map);
        }
    }

    public static void onEventDebounce(String str, long j, String str2) {
        if (vd != null) {
            vd.onEventDebounce(str, j, str2);
        }
    }

    public static void onEventDebounce(String str, long j, Map<String, String> map) {
        if (vd != null) {
            vd.onEventDebounce(str, j, map);
        }
    }

    public static void onEventEnd(String str) {
        if (vd != null) {
            vd.onEventEnd(str);
        }
    }

    public static void onEventStart(String str) {
        if (vd != null) {
            vd.onEventStart(str);
        }
    }

    public static void onEventStatus(String str, String str2, boolean z) {
        if (vd != null) {
            vd.onEventStatus(str, str2, z);
        }
    }

    public static void onPerformance(String str, Map<String, String> map) {
        if (vd != null) {
            vd.onPerformance(str, map);
        }
    }

    public static void onPerformance(String str, JSONObject jSONObject) {
        if (vd != null) {
            vd.onPerformance(str, jSONObject);
        }
    }

    public static void pause() {
        if (vd != null) {
            vd.pause();
        }
    }

    public static void release() {
        ve = null;
        if (vd != null) {
            vd.release();
            vd = null;
        }
    }

    public static void resume() {
        if (vd != null) {
            vd.resume();
        }
    }

    public static void setPubParam(String str, String str2) {
        if (vd != null) {
            vd.setPubParam(str, str2);
        }
    }

    public static void setPubParams(Map<String, String> map) {
        if (vd != null) {
            vd.setPubParams(map);
        }
    }
}
