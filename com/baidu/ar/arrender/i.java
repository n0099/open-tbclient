package com.baidu.ar.arrender;
/* loaded from: classes3.dex */
public class i extends com.baidu.ar.ability.c {
    private String hS;
    private String hT;
    private Object hU;
    private a hV;

    /* loaded from: classes3.dex */
    public enum a {
        INT,
        FLOAT,
        FLOAT_ARRAY,
        STRING
    }

    public void N(String str) {
        this.hT = str;
    }

    public void O(String str) {
        this.hU = str;
        this.hV = a.STRING;
    }

    public void a(float f) {
        this.hU = Float.valueOf(f);
        this.hV = a.FLOAT;
    }

    public void a(float[] fArr) {
        this.hU = fArr;
        this.hV = a.FLOAT_ARRAY;
    }

    public String bQ() {
        return this.hT;
    }

    public Object bR() {
        return this.hU;
    }

    public a bS() {
        return this.hV;
    }

    public String getFilterName() {
        return this.hS;
    }

    public void r(int i) {
        this.hU = Integer.valueOf(i);
        this.hV = a.INT;
    }

    public void setFilterName(String str) {
        this.hS = str;
    }
}
