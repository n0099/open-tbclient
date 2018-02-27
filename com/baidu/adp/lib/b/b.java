package com.baidu.adp.lib.b;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class b {
    private int ahJ;
    private a ahM;
    private String mName;
    private int ahL = 0;
    private String[] ahO = null;
    private int ahK = 0;
    private String[] ahP = null;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, int i, boolean z);
    }

    public b(String str, int i, a aVar) {
        this.mName = null;
        this.ahM = null;
        this.ahJ = 0;
        if (str == null) {
            throw new InvalidParameterException("SwitchData name is null");
        }
        this.mName = str;
        this.ahM = aVar;
        this.ahJ = i;
    }

    public void a(int i, String[] strArr, int i2) {
        this.ahL = i;
        this.ahO = strArr;
        this.ahK = i2;
    }

    public void g(String[] strArr) {
        this.ahP = strArr;
    }

    public String[] mv() {
        return this.ahP;
    }

    public String getName() {
        return this.mName;
    }

    public int mu() {
        return this.ahL;
    }

    public String[] mx() {
        return this.ahO;
    }

    public int mt() {
        return this.ahK;
    }

    public int ms() {
        return this.ahJ;
    }

    public void q(int i, boolean z) {
        if (this.ahM != null) {
            this.ahM.a(this.mName, i, z);
        }
    }
}
