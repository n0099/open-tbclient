package com.baidu.adp.lib.b;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class b {
    private int AA;
    private a AD;
    private String mName;
    private int AC = 0;
    private String[] AF = null;
    private int AB = 0;
    private String[] AG = null;
    private boolean AH = false;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, int i, boolean z);
    }

    public b(String str, int i, a aVar) {
        this.mName = null;
        this.AD = null;
        this.AA = 0;
        if (str == null) {
            throw new InvalidParameterException("SwitchData name is null");
        }
        this.mName = str;
        this.AD = aVar;
        this.AA = i;
    }

    public void a(int i, String[] strArr, int i2) {
        this.AC = i;
        this.AF = strArr;
        this.AB = i2;
    }

    public void K(boolean z) {
        this.AH = z;
    }

    public boolean ix() {
        return this.AH;
    }

    public void h(String[] strArr) {
        this.AG = strArr;
    }

    public String[] iv() {
        return this.AG;
    }

    public String getName() {
        return this.mName;
    }

    public int iu() {
        return this.AC;
    }

    public String[] iy() {
        return this.AF;
    }

    public int it() {
        return this.AB;
    }

    public int is() {
        return this.AA;
    }

    public void f(int i, boolean z) {
        if (this.AD != null) {
            this.AD.a(this.mName, i, z);
        }
    }
}
