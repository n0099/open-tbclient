package com.baidu.adp.trafficStats;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class ITrafficStatsNativeManager extends OrmObject {
    private static volatile ITrafficStatsNativeManager GZ = null;
    private static ArrayList<a> Ha = new ArrayList<>();

    public abstract void a(String str, long j, long j2, String str2);

    public static ITrafficStatsNativeManager ku() {
        if (GZ == null) {
            BdLog.e("trafficStatsManaer");
            GZ = new ITrafficStatsNativeManager() { // from class: com.baidu.adp.trafficStats.ITrafficStatsNativeManager.1
                @Override // com.baidu.adp.trafficStats.ITrafficStatsNativeManager
                public void a(String str, long j, long j2, String str2) {
                    if (ITrafficStatsNativeManager.Ha.size() < 30) {
                        ITrafficStatsNativeManager.Ha.add(new a(str, j, j2, str2));
                    }
                }
            };
        }
        return GZ;
    }

    public static void a(ITrafficStatsNativeManager iTrafficStatsNativeManager) {
        GZ = iTrafficStatsNativeManager;
        if (GZ != null) {
            Iterator<a> it = Ha.iterator();
            while (it.hasNext()) {
                a next = it.next();
                GZ.a(next.contentType, next.Hb, next.Hc, next.url);
            }
            Ha.clear();
        }
    }

    public void c(String str, long j, long j2) {
        a(str, j, j2, null);
    }

    /* loaded from: classes.dex */
    class a {
        public long Hb;
        public long Hc;
        public String contentType;
        public String url;

        public a(String str, long j, long j2, String str2) {
            this.contentType = str;
            this.Hb = j;
            this.Hc = j2;
            this.url = str2;
        }
    }
}
