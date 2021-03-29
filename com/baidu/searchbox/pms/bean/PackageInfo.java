package com.baidu.searchbox.pms.bean;

import android.text.TextUtils;
import com.baidu.searchbox.NoProGuard;
import java.util.Random;
/* loaded from: classes2.dex */
public class PackageInfo implements NoProGuard, Cloneable {
    public static final int CODE_FILTERD = 1102;
    public static final int CODE_HOST_VERSION = 1103;
    public static final int CODE_NOT_EXISTS = 1101;
    public static final int CODE_SUCCESS = 0;
    public String channelId;
    public int disable;
    public int downloadOption;
    public String downloadUrl;
    public String extraLocal;
    public String extraServer;
    public int isSilence;
    public String key;
    public String maxHostVersion;
    public String md5;
    public String minHostVersion;
    public String name;
    public String packageName;
    public String sign;
    public String size;
    public int wifi;
    public int errNo = -1;
    public long version = -1;
    public long updateVersion = 0;
    public volatile int type = 0;
    public int retryCount = 0;
    public volatile String filePath = "";
    public long totalSize = 0;
    public long currentSize = 0;
    public long createTime = 0;
    public long updateTime = 0;
    public volatile long rawId = 0;
    public String uniqueID = String.valueOf(System.currentTimeMillis()) + new Random().nextInt(1000);

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void copyDownloadInfo(PackageInfo packageInfo) {
        packageInfo.errNo = this.errNo;
        packageInfo.type = this.type;
        packageInfo.filePath = this.filePath;
        packageInfo.totalSize = this.totalSize;
        packageInfo.currentSize = this.currentSize;
        packageInfo.createTime = this.createTime;
        packageInfo.updateTime = this.updateTime;
    }

    public void copyTo(PackageInfo packageInfo) {
        packageInfo.name = this.name;
        packageInfo.extraLocal = this.extraLocal;
        packageInfo.downloadOption = this.downloadOption;
        packageInfo.channelId = this.channelId;
        packageInfo.version = this.version;
        packageInfo.updateVersion = this.updateVersion;
        packageInfo.minHostVersion = this.minHostVersion;
        packageInfo.maxHostVersion = this.maxHostVersion;
        packageInfo.extraServer = this.extraServer;
        packageInfo.downloadUrl = this.downloadUrl;
        packageInfo.packageName = this.packageName;
        packageInfo.disable = this.disable;
        packageInfo.wifi = this.wifi;
        packageInfo.isSilence = this.isSilence;
        packageInfo.sign = this.sign;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof PackageInfo)) {
            return TextUtils.equals(getKey(), ((PackageInfo) obj).getKey());
        }
        return false;
    }

    public String getKey() {
        if (TextUtils.isEmpty(this.key) && !TextUtils.isEmpty(this.channelId) && !TextUtils.isEmpty(this.packageName) && !TextUtils.isEmpty(this.md5)) {
            this.key = this.channelId + "_" + this.packageName + "_" + this.md5;
        }
        return this.key;
    }

    public boolean isAllowSilence() {
        return this.isSilence == 1;
    }

    public boolean isDisable() {
        return this.disable == 1;
    }

    public boolean isOlderThan(PackageInfo packageInfo) {
        return this.version < packageInfo.version;
    }

    public boolean isOnlyWifi() {
        return this.wifi == 1;
    }

    public boolean isValid() {
        return (this.errNo != 0 || TextUtils.isEmpty(this.channelId) || TextUtils.isEmpty(this.packageName) || TextUtils.isEmpty(this.md5) || TextUtils.isEmpty(this.downloadUrl) || this.updateVersion < 0) ? false : true;
    }

    public String toString() {
        return "channelId=" + this.channelId + ",packageName=" + this.packageName + ",version=" + this.version + ",updateVersion=" + this.updateVersion + ",name=" + this.name + ",md5=" + this.md5 + ",type=" + this.type + ",downloadUrl=" + this.downloadUrl;
    }
}
