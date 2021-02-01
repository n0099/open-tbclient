package com.baidu.swan.games.y;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
import com.baidu.swan.games.y.b;
/* loaded from: classes9.dex */
public class c extends EventTargetImpl {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.f.b ecD;
    private com.baidu.swan.games.binding.model.a elo;
    private String elp;

    public c(com.baidu.swan.games.f.b bVar) {
        super(bVar);
        this.ecD = bVar;
    }

    public void n(JsObject jsObject) {
        reset();
        o(jsObject);
        if (TextUtils.isEmpty(this.elp)) {
            if (DEBUG) {
                Log.i("LoadSubpackageTask", "params error");
            }
            com.baidu.swan.games.v.c.m(this.elp, 2111, "");
            return;
        }
        b.a(this.elp, new b.a() { // from class: com.baidu.swan.games.y.c.1
            @Override // com.baidu.swan.games.y.b.a
            public void aYz() {
                c.this.ii(c.this.xt(c.this.elp));
            }

            @Override // com.baidu.swan.games.y.b.a
            public void gg(int i) {
                c.this.ii(false);
                com.baidu.swan.games.v.c.m(c.this.elp, i, "");
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
    public void ii(final boolean z) {
        if (this.ecD != null) {
            this.ecD.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.y.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (z) {
                        if (c.this.elo != null) {
                            c.this.elo.onSuccess();
                            if (c.DEBUG) {
                                Log.i("LoadSubpackageTask", "success call");
                            }
                        }
                    } else if (c.this.elo != null) {
                        c.this.elo.onFail();
                        if (c.DEBUG) {
                            Log.i("LoadSubpackageTask", "fail call");
                        }
                    }
                }
            });
        }
    }

    private void reset() {
        this.elo = null;
        this.elp = null;
    }

    private void o(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e;
        if (jsObject != null && (e = com.baidu.swan.games.binding.model.c.e(jsObject)) != null) {
            this.elo = com.baidu.swan.games.binding.model.a.f(e);
            try {
                this.elp = e.getString("name");
            } catch (JSTypeMismatchException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
                com.baidu.swan.games.utils.b.a(this.ecD, e2);
                reset();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xt(String str) {
        if (this.ecD == null) {
            return false;
        }
        String str2 = f.aAl().azS() + a.aYy().ah(str, 2);
        String ah = a.aYy().ah(str, 3);
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(ah)) {
            return false;
        }
        this.ecD.cT(str2, ah);
        return true;
    }
}
