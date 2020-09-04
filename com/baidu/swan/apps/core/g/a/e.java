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
    private d cjX;
    private LinkedList<com.baidu.swan.apps.event.a.a> cjW = new LinkedList<>();
    private b cjV = new b(2);
    private final Object mLock = new Object();
    private volatile boolean cjY = false;
    private volatile boolean cjZ = false;
    private volatile boolean cka = false;
    private boolean cjR = false;

    public void a(boolean z, c cVar) {
        if (!this.cka) {
            synchronized (this.mLock) {
                if (!this.cka) {
                    this.cjR = z;
                    d m = d.m(true, z);
                    m.a(this);
                    m.a(cVar);
                    this.cjV.a(m);
                    this.cka = true;
                    return;
                }
            }
        }
        if (DEBUG) {
            Log.w("SwanAppMasterProvider", "call prepareDefault repeat");
        }
        d lw = this.cjV.lw("_default_id_");
        if (lw != null) {
            lw.a(cVar);
        }
    }

    public boolean ail() {
        return this.cjY;
    }

    public boolean aim() {
        return this.cka;
    }

    public void a(String str, PrefetchEvent.b bVar) {
        if (DEBUG) {
            Log.i("SwanAppMasterProvider", "get a prefetch event - " + bVar);
        }
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.w("SwanAppMasterProvider", "prefetch appId is empty");
            }
        } else if (this.cjZ) {
            com.baidu.swan.apps.runtime.e azJ = com.baidu.swan.apps.runtime.e.azJ();
            if (azJ != null) {
                if (TextUtils.equals(str, azJ.getAppId())) {
                    this.cjX.a(str, bVar);
                    if (DEBUG) {
                        Log.w("SwanAppMasterProvider", "prefetch after app start - " + str);
                    }
                } else if (DEBUG) {
                    Log.w("SwanAppMasterProvider", "can not prefetch after swan app start");
                }
            }
        } else if (!this.cjY) {
            if (DEBUG) {
                Log.w("SwanAppMasterProvider", "can not prefetch before default mater ready");
            }
        } else {
            synchronized (this.mLock) {
                if (!this.cjZ) {
                    d lw = this.cjV.lw(str);
                    if (lw == null) {
                        lw = d.m(false, this.cjR);
                        this.cjV.a(lw);
                    }
                    lw.a(str, bVar);
                }
            }
        }
    }

    public d ly(String str) {
        d lw;
        long currentTimeMillis = DEBUG ? System.currentTimeMillis() : 0L;
        if (DEBUG) {
            Log.w("SwanAppMasterProvider", "real start a swan app - " + str);
        }
        if (!this.cjY && DEBUG) {
            throw new RuntimeException("should call startApp after preload finished");
        }
        if (this.cjZ) {
            return this.cjX;
        }
        synchronized (this.mLock) {
            if (!this.cjZ) {
                if (TextUtils.isEmpty(str)) {
                    lw = this.cjV.lw("_default_id_");
                } else {
                    lw = this.cjV.lw(str);
                    if (lw == null || !lw.isReady()) {
                        lw = this.cjV.lw("_default_id_");
                    }
                }
                a(lw, str);
            }
        }
        if (DEBUG) {
            Log.i("SwanAppMasterProvider", "get right master cost - " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            Log.i("SwanAppMasterProvider", "final master id - " + this.cjX.aii().aaU());
        }
        return this.cjX;
    }

    private void a(d dVar, String str) {
        this.cjX = dVar;
        this.cjX.lx(str);
        this.cjZ = true;
        aip();
        long currentTimeMillis = DEBUG ? System.currentTimeMillis() : 0L;
        this.cjV.e(Collections.singletonList(dVar));
        if (DEBUG) {
            Log.i("SwanAppMasterProvider", "clear useless master cost - " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
    }

    public boolean ain() {
        return this.cjZ;
    }

    public d aio() {
        if (this.cjZ) {
            return this.cjX;
        }
        if (DEBUG) {
            Log.w("SwanAppMasterProvider", "master not final confirmed, has default - " + aim());
            Log.w("SwanAppMasterProvider", Log.getStackTraceString(new RuntimeException("throw by debug")));
        }
        return null;
    }

    public void reset() {
        this.cjY = false;
        this.cjZ = false;
        this.cka = false;
        this.cjR = false;
        this.cjX = null;
        this.cjV.e(null);
        synchronized (this.mLock) {
            this.cjW.clear();
        }
        a.aif();
    }

    private void aip() {
        if (!this.cjW.isEmpty() && this.cjZ) {
            synchronized (this.mLock) {
                Iterator<com.baidu.swan.apps.event.a.a> it = this.cjW.iterator();
                while (it.hasNext()) {
                    com.baidu.swan.apps.event.a.a next = it.next();
                    if (DEBUG) {
                        Log.d("SwanAppMasterProvider", "dispatchPendingEvents event: " + next.bXY);
                    }
                    com.baidu.swan.apps.core.turbo.d.ajS().b(next);
                }
                this.cjW.clear();
            }
        }
    }

    public boolean aiq() {
        return this.cjR;
    }

    public void a(com.baidu.swan.apps.event.a.a aVar) {
        if (aVar != null && !this.cjZ) {
            synchronized (this.mLock) {
                this.cjW.add(aVar);
            }
        }
    }

    @Override // com.baidu.swan.apps.core.g.a.c
    public void onReady() {
        this.cjY = true;
    }
}
