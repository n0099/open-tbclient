package com.baidu.live.tbadk.load.library;
/* loaded from: classes6.dex */
public class LoadLibraryManager {
    private ILoadLibraryCallback mCallback;

    public static LoadLibraryManager getInstance() {
        return InstanceHolder.sInst;
    }

    public void init(ILoadLibraryCallback iLoadLibraryCallback) {
        this.mCallback = iLoadLibraryCallback;
    }

    public ILoadLibraryCallback getLoadLibraryCallback() {
        return this.mCallback;
    }

    /* loaded from: classes6.dex */
    public static class InstanceHolder {
        private static final LoadLibraryManager sInst = new LoadLibraryManager();
    }
}
