package com.baidu.swan.pms.utils;

import com.baidu.swan.pms.model.PMSPkgStatus;
import com.baidu.swan.pms.model.i;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
/* loaded from: classes3.dex */
public class f {
    private Set<a> evS = Collections.synchronizedSet(new HashSet());

    public void a(com.baidu.swan.pms.model.e eVar, PMSPkgStatus pMSPkgStatus) {
        this.evS.add(new a(eVar, pMSPkgStatus));
    }

    public int bdL() {
        return this.evS.size();
    }

    public boolean isEmpty() {
        return this.evS.isEmpty();
    }

    public boolean bdM() {
        for (a aVar : this.evS) {
            if (aVar != null && (aVar.deT instanceof com.baidu.swan.pms.model.f)) {
                return true;
            }
        }
        return false;
    }

    public boolean bdN() {
        for (a aVar : this.evS) {
            if (aVar != null && (aVar.deT instanceof com.baidu.swan.pms.model.g)) {
                return true;
            }
        }
        return false;
    }

    public boolean bdO() {
        for (a aVar : this.evS) {
            if (aVar != null && (aVar.deT instanceof i)) {
                return true;
            }
        }
        return false;
    }

    public boolean bdP() {
        for (a aVar : this.evS) {
            if (aVar != null && (aVar.deT instanceof com.baidu.swan.pms.model.d)) {
                return true;
            }
        }
        return false;
    }

    public boolean bdQ() {
        for (a aVar : this.evS) {
            if (aVar != null && (aVar.deT instanceof com.baidu.swan.pms.model.b)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0.evT = com.baidu.swan.pms.model.PMSPkgStatus.ERROR;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void f(com.baidu.swan.pms.model.e eVar) {
        if (eVar != null) {
            Iterator<a> it = this.evS.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next != null && next.deT.equals(eVar)) {
                    break;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0.evT = com.baidu.swan.pms.model.PMSPkgStatus.FINISH;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void g(com.baidu.swan.pms.model.e eVar) {
        if (eVar != null) {
            Iterator<a> it = this.evS.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next != null && next.deT.equals(eVar)) {
                    break;
                }
            }
        }
    }

    public synchronized boolean bdR() {
        boolean z;
        Iterator<a> it = this.evS.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            a next = it.next();
            if (next != null && (next.deT instanceof com.baidu.swan.pms.model.g) && next.evT == PMSPkgStatus.WAIT) {
                z = true;
                break;
            }
        }
        return z;
    }

    /* loaded from: classes3.dex */
    public static class a {
        private com.baidu.swan.pms.model.e deT;
        private PMSPkgStatus evT;

        public a(com.baidu.swan.pms.model.e eVar, PMSPkgStatus pMSPkgStatus) {
            this.deT = eVar;
            this.evT = pMSPkgStatus;
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            return this.deT.equals(((a) obj).deT);
        }

        public int hashCode() {
            return Objects.hash(this.deT);
        }
    }
}
