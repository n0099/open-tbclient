package com.baidu.baiduarsdk.filter.a;

import android.text.TextUtils;
import com.baidu.baiduarsdk.filter.configdata.FilterData;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i implements q {
    private void a(com.baidu.baiduarsdk.gpuimage.a.i iVar, float f) {
        iVar.a(f);
    }

    @Override // com.baidu.baiduarsdk.filter.a.q
    public com.baidu.baiduarsdk.gpuimage.a.g a(FilterData filterData) {
        if (filterData != null) {
            JSONObject h = filterData.h();
            float optDouble = h != null ? (float) h.optDouble("blur_radius_in_pixels", 1.0d) : 1.0f;
            com.baidu.baiduarsdk.gpuimage.a.i iVar = new com.baidu.baiduarsdk.gpuimage.a.i();
            a(iVar, optDouble);
            return iVar;
        }
        return null;
    }

    @Override // com.baidu.baiduarsdk.filter.a.q
    public void a(com.baidu.baiduarsdk.gpuimage.a.g gVar, Map<String, Object> map) {
        if (map == null || gVar == null || !(gVar instanceof com.baidu.baiduarsdk.gpuimage.a.i)) {
            return;
        }
        FilterData.AdjustType a = com.baidu.baiduarsdk.filter.d.a(map);
        String b = com.baidu.baiduarsdk.filter.d.b(map);
        String c = com.baidu.baiduarsdk.filter.d.c(map);
        try {
            if (a == FilterData.AdjustType.FLOAT && !TextUtils.isEmpty(b) && b.equals("blur_radius_in_pixels")) {
                a((com.baidu.baiduarsdk.gpuimage.a.i) gVar, Float.parseFloat(c));
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
