package com.baidu.dynamic.download.data.bean;

import com.baidu.searchbox.NoProGuard;
@Deprecated
/* loaded from: classes.dex */
public class DynamicFile implements NoProGuard {
    public String channelId;
    public String channelName;
    public int downloadOption;
    public String downloadUrl;
    public String errMsg;
    public String extraLocal;
    public String extraServer;
    public String maxHostVersion;
    public String md5;
    public String minHostVersion;
    public String name;
    public String packageName;
    public String size;
    public String tipMsg;
    public int wifi;
    public long version = -1;
    public long updateVersion = 0;
    public int rollback = 0;
    public int errNo = -1;
    public int type = 0;
    public String filePath = "";
    public byte[] fileData = null;
    public int fileSaveType = 0;
    public long totalSize = 0;
    public long currentSize = 0;
    public long createTime = 0;
    public long updateTime = 0;
    public long rawid = 0;
    public int callbackIndex = 0;
    public String uniqueID = "";

    @Deprecated
    public void copyDownloadInfo(DynamicFile dynamicFile) {
        dynamicFile.errNo = this.errNo;
        dynamicFile.errMsg = this.errMsg;
        dynamicFile.tipMsg = this.tipMsg;
        dynamicFile.type = this.type;
        dynamicFile.filePath = this.filePath;
        dynamicFile.fileData = this.fileData;
        dynamicFile.fileSaveType = this.fileSaveType;
        dynamicFile.totalSize = this.totalSize;
        dynamicFile.currentSize = this.currentSize;
        dynamicFile.createTime = this.createTime;
        dynamicFile.updateTime = this.updateTime;
    }

    @Deprecated
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof DynamicFile)) {
            return equalsDynamicFile((DynamicFile) obj);
        }
        return false;
    }

    @Deprecated
    public boolean equalsDynamicFile(DynamicFile dynamicFile) {
        return this.channelId.equals(dynamicFile.channelId) && this.packageName.equals(dynamicFile.packageName) && this.version == dynamicFile.version && this.md5.equals(dynamicFile.md5);
    }

    @Deprecated
    public boolean isOlderThan(DynamicFile dynamicFile) {
        return this.version < dynamicFile.version;
    }

    @Deprecated
    public void sign(DynamicFile dynamicFile) {
        dynamicFile.extraLocal = this.extraLocal;
        dynamicFile.downloadOption = this.downloadOption;
        dynamicFile.channelId = this.channelId;
        dynamicFile.channelName = this.channelName;
        dynamicFile.version = this.version;
        dynamicFile.updateVersion = this.updateVersion;
        dynamicFile.minHostVersion = this.minHostVersion;
        dynamicFile.maxHostVersion = this.maxHostVersion;
        dynamicFile.extraServer = this.extraServer;
        dynamicFile.downloadUrl = this.downloadUrl;
        dynamicFile.packageName = this.packageName;
    }

    @Deprecated
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("packageName:" + this.packageName);
        sb.append(",name:" + this.name);
        sb.append(",version:" + this.version);
        sb.append(",updateVersion:" + this.updateVersion);
        sb.append(",downloadUrl:" + this.downloadUrl);
        sb.append(",md5:" + this.md5);
        sb.append(",size:" + this.size);
        sb.append(",minHostVersion:" + this.minHostVersion);
        sb.append(",maxHostVersion:" + this.maxHostVersion);
        sb.append(",wifi:" + this.wifi);
        sb.append(",rollback:" + this.rollback);
        sb.append(",errNo:" + this.errNo);
        sb.append(",errMsg:" + this.errMsg);
        sb.append(",tipMsg:" + this.tipMsg);
        sb.append(",channelId:" + this.channelId);
        sb.append(",channelName:" + this.channelName);
        sb.append(",downloadOption:" + this.downloadOption);
        sb.append(",extraLocal:" + this.extraLocal);
        sb.append(",type:" + this.type);
        sb.append(",filePath:" + this.filePath);
        sb.append(",fileData:" + this.fileData);
        sb.append(",fileSaveType:" + this.fileSaveType);
        sb.append(",totalSize:" + this.totalSize);
        sb.append(",currentSize:" + this.currentSize);
        sb.append(",createTime:" + this.createTime);
        sb.append(",updateTime:" + this.updateTime);
        sb.append(",rawid:" + this.rawid);
        sb.append(",callbackIndex:" + this.callbackIndex);
        sb.append(",uniqueID:" + this.uniqueID);
        return sb.toString();
    }
}
