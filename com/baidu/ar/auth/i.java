package com.baidu.ar.auth;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class i {
    private volatile a jP = a.RUNNING;
    private volatile List<Integer> jQ;
    private String jR;

    /* loaded from: classes11.dex */
    public enum a {
        RUNNING,
        PASS,
        FAIL
    }

    public i(List<Integer> list) {
        this.jQ = list;
        ck();
    }

    public void Q(String str) {
        synchronized (this) {
            this.jP = a.FAIL;
            this.jR = str;
        }
        b(null);
    }

    public void b(Set<Integer> set) {
        synchronized (this) {
            if (this.jQ == null) {
                this.jQ = new ArrayList();
            }
            this.jQ.clear();
            if (set != null && !set.isEmpty()) {
                this.jQ.addAll(set);
            }
            ck();
        }
    }

    public void ci() {
        synchronized (this) {
            this.jP = a.PASS;
        }
    }

    public String cj() {
        return this.jR;
    }

    public final void ck() {
        if (this.jQ != null) {
            int[] iArr = new int[this.jQ.size()];
            int size = this.jQ.size();
            for (int i = 0; i < size; i++) {
                iArr[i] = this.jQ.get(i).intValue();
            }
            AuthJni.setGrantedFeatures(iArr);
        }
    }

    public List<Integer> cl() {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList();
            if (this.jQ != null) {
                arrayList.addAll(this.jQ);
            }
        }
        return arrayList;
    }

    public boolean isFailed() {
        return this.jP == a.FAIL;
    }

    public boolean isRunning() {
        return this.jP == a.RUNNING;
    }

    public boolean w(int i) {
        return (isFailed() || this.jQ == null || !this.jQ.contains(Integer.valueOf(i))) ? false : true;
    }
}
