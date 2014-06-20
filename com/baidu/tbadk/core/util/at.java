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
public class at {
    private static final String[] a = {"/c/s/pv", "/c/f/pb/page", "/c/s/msg", "/c/f/pb/floor", "/c/m/getmsg", "/c/u/feed/replyme", "/c/f/forum/search", "/c/f/frs/page", "/c/f/forum/favocommend", "/c/u/user/profile"};
    private static List<Integer> b = new LinkedList();
    private static at c;
    private static au d;

    private at() {
        d = new au(this, null);
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            TbadkApplication.m252getInst().getApp().registerReceiver(d, intentFilter);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    private static synchronized void e() {
        synchronized (at.class) {
            if (c == null) {
                c = new at();
            }
        }
    }

    public static at a() {
        if (c == null) {
            e();
        }
        return c;
    }

    public static int a(String str) {
        if (bg.c(str)) {
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
        List<av> list;
        int i3;
        if (i > 0 && i2 > 0) {
            String a2 = com.baidu.tbadk.core.sharedPref.b.a().a("network_error_record", "");
            if (bg.c(a2)) {
                list = new LinkedList<>();
                av avVar = new av(this, null);
                avVar.a = i;
                avVar.b = i2;
                avVar.c = 1;
                list.add(avVar);
            } else {
                List<av> d2 = d(a2);
                int i4 = -1;
                int i5 = 0;
                while (i5 < d2.size()) {
                    if (d2.get(i5).a == i && d2.get(i5).b == i2) {
                        d2.get(i5).c++;
                        i3 = i5;
                    } else {
                        i3 = i4;
                    }
                    i5++;
                    i4 = i3;
                }
                if (i4 < 0) {
                    av avVar2 = new av(this, null);
                    avVar2.a = i;
                    avVar2.b = i2;
                    avVar2.c = 1;
                    d2.add(avVar2);
                }
                list = d2;
            }
            String a3 = a(list);
            if (!bg.c(a3)) {
                com.baidu.tbadk.core.sharedPref.b.a().b("network_error_record", a3);
            }
        }
    }

    public synchronized void b(String str) {
        if (!bg.c(str)) {
            for (av avVar : d(str)) {
                if (avVar != null) {
                    a(avVar.a, avVar.b);
                }
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

    public static void c(String str) {
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

    private String a(List<av> list) {
        JsonArray jsonArray = new JsonArray();
        try {
            for (av avVar : list) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("port", Integer.valueOf(avVar.a));
                jsonObject.addProperty("action", Integer.valueOf(avVar.b));
                jsonObject.addProperty("count", Integer.valueOf(avVar.c));
                jsonArray.add(jsonObject);
            }
            return jsonArray.toString();
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            return null;
        }
    }

    private List<av> d(String str) {
        LinkedList linkedList = new LinkedList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                av avVar = new av(this, null);
                avVar.a = optJSONObject.getInt("port");
                avVar.b = optJSONObject.getInt("action");
                avVar.c = optJSONObject.getInt("count");
                linkedList.add(avVar);
            }
        } catch (JSONException e) {
            BdLog.e(e.getMessage());
        }
        return linkedList;
    }
}
