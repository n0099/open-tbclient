package com.baidu.swan.pms.model;
/* loaded from: classes2.dex */
public class g {
    public f bsT;
    public PMSAppInfo bsU;

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (obj == null || !(obj instanceof g)) {
            return false;
        }
        return this.bsT.equals(((g) obj).bsT);
    }

    public String toString() {
        return "PMSPkgPair{pkgMain=" + this.bsT + ",appInfo=" + this.bsU + "}";
    }
}
