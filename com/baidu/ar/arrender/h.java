package com.baidu.ar.arrender;
/* loaded from: classes3.dex */
public class h extends com.baidu.ar.ability.c {
    private String im;
    private String in;

    /* renamed from: io  reason: collision with root package name */
    private Object f980io;
    private a ip;

    /* loaded from: classes3.dex */
    public enum a {
        INT,
        FLOAT,
        FLOAT_ARRAY,
        STRING
    }

    public void K(String str) {
        this.in = str;
    }

    public void L(String str) {
        this.f980io = str;
        this.ip = a.STRING;
    }

    public void b(float f) {
        this.f980io = Float.valueOf(f);
        this.ip = a.FLOAT;
    }

    public void b(float[] fArr) {
        this.f980io = fArr;
        this.ip = a.FLOAT_ARRAY;
    }

    public String bG() {
        return this.in;
    }

    public Object bH() {
        return this.f980io;
    }

    public a bI() {
        return this.ip;
    }

    public String getFilterName() {
        return this.im;
    }

    public void s(int i) {
        this.f980io = Integer.valueOf(i);
        this.ip = a.INT;
    }

    public void setFilterName(String str) {
        this.im = str;
    }
}
