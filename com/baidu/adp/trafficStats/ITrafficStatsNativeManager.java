package com.baidu.adp.trafficStats;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class ITrafficStatsNativeManager extends OrmObject {
    private static volatile ITrafficStatsNativeManager FW = null;
    private static ArrayList<a> FX = new ArrayList<>();

    public abstract void a(String str, long j, long j2, String str2);

    public static ITrafficStatsNativeManager kj() {
        if (FW == null) {
            BdLog.e("trafficStatsManaer");
            FW = new com.baidu.adp.trafficStats.a();
        }
        return FW;
    }

    public static void a(ITrafficStatsNativeManager iTrafficStatsNativeManager) {
        FW = iTrafficStatsNativeManager;
        if (FW != null) {
            Iterator<a> it = FX.iterator();
            while (it.hasNext()) {
                a next = it.next();
                FW.a(next.contentType, next.FY, next.FZ, next.url);
            }
            FX.clear();
        }
    }

    public void a(String str, long j, long j2) {
        a(str, j, j2, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a {
        public long FY;
        public long FZ;
        public String contentType;
        public String url;

        public a(String str, long j, long j2, String str2) {
            this.contentType = str;
            this.FY = j;
            this.FZ = j2;
            this.url = str2;
        }
    }
}
