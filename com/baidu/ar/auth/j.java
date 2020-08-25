package com.baidu.ar.auth;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class j {
    private volatile a jG = a.RUNNING;
    private volatile List<Integer> jH;
    private String jI;

    /* loaded from: classes11.dex */
    public enum a {
        RUNNING,
        PASS,
        FAIL
    }

    public j(List<Integer> list) {
        this.jH = list;
        cD();
    }

    public void R(String str) {
        synchronized (this) {
            this.jG = a.FAIL;
            this.jI = str;
        }
        b(null);
    }

    public void b(Set<Integer> set) {
        synchronized (this) {
            if (this.jH == null) {
                this.jH = new ArrayList();
            }
            this.jH.clear();
            if (set != null && !set.isEmpty()) {
                this.jH.addAll(set);
            }
            cD();
        }
    }

    public void cB() {
        synchronized (this) {
            this.jG = a.PASS;
        }
    }

    public String cC() {
        return this.jI;
    }

    public final void cD() {
        if (this.jH != null) {
            int[] iArr = new int[this.jH.size()];
            int size = this.jH.size();
            for (int i = 0; i < size; i++) {
                iArr[i] = this.jH.get(i).intValue();
            }
            AuthJni.setGrantedFeatures(iArr);
        }
    }

    public List<Integer> cE() {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList();
            if (this.jH != null) {
                arrayList.addAll(this.jH);
            }
        }
        return arrayList;
    }

    public boolean isFailed() {
        return this.jG == a.FAIL;
    }

    public boolean isRunning() {
        return this.jG == a.RUNNING;
    }

    public boolean t(int i) {
        return (isFailed() || this.jH == null || !this.jH.contains(Integer.valueOf(i))) ? false : true;
    }
}
