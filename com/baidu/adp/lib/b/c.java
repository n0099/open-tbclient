package com.baidu.adp.lib.b;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {
    private String mName;
    private int ud;
    private a ug;
    private int uf = 0;
    private String[] ui = null;
    private int ue = 0;
    private String[] uj = null;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, int i, boolean z);
    }

    public c(String str, int i, a aVar) {
        this.mName = null;
        this.ug = null;
        this.ud = 0;
        if (str == null) {
            throw new InvalidParameterException("SwitchData name is null");
        }
        this.mName = str;
        this.ug = aVar;
        this.ud = i;
    }

    public void a(int i, String[] strArr, int i2) {
        this.uf = i;
        this.ui = strArr;
        this.ue = i2;
    }

    public void g(String[] strArr) {
        this.uj = strArr;
    }

    public String[] eU() {
        return this.uj;
    }

    public String getName() {
        return this.mName;
    }

    public int eT() {
        return this.uf;
    }

    public String[] eW() {
        return this.ui;
    }

    public int eS() {
        return this.ue;
    }

    public int eR() {
        return this.ud;
    }

    public void d(int i, boolean z) {
        if (this.ug != null) {
            this.ug.a(this.mName, i, z);
        }
    }
}
