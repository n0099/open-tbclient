package com.baidu.platform.comjni.map.basemap;

import android.os.Bundle;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class BaseMapCallback {

    /* renamed from: a  reason: collision with root package name */
    private static final ConcurrentHashMap<Long, a> f4721a = new ConcurrentHashMap<>(2);

    /* renamed from: b  reason: collision with root package name */
    private static final ConcurrentHashMap<Long, com.baidu.mapsdkplatform.comjni.a.a.a> f4722b = new ConcurrentHashMap<>(2);

    public static void release(long j) {
        f4721a.remove(Long.valueOf(j));
        f4722b.remove(Long.valueOf(j));
    }

    public static int reqLayerData(Bundle bundle, long j, int i) {
        if (f4721a.isEmpty()) {
            return 0;
        }
        for (Map.Entry<Long, a> entry : f4721a.entrySet()) {
            a value = entry.getValue();
            if (value != null && value.a(j)) {
                return value.a(bundle, j, i);
            }
        }
        for (Map.Entry<Long, com.baidu.mapsdkplatform.comjni.a.a.a> entry2 : f4722b.entrySet()) {
            com.baidu.mapsdkplatform.comjni.a.a.a value2 = entry2.getValue();
            if (value2 != null && value2.a(j)) {
                return value2.a(bundle, j, i);
            }
        }
        return 0;
    }

    public static boolean setMapCallback(long j, a aVar) {
        if (aVar == null || j == 0) {
            return false;
        }
        f4721a.put(Long.valueOf(j), aVar);
        return true;
    }

    public static boolean setMapSDKCallback(long j, com.baidu.mapsdkplatform.comjni.a.a.a aVar) {
        if (aVar == null || j == 0) {
            return false;
        }
        f4722b.put(Long.valueOf(j), aVar);
        return true;
    }
}
