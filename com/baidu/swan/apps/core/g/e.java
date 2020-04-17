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
    private d bNX;
    private String bNY;
    private String bNZ;
    private boolean bOa;
    private boolean bOb;

    public e(Context context) {
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void loadUrl(String str) {
        if (this.bNX == null) {
            final String Yy = com.baidu.swan.apps.core.k.d.Yo().Yy();
            this.bNX = new d(Yy, "runtime/index.js");
            this.bNY = str;
            this.bNX.a(new V8EngineConfiguration.JSCacheCallback() { // from class: com.baidu.swan.apps.core.g.e.1
                @Override // com.baidu.searchbox.v8engine.V8EngineConfiguration.JSCacheCallback
                public void onCacheResult(V8EngineConfiguration.CacheInfo cacheInfo) {
                    if (e.DEBUG) {
                        Log.d("V8MasterAdapter", "onCacheResult cached:" + cacheInfo.cached + " ,jsPath: " + cacheInfo.jsPath);
                    }
                    if (cacheInfo.cached && !TextUtils.isEmpty(cacheInfo.jsPath)) {
                        File file = new File(cacheInfo.jsPath);
                        try {
                            if (file.getPath().startsWith(new File(Yy).getCanonicalPath())) {
                                e.this.bOa = true;
                            } else if (!TextUtils.isEmpty(e.this.bNZ) && file.getCanonicalPath().startsWith(new File(e.this.bNZ).getCanonicalPath())) {
                                e.this.bOb = true;
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
        if (this.bNX != null) {
            this.bNX.a(new d.b() { // from class: com.baidu.swan.apps.core.g.e.2
                @Override // com.baidu.swan.apps.core.g.d.b
                public void c(com.baidu.swan.games.e.a aVar) {
                    if (bVar != null) {
                        bVar.fe(e.this.bNY);
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void destroy() {
        if (this.bNX != null) {
            this.bNX.finish();
        }
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void D(Activity activity) {
        this.bNX.D(activity);
    }

    @Override // com.baidu.swan.apps.core.g.a
    public com.baidu.swan.apps.core.container.a Rs() {
        return this.bNX.getV8Engine();
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void a(com.baidu.swan.apps.core.k.a aVar) {
        if (com.baidu.swan.apps.w.a.abR().dY(0) && aVar != null) {
            if (DEBUG) {
                Log.d("V8MasterAdapter", "pathList item: " + aVar.appPath);
            }
            this.bNZ = aVar.appPath;
            this.bNX.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.aF("appjs", aVar.appPath));
        }
    }

    public int WY() {
        return com.baidu.swan.apps.core.b.a.j(this.bOa, this.bOb);
    }
}
