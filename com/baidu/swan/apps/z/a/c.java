package com.baidu.swan.apps.z.a;
/* loaded from: classes7.dex */
public class c {
    protected boolean cvK;
    protected int cwv;
    protected String cww;
    protected long cwx;

    public c(int i) {
        this(i, null);
    }

    public c(int i, String str) {
        this.cvK = false;
        this.cwv = i;
        this.cww = str;
    }

    public c(int i, String str, long j) {
        this.cvK = false;
        this.cwv = i;
        this.cww = str;
        this.cwx = j;
    }

    public c(int i, String str, long j, boolean z) {
        this.cvK = false;
        this.cwv = i;
        this.cww = str;
        this.cwx = j;
        this.cvK = z;
    }

    public int getId() {
        return this.cwv;
    }

    public String amP() {
        return this.cww;
    }

    public long amQ() {
        return this.cwx;
    }

    public boolean amR() {
        return this.cvK;
    }
}
