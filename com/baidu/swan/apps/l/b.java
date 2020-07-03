package com.baidu.swan.apps.l;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.swan.games.f.e;
import com.baidu.swan.games.f.i;
/* loaded from: classes11.dex */
public class b implements i {
    @Override // com.baidu.swan.games.f.i
    public com.baidu.swan.games.f.a a(String str, com.baidu.swan.games.f.d.b bVar, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        return new e(str, bVar, v8ThreadDelegatePolicy);
    }

    @Override // com.baidu.swan.games.f.i
    public String getUserAgent() {
        return a.adu();
    }

    /* loaded from: classes11.dex */
    private static class a {
        private static String Lw;

        static String adu() {
            if (TextUtils.isEmpty(Lw)) {
                Lw = com.baidu.swan.apps.ao.b.adu();
            }
            return Lw;
        }
    }
}
