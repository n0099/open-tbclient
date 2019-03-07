package com.baidu.swan.apps.statistic.search;
/* loaded from: classes2.dex */
public class SearchFlowEvent {
    public EventType aSK;
    public String data;
    public String extData;
    public String id;
    public long timestamp;

    /* loaded from: classes2.dex */
    public enum EventType {
        START,
        NORMAL,
        END
    }

    public SearchFlowEvent(String str) {
        this.id = str;
        this.timestamp = System.currentTimeMillis();
        this.aSK = EventType.NORMAL;
        this.data = "";
        this.extData = "";
    }

    public SearchFlowEvent(String str, long j, String str2, String str3, EventType eventType) {
        this.id = str;
        this.timestamp = j;
        this.data = str2;
        this.extData = str3;
        this.aSK = eventType;
    }

    public String toString() {
        return "Event: id=" + this.id + ", timestamp=" + this.timestamp + ", data=" + this.data + ", extData=" + this.extData + ", eventType=" + this.aSK.toString();
    }
}
