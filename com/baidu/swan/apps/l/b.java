package com.baidu.swan.apps.l;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.swan.games.f.e;
import com.baidu.swan.games.f.i;
/* loaded from: classes7.dex */
public class b implements i {
    @Override // com.baidu.swan.games.f.i
    public com.baidu.swan.games.f.a a(String str, com.baidu.swan.games.f.d.b bVar, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        return new e(str, bVar, v8ThreadDelegatePolicy);
    }

    @Override // com.baidu.swan.games.f.i
    public String getUserAgent() {
        return a.aeA();
    }

    /* loaded from: classes7.dex */
    private static class a {
        private static String Lv;

        static String aeA() {
            if (TextUtils.isEmpty(Lv)) {
                Lv = com.baidu.swan.apps.ao.b.aeA();
            }
            return Lv;
        }
    }
}
