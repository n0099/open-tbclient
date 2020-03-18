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
    private d bpQ;
    private String bpR;
    private String bpS;
    private boolean bpT;
    private boolean bpU;

    public e(Context context) {
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void loadUrl(String str) {
        if (this.bpQ == null) {
            final String QJ = com.baidu.swan.apps.core.k.d.Qz().QJ();
            this.bpQ = new d(QJ, "runtime/index.js");
            this.bpR = str;
            this.bpQ.a(new V8EngineConfiguration.JSCacheCallback() { // from class: com.baidu.swan.apps.core.g.e.1
                @Override // com.baidu.searchbox.v8engine.V8EngineConfiguration.JSCacheCallback
                public void onCacheResult(V8EngineConfiguration.CacheInfo cacheInfo) {
                    if (e.DEBUG) {
                        Log.d("V8MasterAdapter", "onCacheResult cached:" + cacheInfo.cached + " ,jsPath: " + cacheInfo.jsPath);
                    }
                    if (cacheInfo.cached && !TextUtils.isEmpty(cacheInfo.jsPath)) {
                        File file = new File(cacheInfo.jsPath);
                        try {
                            if (file.getPath().startsWith(new File(QJ).getCanonicalPath())) {
                                e.this.bpT = true;
                            } else if (!TextUtils.isEmpty(e.this.bpS) && file.getCanonicalPath().startsWith(new File(e.this.bpS).getCanonicalPath())) {
                                e.this.bpU = true;
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
        if (this.bpQ != null) {
            this.bpQ.a(new d.b() { // from class: com.baidu.swan.apps.core.g.e.2
                @Override // com.baidu.swan.apps.core.g.d.b
                public void c(com.baidu.swan.games.e.a aVar) {
                    if (bVar != null) {
                        bVar.el(e.this.bpR);
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void destroy() {
        if (this.bpQ != null) {
            this.bpQ.finish();
        }
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void H(Activity activity) {
        this.bpQ.H(activity);
    }

    @Override // com.baidu.swan.apps.core.g.a
    public com.baidu.swan.apps.core.container.a JG() {
        return this.bpQ.getV8Engine();
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void a(com.baidu.swan.apps.core.k.a aVar) {
        if (com.baidu.swan.apps.w.a.Uc().dT(0) && aVar != null) {
            if (DEBUG) {
                Log.d("V8MasterAdapter", "pathList item: " + aVar.appPath);
            }
            this.bpS = aVar.appPath;
            this.bpQ.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.aw("appjs", aVar.appPath));
        }
    }

    public int Pj() {
        return com.baidu.swan.apps.core.b.a.k(this.bpT, this.bpU);
    }
}
