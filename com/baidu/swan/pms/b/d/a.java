package com.baidu.swan.pms.b.d;
/* loaded from: classes2.dex */
public class a extends c {
    private String bmP;
    private String bmR;
    private String bmS;
    private String bmU;
    private String mPath;
    private int bmQ = -1;
    private long bmT = -1;

    public a(String str, int i) {
        this.bmP = str;
        this.bmW = i;
    }

    public a jp(String str) {
        this.bmS = str;
        return this;
    }

    public a jq(String str) {
        this.bmR = str;
        return this;
    }

    public a fi(int i) {
        this.bmQ = i;
        return this;
    }

    public a U(long j) {
        this.bmT = j;
        return this;
    }

    public a jr(String str) {
        this.bmU = str;
        return this;
    }

    public a js(String str) {
        this.mPath = str;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.b.d.c
    /* renamed from: jt */
    public a ju(String str) {
        super.ju(str);
        return this;
    }

    public String getBundleId() {
        return this.bmP;
    }

    public int Sf() {
        return this.bmQ;
    }

    public long Sg() {
        return this.bmT;
    }

    public String Sh() {
        return this.bmR;
    }

    public String Si() {
        return this.bmS;
    }

    public String Sj() {
        return this.bmU;
    }

    public String getPath() {
        return this.mPath;
    }

    @Override // com.baidu.swan.pms.b.d.c
    public int Sk() {
        return this.bmW;
    }
}
