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
    private d asc;
    private String asd;
    private String ase;
    private boolean asf;
    private boolean asg;

    public e(Context context) {
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void loadUrl(String str) {
        if (this.asc == null) {
            final String Bq = com.baidu.swan.apps.core.j.c.Bi().Bq();
            this.asc = new d(Bq, "runtime/index.js");
            this.asd = str;
            this.asc.a(new V8EngineConfiguration.JSCacheCallback() { // from class: com.baidu.swan.apps.core.g.e.1
                @Override // com.baidu.searchbox.v8engine.V8EngineConfiguration.JSCacheCallback
                public void onCacheResult(V8EngineConfiguration.CacheInfo cacheInfo) {
                    if (e.DEBUG) {
                        Log.d("V8MasterAdapter", "onCacheResult cached:" + cacheInfo.cached + " ,jsPath: " + cacheInfo.jsPath);
                    }
                    if (cacheInfo.cached && !TextUtils.isEmpty(cacheInfo.jsPath)) {
                        File file = new File(cacheInfo.jsPath);
                        try {
                            if (file.getPath().startsWith(new File(Bq).getCanonicalPath())) {
                                e.this.asf = true;
                            } else if (!TextUtils.isEmpty(e.this.ase) && file.getCanonicalPath().startsWith(new File(e.this.ase).getCanonicalPath())) {
                                e.this.asg = true;
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
        if (this.asc != null) {
            this.asc.a(new d.b() { // from class: com.baidu.swan.apps.core.g.e.2
                @Override // com.baidu.swan.apps.core.g.d.b
                public void c(com.baidu.swan.games.e.a aVar) {
                    if (cVar != null) {
                        cVar.ds(e.this.asd);
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void destroy() {
        if (this.asc != null) {
            this.asc.finish();
        }
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void v(Activity activity) {
        this.asc.v(activity);
    }

    @Override // com.baidu.swan.apps.core.g.a
    public com.baidu.swan.apps.core.container.a Ar() {
        return this.asc.getV8Engine();
    }

    @Override // com.baidu.swan.apps.core.g.a
    public void a(com.baidu.swan.apps.core.j.a aVar) {
        if (com.baidu.swan.apps.u.a.DE().vS() && aVar != null) {
            if (DEBUG) {
                Log.d("V8MasterAdapter", "pathList item: " + aVar.atz);
            }
            this.ase = aVar.atz;
            this.asc.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.Y("appjs", aVar.atz));
        }
    }

    public int Aw() {
        return com.baidu.swan.apps.core.b.a.e(this.asf, this.asg);
    }
}
