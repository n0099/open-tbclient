package com.baidu.swan.pms.utils;

import com.baidu.swan.pms.model.PMSPkgStatus;
import com.baidu.swan.pms.model.i;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
/* loaded from: classes6.dex */
public class f {
    private Set<a> eoR = Collections.synchronizedSet(new HashSet());

    public void a(com.baidu.swan.pms.model.e eVar, PMSPkgStatus pMSPkgStatus) {
        this.eoR.add(new a(eVar, pMSPkgStatus));
    }

    public int beW() {
        return this.eoR.size();
    }

    public boolean isEmpty() {
        return this.eoR.isEmpty();
    }

    public boolean beX() {
        for (a aVar : this.eoR) {
            if (aVar != null && (aVar.dcB instanceof com.baidu.swan.pms.model.f)) {
                return true;
            }
        }
        return false;
    }

    public boolean beY() {
        for (a aVar : this.eoR) {
            if (aVar != null && (aVar.dcB instanceof com.baidu.swan.pms.model.g)) {
                return true;
            }
        }
        return false;
    }

    public boolean beZ() {
        for (a aVar : this.eoR) {
            if (aVar != null && (aVar.dcB instanceof i)) {
                return true;
            }
        }
        return false;
    }

    public boolean bfa() {
        for (a aVar : this.eoR) {
            if (aVar != null && (aVar.dcB instanceof com.baidu.swan.pms.model.d)) {
                return true;
            }
        }
        return false;
    }

    public boolean bfb() {
        for (a aVar : this.eoR) {
            if (aVar != null && (aVar.dcB instanceof com.baidu.swan.pms.model.b)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0.eoS = com.baidu.swan.pms.model.PMSPkgStatus.ERROR;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void f(com.baidu.swan.pms.model.e eVar) {
        if (eVar != null) {
            Iterator<a> it = this.eoR.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next != null && next.dcB.equals(eVar)) {
                    break;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0.eoS = com.baidu.swan.pms.model.PMSPkgStatus.FINISH;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void g(com.baidu.swan.pms.model.e eVar) {
        if (eVar != null) {
            Iterator<a> it = this.eoR.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next != null && next.dcB.equals(eVar)) {
                    break;
                }
            }
        }
    }

    public synchronized boolean bfc() {
        boolean z;
        Iterator<a> it = this.eoR.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            a next = it.next();
            if (next != null && (next.dcB instanceof com.baidu.swan.pms.model.g) && next.eoS == PMSPkgStatus.WAIT) {
                z = true;
                break;
            }
        }
        return z;
    }

    /* loaded from: classes6.dex */
    public static class a {
        private com.baidu.swan.pms.model.e dcB;
        private PMSPkgStatus eoS;

        public a(com.baidu.swan.pms.model.e eVar, PMSPkgStatus pMSPkgStatus) {
            this.dcB = eVar;
            this.eoS = pMSPkgStatus;
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            return this.dcB.equals(((a) obj).dcB);
        }

        public int hashCode() {
            return Objects.hash(this.dcB);
        }
    }
}
