package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public class p {
    private long PP;
    private String PQ;
    private String content;
    private String link;
    private String stat;
    private long taskId;

    public p() {
        this.PP = -1L;
        this.link = null;
        this.content = null;
        this.PQ = null;
        this.stat = "";
        this.taskId = -1L;
    }

    public p(long j, long j2, String str, String str2, String str3) {
        this.PP = -1L;
        this.link = null;
        this.content = null;
        this.PQ = null;
        this.stat = "";
        this.taskId = -1L;
        this.PP = j;
        this.taskId = j2;
        this.link = str;
        this.content = str2;
        this.stat = str3;
    }

    public String getStat() {
        return this.stat;
    }

    public long qg() {
        return this.PP;
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
