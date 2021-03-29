package com.baidu.searchbox.pms.bean;
/* loaded from: classes2.dex */
public class PackageParams {
    public String packageName;
    public long updateVersion;
    public long version;

    public PackageParams() {
        this.version = -1L;
        this.updateVersion = -1L;
    }

    public PackageParams(String str) {
        this.version = -1L;
        this.updateVersion = -1L;
        this.packageName = str;
    }

    public PackageParams(String str, long j, long j2) {
        this.version = -1L;
        this.updateVersion = -1L;
        this.packageName = str;
        this.version = j;
        this.updateVersion = j2;
    }
}
