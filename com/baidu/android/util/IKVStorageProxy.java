package com.baidu.android.util;

import android.content.SharedPreferences;
/* loaded from: classes.dex */
public interface IKVStorageProxy {
    public static final IKVStorageProxy EMPTY = new IKVStorageProxy() { // from class: com.baidu.android.util.IKVStorageProxy.1
        @Override // com.baidu.android.util.IKVStorageProxy
        public SharedPreferences getProxy(String str) {
            return null;
        }
    };

    SharedPreferences getProxy(String str);
}
