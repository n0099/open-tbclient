package com.baidu.adp.trafficStats;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class ITrafficStatsNativeManager extends OrmObject {
    private static volatile ITrafficStatsNativeManager Hb = null;
    private static ArrayList<a> Hc = new ArrayList<>();

    public abstract void a(String str, long j, long j2, String str2);

    public static ITrafficStatsNativeManager kt() {
        if (Hb == null) {
            BdLog.e("trafficStatsManaer");
            Hb = new ITrafficStatsNativeManager() { // from class: com.baidu.adp.trafficStats.ITrafficStatsNativeManager.1
                @Override // com.baidu.adp.trafficStats.ITrafficStatsNativeManager
                public void a(String str, long j, long j2, String str2) {
                    if (ITrafficStatsNativeManager.Hc.size() < 30) {
                        ITrafficStatsNativeManager.Hc.add(new a(str, j, j2, str2));
                    }
                }
            };
        }
        return Hb;
    }

    public static void a(ITrafficStatsNativeManager iTrafficStatsNativeManager) {
        Hb = iTrafficStatsNativeManager;
        if (Hb != null) {
            Iterator<a> it = Hc.iterator();
            while (it.hasNext()) {
                a next = it.next();
                Hb.a(next.contentType, next.Hd, next.He, next.url);
            }
            Hc.clear();
        }
    }

    public void c(String str, long j, long j2) {
        a(str, j, j2, null);
    }

    /* loaded from: classes.dex */
    class a {
        public long Hd;
        public long He;
        public String contentType;
        public String url;

        public a(String str, long j, long j2, String str2) {
            this.contentType = str;
            this.Hd = j;
            this.He = j2;
            this.url = str2;
        }
    }
}
