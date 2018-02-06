package com.baidu.adp.lib.b;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class b {
    private int ahP;
    private a ahS;
    private String mName;
    private int ahR = 0;
    private String[] ahU = null;
    private int ahQ = 0;
    private String[] ahV = null;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, int i, boolean z);
    }

    public b(String str, int i, a aVar) {
        this.mName = null;
        this.ahS = null;
        this.ahP = 0;
        if (str == null) {
            throw new InvalidParameterException("SwitchData name is null");
        }
        this.mName = str;
        this.ahS = aVar;
        this.ahP = i;
    }

    public void a(int i, String[] strArr, int i2) {
        this.ahR = i;
        this.ahU = strArr;
        this.ahQ = i2;
    }

    public void g(String[] strArr) {
        this.ahV = strArr;
    }

    public String[] mv() {
        return this.ahV;
    }

    public String getName() {
        return this.mName;
    }

    public int mu() {
        return this.ahR;
    }

    public String[] mx() {
        return this.ahU;
    }

    public int mt() {
        return this.ahQ;
    }

    public int ms() {
        return this.ahP;
    }

    public void q(int i, boolean z) {
        if (this.ahS != null) {
            this.ahS.a(this.mName, i, z);
        }
    }
}
