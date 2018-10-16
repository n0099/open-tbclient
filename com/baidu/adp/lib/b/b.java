package com.baidu.adp.lib.b;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class b {
    private int Bl;
    private a Bo;
    private String mName;
    private int Bn = 0;
    private String[] Bq = null;
    private int Bm = 0;
    private String[] Br = null;
    private boolean Bs = false;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, int i, boolean z);
    }

    public b(String str, int i, a aVar) {
        this.mName = null;
        this.Bo = null;
        this.Bl = 0;
        if (str == null) {
            throw new InvalidParameterException("SwitchData name is null");
        }
        this.mName = str;
        this.Bo = aVar;
        this.Bl = i;
    }

    public void a(int i, String[] strArr, int i2) {
        this.Bn = i;
        this.Bq = strArr;
        this.Bm = i2;
    }

    public void K(boolean z) {
        this.Bs = z;
    }

    public boolean iN() {
        return this.Bs;
    }

    public void h(String[] strArr) {
        this.Br = strArr;
    }

    public String[] iL() {
        return this.Br;
    }

    public String getName() {
        return this.mName;
    }

    public int iK() {
        return this.Bn;
    }

    public String[] iO() {
        return this.Bq;
    }

    public int iJ() {
        return this.Bm;
    }

    public int iI() {
        return this.Bl;
    }

    public void f(int i, boolean z) {
        if (this.Bo != null) {
            this.Bo.a(this.mName, i, z);
        }
    }
}
