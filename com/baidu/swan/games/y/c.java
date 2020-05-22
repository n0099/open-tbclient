package com.baidu.swan.games.y;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.w.f;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
import com.baidu.swan.games.y.b;
/* loaded from: classes11.dex */
public class c extends EventTargetImpl {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.f.b cTU;
    private com.baidu.swan.games.binding.model.a dcI;
    private String dcJ;

    public c(com.baidu.swan.games.f.b bVar) {
        super(bVar);
        this.cTU = bVar;
    }

    public void n(JsObject jsObject) {
        reset();
        o(jsObject);
        if (TextUtils.isEmpty(this.dcJ)) {
            if (DEBUG) {
                Log.i("LoadSubpackageTask", "params error");
            }
            com.baidu.swan.games.v.c.k(this.dcJ, 2111, "");
            return;
        }
        b.a(this.dcJ, new b.a() { // from class: com.baidu.swan.games.y.c.1
            @Override // com.baidu.swan.games.y.b.a
            public void aBX() {
                c.this.fR(c.this.sB(c.this.dcJ));
            }

            @Override // com.baidu.swan.games.y.b.a
            public void ej(int i) {
                c.this.fR(false);
                com.baidu.swan.games.v.c.k(c.this.dcJ, i, "");
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
    public void fR(final boolean z) {
        if (this.cTU != null) {
            this.cTU.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.y.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (z) {
                        if (c.this.dcI != null) {
                            c.this.dcI.onSuccess();
                            if (c.DEBUG) {
                                Log.i("LoadSubpackageTask", "success call");
                            }
                        }
                    } else if (c.this.dcI != null) {
                        c.this.dcI.onFail();
                        if (c.DEBUG) {
                            Log.i("LoadSubpackageTask", "fail call");
                        }
                    }
                }
            });
        }
    }

    private void reset() {
        this.dcI = null;
        this.dcJ = null;
    }

    private void o(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e;
        if (jsObject != null && (e = com.baidu.swan.games.binding.model.c.e(jsObject)) != null) {
            this.dcI = com.baidu.swan.games.binding.model.a.f(e);
            try {
                this.dcJ = e.getString("name");
            } catch (JSTypeMismatchException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
                com.baidu.swan.games.utils.b.a(this.cTU, e2);
                reset();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sB(String str) {
        if (this.cTU == null) {
            return false;
        }
        String str2 = f.ahV().ahC() + a.aBW().X(str, 2);
        String X = a.aBW().X(str, 3);
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(X)) {
            return false;
        }
        this.cTU.ck(str2, X);
        return true;
    }
}
