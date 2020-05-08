package com.baidu.swan.apps.performance;

import java.util.Locale;
/* loaded from: classes11.dex */
public class UbcFlowEvent {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final String id;
    private long mTime = System.currentTimeMillis();
    private String mValue = "";
    private String cgO = "NA";
    private RecordType cgP = RecordType.KEEP;
    private boolean cgQ = false;

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

    public long aid() {
        return this.mTime;
    }

    public String value() {
        return this.mValue;
    }

    public UbcFlowEvent lq(String str) {
        this.cgO = str;
        return this;
    }

    public String aie() {
        return this.cgO;
    }

    public UbcFlowEvent ed(boolean z) {
        this.cgQ = z;
        return this;
    }

    public boolean aif() {
        return this.cgQ;
    }

    public UbcFlowEvent a(RecordType recordType) {
        this.cgP = recordType;
        return this;
    }

    public RecordType aig() {
        return this.cgP;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(aid());
        objArr[1] = this.id;
        objArr[2] = aif() ? "(justLocalRecord)" : "";
        return String.format(locale, "Event at %d id = %s %s", objArr);
    }
}
