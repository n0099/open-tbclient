package com.baidu.browser.sailor;

import android.content.Context;
import android.net.http.SslError;
import com.baidu.browser.core.INoProGuard;
import com.baidu.webkit.sdk.WebKitClient;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes5.dex */
public class BdSailorClient extends WebKitClient implements INoProGuard, ISailorUrlPushService, com.baidu.browser.sailor.platform.b.b {

    /* loaded from: classes5.dex */
    public enum DownloadTaskType {
        ZEUS,
        BROWSER
    }

    /* loaded from: classes5.dex */
    public interface IDownloadTaskListener extends INoProGuard {
        void onDownloadCancel(String str, long j, long j2, String str2);

        void onDownloadFail(String str, long j, String str2, String str3);

        void onDownloadPause(String str, long j, long j2, String str2);

        void onDownloadStart(String str, long j, String str2);

        void onDownloadSuccess(String str, String str2, long j);

        void onDownloading(String str, long j, long j2);
    }

    public void checkErrorPageWifiBtnShow(WebView webView) {
    }

    public String getApplicationVersion() {
        return "";
    }

    public String getErrorPageInfo(Context context, int i, String str, String str2, String str3) {
        return null;
    }

    public String getErrpgSearchUrl(Context context) {
        return null;
    }

    @Override // com.baidu.webkit.sdk.WebKitClient
    public String getLocationInfo() {
        return null;
    }

    public String getProcessedUrl(String str) {
        return str;
    }

    public String getSslErrorInfo(Context context, SslError sslError) {
        return null;
    }

    @Override // com.baidu.browser.sailor.ISailorUrlPushService
    public boolean getSwitchByKey(String str) {
        return false;
    }

    @Override // com.baidu.browser.sailor.ISailorUrlPushService
    public String getUrl(String str) {
        return null;
    }

    public void invokeWifiPlugin() {
    }

    @Override // com.baidu.browser.sailor.ISailorUrlPushService
    public boolean isNeedUpdate(String str) {
        return false;
    }

    public void onAddToLauncher(String str) {
    }

    public boolean onDownloadTask(String str, String str2, String str3, String str4, DownloadTaskType downloadTaskType, IDownloadTaskListener iDownloadTaskListener) {
        return false;
    }

    public void onGetABTestPolicy(String str, String str2) {
    }

    public void onSailorStatistics(String str, String str2) {
    }

    public void onShareWebPage(String str, String str2) {
    }

    public void onShouldInsertToHistory(String str, String str2) {
    }

    @Override // com.baidu.webkit.sdk.WebKitClient
    public boolean onStartLocation() {
        return false;
    }

    @Override // com.baidu.webkit.sdk.WebKitClient
    public void onStopLocation() {
    }

    public void statWifiErrorPageShow() {
    }

    @Override // com.baidu.browser.sailor.ISailorUrlPushService
    public void updateFingerprint(String str, String str2) {
    }

    public void updateSearchUrlProtocol(Context context, boolean z) {
    }
}
