package com.baidu.browser.sailor;

import android.content.Context;
import com.baidu.webkit.sdk.WebKitClient;
/* loaded from: classes2.dex */
public class BdSailorClient extends WebKitClient {

    /* loaded from: classes2.dex */
    public enum DownloadTaskType {
        ZEUS,
        BROWSER
    }

    /* loaded from: classes2.dex */
    public interface a {
    }

    public boolean a(String str, String str2, String str3, String str4, DownloadTaskType downloadTaskType, a aVar) {
        return false;
    }

    @Override // com.baidu.webkit.sdk.WebKitClient
    public String getLocationInfo() {
        return null;
    }

    public void i(Context context, boolean z) {
    }

    @Override // com.baidu.webkit.sdk.WebKitClient
    public boolean onStartLocation() {
        return false;
    }

    @Override // com.baidu.webkit.sdk.WebKitClient
    public void onStopLocation() {
    }
}
