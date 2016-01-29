package com.baidu.adp.b;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class a extends i {
    private static volatile a FE = null;
    private static ArrayList<C0000a> FF = new ArrayList<>();

    public abstract void a(String str, long j, long j2, String str2);

    public static a mo() {
        if (FE == null) {
            BdLog.e("trafficStatsManaer");
            FE = new b();
        }
        return FE;
    }

    public static void a(a aVar) {
        FE = aVar;
        if (FE != null) {
            Iterator<C0000a> it = FF.iterator();
            while (it.hasNext()) {
                C0000a next = it.next();
                FE.a(next.contentType, next.FG, next.FH, next.url);
            }
            FF.clear();
        }
    }

    public void a(String str, long j, long j2) {
        a(str, j, j2, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.adp.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0000a {
        public long FG;
        public long FH;
        public String contentType;
        public String url;

        public C0000a(String str, long j, long j2, String str2) {
            this.contentType = str;
            this.FG = j;
            this.FH = j2;
            this.url = str2;
        }
    }
}
