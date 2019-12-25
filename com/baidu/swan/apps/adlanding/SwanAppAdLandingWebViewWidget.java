package com.baidu.swan.apps.adlanding;

import android.content.Context;
import android.util.Log;
import com.baidu.browser.sailor.ISailorDownloadListener;
import com.baidu.swan.apps.view.SwanAppSimpleH5Widget;
/* loaded from: classes9.dex */
public class SwanAppAdLandingWebViewWidget extends SwanAppSimpleH5Widget {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public SwanAppAdLandingWebViewWidget(Context context) {
        super(context);
        this.bhc.setDownloadListener(new DownloadListener());
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String Gd() {
        return "ai_apps_ad_landing";
    }

    /* loaded from: classes9.dex */
    class DownloadListener implements ISailorDownloadListener {
        DownloadListener() {
        }

        @Override // com.baidu.browser.sailor.ISailorDownloadListener
        public void onPlayVideo(String str) {
        }

        @Override // com.baidu.browser.sailor.ISailorDownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            if (SwanAppAdLandingWebViewWidget.DEBUG) {
                Log.d("SwanAppAdLandingWVWidget", "onDownloadStart: url=" + str + ", userAgent=" + str2 + ", mimeType=" + str4);
            }
            com.baidu.swan.apps.adlanding.download.model.a aVar = new com.baidu.swan.apps.adlanding.download.model.a(str, "");
            aVar.userAgent = str2;
            aVar.contentDisposition = str3;
            aVar.mimeType = str4;
            aVar.contentLength = j;
            com.baidu.swan.apps.w.a.Ru().h(SwanAppAdLandingWebViewWidget.this.mContext, aVar.Gu());
        }

        @Override // com.baidu.browser.sailor.ISailorDownloadListener
        public void onDownloadFlash(String str) {
        }
    }
}
