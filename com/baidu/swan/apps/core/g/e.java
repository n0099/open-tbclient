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
/* loaded from: classes25.dex */
public class e implements a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private d cRu;
    private String cRv;
    private String cRw;
    private boolean cRx;
    private boolean cRy;

    public e(Context context) {
    }

    @Override // com.baidu.swan.apps.core.g.a
    public String alj() {
        if (this.cRu != null) {
            return this.cRu.asq();
        }
        if (DEBUG) {
            Log.d("V8MasterAdapter", Log.getStackTraceString(new Exception("illegal state")));
        }
        return "";
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void loadUrl(String str) {
        if (this.cRu == null) {
            final String auv = com.baidu.swan.apps.core.turbo.d.aui().auv();
            this.cRu = new d(auv, "runtime/index.js");
            this.cRv = str;
            this.cRu.a(new V8EngineConfiguration.JSCacheCallback() { // from class: com.baidu.swan.apps.core.g.e.1
                @Override // com.baidu.searchbox.v8engine.V8EngineConfiguration.JSCacheCallback
                public void onCacheResult(V8EngineConfiguration.CacheInfo cacheInfo) {
                    if (e.DEBUG) {
                        Log.d("V8MasterAdapter", "onCacheResult cached:" + cacheInfo.cached + " ,jsPath: " + cacheInfo.jsPath);
                    }
                    if (cacheInfo.cached && !TextUtils.isEmpty(cacheInfo.jsPath)) {
                        File file = new File(cacheInfo.jsPath);
                        try {
                            if (file.getPath().startsWith(new File(auv).getCanonicalPath())) {
                                e.this.cRx = true;
                            } else if (!TextUtils.isEmpty(e.this.cRw) && file.getCanonicalPath().startsWith(new File(e.this.cRw).getCanonicalPath())) {
                                e.this.cRy = true;
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
        if (this.cRu != null) {
            this.cRu.a(new d.b() { // from class: com.baidu.swan.apps.core.g.e.2
                @Override // com.baidu.swan.apps.core.g.d.b
                public void c(com.baidu.swan.games.f.a aVar) {
                    if (gVar != null) {
                        gVar.it(e.this.cRv);
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void destroy() {
        if (this.cRu != null) {
            this.cRu.finish();
        }
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void attachActivity(Activity activity) {
        this.cRu.F(activity);
    }

    @Override // com.baidu.swan.apps.core.g.a
    public com.baidu.swan.apps.core.container.a alX() {
        return this.cRu.getV8Engine();
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void a(com.baidu.swan.apps.core.turbo.a aVar) {
        if (com.baidu.swan.apps.t.a.azd().hM(0) && aVar != null) {
            if (DEBUG) {
                Log.d("V8MasterAdapter", "pathList item: " + aVar.appPath);
            }
            this.cRw = aVar.appPath;
            this.cRu.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.by("appjs", aVar.appPath));
        }
    }

    public int asu() {
        return com.baidu.swan.apps.core.b.a.l(this.cRx, this.cRy);
    }
}
