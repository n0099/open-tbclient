package com.baidu.swan.apps.performance;

import java.util.Locale;
/* loaded from: classes11.dex */
public class UbcFlowEvent {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final String id;
    private long mTime = System.currentTimeMillis();
    private String mValue = "";
    private String bHN = "NA";
    private RecordType bHO = RecordType.KEEP;
    private boolean bHP = false;

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

    public long ZW() {
        return this.mTime;
    }

    public String value() {
        return this.mValue;
    }

    public UbcFlowEvent ke(String str) {
        this.bHN = str;
        return this;
    }

    public String ZX() {
        return this.bHN;
    }

    public UbcFlowEvent dg(boolean z) {
        this.bHP = z;
        return this;
    }

    public boolean ZY() {
        return this.bHP;
    }

    public UbcFlowEvent a(RecordType recordType) {
        this.bHO = recordType;
        return this;
    }

    public RecordType ZZ() {
        return this.bHO;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(ZW());
        objArr[1] = this.id;
        objArr[2] = ZY() ? "(justLocalRecord)" : "";
        return String.format(locale, "Event at %d id = %s %s", objArr);
    }
}
