package com.baidu.ar.logo;
/* loaded from: classes3.dex */
public class RecognitionRes {
    private String a;
    private String b;
    private int c;
    private double d;
    private b e;

    public String getCode() {
        return this.b;
    }

    public b getImageLocation() {
        return this.e;
    }

    public String getName() {
        return this.a;
    }

    public double getProbability() {
        return this.d;
    }

    public int getType() {
        return this.c;
    }

    public void setCode(String str) {
        this.b = str;
    }

    public void setImageLocation(b bVar) {
        this.e = bVar;
    }

    public void setName(String str) {
        this.a = str;
    }

    public void setProbability(double d) {
        this.d = d;
    }

    public void setType(int i) {
        this.c = i;
    }
}
