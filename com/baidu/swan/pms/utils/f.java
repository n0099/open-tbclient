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
    private Set<a> eyB = Collections.synchronizedSet(new HashSet());

    public void a(com.baidu.swan.pms.model.e eVar, PMSPkgStatus pMSPkgStatus) {
        this.eyB.add(new a(eVar, pMSPkgStatus));
    }

    public int bhr() {
        return this.eyB.size();
    }

    public boolean isEmpty() {
        return this.eyB.isEmpty();
    }

    public boolean bhs() {
        for (a aVar : this.eyB) {
            if (aVar != null && (aVar.dhu instanceof com.baidu.swan.pms.model.f)) {
                return true;
            }
        }
        return false;
    }

    public boolean bht() {
        for (a aVar : this.eyB) {
            if (aVar != null && (aVar.dhu instanceof com.baidu.swan.pms.model.g)) {
                return true;
            }
        }
        return false;
    }

    public boolean bhu() {
        for (a aVar : this.eyB) {
            if (aVar != null && (aVar.dhu instanceof i)) {
                return true;
            }
        }
        return false;
    }

    public boolean bhv() {
        for (a aVar : this.eyB) {
            if (aVar != null && (aVar.dhu instanceof com.baidu.swan.pms.model.d)) {
                return true;
            }
        }
        return false;
    }

    public boolean bhw() {
        for (a aVar : this.eyB) {
            if (aVar != null && (aVar.dhu instanceof com.baidu.swan.pms.model.b)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0.eyC = com.baidu.swan.pms.model.PMSPkgStatus.ERROR;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void f(com.baidu.swan.pms.model.e eVar) {
        if (eVar != null) {
            Iterator<a> it = this.eyB.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next != null && next.dhu.equals(eVar)) {
                    break;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0.eyC = com.baidu.swan.pms.model.PMSPkgStatus.FINISH;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void g(com.baidu.swan.pms.model.e eVar) {
        if (eVar != null) {
            Iterator<a> it = this.eyB.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next != null && next.dhu.equals(eVar)) {
                    break;
                }
            }
        }
    }

    public synchronized boolean bhx() {
        boolean z;
        Iterator<a> it = this.eyB.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            a next = it.next();
            if (next != null && (next.dhu instanceof com.baidu.swan.pms.model.g) && next.eyC == PMSPkgStatus.WAIT) {
                z = true;
                break;
            }
        }
        return z;
    }

    /* loaded from: classes6.dex */
    public static class a {
        private com.baidu.swan.pms.model.e dhu;
        private PMSPkgStatus eyC;

        public a(com.baidu.swan.pms.model.e eVar, PMSPkgStatus pMSPkgStatus) {
            this.dhu = eVar;
            this.eyC = pMSPkgStatus;
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            return this.dhu.equals(((a) obj).dhu);
        }

        public int hashCode() {
            return Objects.hash(this.dhu);
        }
    }
}
