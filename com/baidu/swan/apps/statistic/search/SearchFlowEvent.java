package com.baidu.swan.apps.statistic.search;
/* loaded from: classes3.dex */
public class SearchFlowEvent {

    /* renamed from: a  reason: collision with root package name */
    public String f12312a;

    /* renamed from: b  reason: collision with root package name */
    public long f12313b;

    /* renamed from: c  reason: collision with root package name */
    public String f12314c;

    /* renamed from: d  reason: collision with root package name */
    public String f12315d;

    /* renamed from: e  reason: collision with root package name */
    public EventType f12316e;

    /* loaded from: classes3.dex */
    public enum EventType {
        START,
        NORMAL,
        END
    }

    public SearchFlowEvent(String str) {
        this.f12312a = str;
        this.f12313b = System.currentTimeMillis();
        this.f12316e = EventType.NORMAL;
        this.f12314c = "";
        this.f12315d = "";
    }

    public String toString() {
        return "Event: id=" + this.f12312a + ", timestamp=" + this.f12313b + ", data=" + this.f12314c + ", extData=" + this.f12315d + ", eventType=" + this.f12316e.toString();
    }

    public SearchFlowEvent(String str, long j, String str2, String str3, EventType eventType) {
        this.f12312a = str;
        this.f12313b = j;
        this.f12314c = str2;
        this.f12315d = str3;
        this.f12316e = eventType;
    }
}
