package com.baidu.android.common.so;
/* loaded from: classes.dex */
final class DefaultSoLoader implements ICallingSoLoader {
    private DefaultSoLoader() {
    }

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
