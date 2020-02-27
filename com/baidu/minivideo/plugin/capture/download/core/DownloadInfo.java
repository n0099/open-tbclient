package com.baidu.minivideo.plugin.capture.download.core;

import java.io.File;
/* loaded from: classes13.dex */
public class DownloadInfo {
    private boolean acceptRanges;
    private File dir;
    private long finished;
    private long length;
    private String name;
    private int progress;
    private String uri;

    public DownloadInfo() {
    }

    public DownloadInfo(String str, String str2, File file) {
        this.name = str;
        this.uri = str2;
        this.dir = file;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getUri() {
        return this.uri;
    }

    public void setUri(String str) {
        this.uri = str;
    }

    public File getDir() {
        return this.dir;
    }

    public void setDir(File file) {
        this.dir = file;
    }

    public int getProgress() {
        return this.progress;
    }

    public void setProgress(int i) {
        this.progress = i;
    }

    public long getLength() {
        return this.length;
    }

    public void setLength(long j) {
        this.length = j;
    }

    public long getFinished() {
        return this.finished;
    }

    public void setFinished(long j) {
        this.finished = j;
    }

    public boolean isAcceptRanges() {
        return this.acceptRanges;
    }

    public void setAcceptRanges(boolean z) {
        this.acceptRanges = z;
    }
}
