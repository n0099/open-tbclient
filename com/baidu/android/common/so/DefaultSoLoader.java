package com.baidu.android.common.so;
/* loaded from: classes.dex */
public final class DefaultSoLoader implements ICallingSoLoader {
    public static DefaultSoLoader getDefaultSoLoader() {
        return new DefaultSoLoader();
    }

    @Override // com.baidu.android.common.so.ICallingSoLoader
    public void load(String str) {
        System.load(str);
    }

    @Override // com.baidu.android.common.so.ICallingSoLoader
    public void loadLibrary(String str) {
        System.loadLibrary(str);
    }
}
