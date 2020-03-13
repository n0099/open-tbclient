package com.baidu.swan.apps.performance;

import java.util.Locale;
/* loaded from: classes11.dex */
public class UbcFlowEvent {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final String id;
    private long mTime = System.currentTimeMillis();
    private String mValue = "";
    private String bHO = "NA";
    private RecordType bHP = RecordType.KEEP;
    private boolean bHQ = false;

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
        this.bHO = str;
        return this;
    }

    public String ZX() {
        return this.bHO;
    }

    public UbcFlowEvent dg(boolean z) {
        this.bHQ = z;
        return this;
    }

    public boolean ZY() {
        return this.bHQ;
    }

    public UbcFlowEvent a(RecordType recordType) {
        this.bHP = recordType;
        return this;
    }

    public RecordType ZZ() {
        return this.bHP;
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
