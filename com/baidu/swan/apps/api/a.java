package com.baidu.swan.apps.api;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.swan.apps.api.a.b;
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
    public CallbackHandler Hl() {
        return this.mCallbackHandler;
    }

    @Override // com.baidu.swan.apps.api.a.b
    @NonNull
    public com.baidu.swan.apps.core.container.a Hm() {
        return this.mJSContainer;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0053 A[Catch: Exception -> 0x0028, TryCatch #0 {Exception -> 0x0028, blocks: (B:3:0x0004, B:7:0x001b, B:9:0x001f, B:10:0x0027, B:18:0x0053, B:19:0x005b, B:21:0x0061, B:23:0x0077, B:25:0x007b, B:26:0x0083, B:28:0x0086, B:30:0x008a, B:31:0x0092, B:32:0x0093, B:34:0x009a, B:35:0x00b5, B:37:0x00b9, B:39:0x00c4, B:16:0x004e), top: B:41:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b A[Catch: Exception -> 0x0028, TryCatch #0 {Exception -> 0x0028, blocks: (B:3:0x0004, B:7:0x001b, B:9:0x001f, B:10:0x0027, B:18:0x0053, B:19:0x005b, B:21:0x0061, B:23:0x0077, B:25:0x007b, B:26:0x0083, B:28:0x0086, B:30:0x008a, B:31:0x0092, B:32:0x0093, B:34:0x009a, B:35:0x00b5, B:37:0x00b9, B:39:0x00c4, B:16:0x004e), top: B:41:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(@NonNull com.baidu.swan.apps.core.container.a aVar) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Map<String, Object> apiModules = new SwanApi$$ModulesProvider(this).getApiModules();
            Map<String, Object> a = com.baidu.swan.apps.w.a.Sh().a(this);
            if (a != null) {
                if (apiModules != null) {
                    apiModules.putAll(a);
                }
                if (a != null) {
                    if (DEBUG) {
                        throw new RuntimeException("bindSwanAppApis fail: api modules is null");
                    }
                    return;
                }
                for (Map.Entry<String, Object> entry : a.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    if (TextUtils.isEmpty(key)) {
                        if (DEBUG) {
                            throw new RuntimeException("bindSwanAppApis fail: moduleName is empty");
                        }
                    } else if (value == null) {
                        if (DEBUG) {
                            throw new RuntimeException("bindSwanAppApis fail: module obj is null");
                        }
                    } else {
                        aVar.addJavascriptInterface(value, key);
                        if (DEBUG) {
                            Log.d("Api-Binder", "bindSwanAppApis: bound " + key);
                        }
                    }
                }
                if (DEBUG) {
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    if (currentTimeMillis2 > 5) {
                        Log.w("Api-Binder", "bindSwanAppApis: 耗时 " + currentTimeMillis2 + "ms");
                        return;
                    }
                    return;
                }
                return;
            }
            a = apiModules;
            if (a != null) {
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (DEBUG) {
                throw new RuntimeException("bindSwanAppApis fail: " + e.getMessage());
            }
        }
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
