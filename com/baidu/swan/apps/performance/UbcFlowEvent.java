package com.baidu.swan.apps.performance;

import java.util.Locale;
/* loaded from: classes10.dex */
public class UbcFlowEvent {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final String id;
    private long mTime = System.currentTimeMillis();
    private String mValue = "";
    private String bDG = "NA";
    private RecordType bDH = RecordType.KEEP;
    private boolean bDI = false;

    /* loaded from: classes10.dex */
    public enum RecordType {
        KEEP,
        UPDATE,
        UPDATE_RECENT,
        UPDATE_EARLIER
    }

    public UbcFlowEvent(String str) {
        this.id = str;
    }

    public UbcFlowEvent aq(long j) {
        if (j < 0) {
            j = 0;
        }
        this.mTime = j;
        return this;
    }

    public long XG() {
        return this.mTime;
    }

    public String value() {
        return this.mValue;
    }

    public UbcFlowEvent jP(String str) {
        this.bDG = str;
        return this;
    }

    public String XH() {
        return this.bDG;
    }

    public UbcFlowEvent cZ(boolean z) {
        this.bDI = z;
        return this;
    }

    public boolean XI() {
        return this.bDI;
    }

    public UbcFlowEvent a(RecordType recordType) {
        this.bDH = recordType;
        return this;
    }

    public RecordType XJ() {
        return this.bDH;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(XG());
        objArr[1] = this.id;
        objArr[2] = XI() ? "(justLocalRecord)" : "";
        return String.format(locale, "Event at %d id = %s %s", objArr);
    }
}
