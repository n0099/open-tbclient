package com.baidu.swan.pms.b.d;
/* loaded from: classes2.dex */
public class a extends c {
    private String bmS;
    private String bmU;
    private String bmV;
    private String bmX;
    private String mPath;
    private int bmT = -1;
    private long bmW = -1;

    public a(String str, int i) {
        this.bmS = str;
        this.bmZ = i;
    }

    public a jq(String str) {
        this.bmV = str;
        return this;
    }

    public a jr(String str) {
        this.bmU = str;
        return this;
    }

    public a fh(int i) {
        this.bmT = i;
        return this;
    }

    public a U(long j) {
        this.bmW = j;
        return this;
    }

    public a js(String str) {
        this.bmX = str;
        return this;
    }

    public a jt(String str) {
        this.mPath = str;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.b.d.c
    /* renamed from: ju */
    public a jv(String str) {
        super.jv(str);
        return this;
    }

    public String getBundleId() {
        return this.bmS;
    }

    public int Sd() {
        return this.bmT;
    }

    public long Se() {
        return this.bmW;
    }

    public String Sf() {
        return this.bmU;
    }

    public String Sg() {
        return this.bmV;
    }

    public String Sh() {
        return this.bmX;
    }

    public String getPath() {
        return this.mPath;
    }

    @Override // com.baidu.swan.pms.b.d.c
    public int Si() {
        return this.bmZ;
    }
}
