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
    private Set<a> cCj = Collections.synchronizedSet(new HashSet());

    public void a(com.baidu.swan.pms.model.e eVar, PMSPkgStatus pMSPkgStatus) {
        this.cCj.add(new a(eVar, pMSPkgStatus));
    }

    public int aut() {
        return this.cCj.size();
    }

    public boolean isEmpty() {
        return this.cCj.isEmpty();
    }

    public boolean auu() {
        for (a aVar : this.cCj) {
            if (aVar != null && (aVar.bxC instanceof com.baidu.swan.pms.model.f)) {
                return true;
            }
        }
        return false;
    }

    public boolean auv() {
        for (a aVar : this.cCj) {
            if (aVar != null && (aVar.bxC instanceof g)) {
                return true;
            }
        }
        return false;
    }

    public boolean auw() {
        for (a aVar : this.cCj) {
            if (aVar != null && (aVar.bxC instanceof com.baidu.swan.pms.model.d)) {
                return true;
            }
        }
        return false;
    }

    public boolean aux() {
        for (a aVar : this.cCj) {
            if (aVar != null && (aVar.bxC instanceof com.baidu.swan.pms.model.b)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0.cCk = com.baidu.swan.pms.model.PMSPkgStatus.ERROR;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void f(com.baidu.swan.pms.model.e eVar) {
        if (eVar != null) {
            Iterator<a> it = this.cCj.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next != null && next.bxC.equals(eVar)) {
                    break;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0.cCk = com.baidu.swan.pms.model.PMSPkgStatus.FINISH;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void g(com.baidu.swan.pms.model.e eVar) {
        if (eVar != null) {
            Iterator<a> it = this.cCj.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next != null && next.bxC.equals(eVar)) {
                    break;
                }
            }
        }
    }

    public synchronized boolean auy() {
        boolean z;
        Iterator<a> it = this.cCj.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            a next = it.next();
            if (next != null && (next.bxC instanceof g) && next.cCk == PMSPkgStatus.WAIT) {
                z = true;
                break;
            }
        }
        return z;
    }

    /* loaded from: classes11.dex */
    public static class a {
        private com.baidu.swan.pms.model.e bxC;
        private PMSPkgStatus cCk;

        public a(com.baidu.swan.pms.model.e eVar, PMSPkgStatus pMSPkgStatus) {
            this.bxC = eVar;
            this.cCk = pMSPkgStatus;
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            return this.bxC.equals(((a) obj).bxC);
        }

        public int hashCode() {
            return Objects.hash(this.bxC);
        }
    }
}
