package com.baidu.baiduarsdk.filter.a;

import android.graphics.PointF;
import android.util.Log;
import com.baidu.baiduarsdk.filter.configdata.FilterData;
import com.baidu.baiduarsdk.util.MsgParamsUtil;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class g implements q {
    private void b(com.baidu.baiduarsdk.gpuimage.a.g gVar, Map<String, Object> map) {
        if (gVar != null) {
            FilterData.AdjustType a = com.baidu.baiduarsdk.filter.d.a(map);
            String b = com.baidu.baiduarsdk.filter.d.b(map);
            String c = com.baidu.baiduarsdk.filter.d.c(map);
            Log.d("bdar", "bdar:params type =" + a.a() + ", key = " + b + ", value = " + c);
            try {
                switch (a) {
                    case INT:
                        gVar.a(b, Integer.parseInt(c));
                        return;
                    case FLOAT:
                        gVar.a(b, Float.parseFloat(c));
                        return;
                    case POINT:
                        float[] str2FloatArray = MsgParamsUtil.str2FloatArray(c);
                        if (str2FloatArray == null || str2FloatArray.length < 2) {
                            return;
                        }
                        gVar.a(b, new PointF(str2FloatArray[0], str2FloatArray[1]));
                        return;
                    case VEC3:
                        float[] str2FloatArray2 = MsgParamsUtil.str2FloatArray(c);
                        if (str2FloatArray2 == null || str2FloatArray2.length < 3) {
                            return;
                        }
                        gVar.a(b, str2FloatArray2);
                        return;
                    case VEC4:
                        float[] str2FloatArray3 = MsgParamsUtil.str2FloatArray(c);
                        if (str2FloatArray3 == null || str2FloatArray3.length < 4) {
                            return;
                        }
                        gVar.b(b, str2FloatArray3);
                        return;
                    case SIZE:
                    default:
                        return;
                    case MAP:
                        HashMap<String, Object> d = com.baidu.baiduarsdk.filter.d.d(map);
                        if (d == null || d.size() == 0) {
                            return;
                        }
                        for (Object obj : d.values()) {
                            if (obj != null && (obj instanceof HashMap)) {
                                b(gVar, (HashMap) obj);
                            }
                        }
                        return;
                    case MAT3:
                        float[] str2FloatArray4 = MsgParamsUtil.str2FloatArray(c);
                        if (str2FloatArray4 == null || str2FloatArray4.length != 9) {
                            return;
                        }
                        gVar.c(b, str2FloatArray4);
                        return;
                    case MAT4:
                        float[] str2FloatArray5 = MsgParamsUtil.str2FloatArray(c);
                        if (str2FloatArray5 == null || str2FloatArray5.length != 16) {
                            return;
                        }
                        gVar.d(b, str2FloatArray5);
                        return;
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.baiduarsdk.filter.a.q
    public com.baidu.baiduarsdk.gpuimage.a.g a(FilterData filterData) {
        if (filterData != null) {
            return new com.baidu.baiduarsdk.gpuimage.a.g(com.baidu.baiduarsdk.util.a.a(filterData.e()), com.baidu.baiduarsdk.util.a.a(filterData.f()));
        }
        return null;
    }

    @Override // com.baidu.baiduarsdk.filter.a.q
    public void a(com.baidu.baiduarsdk.gpuimage.a.g gVar, Map<String, Object> map) {
        b(gVar, map);
    }
}
