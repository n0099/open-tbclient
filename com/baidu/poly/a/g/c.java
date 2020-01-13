package com.baidu.poly.a.g;

import android.text.TextUtils;
import com.baidu.searchbox.suspensionball.SuspensionBallUbc;
import com.baidu.searchbox.ui.animview.praise.PraiseDataPassUtil;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.cookie.SM;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c {
    public static String aMH;
    public static String aMI;
    public static String aMJ;
    public static String aMK;
    public static String aML;
    private static List<com.baidu.poly.a.g.a> aMM;

    /* loaded from: classes10.dex */
    static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.doFlush();
        }
    }

    private static com.baidu.poly.a.a.c Cj() {
        com.baidu.poly.a.a.c cVar = new com.baidu.poly.a.a.c();
        if (!TextUtils.isEmpty(aMH)) {
            cVar.f(SM.COOKIE, "BDUSS=" + aMH);
        }
        return cVar;
    }

    private static com.baidu.poly.a.a.b Ck() {
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        bVar.f("dm", "cashier");
        bVar.f("os", PraiseDataPassUtil.KEY_FROM_OS);
        bVar.f("v", "2.6.0");
        if (!TextUtils.isEmpty(aML)) {
            bVar.f("n", aML);
        }
        if (!TextUtils.isEmpty(aMI)) {
            bVar.f("d", aMI);
        }
        if (!TextUtils.isEmpty(aMJ)) {
            bVar.f(SuspensionBallUbc.VALUE_DT, aMJ);
        }
        if (!TextUtils.isEmpty(aMK)) {
            bVar.f("dp", aMK);
        }
        return bVar;
    }

    public static void a(com.baidu.poly.a.g.a aVar) {
        if (aMM == null) {
            aMM = new ArrayList();
        }
        if (aVar != null) {
            aMM.add(aVar);
        }
    }

    private static void clear() {
        List<com.baidu.poly.a.g.a> list = aMM;
        if (list != null) {
            list.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void doFlush() {
        synchronized (c.class) {
            List<com.baidu.poly.a.g.a> list = aMM;
            if (list != null && !list.isEmpty()) {
                com.baidu.poly.a.a.b Ck = Ck();
                JSONArray jSONArray = new JSONArray();
                for (com.baidu.poly.a.g.a aVar : aMM) {
                    JSONObject Ci = aVar.Ci();
                    if (Ci != null) {
                        jSONArray.put(Ci);
                    }
                }
                Ck.f("data", jSONArray.toString());
                new b().a(Cj(), Ck);
                clear();
            }
        }
    }

    public static void flush() {
        com.baidu.poly.b.a.execute(new a());
    }

    public static void o() {
        aMH = null;
        aMI = null;
        aMJ = null;
        aMK = null;
        aML = null;
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
            aVar.eA(str);
            a(aVar);
        }
    }
}
