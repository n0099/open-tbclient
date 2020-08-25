package com.baidu.ar.arrender;
/* loaded from: classes11.dex */
public class h extends com.baidu.ar.ability.c {
    private String hE;
    private String hF;
    private Object hG;
    private a hH;

    /* loaded from: classes11.dex */
    public enum a {
        INT,
        FLOAT,
        FLOAT_ARRAY,
        STRING
    }

    public void K(String str) {
        this.hF = str;
    }

    public void L(String str) {
        this.hG = str;
        this.hH = a.STRING;
    }

    public void b(float f) {
        this.hG = Float.valueOf(f);
        this.hH = a.FLOAT;
    }

    public void b(float[] fArr) {
        this.hG = fArr;
        this.hH = a.FLOAT_ARRAY;
    }

    public String bR() {
        return this.hF;
    }

    public Object bS() {
        return this.hG;
    }

    public a bT() {
        return this.hH;
    }

    public String getFilterName() {
        return this.hE;
    }

    public void p(int i) {
        this.hG = Integer.valueOf(i);
        this.hH = a.INT;
    }

    public void setFilterName(String str) {
        this.hE = str;
    }
}
