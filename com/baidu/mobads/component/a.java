package com.baidu.mobads.component;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class a implements IFeedPortraitListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XNativeView f3311a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(XNativeView xNativeView) {
        this.f3311a = xNativeView;
    }

    @Override // com.baidu.mobads.component.IFeedPortraitListener
    public void playCompletion() {
        INativeVideoListener iNativeVideoListener;
        INativeVideoListener iNativeVideoListener2;
        iNativeVideoListener = this.f3311a.mFeedVideoListener;
        if (iNativeVideoListener != null) {
            iNativeVideoListener2 = this.f3311a.mFeedVideoListener;
            iNativeVideoListener2.onCompletion();
        }
    }

    @Override // com.baidu.mobads.component.IFeedPortraitListener
    public void playError() {
        INativeVideoListener iNativeVideoListener;
        INativeVideoListener iNativeVideoListener2;
        iNativeVideoListener = this.f3311a.mFeedVideoListener;
        if (iNativeVideoListener != null) {
            iNativeVideoListener2 = this.f3311a.mFeedVideoListener;
            iNativeVideoListener2.onError();
        }
    }

    @Override // com.baidu.mobads.component.IFeedPortraitListener
    public void playRenderingStart() {
        INativeVideoListener iNativeVideoListener;
        INativeVideoListener iNativeVideoListener2;
        XNativeViewManager.getInstance().resetAllPlayer(this.f3311a);
        iNativeVideoListener = this.f3311a.mFeedVideoListener;
        if (iNativeVideoListener != null) {
            iNativeVideoListener2 = this.f3311a.mFeedVideoListener;
            iNativeVideoListener2.onRenderingStart();
        }
    }

    @Override // com.baidu.mobads.component.IFeedPortraitListener
    public void playPause() {
        INativeVideoListener iNativeVideoListener;
        INativeVideoListener iNativeVideoListener2;
        iNativeVideoListener = this.f3311a.mFeedVideoListener;
        if (iNativeVideoListener != null) {
            iNativeVideoListener2 = this.f3311a.mFeedVideoListener;
            iNativeVideoListener2.onPause();
        }
    }

    @Override // com.baidu.mobads.component.IFeedPortraitListener
    public void playResume() {
        INativeVideoListener iNativeVideoListener;
        INativeVideoListener iNativeVideoListener2;
        iNativeVideoListener = this.f3311a.mFeedVideoListener;
        if (iNativeVideoListener != null) {
            iNativeVideoListener2 = this.f3311a.mFeedVideoListener;
            iNativeVideoListener2.onResume();
        }
    }
}
