package com.baidu.swan.apps.api;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.swan.apps.api.a.b;
import com.baidu.swan.apps.api.module.network.SwanApiNetworkV8Module;
import java.lang.ref.WeakReference;
import java.util.Map;
/* loaded from: classes10.dex */
public class a implements b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private WeakReference<Activity> mActivityRef;
    @NonNull
    private CallbackHandler mCallbackHandler;
    @NonNull
    protected Context mContext;
    private com.baidu.swan.apps.core.container.a mJSContainer;

    public a(@NonNull Context context, @NonNull CallbackHandler callbackHandler, @NonNull com.baidu.swan.apps.core.container.a aVar) {
        this.mContext = context;
        this.mCallbackHandler = callbackHandler;
        this.mJSContainer = aVar;
    }

    @Override // com.baidu.swan.apps.api.a.b
    @NonNull
    public Context getContext() {
        return getDispatchContext();
    }

    @Override // com.baidu.swan.apps.api.a.b
    @NonNull
    public CallbackHandler afc() {
        return this.mCallbackHandler;
    }

    @Override // com.baidu.swan.apps.api.a.b
    @NonNull
    public com.baidu.swan.apps.core.container.a afd() {
        return this.mJSContainer;
    }

    public final void a(@NonNull com.baidu.swan.apps.core.container.a aVar) {
        if (aVar instanceof com.baidu.swan.games.f.b) {
            a((com.baidu.swan.games.f.b) aVar);
        } else {
            b(aVar);
        }
    }

    private void a(@NonNull com.baidu.swan.games.f.b bVar) {
        a(bVar, SwanApi$$ModulesProvider.getV8ApiModules(this), com.baidu.swan.apps.t.a.asI().getV8ApiModules(this));
    }

    private void b(@NonNull com.baidu.swan.apps.core.container.a aVar) {
        a(aVar, SwanApi$$ModulesProvider.getWebviewApiModules(this), com.baidu.swan.apps.t.a.asI().getWebviewApiModules(this));
    }

    private void a(@NonNull com.baidu.swan.apps.core.container.a aVar, Map<String, Object> map, Map<String, Object> map2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (map2 != null) {
            if (map == null) {
                map = map2;
            } else {
                try {
                    map.putAll(map2);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (DEBUG) {
                        throw new RuntimeException("doBindSwanApis fail: " + e.getMessage());
                    }
                    return;
                }
            }
        }
        if (map == null) {
            if (DEBUG) {
                throw new RuntimeException("doBindSwanApis fail: api modules cannot be null");
            }
            return;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (TextUtils.isEmpty(key)) {
                if (DEBUG) {
                    throw new RuntimeException("doBindSwanApis fail: moduleName cannot be empty");
                }
            } else if (value == null) {
                if (DEBUG) {
                    throw new RuntimeException("doBindSwanApis fail: module obj cannot be null");
                }
            } else {
                aVar.addJavascriptInterface(value, key);
                if (DEBUG) {
                    Log.d("Api-Binder", "doBindSwanApis(" + (aVar instanceof com.baidu.swan.games.f.b ? "V8" : "Webview") + "): bound " + key);
                }
            }
        }
        if (DEBUG) {
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (currentTimeMillis2 > 5) {
                Log.w("Api-Binder", "doBindSwanApis: 耗时 " + currentTimeMillis2 + "ms");
            }
        }
    }

    public void c(@NonNull com.baidu.swan.apps.core.container.a aVar) {
        aVar.addJavascriptInterface(new SwanApiNetworkV8Module(this), SwanApiNetworkV8Module.MODULE_NAME);
    }

    public void setActivityRef(Activity activity) {
        if (activity != null) {
            this.mActivityRef = new WeakReference<>(activity);
        }
    }

    @NonNull
    private Context getDispatchContext() {
        Activity activity = this.mActivityRef != null ? this.mActivityRef.get() : null;
        if (activity == null) {
            return this.mContext;
        }
        return activity;
    }
}
