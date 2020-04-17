package com.baidu.poly.a.g;

import android.text.TextUtils;
import com.baidu.searchbox.suspensionball.SuspensionBallUbc;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.cookie.SM;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    public static String bnA;
    public static String bnB;
    public static String bnC;
    private static List<com.baidu.poly.a.g.a> bnD;
    public static String bny;
    public static String bnz;

    /* loaded from: classes11.dex */
    static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.doFlush();
        }
    }

    private static com.baidu.poly.a.a.c KX() {
        com.baidu.poly.a.a.c cVar = new com.baidu.poly.a.a.c();
        if (!TextUtils.isEmpty(bny)) {
            cVar.f(SM.COOKIE, "BDUSS=" + bny);
        }
        return cVar;
    }

    private static com.baidu.poly.a.a.b KY() {
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        bVar.f("dm", "cashier");
        bVar.f("os", "android");
        bVar.f("v", "2.6.0");
        if (!TextUtils.isEmpty(bnC)) {
            bVar.f("n", bnC);
        }
        if (!TextUtils.isEmpty(bnz)) {
            bVar.f("d", bnz);
        }
        if (!TextUtils.isEmpty(bnA)) {
            bVar.f(SuspensionBallUbc.VALUE_DT, bnA);
        }
        if (!TextUtils.isEmpty(bnB)) {
            bVar.f("dp", bnB);
        }
        return bVar;
    }

    public static void a(com.baidu.poly.a.g.a aVar) {
        if (bnD == null) {
            bnD = new ArrayList();
        }
        if (aVar != null) {
            bnD.add(aVar);
        }
    }

    private static void clear() {
        List<com.baidu.poly.a.g.a> list = bnD;
        if (list != null) {
            list.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void doFlush() {
        synchronized (c.class) {
            List<com.baidu.poly.a.g.a> list = bnD;
            if (list != null && !list.isEmpty()) {
                com.baidu.poly.a.a.b KY = KY();
                JSONArray jSONArray = new JSONArray();
                for (com.baidu.poly.a.g.a aVar : bnD) {
                    JSONObject KW = aVar.KW();
                    if (KW != null) {
                        jSONArray.put(KW);
                    }
                }
                KY.f("data", jSONArray.toString());
                new b().a(KX(), KY);
                clear();
            }
        }
    }

    public static void flush() {
        com.baidu.poly.b.a.execute(new a());
    }

    public static void o() {
        bny = null;
        bnz = null;
        bnA = null;
        bnB = null;
        bnC = null;
    }

    public static void b(int i, String str) {
        com.baidu.poly.a.g.a aVar = null;
        if (i == 0) {
            aVar = new com.baidu.poly.a.g.a("2");
        } else if (i == 2) {
            aVar = new com.baidu.poly.a.g.a("4");
        } else if (i == 3) {
            aVar = new com.baidu.poly.a.g.a("3");
        }
        if (aVar != null) {
            aVar.fK(str);
            a(aVar);
        }
    }
}
