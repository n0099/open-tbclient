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
    private d cRZ;
    private LinkedList<com.baidu.swan.apps.event.a.a> cRY = new LinkedList<>();
    private b cRX = new b(2);
    private final Object mLock = new Object();
    private volatile boolean cSa = false;
    private volatile boolean cSb = false;
    private volatile boolean cSc = false;
    private boolean cRT = false;

    public void a(boolean z, c cVar) {
        if (!this.cSc) {
            synchronized (this.mLock) {
                if (!this.cSc) {
                    this.cRT = z;
                    d m = d.m(true, z);
                    m.a(this);
                    m.a(cVar);
                    this.cRX.a(m);
                    this.cSc = true;
                    return;
                }
            }
        }
        if (DEBUG) {
            Log.w("SwanAppMasterProvider", "call prepareDefault repeat");
        }
        d ms = this.cRX.ms("_default_id_");
        if (ms != null) {
            ms.a(cVar);
        }
    }

    public boolean apY() {
        return this.cSa;
    }

    public boolean apZ() {
        return this.cSc;
    }

    public void a(String str, PrefetchEvent.b bVar) {
        if (DEBUG) {
            Log.i("SwanAppMasterProvider", "get a prefetch event - " + bVar);
        }
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.w("SwanAppMasterProvider", "prefetch appId is empty");
            }
        } else if (this.cSb) {
            com.baidu.swan.apps.runtime.e aIs = com.baidu.swan.apps.runtime.e.aIs();
            if (aIs != null) {
                if (TextUtils.equals(str, aIs.getAppId())) {
                    this.cRZ.a(str, bVar);
                    if (DEBUG) {
                        Log.w("SwanAppMasterProvider", "prefetch after app start - " + str);
                    }
                } else if (DEBUG) {
                    Log.w("SwanAppMasterProvider", "can not prefetch after swan app start");
                }
            }
        } else if (!this.cSa) {
            if (DEBUG) {
                Log.w("SwanAppMasterProvider", "can not prefetch before default mater ready");
            }
        } else {
            synchronized (this.mLock) {
                if (!this.cSb) {
                    d ms = this.cRX.ms(str);
                    if (ms == null) {
                        ms = d.m(false, this.cRT);
                        this.cRX.a(ms);
                    }
                    ms.a(str, bVar);
                }
            }
        }
    }

    public d mu(String str) {
        d ms;
        long currentTimeMillis = DEBUG ? System.currentTimeMillis() : 0L;
        if (DEBUG) {
            Log.w("SwanAppMasterProvider", "real start a swan app - " + str);
        }
        if (!this.cSa && DEBUG) {
            throw new RuntimeException("should call startApp after preload finished");
        }
        if (this.cSb) {
            return this.cRZ;
        }
        synchronized (this.mLock) {
            if (!this.cSb) {
                if (TextUtils.isEmpty(str)) {
                    ms = this.cRX.ms("_default_id_");
                } else {
                    ms = this.cRX.ms(str);
                    if (ms == null || !ms.isReady()) {
                        ms = this.cRX.ms("_default_id_");
                    }
                }
                a(ms, str);
            }
        }
        if (DEBUG) {
            Log.i("SwanAppMasterProvider", "get right master cost - " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            Log.i("SwanAppMasterProvider", "final master id - " + this.cRZ.apV().aiA());
        }
        return this.cRZ;
    }

    private void a(d dVar, String str) {
        this.cRZ = dVar;
        this.cRZ.mt(str);
        this.cSb = true;
        aqc();
        long currentTimeMillis = DEBUG ? System.currentTimeMillis() : 0L;
        this.cRX.e(Collections.singletonList(dVar));
        if (DEBUG) {
            Log.i("SwanAppMasterProvider", "clear useless master cost - " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
    }

    public boolean aqa() {
        return this.cSb;
    }

    public d aqb() {
        if (this.cSb) {
            return this.cRZ;
        }
        if (DEBUG) {
            Log.w("SwanAppMasterProvider", "master not final confirmed, has default - " + apZ());
            Log.w("SwanAppMasterProvider", Log.getStackTraceString(new RuntimeException("throw by debug")));
        }
        return null;
    }

    public void reset() {
        this.cSa = false;
        this.cSb = false;
        this.cSc = false;
        this.cRT = false;
        this.cRZ = null;
        this.cRX.e(null);
        synchronized (this.mLock) {
            this.cRY.clear();
        }
        a.apS();
    }

    private void aqc() {
        if (!this.cRY.isEmpty() && this.cSb) {
            synchronized (this.mLock) {
                Iterator<com.baidu.swan.apps.event.a.a> it = this.cRY.iterator();
                while (it.hasNext()) {
                    com.baidu.swan.apps.event.a.a next = it.next();
                    if (DEBUG) {
                        Log.d("SwanAppMasterProvider", "dispatchPendingEvents event: " + next.cFY);
                    }
                    com.baidu.swan.apps.core.turbo.d.arG().b(next);
                }
                this.cRY.clear();
            }
        }
    }

    public boolean aqd() {
        return this.cRT;
    }

    public void a(com.baidu.swan.apps.event.a.a aVar) {
        if (aVar != null && !this.cSb) {
            synchronized (this.mLock) {
                this.cRY.add(aVar);
            }
        }
    }

    @Override // com.baidu.swan.apps.core.g.a.c
    public void onReady() {
        this.cSa = true;
    }
}
