package com.baidu.mobads.component;
/* loaded from: classes2.dex */
public class a implements IFeedPortraitListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XNativeView f8202a;

    public a(XNativeView xNativeView) {
        this.f8202a = xNativeView;
    }

    @Override // com.baidu.mobads.component.IFeedPortraitListener
    public void playCompletion() {
        INativeVideoListener iNativeVideoListener;
        INativeVideoListener iNativeVideoListener2;
        iNativeVideoListener = this.f8202a.mFeedVideoListener;
        if (iNativeVideoListener != null) {
            iNativeVideoListener2 = this.f8202a.mFeedVideoListener;
            iNativeVideoListener2.onCompletion();
        }
    }

    @Override // com.baidu.mobads.component.IFeedPortraitListener
    public void playError() {
        INativeVideoListener iNativeVideoListener;
        INativeVideoListener iNativeVideoListener2;
        iNativeVideoListener = this.f8202a.mFeedVideoListener;
        if (iNativeVideoListener != null) {
            iNativeVideoListener2 = this.f8202a.mFeedVideoListener;
            iNativeVideoListener2.onError();
        }
    }

    @Override // com.baidu.mobads.component.IFeedPortraitListener
    public void playPause() {
        INativeVideoListener iNativeVideoListener;
        INativeVideoListener iNativeVideoListener2;
        iNativeVideoListener = this.f8202a.mFeedVideoListener;
        if (iNativeVideoListener != null) {
            iNativeVideoListener2 = this.f8202a.mFeedVideoListener;
            iNativeVideoListener2.onPause();
        }
    }

    @Override // com.baidu.mobads.component.IFeedPortraitListener
    public void playRenderingStart() {
        INativeVideoListener iNativeVideoListener;
        INativeVideoListener iNativeVideoListener2;
        XNativeViewManager.getInstance().resetAllPlayer(this.f8202a);
        iNativeVideoListener = this.f8202a.mFeedVideoListener;
        if (iNativeVideoListener != null) {
            iNativeVideoListener2 = this.f8202a.mFeedVideoListener;
            iNativeVideoListener2.onRenderingStart();
        }
    }

    @Override // com.baidu.mobads.component.IFeedPortraitListener
    public void playResume() {
        INativeVideoListener iNativeVideoListener;
        INativeVideoListener iNativeVideoListener2;
        iNativeVideoListener = this.f8202a.mFeedVideoListener;
        if (iNativeVideoListener != null) {
            iNativeVideoListener2 = this.f8202a.mFeedVideoListener;
            iNativeVideoListener2.onResume();
        }
    }
}
