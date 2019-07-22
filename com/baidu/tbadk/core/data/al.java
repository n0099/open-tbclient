package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public class al {
    private long bHP;
    private String bHQ;
    private String content;
    private String link;
    private String stat;
    private long taskId;

    public al() {
        this.bHP = -1L;
        this.link = null;
        this.content = null;
        this.bHQ = null;
        this.stat = "";
        this.taskId = -1L;
    }

    public al(long j, long j2, String str, String str2, String str3) {
        this.bHP = -1L;
        this.link = null;
        this.content = null;
        this.bHQ = null;
        this.stat = "";
        this.taskId = -1L;
        this.bHP = j;
        this.taskId = j2;
        this.link = str;
        this.content = str2;
        this.stat = str3;
    }

    public String getStat() {
        return this.stat;
    }

    public long adk() {
        return this.bHP;
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
