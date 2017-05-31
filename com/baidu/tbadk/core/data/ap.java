package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public class ap {
    private long Wi;
    private String Wj;
    private String content;
    private String link;
    private String stat;
    private long taskId;

    public ap() {
        this.Wi = -1L;
        this.link = null;
        this.content = null;
        this.Wj = null;
        this.stat = "";
        this.taskId = -1L;
    }

    public ap(long j, long j2, String str, String str2, String str3) {
        this.Wi = -1L;
        this.link = null;
        this.content = null;
        this.Wj = null;
        this.stat = "";
        this.taskId = -1L;
        this.Wi = j;
        this.taskId = j2;
        this.link = str;
        this.content = str2;
        this.stat = str3;
    }

    public String getStat() {
        return this.stat;
    }

    public long qn() {
        return this.Wi;
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
