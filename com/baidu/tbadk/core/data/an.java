package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public class an {
    private long Xn;
    private String Xo;
    private String content;
    private String link;
    private String stat;
    private long taskId;

    public an() {
        this.Xn = -1L;
        this.link = null;
        this.content = null;
        this.Xo = null;
        this.stat = "";
        this.taskId = -1L;
    }

    public an(long j, long j2, String str, String str2, String str3) {
        this.Xn = -1L;
        this.link = null;
        this.content = null;
        this.Xo = null;
        this.stat = "";
        this.taskId = -1L;
        this.Xn = j;
        this.taskId = j2;
        this.link = str;
        this.content = str2;
        this.stat = str3;
    }

    public String getStat() {
        return this.stat;
    }

    public long ql() {
        return this.Xn;
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
