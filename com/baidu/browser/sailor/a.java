package com.baidu.browser.sailor;

import android.app.Activity;
import android.content.Context;
import android.view.Window;
import android.widget.FrameLayout;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebChromeClient;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public final class a implements Runnable {
    final /* synthetic */ BdSailorWebView afZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BdSailorWebView bdSailorWebView) {
        this.afZ = bdSailorWebView;
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
            Context context = this.afZ.getContext();
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                if (this.afZ.getCurrentWebView() != null) {
                    this.afZ.getCurrentWebView().setVisibility(0);
                }
                this.afZ.setFullscreen(activity, false);
                Window window = activity.getWindow();
                if (window == null || (frameLayout = (FrameLayout) window.getDecorView()) == null) {
                    return;
                }
                frameLayout2 = this.afZ.mFullscreenContainer;
                if (frameLayout2 != null) {
                    frameLayout3 = this.afZ.mFullscreenContainer;
                    frameLayout.removeView(frameLayout3);
                    this.afZ.mFullscreenContainer = null;
                }
                this.afZ.mCustomView = null;
                customViewCallback = this.afZ.mCustomViewCallback;
                if (customViewCallback != null) {
                    customViewCallback2 = this.afZ.mCustomViewCallback;
                    customViewCallback2.onCustomViewHidden();
                }
                i = this.afZ.mOriginalOrientation;
                activity.setRequestedOrientation(i);
            }
        } catch (Exception e) {
            str = BdSailorWebView.LOG_TAG;
            Log.e(str, "Exception happened when hide custom view");
            e.printStackTrace();
        }
    }
}
