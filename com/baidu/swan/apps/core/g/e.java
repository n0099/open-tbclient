package com.baidu.swan.apps.core.g;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.swan.apps.core.g;
import com.baidu.swan.apps.core.g.d;
import java.io.File;
import java.io.IOException;
/* loaded from: classes10.dex */
public class e implements a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private d cxW;
    private String cxX;
    private String cxY;
    private boolean cxZ;
    private boolean cya;

    public e(Context context) {
    }

    @Override // com.baidu.swan.apps.core.g.a
    public String aep() {
        if (this.cxW != null) {
            return this.cxW.alv();
        }
        if (DEBUG) {
            Log.d("V8MasterAdapter", Log.getStackTraceString(new Exception("illegal state")));
        }
        return "";
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void loadUrl(String str) {
        if (this.cxW == null) {
            final String anA = com.baidu.swan.apps.core.turbo.d.ann().anA();
            this.cxW = new d(anA, "runtime/index.js");
            this.cxX = str;
            this.cxW.a(new V8EngineConfiguration.JSCacheCallback() { // from class: com.baidu.swan.apps.core.g.e.1
                @Override // com.baidu.searchbox.v8engine.V8EngineConfiguration.JSCacheCallback
                public void onCacheResult(V8EngineConfiguration.CacheInfo cacheInfo) {
                    if (e.DEBUG) {
                        Log.d("V8MasterAdapter", "onCacheResult cached:" + cacheInfo.cached + " ,jsPath: " + cacheInfo.jsPath);
                    }
                    if (cacheInfo.cached && !TextUtils.isEmpty(cacheInfo.jsPath)) {
                        File file = new File(cacheInfo.jsPath);
                        try {
                            if (file.getPath().startsWith(new File(anA).getCanonicalPath())) {
                                e.this.cxZ = true;
                            } else if (!TextUtils.isEmpty(e.this.cxY) && file.getCanonicalPath().startsWith(new File(e.this.cxY).getCanonicalPath())) {
                                e.this.cya = true;
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
    public void a(final g gVar) {
        if (this.cxW != null) {
            this.cxW.a(new d.b() { // from class: com.baidu.swan.apps.core.g.e.2
                @Override // com.baidu.swan.apps.core.g.d.b
                public void c(com.baidu.swan.games.f.a aVar) {
                    if (gVar != null) {
                        gVar.hG(e.this.cxX);
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void destroy() {
        if (this.cxW != null) {
            this.cxW.finish();
        }
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void attachActivity(Activity activity) {
        this.cxW.G(activity);
    }

    @Override // com.baidu.swan.apps.core.g.a
    public com.baidu.swan.apps.core.container.a afd() {
        return this.cxW.getV8Engine();
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void a(com.baidu.swan.apps.core.turbo.a aVar) {
        if (com.baidu.swan.apps.t.a.asi().gX(0) && aVar != null) {
            if (DEBUG) {
                Log.d("V8MasterAdapter", "pathList item: " + aVar.appPath);
            }
            this.cxY = aVar.appPath;
            this.cxW.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.bl("appjs", aVar.appPath));
        }
    }

    public int alz() {
        return com.baidu.swan.apps.core.b.a.l(this.cxZ, this.cya);
    }
}
