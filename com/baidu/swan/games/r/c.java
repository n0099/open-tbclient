package com.baidu.swan.games.r;

import com.baidu.android.imsdk.IMConstants;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.games.r.a.d;
/* loaded from: classes2.dex */
public class c {
    public static void kx(String str) {
        d dVar = new d();
        dVar.errMsg = str;
        b.Ya().a(new a(10000, dVar));
    }

    public static void ky(String str) {
        d dVar = new d();
        dVar.errMsg = str;
        b.Ya().a(new a(MessageConfig.SOCKET_TIME_OUT_MS_2G, dVar));
    }

    public static void bn(String str, String str2) {
        com.baidu.swan.games.r.a.b bVar = new com.baidu.swan.games.r.a.b();
        bVar.key = str;
        bVar.errMsg = str2;
        b.Ya().a(new a(30000, bVar));
    }

    public static void e(CallbackHandler callbackHandler, String str) {
        if (UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            d dVar = new d();
            dVar.errMsg = str;
            b.Ya().a(new a(40000, dVar));
        }
    }

    public static void f(CallbackHandler callbackHandler, String str) {
        if (UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            d dVar = new d();
            dVar.errMsg = str;
            b.Ya().a(new a(IMConstants.ERROR_BASE, dVar));
        }
    }

    public static void g(CallbackHandler callbackHandler, String str) {
        if (UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            d dVar = new d();
            dVar.errMsg = str;
            b.Ya().a(new a(60000, dVar));
        }
    }

    public static void a(String str, int i, String str2, boolean z) {
        com.baidu.swan.games.r.a.a aVar = new com.baidu.swan.games.r.a.a();
        aVar.url = str;
        aVar.errCode = i;
        aVar.bEu = z ? 1 : 0;
        aVar.errMsg = str2;
        b.Ya().a(new a(70000, aVar));
    }

    public static void i(String str, int i, String str2) {
        com.baidu.swan.games.r.a.c cVar = new com.baidu.swan.games.r.a.c();
        cVar.packageName = str;
        cVar.errCode = i;
        cVar.errMsg = str2;
        b.Ya().a(new a(80000, cVar));
    }

    public static void h(CallbackHandler callbackHandler, String str) {
        if (UnitedSchemeUtility.isInvokedFromSwanGame(callbackHandler)) {
            d dVar = new d();
            dVar.errMsg = str;
            b.Ya().a(new a(90000, dVar));
        }
    }
}
