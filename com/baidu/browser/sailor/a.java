package com.baidu.browser.sailor;

import android.app.Activity;
import android.content.Context;
import android.view.Window;
import android.widget.FrameLayout;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebChromeClient;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public final class a implements Runnable {
    final /* synthetic */ BdSailorWebView agr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BdSailorWebView bdSailorWebView) {
        this.agr = bdSailorWebView;
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
            Context context = this.agr.getContext();
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                if (this.agr.getCurrentWebView() != null) {
                    this.agr.getCurrentWebView().setVisibility(0);
                }
                this.agr.setFullscreen(activity, false);
                Window window = activity.getWindow();
                if (window == null || (frameLayout = (FrameLayout) window.getDecorView()) == null) {
                    return;
                }
                frameLayout2 = this.agr.mFullscreenContainer;
                if (frameLayout2 != null) {
                    frameLayout3 = this.agr.mFullscreenContainer;
                    frameLayout.removeView(frameLayout3);
                    this.agr.mFullscreenContainer = null;
                }
                this.agr.mCustomView = null;
                customViewCallback = this.agr.mCustomViewCallback;
                if (customViewCallback != null) {
                    customViewCallback2 = this.agr.mCustomViewCallback;
                    customViewCallback2.onCustomViewHidden();
                }
                i = this.agr.mOriginalOrientation;
                activity.setRequestedOrientation(i);
            }
        } catch (Exception e) {
            str = BdSailorWebView.LOG_TAG;
            Log.e(str, "Exception happened when hide custom view");
            e.printStackTrace();
        }
    }
}
