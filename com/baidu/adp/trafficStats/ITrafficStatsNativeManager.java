package com.baidu.adp.trafficStats;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class ITrafficStatsNativeManager extends OrmObject {
    private static volatile ITrafficStatsNativeManager EY = null;
    private static ArrayList<a> EZ = new ArrayList<>();

    public abstract void a(String str, long j, long j2, String str2);

    public static ITrafficStatsNativeManager kk() {
        if (EY == null) {
            BdLog.e("trafficStatsManaer");
            EY = new ITrafficStatsNativeManager() { // from class: com.baidu.adp.trafficStats.ITrafficStatsNativeManager.1
                @Override // com.baidu.adp.trafficStats.ITrafficStatsNativeManager
                public void a(String str, long j, long j2, String str2) {
                    if (ITrafficStatsNativeManager.EZ.size() < 30) {
                        ITrafficStatsNativeManager.EZ.add(new a(str, j, j2, str2));
                    }
                }
            };
        }
        return EY;
    }

    public static void a(ITrafficStatsNativeManager iTrafficStatsNativeManager) {
        EY = iTrafficStatsNativeManager;
        if (EY != null) {
            Iterator<a> it = EZ.iterator();
            while (it.hasNext()) {
                a next = it.next();
                EY.a(next.contentType, next.Fa, next.Fb, next.url);
            }
            EZ.clear();
        }
    }

    public void c(String str, long j, long j2) {
        a(str, j, j2, null);
    }

    /* loaded from: classes.dex */
    class a {
        public long Fa;
        public long Fb;
        public String contentType;
        public String url;

        public a(String str, long j, long j2, String str2) {
            this.contentType = str;
            this.Fa = j;
            this.Fb = j2;
            this.url = str2;
        }
    }
}
