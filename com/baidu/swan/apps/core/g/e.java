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
    private d bOc;
    private String bOd;
    private String bOe;
    private boolean bOf;
    private boolean bOg;

    public e(Context context) {
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void loadUrl(String str) {
        if (this.bOc == null) {
            final String Yx = com.baidu.swan.apps.core.k.d.Yn().Yx();
            this.bOc = new d(Yx, "runtime/index.js");
            this.bOd = str;
            this.bOc.a(new V8EngineConfiguration.JSCacheCallback() { // from class: com.baidu.swan.apps.core.g.e.1
                @Override // com.baidu.searchbox.v8engine.V8EngineConfiguration.JSCacheCallback
                public void onCacheResult(V8EngineConfiguration.CacheInfo cacheInfo) {
                    if (e.DEBUG) {
                        Log.d("V8MasterAdapter", "onCacheResult cached:" + cacheInfo.cached + " ,jsPath: " + cacheInfo.jsPath);
                    }
                    if (cacheInfo.cached && !TextUtils.isEmpty(cacheInfo.jsPath)) {
                        File file = new File(cacheInfo.jsPath);
                        try {
                            if (file.getPath().startsWith(new File(Yx).getCanonicalPath())) {
                                e.this.bOf = true;
                            } else if (!TextUtils.isEmpty(e.this.bOe) && file.getCanonicalPath().startsWith(new File(e.this.bOe).getCanonicalPath())) {
                                e.this.bOg = true;
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
        if (this.bOc != null) {
            this.bOc.a(new d.b() { // from class: com.baidu.swan.apps.core.g.e.2
                @Override // com.baidu.swan.apps.core.g.d.b
                public void c(com.baidu.swan.games.e.a aVar) {
                    if (bVar != null) {
                        bVar.fe(e.this.bOd);
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void destroy() {
        if (this.bOc != null) {
            this.bOc.finish();
        }
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void D(Activity activity) {
        this.bOc.D(activity);
    }

    @Override // com.baidu.swan.apps.core.g.a
    public com.baidu.swan.apps.core.container.a Rr() {
        return this.bOc.getV8Engine();
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void a(com.baidu.swan.apps.core.k.a aVar) {
        if (com.baidu.swan.apps.w.a.abQ().dY(0) && aVar != null) {
            if (DEBUG) {
                Log.d("V8MasterAdapter", "pathList item: " + aVar.appPath);
            }
            this.bOe = aVar.appPath;
            this.bOc.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.aF("appjs", aVar.appPath));
        }
    }

    public int WX() {
        return com.baidu.swan.apps.core.b.a.j(this.bOf, this.bOg);
    }
}
