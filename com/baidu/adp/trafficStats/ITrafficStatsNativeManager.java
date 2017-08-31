package com.baidu.adp.trafficStats;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class ITrafficStatsNativeManager extends OrmObject {
    private static volatile ITrafficStatsNativeManager EV = null;
    private static ArrayList<a> EW = new ArrayList<>();

    public abstract void a(String str, long j, long j2, String str2);

    public static ITrafficStatsNativeManager kl() {
        if (EV == null) {
            BdLog.e("trafficStatsManaer");
            EV = new ITrafficStatsNativeManager() { // from class: com.baidu.adp.trafficStats.ITrafficStatsNativeManager.1
                @Override // com.baidu.adp.trafficStats.ITrafficStatsNativeManager
                public void a(String str, long j, long j2, String str2) {
                    if (ITrafficStatsNativeManager.EW.size() < 30) {
                        ITrafficStatsNativeManager.EW.add(new a(str, j, j2, str2));
                    }
                }
            };
        }
        return EV;
    }

    public static void a(ITrafficStatsNativeManager iTrafficStatsNativeManager) {
        EV = iTrafficStatsNativeManager;
        if (EV != null) {
            Iterator<a> it = EW.iterator();
            while (it.hasNext()) {
                a next = it.next();
                EV.a(next.contentType, next.EX, next.EY, next.url);
            }
            EW.clear();
        }
    }

    public void c(String str, long j, long j2) {
        a(str, j, j2, null);
    }

    /* loaded from: classes.dex */
    class a {
        public long EX;
        public long EY;
        public String contentType;
        public String url;

        public a(String str, long j, long j2, String str2) {
            this.contentType = str;
            this.EX = j;
            this.EY = j2;
            this.url = str2;
        }
    }
}
