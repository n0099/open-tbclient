package com.baidu.swan.pms.utils;

import com.baidu.swan.pms.model.PMSPkgStatus;
import com.baidu.swan.pms.model.i;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
/* loaded from: classes14.dex */
public class f {
    private Set<a> dGZ = Collections.synchronizedSet(new HashSet());

    public void a(com.baidu.swan.pms.model.e eVar, PMSPkgStatus pMSPkgStatus) {
        this.dGZ.add(new a(eVar, pMSPkgStatus));
    }

    public int aUK() {
        return this.dGZ.size();
    }

    public boolean isEmpty() {
        return this.dGZ.isEmpty();
    }

    public boolean aUL() {
        for (a aVar : this.dGZ) {
            if (aVar != null && (aVar.cuP instanceof com.baidu.swan.pms.model.f)) {
                return true;
            }
        }
        return false;
    }

    public boolean aUM() {
        for (a aVar : this.dGZ) {
            if (aVar != null && (aVar.cuP instanceof com.baidu.swan.pms.model.g)) {
                return true;
            }
        }
        return false;
    }

    public boolean aUN() {
        for (a aVar : this.dGZ) {
            if (aVar != null && (aVar.cuP instanceof i)) {
                return true;
            }
        }
        return false;
    }

    public boolean aUO() {
        for (a aVar : this.dGZ) {
            if (aVar != null && (aVar.cuP instanceof com.baidu.swan.pms.model.d)) {
                return true;
            }
        }
        return false;
    }

    public boolean aUP() {
        for (a aVar : this.dGZ) {
            if (aVar != null && (aVar.cuP instanceof com.baidu.swan.pms.model.b)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0.dHa = com.baidu.swan.pms.model.PMSPkgStatus.ERROR;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void f(com.baidu.swan.pms.model.e eVar) {
        if (eVar != null) {
            Iterator<a> it = this.dGZ.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next != null && next.cuP.equals(eVar)) {
                    break;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0.dHa = com.baidu.swan.pms.model.PMSPkgStatus.FINISH;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void g(com.baidu.swan.pms.model.e eVar) {
        if (eVar != null) {
            Iterator<a> it = this.dGZ.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next != null && next.cuP.equals(eVar)) {
                    break;
                }
            }
        }
    }

    public synchronized boolean aUQ() {
        boolean z;
        Iterator<a> it = this.dGZ.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            a next = it.next();
            if (next != null && (next.cuP instanceof com.baidu.swan.pms.model.g) && next.dHa == PMSPkgStatus.WAIT) {
                z = true;
                break;
            }
        }
        return z;
    }

    /* loaded from: classes14.dex */
    public static class a {
        private com.baidu.swan.pms.model.e cuP;
        private PMSPkgStatus dHa;

        public a(com.baidu.swan.pms.model.e eVar, PMSPkgStatus pMSPkgStatus) {
            this.cuP = eVar;
            this.dHa = pMSPkgStatus;
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            return this.cuP.equals(((a) obj).cuP);
        }

        public int hashCode() {
            return Objects.hash(this.cuP);
        }
    }
}
