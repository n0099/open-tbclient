package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public class n {
    private long UX;
    private String UY;
    private String content;
    private String link;
    private String stat;
    private long taskId;

    public n() {
        this.UX = -1L;
        this.link = null;
        this.content = null;
        this.UY = null;
        this.stat = "";
        this.taskId = -1L;
    }

    public n(long j, long j2, String str, String str2, String str3) {
        this.UX = -1L;
        this.link = null;
        this.content = null;
        this.UY = null;
        this.stat = "";
        this.taskId = -1L;
        this.UX = j;
        this.taskId = j2;
        this.link = str;
        this.content = str2;
        this.stat = str3;
    }

    public String getStat() {
        return this.stat;
    }

    public long rF() {
        return this.UX;
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
