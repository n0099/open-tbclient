package com.baidu.browser.sailor;

import android.app.Activity;
import android.content.Context;
import android.view.Window;
import android.widget.FrameLayout;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebChromeClient;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class a implements Runnable {
    final /* synthetic */ BdSailorWebView afv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BdSailorWebView bdSailorWebView) {
        this.afv = bdSailorWebView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        WebChromeClient.CustomViewCallback customViewCallback;
        int i;
        WebChromeClient.CustomViewCallback customViewCallback2;
        FrameLayout frameLayout3;
        try {
            Context context = this.afv.getContext();
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                if (this.afv.getCurrentWebView() != null) {
                    this.afv.getCurrentWebView().setVisibility(0);
                }
                this.afv.setFullscreen(activity, false);
                Window window = activity.getWindow();
                if (window == null || (frameLayout = (FrameLayout) window.getDecorView()) == null) {
                    return;
                }
                frameLayout2 = this.afv.mFullscreenContainer;
                if (frameLayout2 != null) {
                    frameLayout3 = this.afv.mFullscreenContainer;
                    frameLayout.removeView(frameLayout3);
                    this.afv.mFullscreenContainer = null;
                }
                this.afv.mCustomView = null;
                customViewCallback = this.afv.mCustomViewCallback;
                if (customViewCallback != null) {
                    customViewCallback2 = this.afv.mCustomViewCallback;
                    customViewCallback2.onCustomViewHidden();
                }
                i = this.afv.mOriginalOrientation;
                activity.setRequestedOrientation(i);
            }
        } catch (Exception e) {
            str = BdSailorWebView.LOG_TAG;
            Log.e(str, "Exception happened when hide custom view");
            e.printStackTrace();
        }
    }
}
