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
    private d cGs;
    private String cGt;
    private String cGu;
    private boolean cGv;
    private boolean cGw;

    public e(Context context) {
    }

    @Override // com.baidu.swan.apps.core.g.a
    public String agj() {
        if (this.cGs != null) {
            return this.cGs.anp();
        }
        if (DEBUG) {
            Log.d("V8MasterAdapter", Log.getStackTraceString(new Exception("illegal state")));
        }
        return "";
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void loadUrl(String str) {
        if (this.cGs == null) {
            final String apv = com.baidu.swan.apps.core.turbo.d.aph().apv();
            this.cGs = new d(apv, "runtime/index.js");
            this.cGt = str;
            this.cGs.a(new V8EngineConfiguration.JSCacheCallback() { // from class: com.baidu.swan.apps.core.g.e.1
                @Override // com.baidu.searchbox.v8engine.V8EngineConfiguration.JSCacheCallback
                public void onCacheResult(V8EngineConfiguration.CacheInfo cacheInfo) {
                    if (e.DEBUG) {
                        Log.d("V8MasterAdapter", "onCacheResult cached:" + cacheInfo.cached + " ,jsPath: " + cacheInfo.jsPath);
                    }
                    if (cacheInfo.cached && !TextUtils.isEmpty(cacheInfo.jsPath)) {
                        File file = new File(cacheInfo.jsPath);
                        try {
                            if (file.getPath().startsWith(new File(apv).getCanonicalPath())) {
                                e.this.cGv = true;
                            } else if (!TextUtils.isEmpty(e.this.cGu) && file.getCanonicalPath().startsWith(new File(e.this.cGu).getCanonicalPath())) {
                                e.this.cGw = true;
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
        if (this.cGs != null) {
            this.cGs.a(new d.b() { // from class: com.baidu.swan.apps.core.g.e.2
                @Override // com.baidu.swan.apps.core.g.d.b
                public void c(com.baidu.swan.games.f.a aVar) {
                    if (gVar != null) {
                        gVar.hO(e.this.cGt);
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void destroy() {
        if (this.cGs != null) {
            this.cGs.finish();
        }
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void attachActivity(Activity activity) {
        this.cGs.G(activity);
    }

    @Override // com.baidu.swan.apps.core.g.a
    public com.baidu.swan.apps.core.container.a agX() {
        return this.cGs.getV8Engine();
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void a(com.baidu.swan.apps.core.turbo.a aVar) {
        if (com.baidu.swan.apps.t.a.aud().hi(0) && aVar != null) {
            if (DEBUG) {
                Log.d("V8MasterAdapter", "pathList item: " + aVar.appPath);
            }
            this.cGu = aVar.appPath;
            this.cGs.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.bs("appjs", aVar.appPath));
        }
    }

    public int ant() {
        return com.baidu.swan.apps.core.b.a.l(this.cGv, this.cGw);
    }
}
