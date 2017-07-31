package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public class ap {
    private long XU;
    private String XV;
    private String content;
    private String link;
    private String stat;
    private long taskId;

    public ap() {
        this.XU = -1L;
        this.link = null;
        this.content = null;
        this.XV = null;
        this.stat = "";
        this.taskId = -1L;
    }

    public ap(long j, long j2, String str, String str2, String str3) {
        this.XU = -1L;
        this.link = null;
        this.content = null;
        this.XV = null;
        this.stat = "";
        this.taskId = -1L;
        this.XU = j;
        this.taskId = j2;
        this.link = str;
        this.content = str2;
        this.stat = str3;
    }

    public String getStat() {
        return this.stat;
    }

    public long qx() {
        return this.XU;
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
