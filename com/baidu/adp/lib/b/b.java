package com.baidu.adp.lib.b;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class b {
    private String mName;
    private int ue;
    private a uh;
    private int ug = 0;
    private String[] uj = null;
    private int uf = 0;
    private String[] uk = null;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, int i, boolean z);
    }

    public b(String str, int i, a aVar) {
        this.mName = null;
        this.uh = null;
        this.ue = 0;
        if (str == null) {
            throw new InvalidParameterException("SwitchData name is null");
        }
        this.mName = str;
        this.uh = aVar;
        this.ue = i;
    }

    public void a(int i, String[] strArr, int i2) {
        this.ug = i;
        this.uj = strArr;
        this.uf = i2;
    }

    public void g(String[] strArr) {
        this.uk = strArr;
    }

    public String[] eR() {
        return this.uk;
    }

    public String getName() {
        return this.mName;
    }

    public int eQ() {
        return this.ug;
    }

    public String[] eT() {
        return this.uj;
    }

    public int eP() {
        return this.uf;
    }

    public int eO() {
        return this.ue;
    }

    public void d(int i, boolean z) {
        if (this.uh != null) {
            this.uh.a(this.mName, i, z);
        }
    }
}
