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
    private String ayM;
    private com.baidu.swan.games.e.b beU;
    private com.baidu.swan.games.binding.model.a blq;

    public d(com.baidu.swan.games.e.b bVar) {
        super(bVar);
        this.beU = bVar;
    }

    public void l(JsObject jsObject) {
        reset();
        m(jsObject);
        if (TextUtils.isEmpty(this.ayM)) {
            if (DEBUG) {
                Log.i("LoadSubpackageTask", "params error");
            }
            com.baidu.swan.games.r.c.g(this.ayM, 2111, "");
            return;
        }
        c.Tq().a(this.ayM, new c.a() { // from class: com.baidu.swan.games.subpackage.d.1
            @Override // com.baidu.swan.games.subpackage.c.a
            public void Tr() {
                d.this.cU(d.this.kc(d.this.ayM));
            }

            @Override // com.baidu.swan.games.subpackage.c.a
            public void cJ(int i) {
                d.this.cU(false);
                com.baidu.swan.games.r.c.g(d.this.ayM, i, "");
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
        if (this.beU != null) {
            this.beU.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.subpackage.d.2
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.blq != null && d.this.blq.bfF != null) {
                        d.this.blq.onComplete();
                        if (d.DEBUG) {
                            Log.i("LoadSubpackageTask", "complete call");
                        }
                    }
                    if (z) {
                        if (d.this.blq != null && d.this.blq.bfD != null) {
                            d.this.blq.onSuccess();
                            if (d.DEBUG) {
                                Log.i("LoadSubpackageTask", "success call");
                            }
                        }
                    } else if (d.this.blq != null && d.this.blq.bfE != null) {
                        d.this.blq.onFail();
                        if (d.DEBUG) {
                            Log.i("LoadSubpackageTask", "fail call");
                        }
                    }
                }
            });
        }
    }

    private void reset() {
        this.blq = null;
        this.ayM = null;
    }

    private void m(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c c;
        if (jsObject != null && (c = com.baidu.swan.games.binding.model.c.c(jsObject)) != null) {
            this.blq = com.baidu.swan.games.binding.model.a.e(c);
            try {
                this.ayM = c.getString("name");
            } catch (JSTypeMismatchException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                com.baidu.swan.games.utils.a.a(this.beU, e);
                reset();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean kc(String str) {
        if (this.beU == null) {
            return false;
        }
        String str2 = e.GF().Go() + a.Tp().G(str, 2);
        String G = a.Tp().G(str, 3);
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(G)) {
            return false;
        }
        this.beU.aV(str2, G);
        return true;
    }
}
