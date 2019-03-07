package com.baidu.swan.apps.performance;

import java.util.Locale;
/* loaded from: classes2.dex */
public class UbcFlowEvent {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    public final String id;
    private long mTime = System.currentTimeMillis();
    private String mValue = "";
    private String aEj = "NA";
    private RecordType aEk = RecordType.KEEP;
    private boolean aEl = false;

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

    public long FT() {
        return this.mTime;
    }

    public String value() {
        return this.mValue;
    }

    public UbcFlowEvent fK(String str) {
        this.aEj = str;
        return this;
    }

    public String FU() {
        return this.aEj;
    }

    public boolean FV() {
        return this.aEl;
    }

    public UbcFlowEvent a(RecordType recordType) {
        this.aEk = recordType;
        return this;
    }

    public RecordType FW() {
        return this.aEk;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(FT());
        objArr[1] = this.id;
        objArr[2] = FV() ? "(justLocalRecord)" : "";
        return String.format(locale, "Event at %d id = %s %s", objArr);
    }
}
