package com.baidu.baiduarsdk.filter.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.baiduarsdk.filter.configdata.FilterData;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements q {
    private void a(com.baidu.baiduarsdk.gpuimage.a.a aVar, float f) {
        aVar.a(f);
    }

    @Override // com.baidu.baiduarsdk.filter.a.q
    public com.baidu.baiduarsdk.gpuimage.a.g a(FilterData filterData) {
        if (filterData != null) {
            JSONObject h = filterData.h();
            float optDouble = h != null ? (float) h.optDouble("brightness", 0.0d) : 0.0f;
            com.baidu.baiduarsdk.gpuimage.a.a aVar = new com.baidu.baiduarsdk.gpuimage.a.a();
            a(aVar, optDouble);
            return aVar;
        }
        return null;
    }

    @Override // com.baidu.baiduarsdk.filter.a.q
    public void a(com.baidu.baiduarsdk.gpuimage.a.g gVar, Map<String, Object> map) {
        if (map == null || gVar == null || !(gVar instanceof com.baidu.baiduarsdk.gpuimage.a.a)) {
            return;
        }
        FilterData.AdjustType a = com.baidu.baiduarsdk.filter.d.a(map);
        String b = com.baidu.baiduarsdk.filter.d.b(map);
        String c = com.baidu.baiduarsdk.filter.d.c(map);
        Log.d("bdar", "bdar:params type =" + a.a() + ", key = " + b + ", value = " + c);
        try {
            if (a == FilterData.AdjustType.FLOAT && !TextUtils.isEmpty(b) && b.equals("brightness")) {
                a((com.baidu.baiduarsdk.gpuimage.a.a) gVar, Float.parseFloat(c));
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
