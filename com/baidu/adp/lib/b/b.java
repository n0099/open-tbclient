package com.baidu.adp.lib.b;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class b {
    private String mName;
    private int tB;
    private a tE;
    private int tD = 0;
    private String[] tG = null;
    private int tC = 0;
    private String[] tH = null;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, int i, boolean z);
    }

    public b(String str, int i, a aVar) {
        this.mName = null;
        this.tE = null;
        this.tB = 0;
        if (str == null) {
            throw new InvalidParameterException("SwitchData name is null");
        }
        this.mName = str;
        this.tE = aVar;
        this.tB = i;
    }

    public void a(int i, String[] strArr, int i2) {
        this.tD = i;
        this.tG = strArr;
        this.tC = i2;
    }

    public void g(String[] strArr) {
        this.tH = strArr;
    }

    public String[] eQ() {
        return this.tH;
    }

    public String getName() {
        return this.mName;
    }

    public int eP() {
        return this.tD;
    }

    public String[] eS() {
        return this.tG;
    }

    public int eO() {
        return this.tC;
    }

    public int eN() {
        return this.tB;
    }

    public void c(int i, boolean z) {
        if (this.tE != null) {
            this.tE.a(this.mName, i, z);
        }
    }
}
