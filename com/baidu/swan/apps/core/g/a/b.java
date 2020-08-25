package com.baidu.swan.apps.core.g.a;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private List<d> cjH;
    private final Object mLock;
    private final int mMaxSize;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i) {
        if (i < 1) {
            throw new RuntimeException("MasterPool size can not less than 1");
        }
        this.mMaxSize = i;
        this.mLock = new Object();
        this.cjH = new LinkedList();
    }

    public void a(d dVar) {
        if (dVar != null) {
            synchronized (this.mLock) {
                if (!this.cjH.contains(dVar)) {
                    this.cjH.add(dVar);
                }
                resize();
            }
        }
    }

    public d lv(String str) {
        d dVar;
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.w("MasterPool", "appId can not be empty");
            }
            return null;
        }
        synchronized (this.mLock) {
            if (TextUtils.equals(str, "_default_id_")) {
                if (DEBUG) {
                    Log.i("MasterPool", "get default master manger for id - " + str);
                }
                return aig();
            }
            int size = this.cjH.size();
            int i = size - 1;
            while (true) {
                if (i < 0) {
                    dVar = null;
                    break;
                }
                dVar = this.cjH.get(i);
                if (!TextUtils.equals(dVar.aih(), str)) {
                    i--;
                } else if (DEBUG) {
                    Log.i("MasterPool", "get master in pool for id - " + str);
                }
            }
            if (dVar != null && i != size - 1) {
                this.cjH.remove(i);
                this.cjH.add(dVar);
            }
            if (DEBUG) {
                if (dVar == null) {
                    Log.i("MasterPool", "find no master for id - " + str);
                } else {
                    Log.i("MasterPool", "hit a master cache for id - " + str);
                }
            }
            return dVar;
        }
    }

    public void e(Collection<d> collection) {
        boolean z = collection == null || collection.size() <= 0;
        if (DEBUG) {
            Log.i("MasterPool", "master pool clear, excludes size - " + (collection != null ? collection.size() : 0));
            if (collection != null) {
                for (d dVar : collection) {
                    if (dVar.aii() != null) {
                        Log.i("MasterPool", "excludes  - " + dVar.aii().aaU());
                    }
                }
            }
        }
        synchronized (this.mLock) {
            ArrayList arrayList = new ArrayList();
            for (d dVar2 : this.cjH) {
                if (z || !collection.contains(dVar2)) {
                    arrayList.add(dVar2);
                }
            }
            f(arrayList);
        }
    }

    private d aig() {
        for (d dVar : this.cjH) {
            if (dVar.isDefault()) {
                return dVar;
            }
        }
        if (DEBUG) {
            throw new RuntimeException("there must be one default master in pool, you should add default one first");
        }
        return null;
    }

    private void resize() {
        boolean z;
        int size = this.cjH.size();
        if (size > this.mMaxSize) {
            if (DEBUG) {
                Log.i("MasterPool", "resize, current - " + size + ", target - " + this.mMaxSize);
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            boolean z2 = false;
            while (i < size) {
                d dVar = this.cjH.get(i);
                if (dVar.isDefault() && !z2) {
                    z = true;
                } else {
                    arrayList.add(dVar);
                    if (arrayList.size() >= size - this.mMaxSize) {
                        break;
                    }
                    z = z2;
                }
                i++;
                z2 = z;
            }
            f(arrayList);
        }
    }

    private void f(Collection<d> collection) {
        if (collection.size() > 0) {
            long currentTimeMillis = DEBUG ? System.currentTimeMillis() : 0L;
            this.cjH.removeAll(collection);
            if (DEBUG) {
                Log.i("MasterPool", "remove no use master in pool, size - " + collection.size());
            }
            for (d dVar : collection) {
                if (dVar.aii() != null) {
                    dVar.aii().destroy();
                    if (DEBUG) {
                        Log.i("MasterPool", "master destroy, id - " + dVar.aii().aaU() + ", isReady - " + dVar.isReady() + ", is Default - " + dVar.isDefault());
                    }
                }
            }
            if (DEBUG) {
                Log.i("MasterPool", "destroy masters cost - " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            }
        }
    }
}
