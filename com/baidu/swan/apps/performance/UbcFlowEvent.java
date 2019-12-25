package com.baidu.swan.apps.performance;

import java.util.Locale;
/* loaded from: classes9.dex */
public class UbcFlowEvent {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public final String id;
    private long mTime = System.currentTimeMillis();
    private String mValue = "";
    private String bCV = "NA";
    private RecordType bCW = RecordType.KEEP;
    private boolean bCX = false;

    /* loaded from: classes9.dex */
    public enum RecordType {
        KEEP,
        UPDATE,
        UPDATE_RECENT,
        UPDATE_EARLIER
    }

    public UbcFlowEvent(String str) {
        this.id = str;
    }

    public UbcFlowEvent an(long j) {
        if (j < 0) {
            j = 0;
        }
        this.mTime = j;
        return this;
    }

    public long Xj() {
        return this.mTime;
    }

    public String value() {
        return this.mValue;
    }

    public UbcFlowEvent jM(String str) {
        this.bCV = str;
        return this;
    }

    public String Xk() {
        return this.bCV;
    }

    public UbcFlowEvent cU(boolean z) {
        this.bCX = z;
        return this;
    }

    public boolean Xl() {
        return this.bCX;
    }

    public UbcFlowEvent a(RecordType recordType) {
        this.bCW = recordType;
        return this;
    }

    public RecordType Xm() {
        return this.bCW;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(Xj());
        objArr[1] = this.id;
        objArr[2] = Xl() ? "(justLocalRecord)" : "";
        return String.format(locale, "Event at %d id = %s %s", objArr);
    }
}
