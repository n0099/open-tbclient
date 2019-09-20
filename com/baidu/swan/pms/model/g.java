package com.baidu.swan.pms.model;
/* loaded from: classes2.dex */
public class g {
    public f btr;
    public PMSAppInfo bts;

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (obj == null || !(obj instanceof g)) {
            return false;
        }
        return this.btr.equals(((g) obj).btr);
    }

    public String toString() {
        return "PMSPkgPair{pkgMain=" + this.btr + ",appInfo=" + this.bts + "}";
    }
}
