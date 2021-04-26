package com.baidu.android.util;
/* loaded from: classes.dex */
public interface IKVStorageControl {
    public static final IKVStorageControl EMPTY = new IKVStorageControl() { // from class: com.baidu.android.util.IKVStorageControl.1
        @Override // com.baidu.android.util.IKVStorageControl
        public String getKVStoragePath() {
            return null;
        }

        @Override // com.baidu.android.util.IKVStorageControl
        public int getKVStorageType() {
            return 0;
        }
    };
    public static final int KV_STORAGE_TYPE_BOTH = 2;
    public static final int KV_STORAGE_TYPE_OPT = 1;
    public static final int KV_STORAGE_TYPE_ORIGIN = 0;

    String getKVStoragePath();

    int getKVStorageType();
}
