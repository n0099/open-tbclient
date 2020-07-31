package com.baidu.crabsdk.sender;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public final class h {
    private static SharedPreferences amq;
    private static Context mContext;

    public static void a(int i) {
        a(false);
        Calendar calendar = Calendar.getInstance();
        calendar.set(5, calendar.get(5) + i);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        long timeInMillis = calendar.getTimeInMillis();
        if (amq != null) {
            com.baidu.crabsdk.c.c.a(amq.edit().putLong("crash_switch_time", timeInMillis), true);
        }
    }

    public static void a(long j) {
        if (amq != null) {
            com.baidu.crabsdk.c.c.a(amq.edit().putLong("crash_upload_time_nowifi", j), true);
        }
    }

    private static void a(boolean z) {
        if (amq != null) {
            com.baidu.crabsdk.c.c.a(amq.edit().putBoolean("crash_switch", z), true);
        }
    }

    public static void aa() {
        a(true);
    }

    public static boolean ab() {
        long j = amq != null ? amq.getLong("crash_upload_time_nowifi", 0L) : 0L;
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

    public static boolean ac() {
        int i;
        if (com.baidu.crabsdk.a.u == -1) {
            return true;
        }
        if (amq == null || (i = amq.getInt(com.baidu.crabsdk.c.c.ak() + "oneday_crash_count", -1)) <= com.baidu.crabsdk.a.u) {
            return com.baidu.crabsdk.a.y <= com.baidu.crabsdk.a.u;
        }
        com.baidu.crabsdk.c.a.w("exceed daily crash quota " + i + "/" + com.baidu.crabsdk.a.u);
        return false;
    }

    public static void af() {
        if (com.baidu.crabsdk.a.u == -1) {
            return;
        }
        if (amq != null) {
            int i = amq.getInt(com.baidu.crabsdk.c.c.ak() + "oneday_crash_count", 0) + 1;
            com.baidu.crabsdk.c.a.w("addCrashUploadCount todayCount: " + i);
            com.baidu.crabsdk.c.c.a(amq.edit().putInt(com.baidu.crabsdk.c.c.ak() + "oneday_crash_count", i), true);
        }
        com.baidu.crabsdk.a.y++;
    }

    public static void ag() {
        if (com.baidu.crabsdk.a.v == -1) {
            return;
        }
        if (amq != null) {
            int i = amq.getInt(com.baidu.crabsdk.c.c.ak() + "oneday_anr_count", 0) + 1;
            com.baidu.crabsdk.c.a.w("addAnrUploadCount todayCount: " + i);
            com.baidu.crabsdk.c.c.a(amq.edit().putInt(com.baidu.crabsdk.c.c.ak() + "oneday_anr_count", i), true);
        }
        com.baidu.crabsdk.a.A++;
    }

    public static void ah() {
        com.baidu.crabsdk.c.a.dh("### addBlockUploadCount = " + com.baidu.crabsdk.a.w);
        if (com.baidu.crabsdk.a.w == -1) {
            return;
        }
        if (amq != null) {
            int i = amq.getInt(com.baidu.crabsdk.c.c.ak() + "oneday_block_count", 0) + 1;
            com.baidu.crabsdk.c.a.dh("addBlockUploadCount todayCount: " + i);
            com.baidu.crabsdk.c.c.a(amq.edit().putInt(com.baidu.crabsdk.c.c.ak() + "oneday_block_count", i), false);
        }
        com.baidu.crabsdk.a.B++;
    }

    public static void b(String str, String str2) {
        SharedPreferences.Editor edit = amq.edit();
        edit.putString(str, str2);
        com.baidu.crabsdk.c.c.a(edit, true);
        com.baidu.crabsdk.c.a.v("Encrypted key is: " + str2 + "; filename is: " + str);
    }

    public static void c(Throwable th) {
        String jSONArray;
        boolean z;
        boolean z2;
        int i = 0;
        if (com.baidu.crabsdk.a.t == -1 || amq == null) {
            return;
        }
        String i2 = com.baidu.crabsdk.c.c.i(th);
        boolean z3 = true;
        for (String str : com.baidu.crabsdk.a.x.keySet()) {
            if (str.equals(i2)) {
                com.baidu.crabsdk.a.x.put(str, Integer.valueOf(com.baidu.crabsdk.a.x.get(str).intValue() + 1));
                z2 = false;
            } else {
                z2 = z3;
            }
            z3 = z2;
        }
        if (z3) {
            com.baidu.crabsdk.a.x.put(i2, 1);
        }
        String string = amq.getString(com.baidu.crabsdk.c.c.ak() + "same_crash_oneday_count", null);
        try {
            if (TextUtils.isEmpty(string)) {
                JSONArray jSONArray2 = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("errorOriLine", i2);
                jSONObject.put("count", 1);
                jSONArray2.put(jSONObject);
                jSONArray = jSONArray2.toString();
            } else {
                JSONArray jSONArray3 = new JSONArray(string);
                boolean z4 = false;
                while (i < jSONArray3.length()) {
                    JSONObject jSONObject2 = (JSONObject) jSONArray3.get(i);
                    if (jSONObject2.getString("errorOriLine").equals(i2)) {
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
                    jSONObject3.put("errorOriLine", i2);
                    jSONObject3.put("count", 1);
                    jSONArray3.put(jSONObject3);
                }
                jSONArray = jSONArray3.toString();
            }
            com.baidu.crabsdk.c.c.a(amq.edit().putString(com.baidu.crabsdk.c.c.ak() + "same_crash_oneday_count", jSONArray), true);
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.w("addSameCrashUploadCount exception " + com.baidu.crabsdk.c.c.h(e));
        }
    }

    public static boolean dK(String str) {
        return dL(str) <= 2;
    }

    private static int dL(String str) {
        if (amq != null) {
            return amq.getInt(str, 0);
        }
        return 0;
    }

    public static String dt(String str) {
        String string = amq.getString(str, "");
        com.baidu.crabsdk.c.a.v("Get record appVN is: " + string);
        return string;
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            amq = context.getSharedPreferences("crab_crash_switch", 0);
            if (com.baidu.crabsdk.a.t != -1 && amq != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
                String[] strArr = new String[7];
                for (int i = 1; i < 8; i++) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.add(5, -i);
                    strArr[i - 1] = simpleDateFormat.format(calendar.getTime());
                }
                SharedPreferences.Editor edit = amq.edit();
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
                    String string = amq.getString("constant_crash", null);
                    if (TextUtils.isEmpty(string) || new JSONObject(string).getInt("count") < com.baidu.crabsdk.a.z || com.baidu.crabsdk.a.Q == null) {
                        return;
                    }
                    SharedPreferences.Editor edit2 = amq.edit();
                    edit2.remove("constant_crash");
                    if (edit2.commit()) {
                        com.baidu.crabsdk.a.Q.onCrashExceedCallback();
                    }
                } catch (Exception e) {
                    com.baidu.crabsdk.c.a.w("addConstantSameCrash exception " + com.baidu.crabsdk.c.c.h(e));
                }
            }
        }
    }

    public static void j(String str) {
        int dL = dL(str);
        if (!com.baidu.crabsdk.a.D) {
            dL++;
        }
        if (amq != null) {
            com.baidu.crabsdk.c.c.a(amq.edit().putInt(str, dL), true);
        }
    }

    public static void k(String str) {
        if (amq != null) {
            com.baidu.crabsdk.c.c.a(amq.edit().remove(str), true);
        }
    }

    public static boolean l(Throwable th) {
        if (com.baidu.crabsdk.a.t == -1) {
            return true;
        }
        if (amq != null) {
            String i = com.baidu.crabsdk.c.c.i(th);
            String string = amq.getString(com.baidu.crabsdk.c.c.ak() + "same_crash_oneday_count", null);
            try {
                if (!TextUtils.isEmpty(string)) {
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject = (JSONObject) jSONArray.get(i2);
                        if (jSONObject.getString("errorOriLine").equals(i) && jSONObject.getInt("count") >= com.baidu.crabsdk.a.t) {
                            com.baidu.crabsdk.c.a.v("canSameCrashUpload no");
                            return false;
                        }
                    }
                }
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.w("canSameCrashUpload exception " + com.baidu.crabsdk.c.c.h(e));
            }
            for (String str : com.baidu.crabsdk.a.x.keySet()) {
                if (str.equals(i) && com.baidu.crabsdk.a.x.get(str).intValue() > com.baidu.crabsdk.a.t) {
                    com.baidu.crabsdk.c.a.v("SharedPreferences ignore, but canSameCrashUpload no");
                    return false;
                }
            }
        }
        com.baidu.crabsdk.c.a.v("canSameCrashUpload yes");
        return true;
    }

    public static void m(String str) {
        SharedPreferences.Editor edit = amq.edit();
        edit.putString(str, com.baidu.crabsdk.b.p.L());
        com.baidu.crabsdk.c.c.a(edit, true);
        com.baidu.crabsdk.c.a.v("FileName when write is: " + str);
    }

    public static void m(Throwable th) {
        String jSONObject;
        if (com.baidu.crabsdk.a.z == -1 || amq == null) {
            return;
        }
        String i = com.baidu.crabsdk.c.c.i(th);
        try {
            String string = amq.getString("constant_crash", null);
            if (TextUtils.isEmpty(string)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("crash", i);
                jSONObject2.put("count", 1);
                jSONObject = jSONObject2.toString();
            } else {
                JSONObject jSONObject3 = new JSONObject(string);
                if (i.equals(jSONObject3.getString("crash"))) {
                    jSONObject3.put("count", jSONObject3.getInt("count") + 1);
                } else {
                    jSONObject3.put("crash", i);
                    jSONObject3.put("count", 1);
                }
                jSONObject = jSONObject3.toString();
            }
            com.baidu.crabsdk.c.a.w("同一crash连续发生：" + jSONObject);
            com.baidu.crabsdk.c.c.a(amq.edit().putString("constant_crash", jSONObject), true);
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.w("addConstantSameCrash exception " + com.baidu.crabsdk.c.c.h(e));
        }
    }

    public static void o(String str) {
        try {
            SharedPreferences.Editor edit = amq.edit();
            edit.remove(str);
            com.baidu.crabsdk.c.c.a(edit, true);
            com.baidu.crabsdk.c.a.v("delete local appVN: " + str);
        } catch (Exception e) {
            e.printStackTrace();
            com.baidu.crabsdk.c.a.w("delete local appVN error!");
        }
    }

    public static String p(String str) {
        String string = amq.getString("key_" + str, "");
        if (TextUtils.isEmpty(string)) {
            com.baidu.crabsdk.c.a.di("Not found the relative value. Key is: " + str);
            string = "NoEncrypt_" + com.baidu.crabsdk.c.d.c(com.baidu.crabsdk.a.d, str);
        }
        com.baidu.crabsdk.c.a.v("Decrypted key is: " + string + "; filename is: " + str);
        return string;
    }

    public static void q(String str) {
        try {
            SharedPreferences.Editor edit = amq.edit();
            edit.remove(str);
            com.baidu.crabsdk.c.c.a(edit, true);
            com.baidu.crabsdk.c.a.v("delete local key: " + str);
        } catch (Exception e) {
            e.printStackTrace();
            com.baidu.crabsdk.c.a.w("delete local key error!");
        }
    }

    public static boolean tv() {
        if (amq != null ? amq.getBoolean("crash_switch", true) : true) {
            com.baidu.crabsdk.c.a.v("CrashSwitch yes");
            return true;
        }
        if (System.currentTimeMillis() > (amq != null ? amq.getLong("crash_switch_time", 0L) : 0L)) {
            com.baidu.crabsdk.c.a.v("CrashSwitch yes");
            return true;
        }
        com.baidu.crabsdk.c.a.v("CrashSwitch no");
        return false;
    }

    public static boolean tw() {
        int i;
        if (com.baidu.crabsdk.a.v == -1) {
            return true;
        }
        if (amq == null || (i = amq.getInt(com.baidu.crabsdk.c.c.ak() + "oneday_anr_count", -1)) <= com.baidu.crabsdk.a.v) {
            return com.baidu.crabsdk.a.A <= com.baidu.crabsdk.a.v;
        }
        com.baidu.crabsdk.c.a.w("exceed daily anr quota " + i + "/" + com.baidu.crabsdk.a.v);
        return false;
    }

    public static boolean tx() {
        int i;
        if (com.baidu.crabsdk.a.w == -1) {
            com.baidu.crabsdk.c.a.dh("canBlockUploadToday!");
            return true;
        } else if (amq != null && (i = amq.getInt(com.baidu.crabsdk.c.c.ak() + "oneday_block_count", -1)) > com.baidu.crabsdk.a.w) {
            com.baidu.crabsdk.c.a.w("exceed daily block quota " + i + "/" + com.baidu.crabsdk.a.w);
            return false;
        } else if (com.baidu.crabsdk.a.B > com.baidu.crabsdk.a.w) {
            com.baidu.crabsdk.c.a.w("exceed daily block limit! can not upload block today!!");
            return false;
        } else {
            com.baidu.crabsdk.c.a.dh("canBlockUploadToday!");
            return true;
        }
    }
}
