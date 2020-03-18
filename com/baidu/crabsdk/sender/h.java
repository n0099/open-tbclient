package com.baidu.crabsdk.sender;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.android.util.time.DateTimeUtil;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class h {
    private static SharedPreferences RW;
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
        if (RW != null) {
            com.baidu.crabsdk.c.c.a(RW.edit().putLong("crash_switch_time", timeInMillis), true);
        }
    }

    public static void a(long j) {
        if (RW != null) {
            com.baidu.crabsdk.c.c.a(RW.edit().putLong("crash_upload_time_nowifi", j), true);
        }
    }

    private static void a(boolean z) {
        if (RW != null) {
            com.baidu.crabsdk.c.c.a(RW.edit().putBoolean("crash_switch", z), true);
        }
    }

    public static void aa() {
        a(true);
    }

    public static void af() {
        if (com.baidu.crabsdk.a.u == -1) {
            return;
        }
        if (RW != null) {
            int i = RW.getInt(com.baidu.crabsdk.c.c.os() + "oneday_crash_count", 0) + 1;
            com.baidu.crabsdk.c.a.w("addCrashUploadCount todayCount: " + i);
            com.baidu.crabsdk.c.c.a(RW.edit().putInt(com.baidu.crabsdk.c.c.os() + "oneday_crash_count", i), true);
        }
        com.baidu.crabsdk.a.y++;
    }

    public static void ag() {
        if (com.baidu.crabsdk.a.v == -1) {
            return;
        }
        if (RW != null) {
            int i = RW.getInt(com.baidu.crabsdk.c.c.os() + "oneday_anr_count", 0) + 1;
            com.baidu.crabsdk.c.a.w("addAnrUploadCount todayCount: " + i);
            com.baidu.crabsdk.c.c.a(RW.edit().putInt(com.baidu.crabsdk.c.c.os() + "oneday_anr_count", i), true);
        }
        com.baidu.crabsdk.a.A++;
    }

    public static void ah() {
        com.baidu.crabsdk.c.a.cj("### addBlockUploadCount = " + com.baidu.crabsdk.a.w);
        if (com.baidu.crabsdk.a.w == -1) {
            return;
        }
        if (RW != null) {
            int i = RW.getInt(com.baidu.crabsdk.c.c.os() + "oneday_block_count", 0) + 1;
            com.baidu.crabsdk.c.a.cj("addBlockUploadCount todayCount: " + i);
            com.baidu.crabsdk.c.c.a(RW.edit().putInt(com.baidu.crabsdk.c.c.os() + "oneday_block_count", i), false);
        }
        com.baidu.crabsdk.a.B++;
    }

    public static void b(String str, String str2) {
        SharedPreferences.Editor edit = RW.edit();
        edit.putString(str, str2);
        com.baidu.crabsdk.c.c.a(edit, true);
        com.baidu.crabsdk.c.a.v("Encrypted key is: " + str2 + "; filename is: " + str);
    }

    public static void c(Throwable th) {
        String jSONArray;
        boolean z;
        boolean z2;
        int i = 0;
        if (com.baidu.crabsdk.a.t == -1 || RW == null) {
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
        String string = RW.getString(com.baidu.crabsdk.c.c.os() + "same_crash_oneday_count", null);
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
            com.baidu.crabsdk.c.c.a(RW.edit().putString(com.baidu.crabsdk.c.c.os() + "same_crash_oneday_count", jSONArray), true);
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.w("addSameCrashUploadCount exception " + com.baidu.crabsdk.c.c.h(e));
        }
    }

    public static boolean cs(String str) {
        return ct(str) <= 2;
    }

    private static int ct(String str) {
        if (RW != null) {
            return RW.getInt(str, 0);
        }
        return 0;
    }

    public static String cu(String str) {
        String string = RW.getString(str, "");
        com.baidu.crabsdk.c.a.v("Get record appVN is: " + string);
        return string;
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            RW = context.getSharedPreferences("crab_crash_switch", 0);
            if (com.baidu.crabsdk.a.t != -1 && RW != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateTimeUtil.DAY_FORMAT);
                String[] strArr = new String[7];
                for (int i = 1; i < 8; i++) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.add(5, -i);
                    strArr[i - 1] = simpleDateFormat.format(calendar.getTime());
                }
                SharedPreferences.Editor edit = RW.edit();
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
                    String string = RW.getString("constant_crash", null);
                    if (TextUtils.isEmpty(string) || new JSONObject(string).getInt("count") < com.baidu.crabsdk.a.z || com.baidu.crabsdk.a.Q == null) {
                        return;
                    }
                    SharedPreferences.Editor edit2 = RW.edit();
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
        int ct = ct(str);
        if (!com.baidu.crabsdk.a.D) {
            ct++;
        }
        if (RW != null) {
            com.baidu.crabsdk.c.c.a(RW.edit().putInt(str, ct), true);
        }
    }

    public static void k(String str) {
        if (RW != null) {
            com.baidu.crabsdk.c.c.a(RW.edit().remove(str), true);
        }
    }

    public static boolean k(Throwable th) {
        if (com.baidu.crabsdk.a.t == -1) {
            return true;
        }
        if (RW != null) {
            String i = com.baidu.crabsdk.c.c.i(th);
            String string = RW.getString(com.baidu.crabsdk.c.c.os() + "same_crash_oneday_count", null);
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

    public static void l(Throwable th) {
        String jSONObject;
        if (com.baidu.crabsdk.a.z == -1 || RW == null) {
            return;
        }
        String i = com.baidu.crabsdk.c.c.i(th);
        try {
            String string = RW.getString("constant_crash", null);
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
            com.baidu.crabsdk.c.c.a(RW.edit().putString("constant_crash", jSONObject), true);
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.w("addConstantSameCrash exception " + com.baidu.crabsdk.c.c.h(e));
        }
    }

    public static void m(String str) {
        SharedPreferences.Editor edit = RW.edit();
        edit.putString(str, com.baidu.crabsdk.b.p.L());
        com.baidu.crabsdk.c.c.a(edit, true);
        com.baidu.crabsdk.c.a.v("FileName when write is: " + str);
    }

    public static void o(String str) {
        try {
            SharedPreferences.Editor edit = RW.edit();
            edit.remove(str);
            com.baidu.crabsdk.c.c.a(edit, true);
            com.baidu.crabsdk.c.a.v("delete local appVN: " + str);
        } catch (Exception e) {
            e.printStackTrace();
            com.baidu.crabsdk.c.a.w("delete local appVN error!");
        }
    }

    public static boolean oA() {
        int i;
        if (com.baidu.crabsdk.a.u == -1) {
            return true;
        }
        if (RW == null || (i = RW.getInt(com.baidu.crabsdk.c.c.os() + "oneday_crash_count", -1)) <= com.baidu.crabsdk.a.u) {
            return com.baidu.crabsdk.a.y <= com.baidu.crabsdk.a.u;
        }
        com.baidu.crabsdk.c.a.w("exceed daily crash quota " + i + "/" + com.baidu.crabsdk.a.u);
        return false;
    }

    public static boolean oB() {
        int i;
        if (com.baidu.crabsdk.a.v == -1) {
            return true;
        }
        if (RW == null || (i = RW.getInt(com.baidu.crabsdk.c.c.os() + "oneday_anr_count", -1)) <= com.baidu.crabsdk.a.v) {
            return com.baidu.crabsdk.a.A <= com.baidu.crabsdk.a.v;
        }
        com.baidu.crabsdk.c.a.w("exceed daily anr quota " + i + "/" + com.baidu.crabsdk.a.v);
        return false;
    }

    public static boolean oC() {
        int i;
        if (com.baidu.crabsdk.a.w == -1) {
            com.baidu.crabsdk.c.a.cj("canBlockUploadToday!");
            return true;
        } else if (RW != null && (i = RW.getInt(com.baidu.crabsdk.c.c.os() + "oneday_block_count", -1)) > com.baidu.crabsdk.a.w) {
            com.baidu.crabsdk.c.a.w("exceed daily block quota " + i + "/" + com.baidu.crabsdk.a.w);
            return false;
        } else if (com.baidu.crabsdk.a.B > com.baidu.crabsdk.a.w) {
            com.baidu.crabsdk.c.a.w("exceed daily block limit! can not upload block today!!");
            return false;
        } else {
            com.baidu.crabsdk.c.a.cj("canBlockUploadToday!");
            return true;
        }
    }

    public static boolean oy() {
        if (RW != null ? RW.getBoolean("crash_switch", true) : true) {
            com.baidu.crabsdk.c.a.v("CrashSwitch yes");
            return true;
        }
        if (System.currentTimeMillis() > (RW != null ? RW.getLong("crash_switch_time", 0L) : 0L)) {
            com.baidu.crabsdk.c.a.v("CrashSwitch yes");
            return true;
        }
        com.baidu.crabsdk.c.a.v("CrashSwitch no");
        return false;
    }

    public static boolean oz() {
        long j = RW != null ? RW.getLong("crash_upload_time_nowifi", 0L) : 0L;
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

    public static String p(String str) {
        String string = RW.getString("key_" + str, "");
        if (TextUtils.isEmpty(string)) {
            com.baidu.crabsdk.c.a.ck("Not found the relative value. Key is: " + str);
            string = "NoEncrypt_" + com.baidu.crabsdk.c.d.c(com.baidu.crabsdk.a.d, str);
        }
        com.baidu.crabsdk.c.a.v("Decrypted key is: " + string + "; filename is: " + str);
        return string;
    }

    public static void q(String str) {
        try {
            SharedPreferences.Editor edit = RW.edit();
            edit.remove(str);
            com.baidu.crabsdk.c.c.a(edit, true);
            com.baidu.crabsdk.c.a.v("delete local key: " + str);
        } catch (Exception e) {
            e.printStackTrace();
            com.baidu.crabsdk.c.a.w("delete local key error!");
        }
    }
}
