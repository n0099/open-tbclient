package com.baidu.browser.sailor;

import android.app.Activity;
import android.content.Context;
import android.view.Window;
import android.widget.FrameLayout;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebChromeClient;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class l implements Runnable {
    final /* synthetic */ BdSailorWebView VV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(BdSailorWebView bdSailorWebView) {
        this.VV = bdSailorWebView;
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
            Context context = this.VV.getContext();
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                if (this.VV.getCurrentWebView() != null) {
                    this.VV.getCurrentWebView().setVisibility(0);
                }
                this.VV.setFullscreen(activity, false);
                Window window = activity.getWindow();
                if (window == null || (frameLayout = (FrameLayout) window.getDecorView()) == null) {
                    return;
                }
                frameLayout2 = this.VV.mFullscreenContainer;
                if (frameLayout2 != null) {
                    frameLayout3 = this.VV.mFullscreenContainer;
                    frameLayout.removeView(frameLayout3);
                    this.VV.mFullscreenContainer = null;
                }
                this.VV.mCustomView = null;
                customViewCallback = this.VV.mCustomViewCallback;
                if (customViewCallback != null) {
                    customViewCallback2 = this.VV.mCustomViewCallback;
                    customViewCallback2.onCustomViewHidden();
                }
                i = this.VV.mOriginalOrientation;
                activity.setRequestedOrientation(i);
            }
        } catch (Exception e) {
            str = BdSailorWebView.LOG_TAG;
            Log.e(str, "Exception happened when hide custom view");
            e.printStackTrace();
        }
    }
}
