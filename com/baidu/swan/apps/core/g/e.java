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
    private d cMl;
    private String cMm;
    private String cMn;
    private boolean cMo;
    private boolean cMp;

    public e(Context context) {
    }

    @Override // com.baidu.swan.apps.core.g.a
    public String aiJ() {
        if (this.cMl != null) {
            return this.cMl.apQ();
        }
        if (DEBUG) {
            Log.d("V8MasterAdapter", Log.getStackTraceString(new Exception("illegal state")));
        }
        return "";
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void loadUrl(String str) {
        if (this.cMl == null) {
            final String arV = com.baidu.swan.apps.core.turbo.d.arI().arV();
            this.cMl = new d(arV, "runtime/index.js");
            this.cMm = str;
            this.cMl.a(new V8EngineConfiguration.JSCacheCallback() { // from class: com.baidu.swan.apps.core.g.e.1
                @Override // com.baidu.searchbox.v8engine.V8EngineConfiguration.JSCacheCallback
                public void onCacheResult(V8EngineConfiguration.CacheInfo cacheInfo) {
                    if (e.DEBUG) {
                        Log.d("V8MasterAdapter", "onCacheResult cached:" + cacheInfo.cached + " ,jsPath: " + cacheInfo.jsPath);
                    }
                    if (cacheInfo.cached && !TextUtils.isEmpty(cacheInfo.jsPath)) {
                        File file = new File(cacheInfo.jsPath);
                        try {
                            if (file.getPath().startsWith(new File(arV).getCanonicalPath())) {
                                e.this.cMo = true;
                            } else if (!TextUtils.isEmpty(e.this.cMn) && file.getCanonicalPath().startsWith(new File(e.this.cMn).getCanonicalPath())) {
                                e.this.cMp = true;
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
        if (this.cMl != null) {
            this.cMl.a(new d.b() { // from class: com.baidu.swan.apps.core.g.e.2
                @Override // com.baidu.swan.apps.core.g.d.b
                public void c(com.baidu.swan.games.f.a aVar) {
                    if (gVar != null) {
                        gVar.hV(e.this.cMm);
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void destroy() {
        if (this.cMl != null) {
            this.cMl.finish();
        }
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void attachActivity(Activity activity) {
        this.cMl.G(activity);
    }

    @Override // com.baidu.swan.apps.core.g.a
    public com.baidu.swan.apps.core.container.a ajx() {
        return this.cMl.getV8Engine();
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void a(com.baidu.swan.apps.core.turbo.a aVar) {
        if (com.baidu.swan.apps.t.a.awD().hs(0) && aVar != null) {
            if (DEBUG) {
                Log.d("V8MasterAdapter", "pathList item: " + aVar.appPath);
            }
            this.cMn = aVar.appPath;
            this.cMl.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.bs("appjs", aVar.appPath));
        }
    }

    public int apU() {
        return com.baidu.swan.apps.core.b.a.l(this.cMo, this.cMp);
    }
}
