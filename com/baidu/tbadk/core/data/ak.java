package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public class ak {
    private long agL;
    private String agM;
    private String content;
    private String link;
    private String stat;
    private long taskId;

    public ak() {
        this.agL = -1L;
        this.link = null;
        this.content = null;
        this.agM = null;
        this.stat = "";
        this.taskId = -1L;
    }

    public ak(long j, long j2, String str, String str2, String str3) {
        this.agL = -1L;
        this.link = null;
        this.content = null;
        this.agM = null;
        this.stat = "";
        this.taskId = -1L;
        this.agL = j;
        this.taskId = j2;
        this.link = str;
        this.content = str2;
        this.stat = str3;
    }

    public String getStat() {
        return this.stat;
    }

    public long uq() {
        return this.agL;
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
