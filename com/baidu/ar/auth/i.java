package com.baidu.ar.auth;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class i {
    private volatile a jx = a.RUNNING;
    private volatile List<Integer> jy;
    private String jz;

    /* loaded from: classes3.dex */
    public enum a {
        RUNNING,
        PASS,
        FAIL
    }

    public i(List<Integer> list) {
        this.jy = list;
        bU();
    }

    private void bU() {
        if (this.jy != null) {
            int[] iArr = new int[this.jy.size()];
            int size = this.jy.size();
            for (int i = 0; i < size; i++) {
                iArr[i] = this.jy.get(i).intValue();
            }
            AuthJni.setGrantedFeatures(iArr);
        }
    }

    public void Q(String str) {
        synchronized (this) {
            this.jx = a.FAIL;
            this.jz = str;
        }
        b(null);
    }

    public void b(Set<Integer> set) {
        synchronized (this) {
            if (this.jy == null) {
                this.jy = new ArrayList();
            }
            this.jy.clear();
            if (set != null && !set.isEmpty()) {
                this.jy.addAll(set);
            }
            bU();
        }
    }

    public void bS() {
        synchronized (this) {
            this.jx = a.PASS;
        }
    }

    public String bT() {
        return this.jz;
    }

    public List<Integer> bV() {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList();
            if (this.jy != null) {
                arrayList.addAll(this.jy);
            }
        }
        return arrayList;
    }

    public boolean isFailed() {
        return this.jx == a.FAIL;
    }

    public boolean isRunning() {
        return this.jx == a.RUNNING;
    }

    public boolean u(int i) {
        return (isFailed() || this.jy == null || !this.jy.contains(Integer.valueOf(i))) ? false : true;
    }
}
