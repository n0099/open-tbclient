package com.baidu.swan.pms.utils;

import com.baidu.swan.pms.model.PMSPkgStatus;
import com.baidu.swan.pms.model.i;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
/* loaded from: classes15.dex */
public class f {
    private Set<a> edE = Collections.synchronizedSet(new HashSet());

    public void a(com.baidu.swan.pms.model.e eVar, PMSPkgStatus pMSPkgStatus) {
        this.edE.add(new a(eVar, pMSPkgStatus));
    }

    public int aZY() {
        return this.edE.size();
    }

    public boolean isEmpty() {
        return this.edE.isEmpty();
    }

    public boolean aZZ() {
        for (a aVar : this.edE) {
            if (aVar != null && (aVar.cRv instanceof com.baidu.swan.pms.model.f)) {
                return true;
            }
        }
        return false;
    }

    public boolean baa() {
        for (a aVar : this.edE) {
            if (aVar != null && (aVar.cRv instanceof com.baidu.swan.pms.model.g)) {
                return true;
            }
        }
        return false;
    }

    public boolean bab() {
        for (a aVar : this.edE) {
            if (aVar != null && (aVar.cRv instanceof i)) {
                return true;
            }
        }
        return false;
    }

    public boolean bac() {
        for (a aVar : this.edE) {
            if (aVar != null && (aVar.cRv instanceof com.baidu.swan.pms.model.d)) {
                return true;
            }
        }
        return false;
    }

    public boolean bad() {
        for (a aVar : this.edE) {
            if (aVar != null && (aVar.cRv instanceof com.baidu.swan.pms.model.b)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0.edF = com.baidu.swan.pms.model.PMSPkgStatus.ERROR;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void f(com.baidu.swan.pms.model.e eVar) {
        if (eVar != null) {
            Iterator<a> it = this.edE.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next != null && next.cRv.equals(eVar)) {
                    break;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0.edF = com.baidu.swan.pms.model.PMSPkgStatus.FINISH;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void g(com.baidu.swan.pms.model.e eVar) {
        if (eVar != null) {
            Iterator<a> it = this.edE.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next != null && next.cRv.equals(eVar)) {
                    break;
                }
            }
        }
    }

    public synchronized boolean bae() {
        boolean z;
        Iterator<a> it = this.edE.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            a next = it.next();
            if (next != null && (next.cRv instanceof com.baidu.swan.pms.model.g) && next.edF == PMSPkgStatus.WAIT) {
                z = true;
                break;
            }
        }
        return z;
    }

    /* loaded from: classes15.dex */
    public static class a {
        private com.baidu.swan.pms.model.e cRv;
        private PMSPkgStatus edF;

        public a(com.baidu.swan.pms.model.e eVar, PMSPkgStatus pMSPkgStatus) {
            this.cRv = eVar;
            this.edF = pMSPkgStatus;
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            return this.cRv.equals(((a) obj).cRv);
        }

        public int hashCode() {
            return Objects.hash(this.cRv);
        }
    }
}
