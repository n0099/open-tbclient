package com.baidu.adp.lib.b;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c {
    private String mName;
    private int tX;
    private a ub;
    private int tZ = 0;
    private String[] ud = null;
    private int tY = 0;
    private String[] ue = null;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, int i, boolean z);
    }

    public c(String str, int i, a aVar) {
        this.mName = null;
        this.ub = null;
        this.tX = 0;
        if (str == null) {
            throw new InvalidParameterException("SwitchData name is null");
        }
        this.mName = str;
        this.ub = aVar;
        this.tX = i;
    }

    public void a(int i, String[] strArr, int i2) {
        this.tZ = i;
        this.ud = strArr;
        this.tY = i2;
    }

    public void g(String[] strArr) {
        this.ue = strArr;
    }

    public String[] eT() {
        return this.ue;
    }

    public String getName() {
        return this.mName;
    }

    public int eS() {
        return this.tZ;
    }

    public String[] eV() {
        return this.ud;
    }

    public int eR() {
        return this.tY;
    }

    public int eQ() {
        return this.tX;
    }

    public void d(int i, boolean z) {
        if (this.ub != null) {
            this.ub.a(this.mName, i, z);
        }
    }
}
