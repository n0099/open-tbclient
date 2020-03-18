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
    private static List<com.baidu.poly.a.g.a> aRA;
    public static String aRv;
    public static String aRw;
    public static String aRx;
    public static String aRy;
    public static String aRz;

    /* loaded from: classes11.dex */
    static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.doFlush();
        }
    }

    private static com.baidu.poly.a.a.c EM() {
        com.baidu.poly.a.a.c cVar = new com.baidu.poly.a.a.c();
        if (!TextUtils.isEmpty(aRv)) {
            cVar.f(SM.COOKIE, "BDUSS=" + aRv);
        }
        return cVar;
    }

    private static com.baidu.poly.a.a.b EN() {
        com.baidu.poly.a.a.b bVar = new com.baidu.poly.a.a.b();
        bVar.f("dm", "cashier");
        bVar.f("os", PraiseDataPassUtil.KEY_FROM_OS);
        bVar.f("v", "2.6.0");
        if (!TextUtils.isEmpty(aRz)) {
            bVar.f("n", aRz);
        }
        if (!TextUtils.isEmpty(aRw)) {
            bVar.f("d", aRw);
        }
        if (!TextUtils.isEmpty(aRx)) {
            bVar.f(SuspensionBallUbc.VALUE_DT, aRx);
        }
        if (!TextUtils.isEmpty(aRy)) {
            bVar.f("dp", aRy);
        }
        return bVar;
    }

    public static void a(com.baidu.poly.a.g.a aVar) {
        if (aRA == null) {
            aRA = new ArrayList();
        }
        if (aVar != null) {
            aRA.add(aVar);
        }
    }

    private static void clear() {
        List<com.baidu.poly.a.g.a> list = aRA;
        if (list != null) {
            list.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void doFlush() {
        synchronized (c.class) {
            List<com.baidu.poly.a.g.a> list = aRA;
            if (list != null && !list.isEmpty()) {
                com.baidu.poly.a.a.b EN = EN();
                JSONArray jSONArray = new JSONArray();
                for (com.baidu.poly.a.g.a aVar : aRA) {
                    JSONObject EL = aVar.EL();
                    if (EL != null) {
                        jSONArray.put(EL);
                    }
                }
                EN.f("data", jSONArray.toString());
                new b().a(EM(), EN);
                clear();
            }
        }
    }

    public static void flush() {
        com.baidu.poly.b.a.execute(new a());
    }

    public static void o() {
        aRv = null;
        aRw = null;
        aRx = null;
        aRy = null;
        aRz = null;
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
            aVar.eP(str);
            a(aVar);
        }
    }
}
