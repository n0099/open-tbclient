package com.baidu.swan.apps.performance;

import java.util.Locale;
/* loaded from: classes2.dex */
public class UbcFlowEvent {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final String id;
    private long mTime = System.currentTimeMillis();
    private String mValue = "";
    private String aEo = "NA";
    private RecordType aEp = RecordType.KEEP;
    private boolean aEq = false;

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

    public UbcFlowEvent A(long j) {
        if (j < 0) {
            j = 0;
        }
        this.mTime = j;
        return this;
    }

    public long FR() {
        return this.mTime;
    }

    public String value() {
        return this.mValue;
    }

    public UbcFlowEvent fL(String str) {
        this.aEo = str;
        return this;
    }

    public String FS() {
        return this.aEo;
    }

    public boolean FT() {
        return this.aEq;
    }

    public UbcFlowEvent a(RecordType recordType) {
        this.aEp = recordType;
        return this;
    }

    public RecordType FU() {
        return this.aEp;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(FR());
        objArr[1] = this.id;
        objArr[2] = FT() ? "(justLocalRecord)" : "";
        return String.format(locale, "Event at %d id = %s %s", objArr);
    }
}
