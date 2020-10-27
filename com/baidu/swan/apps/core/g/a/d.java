package com.baidu.swan.apps.core.g.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.g;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private volatile boolean bcs;
    private com.baidu.swan.apps.core.g.a cGB;
    private final boolean cGC;
    private volatile String cGD;
    private long cGE;
    private long cGF;
    private boolean cGG;
    private final List<c> mCallbacks = new ArrayList();

    private d(boolean z, boolean z2) {
        this.cGC = z;
        this.cGG = z2;
    }

    public boolean isLoaded() {
        return !TextUtils.isEmpty(this.cGD);
    }

    public String anw() {
        return this.cGD;
    }

    public void mV(String str) {
        this.cGD = str;
    }

    public boolean isReady() {
        return this.bcs;
    }

    public boolean isDefault() {
        return this.cGC;
    }

    public com.baidu.swan.apps.core.g.a anx() {
        return this.cGB;
    }

    public long any() {
        return this.cGF - this.cGE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(c cVar) {
        if (cVar != null) {
            if (this.bcs) {
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
    public synchronized void anz() {
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
        } else if (this.cGB == null) {
            if (DEBUG) {
                Log.i("PreloadMasterManager", "mMasterManager not create yet, can not prefetch");
            }
        } else if (this.cGC && !isLoaded()) {
            if (DEBUG) {
                Log.i("PreloadMasterManager", "default blank master can not use to prefetch");
            }
        } else if (isLoaded() && !TextUtils.equals(str, this.cGD)) {
            if (DEBUG) {
                Log.e("PreloadMasterManager", "one master can only prefetch one appId");
            }
        } else if (b(str, bVar)) {
            if (DEBUG) {
                Log.i("PreloadMasterManager", "intercept for current prefetch event - " + str);
            }
        } else {
            this.cGD = str;
            a(new c() { // from class: com.baidu.swan.apps.core.g.a.d.1
                @Override // com.baidu.swan.apps.core.g.a.c
                public void onReady() {
                    if (d.this.cGB != null && d.this.cGB.agX() != null && !d.this.cGB.agX().isDestroyed()) {
                        com.baidu.swan.apps.event.a.a(d.this.cGB.agX(), bVar);
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
        dVar.cGE = System.currentTimeMillis();
        long currentTimeMillis = DEBUG ? System.currentTimeMillis() : 0L;
        dVar.cGB = com.baidu.swan.apps.core.turbo.d.aph().a(z2, new g() { // from class: com.baidu.swan.apps.core.g.a.d.2
            @Override // com.baidu.swan.apps.core.g
            public void hO(String str) {
                super.hO(str);
                if (d.DEBUG) {
                    Log.d("PreloadMasterManager", "prepareMaster finish. url: " + str);
                }
                d.this.bcs = true;
                d.this.cGF = System.currentTimeMillis();
                d.this.anz();
                if (d.DEBUG) {
                    Log.d("PreloadMasterManager", "createBlankOne cost - " + d.this.any() + "ms");
                }
            }
        });
        if (DEBUG) {
            Log.i("PreloadMasterManager", "create a new master cost - " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
        return dVar;
    }
}
