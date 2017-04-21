package com.baidu.adp.trafficStats;

import com.baidu.adp.trafficStats.ITrafficStatsNativeManager;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends ITrafficStatsNativeManager {
    @Override // com.baidu.adp.trafficStats.ITrafficStatsNativeManager
    public void a(String str, long j, long j2, String str2) {
        ArrayList arrayList;
        ArrayList arrayList2;
        arrayList = ITrafficStatsNativeManager.FB;
        if (arrayList.size() >= 30) {
            return;
        }
        arrayList2 = ITrafficStatsNativeManager.FB;
        arrayList2.add(new ITrafficStatsNativeManager.a(str, j, j2, str2));
    }
}
