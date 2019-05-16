package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public class al {
    private long bGO;
    private String bGP;
    private String content;
    private String link;
    private String stat;
    private long taskId;

    public al() {
        this.bGO = -1L;
        this.link = null;
        this.content = null;
        this.bGP = null;
        this.stat = "";
        this.taskId = -1L;
    }

    public al(long j, long j2, String str, String str2, String str3) {
        this.bGO = -1L;
        this.link = null;
        this.content = null;
        this.bGP = null;
        this.stat = "";
        this.taskId = -1L;
        this.bGO = j;
        this.taskId = j2;
        this.link = str;
        this.content = str2;
        this.stat = str3;
    }

    public String getStat() {
        return this.stat;
    }

    public long aci() {
        return this.bGO;
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
