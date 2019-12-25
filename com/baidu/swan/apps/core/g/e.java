package com.baidu.swan.apps.core.g;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.swan.apps.core.g.d;
import java.io.File;
import java.io.IOException;
/* loaded from: classes9.dex */
public class e implements a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private d bkD;
    private String bkE;
    private String bkF;
    private boolean bkG;
    private boolean bkH;

    public e(Context context) {
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void loadUrl(String str) {
        if (this.bkD == null) {
            final String NU = com.baidu.swan.apps.core.k.d.NK().NU();
            this.bkD = new d(NU, "runtime/index.js");
            this.bkE = str;
            this.bkD.a(new V8EngineConfiguration.JSCacheCallback() { // from class: com.baidu.swan.apps.core.g.e.1
                @Override // com.baidu.searchbox.v8engine.V8EngineConfiguration.JSCacheCallback
                public void onCacheResult(V8EngineConfiguration.CacheInfo cacheInfo) {
                    if (e.DEBUG) {
                        Log.d("V8MasterAdapter", "onCacheResult cached:" + cacheInfo.cached + " ,jsPath: " + cacheInfo.jsPath);
                    }
                    if (cacheInfo.cached && !TextUtils.isEmpty(cacheInfo.jsPath)) {
                        File file = new File(cacheInfo.jsPath);
                        try {
                            if (file.getPath().startsWith(new File(NU).getCanonicalPath())) {
                                e.this.bkG = true;
                            } else if (!TextUtils.isEmpty(e.this.bkF) && file.getCanonicalPath().startsWith(new File(e.this.bkF).getCanonicalPath())) {
                                e.this.bkH = true;
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
        if (this.bkD != null) {
            this.bkD.a(new d.b() { // from class: com.baidu.swan.apps.core.g.e.2
                @Override // com.baidu.swan.apps.core.g.d.b
                public void c(com.baidu.swan.games.e.a aVar) {
                    if (bVar != null) {
                        bVar.dV(e.this.bkE);
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void destroy() {
        if (this.bkD != null) {
            this.bkD.finish();
        }
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void F(Activity activity) {
        this.bkD.F(activity);
    }

    @Override // com.baidu.swan.apps.core.g.a
    public com.baidu.swan.apps.core.container.a GQ() {
        return this.bkD.getV8Engine();
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void a(com.baidu.swan.apps.core.k.a aVar) {
        if (com.baidu.swan.apps.w.a.Rn().dC(0) && aVar != null) {
            if (DEBUG) {
                Log.d("V8MasterAdapter", "pathList item: " + aVar.appPath);
            }
            this.bkF = aVar.appPath;
            this.bkD.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.am("appjs", aVar.appPath));
        }
    }

    public int Mu() {
        return com.baidu.swan.apps.core.b.a.i(this.bkG, this.bkH);
    }
}
