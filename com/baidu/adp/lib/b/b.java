package com.baidu.adp.lib.b;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class b {
    private String mName;
    private int vH;
    private a vK;
    private int vJ = 0;
    private String[] vM = null;
    private int vI = 0;
    private String[] vN = null;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, int i, boolean z);
    }

    public b(String str, int i, a aVar) {
        this.mName = null;
        this.vK = null;
        this.vH = 0;
        if (str == null) {
            throw new InvalidParameterException("SwitchData name is null");
        }
        this.mName = str;
        this.vK = aVar;
        this.vH = i;
    }

    public void a(int i, String[] strArr, int i2) {
        this.vJ = i;
        this.vM = strArr;
        this.vI = i2;
    }

    public void g(String[] strArr) {
        this.vN = strArr;
    }

    public String[] fc() {
        return this.vN;
    }

    public String getName() {
        return this.mName;
    }

    public int fb() {
        return this.vJ;
    }

    public String[] fe() {
        return this.vM;
    }

    public int fa() {
        return this.vI;
    }

    public int eZ() {
        return this.vH;
    }

    public void d(int i, boolean z) {
        if (this.vK != null) {
            this.vK.a(this.mName, i, z);
        }
    }
}
