package com.baidu.adp.lib.b;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class b {
    private String mName;
    private int ym;
    private a yp;
    private int yo = 0;
    private String[] yr = null;
    private int yn = 0;
    private String[] ys = null;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, int i, boolean z);
    }

    public b(String str, int i, a aVar) {
        this.mName = null;
        this.yp = null;
        this.ym = 0;
        if (str == null) {
            throw new InvalidParameterException("SwitchData name is null");
        }
        this.mName = str;
        this.yp = aVar;
        this.ym = i;
    }

    public void a(int i, String[] strArr, int i2) {
        this.yo = i;
        this.yr = strArr;
        this.yn = i2;
    }

    public void g(String[] strArr) {
        this.ys = strArr;
    }

    public String[] hq() {
        return this.ys;
    }

    public String getName() {
        return this.mName;
    }

    public int hp() {
        return this.yo;
    }

    public String[] hs() {
        return this.yr;
    }

    public int ho() {
        return this.yn;
    }

    public int hn() {
        return this.ym;
    }

    public void f(int i, boolean z) {
        if (this.yp != null) {
            this.yp.a(this.mName, i, z);
        }
    }
}
