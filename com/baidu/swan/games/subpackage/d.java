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
    private String aSA;
    private com.baidu.swan.games.binding.model.a bEC;
    private com.baidu.swan.games.e.b bym;

    public d(com.baidu.swan.games.e.b bVar) {
        super(bVar);
        this.bym = bVar;
    }

    public void l(JsObject jsObject) {
        reset();
        m(jsObject);
        if (TextUtils.isEmpty(this.aSA)) {
            if (DEBUG) {
                Log.i("LoadSubpackageTask", "params error");
            }
            com.baidu.swan.games.r.c.i(this.aSA, 2111, "");
            return;
        }
        c.Yl().a(this.aSA, new c.a() { // from class: com.baidu.swan.games.subpackage.d.1
            @Override // com.baidu.swan.games.subpackage.c.a
            public void Ym() {
                d.this.dl(d.this.kG(d.this.aSA));
            }

            @Override // com.baidu.swan.games.subpackage.c.a
            public void dF(int i) {
                d.this.dl(false);
                com.baidu.swan.games.r.c.i(d.this.aSA, i, "");
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
        if (this.bym != null) {
            this.bym.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.subpackage.d.2
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.bEC != null && d.this.bEC.byW != null) {
                        d.this.bEC.onComplete();
                        if (d.DEBUG) {
                            Log.i("LoadSubpackageTask", "complete call");
                        }
                    }
                    if (z) {
                        if (d.this.bEC != null && d.this.bEC.byU != null) {
                            d.this.bEC.onSuccess();
                            if (d.DEBUG) {
                                Log.i("LoadSubpackageTask", "success call");
                            }
                        }
                    } else if (d.this.bEC != null && d.this.bEC.byV != null) {
                        d.this.bEC.onFail();
                        if (d.DEBUG) {
                            Log.i("LoadSubpackageTask", "fail call");
                        }
                    }
                }
            });
        }
    }

    private void reset() {
        this.bEC = null;
        this.aSA = null;
    }

    private void m(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c c;
        if (jsObject != null && (c = com.baidu.swan.games.binding.model.c.c(jsObject)) != null) {
            this.bEC = com.baidu.swan.games.binding.model.a.e(c);
            try {
                this.aSA = c.getString("name");
            } catch (JSTypeMismatchException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                com.baidu.swan.games.utils.a.a(this.bym, e);
                reset();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean kG(String str) {
        if (this.bym == null) {
            return false;
        }
        String str2 = e.LD().Lm() + a.Yk().G(str, 2);
        String G = a.Yk().G(str, 3);
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(G)) {
            return false;
        }
        this.bym.bc(str2, G);
        return true;
    }
}
