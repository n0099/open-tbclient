package com.baidu.swan.pms.model;

import android.text.TextUtils;
import java.util.Objects;
/* loaded from: classes2.dex */
public class f extends d {
    public String bma;
    public int category;
    public String downloadUrl;
    public String md5;
    public String sign;
    public long size;
    public int versionCode;
    public String versionName;

    public boolean RI() {
        return !TextUtils.isEmpty(this.bma) && (this.category == 0 || this.category == 1) && this.versionCode > 0 && this.size > 0 && !TextUtils.isEmpty(this.md5) && !TextUtils.isEmpty(this.sign) && !TextUtils.isEmpty(this.downloadUrl);
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (obj != null && (obj instanceof f)) {
            f fVar = (f) obj;
            return (TextUtils.isEmpty(this.versionName) && TextUtils.isEmpty(fVar.versionName)) ? this.bma.equals(fVar.bma) && this.versionCode == fVar.versionCode : TextUtils.equals(this.bma, fVar.bma) && this.versionCode == fVar.versionCode && TextUtils.equals(this.versionName, fVar.versionName);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.bma, Integer.valueOf(this.category), Integer.valueOf(this.versionCode), this.versionName);
    }

    public String toString() {
        return "bundleId=" + this.bma + ",category=" + this.category + ",versionCode=" + this.versionCode + ",versionName=" + this.versionName + ",size=" + this.size + ",md5=" + this.md5 + ",sign=" + this.sign + ",downloadUrl" + this.downloadUrl;
    }
}
