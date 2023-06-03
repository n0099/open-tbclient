package com.baidu.searchbox.download.unified;
/* loaded from: classes3.dex */
public class DownloadInfoData {
    public int businessType;
    public int category;
    public long createTime;
    public long currentSize;
    public int errorReason;
    public String extraInfo;
    public String fileName;
    public String filePath;
    public long id;
    public String mimeType;
    public String source;
    public int status;
    public long timeStampLastModification;
    public long totalSize;
    public String url;
    public boolean visibleInDownloadsUI;

    /* loaded from: classes3.dex */
    public static class Status {
        public static final int STATUS_FAILED = 16;
        public static final int STATUS_PAUSED = 4;
        public static final int STATUS_PENDING = 1;
        public static final int STATUS_RUNNING = 2;
        public static final int STATUS_SUCCESSFUL = 8;
    }

    public int getBusinessType() {
        return this.businessType;
    }

    public int getCategory() {
        return this.category;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public long getCurrentSize() {
        return this.currentSize;
    }

    public int getErrorReason() {
        return this.errorReason;
    }

    public String getExtraInfo() {
        return this.extraInfo;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public long getId() {
        return this.id;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public String getSource() {
        return this.source;
    }

    public int getStatus() {
        return this.status;
    }

    public long getTimeStampLastModification() {
        return this.timeStampLastModification;
    }

    public long getTotalSize() {
        return this.totalSize;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isVisibleInDownloadsUI() {
        return this.visibleInDownloadsUI;
    }

    public void setBusinessType(int i) {
        this.businessType = i;
    }

    public void setCategory(int i) {
        this.category = i;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public void setCurrentSize(long j) {
        this.currentSize = j;
    }

    public void setErrorReason(int i) {
        this.errorReason = i;
    }

    public void setExtraInfo(String str) {
        this.extraInfo = str;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setMimeType(String str) {
        this.mimeType = str;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setTimeStampLastModification(long j) {
        this.timeStampLastModification = j;
    }

    public void setTotalSize(long j) {
        this.totalSize = j;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setVisibleInDownloadsUI(boolean z) {
        this.visibleInDownloadsUI = z;
    }
}
