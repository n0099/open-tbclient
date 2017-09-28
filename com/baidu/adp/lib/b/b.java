package com.baidu.adp.lib.b;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class b {
    private String mName;
    private int tA;
    private a tD;
    private int tC = 0;
    private String[] tF = null;
    private int tB = 0;
    private String[] tG = null;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, int i, boolean z);
    }

    public b(String str, int i, a aVar) {
        this.mName = null;
        this.tD = null;
        this.tA = 0;
        if (str == null) {
            throw new InvalidParameterException("SwitchData name is null");
        }
        this.mName = str;
        this.tD = aVar;
        this.tA = i;
    }

    public void a(int i, String[] strArr, int i2) {
        this.tC = i;
        this.tF = strArr;
        this.tB = i2;
    }

    public void g(String[] strArr) {
        this.tG = strArr;
    }

    public String[] eQ() {
        return this.tG;
    }

    public String getName() {
        return this.mName;
    }

    public int eP() {
        return this.tC;
    }

    public String[] eS() {
        return this.tF;
    }

    public int eO() {
        return this.tB;
    }

    public int eN() {
        return this.tA;
    }

    public void c(int i, boolean z) {
        if (this.tD != null) {
            this.tD.a(this.mName, i, z);
        }
    }
}
