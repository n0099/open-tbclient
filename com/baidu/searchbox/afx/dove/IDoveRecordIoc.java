package com.baidu.searchbox.afx.dove;
/* loaded from: classes3.dex */
public interface IDoveRecordIoc {
    public static final IDoveRecordIoc EMPTY = new IDoveRecordIoc() { // from class: com.baidu.searchbox.afx.dove.IDoveRecordIoc.1
        @Override // com.baidu.searchbox.afx.dove.IDoveRecordIoc
        public void initRecord() {
        }

        @Override // com.baidu.searchbox.afx.dove.IDoveRecordIoc
        public void recordTask() {
        }
    };

    void initRecord();

    void recordTask();
}
