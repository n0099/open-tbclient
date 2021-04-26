package com.baidu.android.util;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
@Autowired
/* loaded from: classes.dex */
public class KVStorageRuntime {
    @Inject(force = false)
    public static IKVStorageControl getKVStorageControl() {
        return IKVStorageControl.EMPTY;
    }

    @Inject(force = false)
    public static IKVStorageProxy getKVStorageProxy() {
        return IKVStorageProxy.EMPTY;
    }
}
