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
    private d bpC;
    private String bpD;
    private String bpE;
    private boolean bpF;
    private boolean bpG;

    public e(Context context) {
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void loadUrl(String str) {
        if (this.bpC == null) {
            final String QE = com.baidu.swan.apps.core.k.d.Qu().QE();
            this.bpC = new d(QE, "runtime/index.js");
            this.bpD = str;
            this.bpC.a(new V8EngineConfiguration.JSCacheCallback() { // from class: com.baidu.swan.apps.core.g.e.1
                @Override // com.baidu.searchbox.v8engine.V8EngineConfiguration.JSCacheCallback
                public void onCacheResult(V8EngineConfiguration.CacheInfo cacheInfo) {
                    if (e.DEBUG) {
                        Log.d("V8MasterAdapter", "onCacheResult cached:" + cacheInfo.cached + " ,jsPath: " + cacheInfo.jsPath);
                    }
                    if (cacheInfo.cached && !TextUtils.isEmpty(cacheInfo.jsPath)) {
                        File file = new File(cacheInfo.jsPath);
                        try {
                            if (file.getPath().startsWith(new File(QE).getCanonicalPath())) {
                                e.this.bpF = true;
                            } else if (!TextUtils.isEmpty(e.this.bpE) && file.getCanonicalPath().startsWith(new File(e.this.bpE).getCanonicalPath())) {
                                e.this.bpG = true;
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
        if (this.bpC != null) {
            this.bpC.a(new d.b() { // from class: com.baidu.swan.apps.core.g.e.2
                @Override // com.baidu.swan.apps.core.g.d.b
                public void c(com.baidu.swan.games.e.a aVar) {
                    if (bVar != null) {
                        bVar.em(e.this.bpD);
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void destroy() {
        if (this.bpC != null) {
            this.bpC.finish();
        }
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void H(Activity activity) {
        this.bpC.H(activity);
    }

    @Override // com.baidu.swan.apps.core.g.a
    public com.baidu.swan.apps.core.container.a JB() {
        return this.bpC.getV8Engine();
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void a(com.baidu.swan.apps.core.k.a aVar) {
        if (com.baidu.swan.apps.w.a.TX().dT(0) && aVar != null) {
            if (DEBUG) {
                Log.d("V8MasterAdapter", "pathList item: " + aVar.appPath);
            }
            this.bpE = aVar.appPath;
            this.bpC.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.ax("appjs", aVar.appPath));
        }
    }

    public int Pe() {
        return com.baidu.swan.apps.core.b.a.j(this.bpF, this.bpG);
    }
}
