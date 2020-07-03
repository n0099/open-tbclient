package com.baidu.swan.apps.core.g;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.swan.apps.core.g.d;
import java.io.File;
import java.io.IOException;
/* loaded from: classes11.dex */
public class e implements a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private d cbW;
    private String cbX;
    private String cbY;
    private boolean cbZ;
    private boolean cca;

    public e(Context context) {
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void loadUrl(String str) {
        if (this.cbW == null) {
            final String acC = com.baidu.swan.apps.core.turbo.d.acr().acC();
            this.cbW = new d(acC, "runtime/index.js");
            this.cbX = str;
            this.cbW.a(new V8EngineConfiguration.JSCacheCallback() { // from class: com.baidu.swan.apps.core.g.e.1
                @Override // com.baidu.searchbox.v8engine.V8EngineConfiguration.JSCacheCallback
                public void onCacheResult(V8EngineConfiguration.CacheInfo cacheInfo) {
                    if (e.DEBUG) {
                        Log.d("V8MasterAdapter", "onCacheResult cached:" + cacheInfo.cached + " ,jsPath: " + cacheInfo.jsPath);
                    }
                    if (cacheInfo.cached && !TextUtils.isEmpty(cacheInfo.jsPath)) {
                        File file = new File(cacheInfo.jsPath);
                        try {
                            if (file.getPath().startsWith(new File(acC).getCanonicalPath())) {
                                e.this.cbZ = true;
                            } else if (!TextUtils.isEmpty(e.this.cbY) && file.getCanonicalPath().startsWith(new File(e.this.cbY).getCanonicalPath())) {
                                e.this.cca = true;
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
    public void a(final com.baidu.swan.apps.core.b bVar) {
        if (this.cbW != null) {
            this.cbW.a(new d.b() { // from class: com.baidu.swan.apps.core.g.e.2
                @Override // com.baidu.swan.apps.core.g.d.b
                public void c(com.baidu.swan.games.f.a aVar) {
                    if (bVar != null) {
                        bVar.fJ(e.this.cbX);
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void destroy() {
        if (this.cbW != null) {
            this.cbW.finish();
        }
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void attachActivity(Activity activity) {
        this.cbW.E(activity);
    }

    @Override // com.baidu.swan.apps.core.g.a
    public com.baidu.swan.apps.core.container.a UX() {
        return this.cbW.getV8Engine();
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void a(com.baidu.swan.apps.core.turbo.a aVar) {
        if (com.baidu.swan.apps.u.a.aga().er(0) && aVar != null) {
            if (DEBUG) {
                Log.d("V8MasterAdapter", "pathList item: " + aVar.appPath);
            }
            this.cbY = aVar.appPath;
            this.cbW.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.aX("appjs", aVar.appPath));
        }
    }

    public int aaP() {
        return com.baidu.swan.apps.core.b.a.k(this.cbZ, this.cca);
    }
}
