package com.baidu.android.util.soloader;
/* loaded from: classes13.dex */
final class DefaultSoLoader implements ICallingSoLoader {
    private DefaultSoLoader() {
    }

    public static DefaultSoLoader getDefaultSoLoader() {
        return new DefaultSoLoader();
    }

    @Override // com.baidu.android.util.soloader.ICallingSoLoader
    public void load(String str) {
        System.load(str);
    }

    @Override // com.baidu.android.util.soloader.ICallingSoLoader
    public void loadLibrary(String str) {
        System.loadLibrary(str);
    }
}
