package com.baidu.swan.games.y;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
import com.baidu.swan.games.y.b;
/* loaded from: classes3.dex */
public class c extends EventTargetImpl {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.f.b dqC;
    private com.baidu.swan.games.binding.model.a dzn;
    private String dzo;

    public c(com.baidu.swan.games.f.b bVar) {
        super(bVar);
        this.dqC = bVar;
    }

    public void n(JsObject jsObject) {
        reset();
        o(jsObject);
        if (TextUtils.isEmpty(this.dzo)) {
            if (DEBUG) {
                Log.i("LoadSubpackageTask", "params error");
            }
            com.baidu.swan.games.v.c.k(this.dzo, 2111, "");
            return;
        }
        b.a(this.dzo, new b.a() { // from class: com.baidu.swan.games.y.c.1
            @Override // com.baidu.swan.games.y.b.a
            public void aQm() {
                c.this.gI(c.this.wr(c.this.dzo));
            }

            @Override // com.baidu.swan.games.y.b.a
            public void gE(int i) {
                c.this.gI(false);
                com.baidu.swan.games.v.c.k(c.this.dzo, i, "");
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
    public void gI(final boolean z) {
        if (this.dqC != null) {
            this.dqC.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.y.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (z) {
                        if (c.this.dzn != null) {
                            c.this.dzn.onSuccess();
                            if (c.DEBUG) {
                                Log.i("LoadSubpackageTask", "success call");
                            }
                        }
                    } else if (c.this.dzn != null) {
                        c.this.dzn.onFail();
                        if (c.DEBUG) {
                            Log.i("LoadSubpackageTask", "fail call");
                        }
                    }
                }
            });
        }
    }

    private void reset() {
        this.dzn = null;
        this.dzo = null;
    }

    private void o(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e;
        if (jsObject != null && (e = com.baidu.swan.games.binding.model.c.e(jsObject)) != null) {
            this.dzn = com.baidu.swan.games.binding.model.a.f(e);
            try {
                this.dzo = e.getString("name");
            } catch (JSTypeMismatchException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
                com.baidu.swan.games.utils.b.a(this.dqC, e2);
                reset();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean wr(String str) {
        if (this.dqC == null) {
            return false;
        }
        String str2 = f.asJ().asq() + a.aQl().Z(str, 2);
        String Z = a.aQl().Z(str, 3);
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(Z)) {
            return false;
        }
        this.dqC.cJ(str2, Z);
        return true;
    }
}
