package com.baidu.swan.pms.model;
/* loaded from: classes2.dex */
public class g {
    public f bMc;
    public PMSAppInfo bMd;

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (obj == null || !(obj instanceof g)) {
            return false;
        }
        return this.bMc.equals(((g) obj).bMc);
    }

    public String toString() {
        return "PMSPkgPair{pkgMain=" + this.bMc + ",appInfo=" + this.bMd + "}";
    }
}
