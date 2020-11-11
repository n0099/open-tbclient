package com.baidu.swan.apps.core.g.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes10.dex */
public class e implements c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private d cMF;
    private LinkedList<com.baidu.swan.apps.event.a.a> cME = new LinkedList<>();
    private b cMD = new b(2);
    private final Object mLock = new Object();
    private volatile boolean cMG = false;
    private volatile boolean cMH = false;
    private volatile boolean cMI = false;
    private boolean cMz = false;

    public void a(boolean z, c cVar) {
        if (!this.cMI) {
            synchronized (this.mLock) {
                if (!this.cMI) {
                    this.cMz = z;
                    d m = d.m(true, z);
                    m.a(this);
                    m.a(cVar);
                    this.cMD.a(m);
                    this.cMI = true;
                    return;
                }
            }
        }
        if (DEBUG) {
            Log.w("SwanAppMasterProvider", "call prepareDefault repeat");
        }
        d nj = this.cMD.nj("_default_id_");
        if (nj != null) {
            nj.a(cVar);
        }
    }

    public boolean aqb() {
        return this.cMG;
    }

    public boolean aqc() {
        return this.cMI;
    }

    public void a(String str, PrefetchEvent.b bVar) {
        if (DEBUG) {
            Log.i("SwanAppMasterProvider", "get a prefetch event - " + bVar);
        }
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.w("SwanAppMasterProvider", "prefetch appId is empty");
            }
        } else if (this.cMH) {
            com.baidu.swan.apps.runtime.e aHv = com.baidu.swan.apps.runtime.e.aHv();
            if (aHv != null) {
                if (TextUtils.equals(str, aHv.getAppId())) {
                    this.cMF.a(str, bVar);
                    if (DEBUG) {
                        Log.w("SwanAppMasterProvider", "prefetch after app start - " + str);
                    }
                } else if (DEBUG) {
                    Log.w("SwanAppMasterProvider", "can not prefetch after swan app start");
                }
            }
        } else if (!this.cMG) {
            if (DEBUG) {
                Log.w("SwanAppMasterProvider", "can not prefetch before default mater ready");
            }
        } else {
            synchronized (this.mLock) {
                if (!this.cMH) {
                    d nj = this.cMD.nj(str);
                    if (nj == null) {
                        nj = d.m(false, this.cMz);
                        this.cMD.a(nj);
                    }
                    nj.a(str, bVar);
                }
            }
        }
    }

    public d nl(String str) {
        d nj;
        long currentTimeMillis = DEBUG ? System.currentTimeMillis() : 0L;
        if (DEBUG) {
            Log.w("SwanAppMasterProvider", "real start a swan app - " + str);
        }
        if (!this.cMG && DEBUG) {
            throw new RuntimeException("should call startApp after preload finished");
        }
        if (this.cMH) {
            return this.cMF;
        }
        synchronized (this.mLock) {
            if (!this.cMH) {
                if (TextUtils.isEmpty(str)) {
                    nj = this.cMD.nj("_default_id_");
                } else {
                    nj = this.cMD.nj(str);
                    if (nj == null || !nj.isReady()) {
                        nj = this.cMD.nj("_default_id_");
                    }
                }
                a(nj, str);
            }
        }
        if (DEBUG) {
            Log.i("SwanAppMasterProvider", "get right master cost - " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            Log.i("SwanAppMasterProvider", "final master id - " + this.cMF.apY().aiJ());
        }
        return this.cMF;
    }

    private void a(d dVar, String str) {
        this.cMF = dVar;
        this.cMF.nk(str);
        this.cMH = true;
        aqf();
        long currentTimeMillis = DEBUG ? System.currentTimeMillis() : 0L;
        this.cMD.e(Collections.singletonList(dVar));
        if (DEBUG) {
            Log.i("SwanAppMasterProvider", "clear useless master cost - " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
    }

    public boolean aqd() {
        return this.cMH;
    }

    public d aqe() {
        if (this.cMH) {
            return this.cMF;
        }
        if (DEBUG) {
            Log.w("SwanAppMasterProvider", "master not final confirmed, has default - " + aqc());
            Log.w("SwanAppMasterProvider", Log.getStackTraceString(new RuntimeException("throw by debug")));
        }
        return null;
    }

    public void reset() {
        this.cMG = false;
        this.cMH = false;
        this.cMI = false;
        this.cMz = false;
        this.cMF = null;
        this.cMD.e(null);
        synchronized (this.mLock) {
            this.cME.clear();
        }
        a.apV();
    }

    private void aqf() {
        if (!this.cME.isEmpty() && this.cMH) {
            synchronized (this.mLock) {
                Iterator<com.baidu.swan.apps.event.a.a> it = this.cME.iterator();
                while (it.hasNext()) {
                    com.baidu.swan.apps.event.a.a next = it.next();
                    if (DEBUG) {
                        Log.d("SwanAppMasterProvider", "dispatchPendingEvents event: " + next.cAM);
                    }
                    com.baidu.swan.apps.core.turbo.d.arI().b(next);
                }
                this.cME.clear();
            }
        }
    }

    public boolean aqg() {
        return this.cMz;
    }

    public void a(com.baidu.swan.apps.event.a.a aVar) {
        if (aVar != null && !this.cMH) {
            synchronized (this.mLock) {
                this.cME.add(aVar);
            }
        }
    }

    @Override // com.baidu.swan.apps.core.g.a.c
    public void onReady() {
        this.cMG = true;
    }
}
