package com.baidu.android.bbalbs.common.util;

import com.baidu.android.bbalbs.common.util.DeviceId;
import java.util.Comparator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class b implements Comparator<DeviceId.a> {
    final /* synthetic */ DeviceId a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(DeviceId deviceId) {
        this.a = deviceId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(DeviceId.a aVar, DeviceId.a aVar2) {
        int i = aVar2.b - aVar.b;
        if (i == 0) {
            if (aVar.d && aVar2.d) {
                return 0;
            }
            if (aVar.d) {
                return -1;
            }
            if (aVar2.d) {
                return 1;
            }
            return i;
        }
        return i;
    }
}
