package cn.jiguang.d.b.a.a;

import android.text.TextUtils;
import java.net.InetAddress;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes3.dex */
public final class b extends i {
    public b(cn.jiguang.d.b.a.d dVar) {
        super(dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // cn.jiguang.d.b.a.a.i
    public final int a() {
        InetAddress M = cn.jiguang.d.d.g.M(cn.jiguang.d.a.ky.d());
        if (M == null) {
            return -1;
        }
        String hostAddress = M.getHostAddress();
        if (TextUtils.isEmpty(hostAddress)) {
            return -1;
        }
        c cVar = new c(this);
        cVar.add(7000);
        cVar.add(7002);
        cVar.add(7003);
        cVar.add(7004);
        cVar.add(7005);
        cVar.add(7006);
        cVar.add(7007);
        cVar.add(7008);
        cVar.add(7009);
        try {
            Collections.shuffle(cVar);
        } catch (Throwable th) {
        }
        cn.jiguang.d.b.a.a aVar = new cn.jiguang.d.b.a.a();
        Iterator<Integer> it = cVar.iterator();
        while (it.hasNext()) {
            aVar.a(hostAddress, it.next().intValue(), "DefaultConnPolicy");
        }
        return b(aVar);
    }
}
