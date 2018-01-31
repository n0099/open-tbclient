package com.baidu.adp.trafficStats;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class ITrafficStatsNativeManager extends OrmObject {
    private static volatile ITrafficStatsNativeManager asP = null;
    private static ArrayList<a> asQ = new ArrayList<>();

    public abstract void a(String str, long j, long j2, String str2);

    public static ITrafficStatsNativeManager rH() {
        if (asP == null) {
            BdLog.e("trafficStatsManaer");
            asP = new ITrafficStatsNativeManager() { // from class: com.baidu.adp.trafficStats.ITrafficStatsNativeManager.1
                @Override // com.baidu.adp.trafficStats.ITrafficStatsNativeManager
                public void a(String str, long j, long j2, String str2) {
                    if (ITrafficStatsNativeManager.asQ.size() < 30) {
                        ITrafficStatsNativeManager.asQ.add(new a(str, j, j2, str2));
                    }
                }
            };
        }
        return asP;
    }

    public static void a(ITrafficStatsNativeManager iTrafficStatsNativeManager) {
        asP = iTrafficStatsNativeManager;
        if (asP != null) {
            Iterator<a> it = asQ.iterator();
            while (it.hasNext()) {
                a next = it.next();
                asP.a(next.contentType, next.asR, next.asS, next.url);
            }
            asQ.clear();
        }
    }

    public void c(String str, long j, long j2) {
        a(str, j, j2, null);
    }

    /* loaded from: classes.dex */
    class a {
        public long asR;
        public long asS;
        public String contentType;
        public String url;

        public a(String str, long j, long j2, String str2) {
            this.contentType = str;
            this.asR = j;
            this.asS = j2;
            this.url = str2;
        }
    }
}
