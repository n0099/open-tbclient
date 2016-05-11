package com.baidu.adp.b;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class a extends i {
    private static volatile a wc = null;
    private static ArrayList<C0001a> wd = new ArrayList<>();

    public abstract void a(String str, long j, long j2, String str2);

    public static a iu() {
        if (wc == null) {
            BdLog.e("trafficStatsManaer");
            wc = new b();
        }
        return wc;
    }

    public static void a(a aVar) {
        wc = aVar;
        if (wc != null) {
            Iterator<C0001a> it = wd.iterator();
            while (it.hasNext()) {
                C0001a next = it.next();
                wc.a(next.contentType, next.we, next.wf, next.url);
            }
            wd.clear();
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
        public long we;
        public long wf;

        public C0001a(String str, long j, long j2, String str2) {
            this.contentType = str;
            this.we = j;
            this.wf = j2;
            this.url = str2;
        }
    }
}
