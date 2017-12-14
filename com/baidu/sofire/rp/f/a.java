package com.baidu.sofire.rp.f;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.sofire.b.d;
import com.baidu.sofire.b.e;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {
    private static String a = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static int a(Context context) {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            d.a(e);
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

    private static String c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "1.0.0";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x011b A[Catch: Exception -> 0x0153, TryCatch #0 {Exception -> 0x0153, blocks: (B:3:0x0005, B:6:0x000f, B:9:0x001c, B:11:0x0024, B:15:0x002e, B:18:0x003b, B:21:0x0048, B:24:0x0055, B:27:0x0062, B:30:0x006f, B:33:0x0086, B:36:0x0093, B:39:0x00aa, B:41:0x00cd, B:43:0x00d6, B:51:0x012b, B:46:0x00e2, B:48:0x011b, B:58:0x0149, B:54:0x0138), top: B:62:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0149 A[Catch: Exception -> 0x0153, TRY_LEAVE, TryCatch #0 {Exception -> 0x0153, blocks: (B:3:0x0005, B:6:0x000f, B:9:0x001c, B:11:0x0024, B:15:0x002e, B:18:0x003b, B:21:0x0048, B:24:0x0055, B:27:0x0062, B:30:0x006f, B:33:0x0086, B:36:0x0093, B:39:0x00aa, B:41:0x00cd, B:43:0x00d6, B:51:0x012b, B:46:0x00e2, B:48:0x011b, B:58:0x0149, B:54:0x0138), top: B:62:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONObject as(Context context) {
        String str;
        String g;
        String str2;
        TimeZone timeZone;
        JSONObject jSONObject = new JSONObject();
        try {
            String str3 = Build.BOARD;
            if (str3 == null) {
                str3 = "";
            }
            jSONObject.put("0", str3);
            String str4 = Build.DEVICE;
            if (str4 == null) {
                str4 = "";
            }
            jSONObject.put("1", str4);
            if (Build.VERSION.SDK_INT > 7) {
                str = Build.HARDWARE;
            } else {
                str = "";
            }
            if (str == null) {
                str = "";
            }
            jSONObject.put("2", str);
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
            jSONObject.put("8", e.a(context));
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
            jSONObject.put("11", e.f(context));
            String str12 = Build.VERSION.RELEASE;
            if (str12 == null) {
                str12 = "";
            }
            jSONObject.put("12", str12);
            jSONObject.put("13", e.b(context));
            jSONObject.put("14", "");
            g = e.g(context);
        } catch (Exception e) {
            d.a(e);
        }
        if (!TextUtils.isEmpty(g)) {
            if (g.startsWith("46000") || g.startsWith("46002")) {
                str2 = "1";
            } else if (g.startsWith("46001")) {
                str2 = "2";
            } else if (g.startsWith("46003")) {
                str2 = "3";
            }
            jSONObject.put("15", str2);
            jSONObject.put("16", e.h(context));
            jSONObject.put("17", e.i(context));
            jSONObject.put("18", e.j(context));
            jSONObject.put("19", e.k(context));
            jSONObject.put("20", Build.VERSION.SDK_INT);
            timeZone = TimeZone.getDefault();
            if (timeZone == null) {
                jSONObject.put("21", timeZone.getID());
            } else {
                jSONObject.put("21", "-1");
            }
            return jSONObject;
        }
        str2 = "";
        jSONObject.put("15", str2);
        jSONObject.put("16", e.h(context));
        jSONObject.put("17", e.i(context));
        jSONObject.put("18", e.j(context));
        jSONObject.put("19", e.k(context));
        jSONObject.put("20", Build.VERSION.SDK_INT);
        timeZone = TimeZone.getDefault();
        if (timeZone == null) {
        }
        return jSONObject;
    }

    public static JSONObject a(Context context, com.baidu.sofire.rp.a.b bVar, String str, boolean z) {
        return b(context, bVar.a, bVar.c, z ? bVar.d : bVar.e, str);
    }

    public static JSONObject b(Context context, JSONObject jSONObject) {
        String str;
        JSONObject jSONObject2 = new JSONObject();
        System.currentTimeMillis();
        JSONObject jSONObject3 = null;
        try {
            jSONObject3 = jSONObject.getJSONObject("Common_section");
        } catch (Exception e) {
            d.a(e);
        }
        String optString = jSONObject3.optString("10");
        long optLong = jSONObject3.optLong("0");
        String optString2 = jSONObject3.optString("1");
        String optString3 = jSONObject3.optString("3");
        String optString4 = jSONObject3.optString("8");
        String optString5 = jSONObject3.optString("9");
        try {
            try {
                str = context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
            } catch (Exception e2) {
                d.a(e2);
                str = "";
            }
            jSONObject2.put("1", str);
            jSONObject2.put("2", context.getPackageName());
            jSONObject2.put("3", c(context));
            jSONObject2.put("4", e.a(context));
            jSONObject2.put("5", optString);
            jSONObject2.put("6", optLong);
            jSONObject2.put("7", optString2);
            jSONObject2.put("8", optString3);
            jSONObject2.put("9", optString4);
            jSONObject2.put("10", optString5);
            com.baidu.sofire.rp.a.a aVar = new com.baidu.sofire.rp.a.a(context);
            jSONObject2.put("11", aVar.a.getString("re_a_cv", ""));
            jSONObject2.put("12", aVar.a.getString("re_a_lc", ""));
            jSONObject2.put("13", aVar.b.getBoolean("hac", true) ? 1 : 0);
            if (a(context) == 2) {
                jSONObject2.put("14", 1);
            } else {
                jSONObject2.put("14", 2);
            }
            jSONObject2.put("20", e.d(context));
            jSONObject2.put("21", e.e(context));
            jSONObject2.put("22", e.b(context));
            Object obj = jSONObject.get("Module_section");
            if (obj instanceof JSONArray) {
                jSONObject2.put("module_section", obj);
            } else {
                jSONObject2.put("module_section", new JSONArray().put(obj));
            }
        } catch (Exception e3) {
            d.a(e3);
        }
        return jSONObject2;
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        int indexOf;
        com.baidu.sofire.rp.a.b bVar;
        b.at(context).a();
        b at = b.at(context);
        Message message = new Message();
        message.what = 8;
        at.QO.QK.sendMessage(message);
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
                    aVar.c.putString("re_con", aVar.a.getString("re_con", "").replace(com.baidu.sofire.rp.a.b.b(bVar), com.baidu.sofire.rp.a.b.b(bVar2)));
                    aVar.c.commit();
                }
                com.baidu.sofire.rp.e.a aVar2 = b.at(context).QO;
                Message message2 = new Message();
                message2.what = 7;
                aVar2.QK.sendMessage(message2);
                return;
            }
            if (!aVar.a.getBoolean("re_net_ins_" + bVar2.e, false)) {
                b at2 = b.at(context);
                Message message3 = new Message();
                message3.what = 3;
                message3.obj = bVar2;
                at2.QO.QK.sendMessage(message3);
            }
            com.baidu.sofire.rp.e.a aVar3 = b.at(context).QO;
            Message message4 = new Message();
            message4.what = 7;
            aVar3.QK.sendMessage(message4);
            b at3 = b.at(context);
            Message message5 = new Message();
            message5.what = 2;
            at3.QO.QK.sendMessage(message5);
        }
    }

    public static void a(Context context, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            com.baidu.sofire.rp.a.a aVar = new com.baidu.sofire.rp.a.a(context);
            System.currentTimeMillis();
            aVar.a.getInt("re_net_ty", 2);
            JSONObject optJSONObject = jSONObject.optJSONObject("Common_section");
            long optLong = optJSONObject.optLong("0");
            String optString = optJSONObject.optString("10");
            int optInt = optJSONObject.optInt("5");
            int optInt2 = optJSONObject.optInt("6");
            int optInt3 = optJSONObject.optInt("7");
            int optInt4 = optJSONObject.optInt("11");
            String optString2 = optJSONObject.optString("12", "");
            int i = optInt2 != 0 ? optInt2 : 1;
            com.baidu.sofire.rp.c.a aVar2 = new com.baidu.sofire.rp.c.a();
            aVar2.d = str;
            aVar2.b = optString;
            aVar2.g = optInt;
            aVar2.c = 3;
            aVar2.e = optLong;
            aVar2.f = i;
            aVar2.h = optInt3;
            aVar2.i = optInt4;
            aVar2.j = optString2;
            b at = b.at(context);
            Message message = new Message();
            message.what = 1;
            message.obj = aVar2;
            at.QO.QK.sendMessage(message);
        } catch (Exception e) {
            d.a(e);
        }
    }

    public static void b(Context context, String str) {
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
                        aVar.c.putString("al_da" + str2, optJSONObject.optString(str2));
                        aVar.c.commit();
                    }
                }
            } catch (Exception e) {
                d.a(e);
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
                        aVar.c.putString("in_da" + str3, optJSONObject2.optString(str3));
                        aVar.c.commit();
                    }
                }
            } catch (Exception e2) {
                d.a(e2);
            }
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("2");
                if (optJSONArray != null) {
                    aVar.c.putString("li_pk_s", optJSONArray.toString());
                    aVar.c.commit();
                }
            } catch (Exception e3) {
                d.a(e3);
            }
        } catch (Exception e4) {
            d.a(e4);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r1v1 int), (r2v1 int), (wrap: int : 0x000f: INVOKE  (r0v1 int A[REMOVE]) = (r0v0 java.util.Calendar), (5 int) type: VIRTUAL call: java.util.Calendar.get(int):int)] */
    public static String a() {
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(1);
        int i2 = calendar.get(2);
        return new StringBuilder().append(i).append(i2).append(calendar.get(5)).toString();
    }

    public static JSONObject b(Context context, String str, String str2, String str3, String str4) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject = new JSONObject();
            jSONObject.put("0", System.currentTimeMillis());
            jSONObject.put("1", "0");
            jSONObject.put("2", "0");
            String[] e = d.e(context);
            if (e != null && e.length == 2) {
                jSONObject.put("3", e[0]);
            } else {
                jSONObject.put("3", "3");
            }
            jSONObject.put("4", 0);
            jSONObject.put("5", 0);
            jSONObject.put("6", 1);
            jSONObject.put("7", 0);
            jSONObject.put("8", str);
            jSONObject.put("9", str2);
            jSONObject.put("10", str3);
            jSONObject2 = new JSONObject();
        } catch (Exception e2) {
            d.a(e2);
        }
        if (!TextUtils.isEmpty(str4)) {
            try {
                jSONObject3 = new JSONObject(str4);
            } catch (Exception e3) {
                d.a(e3);
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

    public static void a(Context context, long j) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 101, new Intent("com.b.r.p"), 134217728);
        try {
            alarmManager.cancel(broadcast);
        } catch (Throwable th) {
            d.a(th);
        }
        try {
            alarmManager.set(0, System.currentTimeMillis() + j, broadcast);
        } catch (Exception e) {
            d.a(e);
        }
    }
}
