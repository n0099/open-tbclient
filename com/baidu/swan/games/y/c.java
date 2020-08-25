package com.baidu.swan.games.y;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
import com.baidu.swan.games.y.b;
/* loaded from: classes8.dex */
public class c extends EventTargetImpl {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.f.b dox;
    private com.baidu.swan.games.binding.model.a dxi;
    private String dxj;

    public c(com.baidu.swan.games.f.b bVar) {
        super(bVar);
        this.dox = bVar;
    }

    public void n(JsObject jsObject) {
        reset();
        o(jsObject);
        if (TextUtils.isEmpty(this.dxj)) {
            if (DEBUG) {
                Log.i("LoadSubpackageTask", "params error");
            }
            com.baidu.swan.games.v.c.k(this.dxj, 2111, "");
            return;
        }
        b.a(this.dxj, new b.a() { // from class: com.baidu.swan.games.y.c.1
            @Override // com.baidu.swan.games.y.b.a
            public void aPB() {
                c.this.gJ(c.this.vX(c.this.dxj));
            }

            @Override // com.baidu.swan.games.y.b.a
            public void gv(int i) {
                c.this.gJ(false);
                com.baidu.swan.games.v.c.k(c.this.dxj, i, "");
            }

            @Override // com.baidu.swan.games.y.b.a
            public void d(int i, long j, long j2) {
                if (c.this.hasEventListener("progressupdate")) {
                    com.baidu.swan.games.y.a.a aVar = new com.baidu.swan.games.y.a.a();
                    aVar.progress = i;
                    aVar.totalBytesWritten = j;
                    aVar.totalBytesExpectedToWrite = j2;
                    JSEvent jSEvent = new JSEvent("progressupdate");
                    jSEvent.data = aVar;
                    if (c.DEBUG) {
                        Log.i("LoadSubpackageTask", "progress :" + i + "totalBytesWritten :" + j + "totalBytesExpectedToWrite :" + j2);
                    }
                    c.this.dispatchEvent(jSEvent);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gJ(final boolean z) {
        if (this.dox != null) {
            this.dox.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.y.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (z) {
                        if (c.this.dxi != null) {
                            c.this.dxi.onSuccess();
                            if (c.DEBUG) {
                                Log.i("LoadSubpackageTask", "success call");
                            }
                        }
                    } else if (c.this.dxi != null) {
                        c.this.dxi.onFail();
                        if (c.DEBUG) {
                            Log.i("LoadSubpackageTask", "fail call");
                        }
                    }
                }
            });
        }
    }

    private void reset() {
        this.dxi = null;
        this.dxj = null;
    }

    private void o(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e;
        if (jsObject != null && (e = com.baidu.swan.games.binding.model.c.e(jsObject)) != null) {
            this.dxi = com.baidu.swan.games.binding.model.a.f(e);
            try {
                this.dxj = e.getString("name");
            } catch (JSTypeMismatchException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
                com.baidu.swan.games.utils.b.a(this.dox, e2);
                reset();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean vX(String str) {
        if (this.dox == null) {
            return false;
        }
        String str2 = f.arY().arF() + a.aPA().Z(str, 2);
        String Z = a.aPA().Z(str, 3);
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(Z)) {
            return false;
        }
        this.dox.cJ(str2, Z);
        return true;
    }
}
