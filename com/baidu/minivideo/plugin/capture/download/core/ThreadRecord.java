package com.baidu.minivideo.plugin.capture.download.core;
/* loaded from: classes17.dex */
public class ThreadRecord {
    private long end;
    private long finished;
    private int id;
    private long start;
    private String tag;
    private String uri;

    public ThreadRecord() {
    }

    public ThreadRecord(int i, String str, String str2, long j) {
        this(i, str, str2, 0L, 0L, j);
    }

    public ThreadRecord(int i, String str, String str2, long j, long j2, long j3) {
        this.id = i;
        this.tag = str;
        this.uri = str2;
        this.start = j;
        this.end = j2;
        this.finished = j3;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public String getUri() {
        return this.uri;
    }

    public void setUri(String str) {
        this.uri = str;
    }

    public long getStart() {
        return this.start;
    }

    public void setStart(long j) {
        this.start = j;
    }

    public long getEnd() {
        return this.end;
    }

    public void setEnd(long j) {
        this.end = j;
    }

    public long getFinished() {
        return this.finished;
    }

    public void setFinished(long j) {
        this.finished = j;
    }
}
