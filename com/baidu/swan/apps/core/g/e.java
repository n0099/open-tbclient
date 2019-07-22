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
    private d asF;
    private String asG;
    private String asH;
    private boolean asI;
    private boolean asJ;

    public e(Context context) {
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void loadUrl(String str) {
        if (this.asF == null) {
            final String BY = com.baidu.swan.apps.core.j.c.BQ().BY();
            this.asF = new d(BY, "runtime/index.js");
            this.asG = str;
            this.asF.a(new V8EngineConfiguration.JSCacheCallback() { // from class: com.baidu.swan.apps.core.g.e.1
                @Override // com.baidu.searchbox.v8engine.V8EngineConfiguration.JSCacheCallback
                public void onCacheResult(V8EngineConfiguration.CacheInfo cacheInfo) {
                    if (e.DEBUG) {
                        Log.d("V8MasterAdapter", "onCacheResult cached:" + cacheInfo.cached + " ,jsPath: " + cacheInfo.jsPath);
                    }
                    if (cacheInfo.cached && !TextUtils.isEmpty(cacheInfo.jsPath)) {
                        File file = new File(cacheInfo.jsPath);
                        try {
                            if (file.getPath().startsWith(new File(BY).getCanonicalPath())) {
                                e.this.asI = true;
                            } else if (!TextUtils.isEmpty(e.this.asH) && file.getCanonicalPath().startsWith(new File(e.this.asH).getCanonicalPath())) {
                                e.this.asJ = true;
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
        if (this.asF != null) {
            this.asF.a(new d.b() { // from class: com.baidu.swan.apps.core.g.e.2
                @Override // com.baidu.swan.apps.core.g.d.b
                public void c(com.baidu.swan.games.e.a aVar) {
                    if (cVar != null) {
                        cVar.dw(e.this.asG);
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void destroy() {
        if (this.asF != null) {
            this.asF.finish();
        }
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void y(Activity activity) {
        this.asF.y(activity);
    }

    @Override // com.baidu.swan.apps.core.g.a
    public com.baidu.swan.apps.core.container.a AZ() {
        return this.asF.getV8Engine();
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void a(com.baidu.swan.apps.core.j.a aVar) {
        if (com.baidu.swan.apps.u.a.En().wt() && aVar != null) {
            if (DEBUG) {
                Log.d("V8MasterAdapter", "pathList item: " + aVar.auc);
            }
            this.asH = aVar.auc;
            this.asF.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.Y("appjs", aVar.auc));
        }
    }

    public int Be() {
        return com.baidu.swan.apps.core.b.a.e(this.asI, this.asJ);
    }
}
