package com.baidu.swan.apps.statistic.search;
/* loaded from: classes11.dex */
public class SearchFlowEvent {
    public EventType cGJ;
    public String data;
    public String extData;
    public String id;
    public long timestamp;

    /* loaded from: classes11.dex */
    public enum EventType {
        START,
        NORMAL,
        END
    }

    public SearchFlowEvent(String str) {
        this.id = str;
        this.timestamp = System.currentTimeMillis();
        this.cGJ = EventType.NORMAL;
        this.data = "";
        this.extData = "";
    }

    public SearchFlowEvent(String str, long j, String str2, String str3, EventType eventType) {
        this.id = str;
        this.timestamp = j;
        this.data = str2;
        this.extData = str3;
        this.cGJ = eventType;
    }

    public String toString() {
        return "Event: id=" + this.id + ", timestamp=" + this.timestamp + ", data=" + this.data + ", extData=" + this.extData + ", eventType=" + this.cGJ.toString();
    }
}
