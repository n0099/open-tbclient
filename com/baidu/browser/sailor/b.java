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
    final /* synthetic */ BdSailorWebView acA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdSailorWebView bdSailorWebView) {
        this.acA = bdSailorWebView;
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
            Context context = this.acA.getContext();
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                if (this.acA.getCurrentWebView() != null) {
                    this.acA.getCurrentWebView().setVisibility(0);
                }
                this.acA.setFullscreen(activity, false);
                Window window = activity.getWindow();
                if (window == null || (frameLayout = (FrameLayout) window.getDecorView()) == null) {
                    return;
                }
                frameLayout2 = this.acA.mFullscreenContainer;
                if (frameLayout2 != null) {
                    frameLayout3 = this.acA.mFullscreenContainer;
                    frameLayout.removeView(frameLayout3);
                    this.acA.mFullscreenContainer = null;
                }
                this.acA.mCustomView = null;
                customViewCallback = this.acA.mCustomViewCallback;
                if (customViewCallback != null) {
                    customViewCallback2 = this.acA.mCustomViewCallback;
                    customViewCallback2.onCustomViewHidden();
                }
                i = this.acA.mOriginalOrientation;
                activity.setRequestedOrientation(i);
            }
        } catch (Exception e) {
            str = BdSailorWebView.LOG_TAG;
            Log.e(str, "Exception happened when hide custom view");
            e.printStackTrace();
        }
    }
}
