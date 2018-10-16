package com.baidu.searchbox.ng.ai.apps.statistic.search;
/* loaded from: classes2.dex */
public class SearchFlowEvent {
    public static final String ERR_TYPE_BACK = "custom_return";
    public static final String ERR_TYPE_DEVELOP_ERR = "develop_error";
    public static final String ERR_TYPE_SWAN_ERR = "swan_error";
    public static final String ID_DOM_CLICK = "dom_click";
    public static final String ID_DOM_FIRST_PAINT = "dom_first_paint";
    public static final String ID_NOT_REACH = "nreach";
    public String data;
    public EventType eventType;
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
        this.eventType = EventType.NORMAL;
        this.data = "";
        this.extData = "";
    }

    public SearchFlowEvent(String str, long j, String str2, String str3, EventType eventType) {
        this.id = str;
        this.timestamp = j;
        this.data = str2;
        this.extData = str3;
        this.eventType = eventType;
    }

    public String toString() {
        return "Event: id=" + this.id + ", timestamp=" + this.timestamp + ", data=" + this.data + ", extData=" + this.extData + ", eventType=" + this.eventType.toString();
    }
}
