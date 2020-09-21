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
/* loaded from: classes3.dex */
public class e implements a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private d clE;
    private String clF;
    private String clG;
    private boolean clH;
    private boolean clI;

    public e(Context context) {
    }

    @Override // com.baidu.swan.apps.core.g.a
    public String abD() {
        if (this.clE != null) {
            return this.clE.aiK();
        }
        if (DEBUG) {
            Log.d("V8MasterAdapter", Log.getStackTraceString(new Exception("illegal state")));
        }
        return "";
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void loadUrl(String str) {
        if (this.clE == null) {
            final String akP = com.baidu.swan.apps.core.turbo.d.akC().akP();
            this.clE = new d(akP, "runtime/index.js");
            this.clF = str;
            this.clE.a(new V8EngineConfiguration.JSCacheCallback() { // from class: com.baidu.swan.apps.core.g.e.1
                @Override // com.baidu.searchbox.v8engine.V8EngineConfiguration.JSCacheCallback
                public void onCacheResult(V8EngineConfiguration.CacheInfo cacheInfo) {
                    if (e.DEBUG) {
                        Log.d("V8MasterAdapter", "onCacheResult cached:" + cacheInfo.cached + " ,jsPath: " + cacheInfo.jsPath);
                    }
                    if (cacheInfo.cached && !TextUtils.isEmpty(cacheInfo.jsPath)) {
                        File file = new File(cacheInfo.jsPath);
                        try {
                            if (file.getPath().startsWith(new File(akP).getCanonicalPath())) {
                                e.this.clH = true;
                            } else if (!TextUtils.isEmpty(e.this.clG) && file.getCanonicalPath().startsWith(new File(e.this.clG).getCanonicalPath())) {
                                e.this.clI = true;
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
        if (this.clE != null) {
            this.clE.a(new d.b() { // from class: com.baidu.swan.apps.core.g.e.2
                @Override // com.baidu.swan.apps.core.g.d.b
                public void c(com.baidu.swan.games.f.a aVar) {
                    if (gVar != null) {
                        gVar.hp(e.this.clF);
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void destroy() {
        if (this.clE != null) {
            this.clE.finish();
        }
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void attachActivity(Activity activity) {
        this.clE.F(activity);
    }

    @Override // com.baidu.swan.apps.core.g.a
    public com.baidu.swan.apps.core.container.a acr() {
        return this.clE.getV8Engine();
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void a(com.baidu.swan.apps.core.turbo.a aVar) {
        if (com.baidu.swan.apps.t.a.apx().gA(0) && aVar != null) {
            if (DEBUG) {
                Log.d("V8MasterAdapter", "pathList item: " + aVar.appPath);
            }
            this.clG = aVar.appPath;
            this.clE.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.bg("appjs", aVar.appPath));
        }
    }

    public int aiO() {
        return com.baidu.swan.apps.core.b.a.l(this.clH, this.clI);
    }
}
