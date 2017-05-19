package com.baidu.android.pushservice.f;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class o {
    private static final String a = o.class.getSimpleName();
    private static volatile o b = null;
    private Context c;

    private o(Context context) {
        this.c = null;
        this.c = context.getApplicationContext();
        if (this.c == null) {
            com.baidu.android.pushservice.e.a.e(a, "Error occurs with mContext");
        }
    }

    public static o a(Context context) {
        if (b == null) {
            b = new o(context);
        }
        com.baidu.android.pushservice.e.a.c(a, "Current packet name: " + context.getPackageName());
        return b;
    }

    public String a(long j, long j2, int i, int i2) {
        JSONArray jSONArray = new JSONArray();
        List<i> a2 = com.baidu.android.pushservice.h.o.a(this.c);
        ArrayList<h> arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        ArrayList<f> arrayList2 = new ArrayList();
        List<e> a3 = com.baidu.android.pushservice.h.o.a(this.c, j, j2, i, i2);
        if (a3 != null) {
            for (e eVar : a3) {
                if (eVar.a().startsWith(m.s)) {
                    arrayList.add(eVar.d());
                } else if (eVar.a().startsWith(m.q)) {
                    if (!hashMap.containsKey(eVar.b())) {
                        hashMap.put(eVar.b(), new ArrayList());
                    }
                    List list = (List) hashMap.get(eVar.b());
                    if (list != null) {
                        list.add(eVar.e());
                    }
                } else if (eVar.a().startsWith(m.r)) {
                    if (!hashMap2.containsKey(eVar.b())) {
                        hashMap2.put(eVar.b(), new ArrayList());
                    }
                    List list2 = (List) hashMap2.get(eVar.b());
                    if (list2 != null) {
                        list2.add(eVar.f());
                    }
                } else if (eVar.a().startsWith(m.t)) {
                    arrayList2.add(eVar.g());
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
                    JSONObject a4 = iVar.a(this.c);
                    JSONArray jSONArray3 = new JSONArray();
                    List<j> list3 = (List) hashMap.get(iVar.a());
                    List<b> list4 = (List) hashMap2.get(iVar.a());
                    if (list3 != null) {
                        try {
                            if (list3.size() != 0) {
                                for (j jVar : list3) {
                                    jSONArray3.put(jVar.a());
                                }
                            }
                        } catch (JSONException e) {
                            com.baidu.android.pushservice.e.a.e(a, "error: JSONException");
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
            if (arrayList2 != null && arrayList2.size() > 0) {
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
            com.baidu.android.pushservice.e.a.e(a, "error:" + e2.getMessage());
        }
        String jSONArray5 = jSONArray.length() == 0 ? "" : jSONArray.toString();
        com.baidu.android.pushservice.e.a.c(a, "stat:" + jSONArray5);
        return jSONArray5;
    }
}
