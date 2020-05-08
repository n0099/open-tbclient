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
    public static String bnD;
    public static String bnE;
    public static String bnF;
    public static String bnG;
    public static String bnH;
    private static List<com.baidu.poly.a.g.a> bnI;

    /* loaded from: classes11.dex */
    static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.doFlush();
        }
    }

    private static com.baidu.poly.a.a.c KW() {
        com.baidu.poly.a.a.c cVar = new com.baidu.poly.a.a.c();
        if (!TextUtils.isEmpty(bnD)) {
            cVar.f(SM.COOKIE, "BDUSS=" + bnD);
        }
        return cVar;
    }

    private static com.baidu.poly.a.a.b KX() {
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        bVar.f("dm", "cashier");
        bVar.f("os", "android");
        bVar.f("v", "2.6.0");
        if (!TextUtils.isEmpty(bnH)) {
            bVar.f("n", bnH);
        }
        if (!TextUtils.isEmpty(bnE)) {
            bVar.f("d", bnE);
        }
        if (!TextUtils.isEmpty(bnF)) {
            bVar.f(SuspensionBallUbc.VALUE_DT, bnF);
        }
        if (!TextUtils.isEmpty(bnG)) {
            bVar.f("dp", bnG);
        }
        return bVar;
    }

    public static void a(com.baidu.poly.a.g.a aVar) {
        if (bnI == null) {
            bnI = new ArrayList();
        }
        if (aVar != null) {
            bnI.add(aVar);
        }
    }

    private static void clear() {
        List<com.baidu.poly.a.g.a> list = bnI;
        if (list != null) {
            list.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void doFlush() {
        synchronized (c.class) {
            List<com.baidu.poly.a.g.a> list = bnI;
            if (list != null && !list.isEmpty()) {
                com.baidu.poly.a.a.b KX = KX();
                JSONArray jSONArray = new JSONArray();
                for (com.baidu.poly.a.g.a aVar : bnI) {
                    JSONObject KV = aVar.KV();
                    if (KV != null) {
                        jSONArray.put(KV);
                    }
                }
                KX.f("data", jSONArray.toString());
                new b().a(KW(), KX);
                clear();
            }
        }
    }

    public static void flush() {
        com.baidu.poly.b.a.execute(new a());
    }

    public static void o() {
        bnD = null;
        bnE = null;
        bnF = null;
        bnG = null;
        bnH = null;
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
