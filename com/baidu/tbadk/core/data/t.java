package com.baidu.tbadk.core.data;
/* loaded from: classes.dex */
public class t {
    private long VO;
    private String VP;
    private String content;
    private String link;
    private String stat;
    private long taskId;

    public t() {
        this.VO = -1L;
        this.link = null;
        this.content = null;
        this.VP = null;
        this.stat = "";
        this.taskId = -1L;
    }

    public t(long j, long j2, String str, String str2, String str3) {
        this.VO = -1L;
        this.link = null;
        this.content = null;
        this.VP = null;
        this.stat = "";
        this.taskId = -1L;
        this.VO = j;
        this.taskId = j2;
        this.link = str;
        this.content = str2;
        this.stat = str3;
    }

    public String getStat() {
        return this.stat;
    }

    public long sp() {
        return this.VO;
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
