package com.baidu.swan.apps.core.g;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.swan.apps.core.g.d;
import java.io.File;
import java.io.IOException;
/* loaded from: classes2.dex */
public class e implements a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private d aMu;
    private String aMv;
    private String aMw;
    private boolean aMx;
    private boolean aMy;

    public e(Context context) {
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void loadUrl(String str) {
        if (this.aMu == null) {
            final String GW = com.baidu.swan.apps.core.j.c.GO().GW();
            this.aMu = new d(GW, "runtime/index.js");
            this.aMv = str;
            this.aMu.a(new V8EngineConfiguration.JSCacheCallback() { // from class: com.baidu.swan.apps.core.g.e.1
                @Override // com.baidu.searchbox.v8engine.V8EngineConfiguration.JSCacheCallback
                public void onCacheResult(V8EngineConfiguration.CacheInfo cacheInfo) {
                    if (e.DEBUG) {
                        Log.d("V8MasterAdapter", "onCacheResult cached:" + cacheInfo.cached + " ,jsPath: " + cacheInfo.jsPath);
                    }
                    if (cacheInfo.cached && !TextUtils.isEmpty(cacheInfo.jsPath)) {
                        File file = new File(cacheInfo.jsPath);
                        try {
                            if (file.getPath().startsWith(new File(GW).getCanonicalPath())) {
                                e.this.aMx = true;
                            } else if (!TextUtils.isEmpty(e.this.aMw) && file.getCanonicalPath().startsWith(new File(e.this.aMw).getCanonicalPath())) {
                                e.this.aMy = true;
                            }
                        } catch (IOException e) {
                            if (e.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            });
        } else if (DEBUG) {
            Log.e("V8MasterAdapter", Log.getStackTraceString(new Exception("same instance loadUrl should not be call twice.")));
        }
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void a(final com.baidu.swan.apps.core.c cVar) {
        if (this.aMu != null) {
            this.aMu.a(new d.b() { // from class: com.baidu.swan.apps.core.g.e.2
                @Override // com.baidu.swan.apps.core.g.d.b
                public void c(com.baidu.swan.games.e.a aVar) {
                    if (cVar != null) {
                        cVar.db(e.this.aMv);
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void destroy() {
        if (this.aMu != null) {
            this.aMu.finish();
        }
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void x(Activity activity) {
        this.aMu.x(activity);
    }

    @Override // com.baidu.swan.apps.core.g.a
    public com.baidu.swan.apps.core.container.a FY() {
        return this.aMu.getV8Engine();
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void a(com.baidu.swan.apps.core.j.a aVar) {
        if (com.baidu.swan.apps.u.a.Jl().Br() && aVar != null) {
            if (DEBUG) {
                Log.d("V8MasterAdapter", "pathList item: " + aVar.aNR);
            }
            this.aMw = aVar.aNR;
            this.aMu.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.ag("appjs", aVar.aNR));
        }
    }

    public int Gd() {
        return com.baidu.swan.apps.core.b.a.i(this.aMx, this.aMy);
    }
}
