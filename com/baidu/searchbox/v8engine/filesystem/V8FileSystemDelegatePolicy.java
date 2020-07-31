package com.baidu.searchbox.v8engine.filesystem;

import android.webkit.ValueCallback;
import com.baidu.searchbox.v8engine.NotProguard;
@NotProguard
/* loaded from: classes10.dex */
public interface V8FileSystemDelegatePolicy {
    void destroy();

    void loadFileFromUrl(String str, ValueCallback<String> valueCallback);
}
