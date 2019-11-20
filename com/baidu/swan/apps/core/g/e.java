package com.baidu.swan.apps.core.g;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.swan.apps.core.g.d;
import java.io.File;
import java.io.IOException;
/* loaded from: classes2.dex */
public class e implements a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private d aMc;
    private String aMd;
    private String aMe;
    private boolean aMf;
    private boolean aMg;

    public e(Context context) {
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void loadUrl(String str) {
        if (this.aMc == null) {
            final String GX = com.baidu.swan.apps.core.j.c.GP().GX();
            this.aMc = new d(GX, "runtime/index.js");
            this.aMd = str;
            this.aMc.a(new V8EngineConfiguration.JSCacheCallback() { // from class: com.baidu.swan.apps.core.g.e.1
                @Override // com.baidu.searchbox.v8engine.V8EngineConfiguration.JSCacheCallback
                public void onCacheResult(V8EngineConfiguration.CacheInfo cacheInfo) {
                    if (e.DEBUG) {
                        Log.d("V8MasterAdapter", "onCacheResult cached:" + cacheInfo.cached + " ,jsPath: " + cacheInfo.jsPath);
                    }
                    if (cacheInfo.cached && !TextUtils.isEmpty(cacheInfo.jsPath)) {
                        File file = new File(cacheInfo.jsPath);
                        try {
                            if (file.getPath().startsWith(new File(GX).getCanonicalPath())) {
                                e.this.aMf = true;
                            } else if (!TextUtils.isEmpty(e.this.aMe) && file.getCanonicalPath().startsWith(new File(e.this.aMe).getCanonicalPath())) {
                                e.this.aMg = true;
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
    public void a(final com.baidu.swan.apps.core.c cVar) {
        if (this.aMc != null) {
            this.aMc.a(new d.b() { // from class: com.baidu.swan.apps.core.g.e.2
                @Override // com.baidu.swan.apps.core.g.d.b
                public void c(com.baidu.swan.games.e.a aVar) {
                    if (cVar != null) {
                        cVar.db(e.this.aMd);
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void destroy() {
        if (this.aMc != null) {
            this.aMc.finish();
        }
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void x(Activity activity) {
        this.aMc.x(activity);
    }

    @Override // com.baidu.swan.apps.core.g.a
    public com.baidu.swan.apps.core.container.a FZ() {
        return this.aMc.getV8Engine();
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void a(com.baidu.swan.apps.core.j.a aVar) {
        if (com.baidu.swan.apps.u.a.Jm().Bs() && aVar != null) {
            if (DEBUG) {
                Log.d("V8MasterAdapter", "pathList item: " + aVar.aNz);
            }
            this.aMe = aVar.aNz;
            this.aMc.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.ag("appjs", aVar.aNz));
        }
    }

    public int Ge() {
        return com.baidu.swan.apps.core.b.a.i(this.aMf, this.aMg);
    }
}
