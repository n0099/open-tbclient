package com.baidu.swan.apps.core.g.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.g;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.core.g.a cRO;
    private final boolean cRP;
    private volatile String cRQ;
    private long cRR;
    private long cRS;
    private boolean cRT;
    private final List<c> mCallbacks = new ArrayList();
    private volatile boolean mIsReady;

    private d(boolean z, boolean z2) {
        this.cRP = z;
        this.cRT = z2;
    }

    public boolean isLoaded() {
        return !TextUtils.isEmpty(this.cRQ);
    }

    public String apU() {
        return this.cRQ;
    }

    public void mt(String str) {
        this.cRQ = str;
    }

    public boolean isReady() {
        return this.mIsReady;
    }

    public boolean isDefault() {
        return this.cRP;
    }

    public com.baidu.swan.apps.core.g.a apV() {
        return this.cRO;
    }

    public long apW() {
        return this.cRS - this.cRR;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(c cVar) {
        if (cVar != null) {
            if (this.mIsReady) {
                if (DEBUG) {
                    Log.d("PreloadMasterManager", "is Ready , call back immediately");
                }
                cVar.onReady();
            } else if (!this.mCallbacks.contains(cVar)) {
                this.mCallbacks.add(cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void apX() {
        if (DEBUG) {
            Log.d("PreloadMasterManager", "notifyAllReady, callback size " + this.mCallbacks.size());
        }
        for (c cVar : this.mCallbacks) {
            if (cVar != null) {
                cVar.onReady();
            }
        }
        this.mCallbacks.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, final PrefetchEvent.b bVar) {
        if (bVar == null) {
            if (DEBUG) {
                Log.e("PreloadMasterManager", "prefetch event is null");
            }
        } else if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.e("PreloadMasterManager", "prefetch appId is empty");
            }
        } else if (this.cRO == null) {
            if (DEBUG) {
                Log.i("PreloadMasterManager", "mMasterManager not create yet, can not prefetch");
            }
        } else if (this.cRP && !isLoaded()) {
            if (DEBUG) {
                Log.i("PreloadMasterManager", "default blank master can not use to prefetch");
            }
        } else if (isLoaded() && !TextUtils.equals(str, this.cRQ)) {
            if (DEBUG) {
                Log.e("PreloadMasterManager", "one master can only prefetch one appId");
            }
        } else if (b(str, bVar)) {
            if (DEBUG) {
                Log.i("PreloadMasterManager", "intercept for current prefetch event - " + str);
            }
        } else {
            this.cRQ = str;
            a(new c() { // from class: com.baidu.swan.apps.core.g.a.d.1
                @Override // com.baidu.swan.apps.core.g.a.c
                public void onReady() {
                    if (d.this.cRO != null && d.this.cRO.ajo() != null && !d.this.cRO.ajo().isDestroyed()) {
                        com.baidu.swan.apps.event.a.a(d.this.cRO.ajo(), bVar);
                    }
                }
            });
            if (DEBUG) {
                Log.i("PreloadMasterManager", "fire prefetch event - " + str);
            }
        }
    }

    private boolean b(String str, PrefetchEvent.b bVar) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d m(boolean z, boolean z2) {
        if (DEBUG) {
            Log.d("PreloadMasterManager", "start create a blank preload master manager, is default - " + z + ",is v8 - " + z2);
        }
        d dVar = new d(z, z2);
        dVar.cRR = System.currentTimeMillis();
        long currentTimeMillis = DEBUG ? System.currentTimeMillis() : 0L;
        dVar.cRO = com.baidu.swan.apps.core.turbo.d.arG().a(z2, new g() { // from class: com.baidu.swan.apps.core.g.a.d.2
            @Override // com.baidu.swan.apps.core.g
            public void gV(String str) {
                super.gV(str);
                if (d.DEBUG) {
                    Log.d("PreloadMasterManager", "prepareMaster finish. url: " + str);
                }
                d.this.mIsReady = true;
                d.this.cRS = System.currentTimeMillis();
                d.this.apX();
                if (d.DEBUG) {
                    Log.d("PreloadMasterManager", "createBlankOne cost - " + d.this.apW() + "ms");
                }
            }
        });
        if (DEBUG) {
            Log.i("PreloadMasterManager", "create a new master cost - " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
        return dVar;
    }
}
