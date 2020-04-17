package com.baidu.swan.apps.performance;

import java.util.Locale;
/* loaded from: classes11.dex */
public class UbcFlowEvent {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final String id;
    private long mTime = System.currentTimeMillis();
    private String mValue = "";
    private String cgI = "NA";
    private RecordType cgJ = RecordType.KEEP;
    private boolean cgK = false;

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

    public UbcFlowEvent aZ(long j) {
        if (j < 0) {
            j = 0;
        }
        this.mTime = j;
        return this;
    }

    public long aie() {
        return this.mTime;
    }

    public String value() {
        return this.mValue;
    }

    public UbcFlowEvent lq(String str) {
        this.cgI = str;
        return this;
    }

    public String aif() {
        return this.cgI;
    }

    public UbcFlowEvent ed(boolean z) {
        this.cgK = z;
        return this;
    }

    public boolean aig() {
        return this.cgK;
    }

    public UbcFlowEvent a(RecordType recordType) {
        this.cgJ = recordType;
        return this;
    }

    public RecordType aih() {
        return this.cgJ;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(aie());
        objArr[1] = this.id;
        objArr[2] = aig() ? "(justLocalRecord)" : "";
        return String.format(locale, "Event at %d id = %s %s", objArr);
    }
}
