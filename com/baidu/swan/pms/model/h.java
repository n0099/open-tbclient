package com.baidu.swan.pms.model;
/* loaded from: classes2.dex */
public class h {
    public g bmc;
    public a bmd;

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (obj == null || !(obj instanceof h)) {
            return false;
        }
        return this.bmc.equals(((h) obj).bmc);
    }

    public String toString() {
        return "PMSPkgPair{pkgMain=" + this.bmc + ",appInfo=" + this.bmd + "}";
    }
}
