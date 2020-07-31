package com.baidu.swan.apps.core.g;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.swan.apps.core.g.d;
import java.io.File;
import java.io.IOException;
/* loaded from: classes7.dex */
public class e implements a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private d cdA;
    private String cdB;
    private String cdC;
    private boolean cdD;
    private boolean cdE;

    public e(Context context) {
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void loadUrl(String str) {
        if (this.cdA == null) {
            final String adH = com.baidu.swan.apps.core.turbo.d.adw().adH();
            this.cdA = new d(adH, "runtime/index.js");
            this.cdB = str;
            this.cdA.a(new V8EngineConfiguration.JSCacheCallback() { // from class: com.baidu.swan.apps.core.g.e.1
                @Override // com.baidu.searchbox.v8engine.V8EngineConfiguration.JSCacheCallback
                public void onCacheResult(V8EngineConfiguration.CacheInfo cacheInfo) {
                    if (e.DEBUG) {
                        Log.d("V8MasterAdapter", "onCacheResult cached:" + cacheInfo.cached + " ,jsPath: " + cacheInfo.jsPath);
                    }
                    if (cacheInfo.cached && !TextUtils.isEmpty(cacheInfo.jsPath)) {
                        File file = new File(cacheInfo.jsPath);
                        try {
                            if (file.getPath().startsWith(new File(adH).getCanonicalPath())) {
                                e.this.cdD = true;
                            } else if (!TextUtils.isEmpty(e.this.cdC) && file.getCanonicalPath().startsWith(new File(e.this.cdC).getCanonicalPath())) {
                                e.this.cdE = true;
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
    public void a(final com.baidu.swan.apps.core.e eVar) {
        if (this.cdA != null) {
            this.cdA.a(new d.b() { // from class: com.baidu.swan.apps.core.g.e.2
                @Override // com.baidu.swan.apps.core.g.d.b
                public void c(com.baidu.swan.games.f.a aVar) {
                    if (eVar != null) {
                        eVar.fH(e.this.cdB);
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void destroy() {
        if (this.cdA != null) {
            this.cdA.finish();
        }
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void attachActivity(Activity activity) {
        this.cdA.D(activity);
    }

    @Override // com.baidu.swan.apps.core.g.a
    public com.baidu.swan.apps.core.container.a VC() {
        return this.cdA.getV8Engine();
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void a(com.baidu.swan.apps.core.turbo.a aVar) {
        if (com.baidu.swan.apps.t.a.ahm().et(0) && aVar != null) {
            if (DEBUG) {
                Log.d("V8MasterAdapter", "pathList item: " + aVar.appPath);
            }
            this.cdC = aVar.appPath;
            this.cdA.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.aZ("appjs", aVar.appPath));
        }
    }

    public int abR() {
        return com.baidu.swan.apps.core.b.a.k(this.cdD, this.cdE);
    }
}
