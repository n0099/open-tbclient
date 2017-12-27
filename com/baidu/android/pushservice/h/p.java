package com.baidu.android.pushservice.h;

import android.content.Context;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class p {
    private static volatile p a = null;
    private Context b;

    private p(Context context) {
        this.b = null;
        this.b = context.getApplicationContext();
        if (this.b == null) {
        }
    }

    public static p a(Context context) {
        if (a == null) {
            a = new p(context);
        }
        return a;
    }

    public String a(long j, long j2, int i) {
        JSONArray jSONArray = new JSONArray();
        List<j> a2 = com.baidu.android.pushservice.d.a.a(this.b);
        ArrayList<i> arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        ArrayList<f> arrayList2 = new ArrayList();
        List<e> a3 = com.baidu.android.pushservice.d.a.a(this.b, j, j2, TbConfig.POST_IMAGE_SMALL);
        List<e> h = com.baidu.android.pushservice.d.c.h(this.b);
        int i2 = 0;
        if (a3 == null) {
            return null;
        }
        boolean z = a3.size() > i;
        if (h != null) {
            a3.addAll(h);
        }
        Iterator<e> it = a3.iterator();
        while (true) {
            int i3 = i2;
            if (!it.hasNext()) {
                i2 = i3;
                break;
            }
            e next = it.next();
            if (next.a().startsWith(n.r)) {
                if (!hashMap.containsKey(next.b())) {
                    hashMap.put(next.b(), new ArrayList());
                }
                List list = (List) hashMap.get(next.b());
                if (list != null) {
                    list.add(next.e());
                }
            } else if (next.a().startsWith(n.s)) {
                if (!hashMap2.containsKey(next.b())) {
                    hashMap2.put(next.b(), new ArrayList());
                }
                List list2 = (List) hashMap2.get(next.b());
                if (list2 != null) {
                    list2.add(next.f());
                }
            } else if (next.a().startsWith(n.v)) {
                if (!hashMap3.containsKey(next.b())) {
                    hashMap3.put(next.b(), new ArrayList());
                }
                List list3 = (List) hashMap3.get(next.b());
                if (list3 != null) {
                    list3.add(next.h());
                }
            } else if (next.a().startsWith(n.u)) {
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
        }
        if (i2 < i) {
            Iterator<e> it2 = a3.iterator();
            while (true) {
                int i4 = i2;
                if (it2.hasNext()) {
                    e next2 = it2.next();
                    if (next2.a().startsWith(n.t)) {
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
                for (i iVar : arrayList) {
                    jSONArray2.put(iVar.a());
                }
                jSONObject.put("push_action", jSONArray2);
                jSONArray.put(jSONObject);
            }
            if (a2 != null) {
                for (j jVar : a2) {
                    JSONObject a4 = jVar.a(this.b);
                    JSONArray jSONArray3 = new JSONArray();
                    List<k> list4 = (List) hashMap.get(jVar.b());
                    List<b> list5 = (List) hashMap2.get(jVar.b());
                    List<h> list6 = (List) hashMap3.get(jVar.b());
                    if (list4 != null) {
                        try {
                            if (list4.size() != 0) {
                                for (k kVar : list4) {
                                    jSONArray3.put(kVar.a());
                                }
                            }
                        } catch (JSONException e) {
                        }
                    }
                    if (list5 != null && list5.size() != 0) {
                        for (b bVar : list5) {
                            jSONArray3.put(bVar.a());
                        }
                    }
                    if (list6 != null) {
                        for (h hVar : list6) {
                            if (hVar.j.equals(jVar.b())) {
                                jSONArray3.put(hVar.a());
                                hashMap3.remove(jVar.b());
                            }
                        }
                    }
                    if (jSONArray3.length() > 0) {
                        a4.put("push_action", jSONArray3);
                    }
                    jSONArray.put(a4);
                }
                for (String str : hashMap3.keySet()) {
                    try {
                        List<h> list7 = (List) hashMap3.get(str);
                        JSONArray jSONArray4 = new JSONArray();
                        if (list7 != null) {
                            r2 = null;
                            for (h hVar2 : list7) {
                                jSONArray4.put(hVar2.a());
                            }
                        } else {
                            hVar2 = null;
                        }
                        if (hVar2 != null) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("app_type", j.b);
                            jSONObject2.put("app_package_name", hVar2.j);
                            jSONObject2.put("app_vercode", hVar2.b);
                            jSONObject2.put("app_vername", hVar2.a);
                            if (jSONArray4.length() > 0) {
                                jSONObject2.put("push_action", jSONArray4);
                            }
                            jSONArray.put(jSONObject2);
                        }
                    } catch (Exception e2) {
                    }
                }
            }
            if (arrayList2.size() > 0) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("app_appid", "9528");
                JSONArray jSONArray5 = new JSONArray();
                for (f fVar : arrayList2) {
                    jSONArray5.put(fVar.a());
                }
                jSONObject3.put("crash_info", jSONArray5);
                jSONArray.put(jSONObject3);
            }
        } catch (JSONException e3) {
        }
        return jSONArray.length() == 0 ? "" : jSONArray.toString();
    }
}
