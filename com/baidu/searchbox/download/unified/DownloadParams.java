package com.baidu.searchbox.download.unified;

import java.io.Serializable;
import java.util.Map;
/* loaded from: classes3.dex */
public class DownloadParams implements Serializable {
    public int destination;
    public String extraInfo;
    public String filePathHint;
    public Map<String, String> headers;
    public String mimeType;
    public String referer;
    public String title;
    public String url;
    public String userAgent;
    public boolean visibleInDownloadsUI;
    public int visibleInNotification;

    /* loaded from: classes3.dex */
    public static class Destination {
        public static final int CUSTOM_DIR = 4;
        public static final int DEFAULT_DIR = 0;
    }

    /* loaded from: classes3.dex */
    public static class VisibleInNotification {
        public static final int HIDDEN = 2;
        public static final int VISIBLE_PROGRESS = 0;
        public static final int VISIBLE_PROGRESS_AND_COMPLETED = 1;
    }

    public int getDestination() {
        return this.destination;
    }

    public String getExtraInfo() {
        return this.extraInfo;
    }

    public String getFilePathHint() {
        return this.filePathHint;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public String getReferer() {
        return this.referer;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public int getVisibleInNotification() {
        return this.visibleInNotification;
    }

    public boolean isVisibleInDownloadsUI() {
        return this.visibleInDownloadsUI;
    }

    public void setDestination(int i) {
        this.destination = i;
    }

    public void setExtraInfo(String str) {
        this.extraInfo = str;
    }

    public void setFilePathHint(String str) {
        this.filePathHint = str;
    }

    public void setHeaders(Map<String, String> map) {
        this.headers = map;
    }

    public void setMimeType(String str) {
        this.mimeType = str;
    }

    public void setReferer(String str) {
        this.referer = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setUserAgent(String str) {
        this.userAgent = str;
    }

    public void setVisibleInDownloadsUI(boolean z) {
        this.visibleInDownloadsUI = z;
    }

    public void setVisibleInNotification(int i) {
        this.visibleInNotification = i;
    }
}
