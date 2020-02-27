package com.baidu.searchbox.dns.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class a {
    private static volatile a p;
    private Context mContext;
    private b n = new c();
    private b o = new c();

    private a(Context context) {
        this.mContext = context;
    }

    public static void b(Context context) {
        if (p == null) {
            synchronized (a.class) {
                if (p == null) {
                    p = new a(context.getApplicationContext());
                }
            }
        }
    }

    public static a e() {
        return p;
    }

    public void a(String str, com.baidu.searchbox.dns.d.a.a aVar) {
        if (aVar != null) {
            String aVar2 = aVar.toString();
            if (!TextUtils.isEmpty(aVar2)) {
                this.n.put(str, aVar2);
            }
        }
    }

    public com.baidu.searchbox.dns.d.a.a c(String str) {
        String str2 = this.n.get(str);
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        return new com.baidu.searchbox.dns.d.a.a(str2);
    }

    public void clear() {
        this.n.clear();
    }

    public void b(String str, com.baidu.searchbox.dns.d.a.a aVar) {
        if (aVar != null) {
            String aVar2 = aVar.toString();
            if (!TextUtils.isEmpty(aVar2)) {
                this.o.put(str, aVar2);
            }
        }
    }

    public com.baidu.searchbox.dns.d.a.a d(String str) {
        try {
            if (this.o.isEmpty()) {
                String f = f();
                if (TextUtils.isEmpty(f)) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject(f);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject optJSONObject = jSONObject.optJSONObject(next);
                    if (optJSONObject != null) {
                        JSONArray optJSONArray = optJSONObject.optJSONArray(TableDefine.UserInfoColumns.COLUMN_IP);
                        ArrayList arrayList = new ArrayList(optJSONArray.length());
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            arrayList.add(optJSONArray.getString(i));
                        }
                        if (!arrayList.isEmpty()) {
                            b(next, new com.baidu.searchbox.dns.d.a.a(null, 0, null, 0L, arrayList, null));
                        }
                    }
                }
            }
            String str2 = this.o.get(str);
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            return new com.baidu.searchbox.dns.d.a.a(str2);
        } catch (Exception e) {
            return null;
        }
    }

    public void e(String str) {
        SharedPreferences.Editor edit = this.mContext.getSharedPreferences("dns_prefs", 0).edit();
        edit.putString("SP_BACKUPIP_KEY", str);
        edit.apply();
    }

    public String f() {
        return this.mContext.getSharedPreferences("dns_prefs", 0).getString("SP_BACKUPIP_KEY", "");
    }

    public void f(String str) {
        SharedPreferences.Editor edit = this.mContext.getSharedPreferences("dns_prefs", 0).edit();
        edit.putString("SP_BACKUPIP_VERSION_KEY", str);
        edit.apply();
    }

    public String g() {
        return this.mContext.getSharedPreferences("dns_prefs", 0).getString("SP_BACKUPIP_VERSION_KEY", "0");
    }
}
