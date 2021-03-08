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
    private d cVM;
    private LinkedList<com.baidu.swan.apps.event.a.a> cVL = new LinkedList<>();
    private b cVK = new b(2);
    private final Object mLock = new Object();
    private volatile boolean cVN = false;
    private volatile boolean cVO = false;
    private volatile boolean cVP = false;
    private boolean cVG = false;

    public void a(boolean z, c cVar) {
        if (!this.cVP) {
            synchronized (this.mLock) {
                if (!this.cVP) {
                    this.cVG = z;
                    d n = d.n(true, z);
                    n.a(this);
                    n.a(cVar);
                    this.cVK.a(n);
                    this.cVP = true;
                    return;
                }
            }
        }
        if (DEBUG) {
            Log.w("SwanAppMasterProvider", "call prepareDefault repeat");
        }
        d mR = this.cVK.mR("_default_id_");
        if (mR != null) {
            mR.a(cVar);
        }
    }

    public boolean aqz() {
        return this.cVN;
    }

    public boolean aqA() {
        return this.cVP;
    }

    public void a(String str, PrefetchEvent.b bVar) {
        if (DEBUG) {
            Log.i("SwanAppMasterProvider", "get a prefetch event - " + bVar);
        }
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.w("SwanAppMasterProvider", "prefetch appId is empty");
            }
        } else if (this.cVO) {
            com.baidu.swan.apps.runtime.e aIO = com.baidu.swan.apps.runtime.e.aIO();
            if (aIO != null) {
                if (TextUtils.equals(str, aIO.getAppId())) {
                    this.cVM.a(str, bVar);
                    if (DEBUG) {
                        Log.w("SwanAppMasterProvider", "prefetch after app start - " + str);
                    }
                } else if (DEBUG) {
                    Log.w("SwanAppMasterProvider", "can not prefetch after swan app start");
                }
            }
        } else if (!this.cVN) {
            if (DEBUG) {
                Log.w("SwanAppMasterProvider", "can not prefetch before default mater ready");
            }
        } else {
            synchronized (this.mLock) {
                if (!this.cVO) {
                    d mR = this.cVK.mR(str);
                    if (mR == null) {
                        mR = d.n(false, this.cVG);
                        this.cVK.a(mR);
                    }
                    mR.a(str, bVar);
                }
            }
        }
    }

    public d mT(String str) {
        d mR;
        long currentTimeMillis = DEBUG ? System.currentTimeMillis() : 0L;
        if (DEBUG) {
            Log.w("SwanAppMasterProvider", "real start a swan app - " + str);
        }
        if (!this.cVN && DEBUG) {
            throw new RuntimeException("should call startApp after preload finished");
        }
        if (this.cVO) {
            return this.cVM;
        }
        synchronized (this.mLock) {
            if (!this.cVO) {
                if (TextUtils.isEmpty(str)) {
                    mR = this.cVK.mR("_default_id_");
                } else {
                    mR = this.cVK.mR(str);
                    if (mR == null || !mR.isReady()) {
                        mR = this.cVK.mR("_default_id_");
                    }
                }
                a(mR, str);
            }
        }
        if (DEBUG) {
            Log.i("SwanAppMasterProvider", "get right master cost - " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            Log.i("SwanAppMasterProvider", "final master id - " + this.cVM.aqw().ajb());
        }
        return this.cVM;
    }

    private void a(d dVar, String str) {
        this.cVM = dVar;
        this.cVM.mS(str);
        this.cVO = true;
        aqD();
        long currentTimeMillis = DEBUG ? System.currentTimeMillis() : 0L;
        this.cVK.e(Collections.singletonList(dVar));
        if (DEBUG) {
            Log.i("SwanAppMasterProvider", "clear useless master cost - " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
    }

    public boolean aqB() {
        return this.cVO;
    }

    public d aqC() {
        if (this.cVO) {
            return this.cVM;
        }
        if (DEBUG) {
            Log.w("SwanAppMasterProvider", "master not final confirmed, has default - " + aqA());
            Log.w("SwanAppMasterProvider", Log.getStackTraceString(new RuntimeException("throw by debug")));
        }
        return null;
    }

    public void reset() {
        this.cVN = false;
        this.cVO = false;
        this.cVP = false;
        this.cVG = false;
        this.cVM = null;
        this.cVK.e(null);
        synchronized (this.mLock) {
            this.cVL.clear();
        }
        a.aqt();
    }

    private void aqD() {
        if (!this.cVL.isEmpty() && this.cVO) {
            synchronized (this.mLock) {
                Iterator<com.baidu.swan.apps.event.a.a> it = this.cVL.iterator();
                while (it.hasNext()) {
                    com.baidu.swan.apps.event.a.a next = it.next();
                    if (DEBUG) {
                        Log.d("SwanAppMasterProvider", "dispatchPendingEvents event: " + next.cJT);
                    }
                    com.baidu.swan.apps.core.turbo.d.ash().b(next);
                }
                this.cVL.clear();
            }
        }
    }

    public boolean aqE() {
        return this.cVG;
    }

    public void a(com.baidu.swan.apps.event.a.a aVar) {
        if (aVar != null && !this.cVO) {
            synchronized (this.mLock) {
                this.cVL.add(aVar);
            }
        }
    }

    @Override // com.baidu.swan.apps.core.g.a.c
    public void onReady() {
        this.cVN = true;
    }
}
