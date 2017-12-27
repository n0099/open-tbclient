package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public class ak {
    private long aMa;
    private String aMb;
    private String content;
    private String link;
    private String stat;
    private long taskId;

    public ak() {
        this.aMa = -1L;
        this.link = null;
        this.content = null;
        this.aMb = null;
        this.stat = "";
        this.taskId = -1L;
    }

    public ak(long j, long j2, String str, String str2, String str3) {
        this.aMa = -1L;
        this.link = null;
        this.content = null;
        this.aMb = null;
        this.stat = "";
        this.taskId = -1L;
        this.aMa = j;
        this.taskId = j2;
        this.link = str;
        this.content = str2;
        this.stat = str3;
    }

    public String getStat() {
        return this.stat;
    }

    public long xP() {
        return this.aMa;
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
