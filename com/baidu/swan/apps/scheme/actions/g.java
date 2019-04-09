package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.support.annotation.AnyThread;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.a.b.a;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g extends y {
    private List<String> aPy;
    private AtomicBoolean aPz;

    public g(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swan/downloadPackages");
        this.aPz = new AtomicBoolean(false);
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        com.baidu.swan.apps.console.c.i("DownloadPackagesAction", "call DownloadPackagesAction, thread=" + Thread.currentThread().getName());
        if (this.aPy == null) {
            this.aPy = Collections.synchronizedList(new ArrayList());
        }
        JSONObject c = c(unitedSchemeEntity, "params");
        if (c == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "invalid parameter");
            return false;
        }
        JSONArray optJSONArray = c.optJSONArray("appKeys");
        String optString = c.optString("abTest", null);
        if (!TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.core.a.c.aoI = optString;
        }
        if (optJSONArray == null || optJSONArray.length() == 0) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "appKeys must not empty");
            return false;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            String optString2 = optJSONArray.optString(i);
            if (optString2 != null) {
                this.aPy.add(optString2);
            }
        }
        if (!SwanAppNetworkUtils.isWifiNetworkConnected(context)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "Network limitation");
            return false;
        }
        if (!this.aPz.getAndSet(true)) {
            JH();
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public void JH() {
        if (this.aPy == null || this.aPy.isEmpty()) {
            this.aPz.set(false);
            com.baidu.swan.apps.console.c.i("DownloadPackagesAction", "preload finish");
            return;
        }
        final String remove = this.aPy.remove(0);
        com.baidu.swan.apps.console.c.i("DownloadPackagesAction", "preload " + remove + ", waitSize=" + this.aPy.size() + " , thread=" + Thread.currentThread().getName());
        com.baidu.swan.apps.core.a.b.a.a(remove, new a.InterfaceC0127a() { // from class: com.baidu.swan.apps.scheme.actions.g.1
            @Override // com.baidu.swan.apps.core.a.b.a.InterfaceC0127a
            public void xM() {
                com.baidu.swan.apps.console.c.w("DownloadPackagesAction", "swanAppIdInvalid: " + remove);
                g.this.JH();
            }

            @Override // com.baidu.swan.apps.core.a.b.a.InterfaceC0127a
            public void xN() {
                com.baidu.swan.apps.console.c.i("DownloadPackagesAction", "preDownloadSuccess: " + remove);
                g.this.JH();
            }

            @Override // com.baidu.swan.apps.core.a.b.a.InterfaceC0127a
            public void bZ(int i) {
                com.baidu.swan.apps.console.c.w("DownloadPackagesAction", "preDownloadFailed: " + remove + ", errorCode:" + i);
                g.this.JH();
            }
        }, "2");
    }
}
