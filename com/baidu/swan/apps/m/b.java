package com.baidu.swan.apps.m;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.swan.games.e.e;
import com.baidu.swan.games.e.i;
/* loaded from: classes10.dex */
public class b implements i {
    @Override // com.baidu.swan.games.e.i
    public com.baidu.swan.games.e.a a(String str, com.baidu.swan.games.e.d.b bVar, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        return new e(str, bVar, v8ThreadDelegatePolicy);
    }

    @Override // com.baidu.swan.games.e.i
    public String getUserAgent() {
        return a.Pg();
    }

    /* loaded from: classes10.dex */
    private static class a {
        private static String rJ;

        static String Pg() {
            if (TextUtils.isEmpty(rJ)) {
                rJ = com.baidu.swan.apps.aq.b.Pg();
            }
            return rJ;
        }
    }
}
