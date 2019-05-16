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
    private String ayf;
    private com.baidu.swan.games.e.b beh;
    private com.baidu.swan.games.binding.model.a bkD;

    public d(com.baidu.swan.games.e.b bVar) {
        super(bVar);
        this.beh = bVar;
    }

    public void l(JsObject jsObject) {
        reset();
        m(jsObject);
        if (TextUtils.isEmpty(this.ayf)) {
            if (DEBUG) {
                Log.i("LoadSubpackageTask", "params error");
            }
            com.baidu.swan.games.r.c.g(this.ayf, 2111, "");
            return;
        }
        c.Sx().a(this.ayf, new c.a() { // from class: com.baidu.swan.games.subpackage.d.1
            @Override // com.baidu.swan.games.subpackage.c.a
            public void Sy() {
                d.this.cR(d.this.jV(d.this.ayf));
            }

            @Override // com.baidu.swan.games.subpackage.c.a
            public void cI(int i) {
                d.this.cR(false);
                com.baidu.swan.games.r.c.g(d.this.ayf, i, "");
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
    public void cR(final boolean z) {
        if (this.beh != null) {
            this.beh.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.subpackage.d.2
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.bkD != null && d.this.bkD.beS != null) {
                        d.this.bkD.onComplete();
                        if (d.DEBUG) {
                            Log.i("LoadSubpackageTask", "complete call");
                        }
                    }
                    if (z) {
                        if (d.this.bkD != null && d.this.bkD.beQ != null) {
                            d.this.bkD.onSuccess();
                            if (d.DEBUG) {
                                Log.i("LoadSubpackageTask", "success call");
                            }
                        }
                    } else if (d.this.bkD != null && d.this.bkD.beR != null) {
                        d.this.bkD.onFail();
                        if (d.DEBUG) {
                            Log.i("LoadSubpackageTask", "fail call");
                        }
                    }
                }
            });
        }
    }

    private void reset() {
        this.bkD = null;
        this.ayf = null;
    }

    private void m(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c c;
        if (jsObject != null && (c = com.baidu.swan.games.binding.model.c.c(jsObject)) != null) {
            this.bkD = com.baidu.swan.games.binding.model.a.e(c);
            try {
                this.ayf = c.getString("name");
            } catch (JSTypeMismatchException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                com.baidu.swan.games.utils.a.a(this.beh, e);
                reset();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean jV(String str) {
        if (this.beh == null) {
            return false;
        }
        String str2 = e.FV().FE() + a.Sw().G(str, 2);
        String G = a.Sw().G(str, 3);
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(G)) {
            return false;
        }
        this.beh.aV(str2, G);
        return true;
    }
}
