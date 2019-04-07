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
        return a.AV();
    }

    /* loaded from: classes2.dex */
    private static class a {
        private static String Di;

        static String AV() {
            if (TextUtils.isEmpty(Di)) {
                Di = new b.a().aG("swangame", "1.0").aH(SchemeConfig.DEFAULT_SCHEME_HEAD, com.baidu.swan.apps.al.b.getVersionName()).aI("Baidu", com.baidu.swan.apps.al.b.getOSVersion()).LH();
            }
            return Di;
        }
    }
}
