package com.baidu.swan.apps.performance;

import java.util.Locale;
/* loaded from: classes11.dex */
public class UbcFlowEvent {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final String id;
    private long mTime = System.currentTimeMillis();
    private String mValue = "";
    private String bHZ = "NA";
    private RecordType bIa = RecordType.KEEP;
    private boolean bIb = false;

    /* loaded from: classes11.dex */
    public enum RecordType {
        KEEP,
        UPDATE,
        UPDATE_RECENT,
        UPDATE_EARLIER
    }

    public UbcFlowEvent(String str) {
        this.id = str;
    }

    public UbcFlowEvent au(long j) {
        if (j < 0) {
            j = 0;
        }
        this.mTime = j;
        return this;
    }

    public long ZZ() {
        return this.mTime;
    }

    public String value() {
        return this.mValue;
    }

    public UbcFlowEvent kd(String str) {
        this.bHZ = str;
        return this;
    }

    public String aaa() {
        return this.bHZ;
    }

    public UbcFlowEvent dh(boolean z) {
        this.bIb = z;
        return this;
    }

    public boolean aab() {
        return this.bIb;
    }

    public UbcFlowEvent a(RecordType recordType) {
        this.bIa = recordType;
        return this;
    }

    public RecordType aac() {
        return this.bIa;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(ZZ());
        objArr[1] = this.id;
        objArr[2] = aab() ? "(justLocalRecord)" : "";
        return String.format(locale, "Event at %d id = %s %s", objArr);
    }
}
