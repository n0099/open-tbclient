package com.baidu.adp.lib.b;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class b {
    private String mName;
    private int yV;
    private a yY;
    private int yX = 0;
    private String[] za = null;
    private int yW = 0;
    private String[] zb = null;
    private boolean zc = false;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, int i, boolean z);
    }

    public b(String str, int i, a aVar) {
        this.mName = null;
        this.yY = null;
        this.yV = 0;
        if (str == null) {
            throw new InvalidParameterException("SwitchData name is null");
        }
        this.mName = str;
        this.yY = aVar;
        this.yV = i;
    }

    public void a(int i, String[] strArr, int i2) {
        this.yX = i;
        this.za = strArr;
        this.yW = i2;
    }

    public void Q(boolean z) {
        this.zc = z;
    }

    public boolean hE() {
        return this.zc;
    }

    public void g(String[] strArr) {
        this.zb = strArr;
    }

    public String[] hC() {
        return this.zb;
    }

    public String getName() {
        return this.mName;
    }

    public int hB() {
        return this.yX;
    }

    public String[] hF() {
        return this.za;
    }

    public int hA() {
        return this.yW;
    }

    public int hz() {
        return this.yV;
    }

    public void f(int i, boolean z) {
        if (this.yY != null) {
            this.yY.a(this.mName, i, z);
        }
    }
}
