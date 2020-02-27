package com.baidu.swan.apps.performance;

import java.util.Locale;
/* loaded from: classes11.dex */
public class UbcFlowEvent {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final String id;
    private long mTime = System.currentTimeMillis();
    private String mValue = "";
    private String bHM = "NA";
    private RecordType bHN = RecordType.KEEP;
    private boolean bHO = false;

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

    public long ZU() {
        return this.mTime;
    }

    public String value() {
        return this.mValue;
    }

    public UbcFlowEvent ke(String str) {
        this.bHM = str;
        return this;
    }

    public String ZV() {
        return this.bHM;
    }

    public UbcFlowEvent dg(boolean z) {
        this.bHO = z;
        return this;
    }

    public boolean ZW() {
        return this.bHO;
    }

    public UbcFlowEvent a(RecordType recordType) {
        this.bHN = recordType;
        return this;
    }

    public RecordType ZX() {
        return this.bHN;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(ZU());
        objArr[1] = this.id;
        objArr[2] = ZW() ? "(justLocalRecord)" : "";
        return String.format(locale, "Event at %d id = %s %s", objArr);
    }
}
