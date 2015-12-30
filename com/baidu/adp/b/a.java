package com.baidu.adp.b;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class a extends i {
    private static volatile a Fr = null;
    private static ArrayList<C0000a> Fs = new ArrayList<>();

    public abstract void a(String str, long j, long j2, String str2);

    public static a ma() {
        if (Fr == null) {
            BdLog.e("trafficStatsManaer");
            Fr = new b();
        }
        return Fr;
    }

    public static void a(a aVar) {
        Fr = aVar;
        if (Fr != null) {
            Iterator<C0000a> it = Fs.iterator();
            while (it.hasNext()) {
                C0000a next = it.next();
                Fr.a(next.contentType, next.Ft, next.Fu, next.url);
            }
            Fs.clear();
        }
    }

    public void b(String str, long j, long j2) {
        a(str, j, j2, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.adp.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0000a {
        public long Ft;
        public long Fu;
        public String contentType;
        public String url;

        public C0000a(String str, long j, long j2, String str2) {
            this.contentType = str;
            this.Ft = j;
            this.Fu = j2;
            this.url = str2;
        }
    }
}
