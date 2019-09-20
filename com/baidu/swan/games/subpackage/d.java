package com.baidu.swan.games.subpackage;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.w.e;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
import com.baidu.swan.games.subpackage.c;
/* loaded from: classes2.dex */
public class d extends EventTargetImpl {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String azk;
    private com.baidu.swan.games.e.b bft;
    private com.baidu.swan.games.binding.model.a blO;

    public d(com.baidu.swan.games.e.b bVar) {
        super(bVar);
        this.bft = bVar;
    }

    public void l(JsObject jsObject) {
        reset();
        m(jsObject);
        if (TextUtils.isEmpty(this.azk)) {
            if (DEBUG) {
                Log.i("LoadSubpackageTask", "params error");
            }
            com.baidu.swan.games.r.c.g(this.azk, 2111, "");
            return;
        }
        c.Tu().a(this.azk, new c.a() { // from class: com.baidu.swan.games.subpackage.d.1
            @Override // com.baidu.swan.games.subpackage.c.a
            public void Tv() {
                d.this.cU(d.this.ke(d.this.azk));
            }

            @Override // com.baidu.swan.games.subpackage.c.a
            public void cK(int i) {
                d.this.cU(false);
                com.baidu.swan.games.r.c.g(d.this.azk, i, "");
            }

            @Override // com.baidu.swan.games.subpackage.c.a
            public void d(int i, long j, long j2) {
                if (d.this.hasEventListener("progressupdate")) {
                    com.baidu.swan.games.subpackage.a.a aVar = new com.baidu.swan.games.subpackage.a.a();
                    aVar.progress = i;
                    aVar.totalBytesWritten = j;
                    aVar.totalBytesExpectedToWrite = j2;
                    JSEvent jSEvent = new JSEvent("progressupdate");
                    jSEvent.data = aVar;
                    if (d.DEBUG) {
                        Log.i("LoadSubpackageTask", "progress :" + i + "totalBytesWritten :" + j + "totalBytesExpectedToWrite :" + j2);
                    }
                    d.this.dispatchEvent(jSEvent);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cU(final boolean z) {
        if (this.bft != null) {
            this.bft.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.subpackage.d.2
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.blO != null && d.this.blO.bgd != null) {
                        d.this.blO.onComplete();
                        if (d.DEBUG) {
                            Log.i("LoadSubpackageTask", "complete call");
                        }
                    }
                    if (z) {
                        if (d.this.blO != null && d.this.blO.bgb != null) {
                            d.this.blO.onSuccess();
                            if (d.DEBUG) {
                                Log.i("LoadSubpackageTask", "success call");
                            }
                        }
                    } else if (d.this.blO != null && d.this.blO.bgc != null) {
                        d.this.blO.onFail();
                        if (d.DEBUG) {
                            Log.i("LoadSubpackageTask", "fail call");
                        }
                    }
                }
            });
        }
    }

    private void reset() {
        this.blO = null;
        this.azk = null;
    }

    private void m(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c c;
        if (jsObject != null && (c = com.baidu.swan.games.binding.model.c.c(jsObject)) != null) {
            this.blO = com.baidu.swan.games.binding.model.a.e(c);
            try {
                this.azk = c.getString("name");
            } catch (JSTypeMismatchException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                com.baidu.swan.games.utils.a.a(this.bft, e);
                reset();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ke(String str) {
        if (this.bft == null) {
            return false;
        }
        String str2 = e.GJ().Gs() + a.Tt().G(str, 2);
        String G = a.Tt().G(str, 3);
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(G)) {
            return false;
        }
        this.bft.aV(str2, G);
        return true;
    }
}
