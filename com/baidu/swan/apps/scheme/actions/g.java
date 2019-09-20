package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.support.annotation.AnyThread;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.a.b.a;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g extends z {
    private List<String> aSK;
    private AtomicBoolean aSL;

    public g(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swan/downloadPackages");
        this.aSL = new AtomicBoolean(false);
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        com.baidu.swan.apps.console.c.i("DownloadPackagesAction", "call DownloadPackagesAction, thread=" + Thread.currentThread().getName());
        if (this.aSK == null) {
            this.aSK = Collections.synchronizedList(new ArrayList());
        }
        JSONObject c = c(unitedSchemeEntity, "params");
        if (c == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "invalid parameter");
            return false;
        }
        JSONArray optJSONArray = c.optJSONArray("appKeys");
        String param = unitedSchemeEntity.getParam(ImageViewerConfig.ABTEST);
        if (!TextUtils.isEmpty(param)) {
            com.baidu.swan.apps.core.a.c.apW = param;
            com.baidu.swan.apps.v.a.setInfo(com.baidu.swan.apps.core.a.c.apW);
        }
        if (optJSONArray == null || optJSONArray.length() == 0) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "appKeys must not empty");
            return false;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            String optString = optJSONArray.optString(i);
            if (optString != null) {
                this.aSK.add(optString);
            }
        }
        if (!SwanAppNetworkUtils.isWifiNetworkConnected(context)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "Network limitation");
            return false;
        }
        if (!this.aSL.getAndSet(true)) {
            MU();
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AnyThread
    public void MU() {
        if (this.aSK == null || this.aSK.isEmpty()) {
            this.aSL.set(false);
            com.baidu.swan.apps.console.c.i("DownloadPackagesAction", "preload finish");
            return;
        }
        final String remove = this.aSK.remove(0);
        com.baidu.swan.apps.console.c.i("DownloadPackagesAction", "preload " + remove + ", waitSize=" + this.aSK.size() + " , thread=" + Thread.currentThread().getName());
        com.baidu.swan.apps.core.a.b.a.a(remove, new a.InterfaceC0141a() { // from class: com.baidu.swan.apps.scheme.actions.g.1
            @Override // com.baidu.swan.apps.core.a.b.a.InterfaceC0141a
            public void zo() {
                com.baidu.swan.apps.console.c.w("DownloadPackagesAction", "swanAppIdInvalid: " + remove);
                g.this.MU();
            }

            @Override // com.baidu.swan.apps.core.a.b.a.InterfaceC0141a
            public void zp() {
                com.baidu.swan.apps.console.c.i("DownloadPackagesAction", "preDownloadSuccess: " + remove);
                g.this.MU();
            }

            @Override // com.baidu.swan.apps.core.a.b.a.InterfaceC0141a
            public void ca(int i) {
                com.baidu.swan.apps.console.c.w("DownloadPackagesAction", "preDownloadFailed: " + remove + ", errorCode:" + i);
                g.this.MU();
            }
        }, "2");
    }
}
