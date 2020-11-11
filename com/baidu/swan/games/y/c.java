package com.baidu.swan.games.y;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
import com.baidu.swan.games.y.b;
/* loaded from: classes10.dex */
public class c extends EventTargetImpl {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.f.b dQV;
    private com.baidu.swan.games.binding.model.a dZD;
    private String dZE;

    public c(com.baidu.swan.games.f.b bVar) {
        super(bVar);
        this.dQV = bVar;
    }

    public void n(JsObject jsObject) {
        reset();
        o(jsObject);
        if (TextUtils.isEmpty(this.dZE)) {
            if (DEBUG) {
                Log.i("LoadSubpackageTask", "params error");
            }
            com.baidu.swan.games.v.c.n(this.dZE, 2111, "");
            return;
        }
        b.a(this.dZE, new b.a() { // from class: com.baidu.swan.games.y.c.1
            @Override // com.baidu.swan.games.y.b.a
            public void aXp() {
                c.this.hA(c.this.xK(c.this.dZE));
            }

            @Override // com.baidu.swan.games.y.b.a
            public void hw(int i) {
                c.this.hA(false);
                com.baidu.swan.games.v.c.n(c.this.dZE, i, "");
            }

            @Override // com.baidu.swan.games.y.b.a
            public void e(int i, long j, long j2) {
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
    public void hA(final boolean z) {
        if (this.dQV != null) {
            this.dQV.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.y.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (z) {
                        if (c.this.dZD != null) {
                            c.this.dZD.onSuccess();
                            if (c.DEBUG) {
                                Log.i("LoadSubpackageTask", "success call");
                            }
                        }
                    } else if (c.this.dZD != null) {
                        c.this.dZD.onFail();
                        if (c.DEBUG) {
                            Log.i("LoadSubpackageTask", "fail call");
                        }
                    }
                }
            });
        }
    }

    private void reset() {
        this.dZD = null;
        this.dZE = null;
    }

    private void o(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e;
        if (jsObject != null && (e = com.baidu.swan.games.binding.model.c.e(jsObject)) != null) {
            this.dZD = com.baidu.swan.games.binding.model.a.f(e);
            try {
                this.dZE = e.getString("name");
            } catch (JSTypeMismatchException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
                com.baidu.swan.games.utils.b.a(this.dQV, e2);
                reset();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xK(String str) {
        if (this.dQV == null) {
            return false;
        }
        String str2 = f.azO().azv() + a.aXo().ac(str, 2);
        String ac = a.aXo().ac(str, 3);
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(ac)) {
            return false;
        }
        this.dQV.cV(str2, ac);
        return true;
    }
}
