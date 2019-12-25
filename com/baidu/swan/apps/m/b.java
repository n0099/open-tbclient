package com.baidu.swan.apps.m;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.swan.games.e.e;
import com.baidu.swan.games.e.i;
/* loaded from: classes9.dex */
public class b implements i {
    @Override // com.baidu.swan.games.e.i
    public com.baidu.swan.games.e.a a(String str, com.baidu.swan.games.e.d.b bVar, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        return new e(str, bVar, v8ThreadDelegatePolicy);
    }

    @Override // com.baidu.swan.games.e.i
    public String getUserAgent() {
        return a.OK();
    }

    /* loaded from: classes9.dex */
    private static class a {
        private static String rJ;

        static String OK() {
            if (TextUtils.isEmpty(rJ)) {
                rJ = com.baidu.swan.apps.aq.b.OK();
            }
            return rJ;
        }
    }
}
