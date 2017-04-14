package com.baidu.adp.trafficStats;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class ITrafficStatsNativeManager extends OrmObject {
    private static volatile ITrafficStatsNativeManager Fx = null;
    private static ArrayList<a> Fy = new ArrayList<>();

    public abstract void a(String str, long j, long j2, String str2);

    public static ITrafficStatsNativeManager kn() {
        if (Fx == null) {
            BdLog.e("trafficStatsManaer");
            Fx = new com.baidu.adp.trafficStats.a();
        }
        return Fx;
    }

    public static void a(ITrafficStatsNativeManager iTrafficStatsNativeManager) {
        Fx = iTrafficStatsNativeManager;
        if (Fx != null) {
            Iterator<a> it = Fy.iterator();
            while (it.hasNext()) {
                a next = it.next();
                Fx.a(next.contentType, next.Fz, next.FA, next.url);
            }
            Fy.clear();
        }
    }

    public void a(String str, long j, long j2) {
        a(str, j, j2, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a {
        public long FA;
        public long Fz;
        public String contentType;
        public String url;

        public a(String str, long j, long j2, String str2) {
            this.contentType = str;
            this.Fz = j;
            this.FA = j2;
            this.url = str2;
        }
    }
}
