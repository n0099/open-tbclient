package com.baidu.browser.sailor;

import android.app.Activity;
import android.content.Context;
import android.view.Window;
import android.widget.FrameLayout;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebChromeClient;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class b implements Runnable {
    final /* synthetic */ BdSailorWebView adf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdSailorWebView bdSailorWebView) {
        this.adf = bdSailorWebView;
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
            Context context = this.adf.getContext();
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                if (this.adf.getCurrentWebView() != null) {
                    this.adf.getCurrentWebView().setVisibility(0);
                }
                this.adf.setFullscreen(activity, false);
                Window window = activity.getWindow();
                if (window == null || (frameLayout = (FrameLayout) window.getDecorView()) == null) {
                    return;
                }
                frameLayout2 = this.adf.mFullscreenContainer;
                if (frameLayout2 != null) {
                    frameLayout3 = this.adf.mFullscreenContainer;
                    frameLayout.removeView(frameLayout3);
                    this.adf.mFullscreenContainer = null;
                }
                this.adf.mCustomView = null;
                customViewCallback = this.adf.mCustomViewCallback;
                if (customViewCallback != null) {
                    customViewCallback2 = this.adf.mCustomViewCallback;
                    customViewCallback2.onCustomViewHidden();
                }
                i = this.adf.mOriginalOrientation;
                activity.setRequestedOrientation(i);
            }
        } catch (Exception e) {
            str = BdSailorWebView.LOG_TAG;
            Log.e(str, "Exception happened when hide custom view");
            e.printStackTrace();
        }
    }
}
