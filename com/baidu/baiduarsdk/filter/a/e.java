package com.baidu.baiduarsdk.filter.a;

import com.baidu.baiduarsdk.filter.configdata.FilterData;
import java.io.Closeable;
import java.io.InputStream;
import java.util.Map;
/* loaded from: classes3.dex */
public class e implements q {
    @Override // com.baidu.baiduarsdk.filter.a.q
    public com.baidu.baiduarsdk.gpuimage.a.g a(FilterData filterData) {
        InputStream inputStream;
        com.baidu.baiduarsdk.gpuimage.a.q qVar;
        Exception e;
        if (filterData == null) {
            return null;
        }
        try {
            inputStream = com.baidu.baiduarsdk.util.a.b(filterData.d());
            if (inputStream != null) {
                try {
                    try {
                        qVar = new com.baidu.baiduarsdk.gpuimage.a.q();
                    } catch (Exception e2) {
                        qVar = null;
                        e = e2;
                    }
                    try {
                        qVar.a(inputStream);
                    } catch (Exception e3) {
                        e = e3;
                        e.printStackTrace();
                        com.baidu.baiduarsdk.util.b.a((Closeable) inputStream);
                        return qVar;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.baiduarsdk.util.b.a((Closeable) inputStream);
                    throw th;
                }
            } else {
                qVar = null;
            }
            com.baidu.baiduarsdk.util.b.a((Closeable) inputStream);
            return qVar;
        } catch (Exception e4) {
            inputStream = null;
            qVar = null;
            e = e4;
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
    }

    @Override // com.baidu.baiduarsdk.filter.a.q
    public void a(com.baidu.baiduarsdk.gpuimage.a.g gVar, Map<String, Object> map) {
    }
}
