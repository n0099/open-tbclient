package com.baidu.live.tbadk.core.data;
@Deprecated
/* loaded from: classes3.dex */
public class NotificationData {
    private String content;
    private String link;
    private long messageID;
    private String stat;
    private long taskId;
    private String toId;

    public NotificationData() {
        this.messageID = -1L;
        this.link = null;
        this.content = null;
        this.toId = null;
        this.stat = "";
        this.taskId = -1L;
    }

    public NotificationData(long j, long j2, String str, String str2, String str3) {
        this.messageID = -1L;
        this.link = null;
        this.content = null;
        this.toId = null;
        this.stat = "";
        this.taskId = -1L;
        this.messageID = j;
        this.taskId = j2;
        this.link = str;
        this.content = str2;
        this.stat = str3;
    }

    public String getStat() {
        return this.stat;
    }

    public long getMessageID() {
        return this.messageID;
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

    public String getId() {
        return this.toId;
    }
}
