package com.baidu.baiduarsdk.filter.a;

import android.text.TextUtils;
import com.baidu.baiduarsdk.filter.configdata.FilterData;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class k implements q {
    private void a(com.baidu.baiduarsdk.gpuimage.a.k kVar, float f) {
        kVar.b(f);
    }

    private void a(com.baidu.baiduarsdk.gpuimage.a.k kVar, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (str.equals("hue")) {
            try {
                a(kVar, Float.valueOf(str2).floatValue());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        } else if (str.equals("brightness")) {
            try {
                b(kVar, Float.valueOf(str2).floatValue());
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
        } else if (str.equals("saturation")) {
            try {
                c(kVar, Float.valueOf(str2).floatValue());
            } catch (NumberFormatException e3) {
                e3.printStackTrace();
            }
        }
    }

    private void b(com.baidu.baiduarsdk.gpuimage.a.k kVar, float f) {
        kVar.d(f);
    }

    private void c(com.baidu.baiduarsdk.gpuimage.a.k kVar, float f) {
        kVar.c(f);
    }

    @Override // com.baidu.baiduarsdk.filter.a.q
    public com.baidu.baiduarsdk.gpuimage.a.g a(FilterData filterData) {
        float f;
        float f2;
        float f3 = 1.0f;
        if (filterData != null) {
            JSONObject h = filterData.h();
            if (h != null) {
                f = (float) h.optDouble("hue", 0.0d);
                f2 = (float) h.optDouble("saturation", 1.0d);
                f3 = (float) h.optDouble("brightness", 1.0d);
            } else {
                f = 0.0f;
                f2 = 1.0f;
            }
            com.baidu.baiduarsdk.gpuimage.a.k kVar = new com.baidu.baiduarsdk.gpuimage.a.k();
            a(kVar, f);
            b(kVar, f3);
            c(kVar, f2);
            return kVar;
        }
        return null;
    }

    @Override // com.baidu.baiduarsdk.filter.a.q
    public void a(com.baidu.baiduarsdk.gpuimage.a.g gVar, Map<String, Object> map) {
        if (map == null || gVar == null || !(gVar instanceof com.baidu.baiduarsdk.gpuimage.a.k)) {
            return;
        }
        FilterData.AdjustType a = com.baidu.baiduarsdk.filter.d.a(map);
        String b = com.baidu.baiduarsdk.filter.d.b(map);
        try {
            switch (a) {
                case FLOAT:
                    a((com.baidu.baiduarsdk.gpuimage.a.k) gVar, b, com.baidu.baiduarsdk.filter.d.c(map));
                    return;
                case MAP:
                    HashMap<String, Object> d = com.baidu.baiduarsdk.filter.d.d(map);
                    if (d == null || d.size() == 0) {
                        return;
                    }
                    for (Object obj : d.values()) {
                        if (obj != null && (obj instanceof HashMap)) {
                            HashMap hashMap = (HashMap) obj;
                            FilterData.AdjustType a2 = com.baidu.baiduarsdk.filter.d.a(hashMap);
                            String b2 = com.baidu.baiduarsdk.filter.d.b(hashMap);
                            String c = com.baidu.baiduarsdk.filter.d.c(hashMap);
                            if (a2 == FilterData.AdjustType.FLOAT) {
                                a((com.baidu.baiduarsdk.gpuimage.a.k) gVar, b2, c);
                            }
                        }
                    }
                    return;
                default:
                    return;
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
        }
    }
}
