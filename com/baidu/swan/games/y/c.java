package com.baidu.swan.games.y;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
import com.baidu.swan.games.y.b;
/* loaded from: classes25.dex */
public class c extends EventTargetImpl {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.f.b dWl;
    private com.baidu.swan.games.binding.model.a eeU;
    private String eeV;

    public c(com.baidu.swan.games.f.b bVar) {
        super(bVar);
        this.dWl = bVar;
    }

    public void n(JsObject jsObject) {
        reset();
        o(jsObject);
        if (TextUtils.isEmpty(this.eeV)) {
            if (DEBUG) {
                Log.i("LoadSubpackageTask", "params error");
            }
            com.baidu.swan.games.v.c.n(this.eeV, 2111, "");
            return;
        }
        b.a(this.eeV, new b.a() { // from class: com.baidu.swan.games.y.c.1
            @Override // com.baidu.swan.games.y.b.a
            public void aZM() {
                c.this.hS(c.this.ym(c.this.eeV));
            }

            @Override // com.baidu.swan.games.y.b.a
            public void hQ(int i) {
                c.this.hS(false);
                com.baidu.swan.games.v.c.n(c.this.eeV, i, "");
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
    public void hS(final boolean z) {
        if (this.dWl != null) {
            this.dWl.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.y.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (z) {
                        if (c.this.eeU != null) {
                            c.this.eeU.onSuccess();
                            if (c.DEBUG) {
                                Log.i("LoadSubpackageTask", "success call");
                            }
                        }
                    } else if (c.this.eeU != null) {
                        c.this.eeU.onFail();
                        if (c.DEBUG) {
                            Log.i("LoadSubpackageTask", "fail call");
                        }
                    }
                }
            });
        }
    }

    private void reset() {
        this.eeU = null;
        this.eeV = null;
    }

    private void o(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e;
        if (jsObject != null && (e = com.baidu.swan.games.binding.model.c.e(jsObject)) != null) {
            this.eeU = com.baidu.swan.games.binding.model.a.f(e);
            try {
                this.eeV = e.getString("name");
            } catch (JSTypeMismatchException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
                com.baidu.swan.games.utils.b.a(this.dWl, e2);
                reset();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ym(String str) {
        if (this.dWl == null) {
            return false;
        }
        String str2 = f.aCp().aBW() + a.aZL().ad(str, 2);
        String ad = a.aZL().ad(str, 3);
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(ad)) {
            return false;
        }
        this.dWl.db(str2, ad);
        return true;
    }
}
