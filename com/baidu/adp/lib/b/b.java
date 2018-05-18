package com.baidu.adp.lib.b;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class b {
    private String mName;
    private int sb;
    private a se;
    private int sd = 0;
    private String[] sg = null;
    private int sc = 0;
    private String[] sh = null;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, int i, boolean z);
    }

    public b(String str, int i, a aVar) {
        this.mName = null;
        this.se = null;
        this.sb = 0;
        if (str == null) {
            throw new InvalidParameterException("SwitchData name is null");
        }
        this.mName = str;
        this.se = aVar;
        this.sb = i;
    }

    public void a(int i, String[] strArr, int i2) {
        this.sd = i;
        this.sg = strArr;
        this.sc = i2;
    }

    public void g(String[] strArr) {
        this.sh = strArr;
    }

    public String[] ez() {
        return this.sh;
    }

    public String getName() {
        return this.mName;
    }

    public int ey() {
        return this.sd;
    }

    public String[] eB() {
        return this.sg;
    }

    public int ex() {
        return this.sc;
    }

    public int ew() {
        return this.sb;
    }

    public void f(int i, boolean z) {
        if (this.se != null) {
            this.se.a(this.mName, i, z);
        }
    }
}
