package com.baidu.searchbox.ng.ai.apps.performance;

import java.util.Locale;
/* loaded from: classes2.dex */
public class UbcFlowEvent {
    private static final boolean DEBUG = false;
    private static final String TAG = "UbcFlowEvent";
    public final String id;
    private long mTime = System.currentTimeMillis();
    private String mValue = "";
    private String mSrcType = "NA";
    private RecordType mRecordType = RecordType.KEEP;
    private boolean mFlagLocalRecord = false;

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

    public UbcFlowEvent time(long j) {
        if (j < 0) {
            j = 0;
        }
        this.mTime = j;
        return this;
    }

    public long time() {
        return this.mTime;
    }

    public UbcFlowEvent value(String str) {
        this.mValue = str;
        return this;
    }

    public String value() {
        return this.mValue;
    }

    public UbcFlowEvent srcType(String str) {
        this.mSrcType = str;
        return this;
    }

    public String srcType() {
        return this.mSrcType;
    }

    public UbcFlowEvent justLocalRecord(boolean z) {
        this.mFlagLocalRecord = z;
        return this;
    }

    public boolean justLocalRecord() {
        return this.mFlagLocalRecord;
    }

    public UbcFlowEvent recordType(RecordType recordType) {
        this.mRecordType = recordType;
        return this;
    }

    public RecordType recordType() {
        return this.mRecordType;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(time());
        objArr[1] = this.id;
        objArr[2] = justLocalRecord() ? "(justLocalRecord)" : "";
        return String.format(locale, "Event at %d id = %s %s", objArr);
    }
}
