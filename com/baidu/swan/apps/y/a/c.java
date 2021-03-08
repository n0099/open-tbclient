package com.baidu.swan.apps.y.a;
/* loaded from: classes8.dex */
public class c {
    protected boolean dpt;
    protected int dqf;
    protected String dqg;
    protected long dqh;

    public c(int i) {
        this(i, null);
    }

    public c(int i, String str) {
        this.dpt = false;
        this.dqf = i;
        this.dqg = str;
    }

    public c(int i, String str, long j) {
        this.dpt = false;
        this.dqf = i;
        this.dqg = str;
        this.dqh = j;
    }

    public c(int i, String str, long j, boolean z) {
        this.dpt = false;
        this.dqf = i;
        this.dqg = str;
        this.dqh = j;
        this.dpt = z;
    }

    public int getId() {
        return this.dqf;
    }

    public String aDb() {
        return this.dqg;
    }

    public long aDc() {
        return this.dqh;
    }

    public boolean aDd() {
        return this.dpt;
    }
}
