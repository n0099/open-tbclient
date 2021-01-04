package com.baidu.minivideo.plugin.capture.download;

import java.io.Serializable;
/* loaded from: classes3.dex */
public class RequestTask implements Serializable {
    public static final int STATUS_COMPLETE = 6;
    public static final int STATUS_CONNECTING = 1;
    public static final int STATUS_CONNECT_ERROR = 2;
    public static final int STATUS_DOWNLOADING = 3;
    public static final int STATUS_DOWNLOAD_ERROR = 5;
    public static final int STATUS_NOT_DOWNLOAD = 0;
    public static final int STATUS_PAUSED = 4;
    private int progress;
    private String savePath;
    private String name = "";
    private String id = "";
    private String image = "";
    private String url = "";
    private String downloadPerSize = "";
    private int status = 0;

    public static RequestTask createTaskWithUrl(String str) {
        RequestTask requestTask = new RequestTask();
        requestTask.url = str;
        return requestTask;
    }

    public static RequestTask createTaskWithUrlAndCover(String str, String str2) {
        RequestTask requestTask = new RequestTask();
        requestTask.url = str2;
        requestTask.image = str;
        return requestTask;
    }

    public static RequestTask createDetailTask(String str, String str2, String str3, String str4) {
        RequestTask requestTask = new RequestTask();
        requestTask.url = str4;
        requestTask.image = str3;
        requestTask.id = str;
        requestTask.name = str2;
        return requestTask;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String str) {
        this.image = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getDownloadPerSize() {
        return this.downloadPerSize;
    }

    public void setDownloadPerSize(String str) {
        this.downloadPerSize = str;
    }

    public int getProgress() {
        return this.progress;
    }

    public void setProgress(int i) {
        this.progress = i;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public String getSavePath() {
        return this.savePath;
    }

    public void setSavePath(String str) {
        this.savePath = str;
    }
}
