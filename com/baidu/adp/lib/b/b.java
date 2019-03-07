package com.baidu.adp.lib.b;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class b {
    private int Bn;
    private a Bq;
    private String mName;
    private int Bp = 0;
    private String[] Bs = null;
    private int Bo = 0;
    private String[] Bt = null;
    private boolean Bu = false;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, int i, boolean z);
    }

    public b(String str, int i, a aVar) {
        this.mName = null;
        this.Bq = null;
        this.Bn = 0;
        if (str == null) {
            throw new InvalidParameterException("SwitchData name is null");
        }
        this.mName = str;
        this.Bq = aVar;
        this.Bn = i;
    }

    public void a(int i, String[] strArr, int i2) {
        this.Bp = i;
        this.Bs = strArr;
        this.Bo = i2;
    }

    public void Y(boolean z) {
        this.Bu = z;
    }

    public boolean iM() {
        return this.Bu;
    }

    public void h(String[] strArr) {
        this.Bt = strArr;
    }

    public String[] iK() {
        return this.Bt;
    }

    public String getName() {
        return this.mName;
    }

    public int iJ() {
        return this.Bp;
    }

    public String[] iN() {
        return this.Bs;
    }

    public int iI() {
        return this.Bo;
    }

    public int iH() {
        return this.Bn;
    }

    public void f(int i, boolean z) {
        if (this.Bq != null) {
            this.Bq.a(this.mName, i, z);
        }
    }
}
