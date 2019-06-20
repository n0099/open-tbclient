package com.baidu.adp.lib.b;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class b {
    private String mName;
    private int yU;
    private a yX;
    private int yW = 0;
    private String[] yZ = null;
    private int yV = 0;
    private String[] za = null;
    private boolean zb = false;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, int i, boolean z);
    }

    public b(String str, int i, a aVar) {
        this.mName = null;
        this.yX = null;
        this.yU = 0;
        if (str == null) {
            throw new InvalidParameterException("SwitchData name is null");
        }
        this.mName = str;
        this.yX = aVar;
        this.yU = i;
    }

    public void a(int i, String[] strArr, int i2) {
        this.yW = i;
        this.yZ = strArr;
        this.yV = i2;
    }

    public void Q(boolean z) {
        this.zb = z;
    }

    public boolean hE() {
        return this.zb;
    }

    public void g(String[] strArr) {
        this.za = strArr;
    }

    public String[] hC() {
        return this.za;
    }

    public String getName() {
        return this.mName;
    }

    public int hB() {
        return this.yW;
    }

    public String[] hF() {
        return this.yZ;
    }

    public int hA() {
        return this.yV;
    }

    public int hz() {
        return this.yU;
    }

    public void f(int i, boolean z) {
        if (this.yX != null) {
            this.yX.a(this.mName, i, z);
        }
    }
}
