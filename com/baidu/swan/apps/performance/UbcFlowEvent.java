package com.baidu.swan.apps.performance;

import java.util.Locale;
/* loaded from: classes2.dex */
public class UbcFlowEvent {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final String id;
    private long mTime = System.currentTimeMillis();
    private String mValue = "";
    private String aHm = "NA";
    private RecordType aHn = RecordType.KEEP;
    private boolean aHo = false;

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

    public long IQ() {
        return this.mTime;
    }

    public String value() {
        return this.mValue;
    }

    public UbcFlowEvent gh(String str) {
        this.aHm = str;
        return this;
    }

    public String IR() {
        return this.aHm;
    }

    public boolean IS() {
        return this.aHo;
    }

    public UbcFlowEvent a(RecordType recordType) {
        this.aHn = recordType;
        return this;
    }

    public RecordType IT() {
        return this.aHn;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(IQ());
        objArr[1] = this.id;
        objArr[2] = IS() ? "(justLocalRecord)" : "";
        return String.format(locale, "Event at %d id = %s %s", objArr);
    }
}
