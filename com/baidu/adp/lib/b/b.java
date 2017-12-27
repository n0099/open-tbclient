package com.baidu.adp.lib.b;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class b {
    private int ahO;
    private a ahR;
    private String mName;
    private int ahQ = 0;
    private String[] ahT = null;
    private int ahP = 0;
    private String[] ahU = null;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, int i, boolean z);
    }

    public b(String str, int i, a aVar) {
        this.mName = null;
        this.ahR = null;
        this.ahO = 0;
        if (str == null) {
            throw new InvalidParameterException("SwitchData name is null");
        }
        this.mName = str;
        this.ahR = aVar;
        this.ahO = i;
    }

    public void a(int i, String[] strArr, int i2) {
        this.ahQ = i;
        this.ahT = strArr;
        this.ahP = i2;
    }

    public void g(String[] strArr) {
        this.ahU = strArr;
    }

    public String[] mu() {
        return this.ahU;
    }

    public String getName() {
        return this.mName;
    }

    public int mt() {
        return this.ahQ;
    }

    public String[] mw() {
        return this.ahT;
    }

    public int ms() {
        return this.ahP;
    }

    public int mr() {
        return this.ahO;
    }

    public void n(int i, boolean z) {
        if (this.ahR != null) {
            this.ahR.a(this.mName, i, z);
        }
    }
}
