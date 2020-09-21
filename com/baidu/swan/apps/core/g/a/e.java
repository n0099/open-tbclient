package com.baidu.swan.apps.core.g.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class e implements c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private d clY;
    private LinkedList<com.baidu.swan.apps.event.a.a> clX = new LinkedList<>();
    private b clW = new b(2);
    private final Object mLock = new Object();
    private volatile boolean clZ = false;
    private volatile boolean cma = false;
    private volatile boolean cmb = false;
    private boolean clS = false;

    public void a(boolean z, c cVar) {
        if (!this.cmb) {
            synchronized (this.mLock) {
                if (!this.cmb) {
                    this.clS = z;
                    d m = d.m(true, z);
                    m.a(this);
                    m.a(cVar);
                    this.clW.a(m);
                    this.cmb = true;
                    return;
                }
            }
        }
        if (DEBUG) {
            Log.w("SwanAppMasterProvider", "call prepareDefault repeat");
        }
        d lP = this.clW.lP("_default_id_");
        if (lP != null) {
            lP.a(cVar);
        }
    }

    public boolean aiV() {
        return this.clZ;
    }

    public boolean aiW() {
        return this.cmb;
    }

    public void a(String str, PrefetchEvent.b bVar) {
        if (DEBUG) {
            Log.i("SwanAppMasterProvider", "get a prefetch event - " + bVar);
        }
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.w("SwanAppMasterProvider", "prefetch appId is empty");
            }
        } else if (this.cma) {
            com.baidu.swan.apps.runtime.e aAs = com.baidu.swan.apps.runtime.e.aAs();
            if (aAs != null) {
                if (TextUtils.equals(str, aAs.getAppId())) {
                    this.clY.a(str, bVar);
                    if (DEBUG) {
                        Log.w("SwanAppMasterProvider", "prefetch after app start - " + str);
                    }
                } else if (DEBUG) {
                    Log.w("SwanAppMasterProvider", "can not prefetch after swan app start");
                }
            }
        } else if (!this.clZ) {
            if (DEBUG) {
                Log.w("SwanAppMasterProvider", "can not prefetch before default mater ready");
            }
        } else {
            synchronized (this.mLock) {
                if (!this.cma) {
                    d lP = this.clW.lP(str);
                    if (lP == null) {
                        lP = d.m(false, this.clS);
                        this.clW.a(lP);
                    }
                    lP.a(str, bVar);
                }
            }
        }
    }

    public d lR(String str) {
        d lP;
        long currentTimeMillis = DEBUG ? System.currentTimeMillis() : 0L;
        if (DEBUG) {
            Log.w("SwanAppMasterProvider", "real start a swan app - " + str);
        }
        if (!this.clZ && DEBUG) {
            throw new RuntimeException("should call startApp after preload finished");
        }
        if (this.cma) {
            return this.clY;
        }
        synchronized (this.mLock) {
            if (!this.cma) {
                if (TextUtils.isEmpty(str)) {
                    lP = this.clW.lP("_default_id_");
                } else {
                    lP = this.clW.lP(str);
                    if (lP == null || !lP.isReady()) {
                        lP = this.clW.lP("_default_id_");
                    }
                }
                a(lP, str);
            }
        }
        if (DEBUG) {
            Log.i("SwanAppMasterProvider", "get right master cost - " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            Log.i("SwanAppMasterProvider", "final master id - " + this.clY.aiS().abD());
        }
        return this.clY;
    }

    private void a(d dVar, String str) {
        this.clY = dVar;
        this.clY.lQ(str);
        this.cma = true;
        aiZ();
        long currentTimeMillis = DEBUG ? System.currentTimeMillis() : 0L;
        this.clW.e(Collections.singletonList(dVar));
        if (DEBUG) {
            Log.i("SwanAppMasterProvider", "clear useless master cost - " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
    }

    public boolean aiX() {
        return this.cma;
    }

    public d aiY() {
        if (this.cma) {
            return this.clY;
        }
        if (DEBUG) {
            Log.w("SwanAppMasterProvider", "master not final confirmed, has default - " + aiW());
            Log.w("SwanAppMasterProvider", Log.getStackTraceString(new RuntimeException("throw by debug")));
        }
        return null;
    }

    public void reset() {
        this.clZ = false;
        this.cma = false;
        this.cmb = false;
        this.clS = false;
        this.clY = null;
        this.clW.e(null);
        synchronized (this.mLock) {
            this.clX.clear();
        }
        a.aiP();
    }

    private void aiZ() {
        if (!this.clX.isEmpty() && this.cma) {
            synchronized (this.mLock) {
                Iterator<com.baidu.swan.apps.event.a.a> it = this.clX.iterator();
                while (it.hasNext()) {
                    com.baidu.swan.apps.event.a.a next = it.next();
                    if (DEBUG) {
                        Log.d("SwanAppMasterProvider", "dispatchPendingEvents event: " + next.bZZ);
                    }
                    com.baidu.swan.apps.core.turbo.d.akC().b(next);
                }
                this.clX.clear();
            }
        }
    }

    public boolean aja() {
        return this.clS;
    }

    public void a(com.baidu.swan.apps.event.a.a aVar) {
        if (aVar != null && !this.cma) {
            synchronized (this.mLock) {
                this.clX.add(aVar);
            }
        }
    }

    @Override // com.baidu.swan.apps.core.g.a.c
    public void onReady() {
        this.clZ = true;
    }
}
