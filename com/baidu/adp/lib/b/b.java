package com.baidu.adp.lib.b;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class b {
    private String mName;
    private a tB;
    private int ty;
    private int tA = 0;
    private String[] tD = null;
    private int tz = 0;
    private String[] tE = null;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, int i, boolean z);
    }

    public b(String str, int i, a aVar) {
        this.mName = null;
        this.tB = null;
        this.ty = 0;
        if (str == null) {
            throw new InvalidParameterException("SwitchData name is null");
        }
        this.mName = str;
        this.tB = aVar;
        this.ty = i;
    }

    public void a(int i, String[] strArr, int i2) {
        this.tA = i;
        this.tD = strArr;
        this.tz = i2;
    }

    public void g(String[] strArr) {
        this.tE = strArr;
    }

    public String[] eR() {
        return this.tE;
    }

    public String getName() {
        return this.mName;
    }

    public int eQ() {
        return this.tA;
    }

    public String[] eT() {
        return this.tD;
    }

    public int eP() {
        return this.tz;
    }

    public int eO() {
        return this.ty;
    }

    public void c(int i, boolean z) {
        if (this.tB != null) {
            this.tB.a(this.mName, i, z);
        }
    }
}
