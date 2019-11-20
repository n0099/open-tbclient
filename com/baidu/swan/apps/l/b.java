package com.baidu.swan.apps.l;

import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.swan.apps.al.b;
import com.baidu.swan.games.e.e;
import com.baidu.swan.games.e.h;
/* loaded from: classes2.dex */
public class b implements h {
    @Override // com.baidu.swan.games.e.h
    public com.baidu.swan.games.e.a a(String str, com.baidu.swan.games.e.d.b bVar, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        return new e(str, bVar, v8ThreadDelegatePolicy);
    }

    @Override // com.baidu.swan.games.e.h
    public String getUserAgent() {
        return a.HL();
    }

    /* loaded from: classes2.dex */
    private static class a {
        private static String oX;

        static String HL() {
            if (TextUtils.isEmpty(oX)) {
                oX = new b.a().aQ("swangame", "1.0").aR(SchemeConfig.DEFAULT_SCHEME_HEAD, com.baidu.swan.apps.al.b.getVersionName()).aS("Baidu", com.baidu.swan.apps.al.b.getOSVersion()).TU();
            }
            return oX;
        }
    }
}
