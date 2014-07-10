package com.baidu.tbadk.core.util;

import android.content.IntentFilter;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.gson.JsonArray;
import com.baidu.gson.JsonObject;
import com.baidu.tbadk.TbadkApplication;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aw {
    private static final String[] a = {"/c/s/pv", "/c/f/pb/page", "/c/s/msg", "/c/f/pb/floor", "/c/m/getmsg", "/c/u/feed/replyme", "/c/f/forum/search", "/c/f/frs/page", "/c/f/forum/favocommend", "/c/u/user/profile"};
    private static List<Integer> b = new LinkedList();
    private static aw c;
    private static ax d;

    private aw() {
        d = new ax(this, null);
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            TbadkApplication.m252getInst().getApp().registerReceiver(d, intentFilter);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    private static synchronized void e() {
        synchronized (aw.class) {
            if (c == null) {
                c = new aw();
            }
        }
    }

    public static aw a() {
        if (c == null) {
            e();
        }
        return c;
    }

    public static int a(String str) {
        if (bm.c(str)) {
            return -1;
        }
        for (int i = 0; i < a.length; i++) {
            if (str.contains(a[i])) {
                return i + 1;
            }
        }
        return -1;
    }

    public synchronized void a(int i, int i2) {
        List<ay> list;
        int i3;
        if (i > 0 && i2 > 0) {
            String a2 = com.baidu.tbadk.core.sharedPref.b.a().a("network_error_record", "");
            if (bm.c(a2)) {
                list = new LinkedList<>();
                ay ayVar = new ay(this, null);
                ayVar.a = i;
                ayVar.b = i2;
                ayVar.c = 1;
                list.add(ayVar);
            } else {
                List<ay> c2 = c(a2);
                int i4 = -1;
                int i5 = 0;
                while (i5 < c2.size()) {
                    if (c2.get(i5).a == i && c2.get(i5).b == i2) {
                        c2.get(i5).c++;
                        i3 = i5;
                    } else {
                        i3 = i4;
                    }
                    i5++;
                    i4 = i3;
                }
                if (i4 < 0) {
                    ay ayVar2 = new ay(this, null);
                    ayVar2.a = i;
                    ayVar2.b = i2;
                    ayVar2.c = 1;
                    c2.add(ayVar2);
                }
                list = c2;
            }
            String a3 = a(list);
            if (!bm.c(a3)) {
                com.baidu.tbadk.core.sharedPref.b.a().b("network_error_record", a3);
            }
        }
    }

    public synchronized void b() {
        for (Integer num : b) {
            a(num.intValue(), 2);
        }
    }

    public synchronized void a(int i) {
        if (i > 0) {
            b.add(Integer.valueOf(i));
        }
    }

    public synchronized void b(int i) {
        if (i > 0) {
            b.remove(Integer.valueOf(i));
        }
    }

    public synchronized void c() {
        com.baidu.tbadk.core.sharedPref.b.a().a("network_error_record");
    }

    public static void b(String str) {
        try {
            int a2 = a(str);
            if (a2 > 0) {
                a().b(a2);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public synchronized String d() {
        return com.baidu.tbadk.core.sharedPref.b.a().a("network_error_record", "");
    }

    private String a(List<ay> list) {
        JsonArray jsonArray = new JsonArray();
        try {
            for (ay ayVar : list) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("port", Integer.valueOf(ayVar.a));
                jsonObject.addProperty("action", Integer.valueOf(ayVar.b));
                jsonObject.addProperty("count", Integer.valueOf(ayVar.c));
                jsonArray.add(jsonObject);
            }
            return jsonArray.toString();
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            return null;
        }
    }

    private List<ay> c(String str) {
        LinkedList linkedList = new LinkedList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                ay ayVar = new ay(this, null);
                ayVar.a = optJSONObject.getInt("port");
                ayVar.b = optJSONObject.getInt("action");
                ayVar.c = optJSONObject.getInt("count");
                linkedList.add(ayVar);
            }
        } catch (JSONException e) {
            BdLog.e(e.getMessage());
        }
        return linkedList;
    }
}
