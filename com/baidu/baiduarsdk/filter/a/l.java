package com.baidu.baiduarsdk.filter.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.baidu.baiduarsdk.filter.configdata.FilterData;
import java.util.Map;
/* loaded from: classes3.dex */
public class l implements q {
    @Override // com.baidu.baiduarsdk.filter.a.q
    public com.baidu.baiduarsdk.gpuimage.a.g a(FilterData filterData) {
        Bitmap decodeFile;
        if (filterData != null) {
            String d = filterData.d();
            float optDouble = filterData.h() != null ? (float) filterData.h().optDouble("dimension", 64.0d) : 64.0f;
            if (!TextUtils.isEmpty(d) && (decodeFile = BitmapFactory.decodeFile(d)) != null && !decodeFile.isRecycled()) {
                com.baidu.baiduarsdk.gpuimage.a.l lVar = new com.baidu.baiduarsdk.gpuimage.a.l();
                lVar.a(decodeFile);
                lVar.a(optDouble);
                return lVar;
            }
        }
        return null;
    }

    @Override // com.baidu.baiduarsdk.filter.a.q
    public void a(com.baidu.baiduarsdk.gpuimage.a.g gVar, Map<String, Object> map) {
        Object obj;
        if (map == null || gVar == null || !(gVar instanceof com.baidu.baiduarsdk.gpuimage.a.l) || (obj = map.get("dimension")) == null) {
            return;
        }
        if (!(obj instanceof String)) {
            if (obj instanceof Float) {
                ((com.baidu.baiduarsdk.gpuimage.a.l) gVar).a(((Float) obj).floatValue());
                return;
            }
            return;
        }
        try {
            ((com.baidu.baiduarsdk.gpuimage.a.l) gVar).a(Float.valueOf((String) obj).floatValue());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
