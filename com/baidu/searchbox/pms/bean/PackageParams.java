package com.baidu.searchbox.pms.bean;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class PackageParams {
    public String packageName;
    public String updateMd5;
    public long updateVersion;
    public long version;

    public PackageParams() {
        this.version = -1L;
        this.updateVersion = -1L;
        this.updateMd5 = "";
    }

    public String getUpdateParams() {
        if (this.updateVersion > -1 && !TextUtils.isEmpty(this.updateMd5)) {
            return this.updateVersion + "|" + this.updateMd5;
        }
        return String.valueOf(this.updateVersion);
    }

    public PackageParams(String str) {
        this.version = -1L;
        this.updateVersion = -1L;
        this.updateMd5 = "";
        this.packageName = str;
    }

    public void setUpdateMd5(String str) {
        this.updateMd5 = str;
    }

    public PackageParams(String str, long j, long j2) {
        this.version = -1L;
        this.updateVersion = -1L;
        this.updateMd5 = "";
        this.packageName = str;
        this.version = j;
        this.updateVersion = j2;
    }
}
