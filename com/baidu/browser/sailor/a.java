package com.baidu.browser.sailor;

import android.app.Activity;
import android.content.Context;
import android.view.Window;
import android.widget.FrameLayout;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebChromeClient;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class a implements Runnable {
    final /* synthetic */ BdSailorWebView afp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BdSailorWebView bdSailorWebView) {
        this.afp = bdSailorWebView;
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
            Context context = this.afp.getContext();
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                if (this.afp.getCurrentWebView() != null) {
                    this.afp.getCurrentWebView().setVisibility(0);
                }
                this.afp.setFullscreen(activity, false);
                Window window = activity.getWindow();
                if (window == null || (frameLayout = (FrameLayout) window.getDecorView()) == null) {
                    return;
                }
                frameLayout2 = this.afp.mFullscreenContainer;
                if (frameLayout2 != null) {
                    frameLayout3 = this.afp.mFullscreenContainer;
                    frameLayout.removeView(frameLayout3);
                    this.afp.mFullscreenContainer = null;
                }
                this.afp.mCustomView = null;
                customViewCallback = this.afp.mCustomViewCallback;
                if (customViewCallback != null) {
                    customViewCallback2 = this.afp.mCustomViewCallback;
                    customViewCallback2.onCustomViewHidden();
                }
                i = this.afp.mOriginalOrientation;
                activity.setRequestedOrientation(i);
            }
        } catch (Exception e) {
            str = BdSailorWebView.LOG_TAG;
            Log.e(str, "Exception happened when hide custom view");
            e.printStackTrace();
        }
    }
}
