package com.baidu.swan.games.y;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
import com.baidu.swan.games.y.b;
/* loaded from: classes8.dex */
public class c extends EventTargetImpl {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.f.b eaw;
    private com.baidu.swan.games.binding.model.a ejh;
    private String eji;

    public c(com.baidu.swan.games.f.b bVar) {
        super(bVar);
        this.eaw = bVar;
    }

    public void n(JsObject jsObject) {
        reset();
        o(jsObject);
        if (TextUtils.isEmpty(this.eji)) {
            if (DEBUG) {
                Log.i("LoadSubpackageTask", "params error");
            }
            com.baidu.swan.games.v.c.m(this.eji, 2111, "");
            return;
        }
        b.a(this.eji, new b.a() { // from class: com.baidu.swan.games.y.c.1
            @Override // com.baidu.swan.games.y.b.a
            public void aYn() {
                c.this.ig(c.this.xa(c.this.eji));
            }

            @Override // com.baidu.swan.games.y.b.a
            public void gd(int i) {
                c.this.ig(false);
                com.baidu.swan.games.v.c.m(c.this.eji, i, "");
            }

            @Override // com.baidu.swan.games.y.b.a
            public void f(int i, long j, long j2) {
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
    public void ig(final boolean z) {
        if (this.eaw != null) {
            this.eaw.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.y.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (z) {
                        if (c.this.ejh != null) {
                            c.this.ejh.onSuccess();
                            if (c.DEBUG) {
                                Log.i("LoadSubpackageTask", "success call");
                            }
                        }
                    } else if (c.this.ejh != null) {
                        c.this.ejh.onFail();
                        if (c.DEBUG) {
                            Log.i("LoadSubpackageTask", "fail call");
                        }
                    }
                }
            });
        }
    }

    private void reset() {
        this.ejh = null;
        this.eji = null;
    }

    private void o(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e;
        if (jsObject != null && (e = com.baidu.swan.games.binding.model.c.e(jsObject)) != null) {
            this.ejh = com.baidu.swan.games.binding.model.a.f(e);
            try {
                this.eji = e.getString("name");
            } catch (JSTypeMismatchException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
                com.baidu.swan.games.utils.b.a(this.eaw, e2);
                reset();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xa(String str) {
        if (this.eaw == null) {
            return false;
        }
        String str2 = f.azN().azu() + a.aYm().af(str, 2);
        String af = a.aYm().af(str, 3);
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(af)) {
            return false;
        }
        this.eaw.cZ(str2, af);
        return true;
    }
}
