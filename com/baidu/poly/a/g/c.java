package com.baidu.poly.a.g;

import android.text.TextUtils;
import com.baidu.searchbox.suspensionball.SuspensionBallUbc;
import com.baidu.searchbox.ui.animview.praise.PraiseDataPassUtil;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.cookie.SM;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    public static String aRh;
    public static String aRi;
    public static String aRj;
    public static String aRk;
    public static String aRl;
    private static List<com.baidu.poly.a.g.a> aRm;

    /* loaded from: classes11.dex */
    static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.doFlush();
        }
    }

    private static com.baidu.poly.a.a.c EH() {
        com.baidu.poly.a.a.c cVar = new com.baidu.poly.a.a.c();
        if (!TextUtils.isEmpty(aRh)) {
            cVar.f(SM.COOKIE, "BDUSS=" + aRh);
        }
        return cVar;
    }

    private static com.baidu.poly.a.a.b EI() {
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        bVar.f("dm", "cashier");
        bVar.f("os", PraiseDataPassUtil.KEY_FROM_OS);
        bVar.f("v", "2.6.0");
        if (!TextUtils.isEmpty(aRl)) {
            bVar.f("n", aRl);
        }
        if (!TextUtils.isEmpty(aRi)) {
            bVar.f("d", aRi);
        }
        if (!TextUtils.isEmpty(aRj)) {
            bVar.f(SuspensionBallUbc.VALUE_DT, aRj);
        }
        if (!TextUtils.isEmpty(aRk)) {
            bVar.f("dp", aRk);
        }
        return bVar;
    }

    public static void a(com.baidu.poly.a.g.a aVar) {
        if (aRm == null) {
            aRm = new ArrayList();
        }
        if (aVar != null) {
            aRm.add(aVar);
        }
    }

    private static void clear() {
        List<com.baidu.poly.a.g.a> list = aRm;
        if (list != null) {
            list.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void doFlush() {
        synchronized (c.class) {
            List<com.baidu.poly.a.g.a> list = aRm;
            if (list != null && !list.isEmpty()) {
                com.baidu.poly.a.a.b EI = EI();
                JSONArray jSONArray = new JSONArray();
                for (com.baidu.poly.a.g.a aVar : aRm) {
                    JSONObject EG = aVar.EG();
                    if (EG != null) {
                        jSONArray.put(EG);
                    }
                }
                EI.f("data", jSONArray.toString());
                new b().a(EH(), EI);
                clear();
            }
        }
    }

    public static void flush() {
        com.baidu.poly.b.a.execute(new a());
    }

    public static void o() {
        aRh = null;
        aRi = null;
        aRj = null;
        aRk = null;
        aRl = null;
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
            aVar.eQ(str);
            a(aVar);
        }
    }
}
