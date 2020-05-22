package com.baidu.swan.apps.aa.a;
/* loaded from: classes11.dex */
public class c {
    protected boolean coU;
    protected int cpF;
    protected String cpG;
    protected long cpH;

    public c(int i) {
        this(i, null);
    }

    public c(int i, String str) {
        this.coU = false;
        this.cpF = i;
        this.cpG = str;
    }

    public c(int i, String str, long j) {
        this.coU = false;
        this.cpF = i;
        this.cpG = str;
        this.cpH = j;
    }

    public c(int i, String str, long j, boolean z) {
        this.coU = false;
        this.cpF = i;
        this.cpG = str;
        this.cpH = j;
        this.coU = z;
    }

    public int getId() {
        return this.cpF;
    }

    public String aks() {
        return this.cpG;
    }

    public long akt() {
        return this.cpH;
    }

    public boolean aku() {
        return this.coU;
    }
}
