package com.baidu.adp.lib.b;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class b {
    private String mName;
    private a tC;
    private int tz;
    private int tB = 0;
    private String[] tE = null;
    private int tA = 0;
    private String[] tF = null;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, int i, boolean z);
    }

    public b(String str, int i, a aVar) {
        this.mName = null;
        this.tC = null;
        this.tz = 0;
        if (str == null) {
            throw new InvalidParameterException("SwitchData name is null");
        }
        this.mName = str;
        this.tC = aVar;
        this.tz = i;
    }

    public void a(int i, String[] strArr, int i2) {
        this.tB = i;
        this.tE = strArr;
        this.tA = i2;
    }

    public void g(String[] strArr) {
        this.tF = strArr;
    }

    public String[] eQ() {
        return this.tF;
    }

    public String getName() {
        return this.mName;
    }

    public int eP() {
        return this.tB;
    }

    public String[] eS() {
        return this.tE;
    }

    public int eO() {
        return this.tA;
    }

    public int eN() {
        return this.tz;
    }

    public void c(int i, boolean z) {
        if (this.tC != null) {
            this.tC.a(this.mName, i, z);
        }
    }
}
