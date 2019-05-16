package com.baidu.swan.apps.u.b;

import android.util.Log;
/* loaded from: classes2.dex */
public interface r {
    void a(String str, com.baidu.swan.apps.aa.a.c cVar);

    void a(String str, com.baidu.swan.apps.n.b bVar);

    /* loaded from: classes2.dex */
    public static class a implements r {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

        @Override // com.baidu.swan.apps.u.b.r
        public void a(String str, com.baidu.swan.apps.n.b bVar) {
            if (DEBUG) {
                Log.e("DefaultSwanAppPushIdImpl", "getFormId:" + str);
            }
            bVar.onFail("not impl");
        }

        @Override // com.baidu.swan.apps.u.b.r
        public void a(String str, com.baidu.swan.apps.aa.a.c cVar) {
            if (DEBUG) {
                Log.e("DefaultSwanAppPushIdImpl", "getPayId:" + str);
            }
            cVar.onFail("not impl");
        }
    }
}
