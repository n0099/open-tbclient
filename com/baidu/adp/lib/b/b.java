package com.baidu.adp.lib.b;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class b {
    private String mName;
    private int nG;
    private a nJ;
    private int nI = 0;
    private String[] nL = null;
    private int nH = 0;
    private String[] nM = null;
    private boolean nN = false;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, int i, boolean z);
    }

    public b(String str, int i, a aVar) {
        this.mName = null;
        this.nJ = null;
        this.nG = 0;
        if (str == null) {
            throw new InvalidParameterException("SwitchData name is null");
        }
        this.mName = str;
        this.nJ = aVar;
        this.nG = i;
    }

    public void a(int i, String[] strArr, int i2) {
        this.nI = i;
        this.nL = strArr;
        this.nH = i2;
    }

    public void z(boolean z) {
        this.nN = z;
    }

    public boolean fo() {
        return this.nN;
    }

    public void g(String[] strArr) {
        this.nM = strArr;
    }

    public String[] fm() {
        return this.nM;
    }

    public String getName() {
        return this.mName;
    }

    public int fl() {
        return this.nI;
    }

    public String[] fp() {
        return this.nL;
    }

    public int fk() {
        return this.nH;
    }

    public int fj() {
        return this.nG;
    }

    public void f(int i, boolean z) {
        if (this.nJ != null) {
            this.nJ.a(this.mName, i, z);
        }
    }
}
