package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public class m {
    private long UT;
    private String UU;
    private String content;
    private String link;
    private String stat;
    private long taskId;

    public m() {
        this.UT = -1L;
        this.link = null;
        this.content = null;
        this.UU = null;
        this.stat = "";
        this.taskId = -1L;
    }

    public m(long j, long j2, String str, String str2, String str3) {
        this.UT = -1L;
        this.link = null;
        this.content = null;
        this.UU = null;
        this.stat = "";
        this.taskId = -1L;
        this.UT = j;
        this.taskId = j2;
        this.link = str;
        this.content = str2;
        this.stat = str3;
    }

    public String getStat() {
        return this.stat;
    }

    public long rG() {
        return this.UT;
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
