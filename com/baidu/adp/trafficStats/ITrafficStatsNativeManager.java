package com.baidu.adp.trafficStats;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class ITrafficStatsNativeManager extends OrmObject {
    private static volatile ITrafficStatsNativeManager EJ = null;
    private static ArrayList<a> EK = new ArrayList<>();

    public abstract void a(String str, long j, long j2, String str2);

    public static ITrafficStatsNativeManager kh() {
        if (EJ == null) {
            BdLog.e("trafficStatsManaer");
            EJ = new ITrafficStatsNativeManager() { // from class: com.baidu.adp.trafficStats.ITrafficStatsNativeManager.1
                @Override // com.baidu.adp.trafficStats.ITrafficStatsNativeManager
                public void a(String str, long j, long j2, String str2) {
                    if (ITrafficStatsNativeManager.EK.size() < 30) {
                        ITrafficStatsNativeManager.EK.add(new a(str, j, j2, str2));
                    }
                }
            };
        }
        return EJ;
    }

    public static void a(ITrafficStatsNativeManager iTrafficStatsNativeManager) {
        EJ = iTrafficStatsNativeManager;
        if (EJ != null) {
            Iterator<a> it = EK.iterator();
            while (it.hasNext()) {
                a next = it.next();
                EJ.a(next.contentType, next.EL, next.EM, next.url);
            }
            EK.clear();
        }
    }

    public void c(String str, long j, long j2) {
        a(str, j, j2, null);
    }

    /* loaded from: classes.dex */
    class a {
        public long EL;
        public long EM;
        public String contentType;
        public String url;

        public a(String str, long j, long j2, String str2) {
            this.contentType = str;
            this.EL = j;
            this.EM = j2;
            this.url = str2;
        }
    }
}
