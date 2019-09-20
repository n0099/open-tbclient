package com.baidu.swan.games.e.c;

import android.webkit.ValueCallback;
import com.baidu.searchbox.v8engine.filesystem.V8FileSystemDelegatePolicy;
/* loaded from: classes2.dex */
public class d implements V8FileSystemDelegatePolicy {
    @Override // com.baidu.searchbox.v8engine.filesystem.V8FileSystemDelegatePolicy
    public void loadFileFromUrl(String str, ValueCallback<String> valueCallback) {
        b.RW().a(str, valueCallback);
    }

    @Override // com.baidu.searchbox.v8engine.filesystem.V8FileSystemDelegatePolicy
    public void destroy() {
    }
}
