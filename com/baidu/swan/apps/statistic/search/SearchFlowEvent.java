package com.baidu.swan.apps.statistic.search;
/* loaded from: classes3.dex */
public class SearchFlowEvent {

    /* renamed from: a  reason: collision with root package name */
    public String f12192a;

    /* renamed from: b  reason: collision with root package name */
    public long f12193b;

    /* renamed from: c  reason: collision with root package name */
    public String f12194c;

    /* renamed from: d  reason: collision with root package name */
    public String f12195d;

    /* renamed from: e  reason: collision with root package name */
    public EventType f12196e;

    /* loaded from: classes3.dex */
    public enum EventType {
        START,
        NORMAL,
        END
    }

    public SearchFlowEvent(String str) {
        this.f12192a = str;
        this.f12193b = System.currentTimeMillis();
        this.f12196e = EventType.NORMAL;
        this.f12194c = "";
        this.f12195d = "";
    }

    public String toString() {
        return "Event: id=" + this.f12192a + ", timestamp=" + this.f12193b + ", data=" + this.f12194c + ", extData=" + this.f12195d + ", eventType=" + this.f12196e.toString();
    }

    public SearchFlowEvent(String str, long j, String str2, String str3, EventType eventType) {
        this.f12192a = str;
        this.f12193b = j;
        this.f12194c = str2;
        this.f12195d = str3;
        this.f12196e = eventType;
    }
}
