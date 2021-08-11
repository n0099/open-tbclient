package com.baidu.searchbox.v8engine.net;

import java.util.Map;
/* loaded from: classes5.dex */
public interface NetRequestCallback {
    public static final int FAILED = 1;
    public static final int NONE = -1;
    public static final int SUCCEEDED = 0;

    void onFailed(int i2, String str);

    void onSucceeded(String str, int i2, Map<String, String> map);
}
