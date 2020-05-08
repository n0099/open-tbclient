package com.baidu.swan.games.x;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.y.f;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
import com.baidu.swan.games.x.b;
/* loaded from: classes11.dex */
public class c extends EventTargetImpl {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.e.b cJn;
    private com.baidu.swan.games.binding.model.a cRK;
    private String cRL;

    public c(com.baidu.swan.games.e.b bVar) {
        super(bVar);
        this.cJn = bVar;
    }

    public void l(JsObject jsObject) {
        reset();
        m(jsObject);
        if (TextUtils.isEmpty(this.cRL)) {
            if (DEBUG) {
                Log.i("LoadSubpackageTask", "params error");
            }
            com.baidu.swan.games.u.c.k(this.cRL, 2111, "");
            return;
        }
        b.a(this.cRL, new b.a() { // from class: com.baidu.swan.games.x.c.1
            @Override // com.baidu.swan.games.x.b.a
            public void ayg() {
                c.this.fG(c.this.qX(c.this.cRL));
            }

            @Override // com.baidu.swan.games.x.b.a
            public void ed(int i) {
                c.this.fG(false);
                com.baidu.swan.games.u.c.k(c.this.cRL, i, "");
            }

            @Override // com.baidu.swan.games.x.b.a
            public void d(int i, long j, long j2) {
                if (c.this.hasEventListener("progressupdate")) {
                    com.baidu.swan.games.x.a.a aVar = new com.baidu.swan.games.x.a.a();
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
    public void fG(final boolean z) {
        if (this.cJn != null) {
            this.cJn.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.x.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (z) {
                        if (c.this.cRK != null) {
                            c.this.cRK.onSuccess();
                            if (c.DEBUG) {
                                Log.i("LoadSubpackageTask", "success call");
                            }
                        }
                    } else if (c.this.cRK != null) {
                        c.this.cRK.onFail();
                        if (c.DEBUG) {
                            Log.i("LoadSubpackageTask", "fail call");
                        }
                    }
                }
            });
        }
    }

    private void reset() {
        this.cRK = null;
        this.cRL = null;
    }

    private void m(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c c;
        if (jsObject != null && (c = com.baidu.swan.games.binding.model.c.c(jsObject)) != null) {
            this.cRK = com.baidu.swan.games.binding.model.a.f(c);
            try {
                this.cRL = c.getString("name");
            } catch (JSTypeMismatchException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                com.baidu.swan.games.utils.b.a(this.cJn, e);
                reset();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean qX(String str) {
        if (this.cJn == null) {
            return false;
        }
        String str2 = f.aeJ().aer() + a.ayf().W(str, 2);
        String W = a.ayf().W(str, 3);
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(W)) {
            return false;
        }
        this.cJn.bP(str2, W);
        return true;
    }
}
