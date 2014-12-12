package com.baidu.tbadk.browser;

import android.text.TextUtils;
import android.webkit.DownloadListener;
import android.webkit.MimeTypeMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements DownloadListener {
    final /* synthetic */ WebTbActivity By;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(WebTbActivity webTbActivity) {
        this.By = webTbActivity;
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        String bI;
        if (!TextUtils.isEmpty(str)) {
            String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(str4);
            if (TextUtils.isEmpty(extensionFromMimeType) || !extensionFromMimeType.equalsIgnoreCase("apk")) {
                return;
            }
            bI = this.By.bI(str);
            if (TextUtils.isEmpty(bI)) {
                bI = String.valueOf(System.currentTimeMillis()) + ".apk";
            }
            com.baidu.tbadk.download.b.uK().a(bI, str, bI, 0, 0);
        }
    }
}
