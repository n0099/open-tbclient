package com.baidu.swan.pms.e;

import com.baidu.swan.pms.model.PMSPkgStatus;
import com.baidu.swan.pms.model.h;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
/* loaded from: classes2.dex */
public class e {
    private Set<a> bur = Collections.synchronizedSet(new HashSet());

    public void a(com.baidu.swan.pms.model.e eVar, PMSPkgStatus pMSPkgStatus) {
        this.bur.add(new a(eVar, pMSPkgStatus));
    }

    public int WY() {
        return this.bur.size();
    }

    public boolean isEmpty() {
        return this.bur.isEmpty();
    }

    public boolean WZ() {
        for (a aVar : this.bur) {
            if (aVar != null && (aVar.ayP instanceof com.baidu.swan.pms.model.f)) {
                return true;
            }
        }
        return false;
    }

    public boolean Xa() {
        for (a aVar : this.bur) {
            if (aVar != null && (aVar.ayP instanceof h)) {
                return true;
            }
        }
        return false;
    }

    public boolean Xb() {
        for (a aVar : this.bur) {
            if (aVar != null && (aVar.ayP instanceof com.baidu.swan.pms.model.d)) {
                return true;
            }
        }
        return false;
    }

    public boolean Xc() {
        for (a aVar : this.bur) {
            if (aVar != null && (aVar.ayP instanceof com.baidu.swan.pms.model.b)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0.bus = com.baidu.swan.pms.model.PMSPkgStatus.ERROR;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void h(com.baidu.swan.pms.model.e eVar) {
        if (eVar != null) {
            Iterator<a> it = this.bur.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next != null && next.ayP.equals(eVar)) {
                    break;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0.bus = com.baidu.swan.pms.model.PMSPkgStatus.FINISH;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void i(com.baidu.swan.pms.model.e eVar) {
        if (eVar != null) {
            Iterator<a> it = this.bur.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next != null && next.ayP.equals(eVar)) {
                    break;
                }
            }
        }
    }

    public synchronized boolean Xd() {
        boolean z;
        Iterator<a> it = this.bur.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            a next = it.next();
            if (next != null && (next.ayP instanceof h) && next.bus == PMSPkgStatus.WAIT) {
                z = true;
                break;
            }
        }
        return z;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private com.baidu.swan.pms.model.e ayP;
        private PMSPkgStatus bus;

        public a(com.baidu.swan.pms.model.e eVar, PMSPkgStatus pMSPkgStatus) {
            this.ayP = eVar;
            this.bus = pMSPkgStatus;
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            return this.ayP.equals(((a) obj).ayP);
        }

        public int hashCode() {
            return Objects.hash(this.ayP);
        }
    }
}
