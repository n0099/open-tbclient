package com.baidu.adp.lib.b;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class b {
    private String mName;
    private int vJ;
    private a vM;
    private int vL = 0;
    private String[] vO = null;
    private int vK = 0;
    private String[] vP = null;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, int i, boolean z);
    }

    public b(String str, int i, a aVar) {
        this.mName = null;
        this.vM = null;
        this.vJ = 0;
        if (str == null) {
            throw new InvalidParameterException("SwitchData name is null");
        }
        this.mName = str;
        this.vM = aVar;
        this.vJ = i;
    }

    public void a(int i, String[] strArr, int i2) {
        this.vL = i;
        this.vO = strArr;
        this.vK = i2;
    }

    public void g(String[] strArr) {
        this.vP = strArr;
    }

    public String[] fc() {
        return this.vP;
    }

    public String getName() {
        return this.mName;
    }

    public int fb() {
        return this.vL;
    }

    public String[] fe() {
        return this.vO;
    }

    public int fa() {
        return this.vK;
    }

    public int eZ() {
        return this.vJ;
    }

    public void d(int i, boolean z) {
        if (this.vM != null) {
            this.vM.a(this.mName, i, z);
        }
    }
}
