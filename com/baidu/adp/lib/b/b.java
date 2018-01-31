package com.baidu.adp.lib.b;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class b {
    private int ahR;
    private a ahU;
    private String mName;
    private int ahT = 0;
    private String[] ahW = null;
    private int ahS = 0;
    private String[] ahX = null;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, int i, boolean z);
    }

    public b(String str, int i, a aVar) {
        this.mName = null;
        this.ahU = null;
        this.ahR = 0;
        if (str == null) {
            throw new InvalidParameterException("SwitchData name is null");
        }
        this.mName = str;
        this.ahU = aVar;
        this.ahR = i;
    }

    public void a(int i, String[] strArr, int i2) {
        this.ahT = i;
        this.ahW = strArr;
        this.ahS = i2;
    }

    public void g(String[] strArr) {
        this.ahX = strArr;
    }

    public String[] mv() {
        return this.ahX;
    }

    public String getName() {
        return this.mName;
    }

    public int mu() {
        return this.ahT;
    }

    public String[] mx() {
        return this.ahW;
    }

    public int mt() {
        return this.ahS;
    }

    public int ms() {
        return this.ahR;
    }

    public void n(int i, boolean z) {
        if (this.ahU != null) {
            this.ahU.a(this.mName, i, z);
        }
    }
}
