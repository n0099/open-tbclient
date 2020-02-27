package com.baidu.live.tbadk.load.library;
/* loaded from: classes3.dex */
public class LoadLibraryManager {
    private ILoadLibraryCallback mCallback;
    private IFaceUnityCallBack mFaceUnityCallBack;

    public static LoadLibraryManager getInstance() {
        return InstanceHolder.sInst;
    }

    public void init(ILoadLibraryCallback iLoadLibraryCallback) {
        this.mCallback = iLoadLibraryCallback;
    }

    public void setFaceUnityCallBack(IFaceUnityCallBack iFaceUnityCallBack) {
        this.mFaceUnityCallBack = iFaceUnityCallBack;
    }

    public ILoadLibraryCallback getLoadLibraryCallback() {
        return this.mCallback;
    }

    public IFaceUnityCallBack getFaceUnityCallBack() {
        return this.mFaceUnityCallBack;
    }

    /* loaded from: classes3.dex */
    public static class InstanceHolder {
        private static final LoadLibraryManager sInst = new LoadLibraryManager();
    }
}
