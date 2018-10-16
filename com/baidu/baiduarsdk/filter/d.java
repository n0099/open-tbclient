package com.baidu.baiduarsdk.filter;

import android.text.TextUtils;
import com.baidu.baiduarsdk.filter.a.p;
import com.baidu.baiduarsdk.filter.a.q;
import com.baidu.baiduarsdk.filter.configdata.FilterData;
import com.baidu.baiduarsdk.gpuimage.a.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class d {
    public static FilterData.AdjustType a(Map<String, Object> map) {
        Object obj;
        return (map == null || (obj = map.get("adjust_value_type")) == null || !(obj instanceof Integer)) ? FilterData.AdjustType.NONE : FilterData.AdjustType.a(((Integer) obj).intValue());
    }

    private static com.baidu.baiduarsdk.filter.configdata.a a(String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("filter_group_id", -1);
            com.baidu.baiduarsdk.filter.configdata.a aVar = new com.baidu.baiduarsdk.filter.configdata.a();
            aVar.a(str);
            aVar.a(optInt);
            aVar.a(jSONObject.optInt("disable_filter_group", 0) == 0);
            aVar.a(b(str, jSONObject.optJSONObject("reality_target")));
            aVar.b(b(str, jSONObject.optJSONObject("virtual_target")));
            aVar.c(b(str, jSONObject.optJSONObject("mix_target")));
            return aVar;
        }
        return null;
    }

    public static com.baidu.baiduarsdk.filter.configdata.c a(String str, String str2) {
        com.baidu.baiduarsdk.filter.configdata.c cVar;
        JSONException e;
        try {
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str2);
            cVar = new com.baidu.baiduarsdk.filter.configdata.c();
            try {
                cVar.a(jSONObject.optInt("start_filter_group_id", -1));
                JSONArray optJSONArray = jSONObject.optJSONArray("filter_group_set");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    HashMap hashMap = new HashMap();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        com.baidu.baiduarsdk.filter.configdata.a a = a(str, optJSONArray.optJSONObject(i));
                        if (a != null) {
                            hashMap.put(Integer.valueOf(a.b()), a);
                        }
                    }
                    cVar.a(hashMap);
                }
                cVar.a(str);
                return cVar;
            } catch (JSONException e2) {
                e = e2;
                e.printStackTrace();
                return cVar;
            }
        } catch (JSONException e3) {
            cVar = null;
            e = e3;
        }
    }

    public static Map<Integer, a> a(List<com.baidu.baiduarsdk.filter.configdata.a> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (com.baidu.baiduarsdk.filter.configdata.a aVar : list) {
            if (aVar != null) {
                a aVar2 = new a();
                aVar2.a(aVar.a());
                aVar2.a(aVar.c());
                aVar2.a(aVar.b());
                com.baidu.baiduarsdk.filter.configdata.b d = aVar.d();
                if (d != null) {
                    aVar2.b(d.a());
                    HashMap hashMap2 = new HashMap();
                    aVar2.d(a(hashMap2, d));
                    aVar2.a(hashMap2);
                }
                com.baidu.baiduarsdk.filter.configdata.b e = aVar.e();
                if (e != null) {
                    aVar2.c(e.a());
                    HashMap hashMap3 = new HashMap();
                    aVar2.e(a(hashMap3, e));
                    aVar2.b(hashMap3);
                }
                com.baidu.baiduarsdk.filter.configdata.b f = aVar.f();
                if (f != null) {
                    aVar2.d(f.a());
                    HashMap hashMap4 = new HashMap();
                    aVar2.f(a(hashMap4, f));
                    aVar2.c(hashMap4);
                }
                hashMap.put(Integer.valueOf(aVar2.b()), aVar2);
            }
        }
        return hashMap;
    }

    public static Map<Integer, g> a(Map<Integer, FilterData> map, com.baidu.baiduarsdk.filter.configdata.b bVar) {
        g a;
        HashMap hashMap = new HashMap();
        if (bVar == null || bVar.b() == null || bVar.b().size() == 0) {
            return hashMap;
        }
        HashMap hashMap2 = new HashMap();
        List<FilterData> b = bVar.b();
        int size = b.size();
        for (int i = 0; i < size; i++) {
            FilterData filterData = b.get(i);
            q a2 = p.a(filterData);
            if (a2 != null && (a = a2.a(filterData)) != null) {
                hashMap2.put(Integer.valueOf(filterData.a()), a);
                map.put(Integer.valueOf(filterData.a()), filterData);
            }
        }
        return hashMap2;
    }

    private static com.baidu.baiduarsdk.filter.configdata.b b(String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            com.baidu.baiduarsdk.filter.configdata.b bVar = new com.baidu.baiduarsdk.filter.configdata.b();
            bVar.a(jSONObject.optInt("disable_pass_list", 0) == 0);
            JSONArray optJSONArray = jSONObject.optJSONArray("pass_list");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    FilterData c = c(str, optJSONArray.optJSONObject(i));
                    if (c != null) {
                        arrayList.add(c);
                    }
                }
                bVar.a(arrayList);
            }
            return bVar;
        }
        return null;
    }

    public static String b(Map<String, Object> map) {
        Object obj;
        if (map == null || (obj = map.get("adjust_key")) == null || !(obj instanceof String)) {
            return null;
        }
        return (String) obj;
    }

    private static FilterData c(String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("source_file");
            String optString2 = jSONObject.optString("vertex_shader");
            String optString3 = jSONObject.optString("fragment_shader");
            FilterData filterData = new FilterData();
            filterData.a(jSONObject.optInt("pass_id"));
            filterData.a(FilterData.PassType.a(jSONObject.optString("pass_type")));
            filterData.a(FilterData.PassSubType.a(jSONObject.optString("sub_type")));
            if (!TextUtils.isEmpty(optString)) {
                filterData.a(str != null ? str.concat(optString) : null);
            }
            if (!TextUtils.isEmpty(optString2)) {
                filterData.b(str != null ? str.concat(optString2) : null);
            }
            if (!TextUtils.isEmpty(optString3)) {
                filterData.c(str != null ? str.concat(optString3) : null);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("multi_source_files");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    String optString4 = optJSONArray.optString(i);
                    if (!TextUtils.isEmpty(optString4)) {
                        arrayList.add(str != null ? str.concat(optString4) : null);
                    }
                }
                filterData.a(arrayList);
            }
            filterData.a(jSONObject.optJSONObject("params"));
            return filterData;
        }
        return null;
    }

    public static String c(Map<String, Object> map) {
        Object obj;
        if (map == null || (obj = map.get("adjust_value")) == null || !(obj instanceof String)) {
            return null;
        }
        return (String) obj;
    }

    public static HashMap<String, Object> d(Map<String, Object> map) {
        Object obj;
        if (map == null || (obj = map.get("adjust_value")) == null || !(obj instanceof HashMap)) {
            return null;
        }
        return (HashMap) obj;
    }
}
