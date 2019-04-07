package com.baidu.swan.pms.model;
/* loaded from: classes2.dex */
public class h {
    public g bmb;
    public a bmc;

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (obj == null || !(obj instanceof h)) {
            return false;
        }
        return this.bmb.equals(((h) obj).bmb);
    }

    public String toString() {
        return "PMSPkgPair{pkgMain=" + this.bmb + ",appInfo=" + this.bmc + "}";
    }
}
