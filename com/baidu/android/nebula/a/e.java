package com.baidu.android.nebula.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.baidu.locMoplus.BDLocManager;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class e {
    private static e b;
    private Context a;
    private BDLocManager c;

    private e(Context context) {
        this.a = context.getApplicationContext();
        this.c = new BDLocManager(this.a);
    }

    public static synchronized e a(Context context) {
        e eVar;
        synchronized (e.class) {
            if (b == null) {
                b = new e(context.getApplicationContext());
            }
            eVar = b;
        }
        return eVar;
    }

    public static void a() {
        b = null;
    }

    private void a(long j) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.a).edit();
        edit.putLong("light_loc_string_time", j);
        edit.commit();
    }

    private void a(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            str2 = com.baidu.android.systemmonitor.security.a.a(str);
        } catch (Error e) {
            e.printStackTrace();
        } catch (Exception e2) {
        }
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.a).edit();
        edit.putString("light_loc_string_gps", str2);
        edit.commit();
    }

    private void b(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            str2 = com.baidu.android.systemmonitor.security.a.a(str);
        } catch (Error e) {
            e.printStackTrace();
        } catch (Exception e2) {
        }
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.a).edit();
        edit.putString("light_loc_string", str2);
        edit.commit();
    }

    private String e() {
        JSONObject jSONObject;
        String str = "";
        a aVar = new a(this.a);
        try {
            HttpPost httpPost = new HttpPost(com.baidu.android.moplus.a.c);
            httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
            ArrayList arrayList = new ArrayList();
            String locString = this.c.getLocString();
            String a = j.a(this.a);
            String a2 = com.baidu.android.moplus.util.a.a();
            arrayList.add(new BasicNameValuePair("apinfo", locString));
            arrayList.add(new BasicNameValuePair("cuid", a));
            arrayList.add(new BasicNameValuePair("cip", a2));
            arrayList.add(new BasicNameValuePair("prod", "Moplus"));
            arrayList.add(new BasicNameValuePair("addr", "city_code|province|city|district|street|street_number"));
            httpPost.setEntity(new UrlEncodedFormEntity(arrayList, "UTF-8"));
            HttpResponse execute = aVar.execute(httpPost);
            if (execute.getStatusLine().getStatusCode() == 200) {
                JSONObject jSONObject2 = new JSONObject(EntityUtils.toString(execute.getEntity(), "UTF-8"));
                JSONObject jSONObject3 = jSONObject2.getJSONObject("content");
                if (jSONObject2.getJSONObject("result").getInt("error") == 161) {
                    String string = jSONObject3.getJSONObject("point").getString("x");
                    String string2 = jSONObject3.getJSONObject("point").getString("y");
                    String string3 = jSONObject3.getString("radius");
                    String string4 = jSONObject3.getJSONObject("addr").getString("city_code");
                    b(jSONObject.optString("province") + jSONObject.optString("city") + jSONObject.optString("district") + jSONObject.optString("street") + jSONObject.optString("street_number"));
                    str = "coords:{accuracy:" + string3 + ",longitude:" + string + ",latitude:" + string2 + "},citycode:" + string4;
                    a(System.currentTimeMillis());
                    a(str);
                } else {
                    str = "";
                }
            }
        } catch (Exception e) {
            str = "";
        } finally {
            aVar.a();
        }
        return str;
    }

    private long f() {
        return PreferenceManager.getDefaultSharedPreferences(this.a).getLong("light_loc_string_time", 0L);
    }

    public String b() {
        String string = PreferenceManager.getDefaultSharedPreferences(this.a).getString("light_loc_string_gps", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                string = com.baidu.android.systemmonitor.security.a.b(string);
            } catch (Error e) {
                e.printStackTrace();
            } catch (Exception e2) {
            }
        }
        return (TextUtils.isEmpty(string) || System.currentTimeMillis() - f() >= 1800000) ? e() : string.contains("error") ? e() : string;
    }

    public boolean b(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
        arrayList.add("android.permission.ACCESS_WIFI_STATE");
        arrayList.add("android.permission.CHANGE_WIFI_STATE");
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (context.getPackageManager().checkPermission((String) it.next(), context.getPackageName()) != 0) {
                return false;
            }
        }
        return true;
    }

    public String c() {
        String d = d();
        if (TextUtils.isEmpty(d)) {
            return d;
        }
        try {
            return com.baidu.android.systemmonitor.security.a.b(d);
        } catch (Error e) {
            e.printStackTrace();
            return d;
        } catch (Exception e2) {
            return d;
        }
    }

    public String d() {
        return PreferenceManager.getDefaultSharedPreferences(this.a).getString("light_loc_string", "");
    }
}
