package com.baidu.swan.games.r;

import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.games.r.a.d;
/* loaded from: classes2.dex */
public class c {
    public static void jT(String str) {
        d dVar = new d();
        dVar.errMsg = str;
        b.Tf().a(new a(10000, dVar));
    }

    public static void jU(String str) {
        d dVar = new d();
        dVar.errMsg = str;
        b.Tf().a(new a(20000, dVar));
    }

    public static void bg(String str, String str2) {
        com.baidu.swan.games.r.a.b bVar = new com.baidu.swan.games.r.a.b();
        bVar.key = str;
        bVar.errMsg = str2;
        b.Tf().a(new a(30000, bVar));
    }

    public static void e(CallbackHandler callbackHandler, String str) {
        if (UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            d dVar = new d();
            dVar.errMsg = str;
            b.Tf().a(new a(40000, dVar));
        }
    }

    public static void f(CallbackHandler callbackHandler, String str) {
        if (UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            d dVar = new d();
            dVar.errMsg = str;
            b.Tf().a(new a(50000, dVar));
        }
    }

    public static void g(CallbackHandler callbackHandler, String str) {
        if (UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            d dVar = new d();
            dVar.errMsg = str;
            b.Tf().a(new a(60000, dVar));
        }
    }

    public static void a(String str, int i, String str2, boolean z) {
        com.baidu.swan.games.r.a.a aVar = new com.baidu.swan.games.r.a.a();
        aVar.url = str;
        aVar.errCode = i;
        aVar.bli = z ? 1 : 0;
        aVar.errMsg = str2;
        b.Tf().a(new a(70000, aVar));
    }

    public static void g(String str, int i, String str2) {
        com.baidu.swan.games.r.a.c cVar = new com.baidu.swan.games.r.a.c();
        cVar.packageName = str;
        cVar.errCode = i;
        cVar.errMsg = str2;
        b.Tf().a(new a(80000, cVar));
    }

    public static void h(CallbackHandler callbackHandler, String str) {
        if (UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            d dVar = new d();
            dVar.errMsg = str;
            b.Tf().a(new a(90000, dVar));
        }
    }
}
