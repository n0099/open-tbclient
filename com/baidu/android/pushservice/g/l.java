package com.baidu.android.pushservice.g;

import android.content.Context;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class l {
    private static volatile l a = null;
    private Context b;

    private l(Context context) {
        this.b = null;
        this.b = context.getApplicationContext();
        if (this.b == null) {
        }
    }

    public static l a(Context context) {
        if (a == null) {
            a = new l(context);
        }
        return a;
    }

    public String a(long j, long j2, int i) {
        int i2;
        JSONArray jSONArray = new JSONArray();
        List<g> a2 = com.baidu.android.pushservice.c.a.a(this.b);
        ArrayList<f> arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        ArrayList<e> arrayList2 = new ArrayList();
        List<d> a3 = com.baidu.android.pushservice.c.a.a(this.b, j, j2, TbConfig.POST_IMAGE_SMALL);
        if (a3 == null) {
            return null;
        }
        boolean z = a3.size() > i;
        Iterator<d> it = a3.iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = i3;
                break;
            }
            d next = it.next();
            if (next.a().startsWith(j.r)) {
                if (!hashMap.containsKey(next.b())) {
                    hashMap.put(next.b(), new ArrayList());
                }
                List list = (List) hashMap.get(next.b());
                if (list != null) {
                    list.add(next.e());
                }
            } else if (next.a().startsWith(j.s)) {
                if (!hashMap2.containsKey(next.b())) {
                    hashMap2.put(next.b(), new ArrayList());
                }
                List list2 = (List) hashMap2.get(next.b());
                if (list2 != null) {
                    list2.add(next.f());
                }
            } else if (next.a().startsWith(j.u)) {
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
            Iterator<d> it2 = a3.iterator();
            while (true) {
                int i4 = i2;
                if (it2.hasNext()) {
                    d next2 = it2.next();
                    if (next2.a().startsWith(j.t)) {
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
                for (f fVar : arrayList) {
                    jSONArray2.put(fVar.a());
                }
                jSONObject.put("push_action", jSONArray2);
                jSONArray.put(jSONObject);
            }
            if (a2 != null) {
                for (g gVar : a2) {
                    JSONObject a4 = gVar.a(this.b);
                    JSONArray jSONArray3 = new JSONArray();
                    List<h> list3 = (List) hashMap.get(gVar.b());
                    List<a> list4 = (List) hashMap2.get(gVar.b());
                    if (list3 != null) {
                        try {
                            if (list3.size() != 0) {
                                for (h hVar : list3) {
                                    jSONArray3.put(hVar.a());
                                }
                            }
                        } catch (JSONException e) {
                        }
                    }
                    if (list4 != null && list4.size() != 0) {
                        for (a aVar : list4) {
                            jSONArray3.put(aVar.a());
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
                for (e eVar : arrayList2) {
                    jSONArray4.put(eVar.a());
                }
                jSONObject2.put("crash_info", jSONArray4);
                jSONArray.put(jSONObject2);
            }
        } catch (JSONException e2) {
        }
        return jSONArray.length() == 0 ? "" : jSONArray.toString();
    }
}
