package com.baidu.crabsdk.lite.sender;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.crabsdk.lite.a.n;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static Context f4680a;

    /* renamed from: b  reason: collision with root package name */
    public static SharedPreferences f4681b;

    public static boolean a(String str) {
        long j;
        SharedPreferences sharedPreferences = f4681b;
        if (sharedPreferences != null) {
            j = sharedPreferences.getLong("crash_upload_time_nowifi_" + str, 0L);
        } else {
            j = 0;
        }
        if (j == 0) {
            e(str, System.currentTimeMillis());
            return false;
        } else if (System.currentTimeMillis() - j > 86400000) {
            e(str, 0L);
            return true;
        } else {
            return false;
        }
    }

    public static boolean b(String str) {
        SharedPreferences sharedPreferences;
        Object obj;
        HashMap<String, Object> hashMap = com.baidu.crabsdk.lite.a.f4639a.get(str);
        int intValue = (hashMap == null || (obj = hashMap.get("sdk_all_crash_limit")) == null) ? -1 : ((Integer) obj).intValue();
        if (intValue != -1 && (sharedPreferences = f4681b) != null) {
            int i2 = sharedPreferences.getInt(com.baidu.crabsdk.lite.b.c.h() + "oneday_crash_count_" + str, -1);
            if (i2 > intValue) {
                com.baidu.crabsdk.lite.b.a.d(str, "exceed daily crash quota " + i2 + "/" + intValue);
                return false;
            }
        }
        return true;
    }

    public static void c(String str) {
        SharedPreferences sharedPreferences;
        Object obj;
        HashMap<String, Object> hashMap = com.baidu.crabsdk.lite.a.f4639a.get(str);
        if (((hashMap == null || (obj = hashMap.get("sdk_all_crash_limit")) == null) ? -1 : ((Integer) obj).intValue()) == -1 || (sharedPreferences = f4681b) == null) {
            return;
        }
        int i2 = sharedPreferences.getInt(com.baidu.crabsdk.lite.b.c.h() + "oneday_crash_count_" + str, 0) + 1;
        StringBuilder sb = new StringBuilder("addCrashUploadCount todayCount: ");
        sb.append(i2);
        com.baidu.crabsdk.lite.b.a.d(str, sb.toString());
        SharedPreferences.Editor edit = f4681b.edit();
        com.baidu.crabsdk.lite.b.c.c(edit.putInt(com.baidu.crabsdk.lite.b.c.h() + "oneday_crash_count_" + str, i2), true);
    }

    public static void d(String str, int i2) {
        g(str, false);
        Calendar calendar = Calendar.getInstance();
        calendar.set(5, calendar.get(5) + i2);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        long timeInMillis = calendar.getTimeInMillis();
        SharedPreferences sharedPreferences = f4681b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            com.baidu.crabsdk.lite.b.c.c(edit.putLong("crash_switch_time_" + str, timeInMillis), true);
        }
    }

    public static void e(String str, long j) {
        SharedPreferences sharedPreferences = f4681b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            com.baidu.crabsdk.lite.b.c.c(edit.putLong("crash_upload_time_nowifi_" + str, j), true);
        }
    }

    public static void f(String str, Context context) {
        Object obj;
        if (f4680a == null) {
            f4680a = context;
            f4681b = context.getSharedPreferences("crablite_crash_switch", 0);
            HashMap<String, Object> hashMap = com.baidu.crabsdk.lite.a.f4639a.get(str);
            if (((hashMap == null || (obj = hashMap.get("sdk_same_crash_limit")) == null) ? -1 : ((Integer) obj).intValue()) == -1 || f4681b == null) {
                return;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            String[] strArr = new String[7];
            for (int i2 = 1; i2 < 8; i2++) {
                Calendar calendar = Calendar.getInstance();
                calendar.add(5, -i2);
                strArr[i2 - 1] = simpleDateFormat.format(calendar.getTime());
            }
            SharedPreferences.Editor edit = f4681b.edit();
            for (int i3 = 0; i3 < 7; i3++) {
                String str2 = strArr[i3];
                edit.remove(str2 + "same_crash_oneday_count_" + str);
                edit.remove(str2 + "oneday_crash_count_" + str);
            }
            com.baidu.crabsdk.lite.b.c.c(edit, true);
        }
    }

    public static void g(String str, boolean z) {
        SharedPreferences sharedPreferences = f4681b;
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            com.baidu.crabsdk.lite.b.c.c(edit.putBoolean("crash_switch_" + str, z), true);
        }
    }

    public static boolean h(String str, Throwable th) {
        Object obj;
        HashMap<String, Object> hashMap = com.baidu.crabsdk.lite.a.f4639a.get(str);
        int intValue = (hashMap == null || (obj = hashMap.get("sdk_same_crash_limit")) == null) ? -1 : ((Integer) obj).intValue();
        if (intValue == -1) {
            return true;
        }
        if (f4681b != null) {
            String f2 = com.baidu.crabsdk.lite.b.c.f(th);
            SharedPreferences sharedPreferences = f4681b;
            String string = sharedPreferences.getString(com.baidu.crabsdk.lite.b.c.h() + "same_crash_oneday_count_" + str, null);
            try {
                if (!TextUtils.isEmpty(string)) {
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject = (JSONObject) jSONArray.get(i2);
                        if (jSONObject.getString("errorOriLine").equals(f2) && jSONObject.getInt("count") >= intValue) {
                            com.baidu.crabsdk.lite.b.a.c(str, "canSameCrashUpload no");
                            return false;
                        }
                    }
                }
            } catch (Exception e2) {
                com.baidu.crabsdk.lite.b.a.d(str, "canSameCrashUpload exception " + com.baidu.crabsdk.lite.b.c.d(e2));
            }
            for (String str2 : com.baidu.crabsdk.lite.a.f4645g.keySet()) {
                if (str2.equals(f2) && com.baidu.crabsdk.lite.a.f4645g.get(str2).intValue() > intValue) {
                    com.baidu.crabsdk.lite.b.a.c(str, "SharedPreferences ignore, but canSameCrashUpload no");
                    return false;
                }
            }
        }
        com.baidu.crabsdk.lite.b.a.c(str, "canSameCrashUpload yes");
        return true;
    }

    public static void i(String str, String str2) {
        Object obj;
        HashMap<String, Object> hashMap = com.baidu.crabsdk.lite.a.f4639a.get(str);
        String str3 = (hashMap == null || (obj = hashMap.get("sdk_appvn")) == null) ? null : (String) obj;
        if (str3 == null) {
            str3 = n.d();
        }
        SharedPreferences.Editor edit = f4681b.edit();
        edit.putString(str2, str3);
        com.baidu.crabsdk.lite.b.c.c(edit, true);
        com.baidu.crabsdk.lite.b.a.c(str, "(--#)  fileName when write  (--#)" + str2);
    }

    public static void j(String str, String str2, String str3) {
        SharedPreferences.Editor edit = f4681b.edit();
        edit.putString(str2, str3);
        com.baidu.crabsdk.lite.b.c.c(edit, true);
        com.baidu.crabsdk.lite.b.a.c(str, "(--#)  save RSA_AESkey when write  (--#)" + str2);
    }

    public static void k(String str, Throwable th) {
        int i2;
        String jSONArray;
        Object obj;
        HashMap<String, Object> hashMap = com.baidu.crabsdk.lite.a.f4639a.get(str);
        if (((hashMap == null || (obj = hashMap.get("sdk_same_crash_limit")) == null) ? -1 : ((Integer) obj).intValue()) == -1 || f4681b == null) {
            return;
        }
        String f2 = com.baidu.crabsdk.lite.b.c.f(th);
        Iterator<String> it = com.baidu.crabsdk.lite.a.f4645g.keySet().iterator();
        boolean z = true;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            if (next.equals(f2)) {
                HashMap<String, Integer> hashMap2 = com.baidu.crabsdk.lite.a.f4645g;
                hashMap2.put(next, Integer.valueOf(hashMap2.get(next).intValue() + 1));
                z = false;
            }
        }
        if (z) {
            com.baidu.crabsdk.lite.a.f4645g.put(f2, 1);
        }
        SharedPreferences sharedPreferences = f4681b;
        String string = sharedPreferences.getString(com.baidu.crabsdk.lite.b.c.h() + "same_crash_oneday_count_" + str, null);
        try {
            if (TextUtils.isEmpty(string)) {
                JSONArray jSONArray2 = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("errorOriLine", f2);
                jSONObject.put("count", 1);
                jSONArray2.put(jSONObject);
                jSONArray = jSONArray2.toString();
            } else {
                JSONArray jSONArray3 = new JSONArray(string);
                boolean z2 = false;
                for (i2 = 0; i2 < jSONArray3.length(); i2++) {
                    JSONObject jSONObject2 = (JSONObject) jSONArray3.get(i2);
                    if (jSONObject2.getString("errorOriLine").equals(f2)) {
                        jSONObject2.put("count", jSONObject2.getInt("count") + 1);
                        z2 = true;
                    }
                }
                if (!z2) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("errorOriLine", f2);
                    jSONObject3.put("count", 1);
                    jSONArray3.put(jSONObject3);
                }
                jSONArray = jSONArray3.toString();
            }
            SharedPreferences.Editor edit = f4681b.edit();
            com.baidu.crabsdk.lite.b.c.c(edit.putString(com.baidu.crabsdk.lite.b.c.h() + "same_crash_oneday_count_" + str, jSONArray), true);
        } catch (Exception e2) {
            com.baidu.crabsdk.lite.b.a.d(str, "addSameCrashUploadCount exception " + com.baidu.crabsdk.lite.b.c.d(e2));
        }
    }

    public static String l(String str, String str2) {
        String string = f4681b.getString(str2, "");
        com.baidu.crabsdk.lite.b.a.c(str, "(--#) getRecordAppVN (--#) " + string);
        return string;
    }

    public static void m(String str, String str2) {
        try {
            SharedPreferences.Editor edit = f4681b.edit();
            edit.remove(str2);
            com.baidu.crabsdk.lite.b.c.c(edit, true);
            com.baidu.crabsdk.lite.b.a.c(str, "(--#) deleteRecordAppVN (--#) " + str2);
        } catch (Exception e2) {
            e2.printStackTrace();
            com.baidu.crabsdk.lite.b.a.d(str, "delete local appVN error!");
        }
    }

    public static String n(String str, String str2) {
        String string = f4681b.getString(str2, "");
        com.baidu.crabsdk.lite.b.a.c(str, "(--#) getRSA_AESkey (--#) " + string);
        return string;
    }

    public static void o(String str, String str2) {
        try {
            SharedPreferences.Editor edit = f4681b.edit();
            edit.remove(str2);
            com.baidu.crabsdk.lite.b.c.c(edit, true);
            com.baidu.crabsdk.lite.b.a.c(str, "(--#) deleteRSA_AESkey (--#) " + str2);
        } catch (Exception e2) {
            e2.printStackTrace();
            com.baidu.crabsdk.lite.b.a.d(str, "delete local key error!");
        }
    }

    public static boolean p(String str) {
        boolean z;
        SharedPreferences sharedPreferences = f4681b;
        if (sharedPreferences != null) {
            z = sharedPreferences.getBoolean("crash_switch_" + str, true);
        } else {
            z = true;
        }
        if (z) {
            com.baidu.crabsdk.lite.b.a.c(str, "CrashSwitch yes");
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences sharedPreferences2 = f4681b;
        long j = 0;
        if (sharedPreferences2 != null) {
            j = sharedPreferences2.getLong("crash_switch_time_" + str, 0L);
        }
        if (currentTimeMillis > j) {
            com.baidu.crabsdk.lite.b.a.c(str, "CrashSwitch yes");
            return true;
        }
        com.baidu.crabsdk.lite.b.a.c(str, "CrashSwitch no");
        return false;
    }

    public static void q(String str) {
        g(str, true);
    }

    public static boolean r(String str) {
        return u(str) <= 2;
    }

    public static void s(String str) {
        int u = u(str) + 1;
        SharedPreferences sharedPreferences = f4681b;
        if (sharedPreferences != null) {
            com.baidu.crabsdk.lite.b.c.c(sharedPreferences.edit().putInt(str, u), true);
        }
    }

    public static void t(String str) {
        SharedPreferences sharedPreferences = f4681b;
        if (sharedPreferences != null) {
            com.baidu.crabsdk.lite.b.c.c(sharedPreferences.edit().remove(str), true);
        }
    }

    public static int u(String str) {
        SharedPreferences sharedPreferences = f4681b;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt(str, 0);
        }
        return 0;
    }
}
