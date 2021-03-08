package com.baidu.mobads.component;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class a implements IFeedPortraitListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XNativeView f2369a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(XNativeView xNativeView) {
        this.f2369a = xNativeView;
    }

    @Override // com.baidu.mobads.component.IFeedPortraitListener
    public void playCompletion() {
        INativeVideoListener iNativeVideoListener;
        INativeVideoListener iNativeVideoListener2;
        iNativeVideoListener = this.f2369a.mFeedVideoListener;
        if (iNativeVideoListener != null) {
            iNativeVideoListener2 = this.f2369a.mFeedVideoListener;
            iNativeVideoListener2.onCompletion();
        }
    }

    @Override // com.baidu.mobads.component.IFeedPortraitListener
    public void playError() {
        INativeVideoListener iNativeVideoListener;
        INativeVideoListener iNativeVideoListener2;
        iNativeVideoListener = this.f2369a.mFeedVideoListener;
        if (iNativeVideoListener != null) {
            iNativeVideoListener2 = this.f2369a.mFeedVideoListener;
            iNativeVideoListener2.onError();
        }
    }

    @Override // com.baidu.mobads.component.IFeedPortraitListener
    public void playRenderingStart() {
        INativeVideoListener iNativeVideoListener;
        INativeVideoListener iNativeVideoListener2;
        XNativeViewManager.getInstance().resetAllPlayer(this.f2369a);
        iNativeVideoListener = this.f2369a.mFeedVideoListener;
        if (iNativeVideoListener != null) {
            iNativeVideoListener2 = this.f2369a.mFeedVideoListener;
            iNativeVideoListener2.onRenderingStart();
        }
    }

    @Override // com.baidu.mobads.component.IFeedPortraitListener
    public void playPause() {
        INativeVideoListener iNativeVideoListener;
        INativeVideoListener iNativeVideoListener2;
        iNativeVideoListener = this.f2369a.mFeedVideoListener;
        if (iNativeVideoListener != null) {
            iNativeVideoListener2 = this.f2369a.mFeedVideoListener;
            iNativeVideoListener2.onPause();
        }
    }

    @Override // com.baidu.mobads.component.IFeedPortraitListener
    public void playResume() {
        INativeVideoListener iNativeVideoListener;
        INativeVideoListener iNativeVideoListener2;
        iNativeVideoListener = this.f2369a.mFeedVideoListener;
        if (iNativeVideoListener != null) {
            iNativeVideoListener2 = this.f2369a.mFeedVideoListener;
            iNativeVideoListener2.onResume();
        }
    }
}
