package com.baidu.adp.trafficStats;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class ITrafficStatsNativeManager extends OrmObject {
    private static volatile ITrafficStatsNativeManager asM = null;
    private static ArrayList<a> asN = new ArrayList<>();

    public abstract void a(String str, long j, long j2, String str2);

    public static ITrafficStatsNativeManager rG() {
        if (asM == null) {
            BdLog.e("trafficStatsManaer");
            asM = new ITrafficStatsNativeManager() { // from class: com.baidu.adp.trafficStats.ITrafficStatsNativeManager.1
                @Override // com.baidu.adp.trafficStats.ITrafficStatsNativeManager
                public void a(String str, long j, long j2, String str2) {
                    if (ITrafficStatsNativeManager.asN.size() < 30) {
                        ITrafficStatsNativeManager.asN.add(new a(str, j, j2, str2));
                    }
                }
            };
        }
        return asM;
    }

    public static void a(ITrafficStatsNativeManager iTrafficStatsNativeManager) {
        asM = iTrafficStatsNativeManager;
        if (asM != null) {
            Iterator<a> it = asN.iterator();
            while (it.hasNext()) {
                a next = it.next();
                asM.a(next.contentType, next.asO, next.asP, next.url);
            }
            asN.clear();
        }
    }

    public void c(String str, long j, long j2) {
        a(str, j, j2, null);
    }

    /* loaded from: classes.dex */
    class a {
        public long asO;
        public long asP;
        public String contentType;
        public String url;

        public a(String str, long j, long j2, String str2) {
            this.contentType = str;
            this.asO = j;
            this.asP = j2;
            this.url = str2;
        }
    }
}
