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
    private d cGM;
    private LinkedList<com.baidu.swan.apps.event.a.a> cGL = new LinkedList<>();
    private b cGK = new b(2);
    private final Object mLock = new Object();
    private volatile boolean cGN = false;
    private volatile boolean cGO = false;
    private volatile boolean cGP = false;
    private boolean cGG = false;

    public void a(boolean z, c cVar) {
        if (!this.cGP) {
            synchronized (this.mLock) {
                if (!this.cGP) {
                    this.cGG = z;
                    d m = d.m(true, z);
                    m.a(this);
                    m.a(cVar);
                    this.cGK.a(m);
                    this.cGP = true;
                    return;
                }
            }
        }
        if (DEBUG) {
            Log.w("SwanAppMasterProvider", "call prepareDefault repeat");
        }
        d mU = this.cGK.mU("_default_id_");
        if (mU != null) {
            mU.a(cVar);
        }
    }

    public boolean anA() {
        return this.cGN;
    }

    public boolean anB() {
        return this.cGP;
    }

    public void a(String str, PrefetchEvent.b bVar) {
        if (DEBUG) {
            Log.i("SwanAppMasterProvider", "get a prefetch event - " + bVar);
        }
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.w("SwanAppMasterProvider", "prefetch appId is empty");
            }
        } else if (this.cGO) {
            com.baidu.swan.apps.runtime.e aEV = com.baidu.swan.apps.runtime.e.aEV();
            if (aEV != null) {
                if (TextUtils.equals(str, aEV.getAppId())) {
                    this.cGM.a(str, bVar);
                    if (DEBUG) {
                        Log.w("SwanAppMasterProvider", "prefetch after app start - " + str);
                    }
                } else if (DEBUG) {
                    Log.w("SwanAppMasterProvider", "can not prefetch after swan app start");
                }
            }
        } else if (!this.cGN) {
            if (DEBUG) {
                Log.w("SwanAppMasterProvider", "can not prefetch before default mater ready");
            }
        } else {
            synchronized (this.mLock) {
                if (!this.cGO) {
                    d mU = this.cGK.mU(str);
                    if (mU == null) {
                        mU = d.m(false, this.cGG);
                        this.cGK.a(mU);
                    }
                    mU.a(str, bVar);
                }
            }
        }
    }

    public d mW(String str) {
        d mU;
        long currentTimeMillis = DEBUG ? System.currentTimeMillis() : 0L;
        if (DEBUG) {
            Log.w("SwanAppMasterProvider", "real start a swan app - " + str);
        }
        if (!this.cGN && DEBUG) {
            throw new RuntimeException("should call startApp after preload finished");
        }
        if (this.cGO) {
            return this.cGM;
        }
        synchronized (this.mLock) {
            if (!this.cGO) {
                if (TextUtils.isEmpty(str)) {
                    mU = this.cGK.mU("_default_id_");
                } else {
                    mU = this.cGK.mU(str);
                    if (mU == null || !mU.isReady()) {
                        mU = this.cGK.mU("_default_id_");
                    }
                }
                a(mU, str);
            }
        }
        if (DEBUG) {
            Log.i("SwanAppMasterProvider", "get right master cost - " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            Log.i("SwanAppMasterProvider", "final master id - " + this.cGM.anx().agj());
        }
        return this.cGM;
    }

    private void a(d dVar, String str) {
        this.cGM = dVar;
        this.cGM.mV(str);
        this.cGO = true;
        anE();
        long currentTimeMillis = DEBUG ? System.currentTimeMillis() : 0L;
        this.cGK.e(Collections.singletonList(dVar));
        if (DEBUG) {
            Log.i("SwanAppMasterProvider", "clear useless master cost - " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
    }

    public boolean anC() {
        return this.cGO;
    }

    public d anD() {
        if (this.cGO) {
            return this.cGM;
        }
        if (DEBUG) {
            Log.w("SwanAppMasterProvider", "master not final confirmed, has default - " + anB());
            Log.w("SwanAppMasterProvider", Log.getStackTraceString(new RuntimeException("throw by debug")));
        }
        return null;
    }

    public void reset() {
        this.cGN = false;
        this.cGO = false;
        this.cGP = false;
        this.cGG = false;
        this.cGM = null;
        this.cGK.e(null);
        synchronized (this.mLock) {
            this.cGL.clear();
        }
        a.anu();
    }

    private void anE() {
        if (!this.cGL.isEmpty() && this.cGO) {
            synchronized (this.mLock) {
                Iterator<com.baidu.swan.apps.event.a.a> it = this.cGL.iterator();
                while (it.hasNext()) {
                    com.baidu.swan.apps.event.a.a next = it.next();
                    if (DEBUG) {
                        Log.d("SwanAppMasterProvider", "dispatchPendingEvents event: " + next.cuT);
                    }
                    com.baidu.swan.apps.core.turbo.d.aph().b(next);
                }
                this.cGL.clear();
            }
        }
    }

    public boolean anF() {
        return this.cGG;
    }

    public void a(com.baidu.swan.apps.event.a.a aVar) {
        if (aVar != null && !this.cGO) {
            synchronized (this.mLock) {
                this.cGL.add(aVar);
            }
        }
    }

    @Override // com.baidu.swan.apps.core.g.a.c
    public void onReady() {
        this.cGN = true;
    }
}
