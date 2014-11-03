package com.baidu.tbadk.browser;

import android.text.TextUtils;
import android.webkit.DownloadListener;
import android.webkit.MimeTypeMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements DownloadListener {
    final /* synthetic */ WebTbActivity xR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(WebTbActivity webTbActivity) {
        this.xR = webTbActivity;
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        String aR;
        if (!TextUtils.isEmpty(str)) {
            String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(str4);
            if (TextUtils.isEmpty(extensionFromMimeType) || !extensionFromMimeType.equalsIgnoreCase("apk")) {
                return;
            }
            aR = this.xR.aR(str);
            if (TextUtils.isEmpty(aR)) {
                aR = String.valueOf(System.currentTimeMillis()) + ".apk";
            }
            com.baidu.tbadk.download.b.rj().a(aR, str, aR, 0);
        }
    }
}
