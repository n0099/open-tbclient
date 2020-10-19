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
    private d cyq;
    private LinkedList<com.baidu.swan.apps.event.a.a> cyp = new LinkedList<>();
    private b cyo = new b(2);
    private final Object mLock = new Object();
    private volatile boolean cyr = false;
    private volatile boolean cys = false;
    private volatile boolean cyt = false;
    private boolean cyk = false;

    public void a(boolean z, c cVar) {
        if (!this.cyt) {
            synchronized (this.mLock) {
                if (!this.cyt) {
                    this.cyk = z;
                    d m = d.m(true, z);
                    m.a(this);
                    m.a(cVar);
                    this.cyo.a(m);
                    this.cyt = true;
                    return;
                }
            }
        }
        if (DEBUG) {
            Log.w("SwanAppMasterProvider", "call prepareDefault repeat");
        }
        d mB = this.cyo.mB("_default_id_");
        if (mB != null) {
            mB.a(cVar);
        }
    }

    public boolean alG() {
        return this.cyr;
    }

    public boolean alH() {
        return this.cyt;
    }

    public void a(String str, PrefetchEvent.b bVar) {
        if (DEBUG) {
            Log.i("SwanAppMasterProvider", "get a prefetch event - " + bVar);
        }
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.w("SwanAppMasterProvider", "prefetch appId is empty");
            }
        } else if (this.cys) {
            com.baidu.swan.apps.runtime.e aDb = com.baidu.swan.apps.runtime.e.aDb();
            if (aDb != null) {
                if (TextUtils.equals(str, aDb.getAppId())) {
                    this.cyq.a(str, bVar);
                    if (DEBUG) {
                        Log.w("SwanAppMasterProvider", "prefetch after app start - " + str);
                    }
                } else if (DEBUG) {
                    Log.w("SwanAppMasterProvider", "can not prefetch after swan app start");
                }
            }
        } else if (!this.cyr) {
            if (DEBUG) {
                Log.w("SwanAppMasterProvider", "can not prefetch before default mater ready");
            }
        } else {
            synchronized (this.mLock) {
                if (!this.cys) {
                    d mB = this.cyo.mB(str);
                    if (mB == null) {
                        mB = d.m(false, this.cyk);
                        this.cyo.a(mB);
                    }
                    mB.a(str, bVar);
                }
            }
        }
    }

    public d mD(String str) {
        d mB;
        long currentTimeMillis = DEBUG ? System.currentTimeMillis() : 0L;
        if (DEBUG) {
            Log.w("SwanAppMasterProvider", "real start a swan app - " + str);
        }
        if (!this.cyr && DEBUG) {
            throw new RuntimeException("should call startApp after preload finished");
        }
        if (this.cys) {
            return this.cyq;
        }
        synchronized (this.mLock) {
            if (!this.cys) {
                if (TextUtils.isEmpty(str)) {
                    mB = this.cyo.mB("_default_id_");
                } else {
                    mB = this.cyo.mB(str);
                    if (mB == null || !mB.isReady()) {
                        mB = this.cyo.mB("_default_id_");
                    }
                }
                a(mB, str);
            }
        }
        if (DEBUG) {
            Log.i("SwanAppMasterProvider", "get right master cost - " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            Log.i("SwanAppMasterProvider", "final master id - " + this.cyq.alD().aep());
        }
        return this.cyq;
    }

    private void a(d dVar, String str) {
        this.cyq = dVar;
        this.cyq.mC(str);
        this.cys = true;
        alK();
        long currentTimeMillis = DEBUG ? System.currentTimeMillis() : 0L;
        this.cyo.e(Collections.singletonList(dVar));
        if (DEBUG) {
            Log.i("SwanAppMasterProvider", "clear useless master cost - " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
    }

    public boolean alI() {
        return this.cys;
    }

    public d alJ() {
        if (this.cys) {
            return this.cyq;
        }
        if (DEBUG) {
            Log.w("SwanAppMasterProvider", "master not final confirmed, has default - " + alH());
            Log.w("SwanAppMasterProvider", Log.getStackTraceString(new RuntimeException("throw by debug")));
        }
        return null;
    }

    public void reset() {
        this.cyr = false;
        this.cys = false;
        this.cyt = false;
        this.cyk = false;
        this.cyq = null;
        this.cyo.e(null);
        synchronized (this.mLock) {
            this.cyp.clear();
        }
        a.alA();
    }

    private void alK() {
        if (!this.cyp.isEmpty() && this.cys) {
            synchronized (this.mLock) {
                Iterator<com.baidu.swan.apps.event.a.a> it = this.cyp.iterator();
                while (it.hasNext()) {
                    com.baidu.swan.apps.event.a.a next = it.next();
                    if (DEBUG) {
                        Log.d("SwanAppMasterProvider", "dispatchPendingEvents event: " + next.cmp);
                    }
                    com.baidu.swan.apps.core.turbo.d.ann().b(next);
                }
                this.cyp.clear();
            }
        }
    }

    public boolean alL() {
        return this.cyk;
    }

    public void a(com.baidu.swan.apps.event.a.a aVar) {
        if (aVar != null && !this.cys) {
            synchronized (this.mLock) {
                this.cyp.add(aVar);
            }
        }
    }

    @Override // com.baidu.swan.apps.core.g.a.c
    public void onReady() {
        this.cyr = true;
    }
}
