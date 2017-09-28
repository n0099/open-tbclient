package com.baidu.adp.trafficStats;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class ITrafficStatsNativeManager extends OrmObject {
    private static volatile ITrafficStatsNativeManager EX = null;
    private static ArrayList<a> EY = new ArrayList<>();

    public abstract void a(String str, long j, long j2, String str2);

    public static ITrafficStatsNativeManager kk() {
        if (EX == null) {
            BdLog.e("trafficStatsManaer");
            EX = new ITrafficStatsNativeManager() { // from class: com.baidu.adp.trafficStats.ITrafficStatsNativeManager.1
                @Override // com.baidu.adp.trafficStats.ITrafficStatsNativeManager
                public void a(String str, long j, long j2, String str2) {
                    if (ITrafficStatsNativeManager.EY.size() < 30) {
                        ITrafficStatsNativeManager.EY.add(new a(str, j, j2, str2));
                    }
                }
            };
        }
        return EX;
    }

    public static void a(ITrafficStatsNativeManager iTrafficStatsNativeManager) {
        EX = iTrafficStatsNativeManager;
        if (EX != null) {
            Iterator<a> it = EY.iterator();
            while (it.hasNext()) {
                a next = it.next();
                EX.a(next.contentType, next.EZ, next.Fa, next.url);
            }
            EY.clear();
        }
    }

    public void c(String str, long j, long j2) {
        a(str, j, j2, null);
    }

    /* loaded from: classes.dex */
    class a {
        public long EZ;
        public long Fa;
        public String contentType;
        public String url;

        public a(String str, long j, long j2, String str2) {
            this.contentType = str;
            this.EZ = j;
            this.Fa = j2;
            this.url = str2;
        }
    }
}
