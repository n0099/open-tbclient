package com.baidu.adp.lib.b;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class b {
    private String mName;
    private int of;
    private a oi;
    private int oh = 0;
    private String[] ol = null;
    private int og = 0;
    private String[] om = null;
    private boolean on = false;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, int i, boolean z);
    }

    public b(String str, int i, a aVar) {
        this.mName = null;
        this.oi = null;
        this.of = 0;
        if (str == null) {
            throw new InvalidParameterException("SwitchData name is null");
        }
        this.mName = str;
        this.oi = aVar;
        this.of = i;
    }

    public void a(int i, String[] strArr, int i2) {
        this.oh = i;
        this.ol = strArr;
        this.og = i2;
    }

    public void z(boolean z) {
        this.on = z;
    }

    public boolean fo() {
        return this.on;
    }

    public void g(String[] strArr) {
        this.om = strArr;
    }

    public String[] fm() {
        return this.om;
    }

    public String getName() {
        return this.mName;
    }

    public int fl() {
        return this.oh;
    }

    public String[] fp() {
        return this.ol;
    }

    public int fk() {
        return this.og;
    }

    public int fj() {
        return this.of;
    }

    public void f(int i, boolean z) {
        if (this.oi != null) {
            this.oi.a(this.mName, i, z);
        }
    }
}
