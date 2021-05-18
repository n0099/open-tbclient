package com.baidu.mapsdkplatform.comjni.map.basemap;

import android.os.Bundle;
import android.util.LongSparseArray;
/* loaded from: classes2.dex */
public class BaseMapCallback {

    /* renamed from: a  reason: collision with root package name */
    public static LongSparseArray<b> f8030a = new LongSparseArray<>();

    public static int ReqLayerData(Bundle bundle, long j, int i2, Bundle bundle2) {
        int size = f8030a.size();
        for (int i3 = 0; i3 < size; i3++) {
            b valueAt = f8030a.valueAt(i3);
            if (valueAt != null && valueAt.a(j)) {
                return valueAt.a(bundle, j, i2, bundle2);
            }
        }
        return 0;
    }

    public static void addLayerDataInterface(long j, b bVar) {
        f8030a.put(j, bVar);
    }

    public static void removeLayerDataInterface(long j) {
        f8030a.remove(j);
    }
}
