package com.baidu.ar.arrender;
/* loaded from: classes11.dex */
public class h extends com.baidu.ar.ability.c {
    private String im;
    private String in;

    /* renamed from: io  reason: collision with root package name */
    private Object f962io;
    private a ip;

    /* loaded from: classes11.dex */
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
        this.f962io = str;
        this.ip = a.STRING;
    }

    public void b(float f) {
        this.f962io = Float.valueOf(f);
        this.ip = a.FLOAT;
    }

    public void b(float[] fArr) {
        this.f962io = fArr;
        this.ip = a.FLOAT_ARRAY;
    }

    public String bG() {
        return this.in;
    }

    public Object bH() {
        return this.f962io;
    }

    public a bI() {
        return this.ip;
    }

    public String getFilterName() {
        return this.im;
    }

    public void s(int i) {
        this.f962io = Integer.valueOf(i);
        this.ip = a.INT;
    }

    public void setFilterName(String str) {
        this.im = str;
    }
}
