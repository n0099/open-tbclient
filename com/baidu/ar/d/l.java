package com.baidu.ar.d;
/* loaded from: classes.dex */
public class l {
    public String J;
    public int nn;
    public boolean no;

    public l(String str, boolean z) {
        this.nn = -1;
        this.J = str;
        this.no = z;
    }

    public l(String str, boolean z, int i) {
        this.nn = -1;
        this.J = str;
        this.no = z;
        this.nn = i;
    }

    public String dc() {
        return this.J;
    }

    public int dk() {
        return this.nn;
    }

    public boolean isSuccess() {
        return this.no;
    }
}
