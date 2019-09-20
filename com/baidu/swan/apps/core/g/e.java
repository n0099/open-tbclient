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
    private d atd;
    private String ate;
    private String atf;
    private boolean atg;
    private boolean ath;

    public e(Context context) {
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void loadUrl(String str) {
        if (this.atd == null) {
            final String Cc = com.baidu.swan.apps.core.j.c.BU().Cc();
            this.atd = new d(Cc, "runtime/index.js");
            this.ate = str;
            this.atd.a(new V8EngineConfiguration.JSCacheCallback() { // from class: com.baidu.swan.apps.core.g.e.1
                @Override // com.baidu.searchbox.v8engine.V8EngineConfiguration.JSCacheCallback
                public void onCacheResult(V8EngineConfiguration.CacheInfo cacheInfo) {
                    if (e.DEBUG) {
                        Log.d("V8MasterAdapter", "onCacheResult cached:" + cacheInfo.cached + " ,jsPath: " + cacheInfo.jsPath);
                    }
                    if (cacheInfo.cached && !TextUtils.isEmpty(cacheInfo.jsPath)) {
                        File file = new File(cacheInfo.jsPath);
                        try {
                            if (file.getPath().startsWith(new File(Cc).getCanonicalPath())) {
                                e.this.atg = true;
                            } else if (!TextUtils.isEmpty(e.this.atf) && file.getCanonicalPath().startsWith(new File(e.this.atf).getCanonicalPath())) {
                                e.this.ath = true;
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
        if (this.atd != null) {
            this.atd.a(new d.b() { // from class: com.baidu.swan.apps.core.g.e.2
                @Override // com.baidu.swan.apps.core.g.d.b
                public void c(com.baidu.swan.games.e.a aVar) {
                    if (cVar != null) {
                        cVar.dy(e.this.ate);
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void destroy() {
        if (this.atd != null) {
            this.atd.finish();
        }
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void y(Activity activity) {
        this.atd.y(activity);
    }

    @Override // com.baidu.swan.apps.core.g.a
    public com.baidu.swan.apps.core.container.a Bd() {
        return this.atd.getV8Engine();
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void a(com.baidu.swan.apps.core.j.a aVar) {
        if (com.baidu.swan.apps.u.a.Er().wx() && aVar != null) {
            if (DEBUG) {
                Log.d("V8MasterAdapter", "pathList item: " + aVar.auA);
            }
            this.atf = aVar.auA;
            this.atd.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.Y("appjs", aVar.auA));
        }
    }

    public int Bi() {
        return com.baidu.swan.apps.core.b.a.e(this.atg, this.ath);
    }
}
