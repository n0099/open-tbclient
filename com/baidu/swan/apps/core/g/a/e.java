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
    private d cUm;
    private LinkedList<com.baidu.swan.apps.event.a.a> cUl = new LinkedList<>();
    private b cUk = new b(2);
    private final Object mLock = new Object();
    private volatile boolean cUn = false;
    private volatile boolean cUo = false;
    private volatile boolean cUp = false;
    private boolean cUg = false;

    public void a(boolean z, c cVar) {
        if (!this.cUp) {
            synchronized (this.mLock) {
                if (!this.cUp) {
                    this.cUg = z;
                    d n = d.n(true, z);
                    n.a(this);
                    n.a(cVar);
                    this.cUk.a(n);
                    this.cUp = true;
                    return;
                }
            }
        }
        if (DEBUG) {
            Log.w("SwanAppMasterProvider", "call prepareDefault repeat");
        }
        d mK = this.cUk.mK("_default_id_");
        if (mK != null) {
            mK.a(cVar);
        }
    }

    public boolean aqw() {
        return this.cUn;
    }

    public boolean aqx() {
        return this.cUp;
    }

    public void a(String str, PrefetchEvent.b bVar) {
        if (DEBUG) {
            Log.i("SwanAppMasterProvider", "get a prefetch event - " + bVar);
        }
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.w("SwanAppMasterProvider", "prefetch appId is empty");
            }
        } else if (this.cUo) {
            com.baidu.swan.apps.runtime.e aIL = com.baidu.swan.apps.runtime.e.aIL();
            if (aIL != null) {
                if (TextUtils.equals(str, aIL.getAppId())) {
                    this.cUm.a(str, bVar);
                    if (DEBUG) {
                        Log.w("SwanAppMasterProvider", "prefetch after app start - " + str);
                    }
                } else if (DEBUG) {
                    Log.w("SwanAppMasterProvider", "can not prefetch after swan app start");
                }
            }
        } else if (!this.cUn) {
            if (DEBUG) {
                Log.w("SwanAppMasterProvider", "can not prefetch before default mater ready");
            }
        } else {
            synchronized (this.mLock) {
                if (!this.cUo) {
                    d mK = this.cUk.mK(str);
                    if (mK == null) {
                        mK = d.n(false, this.cUg);
                        this.cUk.a(mK);
                    }
                    mK.a(str, bVar);
                }
            }
        }
    }

    public d mM(String str) {
        d mK;
        long currentTimeMillis = DEBUG ? System.currentTimeMillis() : 0L;
        if (DEBUG) {
            Log.w("SwanAppMasterProvider", "real start a swan app - " + str);
        }
        if (!this.cUn && DEBUG) {
            throw new RuntimeException("should call startApp after preload finished");
        }
        if (this.cUo) {
            return this.cUm;
        }
        synchronized (this.mLock) {
            if (!this.cUo) {
                if (TextUtils.isEmpty(str)) {
                    mK = this.cUk.mK("_default_id_");
                } else {
                    mK = this.cUk.mK(str);
                    if (mK == null || !mK.isReady()) {
                        mK = this.cUk.mK("_default_id_");
                    }
                }
                a(mK, str);
            }
        }
        if (DEBUG) {
            Log.i("SwanAppMasterProvider", "get right master cost - " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            Log.i("SwanAppMasterProvider", "final master id - " + this.cUm.aqt().aiY());
        }
        return this.cUm;
    }

    private void a(d dVar, String str) {
        this.cUm = dVar;
        this.cUm.mL(str);
        this.cUo = true;
        aqA();
        long currentTimeMillis = DEBUG ? System.currentTimeMillis() : 0L;
        this.cUk.e(Collections.singletonList(dVar));
        if (DEBUG) {
            Log.i("SwanAppMasterProvider", "clear useless master cost - " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
    }

    public boolean aqy() {
        return this.cUo;
    }

    public d aqz() {
        if (this.cUo) {
            return this.cUm;
        }
        if (DEBUG) {
            Log.w("SwanAppMasterProvider", "master not final confirmed, has default - " + aqx());
            Log.w("SwanAppMasterProvider", Log.getStackTraceString(new RuntimeException("throw by debug")));
        }
        return null;
    }

    public void reset() {
        this.cUn = false;
        this.cUo = false;
        this.cUp = false;
        this.cUg = false;
        this.cUm = null;
        this.cUk.e(null);
        synchronized (this.mLock) {
            this.cUl.clear();
        }
        a.aqq();
    }

    private void aqA() {
        if (!this.cUl.isEmpty() && this.cUo) {
            synchronized (this.mLock) {
                Iterator<com.baidu.swan.apps.event.a.a> it = this.cUl.iterator();
                while (it.hasNext()) {
                    com.baidu.swan.apps.event.a.a next = it.next();
                    if (DEBUG) {
                        Log.d("SwanAppMasterProvider", "dispatchPendingEvents event: " + next.cIt);
                    }
                    com.baidu.swan.apps.core.turbo.d.ase().b(next);
                }
                this.cUl.clear();
            }
        }
    }

    public boolean aqB() {
        return this.cUg;
    }

    public void a(com.baidu.swan.apps.event.a.a aVar) {
        if (aVar != null && !this.cUo) {
            synchronized (this.mLock) {
                this.cUl.add(aVar);
            }
        }
    }

    @Override // com.baidu.swan.apps.core.g.a.c
    public void onReady() {
        this.cUn = true;
    }
}
