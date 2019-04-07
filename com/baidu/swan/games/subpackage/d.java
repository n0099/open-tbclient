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
    private String axr;
    private com.baidu.swan.games.e.b bac;
    private com.baidu.swan.games.binding.model.a bfr;

    public d(com.baidu.swan.games.e.b bVar) {
        super(bVar);
        this.bac = bVar;
    }

    public void k(JsObject jsObject) {
        reset();
        l(jsObject);
        if (TextUtils.isEmpty(this.axr)) {
            if (DEBUG) {
                Log.i("LoadSubpackageTask", "params error");
                return;
            }
            return;
        }
        c.Pe().a(this.axr, new c.a() { // from class: com.baidu.swan.games.subpackage.d.1
            @Override // com.baidu.swan.games.subpackage.c.a
            public void Pf() {
                d.this.cA(d.this.jb(d.this.axr));
            }

            @Override // com.baidu.swan.games.subpackage.c.a
            public void cF(int i) {
                d.this.cA(false);
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
    public void cA(final boolean z) {
        if (this.bac != null) {
            this.bac.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.subpackage.d.2
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.bfr != null && d.this.bfr.baV != null) {
                        d.this.bfr.onComplete();
                        if (d.DEBUG) {
                            Log.i("LoadSubpackageTask", "complete call");
                        }
                    }
                    if (z) {
                        if (d.this.bfr != null && d.this.bfr.baT != null) {
                            d.this.bfr.onSuccess();
                            if (d.DEBUG) {
                                Log.i("LoadSubpackageTask", "success call");
                            }
                        }
                    } else if (d.this.bfr != null && d.this.bfr.baU != null) {
                        d.this.bfr.onFail();
                        if (d.DEBUG) {
                            Log.i("LoadSubpackageTask", "fail call");
                        }
                    }
                }
            });
        }
    }

    private void reset() {
        this.bfr = null;
        this.axr = null;
    }

    private void l(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c b;
        if (jsObject != null && (b = com.baidu.swan.games.binding.model.c.b(jsObject)) != null) {
            this.bfr = com.baidu.swan.games.binding.model.a.a(b);
            try {
                this.axr = b.getString("name");
            } catch (JSTypeMismatchException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                com.baidu.swan.games.utils.a.a(this.bac, e);
                reset();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean jb(String str) {
        if (this.bac == null) {
            return false;
        }
        String str2 = e.Ea().DJ() + a.Pd().L(str, 2);
        String L = a.Pd().L(str, 3);
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(L)) {
            return false;
        }
        this.bac.aS(str2, L);
        return true;
    }
}
