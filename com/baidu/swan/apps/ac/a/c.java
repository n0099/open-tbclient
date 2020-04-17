package com.baidu.swan.apps.ac.a;
/* loaded from: classes11.dex */
public class c {
    protected int ceR;
    protected String ceS;
    protected long ceT;
    protected boolean ceh;

    public c(int i) {
        this(i, null);
    }

    public c(int i, String str) {
        this.ceh = false;
        this.ceR = i;
        this.ceS = str;
    }

    public c(int i, String str, long j) {
        this.ceh = false;
        this.ceR = i;
        this.ceS = str;
        this.ceT = j;
    }

    public c(int i, String str, long j, boolean z) {
        this.ceh = false;
        this.ceR = i;
        this.ceS = str;
        this.ceT = j;
        this.ceh = z;
    }

    public int getId() {
        return this.ceR;
    }

    public String aha() {
        return this.ceS;
    }

    public long ahb() {
        return this.ceT;
    }

    public boolean ahc() {
        return this.ceh;
    }
}
