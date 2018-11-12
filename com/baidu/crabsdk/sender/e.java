package com.baidu.crabsdk.sender;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.crabsdk.b.o;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.ng.ai.apps.util.AiAppDateTimeUtil;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class e {
    private static SharedPreferences Yh;
    private static Context mContext;

    public static void W() {
        a(true);
    }

    public static boolean Y() {
        int i;
        if (com.baidu.crabsdk.a.u == -1) {
            return true;
        }
        if (Yh == null || (i = Yh.getInt(com.baidu.crabsdk.c.c.rt() + "oneday_crash_count", -1)) <= com.baidu.crabsdk.a.u) {
            return com.baidu.crabsdk.a.y <= com.baidu.crabsdk.a.u;
        }
        com.baidu.crabsdk.c.a.cJ("exceed daily crash quota " + i + "/" + com.baidu.crabsdk.a.u);
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
        if (Yh != null) {
            com.baidu.crabsdk.c.c.a(Yh.edit().putLong("crash_switch_time", timeInMillis), true);
        }
    }

    public static void a(long j) {
        if (Yh != null) {
            com.baidu.crabsdk.c.c.a(Yh.edit().putLong("crash_upload_time_nowifi", j), true);
        }
    }

    private static void a(boolean z) {
        if (Yh != null) {
            com.baidu.crabsdk.c.c.a(Yh.edit().putBoolean("crash_switch", z), true);
        }
    }

    public static void ab() {
        if (com.baidu.crabsdk.a.u == -1) {
            return;
        }
        if (Yh != null) {
            int i = Yh.getInt(com.baidu.crabsdk.c.c.rt() + "oneday_crash_count", 0) + 1;
            com.baidu.crabsdk.c.a.cJ("addCrashUploadCount todayCount: " + i);
            com.baidu.crabsdk.c.c.a(Yh.edit().putInt(com.baidu.crabsdk.c.c.rt() + "oneday_crash_count", i), true);
        }
        com.baidu.crabsdk.a.y++;
    }

    public static void ac() {
        if (com.baidu.crabsdk.a.v == -1) {
            return;
        }
        if (Yh != null) {
            int i = Yh.getInt(com.baidu.crabsdk.c.c.rt() + "oneday_anr_count", 0) + 1;
            com.baidu.crabsdk.c.a.cJ("addAnrUploadCount todayCount: " + i);
            com.baidu.crabsdk.c.c.a(Yh.edit().putInt(com.baidu.crabsdk.c.c.rt() + "oneday_anr_count", i), true);
        }
        com.baidu.crabsdk.a.A++;
    }

    public static void b(String str, String str2) {
        SharedPreferences.Editor edit = Yh.edit();
        edit.putString(str, str2);
        com.baidu.crabsdk.c.c.a(edit, true);
        com.baidu.crabsdk.c.a.cI("Encrypted key is: " + str2 + "; filename is: " + str);
    }

    public static void c(Throwable th) {
        String jSONArray;
        boolean z;
        boolean z2;
        int i = 0;
        if (com.baidu.crabsdk.a.t == -1 || Yh == null) {
            return;
        }
        String h = com.baidu.crabsdk.c.c.h(th);
        boolean z3 = true;
        for (String str : com.baidu.crabsdk.a.x.keySet()) {
            if (str.equals(h)) {
                com.baidu.crabsdk.a.x.put(str, Integer.valueOf(com.baidu.crabsdk.a.x.get(str).intValue() + 1));
                z2 = false;
            } else {
                z2 = z3;
            }
            z3 = z2;
        }
        if (z3) {
            com.baidu.crabsdk.a.x.put(h, 1);
        }
        String string = Yh.getString(com.baidu.crabsdk.c.c.rt() + "same_crash_oneday_count", null);
        try {
            if (TextUtils.isEmpty(string)) {
                JSONArray jSONArray2 = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("errorOriLine", h);
                jSONObject.put(Config.TRACE_VISIT_RECENT_COUNT, 1);
                jSONArray2.put(jSONObject);
                jSONArray = jSONArray2.toString();
            } else {
                JSONArray jSONArray3 = new JSONArray(string);
                boolean z4 = false;
                while (i < jSONArray3.length()) {
                    JSONObject jSONObject2 = (JSONObject) jSONArray3.get(i);
                    if (jSONObject2.getString("errorOriLine").equals(h)) {
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
                    jSONObject3.put("errorOriLine", h);
                    jSONObject3.put(Config.TRACE_VISIT_RECENT_COUNT, 1);
                    jSONArray3.put(jSONObject3);
                }
                jSONArray = jSONArray3.toString();
            }
            com.baidu.crabsdk.c.c.a(Yh.edit().putString(com.baidu.crabsdk.c.c.rt() + "same_crash_oneday_count", jSONArray), true);
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.cJ("addSameCrashUploadCount exception " + com.baidu.crabsdk.c.c.g(e));
        }
    }

    private static int cP(String str) {
        if (Yh != null) {
            return Yh.getInt(str, 0);
        }
        return 0;
    }

    public static void d(Context context) {
        if (mContext == null) {
            mContext = context;
            Yh = context.getSharedPreferences("crab_crash_switch", 0);
            if (com.baidu.crabsdk.a.t != -1 && Yh != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(AiAppDateTimeUtil.DAY_FORMAT);
                String[] strArr = new String[7];
                for (int i = 1; i < 8; i++) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.add(5, -i);
                    strArr[i - 1] = simpleDateFormat.format(calendar.getTime());
                }
                SharedPreferences.Editor edit = Yh.edit();
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
                    String string = Yh.getString("constant_crash", null);
                    if (TextUtils.isEmpty(string) || new JSONObject(string).getInt(Config.TRACE_VISIT_RECENT_COUNT) < com.baidu.crabsdk.a.z || com.baidu.crabsdk.a.O == null) {
                        return;
                    }
                    SharedPreferences.Editor edit2 = Yh.edit();
                    edit2.remove("constant_crash");
                    if (edit2.commit()) {
                        com.baidu.crabsdk.a.O.onCrashExceedCallback();
                    }
                } catch (Exception e) {
                    com.baidu.crabsdk.c.a.cJ("addConstantSameCrash exception " + com.baidu.crabsdk.c.c.g(e));
                }
            }
        }
    }

    public static boolean e(String str) {
        return cP(str) <= 2;
    }

    public static void f(String str) {
        int cP = cP(str);
        if (!com.baidu.crabsdk.a.D) {
            cP++;
        }
        if (Yh != null) {
            com.baidu.crabsdk.c.c.a(Yh.edit().putInt(str, cP), true);
        }
    }

    public static void g(String str) {
        if (Yh != null) {
            com.baidu.crabsdk.c.c.a(Yh.edit().remove(str), true);
        }
    }

    public static void i(String str) {
        String I = !TextUtils.isEmpty(com.baidu.crabsdk.a.o) ? com.baidu.crabsdk.a.o : o.I();
        SharedPreferences.Editor edit = Yh.edit();
        edit.putString(str, I);
        com.baidu.crabsdk.c.c.a(edit, true);
        com.baidu.crabsdk.c.a.cI("FileName when write is: " + str);
    }

    public static String j(String str) {
        String string = Yh.getString(str, "");
        com.baidu.crabsdk.c.a.cI("Get record appVN is: " + string);
        return string;
    }

    public static boolean j(Throwable th) {
        if (com.baidu.crabsdk.a.t == -1) {
            return true;
        }
        if (Yh != null) {
            String h = com.baidu.crabsdk.c.c.h(th);
            String string = Yh.getString(com.baidu.crabsdk.c.c.rt() + "same_crash_oneday_count", null);
            try {
                if (!TextUtils.isEmpty(string)) {
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                        if (jSONObject.getString("errorOriLine").equals(h) && jSONObject.getInt(Config.TRACE_VISIT_RECENT_COUNT) >= com.baidu.crabsdk.a.t) {
                            com.baidu.crabsdk.c.a.cI("canSameCrashUpload no");
                            return false;
                        }
                    }
                }
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.cJ("canSameCrashUpload exception " + com.baidu.crabsdk.c.c.g(e));
            }
            for (String str : com.baidu.crabsdk.a.x.keySet()) {
                if (str.equals(h) && com.baidu.crabsdk.a.x.get(str).intValue() > com.baidu.crabsdk.a.t) {
                    com.baidu.crabsdk.c.a.cI("SharedPreferences ignore, but canSameCrashUpload no");
                    return false;
                }
            }
        }
        com.baidu.crabsdk.c.a.cI("canSameCrashUpload yes");
        return true;
    }

    public static void k(String str) {
        try {
            SharedPreferences.Editor edit = Yh.edit();
            edit.remove(str);
            com.baidu.crabsdk.c.c.a(edit, true);
            com.baidu.crabsdk.c.a.cI("delete local appVN: " + str);
        } catch (Exception e) {
            e.printStackTrace();
            com.baidu.crabsdk.c.a.cJ("delete local appVN error!");
        }
    }

    public static void k(Throwable th) {
        String jSONObject;
        if (com.baidu.crabsdk.a.z == -1 || Yh == null) {
            return;
        }
        String h = com.baidu.crabsdk.c.c.h(th);
        try {
            String string = Yh.getString("constant_crash", null);
            if (TextUtils.isEmpty(string)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("crash", h);
                jSONObject2.put(Config.TRACE_VISIT_RECENT_COUNT, 1);
                jSONObject = jSONObject2.toString();
            } else {
                JSONObject jSONObject3 = new JSONObject(string);
                if (h.equals(jSONObject3.getString("crash"))) {
                    jSONObject3.put(Config.TRACE_VISIT_RECENT_COUNT, jSONObject3.getInt(Config.TRACE_VISIT_RECENT_COUNT) + 1);
                } else {
                    jSONObject3.put("crash", h);
                    jSONObject3.put(Config.TRACE_VISIT_RECENT_COUNT, 1);
                }
                jSONObject = jSONObject3.toString();
            }
            com.baidu.crabsdk.c.a.cJ("同一crash连续发生：" + jSONObject);
            com.baidu.crabsdk.c.c.a(Yh.edit().putString("constant_crash", jSONObject), true);
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.cJ("addConstantSameCrash exception " + com.baidu.crabsdk.c.c.g(e));
        }
    }

    public static String l(String str) {
        String string = Yh.getString("key_" + str, "");
        if (TextUtils.isEmpty(string)) {
            com.baidu.crabsdk.c.a.v("Not found the relative value. Key is: " + str);
            string = "NoEncrypt_" + com.baidu.crabsdk.c.d.c(com.baidu.crabsdk.a.d, str);
        }
        com.baidu.crabsdk.c.a.cI("Decrypted key is: " + string + "; filename is: " + str);
        return string;
    }

    public static void m(String str) {
        try {
            SharedPreferences.Editor edit = Yh.edit();
            edit.remove(str);
            com.baidu.crabsdk.c.c.a(edit, true);
            com.baidu.crabsdk.c.a.cI("delete local key: " + str);
        } catch (Exception e) {
            e.printStackTrace();
            com.baidu.crabsdk.c.a.cJ("delete local key error!");
        }
    }

    public static boolean rA() {
        int i;
        if (com.baidu.crabsdk.a.v == -1) {
            return true;
        }
        if (Yh == null || (i = Yh.getInt(com.baidu.crabsdk.c.c.rt() + "oneday_anr_count", -1)) <= com.baidu.crabsdk.a.v) {
            return com.baidu.crabsdk.a.A <= com.baidu.crabsdk.a.v;
        }
        com.baidu.crabsdk.c.a.cJ("exceed daily anr quota " + i + "/" + com.baidu.crabsdk.a.v);
        return false;
    }

    public static boolean rB() {
        int i;
        if (com.baidu.crabsdk.a.w == -1) {
            com.baidu.crabsdk.c.a.cG("canBlockUploadToday!");
            return true;
        } else if (Yh != null && (i = Yh.getInt(com.baidu.crabsdk.c.c.rt() + "oneday_block_count", -1)) > com.baidu.crabsdk.a.w) {
            com.baidu.crabsdk.c.a.cJ("exceed daily block quota " + i + "/" + com.baidu.crabsdk.a.w);
            return false;
        } else if (com.baidu.crabsdk.a.B > com.baidu.crabsdk.a.w) {
            com.baidu.crabsdk.c.a.cJ("exceed daily block limit! can not upload block today!!");
            return false;
        } else {
            com.baidu.crabsdk.c.a.cG("canBlockUploadToday!");
            return true;
        }
    }

    public static void rC() {
        com.baidu.crabsdk.c.a.cG("### addBlockUploadCount = " + com.baidu.crabsdk.a.w);
        if (com.baidu.crabsdk.a.w == -1) {
            return;
        }
        if (Yh != null) {
            int i = Yh.getInt(com.baidu.crabsdk.c.c.rt() + "oneday_block_count", 0) + 1;
            com.baidu.crabsdk.c.a.cG("addBlockUploadCount todayCount: " + i);
            com.baidu.crabsdk.c.c.a(Yh.edit().putInt(com.baidu.crabsdk.c.c.rt() + "oneday_block_count", i), false);
        }
        com.baidu.crabsdk.a.B++;
    }

    public static boolean ry() {
        if (Yh != null ? Yh.getBoolean("crash_switch", true) : true) {
            com.baidu.crabsdk.c.a.cI("CrashSwitch yes");
            return true;
        }
        if (System.currentTimeMillis() > (Yh != null ? Yh.getLong("crash_switch_time", 0L) : 0L)) {
            com.baidu.crabsdk.c.a.cI("CrashSwitch yes");
            return true;
        }
        com.baidu.crabsdk.c.a.cI("CrashSwitch no");
        return false;
    }

    public static boolean rz() {
        long j = Yh != null ? Yh.getLong("crash_upload_time_nowifi", 0L) : 0L;
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
}
