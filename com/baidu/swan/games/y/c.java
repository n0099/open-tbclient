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
    private com.baidu.swan.games.f.b efi;
    private com.baidu.swan.games.binding.model.a enV;
    private String enW;

    public c(com.baidu.swan.games.f.b bVar) {
        super(bVar);
        this.efi = bVar;
    }

    public void n(JsObject jsObject) {
        reset();
        o(jsObject);
        if (TextUtils.isEmpty(this.enW)) {
            if (DEBUG) {
                Log.i("LoadSubpackageTask", "params error");
            }
            com.baidu.swan.games.v.c.m(this.enW, 2111, "");
            return;
        }
        b.a(this.enW, new b.a() { // from class: com.baidu.swan.games.y.c.1
            @Override // com.baidu.swan.games.y.b.a
            public void bcg() {
                c.this.ik(c.this.yl(c.this.enW));
            }

            @Override // com.baidu.swan.games.y.b.a
            public void hK(int i) {
                c.this.ik(false);
                com.baidu.swan.games.v.c.m(c.this.enW, i, "");
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
    public void ik(final boolean z) {
        if (this.efi != null) {
            this.efi.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.y.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (z) {
                        if (c.this.enV != null) {
                            c.this.enV.onSuccess();
                            if (c.DEBUG) {
                                Log.i("LoadSubpackageTask", "success call");
                            }
                        }
                    } else if (c.this.enV != null) {
                        c.this.enV.onFail();
                        if (c.DEBUG) {
                            Log.i("LoadSubpackageTask", "fail call");
                        }
                    }
                }
            });
        }
    }

    private void reset() {
        this.enV = null;
        this.enW = null;
    }

    private void o(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e;
        if (jsObject != null && (e = com.baidu.swan.games.binding.model.c.e(jsObject)) != null) {
            this.enV = com.baidu.swan.games.binding.model.a.f(e);
            try {
                this.enW = e.getString("name");
            } catch (JSTypeMismatchException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
                com.baidu.swan.games.utils.b.a(this.efi, e2);
                reset();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean yl(String str) {
        if (this.efi == null) {
            return false;
        }
        String str2 = f.aDG().aDn() + a.bcf().af(str, 2);
        String af = a.bcf().af(str, 3);
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(af)) {
            return false;
        }
        this.efi.da(str2, af);
        return true;
    }
}
