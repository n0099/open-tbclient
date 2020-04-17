package com.baidu.ar.arrender;
/* loaded from: classes3.dex */
public class h extends com.baidu.ar.ability.c {
    private String hW;
    private String hX;
    private Object hY;
    private a hZ;

    /* loaded from: classes3.dex */
    public enum a {
        INT,
        FLOAT,
        FLOAT_ARRAY,
        STRING
    }

    public void K(String str) {
        this.hX = str;
    }

    public void L(String str) {
        this.hY = str;
        this.hZ = a.STRING;
    }

    public void b(float f) {
        this.hY = Float.valueOf(f);
        this.hZ = a.FLOAT;
    }

    public void b(float[] fArr) {
        this.hY = fArr;
        this.hZ = a.FLOAT_ARRAY;
    }

    public String br() {
        return this.hX;
    }

    public Object bs() {
        return this.hY;
    }

    public a bt() {
        return this.hZ;
    }

    public String getFilterName() {
        return this.hW;
    }

    public void q(int i) {
        this.hY = Integer.valueOf(i);
        this.hZ = a.INT;
    }

    public void setFilterName(String str) {
        this.hW = str;
    }
}
