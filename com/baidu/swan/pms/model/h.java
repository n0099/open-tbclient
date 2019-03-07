package com.baidu.swan.pms.model;
/* loaded from: classes2.dex */
public class h {
    public g blX;
    public a blY;

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (obj == null || !(obj instanceof h)) {
            return false;
        }
        return this.blX.equals(((h) obj).blX);
    }

    public String toString() {
        return "PMSPkgPair{pkgMain=" + this.blX + ",appInfo=" + this.blY + "}";
    }
}
