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
    private volatile boolean bdL;
    private com.baidu.swan.apps.core.g.a cMu;
    private final boolean cMv;
    private volatile String cMw;
    private long cMx;
    private long cMy;
    private boolean cMz;
    private final List<c> mCallbacks = new ArrayList();

    private d(boolean z, boolean z2) {
        this.cMv = z;
        this.cMz = z2;
    }

    public boolean isLoaded() {
        return !TextUtils.isEmpty(this.cMw);
    }

    public String apX() {
        return this.cMw;
    }

    public void nk(String str) {
        this.cMw = str;
    }

    public boolean isReady() {
        return this.bdL;
    }

    public boolean isDefault() {
        return this.cMv;
    }

    public com.baidu.swan.apps.core.g.a apY() {
        return this.cMu;
    }

    public long apZ() {
        return this.cMy - this.cMx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(c cVar) {
        if (cVar != null) {
            if (this.bdL) {
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
    public synchronized void aqa() {
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
        } else if (this.cMu == null) {
            if (DEBUG) {
                Log.i("PreloadMasterManager", "mMasterManager not create yet, can not prefetch");
            }
        } else if (this.cMv && !isLoaded()) {
            if (DEBUG) {
                Log.i("PreloadMasterManager", "default blank master can not use to prefetch");
            }
        } else if (isLoaded() && !TextUtils.equals(str, this.cMw)) {
            if (DEBUG) {
                Log.e("PreloadMasterManager", "one master can only prefetch one appId");
            }
        } else if (b(str, bVar)) {
            if (DEBUG) {
                Log.i("PreloadMasterManager", "intercept for current prefetch event - " + str);
            }
        } else {
            this.cMw = str;
            a(new c() { // from class: com.baidu.swan.apps.core.g.a.d.1
                @Override // com.baidu.swan.apps.core.g.a.c
                public void onReady() {
                    if (d.this.cMu != null && d.this.cMu.ajx() != null && !d.this.cMu.ajx().isDestroyed()) {
                        com.baidu.swan.apps.event.a.a(d.this.cMu.ajx(), bVar);
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
        dVar.cMx = System.currentTimeMillis();
        long currentTimeMillis = DEBUG ? System.currentTimeMillis() : 0L;
        dVar.cMu = com.baidu.swan.apps.core.turbo.d.arI().a(z2, new g() { // from class: com.baidu.swan.apps.core.g.a.d.2
            @Override // com.baidu.swan.apps.core.g
            public void hV(String str) {
                super.hV(str);
                if (d.DEBUG) {
                    Log.d("PreloadMasterManager", "prepareMaster finish. url: " + str);
                }
                d.this.bdL = true;
                d.this.cMy = System.currentTimeMillis();
                d.this.aqa();
                if (d.DEBUG) {
                    Log.d("PreloadMasterManager", "createBlankOne cost - " + d.this.apZ() + "ms");
                }
            }
        });
        if (DEBUG) {
            Log.i("PreloadMasterManager", "create a new master cost - " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
        return dVar;
    }
}
