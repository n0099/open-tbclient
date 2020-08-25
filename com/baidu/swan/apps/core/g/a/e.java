package com.baidu.swan.apps.core.g.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes8.dex */
public class e implements c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private d cjT;
    private LinkedList<com.baidu.swan.apps.event.a.a> cjS = new LinkedList<>();
    private b cjR = new b(2);
    private final Object mLock = new Object();
    private volatile boolean cjU = false;
    private volatile boolean cjV = false;
    private volatile boolean cjW = false;
    private boolean cjN = false;

    public void a(boolean z, c cVar) {
        if (!this.cjW) {
            synchronized (this.mLock) {
                if (!this.cjW) {
                    this.cjN = z;
                    d m = d.m(true, z);
                    m.a(this);
                    m.a(cVar);
                    this.cjR.a(m);
                    this.cjW = true;
                    return;
                }
            }
        }
        if (DEBUG) {
            Log.w("SwanAppMasterProvider", "call prepareDefault repeat");
        }
        d lv = this.cjR.lv("_default_id_");
        if (lv != null) {
            lv.a(cVar);
        }
    }

    public boolean ail() {
        return this.cjU;
    }

    public boolean aim() {
        return this.cjW;
    }

    public void a(String str, PrefetchEvent.b bVar) {
        if (DEBUG) {
            Log.i("SwanAppMasterProvider", "get a prefetch event - " + bVar);
        }
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.w("SwanAppMasterProvider", "prefetch appId is empty");
            }
        } else if (this.cjV) {
            com.baidu.swan.apps.runtime.e azJ = com.baidu.swan.apps.runtime.e.azJ();
            if (azJ != null) {
                if (TextUtils.equals(str, azJ.getAppId())) {
                    this.cjT.a(str, bVar);
                    if (DEBUG) {
                        Log.w("SwanAppMasterProvider", "prefetch after app start - " + str);
                    }
                } else if (DEBUG) {
                    Log.w("SwanAppMasterProvider", "can not prefetch after swan app start");
                }
            }
        } else if (!this.cjU) {
            if (DEBUG) {
                Log.w("SwanAppMasterProvider", "can not prefetch before default mater ready");
            }
        } else {
            synchronized (this.mLock) {
                if (!this.cjV) {
                    d lv = this.cjR.lv(str);
                    if (lv == null) {
                        lv = d.m(false, this.cjN);
                        this.cjR.a(lv);
                    }
                    lv.a(str, bVar);
                }
            }
        }
    }

    public d lx(String str) {
        d lv;
        long currentTimeMillis = DEBUG ? System.currentTimeMillis() : 0L;
        if (DEBUG) {
            Log.w("SwanAppMasterProvider", "real start a swan app - " + str);
        }
        if (!this.cjU && DEBUG) {
            throw new RuntimeException("should call startApp after preload finished");
        }
        if (this.cjV) {
            return this.cjT;
        }
        synchronized (this.mLock) {
            if (!this.cjV) {
                if (TextUtils.isEmpty(str)) {
                    lv = this.cjR.lv("_default_id_");
                } else {
                    lv = this.cjR.lv(str);
                    if (lv == null || !lv.isReady()) {
                        lv = this.cjR.lv("_default_id_");
                    }
                }
                a(lv, str);
            }
        }
        if (DEBUG) {
            Log.i("SwanAppMasterProvider", "get right master cost - " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            Log.i("SwanAppMasterProvider", "final master id - " + this.cjT.aii().aaU());
        }
        return this.cjT;
    }

    private void a(d dVar, String str) {
        this.cjT = dVar;
        this.cjT.lw(str);
        this.cjV = true;
        aip();
        long currentTimeMillis = DEBUG ? System.currentTimeMillis() : 0L;
        this.cjR.e(Collections.singletonList(dVar));
        if (DEBUG) {
            Log.i("SwanAppMasterProvider", "clear useless master cost - " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
    }

    public boolean ain() {
        return this.cjV;
    }

    public d aio() {
        if (this.cjV) {
            return this.cjT;
        }
        if (DEBUG) {
            Log.w("SwanAppMasterProvider", "master not final confirmed, has default - " + aim());
            Log.w("SwanAppMasterProvider", Log.getStackTraceString(new RuntimeException("throw by debug")));
        }
        return null;
    }

    public void reset() {
        this.cjU = false;
        this.cjV = false;
        this.cjW = false;
        this.cjN = false;
        this.cjT = null;
        this.cjR.e(null);
        synchronized (this.mLock) {
            this.cjS.clear();
        }
        a.aif();
    }

    private void aip() {
        if (!this.cjS.isEmpty() && this.cjV) {
            synchronized (this.mLock) {
                Iterator<com.baidu.swan.apps.event.a.a> it = this.cjS.iterator();
                while (it.hasNext()) {
                    com.baidu.swan.apps.event.a.a next = it.next();
                    if (DEBUG) {
                        Log.d("SwanAppMasterProvider", "dispatchPendingEvents event: " + next.bXU);
                    }
                    com.baidu.swan.apps.core.turbo.d.ajS().b(next);
                }
                this.cjS.clear();
            }
        }
    }

    public boolean aiq() {
        return this.cjN;
    }

    public void a(com.baidu.swan.apps.event.a.a aVar) {
        if (aVar != null && !this.cjV) {
            synchronized (this.mLock) {
                this.cjS.add(aVar);
            }
        }
    }

    @Override // com.baidu.swan.apps.core.g.a.c
    public void onReady() {
        this.cjU = true;
    }
}
