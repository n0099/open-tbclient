package com.baidu.searchbox.v8engine.filesystem;

import android.webkit.ValueCallback;
/* loaded from: classes2.dex */
public interface V8FileSystemDelegatePolicy {
    void destroy();

    void loadFileFromUrl(String str, ValueCallback valueCallback);
}
