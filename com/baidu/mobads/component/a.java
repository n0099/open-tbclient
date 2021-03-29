package com.baidu.mobads.component;
/* loaded from: classes2.dex */
public class a implements IFeedPortraitListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XNativeView f8203a;

    public a(XNativeView xNativeView) {
        this.f8203a = xNativeView;
    }

    @Override // com.baidu.mobads.component.IFeedPortraitListener
    public void playCompletion() {
        INativeVideoListener iNativeVideoListener;
        INativeVideoListener iNativeVideoListener2;
        iNativeVideoListener = this.f8203a.mFeedVideoListener;
        if (iNativeVideoListener != null) {
            iNativeVideoListener2 = this.f8203a.mFeedVideoListener;
            iNativeVideoListener2.onCompletion();
        }
    }

    @Override // com.baidu.mobads.component.IFeedPortraitListener
    public void playError() {
        INativeVideoListener iNativeVideoListener;
        INativeVideoListener iNativeVideoListener2;
        iNativeVideoListener = this.f8203a.mFeedVideoListener;
        if (iNativeVideoListener != null) {
            iNativeVideoListener2 = this.f8203a.mFeedVideoListener;
            iNativeVideoListener2.onError();
        }
    }

    @Override // com.baidu.mobads.component.IFeedPortraitListener
    public void playPause() {
        INativeVideoListener iNativeVideoListener;
        INativeVideoListener iNativeVideoListener2;
        iNativeVideoListener = this.f8203a.mFeedVideoListener;
        if (iNativeVideoListener != null) {
            iNativeVideoListener2 = this.f8203a.mFeedVideoListener;
            iNativeVideoListener2.onPause();
        }
    }

    @Override // com.baidu.mobads.component.IFeedPortraitListener
    public void playRenderingStart() {
        INativeVideoListener iNativeVideoListener;
        INativeVideoListener iNativeVideoListener2;
        XNativeViewManager.getInstance().resetAllPlayer(this.f8203a);
        iNativeVideoListener = this.f8203a.mFeedVideoListener;
        if (iNativeVideoListener != null) {
            iNativeVideoListener2 = this.f8203a.mFeedVideoListener;
            iNativeVideoListener2.onRenderingStart();
        }
    }

    @Override // com.baidu.mobads.component.IFeedPortraitListener
    public void playResume() {
        INativeVideoListener iNativeVideoListener;
        INativeVideoListener iNativeVideoListener2;
        iNativeVideoListener = this.f8203a.mFeedVideoListener;
        if (iNativeVideoListener != null) {
            iNativeVideoListener2 = this.f8203a.mFeedVideoListener;
            iNativeVideoListener2.onResume();
        }
    }
}
