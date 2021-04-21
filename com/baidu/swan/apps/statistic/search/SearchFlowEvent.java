package com.baidu.swan.apps.statistic.search;
/* loaded from: classes3.dex */
public class SearchFlowEvent {

    /* renamed from: a  reason: collision with root package name */
    public String f12320a;

    /* renamed from: b  reason: collision with root package name */
    public long f12321b;

    /* renamed from: c  reason: collision with root package name */
    public String f12322c;

    /* renamed from: d  reason: collision with root package name */
    public String f12323d;

    /* renamed from: e  reason: collision with root package name */
    public EventType f12324e;

    /* loaded from: classes3.dex */
    public enum EventType {
        START,
        NORMAL,
        END
    }

    public SearchFlowEvent(String str) {
        this.f12320a = str;
        this.f12321b = System.currentTimeMillis();
        this.f12324e = EventType.NORMAL;
        this.f12322c = "";
        this.f12323d = "";
    }

    public String toString() {
        return "Event: id=" + this.f12320a + ", timestamp=" + this.f12321b + ", data=" + this.f12322c + ", extData=" + this.f12323d + ", eventType=" + this.f12324e.toString();
    }

    public SearchFlowEvent(String str, long j, String str2, String str3, EventType eventType) {
        this.f12320a = str;
        this.f12321b = j;
        this.f12322c = str2;
        this.f12323d = str3;
        this.f12324e = eventType;
    }
}
