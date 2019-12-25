package com.baidu.poly.a.g;

import android.text.TextUtils;
import com.baidu.searchbox.suspensionball.SuspensionBallUbc;
import com.baidu.searchbox.ui.animview.praise.PraiseDataPassUtil;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.cookie.SM;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c {
    public static String aLP;
    public static String aLQ;
    public static String aLR;
    public static String aLS;
    public static String aLT;
    private static List<com.baidu.poly.a.g.a> aLU;

    /* loaded from: classes9.dex */
    static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.doFlush();
        }
    }

    private static com.baidu.poly.a.a.c BN() {
        com.baidu.poly.a.a.c cVar = new com.baidu.poly.a.a.c();
        if (!TextUtils.isEmpty(aLP)) {
            cVar.f(SM.COOKIE, "BDUSS=" + aLP);
        }
        return cVar;
    }

    private static com.baidu.poly.a.a.b BO() {
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        bVar.f("dm", "cashier");
        bVar.f("os", PraiseDataPassUtil.KEY_FROM_OS);
        bVar.f("v", "2.6.0");
        if (!TextUtils.isEmpty(aLT)) {
            bVar.f("n", aLT);
        }
        if (!TextUtils.isEmpty(aLQ)) {
            bVar.f("d", aLQ);
        }
        if (!TextUtils.isEmpty(aLR)) {
            bVar.f(SuspensionBallUbc.VALUE_DT, aLR);
        }
        if (!TextUtils.isEmpty(aLS)) {
            bVar.f("dp", aLS);
        }
        return bVar;
    }

    public static void a(com.baidu.poly.a.g.a aVar) {
        if (aLU == null) {
            aLU = new ArrayList();
        }
        if (aVar != null) {
            aLU.add(aVar);
        }
    }

    private static void clear() {
        List<com.baidu.poly.a.g.a> list = aLU;
        if (list != null) {
            list.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void doFlush() {
        synchronized (c.class) {
            List<com.baidu.poly.a.g.a> list = aLU;
            if (list != null && !list.isEmpty()) {
                com.baidu.poly.a.a.b BO = BO();
                JSONArray jSONArray = new JSONArray();
                for (com.baidu.poly.a.g.a aVar : aLU) {
                    JSONObject BM = aVar.BM();
                    if (BM != null) {
                        jSONArray.put(BM);
                    }
                }
                BO.f("data", jSONArray.toString());
                new b().a(BN(), BO);
                clear();
            }
        }
    }

    public static void flush() {
        com.baidu.poly.b.a.execute(new a());
    }

    public static void o() {
        aLP = null;
        aLQ = null;
        aLR = null;
        aLS = null;
        aLT = null;
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
            aVar.ex(str);
            a(aVar);
        }
    }
}
