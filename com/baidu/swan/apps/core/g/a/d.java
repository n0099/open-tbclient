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
    private volatile boolean aVq;
    private com.baidu.swan.apps.core.g.a cjI;
    private final boolean cjJ;
    private volatile String cjK;
    private long cjL;
    private long cjM;
    private boolean cjN;
    private final List<c> mCallbacks = new ArrayList();

    private d(boolean z, boolean z2) {
        this.cjJ = z;
        this.cjN = z2;
    }

    public boolean isLoaded() {
        return !TextUtils.isEmpty(this.cjK);
    }

    public String aih() {
        return this.cjK;
    }

    public void lw(String str) {
        this.cjK = str;
    }

    public boolean isReady() {
        return this.aVq;
    }

    public boolean isDefault() {
        return this.cjJ;
    }

    public com.baidu.swan.apps.core.g.a aii() {
        return this.cjI;
    }

    public long aij() {
        return this.cjM - this.cjL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(c cVar) {
        if (cVar != null) {
            if (this.aVq) {
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
    public synchronized void aik() {
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
        } else if (this.cjI == null) {
            if (DEBUG) {
                Log.i("PreloadMasterManager", "mMasterManager not create yet, can not prefetch");
            }
        } else if (this.cjJ && !isLoaded()) {
            if (DEBUG) {
                Log.i("PreloadMasterManager", "default blank master can not use to prefetch");
            }
        } else if (isLoaded() && !TextUtils.equals(str, this.cjK)) {
            if (DEBUG) {
                Log.e("PreloadMasterManager", "one master can only prefetch one appId");
            }
        } else if (b(str, bVar)) {
            if (DEBUG) {
                Log.i("PreloadMasterManager", "intercept for current prefetch event - " + str);
            }
        } else {
            this.cjK = str;
            a(new c() { // from class: com.baidu.swan.apps.core.g.a.d.1
                @Override // com.baidu.swan.apps.core.g.a.c
                public void onReady() {
                    if (d.this.cjI != null && d.this.cjI.abI() != null && !d.this.cjI.abI().isDestroyed()) {
                        com.baidu.swan.apps.event.a.a(d.this.cjI.abI(), bVar);
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
        dVar.cjL = System.currentTimeMillis();
        long currentTimeMillis = DEBUG ? System.currentTimeMillis() : 0L;
        dVar.cjI = com.baidu.swan.apps.core.turbo.d.ajS().a(z2, new g() { // from class: com.baidu.swan.apps.core.g.a.d.2
            @Override // com.baidu.swan.apps.core.g
            public void hs(String str) {
                super.hs(str);
                if (d.DEBUG) {
                    Log.d("PreloadMasterManager", "prepareMaster finish. url: " + str);
                }
                d.this.aVq = true;
                d.this.cjM = System.currentTimeMillis();
                d.this.aik();
                if (d.DEBUG) {
                    Log.d("PreloadMasterManager", "createBlankOne cost - " + d.this.aij() + "ms");
                }
            }
        });
        if (DEBUG) {
            Log.i("PreloadMasterManager", "create a new master cost - " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
        return dVar;
    }
}
