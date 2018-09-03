package com.baidu.adp.lib.b;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class b {
    private String mName;
    private int yh;
    private a yk;
    private int yj = 0;
    private String[] ym = null;
    private int yi = 0;
    private String[] yn = null;
    private boolean yo = false;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, int i, boolean z);
    }

    public b(String str, int i, a aVar) {
        this.mName = null;
        this.yk = null;
        this.yh = 0;
        if (str == null) {
            throw new InvalidParameterException("SwitchData name is null");
        }
        this.mName = str;
        this.yk = aVar;
        this.yh = i;
    }

    public void a(int i, String[] strArr, int i2) {
        this.yj = i;
        this.ym = strArr;
        this.yi = i2;
    }

    public void A(boolean z) {
        this.yo = z;
    }

    public boolean hr() {
        return this.yo;
    }

    public void g(String[] strArr) {
        this.yn = strArr;
    }

    public String[] hp() {
        return this.yn;
    }

    public String getName() {
        return this.mName;
    }

    public int ho() {
        return this.yj;
    }

    public String[] hs() {
        return this.ym;
    }

    public int hn() {
        return this.yi;
    }

    public int hm() {
        return this.yh;
    }

    public void f(int i, boolean z) {
        if (this.yk != null) {
            this.yk.a(this.mName, i, z);
        }
    }
}
