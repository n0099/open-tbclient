package com.baidu.baiduarsdk.filter.a;

import android.text.TextUtils;
import com.baidu.baiduarsdk.filter.configdata.FilterData;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class m implements q {
    @Override // com.baidu.baiduarsdk.filter.a.q
    public com.baidu.baiduarsdk.gpuimage.a.g a(FilterData filterData) {
        if (filterData != null) {
            List<String> g = filterData.g();
            String a = com.baidu.baiduarsdk.util.a.a(filterData.f());
            String[] strArr = g != null ? new String[g.size()] : null;
            if (strArr != null) {
                g.toArray(strArr);
            }
            if (g == null || g.size() == 0 || TextUtils.isEmpty(a)) {
                return null;
            }
            return new com.baidu.baiduarsdk.gpuimage.b.a(strArr, a);
        }
        return null;
    }

    @Override // com.baidu.baiduarsdk.filter.a.q
    public void a(com.baidu.baiduarsdk.gpuimage.a.g gVar, Map<String, Object> map) {
    }
}
