package com.baidu.swan.pms.model;
/* loaded from: classes2.dex */
public class h {
    public g blY;
    public a blZ;

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (obj == null || !(obj instanceof h)) {
            return false;
        }
        return this.blY.equals(((h) obj).blY);
    }

    public String toString() {
        return "PMSPkgPair{pkgMain=" + this.blY + ",appInfo=" + this.blZ + "}";
    }
}
