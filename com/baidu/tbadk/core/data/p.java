package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public class p {
    private long PR;
    private String PT;
    private String content;
    private String link;
    private String stat;
    private long taskId;

    public p() {
        this.PR = -1L;
        this.link = null;
        this.content = null;
        this.PT = null;
        this.stat = "";
        this.taskId = -1L;
    }

    public p(long j, long j2, String str, String str2, String str3) {
        this.PR = -1L;
        this.link = null;
        this.content = null;
        this.PT = null;
        this.stat = "";
        this.taskId = -1L;
        this.PR = j;
        this.taskId = j2;
        this.link = str;
        this.content = str2;
        this.stat = str3;
    }

    public String getStat() {
        return this.stat;
    }

    public long qg() {
        return this.PR;
    }

    public long getTaskId() {
        return this.taskId;
    }

    public String getLink() {
        return this.link;
    }

    public String getContent() {
        return this.content;
    }
}
