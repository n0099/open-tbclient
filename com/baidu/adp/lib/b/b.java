package com.baidu.adp.lib.b;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class b {
    private String mName;
    private int yo;
    private a yr;
    private int yq = 0;
    private String[] yt = null;
    private int yp = 0;
    private String[] yu = null;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, int i, boolean z);
    }

    public b(String str, int i, a aVar) {
        this.mName = null;
        this.yr = null;
        this.yo = 0;
        if (str == null) {
            throw new InvalidParameterException("SwitchData name is null");
        }
        this.mName = str;
        this.yr = aVar;
        this.yo = i;
    }

    public void a(int i, String[] strArr, int i2) {
        this.yq = i;
        this.yt = strArr;
        this.yp = i2;
    }

    public void g(String[] strArr) {
        this.yu = strArr;
    }

    public String[] hq() {
        return this.yu;
    }

    public String getName() {
        return this.mName;
    }

    public int hp() {
        return this.yq;
    }

    public String[] hs() {
        return this.yt;
    }

    public int ho() {
        return this.yp;
    }

    public int hn() {
        return this.yo;
    }

    public void f(int i, boolean z) {
        if (this.yr != null) {
            this.yr.a(this.mName, i, z);
        }
    }
}
