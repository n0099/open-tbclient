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

    public static ITrafficStatsNativeManager ko() {
        if (FA == null) {
            BdLog.e("trafficStatsManaer");
            FA = new com.baidu.adp.trafficStats.a();
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

    public void a(String str, long j, long j2) {
        a(str, j, j2, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a {
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
