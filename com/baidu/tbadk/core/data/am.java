package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public class am {
    private long Sn;
    private String So;
    private String content;
    private String link;
    private String stat;
    private long taskId;

    public am() {
        this.Sn = -1L;
        this.link = null;
        this.content = null;
        this.So = null;
        this.stat = "";
        this.taskId = -1L;
    }

    public am(long j, long j2, String str, String str2, String str3) {
        this.Sn = -1L;
        this.link = null;
        this.content = null;
        this.So = null;
        this.stat = "";
        this.taskId = -1L;
        this.Sn = j;
        this.taskId = j2;
        this.link = str;
        this.content = str2;
        this.stat = str3;
    }

    public String getStat() {
        return this.stat;
    }

    public long qx() {
        return this.Sn;
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
