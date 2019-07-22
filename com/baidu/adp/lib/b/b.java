package com.baidu.adp.lib.b;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class b {
    private String mName;
    private int za;
    private a zd;
    private int zc = 0;
    private String[] zf = null;
    private int zb = 0;
    private String[] zg = null;
    private boolean zh = false;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, int i, boolean z);
    }

    public b(String str, int i, a aVar) {
        this.mName = null;
        this.zd = null;
        this.za = 0;
        if (str == null) {
            throw new InvalidParameterException("SwitchData name is null");
        }
        this.mName = str;
        this.zd = aVar;
        this.za = i;
    }

    public void a(int i, String[] strArr, int i2) {
        this.zc = i;
        this.zf = strArr;
        this.zb = i2;
    }

    public void Q(boolean z) {
        this.zh = z;
    }

    public boolean hO() {
        return this.zh;
    }

    public void g(String[] strArr) {
        this.zg = strArr;
    }

    public String[] hM() {
        return this.zg;
    }

    public String getName() {
        return this.mName;
    }

    public int hL() {
        return this.zc;
    }

    public String[] hP() {
        return this.zf;
    }

    public int hK() {
        return this.zb;
    }

    public int hJ() {
        return this.za;
    }

    public void f(int i, boolean z) {
        if (this.zd != null) {
            this.zd.a(this.mName, i, z);
        }
    }
}
