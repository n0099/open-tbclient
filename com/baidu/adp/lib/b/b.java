package com.baidu.adp.lib.b;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class b {
    private String mName;
    private int sc;
    private a sf;
    private int se = 0;
    private String[] sh = null;
    private int sd = 0;
    private String[] si = null;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, int i, boolean z);
    }

    public b(String str, int i, a aVar) {
        this.mName = null;
        this.sf = null;
        this.sc = 0;
        if (str == null) {
            throw new InvalidParameterException("SwitchData name is null");
        }
        this.mName = str;
        this.sf = aVar;
        this.sc = i;
    }

    public void a(int i, String[] strArr, int i2) {
        this.se = i;
        this.sh = strArr;
        this.sd = i2;
    }

    public void g(String[] strArr) {
        this.si = strArr;
    }

    public String[] ez() {
        return this.si;
    }

    public String getName() {
        return this.mName;
    }

    public int ey() {
        return this.se;
    }

    public String[] eB() {
        return this.sh;
    }

    public int ex() {
        return this.sd;
    }

    public int ew() {
        return this.sc;
    }

    public void f(int i, boolean z) {
        if (this.sf != null) {
            this.sf.a(this.mName, i, z);
        }
    }
}
