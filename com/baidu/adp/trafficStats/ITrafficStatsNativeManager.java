package com.baidu.adp.trafficStats;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class ITrafficStatsNativeManager extends OrmObject {
    private static volatile ITrafficStatsNativeManager yI = null;
    private static ArrayList<a> yJ = new ArrayList<>();

    public abstract void a(String str, long j, long j2, String str2);

    public static ITrafficStatsNativeManager jp() {
        if (yI == null) {
            BdLog.e("trafficStatsManaer");
            yI = new com.baidu.adp.trafficStats.a();
        }
        return yI;
    }

    public static void a(ITrafficStatsNativeManager iTrafficStatsNativeManager) {
        yI = iTrafficStatsNativeManager;
        if (yI != null) {
            Iterator<a> it = yJ.iterator();
            while (it.hasNext()) {
                a next = it.next();
                yI.a(next.contentType, next.yK, next.yL, next.url);
            }
            yJ.clear();
        }
    }

    public void a(String str, long j, long j2) {
        a(str, j, j2, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a {
        public String contentType;
        public String url;
        public long yK;
        public long yL;

        public a(String str, long j, long j2, String str2) {
            this.contentType = str;
            this.yK = j;
            this.yL = j2;
            this.url = str2;
        }
    }
}
