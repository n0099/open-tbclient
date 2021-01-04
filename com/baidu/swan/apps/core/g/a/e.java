package com.baidu.swan.apps.core.g.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes9.dex */
public class e implements c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private d cWL;
    private LinkedList<com.baidu.swan.apps.event.a.a> cWK = new LinkedList<>();
    private b cWJ = new b(2);
    private final Object mLock = new Object();
    private volatile boolean cWM = false;
    private volatile boolean cWN = false;
    private volatile boolean cWO = false;
    private boolean cWF = false;

    public void a(boolean z, c cVar) {
        if (!this.cWO) {
            synchronized (this.mLock) {
                if (!this.cWO) {
                    this.cWF = z;
                    d m = d.m(true, z);
                    m.a(this);
                    m.a(cVar);
                    this.cWJ.a(m);
                    this.cWO = true;
                    return;
                }
            }
        }
        if (DEBUG) {
            Log.w("SwanAppMasterProvider", "call prepareDefault repeat");
        }
        d nD = this.cWJ.nD("_default_id_");
        if (nD != null) {
            nD.a(cVar);
        }
    }

    public boolean atS() {
        return this.cWM;
    }

    public boolean atT() {
        return this.cWO;
    }

    public void a(String str, PrefetchEvent.b bVar) {
        if (DEBUG) {
            Log.i("SwanAppMasterProvider", "get a prefetch event - " + bVar);
        }
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.w("SwanAppMasterProvider", "prefetch appId is empty");
            }
        } else if (this.cWN) {
            com.baidu.swan.apps.runtime.e aMl = com.baidu.swan.apps.runtime.e.aMl();
            if (aMl != null) {
                if (TextUtils.equals(str, aMl.getAppId())) {
                    this.cWL.a(str, bVar);
                    if (DEBUG) {
                        Log.w("SwanAppMasterProvider", "prefetch after app start - " + str);
                    }
                } else if (DEBUG) {
                    Log.w("SwanAppMasterProvider", "can not prefetch after swan app start");
                }
            }
        } else if (!this.cWM) {
            if (DEBUG) {
                Log.w("SwanAppMasterProvider", "can not prefetch before default mater ready");
            }
        } else {
            synchronized (this.mLock) {
                if (!this.cWN) {
                    d nD = this.cWJ.nD(str);
                    if (nD == null) {
                        nD = d.m(false, this.cWF);
                        this.cWJ.a(nD);
                    }
                    nD.a(str, bVar);
                }
            }
        }
    }

    public d nF(String str) {
        d nD;
        long currentTimeMillis = DEBUG ? System.currentTimeMillis() : 0L;
        if (DEBUG) {
            Log.w("SwanAppMasterProvider", "real start a swan app - " + str);
        }
        if (!this.cWM && DEBUG) {
            throw new RuntimeException("should call startApp after preload finished");
        }
        if (this.cWN) {
            return this.cWL;
        }
        synchronized (this.mLock) {
            if (!this.cWN) {
                if (TextUtils.isEmpty(str)) {
                    nD = this.cWJ.nD("_default_id_");
                } else {
                    nD = this.cWJ.nD(str);
                    if (nD == null || !nD.isReady()) {
                        nD = this.cWJ.nD("_default_id_");
                    }
                }
                a(nD, str);
            }
        }
        if (DEBUG) {
            Log.i("SwanAppMasterProvider", "get right master cost - " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            Log.i("SwanAppMasterProvider", "final master id - " + this.cWL.atP().amt());
        }
        return this.cWL;
    }

    private void a(d dVar, String str) {
        this.cWL = dVar;
        this.cWL.nE(str);
        this.cWN = true;
        atW();
        long currentTimeMillis = DEBUG ? System.currentTimeMillis() : 0L;
        this.cWJ.e(Collections.singletonList(dVar));
        if (DEBUG) {
            Log.i("SwanAppMasterProvider", "clear useless master cost - " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
    }

    public boolean atU() {
        return this.cWN;
    }

    public d atV() {
        if (this.cWN) {
            return this.cWL;
        }
        if (DEBUG) {
            Log.w("SwanAppMasterProvider", "master not final confirmed, has default - " + atT());
            Log.w("SwanAppMasterProvider", Log.getStackTraceString(new RuntimeException("throw by debug")));
        }
        return null;
    }

    public void reset() {
        this.cWM = false;
        this.cWN = false;
        this.cWO = false;
        this.cWF = false;
        this.cWL = null;
        this.cWJ.e(null);
        synchronized (this.mLock) {
            this.cWK.clear();
        }
        a.atM();
    }

    private void atW() {
        if (!this.cWK.isEmpty() && this.cWN) {
            synchronized (this.mLock) {
                Iterator<com.baidu.swan.apps.event.a.a> it = this.cWK.iterator();
                while (it.hasNext()) {
                    com.baidu.swan.apps.event.a.a next = it.next();
                    if (DEBUG) {
                        Log.d("SwanAppMasterProvider", "dispatchPendingEvents event: " + next.cKK);
                    }
                    com.baidu.swan.apps.core.turbo.d.avA().b(next);
                }
                this.cWK.clear();
            }
        }
    }

    public boolean atX() {
        return this.cWF;
    }

    public void a(com.baidu.swan.apps.event.a.a aVar) {
        if (aVar != null && !this.cWN) {
            synchronized (this.mLock) {
                this.cWK.add(aVar);
            }
        }
    }

    @Override // com.baidu.swan.apps.core.g.a.c
    public void onReady() {
        this.cWM = true;
    }
}
