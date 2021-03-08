package com.baidu.ar.auth;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class i {
    private volatile a jV = a.RUNNING;
    private volatile List<Integer> jW;
    private String jX;

    /* loaded from: classes3.dex */
    public enum a {
        RUNNING,
        PASS,
        FAIL
    }

    public i(List<Integer> list) {
        this.jW = list;
        cC();
    }

    public void U(String str) {
        synchronized (this) {
            this.jV = a.FAIL;
            this.jX = str;
        }
        b(null);
    }

    public void b(Set<Integer> set) {
        synchronized (this) {
            if (this.jW == null) {
                this.jW = new ArrayList();
            }
            this.jW.clear();
            if (set != null && !set.isEmpty()) {
                this.jW.addAll(set);
            }
            cC();
        }
    }

    public void cA() {
        synchronized (this) {
            this.jV = a.PASS;
        }
    }

    public String cB() {
        return this.jX;
    }

    public final void cC() {
        if (this.jW != null) {
            int[] iArr = new int[this.jW.size()];
            int size = this.jW.size();
            for (int i = 0; i < size; i++) {
                iArr[i] = this.jW.get(i).intValue();
            }
            AuthJni.setGrantedFeatures(iArr);
        }
    }

    public List<Integer> cD() {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList();
            if (this.jW != null) {
                arrayList.addAll(this.jW);
            }
        }
        return arrayList;
    }

    public boolean isFailed() {
        return this.jV == a.FAIL;
    }

    public boolean isRunning() {
        return this.jV == a.RUNNING;
    }

    public boolean v(int i) {
        return (isFailed() || this.jW == null || !this.jW.contains(Integer.valueOf(i))) ? false : true;
    }
}
