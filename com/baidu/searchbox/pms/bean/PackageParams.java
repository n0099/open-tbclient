package com.baidu.searchbox.pms.bean;

import android.text.TextUtils;
/* loaded from: classes4.dex */
public class PackageParams {
    public String packageName;
    public String uniqueVersion;
    public String updateMd5;
    public long updateVersion;
    public long version;

    public PackageParams() {
        this.version = -1L;
        this.updateVersion = -1L;
        this.updateMd5 = "";
        this.uniqueVersion = "";
    }

    public PackageParams(String str) {
        this.version = -1L;
        this.updateVersion = -1L;
        this.updateMd5 = "";
        this.uniqueVersion = "";
        this.packageName = str;
    }

    public void setUpdateMd5(String str) {
        this.updateMd5 = str;
    }

    public PackageParams(String str, long j, long j2) {
        this.version = -1L;
        this.updateVersion = -1L;
        this.updateMd5 = "";
        this.uniqueVersion = "";
        this.packageName = str;
        this.version = j;
        this.updateVersion = j2;
    }

    public String getUpdateParams() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.updateVersion);
        if (this.updateVersion > -1) {
            if (!TextUtils.isEmpty(this.uniqueVersion)) {
                sb.append("_" + this.uniqueVersion);
            }
            if (!TextUtils.isEmpty(this.updateMd5)) {
                sb.append("|" + this.updateMd5);
            }
        }
        return sb.toString();
    }
}
