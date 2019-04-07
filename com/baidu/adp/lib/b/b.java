package com.baidu.adp.lib.b;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class b {
    private int Bm;
    private a Bp;
    private String mName;
    private int Bo = 0;
    private String[] Br = null;
    private int Bn = 0;
    private String[] Bs = null;
    private boolean Bt = false;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, int i, boolean z);
    }

    public b(String str, int i, a aVar) {
        this.mName = null;
        this.Bp = null;
        this.Bm = 0;
        if (str == null) {
            throw new InvalidParameterException("SwitchData name is null");
        }
        this.mName = str;
        this.Bp = aVar;
        this.Bm = i;
    }

    public void a(int i, String[] strArr, int i2) {
        this.Bo = i;
        this.Br = strArr;
        this.Bn = i2;
    }

    public void Y(boolean z) {
        this.Bt = z;
    }

    public boolean iM() {
        return this.Bt;
    }

    public void h(String[] strArr) {
        this.Bs = strArr;
    }

    public String[] iK() {
        return this.Bs;
    }

    public String getName() {
        return this.mName;
    }

    public int iJ() {
        return this.Bo;
    }

    public String[] iN() {
        return this.Br;
    }

    public int iI() {
        return this.Bn;
    }

    public int iH() {
        return this.Bm;
    }

    public void f(int i, boolean z) {
        if (this.Bp != null) {
            this.Bp.a(this.mName, i, z);
        }
    }
}
