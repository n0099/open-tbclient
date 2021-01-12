package com.baidu.mapsdkplatform.comjni.map.basemap;

import android.os.Bundle;
import android.util.LongSparseArray;
/* loaded from: classes6.dex */
public class BaseMapCallback {

    /* renamed from: a  reason: collision with root package name */
    private static LongSparseArray<b> f3170a = new LongSparseArray<>();

    public static int ReqLayerData(Bundle bundle, long j, int i, Bundle bundle2) {
        int size = f3170a.size();
        for (int i2 = 0; i2 < size; i2++) {
            b valueAt = f3170a.valueAt(i2);
            if (valueAt != null && valueAt.a(j)) {
                return valueAt.a(bundle, j, i, bundle2);
            }
        }
        return 0;
    }

    public static void addLayerDataInterface(long j, b bVar) {
        f3170a.put(j, bVar);
    }

    public static void removeLayerDataInterface(long j) {
        f3170a.remove(j);
    }
}
