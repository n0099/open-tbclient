package com.baidu.adp.trafficStats;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class ITrafficStatsNativeManager extends OrmObject {
    private static volatile ITrafficStatsNativeManager EI = null;
    private static ArrayList<a> EJ = new ArrayList<>();

    public abstract void a(String str, long j, long j2, String str2);

    public static ITrafficStatsNativeManager kh() {
        if (EI == null) {
            BdLog.e("trafficStatsManaer");
            EI = new ITrafficStatsNativeManager() { // from class: com.baidu.adp.trafficStats.ITrafficStatsNativeManager.1
                @Override // com.baidu.adp.trafficStats.ITrafficStatsNativeManager
                public void a(String str, long j, long j2, String str2) {
                    if (ITrafficStatsNativeManager.EJ.size() < 30) {
                        ITrafficStatsNativeManager.EJ.add(new a(str, j, j2, str2));
                    }
                }
            };
        }
        return EI;
    }

    public static void a(ITrafficStatsNativeManager iTrafficStatsNativeManager) {
        EI = iTrafficStatsNativeManager;
        if (EI != null) {
            Iterator<a> it = EJ.iterator();
            while (it.hasNext()) {
                a next = it.next();
                EI.a(next.contentType, next.EK, next.EL, next.url);
            }
            EJ.clear();
        }
    }

    public void c(String str, long j, long j2) {
        a(str, j, j2, null);
    }

    /* loaded from: classes.dex */
    class a {
        public long EK;
        public long EL;
        public String contentType;
        public String url;

        public a(String str, long j, long j2, String str2) {
            this.contentType = str;
            this.EK = j;
            this.EL = j2;
            this.url = str2;
        }
    }
}
