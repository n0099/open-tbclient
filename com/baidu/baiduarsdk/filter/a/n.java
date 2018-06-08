package com.baidu.baiduarsdk.filter.a;

import android.text.TextUtils;
import com.baidu.baiduarsdk.filter.configdata.FilterData;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class n implements q {
    private void a(com.baidu.baiduarsdk.gpuimage.a.n nVar, float f) {
        nVar.a(f);
    }

    @Override // com.baidu.baiduarsdk.filter.a.q
    public com.baidu.baiduarsdk.gpuimage.a.g a(FilterData filterData) {
        if (filterData != null) {
            JSONObject h = filterData.h();
            float optDouble = h != null ? (float) h.optDouble("saturation", 1.0d) : 1.0f;
            com.baidu.baiduarsdk.gpuimage.a.n nVar = new com.baidu.baiduarsdk.gpuimage.a.n();
            a(nVar, optDouble);
            return nVar;
        }
        return null;
    }

    @Override // com.baidu.baiduarsdk.filter.a.q
    public void a(com.baidu.baiduarsdk.gpuimage.a.g gVar, Map<String, Object> map) {
        if (map == null || gVar == null || !(gVar instanceof com.baidu.baiduarsdk.gpuimage.a.n)) {
            return;
        }
        FilterData.AdjustType a = com.baidu.baiduarsdk.filter.d.a(map);
        String b = com.baidu.baiduarsdk.filter.d.b(map);
        String c = com.baidu.baiduarsdk.filter.d.c(map);
        try {
            if (a == FilterData.AdjustType.FLOAT && !TextUtils.isEmpty(b) && b.equals("saturation")) {
                a((com.baidu.baiduarsdk.gpuimage.a.n) gVar, Float.parseFloat(c));
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
