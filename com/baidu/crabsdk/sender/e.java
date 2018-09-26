package com.baidu.crabsdk.sender;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.crabsdk.b.o;
import com.baidu.mobstat.Config;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class e {
    private static SharedPreferences Vv;
    private static Context mContext;

    private static int Q(String str) {
        if (Vv != null) {
            return Vv.getInt(str, 0);
        }
        return 0;
    }

    public static void V() {
        a(true);
    }

    public static boolean Y() {
        int i;
        if (com.baidu.crabsdk.a.v == -1) {
            return true;
        }
        if (Vv == null || (i = Vv.getInt(com.baidu.crabsdk.c.c.qn() + "oneday_anr_count", -1)) <= com.baidu.crabsdk.a.v) {
            return com.baidu.crabsdk.a.A <= com.baidu.crabsdk.a.v;
        }
        com.baidu.crabsdk.c.a.cy("exceed daily anr quota " + i + "/" + com.baidu.crabsdk.a.v);
        return false;
    }

    public static void a(int i) {
        a(false);
        Calendar calendar = Calendar.getInstance();
        calendar.set(5, calendar.get(5) + i);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        long timeInMillis = calendar.getTimeInMillis();
        if (Vv != null) {
            com.baidu.crabsdk.c.c.a(Vv.edit().putLong("crash_switch_time", timeInMillis), true);
        }
    }

    public static void a(long j) {
        if (Vv != null) {
            com.baidu.crabsdk.c.c.a(Vv.edit().putLong("crash_upload_time_nowifi", j), true);
        }
    }

    private static void a(boolean z) {
        if (Vv != null) {
            com.baidu.crabsdk.c.c.a(Vv.edit().putBoolean("crash_switch", z), true);
        }
    }

    public static void aa() {
        if (com.baidu.crabsdk.a.u == -1) {
            return;
        }
        if (Vv != null) {
            int i = Vv.getInt(com.baidu.crabsdk.c.c.qn() + "oneday_crash_count", 0) + 1;
            com.baidu.crabsdk.c.a.cy("addCrashUploadCount todayCount: " + i);
            com.baidu.crabsdk.c.c.a(Vv.edit().putInt(com.baidu.crabsdk.c.c.qn() + "oneday_crash_count", i), true);
        }
        com.baidu.crabsdk.a.y++;
    }

    public static void ab() {
        if (com.baidu.crabsdk.a.v == -1) {
            return;
        }
        if (Vv != null) {
            int i = Vv.getInt(com.baidu.crabsdk.c.c.qn() + "oneday_anr_count", 0) + 1;
            com.baidu.crabsdk.c.a.cy("addAnrUploadCount todayCount: " + i);
            com.baidu.crabsdk.c.c.a(Vv.edit().putInt(com.baidu.crabsdk.c.c.qn() + "oneday_anr_count", i), true);
        }
        com.baidu.crabsdk.a.A++;
    }

    public static void ac() {
        com.baidu.crabsdk.c.a.cv("### addBlockUploadCount = " + com.baidu.crabsdk.a.w);
        if (com.baidu.crabsdk.a.w == -1) {
            return;
        }
        if (Vv != null) {
            int i = Vv.getInt(com.baidu.crabsdk.c.c.qn() + "oneday_block_count", 0) + 1;
            com.baidu.crabsdk.c.a.cv("addBlockUploadCount todayCount: " + i);
            com.baidu.crabsdk.c.c.a(Vv.edit().putInt(com.baidu.crabsdk.c.c.qn() + "oneday_block_count", i), false);
        }
        com.baidu.crabsdk.a.B++;
    }

    public static void b(String str, String str2) {
        SharedPreferences.Editor edit = Vv.edit();
        edit.putString(str, str2);
        com.baidu.crabsdk.c.c.a(edit, true);
        com.baidu.crabsdk.c.a.cx("(--#)  save RSA_AESkey when write  (--#)" + str);
    }

    public static void c(Throwable th) {
        String jSONArray;
        boolean z;
        boolean z2;
        int i = 0;
        if (com.baidu.crabsdk.a.t == -1 || Vv == null) {
            return;
        }
        String g = com.baidu.crabsdk.c.c.g(th);
        boolean z3 = true;
        for (String str : com.baidu.crabsdk.a.x.keySet()) {
            if (str.equals(g)) {
                com.baidu.crabsdk.a.x.put(str, Integer.valueOf(com.baidu.crabsdk.a.x.get(str).intValue() + 1));
                z2 = false;
            } else {
                z2 = z3;
            }
            z3 = z2;
        }
        if (z3) {
            com.baidu.crabsdk.a.x.put(g, 1);
        }
        String string = Vv.getString(com.baidu.crabsdk.c.c.qn() + "same_crash_oneday_count", null);
        try {
            if (TextUtils.isEmpty(string)) {
                JSONArray jSONArray2 = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("errorOriLine", g);
                jSONObject.put(Config.TRACE_VISIT_RECENT_COUNT, 1);
                jSONArray2.put(jSONObject);
                jSONArray = jSONArray2.toString();
            } else {
                JSONArray jSONArray3 = new JSONArray(string);
                boolean z4 = false;
                while (i < jSONArray3.length()) {
                    JSONObject jSONObject2 = (JSONObject) jSONArray3.get(i);
                    if (jSONObject2.getString("errorOriLine").equals(g)) {
                        jSONObject2.put(Config.TRACE_VISIT_RECENT_COUNT, jSONObject2.getInt(Config.TRACE_VISIT_RECENT_COUNT) + 1);
                        z = true;
                    } else {
                        z = z4;
                    }
                    i++;
                    z4 = z;
                }
                if (!z4) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("errorOriLine", g);
                    jSONObject3.put(Config.TRACE_VISIT_RECENT_COUNT, 1);
                    jSONArray3.put(jSONObject3);
                }
                jSONArray = jSONArray3.toString();
            }
            com.baidu.crabsdk.c.c.a(Vv.edit().putString(com.baidu.crabsdk.c.c.qn() + "same_crash_oneday_count", jSONArray), true);
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.cy("addSameCrashUploadCount exception " + com.baidu.crabsdk.c.c.f(e));
        }
    }

    public static void d(Context context) {
        if (mContext == null) {
            mContext = context;
            Vv = context.getSharedPreferences("crab_crash_switch", 0);
            if (com.baidu.crabsdk.a.t != -1 && Vv != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
                String[] strArr = new String[7];
                for (int i = 1; i < 8; i++) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.add(5, -i);
                    strArr[i - 1] = simpleDateFormat.format(calendar.getTime());
                }
                SharedPreferences.Editor edit = Vv.edit();
                for (int i2 = 0; i2 < 7; i2++) {
                    String str = strArr[i2];
                    edit.remove(str + "same_crash_oneday_count");
                    edit.remove(str + "oneday_crash_count");
                    edit.remove(str + "oneday_anr_count");
                }
                com.baidu.crabsdk.c.c.a(edit, true);
            }
            if (com.baidu.crabsdk.a.z != -1) {
                try {
                    String string = Vv.getString("constant_crash", null);
                    if (TextUtils.isEmpty(string) || new JSONObject(string).getInt(Config.TRACE_VISIT_RECENT_COUNT) < com.baidu.crabsdk.a.z || com.baidu.crabsdk.a.N == null) {
                        return;
                    }
                    SharedPreferences.Editor edit2 = Vv.edit();
                    edit2.remove("constant_crash");
                    if (edit2.commit()) {
                        com.baidu.crabsdk.a.N.onCrashExceedCallback();
                    }
                } catch (Exception e) {
                    com.baidu.crabsdk.c.a.cy("addConstantSameCrash exception " + com.baidu.crabsdk.c.c.f(e));
                }
            }
        }
    }

    public static boolean d(String str) {
        return Q(str) <= 2;
    }

    public static void e(String str) {
        int Q = Q(str);
        if (!com.baidu.crabsdk.a.D) {
            Q++;
        }
        if (Vv != null) {
            com.baidu.crabsdk.c.c.a(Vv.edit().putInt(str, Q), true);
        }
    }

    public static void f(String str) {
        if (Vv != null) {
            com.baidu.crabsdk.c.c.a(Vv.edit().remove(str), true);
        }
    }

    public static void h(String str) {
        String H = !TextUtils.isEmpty(com.baidu.crabsdk.a.o) ? com.baidu.crabsdk.a.o : o.H();
        SharedPreferences.Editor edit = Vv.edit();
        edit.putString(str, H);
        com.baidu.crabsdk.c.c.a(edit, true);
        com.baidu.crabsdk.c.a.cx("(--#)  fileName when write  (--#)" + str);
    }

    public static String i(String str) {
        String string = Vv.getString(str, "");
        com.baidu.crabsdk.c.a.cx("(--#) getRecordAppVN (--#) " + string);
        return string;
    }

    public static boolean i(Throwable th) {
        if (com.baidu.crabsdk.a.t == -1) {
            return true;
        }
        if (Vv != null) {
            String g = com.baidu.crabsdk.c.c.g(th);
            String string = Vv.getString(com.baidu.crabsdk.c.c.qn() + "same_crash_oneday_count", null);
            try {
                if (!TextUtils.isEmpty(string)) {
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                        if (jSONObject.getString("errorOriLine").equals(g) && jSONObject.getInt(Config.TRACE_VISIT_RECENT_COUNT) >= com.baidu.crabsdk.a.t) {
                            com.baidu.crabsdk.c.a.cx("canSameCrashUpload no");
                            return false;
                        }
                    }
                }
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.cy("canSameCrashUpload exception " + com.baidu.crabsdk.c.c.f(e));
            }
            for (String str : com.baidu.crabsdk.a.x.keySet()) {
                if (str.equals(g) && com.baidu.crabsdk.a.x.get(str).intValue() > com.baidu.crabsdk.a.t) {
                    com.baidu.crabsdk.c.a.cx("SharedPreferences ignore, but canSameCrashUpload no");
                    return false;
                }
            }
        }
        com.baidu.crabsdk.c.a.cx("canSameCrashUpload yes");
        return true;
    }

    public static void j(String str) {
        try {
            SharedPreferences.Editor edit = Vv.edit();
            edit.remove(str);
            com.baidu.crabsdk.c.c.a(edit, true);
            com.baidu.crabsdk.c.a.cx("(--#) deleteRecordAppVN (--#) " + str);
        } catch (Exception e) {
            e.printStackTrace();
            com.baidu.crabsdk.c.a.cy("delete local appVN error!");
        }
    }

    public static void j(Throwable th) {
        String jSONObject;
        if (com.baidu.crabsdk.a.z == -1 || Vv == null) {
            return;
        }
        String g = com.baidu.crabsdk.c.c.g(th);
        try {
            String string = Vv.getString("constant_crash", null);
            if (TextUtils.isEmpty(string)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("crash", g);
                jSONObject2.put(Config.TRACE_VISIT_RECENT_COUNT, 1);
                jSONObject = jSONObject2.toString();
            } else {
                JSONObject jSONObject3 = new JSONObject(string);
                if (g.equals(jSONObject3.getString("crash"))) {
                    jSONObject3.put(Config.TRACE_VISIT_RECENT_COUNT, jSONObject3.getInt(Config.TRACE_VISIT_RECENT_COUNT) + 1);
                } else {
                    jSONObject3.put("crash", g);
                    jSONObject3.put(Config.TRACE_VISIT_RECENT_COUNT, 1);
                }
                jSONObject = jSONObject3.toString();
            }
            com.baidu.crabsdk.c.a.cy("同一crash连续发生：" + jSONObject);
            com.baidu.crabsdk.c.c.a(Vv.edit().putString("constant_crash", jSONObject), true);
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.cy("addConstantSameCrash exception " + com.baidu.crabsdk.c.c.f(e));
        }
    }

    public static String k(String str) {
        String string = Vv.getString(str, "");
        com.baidu.crabsdk.c.a.cx("(--#) getRSA_AESkey (--#) " + string);
        return string;
    }

    public static void l(String str) {
        try {
            SharedPreferences.Editor edit = Vv.edit();
            edit.remove(str);
            com.baidu.crabsdk.c.c.a(edit, true);
            com.baidu.crabsdk.c.a.cx("(--#) deleteRSA_AESkey (--#) " + str);
        } catch (Exception e) {
            e.printStackTrace();
            com.baidu.crabsdk.c.a.cy("delete local key error!");
        }
    }

    public static boolean qs() {
        if (Vv != null ? Vv.getBoolean("crash_switch", true) : true) {
            com.baidu.crabsdk.c.a.cx("CrashSwitch yes");
            return true;
        }
        if (System.currentTimeMillis() > (Vv != null ? Vv.getLong("crash_switch_time", 0L) : 0L)) {
            com.baidu.crabsdk.c.a.cx("CrashSwitch yes");
            return true;
        }
        com.baidu.crabsdk.c.a.cx("CrashSwitch no");
        return false;
    }

    public static boolean qt() {
        long j = Vv != null ? Vv.getLong("crash_upload_time_nowifi", 0L) : 0L;
        if (j == 0) {
            a(System.currentTimeMillis());
            return false;
        } else if (System.currentTimeMillis() - j > 86400000) {
            a(0L);
            return true;
        } else {
            return false;
        }
    }

    public static boolean qu() {
        int i;
        if (com.baidu.crabsdk.a.u == -1) {
            return true;
        }
        if (Vv == null || (i = Vv.getInt(com.baidu.crabsdk.c.c.qn() + "oneday_crash_count", -1)) <= com.baidu.crabsdk.a.u) {
            return com.baidu.crabsdk.a.y <= com.baidu.crabsdk.a.u;
        }
        com.baidu.crabsdk.c.a.cy("exceed daily crash quota " + i + "/" + com.baidu.crabsdk.a.u);
        return false;
    }

    public static boolean qv() {
        int i;
        if (com.baidu.crabsdk.a.w == -1) {
            com.baidu.crabsdk.c.a.cv("canBlockUploadToday!");
            return true;
        } else if (Vv != null && (i = Vv.getInt(com.baidu.crabsdk.c.c.qn() + "oneday_block_count", -1)) > com.baidu.crabsdk.a.w) {
            com.baidu.crabsdk.c.a.cy("exceed daily block quota " + i + "/" + com.baidu.crabsdk.a.w);
            return false;
        } else if (com.baidu.crabsdk.a.B > com.baidu.crabsdk.a.w) {
            com.baidu.crabsdk.c.a.cy("exceed daily block limit! can not upload block today!!");
            return false;
        } else {
            com.baidu.crabsdk.c.a.cv("canBlockUploadToday!");
            return true;
        }
    }
}
