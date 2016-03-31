package com.baidu.adp.b;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class a extends i {
    private static volatile a FK = null;
    private static ArrayList<C0001a> FL = new ArrayList<>();

    public abstract void a(String str, long j, long j2, String str2);

    public static a mg() {
        if (FK == null) {
            BdLog.e("trafficStatsManaer");
            FK = new b();
        }
        return FK;
    }

    public static void a(a aVar) {
        FK = aVar;
        if (FK != null) {
            Iterator<C0001a> it = FL.iterator();
            while (it.hasNext()) {
                C0001a next = it.next();
                FK.a(next.contentType, next.FM, next.FN, next.url);
            }
            FL.clear();
        }
    }

    public void a(String str, long j, long j2) {
        a(str, j, j2, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.adp.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0001a {
        public long FM;
        public long FN;
        public String contentType;
        public String url;

        public C0001a(String str, long j, long j2, String str2) {
            this.contentType = str;
            this.FM = j;
            this.FN = j2;
            this.url = str2;
        }
    }
}
