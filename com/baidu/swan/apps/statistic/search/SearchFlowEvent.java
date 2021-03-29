package com.baidu.swan.apps.statistic.search;
/* loaded from: classes2.dex */
public class SearchFlowEvent {

    /* renamed from: a  reason: collision with root package name */
    public String f12651a;

    /* renamed from: b  reason: collision with root package name */
    public long f12652b;

    /* renamed from: c  reason: collision with root package name */
    public String f12653c;

    /* renamed from: d  reason: collision with root package name */
    public String f12654d;

    /* renamed from: e  reason: collision with root package name */
    public EventType f12655e;

    /* loaded from: classes2.dex */
    public enum EventType {
        START,
        NORMAL,
        END
    }

    public SearchFlowEvent(String str) {
        this.f12651a = str;
        this.f12652b = System.currentTimeMillis();
        this.f12655e = EventType.NORMAL;
        this.f12653c = "";
        this.f12654d = "";
    }

    public String toString() {
        return "Event: id=" + this.f12651a + ", timestamp=" + this.f12652b + ", data=" + this.f12653c + ", extData=" + this.f12654d + ", eventType=" + this.f12655e.toString();
    }

    public SearchFlowEvent(String str, long j, String str2, String str3, EventType eventType) {
        this.f12651a = str;
        this.f12652b = j;
        this.f12653c = str2;
        this.f12654d = str3;
        this.f12655e = eventType;
    }
}
