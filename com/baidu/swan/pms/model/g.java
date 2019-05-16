package com.baidu.swan.pms.model;
/* loaded from: classes2.dex */
public class g {
    public f bse;
    public PMSAppInfo bsf;

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (obj == null || !(obj instanceof g)) {
            return false;
        }
        return this.bse.equals(((g) obj).bse);
    }

    public String toString() {
        return "PMSPkgPair{pkgMain=" + this.bse + ",appInfo=" + this.bsf + "}";
    }
}
