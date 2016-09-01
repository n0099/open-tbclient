package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public class ai {
    private long RK;
    private String RL;
    private String content;
    private String link;
    private String stat;
    private long taskId;

    public ai() {
        this.RK = -1L;
        this.link = null;
        this.content = null;
        this.RL = null;
        this.stat = "";
        this.taskId = -1L;
    }

    public ai(long j, long j2, String str, String str2, String str3) {
        this.RK = -1L;
        this.link = null;
        this.content = null;
        this.RL = null;
        this.stat = "";
        this.taskId = -1L;
        this.RK = j;
        this.taskId = j2;
        this.link = str;
        this.content = str2;
        this.stat = str3;
    }

    public String getStat() {
        return this.stat;
    }

    public long qk() {
        return this.RK;
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
