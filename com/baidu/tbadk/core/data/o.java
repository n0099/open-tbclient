package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public class o {
    private long DZ;
    private String Ea;
    private String content;
    private String link;
    private String stat;
    private long taskId;

    public o() {
        this.DZ = -1L;
        this.link = null;
        this.content = null;
        this.Ea = null;
        this.stat = "";
        this.taskId = -1L;
    }

    public o(long j, long j2, String str, String str2, String str3) {
        this.DZ = -1L;
        this.link = null;
        this.content = null;
        this.Ea = null;
        this.stat = "";
        this.taskId = -1L;
        this.DZ = j;
        this.taskId = j2;
        this.link = str;
        this.content = str2;
        this.stat = str3;
    }

    public String getStat() {
        return this.stat;
    }

    public long mR() {
        return this.DZ;
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
