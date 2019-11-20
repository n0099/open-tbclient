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
    private String aSi;
    private com.baidu.swan.games.binding.model.a bDL;
    private com.baidu.swan.games.e.b bxv;

    public d(com.baidu.swan.games.e.b bVar) {
        super(bVar);
        this.bxv = bVar;
    }

    public void l(JsObject jsObject) {
        reset();
        m(jsObject);
        if (TextUtils.isEmpty(this.aSi)) {
            if (DEBUG) {
                Log.i("LoadSubpackageTask", "params error");
            }
            com.baidu.swan.games.r.c.i(this.aSi, 2111, "");
            return;
        }
        c.Yj().a(this.aSi, new c.a() { // from class: com.baidu.swan.games.subpackage.d.1
            @Override // com.baidu.swan.games.subpackage.c.a
            public void Yk() {
                d.this.dl(d.this.kG(d.this.aSi));
            }

            @Override // com.baidu.swan.games.subpackage.c.a
            public void dF(int i) {
                d.this.dl(false);
                com.baidu.swan.games.r.c.i(d.this.aSi, i, "");
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
    public void dl(final boolean z) {
        if (this.bxv != null) {
            this.bxv.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.subpackage.d.2
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.bDL != null && d.this.bDL.byf != null) {
                        d.this.bDL.onComplete();
                        if (d.DEBUG) {
                            Log.i("LoadSubpackageTask", "complete call");
                        }
                    }
                    if (z) {
                        if (d.this.bDL != null && d.this.bDL.byd != null) {
                            d.this.bDL.onSuccess();
                            if (d.DEBUG) {
                                Log.i("LoadSubpackageTask", "success call");
                            }
                        }
                    } else if (d.this.bDL != null && d.this.bDL.bye != null) {
                        d.this.bDL.onFail();
                        if (d.DEBUG) {
                            Log.i("LoadSubpackageTask", "fail call");
                        }
                    }
                }
            });
        }
    }

    private void reset() {
        this.bDL = null;
        this.aSi = null;
    }

    private void m(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c c;
        if (jsObject != null && (c = com.baidu.swan.games.binding.model.c.c(jsObject)) != null) {
            this.bDL = com.baidu.swan.games.binding.model.a.e(c);
            try {
                this.aSi = c.getString("name");
            } catch (JSTypeMismatchException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                com.baidu.swan.games.utils.a.a(this.bxv, e);
                reset();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean kG(String str) {
        if (this.bxv == null) {
            return false;
        }
        String str2 = e.LE().Ln() + a.Yi().G(str, 2);
        String G = a.Yi().G(str, 3);
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(G)) {
            return false;
        }
        this.bxv.bc(str2, G);
        return true;
    }
}
