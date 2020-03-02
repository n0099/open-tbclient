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
    private com.baidu.swan.games.e.b cka;
    private com.baidu.swan.games.binding.model.a csy;
    private String csz;

    public c(com.baidu.swan.games.e.b bVar) {
        super(bVar);
        this.cka = bVar;
    }

    public void l(JsObject jsObject) {
        reset();
        m(jsObject);
        if (TextUtils.isEmpty(this.csz)) {
            if (DEBUG) {
                Log.i("LoadSubpackageTask", "params error");
            }
            com.baidu.swan.games.u.c.k(this.csz, 2111, "");
            return;
        }
        b.a(this.csz, new b.a() { // from class: com.baidu.swan.games.x.c.1
            @Override // com.baidu.swan.games.x.b.a
            public void apR() {
                c.this.eI(c.this.pL(c.this.csz));
            }

            @Override // com.baidu.swan.games.x.b.a
            public void dY(int i) {
                c.this.eI(false);
                com.baidu.swan.games.u.c.k(c.this.csz, i, "");
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
    public void eI(final boolean z) {
        if (this.cka != null) {
            this.cka.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.x.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (z) {
                        if (c.this.csy != null) {
                            c.this.csy.onSuccess();
                            if (c.DEBUG) {
                                Log.i("LoadSubpackageTask", "success call");
                            }
                        }
                    } else if (c.this.csy != null) {
                        c.this.csy.onFail();
                        if (c.DEBUG) {
                            Log.i("LoadSubpackageTask", "fail call");
                        }
                    }
                }
            });
        }
    }

    private void reset() {
        this.csy = null;
        this.csz = null;
    }

    private void m(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c c;
        if (jsObject != null && (c = com.baidu.swan.games.binding.model.c.c(jsObject)) != null) {
            this.csy = com.baidu.swan.games.binding.model.a.f(c);
            try {
                this.csz = c.getString("name");
            } catch (JSTypeMismatchException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                com.baidu.swan.games.utils.b.a(this.cka, e);
                reset();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pL(String str) {
        if (this.cka == null) {
            return false;
        }
        String str2 = f.WS().WA() + a.apQ().O(str, 2);
        String O = a.apQ().O(str, 3);
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(O)) {
            return false;
        }
        this.cka.bF(str2, O);
        return true;
    }
}
