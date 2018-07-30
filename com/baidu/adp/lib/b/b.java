package com.baidu.adp.lib.b;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class b {
    private String mName;
    private int yg;
    private a yj;
    private int yi = 0;
    private String[] yl = null;
    private int yh = 0;
    private String[] ym = null;
    private boolean yn = false;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, int i, boolean z);
    }

    public b(String str, int i, a aVar) {
        this.mName = null;
        this.yj = null;
        this.yg = 0;
        if (str == null) {
            throw new InvalidParameterException("SwitchData name is null");
        }
        this.mName = str;
        this.yj = aVar;
        this.yg = i;
    }

    public void a(int i, String[] strArr, int i2) {
        this.yi = i;
        this.yl = strArr;
        this.yh = i2;
    }

    public void A(boolean z) {
        this.yn = z;
    }

    public boolean hr() {
        return this.yn;
    }

    public void g(String[] strArr) {
        this.ym = strArr;
    }

    public String[] hp() {
        return this.ym;
    }

    public String getName() {
        return this.mName;
    }

    public int ho() {
        return this.yi;
    }

    public String[] hs() {
        return this.yl;
    }

    public int hn() {
        return this.yh;
    }

    public int hm() {
        return this.yg;
    }

    public void f(int i, boolean z) {
        if (this.yj != null) {
            this.yj.a(this.mName, i, z);
        }
    }
}
