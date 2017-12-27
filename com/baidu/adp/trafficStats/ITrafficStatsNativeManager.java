package com.baidu.adp.trafficStats;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class ITrafficStatsNativeManager extends OrmObject {
    private static volatile ITrafficStatsNativeManager asN = null;
    private static ArrayList<a> asO = new ArrayList<>();

    public abstract void a(String str, long j, long j2, String str2);

    public static ITrafficStatsNativeManager rG() {
        if (asN == null) {
            BdLog.e("trafficStatsManaer");
            asN = new ITrafficStatsNativeManager() { // from class: com.baidu.adp.trafficStats.ITrafficStatsNativeManager.1
                @Override // com.baidu.adp.trafficStats.ITrafficStatsNativeManager
                public void a(String str, long j, long j2, String str2) {
                    if (ITrafficStatsNativeManager.asO.size() < 30) {
                        ITrafficStatsNativeManager.asO.add(new a(str, j, j2, str2));
                    }
                }
            };
        }
        return asN;
    }

    public static void a(ITrafficStatsNativeManager iTrafficStatsNativeManager) {
        asN = iTrafficStatsNativeManager;
        if (asN != null) {
            Iterator<a> it = asO.iterator();
            while (it.hasNext()) {
                a next = it.next();
                asN.a(next.contentType, next.asP, next.asQ, next.url);
            }
            asO.clear();
        }
    }

    public void c(String str, long j, long j2) {
        a(str, j, j2, null);
    }

    /* loaded from: classes.dex */
    class a {
        public long asP;
        public long asQ;
        public String contentType;
        public String url;

        public a(String str, long j, long j2, String str2) {
            this.contentType = str;
            this.asP = j;
            this.asQ = j2;
            this.url = str2;
        }
    }
}
