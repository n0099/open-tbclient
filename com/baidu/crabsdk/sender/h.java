package com.baidu.crabsdk.sender;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class h {
    private static SharedPreferences JH;
    private static Context mContext;

    public static void V() {
        a(true);
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
        if (JH != null) {
            com.baidu.crabsdk.c.c.a(JH.edit().putLong("crash_switch_time", timeInMillis), true);
        }
    }

    public static void a(long j) {
        if (JH != null) {
            com.baidu.crabsdk.c.c.a(JH.edit().putLong("crash_upload_time_nowifi", j), true);
        }
    }

    private static void a(boolean z) {
        if (JH != null) {
            com.baidu.crabsdk.c.c.a(JH.edit().putBoolean("crash_switch", z), true);
        }
    }

    public static void aa() {
        if (com.baidu.crabsdk.a.u == -1) {
            return;
        }
        if (JH != null) {
            int i = JH.getInt(com.baidu.crabsdk.c.c.mt() + "oneday_crash_count", 0) + 1;
            com.baidu.crabsdk.c.a.w("addCrashUploadCount todayCount: " + i);
            com.baidu.crabsdk.c.c.a(JH.edit().putInt(com.baidu.crabsdk.c.c.mt() + "oneday_crash_count", i), true);
        }
        com.baidu.crabsdk.a.y++;
    }

    public static void ab() {
        if (com.baidu.crabsdk.a.v == -1) {
            return;
        }
        if (JH != null) {
            int i = JH.getInt(com.baidu.crabsdk.c.c.mt() + "oneday_anr_count", 0) + 1;
            com.baidu.crabsdk.c.a.w("addAnrUploadCount todayCount: " + i);
            com.baidu.crabsdk.c.c.a(JH.edit().putInt(com.baidu.crabsdk.c.c.mt() + "oneday_anr_count", i), true);
        }
        com.baidu.crabsdk.a.A++;
    }

    public static void b(String str, String str2) {
        SharedPreferences.Editor edit = JH.edit();
        edit.putString(str, str2);
        com.baidu.crabsdk.c.c.a(edit, true);
        com.baidu.crabsdk.c.a.v("Encrypted key is: " + str2 + "; filename is: " + str);
    }

    private static int bE(String str) {
        if (JH != null) {
            return JH.getInt(str, 0);
        }
        return 0;
    }

    public static String bF(String str) {
        String string = JH.getString(str, "");
        com.baidu.crabsdk.c.a.v("Get record appVN is: " + string);
        return string;
    }

    public static String bG(String str) {
        String string = JH.getString("key_" + str, "");
        if (TextUtils.isEmpty(string)) {
            com.baidu.crabsdk.c.a.bw("Not found the relative value. Key is: " + str);
            string = "NoEncrypt_" + com.baidu.crabsdk.c.d.c(com.baidu.crabsdk.a.d, str);
        }
        com.baidu.crabsdk.c.a.v("Decrypted key is: " + string + "; filename is: " + str);
        return string;
    }

    public static void c(Throwable th) {
        String jSONArray;
        boolean z;
        boolean z2;
        int i = 0;
        if (com.baidu.crabsdk.a.t == -1 || JH == null) {
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
        String string = JH.getString(com.baidu.crabsdk.c.c.mt() + "same_crash_oneday_count", null);
        try {
            if (TextUtils.isEmpty(string)) {
                JSONArray jSONArray2 = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("errorOriLine", g);
                jSONObject.put("count", 1);
                jSONArray2.put(jSONObject);
                jSONArray = jSONArray2.toString();
            } else {
                JSONArray jSONArray3 = new JSONArray(string);
                boolean z4 = false;
                while (i < jSONArray3.length()) {
                    JSONObject jSONObject2 = (JSONObject) jSONArray3.get(i);
                    if (jSONObject2.getString("errorOriLine").equals(g)) {
                        jSONObject2.put("count", jSONObject2.getInt("count") + 1);
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
                    jSONObject3.put("count", 1);
                    jSONArray3.put(jSONObject3);
                }
                jSONArray = jSONArray3.toString();
            }
            com.baidu.crabsdk.c.c.a(JH.edit().putString(com.baidu.crabsdk.c.c.mt() + "same_crash_oneday_count", jSONArray), true);
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.w("addSameCrashUploadCount exception " + com.baidu.crabsdk.c.c.f(e));
        }
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            JH = context.getSharedPreferences("crab_crash_switch", 0);
            if (com.baidu.crabsdk.a.t != -1 && JH != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
                String[] strArr = new String[7];
                for (int i = 1; i < 8; i++) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.add(5, -i);
                    strArr[i - 1] = simpleDateFormat.format(calendar.getTime());
                }
                SharedPreferences.Editor edit = JH.edit();
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
                    String string = JH.getString("constant_crash", null);
                    if (TextUtils.isEmpty(string) || new JSONObject(string).getInt("count") < com.baidu.crabsdk.a.z || com.baidu.crabsdk.a.O == null) {
                        return;
                    }
                    SharedPreferences.Editor edit2 = JH.edit();
                    edit2.remove("constant_crash");
                    if (edit2.commit()) {
                        com.baidu.crabsdk.a.O.onCrashExceedCallback();
                    }
                } catch (Exception e) {
                    com.baidu.crabsdk.c.a.w("addConstantSameCrash exception " + com.baidu.crabsdk.c.c.f(e));
                }
            }
        }
    }

    public static boolean h(String str) {
        return bE(str) <= 2;
    }

    public static void i(String str) {
        int bE = bE(str);
        if (!com.baidu.crabsdk.a.D) {
            bE++;
        }
        if (JH != null) {
            com.baidu.crabsdk.c.c.a(JH.edit().putInt(str, bE), true);
        }
    }

    public static boolean i(Throwable th) {
        if (com.baidu.crabsdk.a.t == -1) {
            return true;
        }
        if (JH != null) {
            String g = com.baidu.crabsdk.c.c.g(th);
            String string = JH.getString(com.baidu.crabsdk.c.c.mt() + "same_crash_oneday_count", null);
            try {
                if (!TextUtils.isEmpty(string)) {
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                        if (jSONObject.getString("errorOriLine").equals(g) && jSONObject.getInt("count") >= com.baidu.crabsdk.a.t) {
                            com.baidu.crabsdk.c.a.v("canSameCrashUpload no");
                            return false;
                        }
                    }
                }
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.w("canSameCrashUpload exception " + com.baidu.crabsdk.c.c.f(e));
            }
            for (String str : com.baidu.crabsdk.a.x.keySet()) {
                if (str.equals(g) && com.baidu.crabsdk.a.x.get(str).intValue() > com.baidu.crabsdk.a.t) {
                    com.baidu.crabsdk.c.a.v("SharedPreferences ignore, but canSameCrashUpload no");
                    return false;
                }
            }
        }
        com.baidu.crabsdk.c.a.v("canSameCrashUpload yes");
        return true;
    }

    public static void j(String str) {
        if (JH != null) {
            com.baidu.crabsdk.c.c.a(JH.edit().remove(str), true);
        }
    }

    public static void j(Throwable th) {
        String jSONObject;
        if (com.baidu.crabsdk.a.z == -1 || JH == null) {
            return;
        }
        String g = com.baidu.crabsdk.c.c.g(th);
        try {
            String string = JH.getString("constant_crash", null);
            if (TextUtils.isEmpty(string)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("crash", g);
                jSONObject2.put("count", 1);
                jSONObject = jSONObject2.toString();
            } else {
                JSONObject jSONObject3 = new JSONObject(string);
                if (g.equals(jSONObject3.getString("crash"))) {
                    jSONObject3.put("count", jSONObject3.getInt("count") + 1);
                } else {
                    jSONObject3.put("crash", g);
                    jSONObject3.put("count", 1);
                }
                jSONObject = jSONObject3.toString();
            }
            com.baidu.crabsdk.c.a.w("同一crash连续发生：" + jSONObject);
            com.baidu.crabsdk.c.c.a(JH.edit().putString("constant_crash", jSONObject), true);
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.w("addConstantSameCrash exception " + com.baidu.crabsdk.c.c.f(e));
        }
    }

    public static void l(String str) {
        String H = !TextUtils.isEmpty(com.baidu.crabsdk.a.o) ? com.baidu.crabsdk.a.o : com.baidu.crabsdk.b.o.H();
        SharedPreferences.Editor edit = JH.edit();
        edit.putString(str, H);
        com.baidu.crabsdk.c.c.a(edit, true);
        com.baidu.crabsdk.c.a.v("FileName when write is: " + str);
    }

    public static boolean mA() {
        long j = JH != null ? JH.getLong("crash_upload_time_nowifi", 0L) : 0L;
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

    public static boolean mB() {
        int i;
        if (com.baidu.crabsdk.a.u == -1) {
            return true;
        }
        if (JH == null || (i = JH.getInt(com.baidu.crabsdk.c.c.mt() + "oneday_crash_count", -1)) <= com.baidu.crabsdk.a.u) {
            return com.baidu.crabsdk.a.y <= com.baidu.crabsdk.a.u;
        }
        com.baidu.crabsdk.c.a.w("exceed daily crash quota " + i + "/" + com.baidu.crabsdk.a.u);
        return false;
    }

    public static boolean mC() {
        int i;
        if (com.baidu.crabsdk.a.v == -1) {
            return true;
        }
        if (JH == null || (i = JH.getInt(com.baidu.crabsdk.c.c.mt() + "oneday_anr_count", -1)) <= com.baidu.crabsdk.a.v) {
            return com.baidu.crabsdk.a.A <= com.baidu.crabsdk.a.v;
        }
        com.baidu.crabsdk.c.a.w("exceed daily anr quota " + i + "/" + com.baidu.crabsdk.a.v);
        return false;
    }

    public static boolean mD() {
        int i;
        if (com.baidu.crabsdk.a.w == -1) {
            com.baidu.crabsdk.c.a.bu("canBlockUploadToday!");
            return true;
        } else if (JH != null && (i = JH.getInt(com.baidu.crabsdk.c.c.mt() + "oneday_block_count", -1)) > com.baidu.crabsdk.a.w) {
            com.baidu.crabsdk.c.a.w("exceed daily block quota " + i + "/" + com.baidu.crabsdk.a.w);
            return false;
        } else if (com.baidu.crabsdk.a.B > com.baidu.crabsdk.a.w) {
            com.baidu.crabsdk.c.a.w("exceed daily block limit! can not upload block today!!");
            return false;
        } else {
            com.baidu.crabsdk.c.a.bu("canBlockUploadToday!");
            return true;
        }
    }

    public static void mE() {
        com.baidu.crabsdk.c.a.bu("### addBlockUploadCount = " + com.baidu.crabsdk.a.w);
        if (com.baidu.crabsdk.a.w == -1) {
            return;
        }
        if (JH != null) {
            int i = JH.getInt(com.baidu.crabsdk.c.c.mt() + "oneday_block_count", 0) + 1;
            com.baidu.crabsdk.c.a.bu("addBlockUploadCount todayCount: " + i);
            com.baidu.crabsdk.c.c.a(JH.edit().putInt(com.baidu.crabsdk.c.c.mt() + "oneday_block_count", i), false);
        }
        com.baidu.crabsdk.a.B++;
    }

    public static boolean mz() {
        if (JH != null ? JH.getBoolean("crash_switch", true) : true) {
            com.baidu.crabsdk.c.a.v("CrashSwitch yes");
            return true;
        }
        if (System.currentTimeMillis() > (JH != null ? JH.getLong("crash_switch_time", 0L) : 0L)) {
            com.baidu.crabsdk.c.a.v("CrashSwitch yes");
            return true;
        }
        com.baidu.crabsdk.c.a.v("CrashSwitch no");
        return false;
    }

    public static void n(String str) {
        try {
            SharedPreferences.Editor edit = JH.edit();
            edit.remove(str);
            com.baidu.crabsdk.c.c.a(edit, true);
            com.baidu.crabsdk.c.a.v("delete local appVN: " + str);
        } catch (Exception e) {
            e.printStackTrace();
            com.baidu.crabsdk.c.a.w("delete local appVN error!");
        }
    }

    public static void p(String str) {
        try {
            SharedPreferences.Editor edit = JH.edit();
            edit.remove(str);
            com.baidu.crabsdk.c.c.a(edit, true);
            com.baidu.crabsdk.c.a.v("delete local key: " + str);
        } catch (Exception e) {
            e.printStackTrace();
            com.baidu.crabsdk.c.a.w("delete local key error!");
        }
    }
}
