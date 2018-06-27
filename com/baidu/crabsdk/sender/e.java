package com.baidu.crabsdk.sender;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.crabsdk.b.o;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class e {
    private static SharedPreferences SV;
    private static Context mContext;

    public static void V() {
        a(true);
    }

    public static boolean Y() {
        int i;
        if (com.baidu.crabsdk.a.v == -1) {
            return true;
        }
        if (SV == null || (i = SV.getInt(com.baidu.crabsdk.c.c.pg() + "oneday_anr_count", -1)) <= com.baidu.crabsdk.a.v) {
            return com.baidu.crabsdk.a.A <= com.baidu.crabsdk.a.v;
        }
        com.baidu.crabsdk.c.a.cg("exceed daily anr quota " + i + "/" + com.baidu.crabsdk.a.v);
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
        if (SV != null) {
            com.baidu.crabsdk.c.c.a(SV.edit().putLong("crash_switch_time", timeInMillis), true);
        }
    }

    public static void a(long j) {
        if (SV != null) {
            com.baidu.crabsdk.c.c.a(SV.edit().putLong("crash_upload_time_nowifi", j), true);
        }
    }

    private static void a(boolean z) {
        if (SV != null) {
            com.baidu.crabsdk.c.c.a(SV.edit().putBoolean("crash_switch", z), true);
        }
    }

    public static void aa() {
        if (com.baidu.crabsdk.a.u == -1) {
            return;
        }
        if (SV != null) {
            int i = SV.getInt(com.baidu.crabsdk.c.c.pg() + "oneday_crash_count", 0) + 1;
            com.baidu.crabsdk.c.a.cg("addCrashUploadCount todayCount: " + i);
            com.baidu.crabsdk.c.c.a(SV.edit().putInt(com.baidu.crabsdk.c.c.pg() + "oneday_crash_count", i), true);
        }
        com.baidu.crabsdk.a.y++;
    }

    public static void ab() {
        if (com.baidu.crabsdk.a.v == -1) {
            return;
        }
        if (SV != null) {
            int i = SV.getInt(com.baidu.crabsdk.c.c.pg() + "oneday_anr_count", 0) + 1;
            com.baidu.crabsdk.c.a.cg("addAnrUploadCount todayCount: " + i);
            com.baidu.crabsdk.c.c.a(SV.edit().putInt(com.baidu.crabsdk.c.c.pg() + "oneday_anr_count", i), true);
        }
        com.baidu.crabsdk.a.A++;
    }

    public static void ac() {
        com.baidu.crabsdk.c.a.cd("### addBlockUploadCount = " + com.baidu.crabsdk.a.w);
        if (com.baidu.crabsdk.a.w == -1) {
            return;
        }
        if (SV != null) {
            int i = SV.getInt(com.baidu.crabsdk.c.c.pg() + "oneday_block_count", 0) + 1;
            com.baidu.crabsdk.c.a.cd("addBlockUploadCount todayCount: " + i);
            com.baidu.crabsdk.c.c.a(SV.edit().putInt(com.baidu.crabsdk.c.c.pg() + "oneday_block_count", i), false);
        }
        com.baidu.crabsdk.a.B++;
    }

    public static void b(String str, String str2) {
        SharedPreferences.Editor edit = SV.edit();
        edit.putString(str, str2);
        com.baidu.crabsdk.c.c.a(edit, true);
        com.baidu.crabsdk.c.a.cf("(--#)  save RSA_AESkey when write  (--#)" + str);
    }

    private static int cn(String str) {
        if (SV != null) {
            return SV.getInt(str, 0);
        }
        return 0;
    }

    public static void d(Context context) {
        if (mContext == null) {
            mContext = context;
            SV = context.getSharedPreferences("crab_crash_switch", 0);
            if (com.baidu.crabsdk.a.t != -1 && SV != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
                String[] strArr = new String[7];
                for (int i = 1; i < 8; i++) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.add(5, -i);
                    strArr[i - 1] = simpleDateFormat.format(calendar.getTime());
                }
                SharedPreferences.Editor edit = SV.edit();
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
                    String string = SV.getString("constant_crash", null);
                    if (TextUtils.isEmpty(string) || new JSONObject(string).getInt("count") < com.baidu.crabsdk.a.z || com.baidu.crabsdk.a.N == null) {
                        return;
                    }
                    SharedPreferences.Editor edit2 = SV.edit();
                    edit2.remove("constant_crash");
                    if (edit2.commit()) {
                        com.baidu.crabsdk.a.N.onCrashExceedCallback();
                    }
                } catch (Exception e) {
                    com.baidu.crabsdk.c.a.cg("addConstantSameCrash exception " + com.baidu.crabsdk.c.c.c(e));
                }
            }
        }
    }

    public static boolean d(String str) {
        return cn(str) <= 2;
    }

    public static void e(String str) {
        int cn = cn(str);
        if (!com.baidu.crabsdk.a.D) {
            cn++;
        }
        if (SV != null) {
            com.baidu.crabsdk.c.c.a(SV.edit().putInt(str, cn), true);
        }
    }

    public static void f(String str) {
        if (SV != null) {
            com.baidu.crabsdk.c.c.a(SV.edit().remove(str), true);
        }
    }

    public static void h(String str) {
        String H = !TextUtils.isEmpty(com.baidu.crabsdk.a.o) ? com.baidu.crabsdk.a.o : o.H();
        SharedPreferences.Editor edit = SV.edit();
        edit.putString(str, H);
        com.baidu.crabsdk.c.c.a(edit, true);
        com.baidu.crabsdk.c.a.cf("(--#)  fileName when write  (--#)" + str);
    }

    public static boolean h(Throwable th) {
        if (com.baidu.crabsdk.a.t == -1) {
            return true;
        }
        if (SV != null) {
            String f = com.baidu.crabsdk.c.c.f(th);
            String string = SV.getString(com.baidu.crabsdk.c.c.pg() + "same_crash_oneday_count", null);
            try {
                if (!TextUtils.isEmpty(string)) {
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                        if (jSONObject.getString("errorOriLine").equals(f) && jSONObject.getInt("count") >= com.baidu.crabsdk.a.t) {
                            com.baidu.crabsdk.c.a.cf("canSameCrashUpload no");
                            return false;
                        }
                    }
                }
            } catch (Exception e) {
                com.baidu.crabsdk.c.a.cg("canSameCrashUpload exception " + com.baidu.crabsdk.c.c.c(e));
            }
            for (String str : com.baidu.crabsdk.a.x.keySet()) {
                if (str.equals(f) && com.baidu.crabsdk.a.x.get(str).intValue() > com.baidu.crabsdk.a.t) {
                    com.baidu.crabsdk.c.a.cf("SharedPreferences ignore, but canSameCrashUpload no");
                    return false;
                }
            }
        }
        com.baidu.crabsdk.c.a.cf("canSameCrashUpload yes");
        return true;
    }

    public static String i(String str) {
        String string = SV.getString(str, "");
        com.baidu.crabsdk.c.a.cf("(--#) getRecordAppVN (--#) " + string);
        return string;
    }

    public static void i(Throwable th) {
        String jSONArray;
        boolean z;
        boolean z2;
        int i = 0;
        if (com.baidu.crabsdk.a.t == -1 || SV == null) {
            return;
        }
        String f = com.baidu.crabsdk.c.c.f(th);
        boolean z3 = true;
        for (String str : com.baidu.crabsdk.a.x.keySet()) {
            if (str.equals(f)) {
                com.baidu.crabsdk.a.x.put(str, Integer.valueOf(com.baidu.crabsdk.a.x.get(str).intValue() + 1));
                z2 = false;
            } else {
                z2 = z3;
            }
            z3 = z2;
        }
        if (z3) {
            com.baidu.crabsdk.a.x.put(f, 1);
        }
        String string = SV.getString(com.baidu.crabsdk.c.c.pg() + "same_crash_oneday_count", null);
        try {
            if (TextUtils.isEmpty(string)) {
                JSONArray jSONArray2 = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("errorOriLine", f);
                jSONObject.put("count", 1);
                jSONArray2.put(jSONObject);
                jSONArray = jSONArray2.toString();
            } else {
                JSONArray jSONArray3 = new JSONArray(string);
                boolean z4 = false;
                while (i < jSONArray3.length()) {
                    JSONObject jSONObject2 = (JSONObject) jSONArray3.get(i);
                    if (jSONObject2.getString("errorOriLine").equals(f)) {
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
                    jSONObject3.put("errorOriLine", f);
                    jSONObject3.put("count", 1);
                    jSONArray3.put(jSONObject3);
                }
                jSONArray = jSONArray3.toString();
            }
            com.baidu.crabsdk.c.c.a(SV.edit().putString(com.baidu.crabsdk.c.c.pg() + "same_crash_oneday_count", jSONArray), true);
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.cg("addSameCrashUploadCount exception " + com.baidu.crabsdk.c.c.c(e));
        }
    }

    public static void j(String str) {
        try {
            SharedPreferences.Editor edit = SV.edit();
            edit.remove(str);
            com.baidu.crabsdk.c.c.a(edit, true);
            com.baidu.crabsdk.c.a.cf("(--#) deleteRecordAppVN (--#) " + str);
        } catch (Exception e) {
            e.printStackTrace();
            com.baidu.crabsdk.c.a.cg("delete local appVN error!");
        }
    }

    public static void j(Throwable th) {
        String jSONObject;
        if (com.baidu.crabsdk.a.z == -1 || SV == null) {
            return;
        }
        String f = com.baidu.crabsdk.c.c.f(th);
        try {
            String string = SV.getString("constant_crash", null);
            if (TextUtils.isEmpty(string)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("crash", f);
                jSONObject2.put("count", 1);
                jSONObject = jSONObject2.toString();
            } else {
                JSONObject jSONObject3 = new JSONObject(string);
                if (f.equals(jSONObject3.getString("crash"))) {
                    jSONObject3.put("count", jSONObject3.getInt("count") + 1);
                } else {
                    jSONObject3.put("crash", f);
                    jSONObject3.put("count", 1);
                }
                jSONObject = jSONObject3.toString();
            }
            com.baidu.crabsdk.c.a.cg("同一crash连续发生：" + jSONObject);
            com.baidu.crabsdk.c.c.a(SV.edit().putString("constant_crash", jSONObject), true);
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.cg("addConstantSameCrash exception " + com.baidu.crabsdk.c.c.c(e));
        }
    }

    public static String k(String str) {
        String string = SV.getString(str, "");
        com.baidu.crabsdk.c.a.cf("(--#) getRSA_AESkey (--#) " + string);
        return string;
    }

    public static void l(String str) {
        try {
            SharedPreferences.Editor edit = SV.edit();
            edit.remove(str);
            com.baidu.crabsdk.c.c.a(edit, true);
            com.baidu.crabsdk.c.a.cf("(--#) deleteRSA_AESkey (--#) " + str);
        } catch (Exception e) {
            e.printStackTrace();
            com.baidu.crabsdk.c.a.cg("delete local key error!");
        }
    }

    public static boolean pm() {
        if (SV != null ? SV.getBoolean("crash_switch", true) : true) {
            com.baidu.crabsdk.c.a.cf("CrashSwitch yes");
            return true;
        }
        if (System.currentTimeMillis() > (SV != null ? SV.getLong("crash_switch_time", 0L) : 0L)) {
            com.baidu.crabsdk.c.a.cf("CrashSwitch yes");
            return true;
        }
        com.baidu.crabsdk.c.a.cf("CrashSwitch no");
        return false;
    }

    public static boolean pn() {
        long j = SV != null ? SV.getLong("crash_upload_time_nowifi", 0L) : 0L;
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

    public static boolean po() {
        int i;
        if (com.baidu.crabsdk.a.u == -1) {
            return true;
        }
        if (SV == null || (i = SV.getInt(com.baidu.crabsdk.c.c.pg() + "oneday_crash_count", -1)) <= com.baidu.crabsdk.a.u) {
            return com.baidu.crabsdk.a.y <= com.baidu.crabsdk.a.u;
        }
        com.baidu.crabsdk.c.a.cg("exceed daily crash quota " + i + "/" + com.baidu.crabsdk.a.u);
        return false;
    }

    public static boolean pp() {
        int i;
        if (com.baidu.crabsdk.a.w == -1) {
            com.baidu.crabsdk.c.a.cd("canBlockUploadToday!");
            return true;
        } else if (SV != null && (i = SV.getInt(com.baidu.crabsdk.c.c.pg() + "oneday_block_count", -1)) > com.baidu.crabsdk.a.w) {
            com.baidu.crabsdk.c.a.cg("exceed daily block quota " + i + "/" + com.baidu.crabsdk.a.w);
            return false;
        } else if (com.baidu.crabsdk.a.B > com.baidu.crabsdk.a.w) {
            com.baidu.crabsdk.c.a.cg("exceed daily block limit! can not upload block today!!");
            return false;
        } else {
            com.baidu.crabsdk.c.a.cd("canBlockUploadToday!");
            return true;
        }
    }
}
