package com.baidu.adp.b;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class a extends i {
    private static volatile a yR = null;
    private static ArrayList<C0001a> yS = new ArrayList<>();

    public abstract void a(String str, long j, long j2, String str2);

    public static a jr() {
        if (yR == null) {
            BdLog.e("trafficStatsManaer");
            yR = new b();
        }
        return yR;
    }

    public static void a(a aVar) {
        yR = aVar;
        if (yR != null) {
            Iterator<C0001a> it = yS.iterator();
            while (it.hasNext()) {
                C0001a next = it.next();
                yR.a(next.contentType, next.yT, next.yU, next.url);
            }
            yS.clear();
        }
    }

    public void a(String str, long j, long j2) {
        a(str, j, j2, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.adp.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0001a {
        public String contentType;
        public String url;
        public long yT;
        public long yU;

        public C0001a(String str, long j, long j2, String str2) {
            this.contentType = str;
            this.yT = j;
            this.yU = j2;
            this.url = str2;
        }
    }
}
