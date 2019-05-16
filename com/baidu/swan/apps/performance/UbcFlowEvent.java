package com.baidu.swan.apps.performance;

import java.util.Locale;
/* loaded from: classes2.dex */
public class UbcFlowEvent {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final String id;
    private long mTime = System.currentTimeMillis();
    private String mValue = "";
    private String aGg = "NA";
    private RecordType aGh = RecordType.KEEP;
    private boolean aGi = false;

    /* loaded from: classes2.dex */
    public enum RecordType {
        KEEP,
        UPDATE,
        UPDATE_RECENT,
        UPDATE_EARLIER
    }

    public UbcFlowEvent(String str) {
        this.id = str;
    }

    public UbcFlowEvent M(long j) {
        if (j < 0) {
            j = 0;
        }
        this.mTime = j;
        return this;
    }

    public long HZ() {
        return this.mTime;
    }

    public String value() {
        return this.mValue;
    }

    public UbcFlowEvent ga(String str) {
        this.aGg = str;
        return this;
    }

    public String Ia() {
        return this.aGg;
    }

    public boolean Ib() {
        return this.aGi;
    }

    public UbcFlowEvent a(RecordType recordType) {
        this.aGh = recordType;
        return this;
    }

    public RecordType Ic() {
        return this.aGh;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(HZ());
        objArr[1] = this.id;
        objArr[2] = Ib() ? "(justLocalRecord)" : "";
        return String.format(locale, "Event at %d id = %s %s", objArr);
    }
}
