package com.baidu.swan.apps.core.g.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes25.dex */
public class e implements c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private d cRO;
    private LinkedList<com.baidu.swan.apps.event.a.a> cRN = new LinkedList<>();
    private b cRM = new b(2);
    private final Object mLock = new Object();
    private volatile boolean cRP = false;
    private volatile boolean cRQ = false;
    private volatile boolean cRR = false;
    private boolean cRI = false;

    public void a(boolean z, c cVar) {
        if (!this.cRR) {
            synchronized (this.mLock) {
                if (!this.cRR) {
                    this.cRI = z;
                    d m = d.m(true, z);
                    m.a(this);
                    m.a(cVar);
                    this.cRM.a(m);
                    this.cRR = true;
                    return;
                }
            }
        }
        if (DEBUG) {
            Log.w("SwanAppMasterProvider", "call prepareDefault repeat");
        }
        d nK = this.cRM.nK("_default_id_");
        if (nK != null) {
            nK.a(cVar);
        }
    }

    public boolean asB() {
        return this.cRP;
    }

    public boolean asC() {
        return this.cRR;
    }

    public void a(String str, PrefetchEvent.b bVar) {
        if (DEBUG) {
            Log.i("SwanAppMasterProvider", "get a prefetch event - " + bVar);
        }
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.w("SwanAppMasterProvider", "prefetch appId is empty");
            }
        } else if (this.cRQ) {
            com.baidu.swan.apps.runtime.e aJV = com.baidu.swan.apps.runtime.e.aJV();
            if (aJV != null) {
                if (TextUtils.equals(str, aJV.getAppId())) {
                    this.cRO.a(str, bVar);
                    if (DEBUG) {
                        Log.w("SwanAppMasterProvider", "prefetch after app start - " + str);
                    }
                } else if (DEBUG) {
                    Log.w("SwanAppMasterProvider", "can not prefetch after swan app start");
                }
            }
        } else if (!this.cRP) {
            if (DEBUG) {
                Log.w("SwanAppMasterProvider", "can not prefetch before default mater ready");
            }
        } else {
            synchronized (this.mLock) {
                if (!this.cRQ) {
                    d nK = this.cRM.nK(str);
                    if (nK == null) {
                        nK = d.m(false, this.cRI);
                        this.cRM.a(nK);
                    }
                    nK.a(str, bVar);
                }
            }
        }
    }

    public d nM(String str) {
        d nK;
        long currentTimeMillis = DEBUG ? System.currentTimeMillis() : 0L;
        if (DEBUG) {
            Log.w("SwanAppMasterProvider", "real start a swan app - " + str);
        }
        if (!this.cRP && DEBUG) {
            throw new RuntimeException("should call startApp after preload finished");
        }
        if (this.cRQ) {
            return this.cRO;
        }
        synchronized (this.mLock) {
            if (!this.cRQ) {
                if (TextUtils.isEmpty(str)) {
                    nK = this.cRM.nK("_default_id_");
                } else {
                    nK = this.cRM.nK(str);
                    if (nK == null || !nK.isReady()) {
                        nK = this.cRM.nK("_default_id_");
                    }
                }
                a(nK, str);
            }
        }
        if (DEBUG) {
            Log.i("SwanAppMasterProvider", "get right master cost - " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            Log.i("SwanAppMasterProvider", "final master id - " + this.cRO.asy().alj());
        }
        return this.cRO;
    }

    private void a(d dVar, String str) {
        this.cRO = dVar;
        this.cRO.nL(str);
        this.cRQ = true;
        asF();
        long currentTimeMillis = DEBUG ? System.currentTimeMillis() : 0L;
        this.cRM.e(Collections.singletonList(dVar));
        if (DEBUG) {
            Log.i("SwanAppMasterProvider", "clear useless master cost - " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
    }

    public boolean asD() {
        return this.cRQ;
    }

    public d asE() {
        if (this.cRQ) {
            return this.cRO;
        }
        if (DEBUG) {
            Log.w("SwanAppMasterProvider", "master not final confirmed, has default - " + asC());
            Log.w("SwanAppMasterProvider", Log.getStackTraceString(new RuntimeException("throw by debug")));
        }
        return null;
    }

    public void reset() {
        this.cRP = false;
        this.cRQ = false;
        this.cRR = false;
        this.cRI = false;
        this.cRO = null;
        this.cRM.e(null);
        synchronized (this.mLock) {
            this.cRN.clear();
        }
        a.asv();
    }

    private void asF() {
        if (!this.cRN.isEmpty() && this.cRQ) {
            synchronized (this.mLock) {
                Iterator<com.baidu.swan.apps.event.a.a> it = this.cRN.iterator();
                while (it.hasNext()) {
                    com.baidu.swan.apps.event.a.a next = it.next();
                    if (DEBUG) {
                        Log.d("SwanAppMasterProvider", "dispatchPendingEvents event: " + next.cFU);
                    }
                    com.baidu.swan.apps.core.turbo.d.aui().b(next);
                }
                this.cRN.clear();
            }
        }
    }

    public boolean asG() {
        return this.cRI;
    }

    public void a(com.baidu.swan.apps.event.a.a aVar) {
        if (aVar != null && !this.cRQ) {
            synchronized (this.mLock) {
                this.cRN.add(aVar);
            }
        }
    }

    @Override // com.baidu.swan.apps.core.g.a.c
    public void onReady() {
        this.cRP = true;
    }
}
