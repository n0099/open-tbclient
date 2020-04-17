package com.baidu.swan.games.u;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
/* loaded from: classes11.dex */
public class c {
    public static void qM(String str) {
        com.baidu.swan.games.u.a.d dVar = new com.baidu.swan.games.u.a.d();
        dVar.errMsg = str;
        b.axS().a(new a(10000, dVar));
    }

    public static void qN(String str) {
        com.baidu.swan.games.u.a.d dVar = new com.baidu.swan.games.u.a.d();
        dVar.errMsg = str;
        b.axS().a(new a(20000, dVar));
    }

    public static void cd(String str, String str2) {
        com.baidu.swan.games.u.a.b bVar = new com.baidu.swan.games.u.a.b();
        bVar.key = str;
        bVar.errMsg = str2;
        b.axS().a(new a(30000, bVar));
    }

    public static void f(CallbackHandler callbackHandler, String str) {
        if (UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            com.baidu.swan.games.u.a.d dVar = new com.baidu.swan.games.u.a.d();
            dVar.errMsg = str;
            b.axS().a(new a(40000, dVar));
        }
    }

    public static void g(CallbackHandler callbackHandler, String str) {
        if (UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            com.baidu.swan.games.u.a.d dVar = new com.baidu.swan.games.u.a.d();
            dVar.errMsg = str;
            b.axS().a(new a(IMConstants.ERROR_BASE, dVar));
        }
    }

    public static void h(CallbackHandler callbackHandler, String str) {
        if (UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            com.baidu.swan.games.u.a.d dVar = new com.baidu.swan.games.u.a.d();
            dVar.errMsg = str;
            b.axS().a(new a(60000, dVar));
        }
    }

    public static void a(String str, int i, String str2, boolean z) {
        com.baidu.swan.games.u.a.a aVar = new com.baidu.swan.games.u.a.a();
        aVar.url = str;
        aVar.errCode = i;
        aVar.cRw = z ? 1 : 0;
        aVar.errMsg = str2;
        b.axS().a(new a(70000, aVar));
    }

    public static void b(String str, int i, String str2, boolean z) {
        com.baidu.swan.games.u.a.a aVar = new com.baidu.swan.games.u.a.a();
        aVar.url = str;
        aVar.errCode = i;
        aVar.cRw = z ? 1 : 0;
        aVar.errMsg = str2;
        b.axS().a(new a(100000, aVar));
    }

    public static void c(String str, int i, String str2, boolean z) {
        com.baidu.swan.games.u.a.a aVar = new com.baidu.swan.games.u.a.a();
        aVar.url = str;
        aVar.errCode = i;
        aVar.cRw = z ? 1 : 0;
        aVar.errMsg = str2;
        b.axS().a(new a(110000, aVar));
    }

    public static void k(String str, int i, String str2) {
        com.baidu.swan.games.u.a.c cVar = new com.baidu.swan.games.u.a.c();
        cVar.packageName = str;
        cVar.errCode = i;
        cVar.errMsg = str2;
        b.axS().a(new a(80000, cVar));
    }

    public static void i(CallbackHandler callbackHandler, String str) {
        if (UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            com.baidu.swan.games.u.a.d dVar = new com.baidu.swan.games.u.a.d();
            dVar.errMsg = str;
            b.axS().a(new a(90000, dVar));
        }
    }

    public static void qO(String str) {
        com.baidu.swan.games.u.a.d dVar = new com.baidu.swan.games.u.a.d();
        dVar.errMsg = str;
        b.axS().a(new a(BdStatisticsManager.UPLOAD_TIMER_INTERVAL, dVar));
    }
}
