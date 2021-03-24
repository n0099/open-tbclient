package com.baidu.swan.apps.statistic.search;
/* loaded from: classes3.dex */
public class SearchFlowEvent {

    /* renamed from: a  reason: collision with root package name */
    public String f12650a;

    /* renamed from: b  reason: collision with root package name */
    public long f12651b;

    /* renamed from: c  reason: collision with root package name */
    public String f12652c;

    /* renamed from: d  reason: collision with root package name */
    public String f12653d;

    /* renamed from: e  reason: collision with root package name */
    public EventType f12654e;

    /* loaded from: classes3.dex */
    public enum EventType {
        START,
        NORMAL,
        END
    }

    public SearchFlowEvent(String str) {
        this.f12650a = str;
        this.f12651b = System.currentTimeMillis();
        this.f12654e = EventType.NORMAL;
        this.f12652c = "";
        this.f12653d = "";
    }

    public String toString() {
        return "Event: id=" + this.f12650a + ", timestamp=" + this.f12651b + ", data=" + this.f12652c + ", extData=" + this.f12653d + ", eventType=" + this.f12654e.toString();
    }

    public SearchFlowEvent(String str, long j, String str2, String str3, EventType eventType) {
        this.f12650a = str;
        this.f12651b = j;
        this.f12652c = str2;
        this.f12653d = str3;
        this.f12654e = eventType;
    }
}
