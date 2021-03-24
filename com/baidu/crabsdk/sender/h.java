package com.baidu.crabsdk.sender;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.crabsdk.b.p;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static Context f4769a;

    /* renamed from: b  reason: collision with root package name */
    public static SharedPreferences f4770b;

    public static boolean a() {
        SharedPreferences sharedPreferences = f4770b;
        if (sharedPreferences != null ? sharedPreferences.getBoolean("crash_switch", true) : true) {
            com.baidu.crabsdk.c.a.c("CrashSwitch yes");
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences sharedPreferences2 = f4770b;
        if (currentTimeMillis > (sharedPreferences2 != null ? sharedPreferences2.getLong("crash_switch_time", 0L) : 0L)) {
            com.baidu.crabsdk.c.a.c("CrashSwitch yes");
            return true;
        }
        com.baidu.crabsdk.c.a.c("CrashSwitch no");
        return false;
    }

    public static void b(int i) {
        d(false);
        Calendar calendar = Calendar.getInstance();
        calendar.set(5, calendar.get(5) + i);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        long timeInMillis = calendar.getTimeInMillis();
        SharedPreferences sharedPreferences = f4770b;
        if (sharedPreferences != null) {
            com.baidu.crabsdk.c.c.c(sharedPreferences.edit().putLong("crash_switch_time", timeInMillis), true);
        }
    }

    public static void c(long j) {
        SharedPreferences sharedPreferences = f4770b;
        if (sharedPreferences != null) {
            com.baidu.crabsdk.c.c.c(sharedPreferences.edit().putLong("crash_upload_time_nowifi", j), true);
        }
    }

    public static void d(boolean z) {
        SharedPreferences sharedPreferences = f4770b;
        if (sharedPreferences != null) {
            com.baidu.crabsdk.c.c.c(sharedPreferences.edit().putBoolean("crash_switch", z), true);
        }
    }

    public static void e() {
        d(true);
    }

    public static boolean f() {
        SharedPreferences sharedPreferences = f4770b;
        long j = sharedPreferences != null ? sharedPreferences.getLong("crash_upload_time_nowifi", 0L) : 0L;
        if (j == 0) {
            c(System.currentTimeMillis());
            return false;
        } else if (System.currentTimeMillis() - j > 86400000) {
            c(0L);
            return true;
        } else {
            return false;
        }
    }

    public static boolean g() {
        if (com.baidu.crabsdk.a.u == -1) {
            return true;
        }
        SharedPreferences sharedPreferences = f4770b;
        if (sharedPreferences != null) {
            int i = sharedPreferences.getInt(com.baidu.crabsdk.c.c.e() + "oneday_crash_count", -1);
            if (i > com.baidu.crabsdk.a.u) {
                com.baidu.crabsdk.c.a.d("exceed daily crash quota " + i + "/" + com.baidu.crabsdk.a.u);
                return false;
            }
        }
        return com.baidu.crabsdk.a.y <= com.baidu.crabsdk.a.u;
    }

    public static boolean h() {
        if (com.baidu.crabsdk.a.v == -1) {
            return true;
        }
        SharedPreferences sharedPreferences = f4770b;
        if (sharedPreferences != null) {
            int i = sharedPreferences.getInt(com.baidu.crabsdk.c.c.e() + "oneday_anr_count", -1);
            if (i > com.baidu.crabsdk.a.v) {
                com.baidu.crabsdk.c.a.d("exceed daily anr quota " + i + "/" + com.baidu.crabsdk.a.v);
                return false;
            }
        }
        return com.baidu.crabsdk.a.A <= com.baidu.crabsdk.a.v;
    }

    public static boolean i() {
        String str;
        if (com.baidu.crabsdk.a.w == -1) {
            com.baidu.crabsdk.c.a.b("canBlockUploadToday!");
            return true;
        }
        SharedPreferences sharedPreferences = f4770b;
        if (sharedPreferences != null) {
            int i = sharedPreferences.getInt(com.baidu.crabsdk.c.c.e() + "oneday_block_count", -1);
            if (i > com.baidu.crabsdk.a.w) {
                str = "exceed daily block quota " + i + "/" + com.baidu.crabsdk.a.w;
                com.baidu.crabsdk.c.a.d(str);
                return false;
            }
        }
        if (com.baidu.crabsdk.a.B <= com.baidu.crabsdk.a.w) {
            com.baidu.crabsdk.c.a.b("canBlockUploadToday!");
            return true;
        }
        str = "exceed daily block limit! can not upload block today!!";
        com.baidu.crabsdk.c.a.d(str);
        return false;
    }

    public static void j() {
        if (com.baidu.crabsdk.a.u == -1) {
            return;
        }
        SharedPreferences sharedPreferences = f4770b;
        if (sharedPreferences != null) {
            int i = sharedPreferences.getInt(com.baidu.crabsdk.c.c.e() + "oneday_crash_count", 0) + 1;
            StringBuilder sb = new StringBuilder("addCrashUploadCount todayCount: ");
            sb.append(i);
            com.baidu.crabsdk.c.a.d(sb.toString());
            com.baidu.crabsdk.c.c.c(f4770b.edit().putInt(com.baidu.crabsdk.c.c.e() + "oneday_crash_count", i), true);
        }
        com.baidu.crabsdk.a.y++;
    }

    public static void k() {
        if (com.baidu.crabsdk.a.v == -1) {
            return;
        }
        SharedPreferences sharedPreferences = f4770b;
        if (sharedPreferences != null) {
            int i = sharedPreferences.getInt(com.baidu.crabsdk.c.c.e() + "oneday_anr_count", 0) + 1;
            StringBuilder sb = new StringBuilder("addAnrUploadCount todayCount: ");
            sb.append(i);
            com.baidu.crabsdk.c.a.d(sb.toString());
            com.baidu.crabsdk.c.c.c(f4770b.edit().putInt(com.baidu.crabsdk.c.c.e() + "oneday_anr_count", i), true);
        }
        com.baidu.crabsdk.a.A++;
    }

    public static void l() {
        com.baidu.crabsdk.c.a.b("### addBlockUploadCount = " + com.baidu.crabsdk.a.w);
        if (com.baidu.crabsdk.a.w == -1) {
            return;
        }
        SharedPreferences sharedPreferences = f4770b;
        if (sharedPreferences != null) {
            int i = sharedPreferences.getInt(com.baidu.crabsdk.c.c.e() + "oneday_block_count", 0) + 1;
            StringBuilder sb = new StringBuilder("addBlockUploadCount todayCount: ");
            sb.append(i);
            com.baidu.crabsdk.c.a.b(sb.toString());
            com.baidu.crabsdk.c.c.c(f4770b.edit().putInt(com.baidu.crabsdk.c.c.e() + "oneday_block_count", i), false);
        }
        com.baidu.crabsdk.a.B++;
    }

    public static void m(String str, String str2) {
        SharedPreferences.Editor edit = f4770b.edit();
        edit.putString(str, str2);
        com.baidu.crabsdk.c.c.c(edit, true);
        com.baidu.crabsdk.c.a.c("Encrypted key is: " + str2 + "; filename is: " + str);
    }

    public static boolean n(Throwable th) {
        if (com.baidu.crabsdk.a.t == -1) {
            return true;
        }
        if (f4770b != null) {
            String h2 = com.baidu.crabsdk.c.c.h(th);
            SharedPreferences sharedPreferences = f4770b;
            String string = sharedPreferences.getString(com.baidu.crabsdk.c.c.e() + "same_crash_oneday_count", null);
            try {
                if (!TextUtils.isEmpty(string)) {
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                        if (jSONObject.getString("errorOriLine").equals(h2) && jSONObject.getInt("count") >= com.baidu.crabsdk.a.t) {
                            com.baidu.crabsdk.c.a.c("canSameCrashUpload no");
                            return false;
                        }
                    }
                }
            } catch (Exception e2) {
                com.baidu.crabsdk.c.a.d("canSameCrashUpload exception " + com.baidu.crabsdk.c.c.g(e2));
            }
            for (String str : com.baidu.crabsdk.a.x.keySet()) {
                if (str.equals(h2) && com.baidu.crabsdk.a.x.get(str).intValue() > com.baidu.crabsdk.a.t) {
                    com.baidu.crabsdk.c.a.c("SharedPreferences ignore, but canSameCrashUpload no");
                    return false;
                }
            }
        }
        com.baidu.crabsdk.c.a.c("canSameCrashUpload yes");
        return true;
    }

    public static void o(Throwable th) {
        int i;
        String jSONArray;
        if (com.baidu.crabsdk.a.t == -1 || f4770b == null) {
            return;
        }
        String h2 = com.baidu.crabsdk.c.c.h(th);
        Iterator<String> it = com.baidu.crabsdk.a.x.keySet().iterator();
        boolean z = true;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            if (next.equals(h2)) {
                HashMap<String, Integer> hashMap = com.baidu.crabsdk.a.x;
                hashMap.put(next, Integer.valueOf(hashMap.get(next).intValue() + 1));
                z = false;
            }
        }
        if (z) {
            com.baidu.crabsdk.a.x.put(h2, 1);
        }
        SharedPreferences sharedPreferences = f4770b;
        String string = sharedPreferences.getString(com.baidu.crabsdk.c.c.e() + "same_crash_oneday_count", null);
        try {
            if (TextUtils.isEmpty(string)) {
                JSONArray jSONArray2 = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("errorOriLine", h2);
                jSONObject.put("count", 1);
                jSONArray2.put(jSONObject);
                jSONArray = jSONArray2.toString();
            } else {
                JSONArray jSONArray3 = new JSONArray(string);
                boolean z2 = false;
                for (i = 0; i < jSONArray3.length(); i++) {
                    JSONObject jSONObject2 = (JSONObject) jSONArray3.get(i);
                    if (jSONObject2.getString("errorOriLine").equals(h2)) {
                        jSONObject2.put("count", jSONObject2.getInt("count") + 1);
                        z2 = true;
                    }
                }
                if (!z2) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("errorOriLine", h2);
                    jSONObject3.put("count", 1);
                    jSONArray3.put(jSONObject3);
                }
                jSONArray = jSONArray3.toString();
            }
            SharedPreferences.Editor edit = f4770b.edit();
            com.baidu.crabsdk.c.c.c(edit.putString(com.baidu.crabsdk.c.c.e() + "same_crash_oneday_count", jSONArray), true);
        } catch (Exception e2) {
            com.baidu.crabsdk.c.a.d("addSameCrashUploadCount exception " + com.baidu.crabsdk.c.c.g(e2));
        }
    }

    public static void p(Throwable th) {
        String jSONObject;
        if (com.baidu.crabsdk.a.z == -1 || f4770b == null) {
            return;
        }
        String h2 = com.baidu.crabsdk.c.c.h(th);
        try {
            String string = f4770b.getString("constant_crash", null);
            if (TextUtils.isEmpty(string)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("crash", h2);
                jSONObject2.put("count", 1);
                jSONObject = jSONObject2.toString();
            } else {
                JSONObject jSONObject3 = new JSONObject(string);
                if (h2.equals(jSONObject3.getString("crash"))) {
                    jSONObject3.put("count", jSONObject3.getInt("count") + 1);
                } else {
                    jSONObject3.put("crash", h2);
                    jSONObject3.put("count", 1);
                }
                jSONObject = jSONObject3.toString();
            }
            com.baidu.crabsdk.c.a.d("同一crash连续发生：" + jSONObject);
            com.baidu.crabsdk.c.c.c(f4770b.edit().putString("constant_crash", jSONObject), true);
        } catch (Exception e2) {
            com.baidu.crabsdk.c.a.d("addConstantSameCrash exception " + com.baidu.crabsdk.c.c.g(e2));
        }
    }

    public static void q(Context context) {
        if (f4769a == null) {
            f4769a = context;
            f4770b = context.getSharedPreferences("crab_crash_switch", 0);
            if (com.baidu.crabsdk.a.t != -1 && f4770b != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
                String[] strArr = new String[7];
                for (int i = 1; i < 8; i++) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.add(5, -i);
                    strArr[i - 1] = simpleDateFormat.format(calendar.getTime());
                }
                SharedPreferences.Editor edit = f4770b.edit();
                for (int i2 = 0; i2 < 7; i2++) {
                    String str = strArr[i2];
                    edit.remove(str + "same_crash_oneday_count");
                    edit.remove(str + "oneday_crash_count");
                    edit.remove(str + "oneday_anr_count");
                }
                com.baidu.crabsdk.c.c.c(edit, true);
            }
            if (com.baidu.crabsdk.a.z != -1) {
                try {
                    String string = f4770b.getString("constant_crash", null);
                    if (TextUtils.isEmpty(string) || new JSONObject(string).getInt("count") < com.baidu.crabsdk.a.z || com.baidu.crabsdk.a.Q == null) {
                        return;
                    }
                    SharedPreferences.Editor edit2 = f4770b.edit();
                    edit2.remove("constant_crash");
                    if (edit2.commit()) {
                        com.baidu.crabsdk.a.Q.onCrashExceedCallback();
                    }
                } catch (Exception e2) {
                    com.baidu.crabsdk.c.a.d("addConstantSameCrash exception " + com.baidu.crabsdk.c.c.g(e2));
                }
            }
        }
    }

    public static boolean r(String str) {
        return u(str) <= 2;
    }

    public static void s(String str) {
        int u = u(str);
        if (!com.baidu.crabsdk.a.D) {
            u++;
        }
        SharedPreferences sharedPreferences = f4770b;
        if (sharedPreferences != null) {
            com.baidu.crabsdk.c.c.c(sharedPreferences.edit().putInt(str, u), true);
        }
    }

    public static void t(String str) {
        SharedPreferences sharedPreferences = f4770b;
        if (sharedPreferences != null) {
            com.baidu.crabsdk.c.c.c(sharedPreferences.edit().remove(str), true);
        }
    }

    public static int u(String str) {
        SharedPreferences sharedPreferences = f4770b;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt(str, 0);
        }
        return 0;
    }

    public static void v(String str) {
        SharedPreferences.Editor edit = f4770b.edit();
        edit.putString(str, p.c());
        com.baidu.crabsdk.c.c.c(edit, true);
        com.baidu.crabsdk.c.a.c("FileName when write is: " + str);
    }

    public static String w(String str) {
        String string = f4770b.getString(str, "");
        com.baidu.crabsdk.c.a.c("Get record appVN is: " + string);
        return string;
    }

    public static void x(String str) {
        try {
            SharedPreferences.Editor edit = f4770b.edit();
            edit.remove(str);
            com.baidu.crabsdk.c.c.c(edit, true);
            com.baidu.crabsdk.c.a.c("delete local appVN: " + str);
        } catch (Exception e2) {
            e2.printStackTrace();
            com.baidu.crabsdk.c.a.d("delete local appVN error!");
        }
    }

    public static String y(String str) {
        String string = f4770b.getString("key_" + str, "");
        if (TextUtils.isEmpty(string)) {
            com.baidu.crabsdk.c.a.e("Not found the relative value. Key is: " + str);
            string = "NoEncrypt_" + com.baidu.crabsdk.c.d.h(com.baidu.crabsdk.a.f4637d, str);
        }
        com.baidu.crabsdk.c.a.c("Decrypted key is: " + string + "; filename is: " + str);
        return string;
    }

    public static void z(String str) {
        try {
            SharedPreferences.Editor edit = f4770b.edit();
            edit.remove(str);
            com.baidu.crabsdk.c.c.c(edit, true);
            com.baidu.crabsdk.c.a.c("delete local key: " + str);
        } catch (Exception e2) {
            e2.printStackTrace();
            com.baidu.crabsdk.c.a.d("delete local key error!");
        }
    }
}
