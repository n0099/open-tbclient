package com.baidu.minivideo.plugin.capture.download.core;

import java.io.File;
/* loaded from: classes2.dex */
public class DownloadInfo {
    public boolean acceptRanges;
    public File dir;
    public long finished;
    public long length;
    public String name;
    public int progress;
    public String uri;

    public DownloadInfo() {
    }

    public File getDir() {
        return this.dir;
    }

    public long getFinished() {
        return this.finished;
    }

    public long getLength() {
        return this.length;
    }

    public String getName() {
        return this.name;
    }

    public int getProgress() {
        return this.progress;
    }

    public String getUri() {
        return this.uri;
    }

    public boolean isAcceptRanges() {
        return this.acceptRanges;
    }

    public void setAcceptRanges(boolean z) {
        this.acceptRanges = z;
    }

    public void setDir(File file) {
        this.dir = file;
    }

    public void setFinished(long j) {
        this.finished = j;
    }

    public void setLength(long j) {
        this.length = j;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setProgress(int i2) {
        this.progress = i2;
    }

    public void setUri(String str) {
        this.uri = str;
    }

    public DownloadInfo(String str, String str2, File file) {
        this.name = str;
        this.uri = str2;
        this.dir = file;
    }
}
