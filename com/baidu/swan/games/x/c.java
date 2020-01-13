package com.baidu.swan.games.x;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.y.f;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
import com.baidu.swan.games.x.b;
/* loaded from: classes10.dex */
public class c extends EventTargetImpl {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.e.b cfV;
    private com.baidu.swan.games.binding.model.a cow;
    private String cox;

    public c(com.baidu.swan.games.e.b bVar) {
        super(bVar);
        this.cfV = bVar;
    }

    public void l(JsObject jsObject) {
        reset();
        m(jsObject);
        if (TextUtils.isEmpty(this.cox)) {
            if (DEBUG) {
                Log.i("LoadSubpackageTask", "params error");
            }
            com.baidu.swan.games.u.c.j(this.cox, 2111, "");
            return;
        }
        b.a(this.cox, new b.a() { // from class: com.baidu.swan.games.x.c.1
            @Override // com.baidu.swan.games.x.b.a
            public void anB() {
                c.this.eB(c.this.pw(c.this.cox));
            }

            @Override // com.baidu.swan.games.x.b.a
            public void dI(int i) {
                c.this.eB(false);
                com.baidu.swan.games.u.c.j(c.this.cox, i, "");
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
    public void eB(final boolean z) {
        if (this.cfV != null) {
            this.cfV.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.x.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (z) {
                        if (c.this.cow != null) {
                            c.this.cow.onSuccess();
                            if (c.DEBUG) {
                                Log.i("LoadSubpackageTask", "success call");
                            }
                        }
                    } else if (c.this.cow != null) {
                        c.this.cow.onFail();
                        if (c.DEBUG) {
                            Log.i("LoadSubpackageTask", "fail call");
                        }
                    }
                }
            });
        }
    }

    private void reset() {
        this.cow = null;
        this.cox = null;
    }

    private void m(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c c;
        if (jsObject != null && (c = com.baidu.swan.games.binding.model.c.c(jsObject)) != null) {
            this.cow = com.baidu.swan.games.binding.model.a.f(c);
            try {
                this.cox = c.getString("name");
            } catch (JSTypeMismatchException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                com.baidu.swan.games.utils.b.a(this.cfV, e);
                reset();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pw(String str) {
        if (this.cfV == null) {
            return false;
        }
        String str2 = f.UC().Uk() + a.anA().Q(str, 2);
        String Q = a.anA().Q(str, 3);
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(Q)) {
            return false;
        }
        this.cfV.bw(str2, Q);
        return true;
    }
}
