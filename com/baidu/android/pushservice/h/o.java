package com.baidu.android.pushservice.h;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class o {
    private static volatile o a = null;
    private Context b;

    private o(Context context) {
        this.b = null;
        this.b = context.getApplicationContext();
        if (this.b == null) {
            com.baidu.android.pushservice.g.a.e("StatisticProcessor", "Error occurs with mContext");
        }
    }

    public static o a(Context context) {
        if (a == null) {
            a = new o(context);
        }
        com.baidu.android.pushservice.g.a.c("StatisticProcessor", "Current packet name: " + context.getPackageName());
        return a;
    }

    public String a(long j, long j2, int i) {
        int i2;
        JSONArray jSONArray = new JSONArray();
        List<i> a2 = com.baidu.android.pushservice.d.a.a(this.b);
        ArrayList<h> arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        ArrayList<f> arrayList2 = new ArrayList();
        List<e> a3 = com.baidu.android.pushservice.d.a.a(this.b, j, j2, 1500);
        if (a3 == null) {
            return null;
        }
        boolean z = a3.size() > i;
        Iterator<e> it = a3.iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = i3;
                break;
            }
            e next = it.next();
            if (next.a().startsWith(m.q)) {
                if (!hashMap.containsKey(next.b())) {
                    hashMap.put(next.b(), new ArrayList());
                }
                List list = (List) hashMap.get(next.b());
                if (list != null) {
                    list.add(next.e());
                }
            } else if (next.a().startsWith(m.r)) {
                if (!hashMap2.containsKey(next.b())) {
                    hashMap2.put(next.b(), new ArrayList());
                }
                List list2 = (List) hashMap2.get(next.b());
                if (list2 != null) {
                    list2.add(next.f());
                }
            } else if (next.a().startsWith(m.t)) {
                arrayList2.add(next.g());
            }
            if (z) {
                i2 = i3 + 1;
                if (i2 >= i) {
                    break;
                }
            } else {
                i2 = i3;
            }
            i3 = i2;
        }
        if (i2 < i) {
            Iterator<e> it2 = a3.iterator();
            while (true) {
                int i4 = i2;
                if (it2.hasNext()) {
                    e next2 = it2.next();
                    if (next2.a().startsWith(m.s)) {
                        arrayList.add(next2.d());
                    }
                    if (z) {
                        i2 = i4 + 1;
                        if (i2 < i) {
                        }
                    } else {
                        i2 = i4;
                    }
                }
            }
        }
        try {
            if (arrayList.size() > 0) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("app_appid", "9527");
                JSONArray jSONArray2 = new JSONArray();
                for (h hVar : arrayList) {
                    jSONArray2.put(hVar.a());
                }
                jSONObject.put("push_action", jSONArray2);
                jSONArray.put(jSONObject);
            }
            if (a2 != null) {
                for (i iVar : a2) {
                    JSONObject a4 = iVar.a(this.b);
                    JSONArray jSONArray3 = new JSONArray();
                    List<j> list3 = (List) hashMap.get(iVar.b());
                    List<b> list4 = (List) hashMap2.get(iVar.b());
                    if (list3 != null) {
                        try {
                            if (list3.size() != 0) {
                                for (j jVar : list3) {
                                    jSONArray3.put(jVar.a());
                                }
                            }
                        } catch (JSONException e) {
                            com.baidu.android.pushservice.g.a.e("StatisticProcessor", "error: JSONException");
                        }
                    }
                    if (list4 != null && list4.size() != 0) {
                        for (b bVar : list4) {
                            jSONArray3.put(bVar.a());
                        }
                    }
                    if (jSONArray3.length() > 0) {
                        a4.put("push_action", jSONArray3);
                    }
                    jSONArray.put(a4);
                }
            }
            if (arrayList2.size() > 0) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("app_appid", "9528");
                JSONArray jSONArray4 = new JSONArray();
                for (f fVar : arrayList2) {
                    jSONArray4.put(fVar.a());
                }
                jSONObject2.put("crash_info", jSONArray4);
                jSONArray.put(jSONObject2);
            }
        } catch (JSONException e2) {
            com.baidu.android.pushservice.g.a.e("StatisticProcessor", "error:" + e2.getMessage());
        }
        String jSONArray5 = jSONArray.length() == 0 ? "" : jSONArray.toString();
        com.baidu.android.pushservice.g.a.c("StatisticProcessor", "stat:" + jSONArray5);
        return jSONArray5;
    }
}
