package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public class aj {
    private long asg;
    private String ash;
    private String content;
    private String link;
    private String stat;
    private long taskId;

    public aj() {
        this.asg = -1L;
        this.link = null;
        this.content = null;
        this.ash = null;
        this.stat = "";
        this.taskId = -1L;
    }

    public aj(long j, long j2, String str, String str2, String str3) {
        this.asg = -1L;
        this.link = null;
        this.content = null;
        this.ash = null;
        this.stat = "";
        this.taskId = -1L;
        this.asg = j;
        this.taskId = j2;
        this.link = str;
        this.content = str2;
        this.stat = str3;
    }

    public String getStat() {
        return this.stat;
    }

    public long yI() {
        return this.asg;
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
