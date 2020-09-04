package com.baidu.swan.pms.model;

import android.text.TextUtils;
import java.util.Objects;
/* loaded from: classes14.dex */
public class e extends c {
    public int category;
    public String dFn;
    public String downloadUrl;
    public String md5;
    public String sign;
    public long size;
    public long versionCode;
    public String versionName;

    public boolean ajo() {
        return (TextUtils.isEmpty(this.dFn) || this.versionCode <= 0 || TextUtils.isEmpty(this.md5) || TextUtils.isEmpty(this.sign) || TextUtils.isEmpty(this.downloadUrl)) ? false : true;
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (obj != null && (obj instanceof e)) {
            e eVar = (e) obj;
            return (TextUtils.isEmpty(this.versionName) && TextUtils.isEmpty(eVar.versionName)) ? this.dFn.equals(eVar.dFn) && this.versionCode == eVar.versionCode : TextUtils.equals(this.dFn, eVar.dFn) && this.versionCode == eVar.versionCode && TextUtils.equals(this.versionName, eVar.versionName);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.dFn, Integer.valueOf(this.category), Long.valueOf(this.versionCode), this.versionName);
    }

    public String toString() {
        return "bundleId=" + this.dFn + ", category=" + this.category + ", versionCode=" + this.versionCode + ", versionName=" + this.versionName + ", size=" + this.size + ", md5=" + this.md5 + ", sign=" + this.sign + ", downloadUrl=" + this.downloadUrl;
    }
}
