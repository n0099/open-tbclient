package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public class aj {
    private long aNs;
    private String aNt;
    private String content;
    private String link;
    private String stat;
    private long taskId;

    public aj() {
        this.aNs = -1L;
        this.link = null;
        this.content = null;
        this.aNt = null;
        this.stat = "";
        this.taskId = -1L;
    }

    public aj(long j, long j2, String str, String str2, String str3) {
        this.aNs = -1L;
        this.link = null;
        this.content = null;
        this.aNt = null;
        this.stat = "";
        this.taskId = -1L;
        this.aNs = j;
        this.taskId = j2;
        this.link = str;
        this.content = str2;
        this.stat = str3;
    }

    public String getStat() {
        return this.stat;
    }

    public long yp() {
        return this.aNs;
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
