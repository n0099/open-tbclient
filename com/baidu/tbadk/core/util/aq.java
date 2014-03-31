package com.baidu.tbadk.core.util;

import android.content.IntentFilter;
import com.baidu.gson.JsonArray;
import com.baidu.gson.JsonObject;
import com.baidu.tbadk.TbadkApplication;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class aq {
    private static final String[] a = {"/c/s/pv", "/c/f/pb/page", "/c/s/msg", "/c/f/pb/floor", "/c/m/getmsg", "/c/u/feed/replyme", "/c/f/forum/search", "/c/f/frs/page", "/c/f/forum/favocommend", "/c/u/user/profile"};
    private static List<Integer> b = new LinkedList();
    private static aq c;
    private static ar d;

    private aq() {
        d = new ar(this, (byte) 0);
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            TbadkApplication.j().b().registerReceiver(d, intentFilter);
        } catch (Throwable th) {
            com.baidu.adp.lib.util.f.b(th.getMessage());
        }
    }

    private static synchronized void e() {
        synchronized (aq.class) {
            if (c == null) {
                c = new aq();
            }
        }
    }

    public static aq a() {
        if (c == null) {
            e();
        }
        return c;
    }

    public static int a(String str) {
        if (bc.c(str)) {
            return -1;
        }
        for (int i = 0; i < a.length; i++) {
            if (str.contains(a[i])) {
                return i + 1;
            }
        }
        return -1;
    }

    public final synchronized void a(int i, int i2) {
        List<as> list;
        int i3;
        int i4 = 0;
        synchronized (this) {
            if (i > 0 && i2 > 0) {
                String a2 = com.baidu.tbadk.core.sharedPref.b.a().a("network_error_record", "");
                if (bc.c(a2)) {
                    list = new LinkedList<>();
                    as asVar = new as(this, (byte) 0);
                    asVar.a = i;
                    asVar.b = i2;
                    asVar.c = 1;
                    list.add(asVar);
                } else {
                    List<as> d2 = d(a2);
                    int i5 = -1;
                    while (i4 < d2.size()) {
                        if (d2.get(i4).a == i && d2.get(i4).b == i2) {
                            d2.get(i4).c++;
                            i3 = i4;
                        } else {
                            i3 = i5;
                        }
                        i4++;
                        i5 = i3;
                    }
                    if (i5 < 0) {
                        as asVar2 = new as(this, (byte) 0);
                        asVar2.a = i;
                        asVar2.b = i2;
                        asVar2.c = 1;
                        d2.add(asVar2);
                    }
                    list = d2;
                }
                String a3 = a(list);
                if (!bc.c(a3)) {
                    com.baidu.tbadk.core.sharedPref.b.a().b("network_error_record", a3);
                }
            }
        }
    }

    public final synchronized void b(String str) {
        if (!bc.c(str)) {
            for (as asVar : d(str)) {
                if (asVar != null) {
                    a(asVar.a, asVar.b);
                }
            }
        }
    }

    public final synchronized void b() {
        for (Integer num : b) {
            a(num.intValue(), 2);
        }
    }

    public final synchronized void a(int i) {
        if (i > 0) {
            b.add(Integer.valueOf(i));
        }
    }

    private synchronized void b(int i) {
        if (i > 0) {
            b.remove(Integer.valueOf(i));
        }
    }

    public final synchronized void c() {
        com.baidu.tbadk.core.sharedPref.b.a().a("network_error_record");
    }

    public static void c(String str) {
        try {
            int a2 = a(str);
            if (a2 > 0) {
                a().b(a2);
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(e.getMessage());
        }
    }

    public final synchronized String d() {
        return com.baidu.tbadk.core.sharedPref.b.a().a("network_error_record", "");
    }

    private static String a(List<as> list) {
        JsonArray jsonArray = new JsonArray();
        try {
            for (as asVar : list) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("port", Integer.valueOf(asVar.a));
                jsonObject.addProperty("action", Integer.valueOf(asVar.b));
                jsonObject.addProperty("count", Integer.valueOf(asVar.c));
                jsonArray.add(jsonObject);
            }
            return jsonArray.toString();
        } catch (Throwable th) {
            com.baidu.adp.lib.util.f.b(th.getMessage());
            return null;
        }
    }

    private List<as> d(String str) {
        LinkedList linkedList = new LinkedList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                as asVar = new as(this, (byte) 0);
                asVar.a = optJSONObject.getInt("port");
                asVar.b = optJSONObject.getInt("action");
                asVar.c = optJSONObject.getInt("count");
                linkedList.add(asVar);
            }
        } catch (JSONException e) {
            com.baidu.adp.lib.util.f.b(e.getMessage());
        }
        return linkedList;
    }
}
