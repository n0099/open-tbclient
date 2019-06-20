package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public class al {
    private long bGP;
    private String bGQ;
    private String content;
    private String link;
    private String stat;
    private long taskId;

    public al() {
        this.bGP = -1L;
        this.link = null;
        this.content = null;
        this.bGQ = null;
        this.stat = "";
        this.taskId = -1L;
    }

    public al(long j, long j2, String str, String str2, String str3) {
        this.bGP = -1L;
        this.link = null;
        this.content = null;
        this.bGQ = null;
        this.stat = "";
        this.taskId = -1L;
        this.bGP = j;
        this.taskId = j2;
        this.link = str;
        this.content = str2;
        this.stat = str3;
    }

    public String getStat() {
        return this.stat;
    }

    public long aci() {
        return this.bGP;
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
