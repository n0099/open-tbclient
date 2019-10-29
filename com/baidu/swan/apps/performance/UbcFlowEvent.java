package com.baidu.swan.apps.performance;

import java.util.Locale;
/* loaded from: classes2.dex */
public class UbcFlowEvent {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final String id;
    private long mTime = System.currentTimeMillis();
    private String mValue = "";
    private String baA = "NA";
    private RecordType baB = RecordType.KEEP;
    private boolean baC = false;

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

    public UbcFlowEvent af(long j) {
        if (j < 0) {
            j = 0;
        }
        this.mTime = j;
        return this;
    }

    public long NK() {
        return this.mTime;
    }

    public String value() {
        return this.mValue;
    }

    public UbcFlowEvent gM(String str) {
        this.baA = str;
        return this;
    }

    public String NL() {
        return this.baA;
    }

    public boolean NM() {
        return this.baC;
    }

    public UbcFlowEvent a(RecordType recordType) {
        this.baB = recordType;
        return this;
    }

    public RecordType NN() {
        return this.baB;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(NK());
        objArr[1] = this.id;
        objArr[2] = NM() ? "(justLocalRecord)" : "";
        return String.format(locale, "Event at %d id = %s %s", objArr);
    }
}
