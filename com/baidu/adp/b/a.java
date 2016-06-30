package com.baidu.adp.b;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class a extends i {
    private static volatile a we = null;
    private static ArrayList<C0001a> wf = new ArrayList<>();

    public abstract void a(String str, long j, long j2, String str2);

    public static a ix() {
        if (we == null) {
            BdLog.e("trafficStatsManaer");
            we = new b();
        }
        return we;
    }

    public static void a(a aVar) {
        we = aVar;
        if (we != null) {
            Iterator<C0001a> it = wf.iterator();
            while (it.hasNext()) {
                C0001a next = it.next();
                we.a(next.contentType, next.wg, next.wh, next.url);
            }
            wf.clear();
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
        public long wg;
        public long wh;

        public C0001a(String str, long j, long j2, String str2) {
            this.contentType = str;
            this.wg = j;
            this.wh = j2;
            this.url = str2;
        }
    }
}
