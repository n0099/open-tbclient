package cn.jiguang.d.c;

import android.support.v4.internal.view.SupportMenu;
import android.text.TextUtils;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public final class f {
    public static List<p> a(String str) {
        h hVar;
        m bA;
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        try {
            String[] a = o.bC().a();
            byte[] b = h.b(m.a(j.a(j.a(str), j.a), 33, 1)).b(SupportMenu.USER_MASK);
            for (String str2 : a) {
                try {
                    hVar = new h(r.a(null, new InetSocketAddress(InetAddress.getByName(str2), 53), b, System.currentTimeMillis() + 1000));
                    bA = hVar.bA();
                } catch (UnknownHostException e) {
                    cn.jiguang.e.c.c("DNSSrvUtils", "Get default ports error at " + str2 + ", with UnknownHostException:" + e.getMessage());
                } catch (IOException e2) {
                    cn.jiguang.e.c.c("DNSSrvUtils", "Get default ports error at " + str2 + ", with IOException:" + e2.getMessage());
                }
                if (bA == null) {
                    break;
                }
                l[] m = hVar.m(1);
                for (l lVar : m) {
                    if (lVar.b().e() == bA.e()) {
                        int d = lVar.b().d();
                        j b2 = lVar.b().b();
                        if (d == bA.c() && b2.equals(bA.b())) {
                            Iterator a2 = lVar.a();
                            while (a2.hasNext()) {
                                p pVar = (p) a2.next();
                                if (pVar.h() > 0) {
                                    arrayList.add(pVar);
                                }
                            }
                        }
                    }
                }
            }
        } catch (k e3) {
            cn.jiguang.e.c.c("DNSSrvUtils", "Get default ports error with NameTooLongException");
        } catch (s e4) {
            cn.jiguang.e.c.c("DNSSrvUtils", "Get default ports error with TextParseException");
        } catch (Throwable th) {
            cn.jiguang.e.c.c("DNSSrvUtils", "Get default ports error with Exception:" + th);
        }
        return arrayList;
    }
}
