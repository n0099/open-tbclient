package com.baidu.swan.games.network.b.a;

import android.util.Log;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.games.network.b.d;
import com.baidu.swan.games.network.b.e;
import com.baidu.swan.games.network.c.c;
import okhttp3.Request;
/* loaded from: classes7.dex */
public class b extends c implements com.baidu.swan.games.network.b.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private e dkZ;

    public b(com.baidu.swan.games.f.b bVar, com.baidu.swan.games.binding.model.c cVar) {
        super(bVar, cVar);
        this.dkZ = new e(this);
    }

    @Override // com.baidu.swan.games.network.a
    public void j(com.baidu.swan.games.binding.model.c cVar) {
        super.j(cVar);
        this.dkZ.aFO();
    }

    @Override // com.baidu.swan.games.network.c.c
    protected void d(Request request) {
        if (this.dkI != null) {
            d.aFN().a(this.dkI.optString("url"), this);
            super.d(request);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.games.network.a
    public void onSuccess(Object obj) {
        this.dkZ.onSuccess(obj);
    }

    @Override // com.baidu.swan.games.network.c.c, com.baidu.swan.games.network.a
    protected void i(String str, int i, String str2) {
        this.dkZ.i(str, i, str2);
    }

    @Override // com.baidu.swan.games.network.a, com.baidu.searchbox.v8engine.event.EventTargetImpl, com.baidu.searchbox.v8engine.event.EventTarget
    public boolean dispatchEvent(JSEvent jSEvent) {
        return this.dkZ.b(jSEvent);
    }

    @Override // com.baidu.swan.games.network.b.a
    public void a(com.baidu.swan.games.network.b.b bVar) {
        if (bVar != null && bVar.data != null) {
            if (DEBUG) {
                Log.d("PreRequestTask", "onDispatchResponseData type:" + bVar.type + ";data:" + bVar.data);
            }
            switch (bVar.type) {
                case 1:
                    super.onSuccess(bVar.data);
                    return;
                case 2:
                    com.baidu.swan.games.network.c.b bVar2 = (com.baidu.swan.games.network.c.b) bVar.data;
                    super.i(bVar2.url, bVar2.statusCode, bVar2.errMsg);
                    return;
                case 3:
                    super.dispatchEvent((JSEvent) bVar.data);
                    return;
                default:
                    return;
            }
        }
    }
}
