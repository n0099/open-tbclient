package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public class ao {
    private long WF;
    private String WG;
    private String content;
    private String link;
    private String stat;
    private long taskId;

    public ao() {
        this.WF = -1L;
        this.link = null;
        this.content = null;
        this.WG = null;
        this.stat = "";
        this.taskId = -1L;
    }

    public ao(long j, long j2, String str, String str2, String str3) {
        this.WF = -1L;
        this.link = null;
        this.content = null;
        this.WG = null;
        this.stat = "";
        this.taskId = -1L;
        this.WF = j;
        this.taskId = j2;
        this.link = str;
        this.content = str2;
        this.stat = str3;
    }

    public String getStat() {
        return this.stat;
    }

    public long qK() {
        return this.WF;
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
