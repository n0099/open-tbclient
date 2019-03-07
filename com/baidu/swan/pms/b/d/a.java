package com.baidu.swan.pms.b.d;
/* loaded from: classes2.dex */
public class a extends c {
    private String bmO;
    private String bmQ;
    private String bmR;
    private String bmT;
    private String mPath;
    private int bmP = -1;
    private long bmS = -1;

    public a(String str, int i) {
        this.bmO = str;
        this.bmV = i;
    }

    public a jp(String str) {
        this.bmR = str;
        return this;
    }

    public a jq(String str) {
        this.bmQ = str;
        return this;
    }

    public a fi(int i) {
        this.bmP = i;
        return this;
    }

    public a U(long j) {
        this.bmS = j;
        return this;
    }

    public a jr(String str) {
        this.bmT = str;
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
        return this.bmO;
    }

    public int Sf() {
        return this.bmP;
    }

    public long Sg() {
        return this.bmS;
    }

    public String Sh() {
        return this.bmQ;
    }

    public String Si() {
        return this.bmR;
    }

    public String Sj() {
        return this.bmT;
    }

    public String getPath() {
        return this.mPath;
    }

    @Override // com.baidu.swan.pms.b.d.c
    public int Sk() {
        return this.bmV;
    }
}
