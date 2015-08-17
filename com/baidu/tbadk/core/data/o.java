package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public class o {
    private long Vf;
    private String Vg;
    private String content;
    private String link;
    private String stat;
    private long taskId;

    public o() {
        this.Vf = -1L;
        this.link = null;
        this.content = null;
        this.Vg = null;
        this.stat = "";
        this.taskId = -1L;
    }

    public o(long j, long j2, String str, String str2, String str3) {
        this.Vf = -1L;
        this.link = null;
        this.content = null;
        this.Vg = null;
        this.stat = "";
        this.taskId = -1L;
        this.Vf = j;
        this.taskId = j2;
        this.link = str;
        this.content = str2;
        this.stat = str3;
    }

    public String getStat() {
        return this.stat;
    }

    public long rO() {
        return this.Vf;
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
