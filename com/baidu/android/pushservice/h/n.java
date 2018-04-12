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
/* loaded from: classes3.dex */
public final class n {
    private static volatile n a = null;
    private Context b;

    private n(Context context) {
        this.b = null;
        this.b = context.getApplicationContext();
        if (this.b == null) {
        }
    }

    public static n a(Context context) {
        if (a == null) {
            a = new n(context);
        }
        return a;
    }

    public String a(long j, long j2, int i) {
        JSONArray jSONArray = new JSONArray();
        List<i> a2 = com.baidu.android.pushservice.d.a.a(this.b);
        ArrayList<h> arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        ArrayList<f> arrayList2 = new ArrayList();
        List<e> a3 = com.baidu.android.pushservice.d.a.a(this.b, j, j2, TbConfig.POST_IMAGE_SMALL);
        List<e> g = com.baidu.android.pushservice.d.c.g(this.b);
        int i2 = 0;
        if (a3 == null) {
            return null;
        }
        boolean z = a3.size() > i;
        if (g != null) {
            a3.addAll(g);
        }
        Iterator<e> it = a3.iterator();
        while (true) {
            int i3 = i2;
            if (!it.hasNext()) {
                i2 = i3;
                break;
            }
            e next = it.next();
            if (next.a().startsWith(l.r)) {
                if (!hashMap.containsKey(next.b())) {
                    hashMap.put(next.b(), new ArrayList());
                }
                List list = (List) hashMap.get(next.b());
                if (list != null) {
                    list.add(next.e());
                }
            } else if (next.a().startsWith(l.s)) {
                if (!hashMap2.containsKey(next.b())) {
                    hashMap2.put(next.b(), new ArrayList());
                }
                List list2 = (List) hashMap2.get(next.b());
                if (list2 != null) {
                    list2.add(next.f());
                }
            } else if (next.a().startsWith(l.v)) {
                if (!hashMap3.containsKey(next.b())) {
                    hashMap3.put(next.b(), new ArrayList());
                }
                List list3 = (List) hashMap3.get(next.b());
                if (list3 != null) {
                    list3.add(next.h());
                }
            } else if (next.a().startsWith(l.u)) {
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
                    if (next2.a().startsWith(l.t)) {
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
                    List<j> list4 = (List) hashMap.get(iVar.b());
                    List<b> list5 = (List) hashMap2.get(iVar.b());
                    List<g> list6 = (List) hashMap3.get(iVar.b());
                    if (list4 != null) {
                        try {
                            if (list4.size() != 0) {
                                for (j jVar : list4) {
                                    jSONArray3.put(jVar.a());
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
                        for (g gVar : list6) {
                            if (gVar.j.equals(iVar.b())) {
                                jSONArray3.put(gVar.a());
                                hashMap3.remove(iVar.b());
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
                        List<g> list7 = (List) hashMap3.get(str);
                        JSONArray jSONArray4 = new JSONArray();
                        if (list7 != null) {
                            r2 = null;
                            for (g gVar2 : list7) {
                                jSONArray4.put(gVar2.a());
                            }
                        } else {
                            gVar2 = null;
                        }
                        if (gVar2 != null) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("app_type", i.b);
                            jSONObject2.put("app_package_name", gVar2.j);
                            jSONObject2.put("app_vercode", gVar2.b);
                            jSONObject2.put("app_vername", gVar2.a);
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
