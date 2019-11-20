package com.baidu.swan.pms.model;
/* loaded from: classes2.dex */
public class g {
    public f bLl;
    public PMSAppInfo bLm;

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (obj == null || !(obj instanceof g)) {
            return false;
        }
        return this.bLl.equals(((g) obj).bLl);
    }

    public String toString() {
        return "PMSPkgPair{pkgMain=" + this.bLl + ",appInfo=" + this.bLm + "}";
    }
}
