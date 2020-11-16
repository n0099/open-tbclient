package com.baidu.swan.apps.core.g.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public class e implements c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private d cKV;
    private LinkedList<com.baidu.swan.apps.event.a.a> cKU = new LinkedList<>();
    private b cKT = new b(2);
    private final Object mLock = new Object();
    private volatile boolean cKW = false;
    private volatile boolean cKX = false;
    private volatile boolean cKY = false;
    private boolean cKP = false;

    public void a(boolean z, c cVar) {
        if (!this.cKY) {
            synchronized (this.mLock) {
                if (!this.cKY) {
                    this.cKP = z;
                    d m = d.m(true, z);
                    m.a(this);
                    m.a(cVar);
                    this.cKT.a(m);
                    this.cKY = true;
                    return;
                }
            }
        }
        if (DEBUG) {
            Log.w("SwanAppMasterProvider", "call prepareDefault repeat");
        }
        d nd = this.cKT.nd("_default_id_");
        if (nd != null) {
            nd.a(cVar);
        }
    }

    public boolean apt() {
        return this.cKW;
    }

    public boolean apu() {
        return this.cKY;
    }

    public void a(String str, PrefetchEvent.b bVar) {
        if (DEBUG) {
            Log.i("SwanAppMasterProvider", "get a prefetch event - " + bVar);
        }
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.w("SwanAppMasterProvider", "prefetch appId is empty");
            }
        } else if (this.cKX) {
            com.baidu.swan.apps.runtime.e aGN = com.baidu.swan.apps.runtime.e.aGN();
            if (aGN != null) {
                if (TextUtils.equals(str, aGN.getAppId())) {
                    this.cKV.a(str, bVar);
                    if (DEBUG) {
                        Log.w("SwanAppMasterProvider", "prefetch after app start - " + str);
                    }
                } else if (DEBUG) {
                    Log.w("SwanAppMasterProvider", "can not prefetch after swan app start");
                }
            }
        } else if (!this.cKW) {
            if (DEBUG) {
                Log.w("SwanAppMasterProvider", "can not prefetch before default mater ready");
            }
        } else {
            synchronized (this.mLock) {
                if (!this.cKX) {
                    d nd = this.cKT.nd(str);
                    if (nd == null) {
                        nd = d.m(false, this.cKP);
                        this.cKT.a(nd);
                    }
                    nd.a(str, bVar);
                }
            }
        }
    }

    public d nf(String str) {
        d nd;
        long currentTimeMillis = DEBUG ? System.currentTimeMillis() : 0L;
        if (DEBUG) {
            Log.w("SwanAppMasterProvider", "real start a swan app - " + str);
        }
        if (!this.cKW && DEBUG) {
            throw new RuntimeException("should call startApp after preload finished");
        }
        if (this.cKX) {
            return this.cKV;
        }
        synchronized (this.mLock) {
            if (!this.cKX) {
                if (TextUtils.isEmpty(str)) {
                    nd = this.cKT.nd("_default_id_");
                } else {
                    nd = this.cKT.nd(str);
                    if (nd == null || !nd.isReady()) {
                        nd = this.cKT.nd("_default_id_");
                    }
                }
                a(nd, str);
            }
        }
        if (DEBUG) {
            Log.i("SwanAppMasterProvider", "get right master cost - " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            Log.i("SwanAppMasterProvider", "final master id - " + this.cKV.apq().aib());
        }
        return this.cKV;
    }

    private void a(d dVar, String str) {
        this.cKV = dVar;
        this.cKV.ne(str);
        this.cKX = true;
        apx();
        long currentTimeMillis = DEBUG ? System.currentTimeMillis() : 0L;
        this.cKT.e(Collections.singletonList(dVar));
        if (DEBUG) {
            Log.i("SwanAppMasterProvider", "clear useless master cost - " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
    }

    public boolean apv() {
        return this.cKX;
    }

    public d apw() {
        if (this.cKX) {
            return this.cKV;
        }
        if (DEBUG) {
            Log.w("SwanAppMasterProvider", "master not final confirmed, has default - " + apu());
            Log.w("SwanAppMasterProvider", Log.getStackTraceString(new RuntimeException("throw by debug")));
        }
        return null;
    }

    public void reset() {
        this.cKW = false;
        this.cKX = false;
        this.cKY = false;
        this.cKP = false;
        this.cKV = null;
        this.cKT.e(null);
        synchronized (this.mLock) {
            this.cKU.clear();
        }
        a.apn();
    }

    private void apx() {
        if (!this.cKU.isEmpty() && this.cKX) {
            synchronized (this.mLock) {
                Iterator<com.baidu.swan.apps.event.a.a> it = this.cKU.iterator();
                while (it.hasNext()) {
                    com.baidu.swan.apps.event.a.a next = it.next();
                    if (DEBUG) {
                        Log.d("SwanAppMasterProvider", "dispatchPendingEvents event: " + next.czc);
                    }
                    com.baidu.swan.apps.core.turbo.d.ara().b(next);
                }
                this.cKU.clear();
            }
        }
    }

    public boolean apy() {
        return this.cKP;
    }

    public void a(com.baidu.swan.apps.event.a.a aVar) {
        if (aVar != null && !this.cKX) {
            synchronized (this.mLock) {
                this.cKU.add(aVar);
            }
        }
    }

    @Override // com.baidu.swan.apps.core.g.a.c
    public void onReady() {
        this.cKW = true;
    }
}
