package com.baidu.sofire.rp.f;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class b {
    private static String c = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String a = "";
    public static String b = "";

    public static void a() {
    }

    public static byte[] b() {
        char[] charArray = c.toCharArray();
        char[] cArr = new char[16];
        for (int i = 0; i < 16; i++) {
            cArr[i] = charArray[new Random().nextInt(62)];
        }
        return new String(cArr).getBytes();
    }

    public static int a(Context context) {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            networkInfo = null;
        }
        if (networkInfo == null) {
            return 0;
        }
        if (1 == networkInfo.getType()) {
            return 2;
        }
        return networkInfo.getType() == 0 ? 1 : 1;
    }

    public static String b(Context context) {
        String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        if (TextUtils.isEmpty(deviceId)) {
            return "";
        }
        return deviceId;
    }

    public static String c(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        return string;
    }

    public static String d(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "1.0.0";
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    public static String a(Context context, String str, String str2) {
        Properties properties = new Properties();
        InputStream inputStream = null;
        String str3 = "";
        try {
            inputStream = context.getAssets().open(str);
            properties.load(inputStream);
            str3 = properties.getProperty(str2);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                }
            }
        } catch (IOException e2) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                }
            }
            throw th;
        }
        return str3;
    }

    public static String c() {
        return UUID.randomUUID().toString();
    }

    public static String a(String str, String str2, long j) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(j).append(str2);
        return i.a(sb.toString());
    }

    public static JSONObject e(Context context) {
        String b2;
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            String str2 = Build.BOARD;
            if (str2 == null) {
                str2 = "";
            }
            jSONObject.put("0", str2);
            String str3 = Build.DEVICE;
            if (str3 == null) {
                str3 = "";
            }
            jSONObject.put("1", str3);
            String str4 = Build.VERSION.SDK_INT > 7 ? Build.HARDWARE : "";
            if (str4 == null) {
                str4 = "";
            }
            jSONObject.put("2", str4);
            String str5 = Build.HOST;
            if (str5 == null) {
                str5 = "";
            }
            jSONObject.put("3", str5);
            String str6 = Build.DISPLAY;
            if (str6 == null) {
                str6 = "";
            }
            jSONObject.put("4", str6);
            String str7 = Build.PRODUCT;
            if (str7 == null) {
                str7 = "";
            }
            jSONObject.put("5", str7);
            String str8 = Build.VERSION.CODENAME;
            if (str8 == null) {
                str8 = "";
            }
            jSONObject.put("6", str8);
            String str9 = Build.VERSION.INCREMENTAL;
            if (str9 == null) {
                str9 = "";
            }
            jSONObject.put("7", str9);
            jSONObject.put("8", d.a(context));
            String str10 = Build.MANUFACTURER;
            if (str10 == null) {
                str10 = "";
            }
            jSONObject.put("9", str10);
            String str11 = Build.MODEL;
            if (str11 == null) {
                str11 = "";
            }
            jSONObject.put("10", str11);
            jSONObject.put("11", e.c(context));
            String str12 = Build.VERSION.RELEASE;
            if (str12 == null) {
                str12 = "";
            }
            jSONObject.put("12", str12);
            jSONObject.put("13", e.a(context));
            jSONObject.put("14", "");
            b2 = e.b(context);
        } catch (Exception e) {
        }
        if (!TextUtils.isEmpty(b2)) {
            if (b2.startsWith("46000") || b2.startsWith("46002")) {
                str = "1";
            } else if (b2.startsWith("46001")) {
                str = "2";
            } else if (b2.startsWith("46003")) {
                str = "3";
            }
            jSONObject.put("15", str);
            jSONObject.put("16", d.d(context));
            jSONObject.put("17", d.e(context));
            jSONObject.put("18", d.f(context));
            jSONObject.put("19", d.g(context));
            jSONObject.put("20", Build.VERSION.SDK_INT);
            return jSONObject;
        }
        str = "";
        jSONObject.put("15", str);
        jSONObject.put("16", d.d(context));
        jSONObject.put("17", d.e(context));
        jSONObject.put("18", d.f(context));
        jSONObject.put("19", d.g(context));
        jSONObject.put("20", Build.VERSION.SDK_INT);
        return jSONObject;
    }

    public static JSONObject a(Context context, com.baidu.sofire.rp.a.b bVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("0", System.currentTimeMillis());
            jSONObject2.put("1", "0");
            jSONObject2.put("2", "0");
            String[] at = at(context);
            if (at != null && at.length == 2) {
                jSONObject2.put("3", at[0]);
            } else {
                jSONObject2.put("3", "");
            }
            jSONObject2.put("4", 0);
            jSONObject2.put("5", 0);
            jSONObject2.put("6", 1);
            jSONObject2.put("7", 0);
            jSONObject2.put("8", bVar.a);
            jSONObject2.put("9", bVar.c);
            jSONObject2.put("10", "1001001");
            JSONObject e = e(context);
            jSONObject.put("Common_section", jSONObject2);
            jSONObject.put("Module_section", e);
        } catch (Exception e2) {
        }
        return jSONObject;
    }

    public static JSONObject a(Context context, com.baidu.sofire.rp.a.b bVar, String str) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject = new JSONObject();
            jSONObject.put("0", System.currentTimeMillis());
            jSONObject.put("1", "0");
            jSONObject.put("2", "0");
            String[] at = at(context);
            if (at != null && at.length == 2) {
                jSONObject.put("3", at[0]);
            } else {
                jSONObject.put("3", "");
            }
            jSONObject.put("4", 0);
            jSONObject.put("5", 0);
            jSONObject.put("6", 1);
            jSONObject.put("7", 0);
            jSONObject.put("8", bVar.a);
            jSONObject.put("9", bVar.c);
            jSONObject.put("10", bVar.d);
            jSONObject2 = new JSONObject();
        } catch (Exception e) {
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONObject3 = new JSONObject(str);
            } catch (Exception e2) {
            }
            jSONObject4.put("Common_section", jSONObject);
            jSONObject4.put("Module_section", jSONObject3);
            return jSONObject4;
        }
        jSONObject3 = jSONObject2;
        jSONObject4.put("Common_section", jSONObject);
        jSONObject4.put("Module_section", jSONObject3);
        return jSONObject4;
    }

    public static JSONObject b(Context context, com.baidu.sofire.rp.a.b bVar, String str) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject = new JSONObject();
            jSONObject.put("0", System.currentTimeMillis());
            jSONObject.put("1", "0");
            jSONObject.put("2", "0");
            String[] at = at(context);
            if (at != null && at.length == 2) {
                jSONObject.put("3", at[0]);
            } else {
                jSONObject.put("3", "");
            }
            jSONObject.put("4", 0);
            jSONObject.put("5", 0);
            jSONObject.put("6", 1);
            jSONObject.put("7", 0);
            jSONObject.put("8", bVar.a);
            jSONObject.put("9", bVar.c);
            jSONObject.put("10", bVar.e);
            jSONObject2 = new JSONObject();
        } catch (Exception e) {
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONObject3 = new JSONObject(str);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            jSONObject4.put("Common_section", jSONObject);
            jSONObject4.put("Module_section", jSONObject3);
            return jSONObject4;
        }
        jSONObject3 = jSONObject2;
        jSONObject4.put("Common_section", jSONObject);
        jSONObject4.put("Module_section", jSONObject3);
        return jSONObject4;
    }

    public static JSONObject a(Context context, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("0", System.currentTimeMillis());
            jSONObject2.put("1", "0");
            jSONObject2.put("2", "0");
            String[] at = at(context);
            if (at != null && at.length == 2) {
                jSONObject2.put("3", at[0]);
            } else {
                jSONObject2.put("3", "");
            }
            jSONObject2.put("4", 0);
            jSONObject2.put("5", 0);
            jSONObject2.put("6", 1);
            jSONObject2.put("7", 0);
            jSONObject2.put("8", "sofire");
            com.baidu.sofire.rp.a.a aVar = new com.baidu.sofire.rp.a.a(context);
            String string = aVar.b.getString("ssv", "");
            if (TextUtils.isEmpty(string)) {
                string = a(context, "my.cfg", "self_version");
            }
            jSONObject2.put("9", string);
            jSONObject2.put("10", str);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("0", aVar.a.getInt("g_r_o_5_m", 0));
            jSONObject.put("Common_section", jSONObject2);
            jSONObject.put("Module_section", jSONObject3);
        } catch (Exception e) {
        }
        return jSONObject;
    }

    public static JSONObject b(Context context, JSONObject jSONObject) {
        JSONObject jSONObject2;
        String str;
        long j;
        String str2;
        String str3;
        String str4;
        String str5;
        String obj;
        JSONObject jSONObject3 = new JSONObject();
        long currentTimeMillis = System.currentTimeMillis();
        try {
            jSONObject2 = jSONObject.getJSONObject("Common_section");
        } catch (Exception e) {
            jSONObject2 = null;
        }
        try {
            str = jSONObject2.optString("10");
        } catch (Exception e2) {
            str = "";
        }
        try {
            j = jSONObject2.optLong("0");
        } catch (Exception e3) {
            j = currentTimeMillis;
        }
        try {
            str2 = jSONObject2.optString("1");
        } catch (Exception e4) {
            str2 = "";
        }
        try {
            str3 = jSONObject2.optString("3");
        } catch (Exception e5) {
            str3 = "";
        }
        try {
            str4 = jSONObject2.optString("8");
        } catch (Exception e6) {
            str4 = "";
        }
        try {
            str5 = jSONObject2.optString("9");
        } catch (Exception e7) {
            str5 = "";
        }
        String str6 = "";
        try {
            str6 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            obj = context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
        } catch (Exception e8) {
        }
        try {
            jSONObject3.put("1", obj);
            jSONObject3.put("2", context.getPackageName());
            jSONObject3.put("3", str6);
            jSONObject3.put("4", d.a(context));
            jSONObject3.put("5", str);
            jSONObject3.put("6", j);
            jSONObject3.put("7", str2);
            jSONObject3.put("8", str3);
            jSONObject3.put("9", str4);
            jSONObject3.put("10", str5);
            com.baidu.sofire.rp.a.a aVar = new com.baidu.sofire.rp.a.a(context);
            jSONObject3.put("11", aVar.a.getString("re_a_cv", ""));
            jSONObject3.put("12", aVar.a.getString("re_a_lc", ""));
            jSONObject3.put("13", aVar.b.getBoolean("hac", true) ? 1 : 0);
            if (a(context) == 2) {
                jSONObject3.put("14", 1);
            } else {
                jSONObject3.put("14", 2);
            }
            String c2 = d.c(context);
            if (TextUtils.isEmpty(c2)) {
                c2 = d.b(context);
            }
            jSONObject3.put("20", c2);
            Object obj2 = jSONObject.get("Module_section");
            if (obj2 instanceof JSONArray) {
                jSONObject3.put("module_section", obj2);
            } else {
                jSONObject3.put("module_section", new JSONArray().put(obj2));
            }
        } catch (Exception e9) {
        }
        return jSONObject3;
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        int indexOf;
        com.baidu.sofire.rp.a.b bVar;
        c.au(context).a();
        c.au(context).d();
        com.baidu.sofire.rp.a.b bVar2 = new com.baidu.sofire.rp.a.b();
        bVar2.a = str;
        bVar2.b = str2;
        bVar2.c = str3;
        bVar2.d = str4;
        bVar2.e = str5;
        if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
            com.baidu.sofire.rp.a.a aVar = new com.baidu.sofire.rp.a.a(context);
            List<com.baidu.sofire.rp.a.b> a2 = aVar.a();
            if (a2 == null) {
                aVar.a(bVar2);
            } else if (!a2.contains(bVar2)) {
                aVar.a(bVar2);
            } else {
                if (a2 != null && (indexOf = a2.indexOf(bVar2)) != -1 && (bVar = a2.get(indexOf)) != null) {
                    aVar.QC.putString("re_con", aVar.a.getString("re_con", "").replace(com.baidu.sofire.rp.a.b.b(bVar), com.baidu.sofire.rp.a.b.b(bVar2)));
                    aVar.QC.commit();
                }
                c.au(context).b();
                return;
            }
            if (!aVar.a.getBoolean("re_net_ins_" + bVar2.e, false)) {
                c.au(context).a(bVar2);
            }
            c.au(context).b();
            c.au(context).c();
        }
    }

    public static void b(Context context, String str) {
        JSONObject jSONObject;
        long j;
        String str2;
        int i;
        int i2;
        int i3 = 0;
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            com.baidu.sofire.rp.a.a aVar = new com.baidu.sofire.rp.a.a(context);
            long currentTimeMillis = System.currentTimeMillis();
            int i4 = aVar.a.getInt("re_net_ty", 2);
            try {
                jSONObject = jSONObject2.optJSONObject("Common_section");
            } catch (Exception e) {
                jSONObject = null;
            }
            try {
                j = jSONObject.optLong("0");
            } catch (Exception e2) {
                j = currentTimeMillis;
            }
            try {
                str2 = jSONObject.optString("10");
            } catch (Exception e3) {
                str2 = "";
            }
            try {
                i = jSONObject.optInt("5");
            } catch (Exception e4) {
                i = 0;
            }
            try {
                i4 = jSONObject.optInt("6");
            } catch (Exception e5) {
            }
            try {
                i2 = jSONObject.optInt("7");
            } catch (Exception e6) {
                i2 = 0;
            }
            try {
                i3 = jSONObject.optInt("11");
            } catch (Exception e7) {
            }
            if (i4 == 0) {
                i4 = 1;
            }
            com.baidu.sofire.rp.c.a aVar2 = new com.baidu.sofire.rp.c.a();
            aVar2.d = str;
            aVar2.b = str2;
            aVar2.g = i;
            aVar2.c = 3;
            aVar2.e = j;
            aVar2.f = i4;
            aVar2.h = i2;
            aVar2.i = i3;
            c.au(context).b(aVar2);
        } catch (Exception e8) {
        }
    }

    public static void e(Context context, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("0", System.currentTimeMillis());
            jSONObject2.put("1", "0");
            jSONObject2.put("2", "0");
            jSONObject2.put("3", "0");
            jSONObject2.put("4", 0);
            jSONObject2.put("5", 0);
            jSONObject2.put("6", 1);
            jSONObject2.put("7", 0);
            jSONObject2.put("8", "");
            jSONObject2.put("9", "");
            jSONObject2.put("10", str);
            jSONObject2.put("11", 0);
            JSONObject jSONObject3 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject3);
            if (!TextUtils.isEmpty(str2)) {
                jSONArray.put(str2);
            }
            jSONObject.put("Common_section", jSONObject2);
            jSONObject.put("Module_section", jSONArray);
        } catch (Exception e) {
        }
        b(context, jSONObject.toString());
    }

    public static void c(Context context, String str) {
        com.baidu.sofire.rp.a.a aVar = new com.baidu.sofire.rp.a.a(context);
        try {
            JSONObject jSONObject = new JSONObject(str);
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("0");
                if (optJSONObject != null) {
                    String str2 = "";
                    while (optJSONObject.keys().hasNext()) {
                        str2 = String.valueOf(optJSONObject.keys().next());
                        if (!TextUtils.isEmpty(str2)) {
                            break;
                        }
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        aVar.QC.putString("al_da" + str2, optJSONObject.optString(str2));
                        aVar.QC.commit();
                    }
                }
            } catch (Exception e) {
            }
            try {
                JSONObject optJSONObject2 = jSONObject.optJSONObject("1");
                if (optJSONObject2 != null) {
                    String str3 = "";
                    while (optJSONObject2.keys().hasNext()) {
                        str3 = String.valueOf(optJSONObject2.keys().next());
                        if (!TextUtils.isEmpty(str3)) {
                            break;
                        }
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        aVar.QC.putString("in_da" + str3, optJSONObject2.optString(str3));
                        aVar.QC.commit();
                    }
                }
            } catch (Exception e2) {
            }
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("2");
                if (optJSONArray != null) {
                    aVar.QC.putString("li_pk_s", optJSONArray.toString());
                    aVar.QC.commit();
                }
            } catch (Exception e3) {
            }
        } catch (Exception e4) {
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r1v1 int), (r2v1 int), (wrap: int : 0x000f: INVOKE  (r0v1 int A[REMOVE]) = (r0v0 java.util.Calendar), (5 int) type: VIRTUAL call: java.util.Calendar.get(int):int)] */
    public static String d() {
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(1);
        int i2 = calendar.get(2);
        return new StringBuilder().append(i).append(i2).append(calendar.get(5)).toString();
    }

    public static String[] at(Context context) {
        if (TextUtils.isEmpty(a) || TextUtils.isEmpty(b)) {
            String string = new com.baidu.sofire.rp.a.a(context).b.getString("svi", "");
            if (!TextUtils.isEmpty(string)) {
                String[] split = string.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                if (split == null || split.length != 2) {
                    return new String[2];
                }
                a = split[0];
                b = split[1];
                return split;
            }
            return new String[2];
        }
        return new String[]{a, b};
    }
}
