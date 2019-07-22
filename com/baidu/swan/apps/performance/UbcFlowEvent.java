package com.baidu.swan.apps.performance;

import java.util.Locale;
/* loaded from: classes2.dex */
public class UbcFlowEvent {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final String id;
    private long mTime = System.currentTimeMillis();
    private String mValue = "";
    private String aGO = "NA";
    private RecordType aGP = RecordType.KEEP;
    private boolean aGQ = false;

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

    public long IM() {
        return this.mTime;
    }

    public String value() {
        return this.mValue;
    }

    public UbcFlowEvent gf(String str) {
        this.aGO = str;
        return this;
    }

    public String IN() {
        return this.aGO;
    }

    public boolean IO() {
        return this.aGQ;
    }

    public UbcFlowEvent a(RecordType recordType) {
        this.aGP = recordType;
        return this;
    }

    public RecordType IP() {
        return this.aGP;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(IM());
        objArr[1] = this.id;
        objArr[2] = IO() ? "(justLocalRecord)" : "";
        return String.format(locale, "Event at %d id = %s %s", objArr);
    }
}
