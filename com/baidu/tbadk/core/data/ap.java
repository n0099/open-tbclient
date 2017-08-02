package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public class ap {
    private long Wy;
    private String Wz;
    private String content;
    private String link;
    private String stat;
    private long taskId;

    public ap() {
        this.Wy = -1L;
        this.link = null;
        this.content = null;
        this.Wz = null;
        this.stat = "";
        this.taskId = -1L;
    }

    public ap(long j, long j2, String str, String str2, String str3) {
        this.Wy = -1L;
        this.link = null;
        this.content = null;
        this.Wz = null;
        this.stat = "";
        this.taskId = -1L;
        this.Wy = j;
        this.taskId = j2;
        this.link = str;
        this.content = str2;
        this.stat = str3;
    }

    public String getStat() {
        return this.stat;
    }

    public long qn() {
        return this.Wy;
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
