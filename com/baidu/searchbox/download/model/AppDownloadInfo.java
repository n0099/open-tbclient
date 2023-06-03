package com.baidu.searchbox.download.model;
/* loaded from: classes3.dex */
public class AppDownloadInfo {
    public Long id;
    public String uri = "";
    public String data = "";
    public String filename = "";
    public String savedPathForUser = "";
    public String mimetype = "";
    public String etag = "";
    public Integer visibility = 0;
    public Integer status = 0;
    public Long totalBytes = 0L;
    public Long currentBytes = 0L;
    public Integer notificationneeded = 0;
    public Boolean notificationshowed = Boolean.FALSE;
    public String savedSourceKeyUser = "";

    public Long getCurrentBytes() {
        return this.currentBytes;
    }

    public String getData() {
        return this.data;
    }

    public String getEtag() {
        return this.etag;
    }

    public String getFilename() {
        return this.filename;
    }

    public Long getId() {
        return this.id;
    }

    public String getMimetype() {
        return this.mimetype;
    }

    public Integer getNotificationneeded() {
        return this.notificationneeded;
    }

    public Boolean getNotificationshowed() {
        return this.notificationshowed;
    }

    public String getSavedPathForUser() {
        return this.savedPathForUser;
    }

    public String getSavedSourceKeyUser() {
        return this.savedSourceKeyUser;
    }

    public Integer getStatus() {
        return this.status;
    }

    public Long getTotalBytes() {
        return this.totalBytes;
    }

    public String getUri() {
        return this.uri;
    }

    public Integer getVisibility() {
        return this.visibility;
    }

    public void setCurrentBytes(Long l) {
        this.currentBytes = l;
    }

    public void setData(String str) {
        if (str == null) {
            str = "";
        }
        this.data = str;
    }

    public void setEtag(String str) {
        this.etag = str;
    }

    public void setFilename(String str) {
        if (str == null) {
            str = "";
        }
        this.filename = str;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public void setMimetype(String str) {
        this.mimetype = str;
    }

    public void setNotificationneeded(Integer num) {
        this.notificationneeded = num;
    }

    public void setNotificationshowed(Boolean bool) {
        this.notificationshowed = bool;
    }

    public void setSavedPathForUser(String str) {
        this.savedPathForUser = str;
    }

    public void setSavedSourceKeyUser(String str) {
        this.savedSourceKeyUser = str;
    }

    public void setStatus(Integer num) {
        this.status = num;
    }

    public void setTotalBytes(Long l) {
        this.totalBytes = l;
    }

    public void setUri(String str) {
        this.uri = str;
    }

    public void setVisibility(Integer num) {
        this.visibility = num;
    }
}
