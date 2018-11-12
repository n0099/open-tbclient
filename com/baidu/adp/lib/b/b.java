package com.baidu.adp.lib.b;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class b {
    private int Bo;
    private a Br;
    private String mName;
    private int Bq = 0;
    private String[] Bt = null;
    private int Bp = 0;
    private String[] Bu = null;
    private boolean Bv = false;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, int i, boolean z);
    }

    public b(String str, int i, a aVar) {
        this.mName = null;
        this.Br = null;
        this.Bo = 0;
        if (str == null) {
            throw new InvalidParameterException("SwitchData name is null");
        }
        this.mName = str;
        this.Br = aVar;
        this.Bo = i;
    }

    public void a(int i, String[] strArr, int i2) {
        this.Bq = i;
        this.Bt = strArr;
        this.Bp = i2;
    }

    public void Y(boolean z) {
        this.Bv = z;
    }

    public boolean iM() {
        return this.Bv;
    }

    public void h(String[] strArr) {
        this.Bu = strArr;
    }

    public String[] iK() {
        return this.Bu;
    }

    public String getName() {
        return this.mName;
    }

    public int iJ() {
        return this.Bq;
    }

    public String[] iN() {
        return this.Bt;
    }

    public int iI() {
        return this.Bp;
    }

    public int iH() {
        return this.Bo;
    }

    public void f(int i, boolean z) {
        if (this.Br != null) {
            this.Br.a(this.mName, i, z);
        }
    }
}
