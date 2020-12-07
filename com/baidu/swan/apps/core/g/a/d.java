package com.baidu.swan.apps.core.g.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.g;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes25.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private volatile boolean bga;
    private com.baidu.swan.apps.core.g.a cRD;
    private final boolean cRE;
    private volatile String cRF;
    private long cRG;
    private long cRH;
    private boolean cRI;
    private final List<c> mCallbacks = new ArrayList();

    private d(boolean z, boolean z2) {
        this.cRE = z;
        this.cRI = z2;
    }

    public boolean isLoaded() {
        return !TextUtils.isEmpty(this.cRF);
    }

    public String asx() {
        return this.cRF;
    }

    public void nL(String str) {
        this.cRF = str;
    }

    public boolean isReady() {
        return this.bga;
    }

    public boolean isDefault() {
        return this.cRE;
    }

    public com.baidu.swan.apps.core.g.a asy() {
        return this.cRD;
    }

    public long asz() {
        return this.cRH - this.cRG;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(c cVar) {
        if (cVar != null) {
            if (this.bga) {
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
    public synchronized void asA() {
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
        } else if (this.cRD == null) {
            if (DEBUG) {
                Log.i("PreloadMasterManager", "mMasterManager not create yet, can not prefetch");
            }
        } else if (this.cRE && !isLoaded()) {
            if (DEBUG) {
                Log.i("PreloadMasterManager", "default blank master can not use to prefetch");
            }
        } else if (isLoaded() && !TextUtils.equals(str, this.cRF)) {
            if (DEBUG) {
                Log.e("PreloadMasterManager", "one master can only prefetch one appId");
            }
        } else if (b(str, bVar)) {
            if (DEBUG) {
                Log.i("PreloadMasterManager", "intercept for current prefetch event - " + str);
            }
        } else {
            this.cRF = str;
            a(new c() { // from class: com.baidu.swan.apps.core.g.a.d.1
                @Override // com.baidu.swan.apps.core.g.a.c
                public void onReady() {
                    if (d.this.cRD != null && d.this.cRD.alX() != null && !d.this.cRD.alX().isDestroyed()) {
                        com.baidu.swan.apps.event.a.a(d.this.cRD.alX(), bVar);
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
        dVar.cRG = System.currentTimeMillis();
        long currentTimeMillis = DEBUG ? System.currentTimeMillis() : 0L;
        dVar.cRD = com.baidu.swan.apps.core.turbo.d.aui().a(z2, new g() { // from class: com.baidu.swan.apps.core.g.a.d.2
            @Override // com.baidu.swan.apps.core.g
            public void it(String str) {
                super.it(str);
                if (d.DEBUG) {
                    Log.d("PreloadMasterManager", "prepareMaster finish. url: " + str);
                }
                d.this.bga = true;
                d.this.cRH = System.currentTimeMillis();
                d.this.asA();
                if (d.DEBUG) {
                    Log.d("PreloadMasterManager", "createBlankOne cost - " + d.this.asz() + "ms");
                }
            }
        });
        if (DEBUG) {
            Log.i("PreloadMasterManager", "create a new master cost - " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
        return dVar;
    }
}
