package com.baidu.swan.pms.b.d;
/* loaded from: classes2.dex */
public class a extends c {
    private String bmT;
    private String bmV;
    private String bmW;
    private String bmY;
    private String mPath;
    private int bmU = -1;
    private long bmX = -1;

    public a(String str, int i) {
        this.bmT = str;
        this.bna = i;
    }

    public a jq(String str) {
        this.bmW = str;
        return this;
    }

    public a jr(String str) {
        this.bmV = str;
        return this;
    }

    public a fh(int i) {
        this.bmU = i;
        return this;
    }

    public a U(long j) {
        this.bmX = j;
        return this;
    }

    public a js(String str) {
        this.bmY = str;
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
        return this.bmT;
    }

    public int Sd() {
        return this.bmU;
    }

    public long Se() {
        return this.bmX;
    }

    public String Sf() {
        return this.bmV;
    }

    public String Sg() {
        return this.bmW;
    }

    public String Sh() {
        return this.bmY;
    }

    public String getPath() {
        return this.mPath;
    }

    @Override // com.baidu.swan.pms.b.d.c
    public int Si() {
        return this.bna;
    }
}
