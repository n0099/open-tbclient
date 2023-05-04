package com.baidu.searchbox.util;

import com.baidu.android.util.IKVStorageControl;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.common.runtime.AppRuntime;
@Singleton
@Service
/* loaded from: classes2.dex */
public class KVStorageControlImpl implements IKVStorageControl {
    public static final String TAG = "KVStorageControlImpl";
    public static String rootDir;
    public int kvStorageType = 1;

    @Override // com.baidu.android.util.IKVStorageControl
    public String getKVStoragePath() {
        if (rootDir == null) {
            rootDir = AppRuntime.getAppContext().getDir(KVStorageUtils.PREFS_SEGMENT, 0).getAbsolutePath();
        }
        return rootDir;
    }

    @Override // com.baidu.android.util.IKVStorageControl
    public int getKVStorageType() {
        return this.kvStorageType;
    }
}
