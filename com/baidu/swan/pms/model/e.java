package com.baidu.swan.pms.model;

import android.text.TextUtils;
import java.util.Objects;
/* loaded from: classes6.dex */
public class e extends c {
    public int category;
    public String downloadUrl;
    public String ewI;
    public String md5;
    public String sign;
    public long size;
    public long versionCode;
    public String versionName;

    public boolean auV() {
        return (TextUtils.isEmpty(this.ewI) || this.versionCode <= 0 || TextUtils.isEmpty(this.md5) || TextUtils.isEmpty(this.sign) || TextUtils.isEmpty(this.downloadUrl)) ? false : true;
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (obj != null && (obj instanceof e)) {
            e eVar = (e) obj;
            return (TextUtils.isEmpty(this.versionName) && TextUtils.isEmpty(eVar.versionName)) ? this.ewI.equals(eVar.ewI) && this.versionCode == eVar.versionCode : TextUtils.equals(this.ewI, eVar.ewI) && this.versionCode == eVar.versionCode && TextUtils.equals(this.versionName, eVar.versionName);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.ewI, Integer.valueOf(this.category), Long.valueOf(this.versionCode), this.versionName);
    }

    public String toString() {
        return "bundleId=" + this.ewI + ", category=" + this.category + ", versionCode=" + this.versionCode + ", versionName=" + this.versionName + ", size=" + this.size + ", md5=" + this.md5 + ", sign=" + this.sign + ", downloadUrl=" + this.downloadUrl;
    }
}
