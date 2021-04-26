package com.baidu.minivideo.plugin.capture.download.core;
/* loaded from: classes2.dex */
public class ThreadRecord {
    public long end;
    public long finished;
    public int id;
    public long start;
    public String tag;
    public String uri;

    public ThreadRecord() {
    }

    public long getEnd() {
        return this.end;
    }

    public long getFinished() {
        return this.finished;
    }

    public int getId() {
        return this.id;
    }

    public long getStart() {
        return this.start;
    }

    public String getTag() {
        return this.tag;
    }

    public String getUri() {
        return this.uri;
    }

    public void setEnd(long j) {
        this.end = j;
    }

    public void setFinished(long j) {
        this.finished = j;
    }

    public void setId(int i2) {
        this.id = i2;
    }

    public void setStart(long j) {
        this.start = j;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public void setUri(String str) {
        this.uri = str;
    }

    public ThreadRecord(int i2, String str, String str2, long j) {
        this(i2, str, str2, 0L, 0L, j);
    }

    public ThreadRecord(int i2, String str, String str2, long j, long j2, long j3) {
        this.id = i2;
        this.tag = str;
        this.uri = str2;
        this.start = j;
        this.end = j2;
        this.finished = j3;
    }
}
