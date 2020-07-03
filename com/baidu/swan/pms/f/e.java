package com.baidu.swan.pms.f;

import com.baidu.swan.pms.model.PMSPkgStatus;
import com.baidu.swan.pms.model.g;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
/* loaded from: classes11.dex */
public class e {
    private Set<a> drZ = Collections.synchronizedSet(new HashSet());

    public void a(com.baidu.swan.pms.model.e eVar, PMSPkgStatus pMSPkgStatus) {
        this.drZ.add(new a(eVar, pMSPkgStatus));
    }

    public int aIt() {
        return this.drZ.size();
    }

    public boolean isEmpty() {
        return this.drZ.isEmpty();
    }

    public boolean aIu() {
        for (a aVar : this.drZ) {
            if (aVar != null && (aVar.cli instanceof com.baidu.swan.pms.model.f)) {
                return true;
            }
        }
        return false;
    }

    public boolean aIv() {
        for (a aVar : this.drZ) {
            if (aVar != null && (aVar.cli instanceof g)) {
                return true;
            }
        }
        return false;
    }

    public boolean aIw() {
        for (a aVar : this.drZ) {
            if (aVar != null && (aVar.cli instanceof com.baidu.swan.pms.model.d)) {
                return true;
            }
        }
        return false;
    }

    public boolean aIx() {
        for (a aVar : this.drZ) {
            if (aVar != null && (aVar.cli instanceof com.baidu.swan.pms.model.b)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0.dsa = com.baidu.swan.pms.model.PMSPkgStatus.ERROR;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void f(com.baidu.swan.pms.model.e eVar) {
        if (eVar != null) {
            Iterator<a> it = this.drZ.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next != null && next.cli.equals(eVar)) {
                    break;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0.dsa = com.baidu.swan.pms.model.PMSPkgStatus.FINISH;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void g(com.baidu.swan.pms.model.e eVar) {
        if (eVar != null) {
            Iterator<a> it = this.drZ.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next != null && next.cli.equals(eVar)) {
                    break;
                }
            }
        }
    }

    public synchronized boolean aIy() {
        boolean z;
        Iterator<a> it = this.drZ.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            a next = it.next();
            if (next != null && (next.cli instanceof g) && next.dsa == PMSPkgStatus.WAIT) {
                z = true;
                break;
            }
        }
        return z;
    }

    /* loaded from: classes11.dex */
    public static class a {
        private com.baidu.swan.pms.model.e cli;
        private PMSPkgStatus dsa;

        public a(com.baidu.swan.pms.model.e eVar, PMSPkgStatus pMSPkgStatus) {
            this.cli = eVar;
            this.dsa = pMSPkgStatus;
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            return this.cli.equals(((a) obj).cli);
        }

        public int hashCode() {
            return Objects.hash(this.cli);
        }
    }
}
