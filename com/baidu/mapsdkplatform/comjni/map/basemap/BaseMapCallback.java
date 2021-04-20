package com.baidu.mapsdkplatform.comjni.map.basemap;

import android.os.Bundle;
import android.util.LongSparseArray;
/* loaded from: classes2.dex */
public class BaseMapCallback {

    /* renamed from: a  reason: collision with root package name */
    public static LongSparseArray<b> f7931a = new LongSparseArray<>();

    public static int ReqLayerData(Bundle bundle, long j, int i, Bundle bundle2) {
        int size = f7931a.size();
        for (int i2 = 0; i2 < size; i2++) {
            b valueAt = f7931a.valueAt(i2);
            if (valueAt != null && valueAt.a(j)) {
                return valueAt.a(bundle, j, i, bundle2);
            }
        }
        return 0;
    }

    public static void addLayerDataInterface(long j, b bVar) {
        f7931a.put(j, bVar);
    }

    public static void removeLayerDataInterface(long j) {
        f7931a.remove(j);
    }
}
