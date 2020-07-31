package com.baidu.swan.pms.f;

import com.baidu.swan.pms.model.PMSPkgStatus;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
/* loaded from: classes19.dex */
public class f {
    private Set<a> dxQ = Collections.synchronizedSet(new HashSet());

    public void a(com.baidu.swan.pms.model.e eVar, PMSPkgStatus pMSPkgStatus) {
        this.dxQ.add(new a(eVar, pMSPkgStatus));
    }

    public int aMl() {
        return this.dxQ.size();
    }

    public boolean isEmpty() {
        return this.dxQ.isEmpty();
    }

    public boolean aMm() {
        for (a aVar : this.dxQ) {
            if (aVar != null && (aVar.cnm instanceof com.baidu.swan.pms.model.f)) {
                return true;
            }
        }
        return false;
    }

    public boolean aMn() {
        for (a aVar : this.dxQ) {
            if (aVar != null && (aVar.cnm instanceof com.baidu.swan.pms.model.g)) {
                return true;
            }
        }
        return false;
    }

    public boolean aMo() {
        for (a aVar : this.dxQ) {
            if (aVar != null && (aVar.cnm instanceof com.baidu.swan.pms.model.d)) {
                return true;
            }
        }
        return false;
    }

    public boolean aMp() {
        for (a aVar : this.dxQ) {
            if (aVar != null && (aVar.cnm instanceof com.baidu.swan.pms.model.b)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0.dxR = com.baidu.swan.pms.model.PMSPkgStatus.ERROR;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void f(com.baidu.swan.pms.model.e eVar) {
        if (eVar != null) {
            Iterator<a> it = this.dxQ.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next != null && next.cnm.equals(eVar)) {
                    break;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0.dxR = com.baidu.swan.pms.model.PMSPkgStatus.FINISH;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void g(com.baidu.swan.pms.model.e eVar) {
        if (eVar != null) {
            Iterator<a> it = this.dxQ.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next != null && next.cnm.equals(eVar)) {
                    break;
                }
            }
        }
    }

    public synchronized boolean aMq() {
        boolean z;
        Iterator<a> it = this.dxQ.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            a next = it.next();
            if (next != null && (next.cnm instanceof com.baidu.swan.pms.model.g) && next.dxR == PMSPkgStatus.WAIT) {
                z = true;
                break;
            }
        }
        return z;
    }

    /* loaded from: classes19.dex */
    public static class a {
        private com.baidu.swan.pms.model.e cnm;
        private PMSPkgStatus dxR;

        public a(com.baidu.swan.pms.model.e eVar, PMSPkgStatus pMSPkgStatus) {
            this.cnm = eVar;
            this.dxR = pMSPkgStatus;
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            return this.cnm.equals(((a) obj).cnm);
        }

        public int hashCode() {
            return Objects.hash(this.cnm);
        }
    }
}
