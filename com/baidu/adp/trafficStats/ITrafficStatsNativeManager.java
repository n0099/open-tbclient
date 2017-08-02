package com.baidu.adp.trafficStats;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class ITrafficStatsNativeManager extends OrmObject {
    private static volatile ITrafficStatsNativeManager FA = null;
    private static ArrayList<a> FB = new ArrayList<>();

    public abstract void a(String str, long j, long j2, String str2);

    public static ITrafficStatsNativeManager kk() {
        if (FA == null) {
            BdLog.e("trafficStatsManaer");
            FA = new ITrafficStatsNativeManager() { // from class: com.baidu.adp.trafficStats.ITrafficStatsNativeManager.1
                @Override // com.baidu.adp.trafficStats.ITrafficStatsNativeManager
                public void a(String str, long j, long j2, String str2) {
                    if (ITrafficStatsNativeManager.FB.size() < 30) {
                        ITrafficStatsNativeManager.FB.add(new a(str, j, j2, str2));
                    }
                }
            };
        }
        return FA;
    }

    public static void a(ITrafficStatsNativeManager iTrafficStatsNativeManager) {
        FA = iTrafficStatsNativeManager;
        if (FA != null) {
            Iterator<a> it = FB.iterator();
            while (it.hasNext()) {
                a next = it.next();
                FA.a(next.contentType, next.FC, next.FD, next.url);
            }
            FB.clear();
        }
    }

    public void c(String str, long j, long j2) {
        a(str, j, j2, null);
    }

    /* loaded from: classes.dex */
    class a {
        public long FC;
        public long FD;
        public String contentType;
        public String url;

        public a(String str, long j, long j2, String str2) {
            this.contentType = str;
            this.FC = j;
            this.FD = j2;
            this.url = str2;
        }
    }
}
