package com.baidu.adp.b;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class a extends i {
    private static volatile a wF = null;
    private static ArrayList<C0001a> wG = new ArrayList<>();

    public abstract void a(String str, long j, long j2, String str2);

    public static a iw() {
        if (wF == null) {
            BdLog.e("trafficStatsManaer");
            wF = new b();
        }
        return wF;
    }

    public static void a(a aVar) {
        wF = aVar;
        if (wF != null) {
            Iterator<C0001a> it = wG.iterator();
            while (it.hasNext()) {
                C0001a next = it.next();
                wF.a(next.contentType, next.wH, next.wI, next.url);
            }
            wG.clear();
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
        public long wH;
        public long wI;

        public C0001a(String str, long j, long j2, String str2) {
            this.contentType = str;
            this.wH = j;
            this.wI = j2;
            this.url = str2;
        }
    }
}
